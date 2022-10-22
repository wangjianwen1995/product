package com.sxdl.cf.service;

import com.sxdl.cf.config.CFRunner;
import com.sxdl.cf.dao.dao1.*;
import com.sxdl.cf.dto.FormDataDBO;
import com.sxdl.cf.dto.QueryDBO;
import com.sxdl.cf.entity.SysCustomerFormFactTableEntity;
import com.sxdl.cf.entity.SysCustomerFormFieldTableEntity;
import com.sxdl.cf.entity.SysCustomerFormHeaderColumnEntity;
import com.sxdl.cf.entity.SysCustomerFormHistoryToexamineEntity;
import com.sxdl.cf.service.base.BaseUUIDServiceImpl;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.ResultUtil;
import com.sxdl.cf.util.SplitUtils;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class SysCustomerFormHeaderColumnService extends BaseUUIDServiceImpl<SysCustomerFormHeaderColumnEntity> {


    public static final String LineBreak = "\r\n";
    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private final SysCustomerFormHeaderColumnDao columnDao;
    private final SysCustomerFormFieldTableDao fieldTableDao;
    private final SysCustomerFormFactTableDao factTableDao;

    private final SysCustomerFormProcessStepDao processStepDao;
    private final SysCustomerFormHistoryToexamineDao historyToexamineDao;

    public List<SysCustomerFormHeaderColumnEntity> getTargetList(Object pid, Object val) {
        return columnDao.getTargetList(convert(pid,String.class),convert(val,String.class));
    }

    public List<SysCustomerFormHeaderColumnEntity> getColumnbyPid(String pid) {
        return columnDao.getTargetList(pid,"");
    }

    public List<SysCustomerFormHeaderColumnEntity> getoptionsList(String pid) {
        return columnDao.getoptionsList(pid );
    }



    public List<LinkedHashMap<String, Object>> getDataLinkedMap(String sql) {
        return columnDao.getLinkedMap(sql);
    }



    /**
     * 拼接查询数据  同时 查询条件中的数据
     * @param table_id
     * @param onableRole 0没有权限 1科室权限  2 人员权限
     * @return
     */
    public String getListQueryText( String table_id, Map<String,Object> map,String table_name,String ks_role,String user_role,List<QueryDBO> queryDBOS ,Integer onableRole) {
        //处理select 的sql
        List<SysCustomerFormHeaderColumnEntity> list = getColumnbyPid(table_id );
        StringBuffer sb = new StringBuffer(" select ");
        list.forEach(e->{
            sb.append(" ["+e.getProp()+"] ,");
        });
        //key 添加上审核需要的数据
        sb.append(" toexamine_process,toexamine_step ,   toexamine_branchs ,toexamine_result,toexamine_currentusers,toexamine_currentnames  ");
        // 处理where 的sql
        sb.append(" from "+table_name+" where 1=1 ");

        //ks_role 各个平台需要传入|科室1|科室2|,保证每一个科室数据前后都有|符号
        if (!StringUtils.isEmpty(ks_role) && 1==onableRole){
            sb.append(" and CHARINDEX( '|'+isnull(owner_department,'')+'|','"+ks_role+"') >0 ");
        }
        //user_role 各个平台需要传入|人员1|人员2|,保证每一个人员数据前后都有|符号
        if (!StringUtils.isEmpty(user_role)&& 2==onableRole){
            sb.append(" and (CHARINDEX( '|"+user_role+"|',owner_user) >0  or created_user='"+user_role+"') ");
        }

        //流程查询
        if(map.containsKey("toexamine_result")){
            sb.append(" and toexamine_result='"+map.get("toexamine_result")+"' ");
        }

        /**
         *  key 1 整数 2 小数 3 文本 4 大文本 5 单选下拉框(option/sql) 6 多选下拉框(options/sqls)
         *       7 日期(yyyy-MM-dd) 8 日期时间(yyyy-MM-dd HH:mm:ss)
         *          9 年份(yyyy) 10 年月(yyyy-MM) 11 时间(HH:mm:ss)
         *
         *
         */
        map.forEach((k,v)->{
            String type = columnDao.getTypebyPidAndName(table_id, k);
            if(!StringUtils.isEmpty(v)){
                if("1".equals(type)||"2".equals(type)){
                    sb.append(" and ["+k+"] = "+v+" ");
                }else if("3".equals(type) ||"4".equals(type)){
                    sb.append(" and ["+k+"] like '%"+v+"%' ");
                }else if("option".equals(type) ||"sql".equals(type) || "radio".equals(type) ||"options".equals(type) ||"sqls".equals(type) || "checkbox".equals(type)){ //5
                    //key 查询时会是多选情况,在java 中处理数据
                    queryDBOS.add(new QueryDBO().setType(type).setColumn(k).setVal(v.toString()));
                } else if("7".equals(type)||"8".equals(type)||"11".equals(type)){


                    String[] split = v.toString().split(",");
                    if(split.length==2){
                        sb.append(" and ["+k+"] between '"+split[0]+"' and '"+split[1]+"'");
                    }
                }else if("9".equals(type)||"10".equals(type)){
                    sb.append(" and ["+k+"] = '"+v+"' ");
                }
            }
        });


        sb.append(" order by created_time desc ,id desc ");
        return sb.toString();
    }

    /**
     *  key 表单打印时  单选下拉 字典sql都 换成字符串中文
     *                多选下拉 字典sql都换成字符串中文中逗号隔开
     *                多选框   换成集合
     *  单条数据下拉框字段转译
     * @param table_id
     * @param e  数据库中的列表数据
     * @return
     */
    public void setCodeZHPrint(String table_id , LinkedHashMap<String, Object> e) {
        //需要转译的下拉框字段
        List<SysCustomerFormHeaderColumnEntity> list = getoptionsList(table_id);
        //字典数据
        Map<Integer, Map<String, String>>  map = CFRunner.CFIOC;
        list.forEach(l->{ // l->一个下拉框字段属性信息
            if(e.containsKey(l.getProp()) && !StringUtils.isEmpty(e.get(l.getProp()))){

                if("option".equals(l.getType())){
                    String s = map.get(Integer.valueOf(l.getType_content())).get(e.get(l.getProp()).toString());
                    e.put(l.getProp(),s);
                }else if("sql".equals(l.getType())){
                    Map<String, String> collect = columnDao.getLinkedMap(l.getType_content()).stream().filter(f -> !StringUtils.isEmpty(f.get("val")))
                            .collect(Collectors.toMap(e1 -> e1.get("val").toString(), e2 -> e2.get("name").toString()));
                    e.put(l.getProp(),collect.get(e.get(l.getProp()).toString()));
                }

                //key 多选列表回显数据
                if("options".equals(l.getType())){
                    //该字典数据组
                    Map<String, String> dictMap = map.get(Integer.valueOf(l.getType_content()));
                    String valueStrData = e.get(l.getProp()).toString();
                    List<String> jsonArray = Arrays.asList(valueStrData.split(","));
                    StringBuilder sb = new StringBuilder();
                    if(jsonArray.size()>0){
                        jsonArray.forEach(j->{
                            sb.append(dictMap.get(j)).append(",");
                        });
                        sb.deleteCharAt(sb.length()-1);
                        e.put(l.getProp(),sb.toString());
                    }
                }else if("sqls".equals(l.getType())){
                    Map<String, String> dictMap = columnDao.getLinkedMap(l.getType_content()).stream().filter(f -> !StringUtils.isEmpty(f.get("val")))
                            .collect(Collectors.toMap(e1 -> e1.get("val").toString(), e2 -> e2.get("name").toString()));

                    String valueStrData = e.get(l.getProp()).toString();
                    List<String> jsonArray = Arrays.asList(valueStrData.split(","));

                    StringBuilder sb = new StringBuilder();
                    if(jsonArray.size()>0){
                        jsonArray.forEach(j->{
                            sb.append(dictMap.get(j)).append(",");
                        });
                        sb.deleteCharAt(sb.length()-1);
                        e.put(l.getProp(),sb.toString());
                    }

                }/*else if("checkbox".equals(l.getType())){

                    String valueStrData = e.get(l.getProp()).toString();
                    List<String> jsonArray = Arrays.asList(valueStrData.split(","));
                    e.put(l.getProp(),jsonArray);
                }else if("radio".equals(l.getType())){
                    e.put(l.getProp(),e.get(l.getProp()).toString());
                }*/

            }
        });


    }




    /**
     *  key 多选下拉框 的核心查询方法
     * @param queryDBOS
     * @param sqlData
     * @return
     */
    public List<LinkedHashMap<String, Object>> getQueryCore(List<QueryDBO> queryDBOS, List<LinkedHashMap<String, Object>> sqlData) {
        if(sqlData.size()>0 && queryDBOS.size()>0){
            AtomicReference<Stream<LinkedHashMap<String, Object>>> atomic = new AtomicReference();
            queryDBOS.forEach(e->{
                String column = e.getColumn();
                String val = e.getVal();
                List<LinkedHashMap<String, Object>> streamToList = null;

                //将查询好的stream 流转换成集合,第一次使用数据库查询出的数据,其他使用atomic中已经筛选的流 ,应该条件是and 的
                if(StringUtils.isEmpty(atomic.get())){
                    streamToList = sqlData;
                }else{
                    streamToList = atomic.get().collect(Collectors.toList());
                }
                //下拉框选中的数据
                String[] split = e.getVal().split(",");

                //用来存储 查询 split 每一个结果集,这里其实就是 or 的筛选

                Stream<LinkedHashMap<String, Object>>[] streamArray = new Stream[split.length];
                for (int i = 0; i < split.length; i++) {
                    String s = split[i];
                    Stream<LinkedHashMap<String, Object>> stream = streamToList.stream().filter(f -> !StringUtils.isEmpty(f.get(column)) && Arrays.asList(f.get(column).toString().split(",")).contains(s));
                    streamArray[i] = stream;

                }
                //将上面 or 流 合并 里面会有重复值,需要后续 distinct
                Stream<LinkedHashMap<String, Object>> objStream = Stream.of(streamArray).
                        flatMap(integerStream -> integerStream);

                atomic.set(objStream);
                //System.out.println(objStream.collect(Collectors.toList()));
            });
            List<LinkedHashMap<String, Object>> collect = atomic.get().distinct().collect(Collectors.toList());
            return collect;
        }else{
            return sqlData;
        }

    }


    /** 1
     * 全部数据下拉框字段转译
     *
     * @param table_id
     * @param dataList  数据库中的列表数据
     * @return
     */
    public  List setCodeZH(String table_id , List<LinkedHashMap<String,Object>> dataList) {
        //需要转译的下拉框字段
        List<SysCustomerFormHeaderColumnEntity> list = getoptionsList(table_id);
        //字典数据
        Map<Integer, Map<String, String>>  map = CFRunner.CFIOC;
        dataList.forEach( e->{ //e -> 数据库一个表单数据
            list.forEach(l->{ // l->一个下拉框字段属性信息
                if(e.containsKey(l.getProp()) && !StringUtils.isEmpty(e.get(l.getProp()))){
                    if("option".equals(l.getType()) ||"radio".equals(l.getType())){
                        e.put(l.getProp(),map.get(Integer.valueOf(l.getType_content())).get(e.get(l.getProp()).toString()));
                    }

                    if("sql".equals(l.getType())){
                        Map<String, String> collect = columnDao.getLinkedMap(l.getType_content()).stream().filter(f -> !StringUtils.isEmpty(f.get("val")))
                                .collect(Collectors.toMap(e1 -> e1.get("val").toString(), e2 -> e2.get("name").toString()));
                        e.put(l.getProp(),collect.get(e.get(l.getProp()).toString()));
                    }
                    //key 多选列表回显数据
                    if("options".equals(l.getType()) || "checkbox".equals(l.getType())){
                        //该字典数据组
                        Map<String, String> dictMap = map.get(Integer.valueOf(l.getType_content()));
                        String valueStrData = e.get(l.getProp()).toString();

                        List<String> jsonArray = Arrays.asList(valueStrData.split(","));
                        StringBuilder sb = new StringBuilder();
                        if(jsonArray.size()>0){
                            jsonArray.forEach(j->{
                                sb.append(dictMap.get(j)).append(",");
                            });
                            sb.deleteCharAt(sb.length()-1);
                            e.put(l.getProp(),sb.toString());
                        }

                    }

                    if("sqls".equals(l.getType())){
                        Map<String, String> dictMap = columnDao.getLinkedMap(l.getType_content()).stream().filter(f -> !StringUtils.isEmpty(f.get("val")))
                                .collect(Collectors.toMap(e1 -> e1.get("val").toString(), e2 -> e2.get("name").toString()));
                        String valueStrData = e.get(l.getProp()).toString();
                        List<String> jsonArray = Arrays.asList(valueStrData.split(","));

                        StringBuilder sb = new StringBuilder();
                        if(jsonArray.size()>0){
                            jsonArray.forEach(j->{
                                sb.append(dictMap.get(j)).append(",");
                            });
                            sb.deleteCharAt(sb.length()-1);
                            e.put(l.getProp(),sb.toString());
                        }

                    }
                }
            });
        });
        return dataList;
    }


    /**
     * key 1 这里数据前端不给id
     *     2 科室权限,所属科室直接保存(owner_department)
     *     3 上级领导,要求数据|领导1|领导2|...(owner_user)
     * @param table_id
     * @param table_name
     * @param update_data_id  修改时候根据此id 查询修改哪一条数据
     * @param operation_type 1 新增 2 修改
     * @param formDataDBO
     */

    public void saveRecord(String table_id, String table_name, String update_data_id, Integer operation_type, FormDataDBO formDataDBO) {

        if(operation_type==1){ //key 数据新增

            Map<String, Object> parentData = formDataDBO.getParentData();

            StringBuilder insert = new StringBuilder(" declare @tb_id table(ID uniqueidentifier) INSERT INTO ["+table_name+"] (  ");
            StringBuilder values = new StringBuilder(" ) OUTPUT INSERTED.id INTO @tb_id VALUES (  ");
            parentData.forEach((k,v)->{
                if(null!=v && (!k.equals("id")) && (!k.equals("created_time"))){
                    insert.append(" [").append(k).append("],");
                    values.append(" '").append(v).append("',");
                }

            });
            insert.deleteCharAt(insert.length()-1);
            values.deleteCharAt(values.length()-1);
            values.append(")");
            insert.append(values).append(" select ID from @tb_id ");

            String inertData_id = columnDao.insertBackId(insert.toString());

            // key 代表有many 类型的子表单  maintable_id 后端赋值
            if(formDataDBO.getChildManyData().size()>0){
                Map<String, List<Map<String, Object>>> childManyData = formDataDBO.getChildManyData();
                childManyData.forEach((childManytableName,childDates)->{
                    childDates.forEach( data  -> {
                        StringBuilder insertMany = new StringBuilder(" INSERT INTO ["+childManytableName+"] ( [maintable_id]  ,");
                        StringBuilder valuesMany = new StringBuilder(" ) VALUES ( '"+inertData_id+"',");
                        data.forEach((k,v)->{
                            //key 上面SQL中有什么字段 ,这里排除什么字段
                            if(null!=v && (!k.equals("id"))  && (!k.equals("maintable_id")) && (!k.equals("created_time")) && (!k.equals("order_number"))  ){
                                insertMany.append(" [").append(k).append("],");
                                valuesMany.append(" '").append(v).append("',");
                            }
                        });
                        insertMany.deleteCharAt(insertMany.length()-1);
                        valuesMany.deleteCharAt(valuesMany.length()-1);
                        valuesMany.append(")");
                        insertMany.append(valuesMany);
                        columnDao.insertBySql(insertMany.toString());
                    });
                });
            }
            //key 代表有one 类型的子表单
            if(formDataDBO.getParentData().size()>0){
                Map<String, Map<String, Object>> childOneData = formDataDBO.getChildOneData();
                childOneData.forEach((childOnetableName,childDate)->{
                    StringBuilder insertOne = new StringBuilder(" INSERT INTO  ["+childOnetableName+"] ( [maintable_id]  ,");
                    StringBuilder valuesOne = new StringBuilder(" ) VALUES ( '"+inertData_id+"', ");
                    childDate.forEach((k,v)->{
                        //key 上面SQL中有什么字段 ,这里排除什么字段
                        if(null!=v && (!k.equals("id")) && (!k.equals("maintable_id"))  && (!k.equals("created_time"))   ){
                            insertOne.append(" [").append(k).append("],");
                            valuesOne.append(" '").append(v).append("',");
                        }
                    });
                    insertOne.deleteCharAt(insertOne.length()-1);
                    valuesOne.deleteCharAt(valuesOne.length()-1);
                    valuesOne.append(")");
                    insertOne.append(valuesOne);
                    columnDao.insertBySql(insertOne.toString());
                });
            }



        }else{  //key 数据修改

           Map<String, Object> parentDatas = formDataDBO.getParentData();
           if(parentDatas.size()>0){
               List<Map<String, Object>> list = SplitUtils.splitMap(parentDatas, 30);
               list.forEach(parentData->{
                   StringBuilder update = new StringBuilder(" UPDATE "+table_name+" SET  ");
                   parentData.forEach((k,v)->{
                       //key 上面SQL中有什么字段 ,这里排除什么字段
                       if(  (!k.equals("id")) && (!k.equals("modified_time")) ){
                           if(null!=v){
                               update.append(" [").append(k).append("]='").append(v).append("',");
                           }else{
                               update.append(" [").append(k).append("]=NULL,");
                           }
                       }
                   });
                   update.deleteCharAt(update.length()-1);
                   update.append(" WHERE ID='"+update_data_id+"'");
                   columnDao.execSqlText(update.toString());

               });
               columnDao.execSqlText(" UPDATE "+table_name+" SET modified_time = CONVERT(VARCHAR(19),GETDATE(),120) WHERE ID='"+update_data_id+"'");

           }


            // key 代表有many 类型的子表单 ,先删除数据 在 添加数据
            if(formDataDBO.getChildManyData().size()>0){
                Map<String, List<Map<String, Object>>> childManyData = formDataDBO.getChildManyData();
                childManyData.forEach((childManytableName,childDates)->{
                    //先删除数据
                    columnDao.deleteBySql(" DELETE FROM "+childManytableName+" WHERE maintable_id = '"+update_data_id+"' ");
                    //添加数据
                    childDates.forEach( data -> {
                        StringBuilder insertMany = new StringBuilder(" INSERT INTO  ["+childManytableName+"] ( [maintable_id] ,[modified_time] ,");
                        StringBuilder valuesMany = new StringBuilder(" ) VALUES ( '"+update_data_id+"',CONVERT(VARCHAR(19),GETDATE(),120), ");
                        data.forEach((k,v)->{
                            //key 上面SQL中有什么字段 ,这里排除什么字段
                            if(null!=v && (!k.equals("id"))   && (!k.equals("maintable_id"))   && (!k.equals("modified_time")) && (!k.equals("order_number"))){
                                insertMany.append(" [").append(k).append("],");
                                valuesMany.append(" '").append(v).append("',");
                            }
                        });
                        insertMany.deleteCharAt(insertMany.length()-1);
                        valuesMany.deleteCharAt(valuesMany.length()-1);
                        valuesMany.append(")");
                        insertMany.append(valuesMany);
                        columnDao.insertBySql(insertMany.toString());
                    });
                });
            }else{
                //key  查询 所有子表 ,根据主表id ,删除所有子表的数据
                SysCustomerFormFactTableEntity reference = new SysCustomerFormFactTableEntity().setMaintable_id(table_id);
                List<SysCustomerFormFactTableEntity> childsToMany = factTableDao.select(reference.setIs_childtable(2));
                childsToMany.forEach(e->{
                    columnDao.deleteBySql(" DELETE FROM "+e.getName()+" WHERE maintable_id = '"+update_data_id+"' ");
                });
            }

            //key 代表有one 类型的子表单
            if(formDataDBO.getChildOneData().size()>0) {
                Map<String, Map<String, Object>> childOneData = formDataDBO.getChildOneData();
                childOneData.forEach((childOnetableName,childDates)->{

                    if(childDates.size()>1){

                        if(!StringUtils.isEmpty(childDates.get("maintable_id"))){ //代表修改数据
                            //拆分字段map
                            List<Map<String, Object>> list = SplitUtils.splitMap(childDates,30);
                            list.forEach(e->{
                                StringBuilder updateOne = new StringBuilder(" UPDATE "+childOnetableName+" SET ");
                                e.forEach((k,v)->{
                                    //key 上面SQL中有什么字段 ,这里排除什么字段
                                    if( (!k.equals("id")) && (!k.equals("modified_time")) && (!k.equals("maintable_id"))){
                                        if(null!=v ){
                                            updateOne.append(" [").append(k).append("]='").append(v).append("',");
                                        }else{
                                            updateOne.append(" [").append(k).append("]=NULL,");
                                        }
                                    }

                                });
                                updateOne.deleteCharAt(updateOne.length()-1);
                                updateOne.append(" WHERE maintable_id='").append(update_data_id).append("'");
                                columnDao.execSqlText(updateOne.toString());
                            });
                            //单独处理修改时间 修改时间
                            columnDao.execSqlText( " UPDATE "+childOnetableName+" SET modified_time = CONVERT(VARCHAR(19),GETDATE(),120)  WHERE maintable_id='"+update_data_id+"'");

                        }else{ //代表新增数据
                            StringBuilder insertOne = new StringBuilder(" INSERT INTO  ["+childOnetableName+"] ( [maintable_id]  ,");
                            StringBuilder valuesOne = new StringBuilder(" ) VALUES ( '"+update_data_id+"', ");
                            childDates.forEach((k,v)->{
                                //key 上面SQL中有什么字段 ,这里排除什么字段
                                if(null!=v && (!k.equals("id")) && (!k.equals("maintable_id"))  && (!k.equals("created_time"))   ){
                                    insertOne.append(" [").append(k).append("],");
                                    valuesOne.append(" '").append(v).append("',");
                                }
                            });
                            insertOne.deleteCharAt(insertOne.length()-1);
                            valuesOne.deleteCharAt(valuesOne.length()-1);
                            valuesOne.append(")");
                            insertOne.append(valuesOne);
                            columnDao.insertBySql(insertOne.toString());
                        }

                    }


                });



            }else{
                // key 查询 所有子表 ,根据主表id ,删除所有子表的数据
                SysCustomerFormFactTableEntity reference = new SysCustomerFormFactTableEntity().setMaintable_id(table_id);
                List<SysCustomerFormFactTableEntity> childsToOne = factTableDao.select(reference.setIs_childtable(1));
                childsToOne.forEach(e->{
                    columnDao.deleteBySql(" DELETE FROM "+e.getName()+" WHERE maintable_id = '"+update_data_id+"' ");
                });
            }
        }

    }


    /**
     *   只允许填写人删除本数据
     *   删除数据时候需要删除流程数据
     *   删除数据时候需要判断有没有子表有子表需要删除子表数据
     * @param table_id
     * @param table_name
     * @param data_id   数据id
     */
    public ResultUtil deleteRecord(String table_id, String table_name, String data_id, String usercode) {

        try {
            //只允许填写人删除本数据
            String code = columnDao.selectString(" SELECT created_user FROM ["+table_name+"]  WHERE [ID]='" + data_id + "'");
            if(StringUtils.isEmpty(code)|| !usercode.equals(code))
                return ResultUtil.error("只有登录用户:["+code+"]才可删除该条数据");

            //删除子表数据
            List<SysCustomerFormFactTableEntity> Childs = factTableDao.select(new SysCustomerFormFactTableEntity().setMaintable_id(table_id));
            List<SysCustomerFormFactTableEntity> OneChilds = Childs.stream().filter(f -> f.getIs_childtable().equals(1)).collect(Collectors.toList());
            OneChilds.forEach(e->{
                columnDao.deleteBySql(" DELETE FROM ["+e.getName()+"] WHERE maintable_id = '"+data_id+"' ");
            });
            List<SysCustomerFormFactTableEntity> ManyChilds = Childs.stream().filter(f -> f.getIs_childtable().equals(2)).collect(Collectors.toList());
            ManyChilds.forEach(e->{
                columnDao.deleteBySql(" DELETE FROM ["+e.getName()+"] WHERE maintable_id = '"+data_id+"' ");
            });

            String sql = " DELETE FROM ["+table_name+"] WHERE [ID] = '"+data_id+"' and created_user ='"+usercode+"'";
            columnDao.deleteBySql(sql);

            // 删除流程历史数据
            int delete = historyToexamineDao.delete(new SysCustomerFormHistoryToexamineEntity().setFormdata_id(data_id).setForm_id(table_id));



        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success();
    }



    public ResultUtil deleteRecordOfOne(  String table_name, String data_id ) {

        try {

            columnDao.deleteBySql(" DELETE FROM ["+table_name+"] WHERE maintable_id = '"+data_id+"' ");

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success();
    }
    public void setFieldName(SysCustomerFormFieldTableEntity fieldEntity, SysCustomerFormHeaderColumnEntity headerEntity) {
        int update = columnDao.updateByPrimaryKeySelective(headerEntity);
        int update1 = fieldTableDao.updateByPrimaryKeySelective(fieldEntity);
    }



}
