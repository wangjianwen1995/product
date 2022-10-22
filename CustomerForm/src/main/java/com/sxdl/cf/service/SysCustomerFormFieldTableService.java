package com.sxdl.cf.service;

import com.sxdl.cf.dao.dao1.SysCustomerFormFieldTableDao;
import com.sxdl.cf.dao.dao1.SysCustomerFormHeaderColumnDao;
import com.sxdl.cf.dto.SqlQueryDBO;
import com.sxdl.cf.entity.SysCustomerFormFieldTableEntity;
import com.sxdl.cf.entity.SysCustomerFormHeaderColumnEntity;
import com.sxdl.cf.service.base.BaseUUIDServiceImpl;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.ResultUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class SysCustomerFormFieldTableService extends BaseUUIDServiceImpl<SysCustomerFormFieldTableEntity> {

    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";
    private final SysCustomerFormFieldTableDao fieldTableDao;

    private final SysCustomerFormHeaderColumnDao columnDao;


    public List<SysCustomerFormFieldTableEntity> getFieldList(String pid, String val) {
        return fieldTableDao.getFieldList(pid,val);
    }

    //添加字段 需要 修改表结构
    public ResultUtil addFieldTable(SysCustomerFormFieldTableEntity fieldEntity) {
        try {
            fieldTableDao.execSqlText(DataUtil.AddSqlText(fieldEntity));
            //存储到数据表中
            int insert = fieldTableDao.insert(fieldEntity);
            //在列表属性中添加数据
            SysCustomerFormHeaderColumnEntity headerEntity = new SysCustomerFormHeaderColumnEntity(
                    fieldEntity.getFacttable_id(),
                    fieldEntity.getName(),
                    fieldEntity.getLabel(),
                    fieldEntity.getOrder_number()
            );
            headerEntity.setIs_system(fieldEntity.getIs_system());
            setHeaderProperty(fieldEntity, headerEntity);
            int insert1 = columnDao.insert( headerEntity);
        }catch (Exception e){
            logger.error(LineBreak+e.getMessage());
            return  ResultUtil.error("字段插入失败: "+e.getMessage());
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    /**
     * 这只 header 属性
     * @param fieldEntity
     * @param o
     */
    public void setHeaderProperty(SysCustomerFormFieldTableEntity fieldEntity, SysCustomerFormHeaderColumnEntity o) {
        o.setType(String.valueOf(fieldEntity.getType()));
        //单选下拉框
        if (5==fieldEntity.getType()   ){
            if(1==fieldEntity.getDictortsql()){ //字典下拉
                o.setType("option");
                o.setType_content(fieldEntity.getData_code());
            }else{ // sql下拉
                o.setType("sql");
                o.setType_content(fieldEntity.getField_sql());
            }
        }

        //多选下拉框
        if (6==fieldEntity.getType() ){
            if(1==fieldEntity.getDictortsql()){ //字典下拉
                o.setType("options");
                o.setType_content(fieldEntity.getData_code());
            }else{ // sql下拉
                o.setType("sqls");
                o.setType_content(fieldEntity.getField_sql());
            }
        }

        //单选框
        if (  14==fieldEntity.getType() && 1==fieldEntity.getDictortsql()  ){
            o.setType("radio");
            o.setType_content(fieldEntity.getData_code());
        }
        //多选框
        if (  15==fieldEntity.getType()&&  1==fieldEntity.getDictortsql() ){
            o.setType("checkbox");
            o.setType_content(fieldEntity.getData_code());

        }
    }

    //添加字段 需要 修改表结构
    public ResultUtil addFieldTables(List<SysCustomerFormFieldTableEntity> list) {
        try {
            list.forEach(this::addFieldTable);
        }catch (Exception e){
            return  ResultUtil.error("字段插入失败: "+e.getMessage());
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    //修改字段 需要判断 字段类型是否改变,若改变需要修改
    public ResultUtil setFieldTable(SysCustomerFormFieldTableEntity fieldTableEntity) {
        try {
            String sqlText = DataUtil.UpdateSqlText(fieldTableEntity);
            fieldTableDao.execSqlText(sqlText);
            int insert = fieldTableDao.updateByPrimaryKey(fieldTableEntity);

            SysCustomerFormHeaderColumnEntity o =columnDao.getbyPidAndName(fieldTableEntity.getFacttable_id(),fieldTableEntity.getName());

            /**
             *   1 整数 2 小数 3 文本 4 大文本 5 单选下拉框 6 多选下拉框 7 日期(yyyy-MM-dd) 8 日期时间(yyyy-MM-dd HH:mm:ss) 9 年份(yyyy) 10 年月(yyyy-MM) 11 时间(HH:mm:ss)
             *
             */
            setHeaderProperty(fieldTableEntity,o);
            int insert1 = columnDao.updateByPrimaryKey(o );

        }catch (Exception e){
            return  ResultUtil.error("由于数据原因非本系统造成,字段修改失败: "+e.getMessage());
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    //修改字段 需要判断 字段类型是否改变,若改变需要修改

    public ResultUtil delFieldTable(SysCustomerFormFieldTableEntity fieldTableEntity) {
        try {
            String sqlText = DataUtil.DelSqlText(fieldTableEntity);
            fieldTableDao.execSqlText(sqlText);
            int insert = fieldTableDao.deleteByPrimaryKey(fieldTableEntity.getId());
            Integer i = columnDao.deletebyPidAndName(fieldTableEntity.getFacttable_id(),fieldTableEntity.getName());

        }catch (Exception e){
            return  ResultUtil.error("由于数据原因非本系统造成,字段删除失败: "+e.getMessage());
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    public List<SysCustomerFormFieldTableEntity> gettargetFields(String resourcesName,String resourcesId, String targetName  ) {
        return fieldTableDao.gettargetFields(resourcesName,resourcesId,targetName);
    }

    public Integer getMaxNum(String facttable_id) {
        return fieldTableDao.getMaxNum(facttable_id);
    }


    public List<LinkedHashMap<String, Object>> getDataBysql(SqlQueryDBO dataDBO) {
        List<LinkedHashMap<String, Object>> result;
        List<LinkedHashMap<String, Object>>  linkedMap = fieldTableDao.getLinkedMap(dataDBO.getSql());
        List<LinkedHashMap<String, Object>> sum = new ArrayList<>();
        if(StringUtils.isNotEmpty(dataDBO.getCode())){
            List<String>  list = Arrays.asList(dataDBO.getCode().split(","));
            if (list.size()>1){
                Stream<LinkedHashMap<String, Object>>[] streamArray = new Stream[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    Stream<LinkedHashMap<String, Object>> stream = linkedMap.stream()
                            .filter(f-> (StringUtils.isNotEmpty(f.get("val").toString()) && (StringUtils.isNotEmpty(f.get("name").toString()))));
                    int finalI = i;
                    Stream<LinkedHashMap<String, Object>> streamDemo = stream.filter(f -> f.get("val").toString().equals(list.get(finalI)) || f.get("name").toString().equals(list.get(finalI)));
                    streamArray[i]=streamDemo;
                }

                Stream<LinkedHashMap<String, Object>> objects1 = Stream.of(streamArray).
                        flatMap(integerStream -> integerStream);
                List<LinkedHashMap<String, Object>> linkedMap2 = objects1.distinct().collect(Collectors.toList());
                sum.addAll(linkedMap2);
            }else{
                List<LinkedHashMap<String, Object>> linkedMap2 = linkedMap.stream().filter(f-> (StringUtils.isNotEmpty(f.get("val").toString()) && f.get("val").toString().equals(dataDBO.getCode()))).collect(Collectors.toList());
                sum.addAll(linkedMap2);
            }
        }

        if(StringUtils.isNotEmpty(dataDBO.getVal()) && StringUtils.isNotBlank(dataDBO.getVal())){
            List<String>  list = Arrays.asList(dataDBO.getVal().split(","));
            if (list.size()>1){
                Stream<LinkedHashMap<String, Object>>[] streamArray = new Stream[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    Stream<LinkedHashMap<String, Object>> stream = linkedMap.stream()
                            .filter(f-> (StringUtils.isNotEmpty(f.get("val").toString()) && (StringUtils.isNotEmpty(f.get("name").toString()))));
                    int finalI = i;
                    Stream<LinkedHashMap<String, Object>> streamDemo = stream.filter(f -> f.get("val").toString().contains(list.get(finalI)) || f.get("name").toString().contains(list.get(finalI)));
                    streamArray[i]=streamDemo;
                }

                Stream<LinkedHashMap<String, Object>> objects1 = Stream.of(streamArray).
                        flatMap(integerStream -> integerStream);
                List<LinkedHashMap<String, Object>> linkedMap2 = objects1.distinct().limit(50).collect(Collectors.toList());
                sum.addAll(linkedMap2);
            }else{
                List<LinkedHashMap<String, Object>> linkedMap2 = linkedMap.stream().filter(f-> (StringUtils.isNotEmpty(f.get("val").toString()) && f.get("val").toString().contains(dataDBO.getVal()))|| (StringUtils.isNotEmpty(f.get("name").toString())&&f.get("name").toString().contains(dataDBO.getVal()))).collect(Collectors.toList());
                sum.addAll(linkedMap2);
            }
        }else{
            List<LinkedHashMap<String, Object>> linkedMap2 = linkedMap.stream().filter(f-> (StringUtils.isNotEmpty(f.get("val").toString())  ||  StringUtils.isNotEmpty(f.get("name").toString()) ))
                    .limit(50).collect(Collectors.toList());
            sum.addAll(linkedMap2);
        }
        result = sum.stream().distinct().collect(Collectors.toList());
        return result;
    }

}
