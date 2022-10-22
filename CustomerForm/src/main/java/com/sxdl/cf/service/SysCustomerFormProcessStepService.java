package com.sxdl.cf.service;

import com.sxdl.cf.dao.dao1.SysCustomerFormHistoryToexamineDao;
import com.sxdl.cf.dao.dao1.SysCustomerFormProcessStepDao;
import com.sxdl.cf.dto.CodeNameDBO;
import com.sxdl.cf.dto.ToExamineDBO;
import com.sxdl.cf.entity.SysCustomerFormHistoryToexamineEntity;
import com.sxdl.cf.entity.SysCustomerFormProcessStepEntity;
import com.sxdl.cf.service.base.BaseUUIDServiceImpl;
import com.sxdl.cf.util.BeanUtils;
import com.sxdl.cf.util.GUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SysCustomerFormProcessStepService extends BaseUUIDServiceImpl<SysCustomerFormProcessStepEntity> {



    private final SysCustomerFormProcessStepDao sysProcessStepDao;
    private final SysCustomerFormHistoryToexamineDao historyToexamineDao;



    public Set<CodeNameDBO> getProcess (String formId) {
        return sysProcessStepDao.select(new SysCustomerFormProcessStepEntity().setForm_id(formId))
                .stream().map(m -> new CodeNameDBO()
                        .setCode(m.getProcess_code())
                        .setStateon(m.getStateon())
                        .setExplain(m.getProcess_explain()))
                .sorted(Comparator.comparing(CodeNameDBO::getCode))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }


    //将数据组合成前段赋值时使用的数据  ToExamineDBO
    public Set<ToExamineDBO> getProcessOnable (String formId) {
        List<SysCustomerFormProcessStepEntity> list = sysProcessStepDao.select(new SysCustomerFormProcessStepEntity()
                .setForm_id(formId)
                .setStep_number(1)
                .setStateon(1));

        //筛选出流程的第一步骤集合
        Map<String, List<SysCustomerFormProcessStepEntity>> collect = list.stream()
                .sorted(Comparator.comparing(SysCustomerFormProcessStepEntity::getProcess_code).thenComparing(SysCustomerFormProcessStepEntity::getId))
                .collect(Collectors.groupingBy(SysCustomerFormProcessStepEntity::getProcess_code));

        //将数据组合成前段赋值时使用的数据  ToExamineDBO
        LinkedHashSet<ToExamineDBO> set = collect.entrySet().stream().map(m -> new ToExamineDBO()
                .setToexamine_process(m.getKey())
                .setToexamine_process_explain(m.getValue().get(0).getProcess_explain())
                .setToexamine_step(1)
                .setToexamine_result(0)
                .setToexamine_branchs(m.getValue().stream().map(SysCustomerFormProcessStepEntity::getId).collect(Collectors.joining(",")))
                .setToexamine_currentusers(m.getValue().stream().map(SysCustomerFormProcessStepEntity::getToexamine_users).collect(Collectors.joining(",")))
                .setToexamine_currentnames(m.getValue().stream().map(SysCustomerFormProcessStepEntity::getToexamine_names).collect(Collectors.joining(","))))
                .sorted(Comparator.comparing(ToExamineDBO::getToexamine_process))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        return set;
    }

    /**
     *
     * @param1 formId
     * @param1 process_code
     * @param1 process_explain
     * @param1 stateon
     */
    public   void saveProcess(SysCustomerFormProcessStepEntity stepEntity) {
        if(StringUtils.isEmpty(stepEntity.getProcess_code())){
            int insert = sysProcessStepDao.insert(stepEntity.setProcess_code(GUID.generatecode()) );
        }else{
            List<SysCustomerFormProcessStepEntity> list = sysProcessStepDao.select(new SysCustomerFormProcessStepEntity(stepEntity.getForm_id(), stepEntity.getProcess_code()));
            list.forEach(e->{
                int update = sysProcessStepDao.updateByPrimaryKey( e.setProcess_explain(stepEntity.getProcess_explain()).setStateon(stepEntity.getStateon()) );
             });
        }
    }

    /**
     *  需要的参数
     * @param1 formId
     * @param1 process_code
     * @param1 process_explain
     * @param1 step_code
     * @param1 step_explain
     */
    public   void saveStep(SysCustomerFormProcessStepEntity stepEntity  ) {
        if(StringUtils.isEmpty(stepEntity.getId())){
            int insert = sysProcessStepDao.insert(stepEntity);
        }else{
            List<SysCustomerFormProcessStepEntity> list = sysProcessStepDao.select(
                    new SysCustomerFormProcessStepEntity()
                            .setForm_id(stepEntity.getForm_id())
                            .setProcess_code(stepEntity.getProcess_code())
                            .setStep_number(stepEntity.getStep_number()) ) ;
            list.forEach(e->{
                int update = sysProcessStepDao.updateByPrimaryKey( e.setStep_explain(stepEntity.getStep_explain())  );
            });
        }
    }


    public List<SysCustomerFormProcessStepEntity> getStepByProcessCode(String formId, String processcode) {
        return sysProcessStepDao.select(new SysCustomerFormProcessStepEntity()
                    .setProcess_code(processcode)
                    .setForm_id(formId))
                .stream()
                .sorted(Comparator.comparing(SysCustomerFormProcessStepEntity::getStep_number))
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(
                                SysCustomerFormProcessStepEntity::getStep_number)))
                        , ArrayList::new)
                );


    }




    public List<SysCustomerFormProcessStepEntity> getBranchByStepCode(String formId, Integer stepNumber,String processCode) {
        return sysProcessStepDao.select(new SysCustomerFormProcessStepEntity()
                    .setStep_number(stepNumber)
                    .setForm_id(formId)
                    .setProcess_code(processCode))
                .stream()
                .sorted(Comparator.comparing(SysCustomerFormProcessStepEntity::getId))
                .collect(Collectors.toList());
    }


    public void saveStepNumber(String formId, String processCode, Integer stepNumberOld, Integer stepNumberNew) {
        List<SysCustomerFormProcessStepEntity> list = sysProcessStepDao.select(new SysCustomerFormProcessStepEntity()
                .setForm_id(formId)
                .setProcess_code(processCode) );

        list.stream().filter(f-> f.getStep_number().equals(stepNumberOld)).forEach(e-> {
            try {
                int i = sysProcessStepDao.updateByPrimaryKey( BeanUtils.deepCopyBean(e).setStep_number(stepNumberNew));
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }

        });

        list.stream().filter(f-> f.getStep_number().equals(stepNumberNew)).forEach(e-> {
            try {
                int i = sysProcessStepDao.updateByPrimaryKey(BeanUtils.deepCopyBean(e).setStep_number(stepNumberOld) );
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
        });


    }

    public Integer delBranch(String id, String formId, String processCode, Integer stepNumber) {
        List<SysCustomerFormProcessStepEntity> list = sysProcessStepDao.select(new SysCustomerFormProcessStepEntity()
                .setForm_id(formId)
                .setProcess_code(processCode)
                .setStep_number(stepNumber));

        if(list.size()==1){
            int i = sysProcessStepDao.deleteByPrimaryKey(id);
            //修改序号
            Integer integer = sysProcessStepDao.updateSql(" update sys_cf_processstep set step_number = step_number-1 " +
                                        " where form_id='"+formId+"' and process_code='"+processCode+"' and step_number > "+stepNumber);
        }else{
            int i = sysProcessStepDao.deleteByPrimaryKey(id);
        }
        return null;
    }

    public void saveBranch(SysCustomerFormProcessStepEntity stepEntity) {
        if(StringUtils.isEmpty(stepEntity.getId())){
            int insert = sysProcessStepDao.insert(stepEntity);
        }else{
            int update = sysProcessStepDao.updateByPrimaryKeySelective(
                    new SysCustomerFormProcessStepEntity()
                    .setId(stepEntity.getId())
                    .setBranch_explain(stepEntity.getBranch_explain()));
        }
    }

    /**
     *  获取组装流程数据(初步)
     * @param formDataId
     * @param formId
     * @param processCode
     * @return
     */
    public List<List<SysCustomerFormProcessStepEntity>> getProcessData(  String formDataId,  String formId, String processCode) {
        //先查询所有流程数据
        List<SysCustomerFormProcessStepEntity> steps=  sysProcessStepDao.select(new SysCustomerFormProcessStepEntity().setForm_id(formId).setProcess_code(processCode))
                .stream().sorted(Comparator.comparing(SysCustomerFormProcessStepEntity::getStep_number)
                        .thenComparing(SysCustomerFormProcessStepEntity::getId))
                .collect(Collectors.toList());

        //再查询已经执行的数据
        List<SysCustomerFormHistoryToexamineEntity> historys = historyToexamineDao.select(new SysCustomerFormHistoryToexamineEntity()
                .setFormdata_id(formDataId))
                .stream().sorted(Comparator.comparing(SysCustomerFormHistoryToexamineEntity::getId))
                .collect(Collectors.toList());


        //将历史数据融合到 流程步骤中
        steps.forEach(e->{
            e.setHistoryToexamineEntity(historys.stream()
                    .filter(h->e.getId().equals(h.getToexamine_branch()))
                    .sorted(Comparator.comparing(SysCustomerFormHistoryToexamineEntity::getId).reversed())
                    .findFirst().orElse(null)
            );
        });

        Map<Integer, List<SysCustomerFormProcessStepEntity>> coreMap = steps.stream().collect(Collectors.groupingBy(SysCustomerFormProcessStepEntity::getStep_number));


        return coreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue).collect(Collectors.toList());
    }


    /**
     *  组装前端流程图数据 (完成)
     * @param resultList
     * @param listList
     */
    public void coreMethod(List<Map<String, Object>> resultList, List<List<SysCustomerFormProcessStepEntity>> listList) {
        //标识结束节点clear 属性值是after
        Boolean flag = false;

        //步骤节点数据
        Map<String,Object> startObj = new HashMap<>();
        //步骤节点下的 list 元素数据集合
        List<Map<String,Object>> childstartList = new ArrayList<>();

        // list 元素集合中的一条对象数据
        Map<String,Object> obj = new HashMap<>();
        obj.put("label","开始");   // 区块名称
        obj.put("class_name","");  // 定义区块颜色
        obj.put("width","80px"); // 区块宽度
        obj.put("clear","before");// 分支前是before 分支后是after ,多分支里面不需要
        obj.put("content",null);// 操作过的数据鼠标上浮提示审核说明,审核人名称,审核时间,审核是否通过(上面type来区分), 后面没有操作过的数据提示应该有谁可以审核该数据

        childstartList.add(obj);

        startObj.put("num",1);
        startObj.put("list",childstartList);

        resultList.add(startObj); //最后的结果

        for (int i = 0; i < listList.size(); i++) {
            int size = listList.get(i).size();
            if(size>1)
                flag = true; //标识结束节点clear 属性值是after
            Map<String,Object> centerObj = new HashMap<>();
            //步骤节点下的 list 元素数据集合
            List<Map<String,Object>> childcenterList = new ArrayList<>();


            Boolean finalFlag = flag;
            listList.get(i).forEach(e->{
                // list 元素集合中的一条对象数据
                Map<String,Object> o = new HashMap<>();
                o.put("label",e.getBranch_explain());   // 区块名称
                if(e.getHistoryToexamineEntity()!=null  ){
                    if(e.getHistoryToexamineEntity().getIspass()==1)
                        o.put("class_name","success");  // 定义区块颜色 danger:驳回,info:未开始,success:完成,
                    else if(e.getHistoryToexamineEntity().getIspass()==0)
                        o.put("class_name","danger");  // 定义区块颜色 danger:驳回,info:未开始,success:完成,
                }else{
                    o.put("class_name","info");  // 定义区块颜色
                }
                if(size==1){
                    if(finalFlag)       o.put("clear","after");
                    else                o.put("clear","before");
                }
                o.put("width","105px"); // 区块宽度
                o.put("content",e);// 操作过的数据鼠标上浮提示审核说明,审核人名称,审核时间,审核是否通过(上面type来区分), 后面没有操作过的数据提示应该有谁可以审核该数据
                childcenterList.add(o);
            });

            List<SysCustomerFormProcessStepEntity> lists = listList.get(i);
            centerObj.put("num",lists.size());
            //判断是否需要unset_border 属性 本步骤属于多分支,下一步也是多分支情况下 添加该属性
            if(listList.get(i).size()>1&&  i+2<=listList.size()  ){
                if(listList.get(i+1).size()>1)
                    centerObj.put("unset_border","unset_bottom");
            }
            centerObj.put("list",childcenterList);
            resultList.add(centerObj);
        }
        //步骤节点数据
        Map<String,Object> endObj = new HashMap<>();
        //步骤节点下的 list 元素数据集合
        List<Map<String,Object>> childendList = new ArrayList<>();

        // list 元素集合中的一条对象数据
        Map<String,Object> o = new HashMap<>();
        o.put("label","结束");   // 区块名称
        o.put("class_name","");  // 定义区块颜色
        o.put("width","80px"); // 区块宽度
        o.put("clear","after");
        o.put("content",null);// 操作过的数据鼠标上浮提示审核说明,审核人名称,审核时间,审核是否通过(上面type来区分), 后面没有操作过的数据提示应该有谁可以审核该数据

        childendList.add(o);

        endObj.put("num",1);
        endObj.put("list",childendList);

        resultList.add(endObj); //最后的结果
    }

}
