package com.sxdl.cf.service;

import com.sxdl.cf.dao.dao1.SysCustomerFormHistoryToexamineDao;
import com.sxdl.cf.dao.dao1.SysCustomerFormProcessStepDao;
import com.sxdl.cf.dto.ToExamineDBO;
import com.sxdl.cf.entity.SysCustomerFormFactTableEntity;
import com.sxdl.cf.entity.SysCustomerFormHistoryToexamineEntity;
import com.sxdl.cf.entity.SysCustomerFormProcessStepEntity;
import com.sxdl.cf.service.base.BaseUUIDServiceImpl;
import com.sxdl.cf.util.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SysCustomerFormHistoryToexamineService extends BaseUUIDServiceImpl<SysCustomerFormHistoryToexamineEntity> {
    private ReentrantLock lock = new ReentrantLock();

    private final SysCustomerFormProcessStepDao processStepDao;
    private final SysCustomerFormHistoryToexamineDao historyToexamineDao;


    /***
     *
     * @param toexamineEntity
     * @param tableEntity
     */
    // key toexamine_result 审核结果:  1进行中 9完成 0未开始 -1驳回
    public void executeToexamine(SysCustomerFormHistoryToexamineEntity toexamineEntity, SysCustomerFormFactTableEntity tableEntity) throws Exception {


            String tableName = tableEntity.getName();
            String tableId = tableEntity.getId();
            String formdata_id = toexamineEntity.getFormdata_id();

            //获取表单数据的当前审核流程与步骤



            String process =toexamineEntity.getToexamine_process();
            Integer result = toexamineEntity.getToexamine_result();
            Integer step = toexamineEntity.getToexamine_step();
            String branchs = toexamineEntity.getToexamine_branchs();
            String currentusers = toexamineEntity.getToexamine_currentusers();



            //获取该流程下 所有步骤与分支数据（开启的）
            List<SysCustomerFormProcessStepEntity> list = processStepDao.select(new SysCustomerFormProcessStepEntity()
                    .setForm_id(tableId)
                    .setProcess_code(process)
                    .setStateon(1));


            //根据审核人，筛选出当前审核的流程分支（分支必须是一个）
            List<SysCustomerFormProcessStepEntity> collect = list.stream()
                    .filter(f -> Arrays.asList(f.getToexamine_users().split(","))
                            .contains(toexamineEntity.getToexamine_usercode()) && f.getStep_number().equals(step))
                    .collect(Collectors.toList());

            if(collect.size()>1)
                throw new RuntimeException("报错:"+toexamineEntity.getToexamine_username()+" 审核数据时,检测到同一步骤下多个分支都拥有审核权限，无法判别该用户属于哪类分支");

            if(collect.size()<1)
                throw new RuntimeException("报错:"+toexamineEntity.getToexamine_username()+" 审核数据时,未检测到["+step+"]骤下拥有审核权限的分支");

            String branchId = collect.get(0).getId();

            if(!branchs.contains(branchId))
                throw new RuntimeException("报错:"+toexamineEntity.getToexamine_username()+" 审核数据时,表单数据与流程审核分支数据不符");



        /**
         *  处理多线程情况下并发问题
         *   场景 多个人同时审核一个分支,造成数据读写并发问题, 张三 李四同时审核数据,数据被同时审核或者一个人审核后,又多了一个人等问题
         *  此类中创建一个 map 集合 用来存储 k-->分支id v->审核历史对象
         */



            if(DataUtil.threadMap.containsKey(branchId)){
                SysCustomerFormHistoryToexamineEntity o = (SysCustomerFormHistoryToexamineEntity)DataUtil.threadMap.get(branchId);
                throw new RuntimeException("用户["+o.getToexamine_username()+"] 正在审核中,请稍后再试");
            }

        lock.lock();
        try{
            DataUtil.threadMap.put(branchId,toexamineEntity);
            //先判断是否 已经被其他人操作了 先查询该事实表,走了哪一个分支  如果分支需要操作的分支不包含当前分支说明已经被其它人操作完成
            ToExamineDBO toExamineDBO = historyToexamineDao.getToExamineDBO(tableName, formdata_id);

            if (!Arrays.asList(toExamineDBO.getToexamine_branchs().split(",")).contains(branchId)   ){
                throw new RuntimeException("该数据已经被其它人审核,详情查看流程图");
            }

            toexamineEntity.setToexamine_branch(branchId);

            Integer toexamine_result = toExamineDBO.getToexamine_result();
            if(toexamineEntity.getIspass()==1){//审核 通过继续下一步

                //key 表示之前驳回了是重新开始的一轮审核 将历史审核数据删除
                if(-1==toexamine_result){
                    delHistoryToexamineInfo(formdata_id);//删除 历史审核数据
                }

                //代表 该步骤下 没有有其他分支 直接下一步骤
                if(!branchs.contains(",")){
                    //获取下一步骤流程数据
                    List<SysCustomerFormProcessStepEntity> stepEntities = list.stream()
                            .filter(f -> f.getStep_number().equals(step + 1))
                            .collect(Collectors.toList());
                    if(stepEntities.size()>0){
                        //key stepEntities=1只有一个分支或者 stepEntities>1有多个分支
                        executeToexamineNext(stepEntities  ,tableName,formdata_id,"1");
                    }else{
                        //代表没有其他步骤 直接结束流程
                        executeToexamineLast( tableName,formdata_id);
                    }

                }else {//该步骤下 有其他分支 需要执行
                    //获取同步骤下的其他分支流程
                    List<SysCustomerFormProcessStepEntity> stepEntities = list.stream()
                            .filter(f -> f.getStep_number().equals(step ) && !branchId.equals(f.getId()) )
                            .collect(Collectors.toList());
                    executeToexamineNext(stepEntities  ,tableName,formdata_id,"1");
                }

                //保存历史审核数据
                int insert = historyToexamineDao.insert(toexamineEntity);
            }else{//驳回  需要重新开始新的一轮审核
                //获取审核第一步数据
                List<SysCustomerFormProcessStepEntity> stepEntitys = list.stream()
                        .filter(f->f.getStep_number().equals(1))
                        .collect(Collectors.toList());

                executeToexamineNext(stepEntitys ,tableName,formdata_id,"-1");
                int insert = historyToexamineDao.insert(toexamineEntity);
            }
        }catch (Exception e){
            throw new RuntimeException("并发编程问题:"+e.getMessage());
        }finally{


           // boolean b = DataUtil.threadMap.keySet().removeIf(k -> k.equals(toexamineEntity.getToexamine_branch()));
            lock.unlock();
            if(DataUtil.threadMap.containsKey(branchId)){
                DataUtil.threadMap.remove(branchId);
            }
        }

    }


    /**
     * 删除 历史审核数据
     * @param fromDataId
     */
    private void delHistoryToexamineInfo(String fromDataId) {
          //获取之前的历史数据
            List<SysCustomerFormHistoryToexamineEntity> list = historyToexamineDao.select(new SysCustomerFormHistoryToexamineEntity().setFormdata_id(fromDataId));
            //删除历史数据
            list.forEach(e->{
                int delete = historyToexamineDao.deleteByPrimaryKey(e.getId());
            });
    }

    /**
     *  获取表单数据的当前审核流程与步骤s
     *         toexamine_process       流程代码
     *        toexamine_step          步骤代码
     *        toexamine_branchs       分支代码组
     *        toexamine_result        结果0     ---->0
     *        toexamine_currentusers   当前审核人代码
     *         toexamine_currentnames   当前审核人名称
     *
     * @param tableName
     * @param formdata_id
     * @return
     */
    private LinkedHashMap<String, Object> getFormDataToexamine(String tableName, String formdata_id) {
        String sql = " select   toexamine_process,toexamine_step ,   toexamine_branchs ,toexamine_result,toexamine_currentusers,toexamine_currentnames  from "+tableName+" where id = '"+formdata_id+"'  ";
        return historyToexamineDao.getMap(sql);
    }


    /**
     *  执行下一步 审核流程
     *
     *    toexamine_process       流程代码 流程代码 key 不需要修改,在保存表单数据时候就已经选择后保存
     *   toexamine_step          步骤代码
     *   toexamine_branchs       分支代码组
     *   toexamine_currentusers   当前审核人代码
     *    toexamine_currentnames   当前审核人名称
     *  key toexamine_result 审核结果:  1进行中 9完成 0未开始 -1驳回   0 -1 允许当前操作人员删除修改, 1 9 不能修改删除数据 但是1中当前审核人可以修改数据
     *
     *
     * @param stepEntitys 下一步骤
     * @param tableName  事实表[表单键]
     */
    private void executeToexamineNext(List<SysCustomerFormProcessStepEntity> stepEntitys, String tableName , String fromDataId ,String result) {
        String sql="";
        if(stepEntitys.size()==1){ //只有一个分支
            SysCustomerFormProcessStepEntity stepEntity = stepEntitys.get(0);
            sql = " update "+tableName+" set " +
                    " toexamine_currentusers='"+stepEntity.getToexamine_users()+"'," +
                    " toexamine_currentnames='"+stepEntity.getToexamine_names()+"'," +
                    " toexamine_branchs='"+stepEntity.getId()+"',"+
                    " toexamine_step='"+stepEntity.getStep_number()+"',"+
                    " toexamine_result= "+result+" where id='"+fromDataId+"' ";
        }else{ //有多个分支
            sql = " update "+tableName+" set " +
                    " toexamine_currentusers='"+stepEntitys.stream().map(SysCustomerFormProcessStepEntity::getToexamine_users).collect(Collectors.joining(","))+"'," +
                    " toexamine_currentnames='"+stepEntitys.stream().map(SysCustomerFormProcessStepEntity::getToexamine_names).collect(Collectors.joining(","))+"'," +
                    " toexamine_branchs='"+stepEntitys.stream().map(SysCustomerFormProcessStepEntity::getId).collect(Collectors.joining(","))+"',"+
                    " toexamine_step='"+stepEntitys.get(0).getStep_number()+"',"+
                    " toexamine_result= "+result+" where id='"+fromDataId+"' ";
        }

        //保存表单数据中的审核信息
        historyToexamineDao.execSqlText(sql);
    }





    /**
     *
     *            toexamine_process       流程代码 流程代码 key 不需要修改,在保存表单数据时候就已经选择后保存
     *           toexamine_step          步骤代码
     *           toexamine_branchs       分支代码组
     *           toexamine_result         审核结果:  1进行中 9完成 0未开始 -1驳回
     *           toexamine_currentusers   当前审核人代码
     *            toexamine_currentnames   当前审核人名称
     *  完成审核流程
     * @param tableName  事实表[表单键]
     * key toexamine_result 审核结果:  1进行中 9完成 0未开始 -1驳回   0 -1 允许当前操作人员删除修改, 1 9 不能修改删除数据 但是1中当前审核人可以修改数据
     */
    private void executeToexamineLast( String tableName,String fromDataId) {

        String  sql = " update "+tableName+" set " +
                " toexamine_currentusers=null," +
                " toexamine_currentnames=null," +
                " toexamine_step=null,"+
                " toexamine_branchs=null,"+
                " toexamine_result= 9 where id='"+fromDataId+"' ";
        //保存表单数据中的审核信息
        historyToexamineDao.execSqlText(sql);
    }




}
