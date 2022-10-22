package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.drplus.entity.DrPlusCenterTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.LinkedHashMap;
import java.util.List;

public interface DrPlusCenterTableDao extends BaseDao<DrPlusCenterTable> {


    @Select(" select COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_NAME='${tablename}'")
    List<String> getTableColumns(String tablename);


    @Select("select top 10 COLUMN_NAME from( select COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_NAME='${tablename}' ) a where COLUMN_NAME like '%${val}%'")
    List<String> getTableColumnsByVal(String tablename,String val);

    @Select("select count(1) from drplus_center_table where drplus_platform_detailed_id =${pid} and  name ='${column}'")
    int getColumnsNumByname(Integer pid,String column);



    /**
     *
     * 添加 字段
     * @param table
     * @param name
     * @param column_type
     * @return
     */
    @Update("Alter table ${table} add  ${name}  ${column_type}  null")
    int alterAddColumn(String table, String name, String column_type);


    /**
     *  修改字段类型
     * @param table
     * @param name
     * @param column_type
     * @return
     */
    @Update(" Alter Table  ${table}  ALTER COLUMN  ${name}  ${column_type} ")
    int alterUpdateColumn(String table, String name, String column_type);

    /**
     * 修改 字段名称
     * @param table
     * @param columnOld
     * @param columnNew
     * @return
     */
    @Update(" execute sp_rename '${table}.${columnOld}','${columnNew}'")
    int updateColname(String table,String columnOld, String columnNew);

    @Update(" EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'${name_zh}' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'${tablename}', @level2type=N'COLUMN',@level2name=N'${name}'")
    int execAddExtendedProperty(String name_zh, String tablename, String name);


    @Update(" EXEC sys.sp_updateextendedproperty  @name=N'MS_Description', @value=N'${name_zh}' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'${tablename}', @level2type=N'COLUMN',@level2name=N'${name}'")
    int execUpdateExtendedProperty(String name_zh, String tablename, String name);

    @Delete(" Alter table ${tableName} drop column ${column}")
    int alterDeleteColumn(String tableName,String column);

    @Select(" select * from drplus_center_table " +
            " where drplus_platform_detailed_id = ${pid} and  name  like '%${val1}%' and name_zh like  '%${val2}%' and  isnull(source_column ,'') like  '%${val3}%'")
    List<DrPlusCenterTable> getLikeDateList(Integer pid,String val1,String val2,String val3);
   @Select(" select * from drplus_center_table " +
           " where drplus_platform_detailed_id = ${pid} and  name  like '%${val1}%' and name_zh like  '%${val2}%' and  isnull(source_column ,'')=''")
    List<DrPlusCenterTable> getLikeDateListPlus(Integer pid,String val1,String val2,String val3 );

   @Select(" select * from drplus_center_table " +
          " where drplus_platform_detailed_id = ${pid}  " +
          "      and  name  like '%${val1}%' and name_zh like  '%${val2}%' " +
          "      and  isnull(source_column ,'') like  '%${val3}%'  and (table_type='a' or name!='PRIMAEYKEY' ) ")
    List<DrPlusCenterTable> getLikeDateListAdd(Integer pid,String val1,String val2,String val3 );

   @Select(" select * from drplus_center_table " +
          " where drplus_platform_detailed_id = ${pid}  " +
          "      and  name  like '%${val1}%' and name_zh like  '%${val2}%' " +
          "      and  isnull(source_column ,'') =  ''  and (table_type='a' or name!='PRIMAEYKEY' ) ")
    List<DrPlusCenterTable> getLikeDateListPlusAdd(Integer pid,String val1,String val2,String val3 );

    @Select(" select * from drplus_center_table where drplus_platform_detailed_id = ${pid} and  name  like '%${val1}%' and name_zh like  '%${val2}%' and  isnull(report_column ,'') like  '%${val3}%'")
    List<DrPlusCenterTable> getLikeDateList2(Integer pid,String val1,String val2,String val3);

    @Select(" select * from drplus_center_table where drplus_platform_detailed_id = ${pid} and  name  like '%${val1}%' and name_zh like  '%${val2}%' and  isnull(report_column ,'')='' ")
    List<DrPlusCenterTable> getLikeDateList3(Integer pid,String val1,String val2);


    @Select("select COLUMN_NAME,mapping from ( select COLUMN_NAME ,case when isnull(s.id,'')='' then '0' else '1' end mapping  " +
            " from(select COLUMN_NAME  FROM information_schema.COLUMNS  WHERE TABLE_NAME='${tablename}')a " +
            " left join drplus_center_table s on s.source_column =COLUMN_NAME and drplus_platform_detailed_id=${pid} " +
            " where COLUMN_NAME like '%${val}%' ) table_s where mapping = '${type}'")
    List<LinkedHashMap<String,String>> getUnmappedColumnList(String tablename, Integer pid, String val,Integer type);


    @Select(" select COLUMN_NAME,mapping " +
            " from (  select COLUMN_NAME ,case when isnull(s.id,'')='' then '0' else '1' end mapping  " +
            "         from (select COLUMN_NAME  FROM information_schema.COLUMNS WHERE TABLE_NAME='${tablenameA}' " +
            "                union" +
            "               select COLUMN_NAME  FROM information_schema.COLUMNS WHERE TABLE_NAME='${tablenameB}') a  " +
            "         left join drplus_center_table s on s.source_column =COLUMN_NAME and drplus_platform_detailed_id=${pid}   " +
            "         where COLUMN_NAME like '%${val}%' )   table_s  " +
            " where mapping = '${type}'")
    List<LinkedHashMap<String,String>> getUnmappedColumnListAdd(String tablenameA,String tablenameB, Integer pid, String val,Integer type );


    @Select("select COLUMN_NAME,mapping from ( select COLUMN_NAME ,case when isnull(s.id,'')='' then '0' else '1' end mapping  " +
            " from(select COLUMN_NAME  FROM information_schema.COLUMNS  WHERE TABLE_NAME='${tablename}')a " +
            " left join drplus_center_table s on s.source_column =COLUMN_NAME and drplus_platform_detailed_id=${pid} " +
            " where COLUMN_NAME like '%${val}%' ) table_s  ")
    List<LinkedHashMap<String,String>> getAllColumnList(String tablename,Integer pid, String val);

    @Select("select COLUMN_NAME,mapping " +
            "from ( select COLUMN_NAME ,case when isnull(s.id,'')='' then '0' else '1' end mapping  " +
            "       from (select COLUMN_NAME   FROM information_schema.COLUMNS   WHERE TABLE_NAME='${tablenameA}'" +
            "              union" +
            "             select COLUMN_NAME   FROM information_schema.COLUMNS   WHERE TABLE_NAME='${tablenameB}' ) a " +
            "       left join drplus_center_table s on s.source_column =COLUMN_NAME and drplus_platform_detailed_id=${pid}  " +
            "       where COLUMN_NAME like '%${val}%' " +
            ") table_s  ")
    List<LinkedHashMap<String,String>> getAllColumnListAdd(String tablenameA,String tablenameB,Integer pid, String val );




    @Update(" update a set a.source_column = b.COLUMN_NAME from drplus_center_table a ,(select COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_NAME='${tablename}') b where a.name = b.COLUMN_NAME and a.drplus_platform_detailed_id =${pid} and isnull(a.source_column,'')='' ")
    void getAutomappedColumn(String tablename, Integer pid);

    @Update(" update a set a.source_column = b.COLUMN_NAME " +
            " from drplus_center_table a ," +
            "  (select COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_NAME='${tablenameA}' " +
            "   union" +
            "  select COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_NAME='${tablenameB}'  ) b" +
            " where a.name = b.COLUMN_NAME and a.drplus_platform_detailed_id =${pid} and isnull(a.source_column,'')='' ")
    void getAutomappedColumnAdd(String tablenameA,String tablenameB, Integer pid );

    @Update(" update  drplus_center_table set source_column = '${columnName}' where id = ${id} ")
    void getManualmappedColumn(String columnName, Integer id);
    @Update(" update  drplus_center_table set report_column = '${columnName}' where id = ${id} ")
    void getReportManualmappedColumn(String columnName, Integer id);

    @Update(" update  drplus_center_table set report_column = name where drplus_platform_detailed_id = ${pid} and  isnull(report_column,'')='' and isnull(source_column,'')!='' ")
    void getAutoReportManualmappedColumn( Integer pid);

    @Update(" update  drplus_center_table set report_column = null where drplus_platform_detailed_id = ${pid}   ")
    void cleanReportManualmappedColumn( Integer pid);

    @Select(" select case when isnull(source_column,'')='' then 0 else 1 end  from drplus_center_table where  id = ${id}")
    int getExistsMapping(Integer id);

    @Select(" select name,source_column  from drplus_center_table where drplus_platform_detailed_id = ${pid}  and name not in( 'drplus_extract_detailed_id')")
    List<DrPlusCenterTable> getColumnByPId(Integer pid);

    @Select(" select name,source_column  from drplus_center_table where drplus_platform_detailed_id = ${pid}  and name not in( 'drplus_extract_detailed_id') and table_type='${tableType}'")
    List<DrPlusCenterTable> getColumnByPIdAndTableType(Integer pid,String tableType);

    @Delete("${sql}")
    int executeDeleteSqlScript(String sql);

    @Insert("${sql}")
    int executeInsertSqlScript(String sql);

    @Select("${sql}")
    int executeSelectSqlScript(String sql);



    @Select(" select count(*) from drplus_center_table_data${pid}  with (nolock) where drplus_extract_detailed_id =${id}  ")
    Integer getCountextractSum(Integer pid,Integer id);

    @Select(" select count(*) from drplus_center_table_data${pid}a  with (nolock) where drplus_extract_detailed_id =${id}  ")
    Integer getCountextractSumAdd(Integer pid,Integer id);


    @Select(" select count(1) from drplus_center_table_data${pid}   with (nolock) where drplus_extract_detailed_id =${id}  ")
    Integer getCountextractSumWithNolock(Integer pid,Integer id);

    @Select(" select count(1) from drplus_center_table_data${pid}a   with (nolock) where drplus_extract_detailed_id =${id}  ")
    Integer getCountextractSumWithNolockAdd(Integer pid,Integer id);


    @Delete(" truncate table drplus_center_table_data_ioc${pid} ")
    void truncateTable(Integer pid);

    @Delete(" truncate table drplus_center_table_data_ioc${pid}${belong}   ")
    void truncateTableAdd(Integer pid,String belong);

    @Insert(" insert into drplus_center_table_data_ioc${pid} " +
            " select * from drplus_center_table_data${pid} " +
            " where   drplus_extract_detailed_id=${extract_id}")
    int insertDataToIocTable(Integer extract_id, Integer pid);

    @Insert(" insert into drplus_center_table_data_ioc${pid}${belong} " +
            " select * from drplus_center_table_data${pid}${belong} " +
            " where   drplus_extract_detailed_id=${extract_id}")
    int insertDataToIocTableAdd(Integer extract_id, Integer pid,String belong);




    @Insert(" insert into drplus_center_table_data_ioc${pid} " +
            " select * from drplus_center_table_data${pid} " +
            " where  PRIMAEYKEY = '${key}'")
    int insertDataToIocTable2(Integer pid, String key);

    @Insert(" insert into drplus_center_table_data_ioc${pid}${belong} " +
            " select * from drplus_center_table_data${pid}${belong} " +
            " where  PRIMAEYKEY = '${key}'")
    int insertDataToIocTableAdd2(Integer pid, String key,String belong);

    @Delete(" delete from drplus_control_result where drplus_extract_detailed_id=${extract_id} and drplus_platform_detailed_id = ${pid}    ")
    int delQualityData(Integer extract_id, Integer pid);

    @Delete(" delete from drplus_errorlog where drplus_platform_detailed_id = ${pid} and drplus_extract_detailed_id=${extract_id} ")
    int delQualityErrorData(Integer extract_id, Integer pid);

    @Delete(" delete from drplus_control_result where drplus_platform_detailed_id = ${pid} and primary_keyval='${PRIMAEYKEY}'   ")
    void delQualityData2(Integer pid, String PRIMAEYKEY);
    @Delete(" delete from drplus_errorlog where drplus_platform_detailed_id = ${pid} and patient_key='${PRIMAEYKEY}' ")
    void delQualityErrorData2(Integer pid,  String PRIMAEYKEY);

    @Update(" update drplus_center_table set source_column = null  where drplus_platform_detailed_id = ${id}")
    void clearMapping(Integer id);



    @Update(" update drplus_center_table set source_column = null  where drplus_platform_detailed_id = ${pid} and id = ${id}")
    void clearOneMapping(Integer pid, Integer id);

    @Select(" select  case when isnull(source_column,'')='' then 0 else 1 end from drplus_center_table  where drplus_platform_detailed_id = ${pid} and id = ${id} ")
    Integer clearExistsMapping(Integer pid, Integer id);

    /**   这里是列表 看需要多少个列数据
     *  主键  住院号  姓名  主治医师  出院科室  出院时间/  结算时间          状态(审核)             审核时间                         操作(审核 /查看 /历史)
     *   PRIMAEYKEY     ZYH  NAME   ZZYS    CYKBMC    CYSJ/   JSSJ     drplus_data_type.review_type   drplus_data_type.first_review_time
     */

    @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,a.p434 ZZYS,a.p26 CYKBMC,a.CYSJ,a.CQSJ, " +
            "        b.review_type,b.first_review_time,b.first_review_msg ,b.report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid} a " +
            " left join drplus_data_type b on b.drplus_platform_detailed_id =${pid}  and a.PRIMAEYKEY = b.primarykey_val" +
            " where  CQSJ between '${stime}' and '${etime}' and ${typesql} and ( isnull(a.PRIMAEYKEY,'') like '%${val}%' or isnull(a.ZYH,'') like '%${val}%' or isnull(a.NAME,'') like '%${val}%' ) " +
            " order by CQSJ desc ")
    List<LinkedHashMap> getPatientByPlatformId2(Integer pid, String timeColumn, String stime, String etime,String typesql,String val);


 @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,a.p434 ZZYS,a.p26 CYKBMC,a.CYSJ,a.CQSJ, " +
            "        b.review_type,b.first_review_time,b.first_review_msg ,b.report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid} a " +
            " left join drplus_data_type b on b.drplus_platform_detailed_id =${pid}  and a.PRIMAEYKEY = b.primarykey_val" +
            " where  CQSJ between '${stime}' and '${etime}' and ${typesql} and ( isnull(a.PRIMAEYKEY,'') like '%${val}%' or isnull(a.ZYH,'') like '%${val}%' or isnull(a.NAME,'') like '%${val}%' ) " +
            " order by CQSJ desc ")
    List<LinkedHashMap> getPatientByPlatformId3(Integer pid, String timeColumn, String stime, String etime,String typesql,String val);


    @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,a.ZZYSMC ZZYS,a.CYKBMC_BZ CYKBMC,a.CYSJ,a.CQSJ, " +
            "        b.review_type,b.first_review_time,b.first_review_msg ,b.report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid} a " +
            " left join drplus_data_type b on b.drplus_platform_detailed_id =${pid}  and a.PRIMAEYKEY = b.primarykey_val" +
            " where  CQSJ between '${stime}' and '${etime}' and ${typesql} and ( isnull(a.PRIMAEYKEY,'') like '%${val}%' or isnull(a.ZYH,'') like '%${val}%' or isnull(a.NAME,'') like '%${val}%' ) " +
            " order by CQSJ desc ")
    List<LinkedHashMap> getPatientByPlatformId5(Integer pid, String timeColumn, String stime, String etime,String typesql,String val);


    @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,null ZZYS,KSROLE CYKBMC,a.CYSJ,a.CQSJ, " +
            "        b.review_type,b.first_review_time,b.first_review_msg ,b.report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid}a a " +
            " left join drplus_data_type b on b.drplus_platform_detailed_id =${pid}  and a.PRIMAEYKEY = b.primarykey_val" +
            " where  CQSJ between '${stime}' and '${etime}' and ${typesql} and ( isnull(a.PRIMAEYKEY,'') like '%${val}%' or isnull(a.ZYH,'') like '%${val}%' or isnull(a.NAME,'') like '%${val}%' ) " +
            " order by CQSJ desc ")
    List<LinkedHashMap> getPatientByPlatformId6(Integer pid, String timeColumn, String stime, String etime,String typesql,String val);

    @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,null ZZYS,KSROLE CYKBMC,a.CYSJ,a.CQSJ, " +
            "        b.review_type,b.first_review_time,b.first_review_msg ,b.report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid}a a " +
            " left join drplus_data_type b on b.drplus_platform_detailed_id =${pid}  and a.PRIMAEYKEY = b.primarykey_val" +
            " where  CQSJ between '${stime}' and '${etime}' and ${typesql} and ( isnull(a.PRIMAEYKEY,'') like '%${val}%' or isnull(a.ZYH,'') like '%${val}%' or isnull(a.NAME,'') like '%${val}%' ) " +
            "  order by CQSJ desc ")
    List<LinkedHashMap> getPatientByPlatformId7(Integer pid, String timeColumn, String stime, String etime,String typesql,String val);

     @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,null ZZYS,KSROLE CYKBMC,a.CYSJ,a.CQSJ, " +
             "        b.review_type,b.first_review_time,b.first_review_msg ,b.report_type,b.report_content," +
             "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
             "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
             " from drplus_center_table_data${pid} a " +
             " left join drplus_data_type b on b.drplus_platform_detailed_id =${pid}  and a.PRIMAEYKEY = b.primarykey_val" +
             " where  CQSJ between '${stime}' and '${etime}' and ${typesql} and ( isnull(a.PRIMAEYKEY,'') like '%${val}%' or isnull(a.ZYH,'') like '%${val}%' or isnull(a.NAME,'') like '%${val}%' ) " +
             " order by CQSJ desc ")
     List<LinkedHashMap> getPatientByPlatformId8(Integer pid, String timeColumn, String stime, String etime, String typesql, String val);

     @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,null ZZYS,KSROLE CYKBMC,a.CYSJ,a.CQSJ, " +
            "        b.review_type,b.first_review_time,b.first_review_msg ,b.report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid} a " +
            " left join drplus_data_type b on b.drplus_platform_detailed_id =${pid}  and a.PRIMAEYKEY = b.primarykey_val" +
            " where  CQSJ between '${stime}' and '${etime}' and ${typesql} and ( isnull(a.PRIMAEYKEY,'') like '%${val}%' or isnull(a.ZYH,'') like '%${val}%' or isnull(a.NAME,'') like '%${val}%' ) " +
            " order by CQSJ desc ")
     List<LinkedHashMap> getPatientByPlatformId9(Integer pid, String timeColumn, String stime, String etime, String typesql, String val);


    @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,atddr_name ZZYS,dscg_caty CYKBMC,a.CYSJ,a.CQSJ, " +
            "        b.review_type,b.first_review_time,b.first_review_msg ,b.report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid}a a " +
            " left join drplus_data_type b on b.drplus_platform_detailed_id =${pid}  and a.PRIMAEYKEY = b.primarykey_val" +
            " where  CQSJ between '${stime}' and '${etime}' and ${typesql} and ( isnull(a.PRIMAEYKEY,'') like '%${val}%' or isnull(a.ZYH,'') like '%${val}%' or isnull(a.NAME,'') like '%${val}%' ) " +
            " order by CQSJ desc ")
    List<LinkedHashMap> getPatientByPlatformId10(Integer pid, String timeColumn, String stime, String etime, String typesql, String val);


    /**
     * TODO 这里需要多少字段 就查询多少字段 暂时先用* 代替
     * @param pid
     * @param PRIMAEYKEY
     * @return
     */
    @Select(" select a.*,isnull(b.review_type,0)  review_type ,isnull(b.report_type,0) report_type " +
            " from drplus_center_table_data${pid} a " +
            " left join drplus_data_type b on   b.primarykey_val = a.PRIMAEYKEY and b.drplus_platform_detailed_id = ${pid} " +
            " where PRIMAEYKEY ='${PRIMAEYKEY}'   ")
    LinkedHashMap<String,Object> getPatientOne(Integer pid, String PRIMAEYKEY);

    @Select(" select  a.*  " +
            ",c.*,isnull(b.review_type,0)  review_type ,isnull(b.report_type,0) report_type  " +
            " from drplus_center_table_data${pid}a a" +
            " left join drplus_center_table_data${pid}b c on c.drplus_extract_detailed_id=a.drplus_extract_detailed_id and c.PRIMAEYKEY= a.PRIMAEYKEY " +
            " left join drplus_data_type b on   b.primarykey_val = a.PRIMAEYKEY and b.drplus_platform_detailed_id = ${pid}" +
            " where a.PRIMAEYKEY ='${PRIMAEYKEY}'    ")
    LinkedHashMap<String,Object> getPatientOneAdd6(Integer pid, String PRIMAEYKEY);

    @Select(" select  a.*," +
            " c.*,isnull(b.review_type,0)  review_type ,isnull(b.report_type,0) report_type  " +
            " from drplus_center_table_data${pid}a a" +
            " left join drplus_center_table_data${pid}b c on c.drplus_extract_detailed_id=a.drplus_extract_detailed_id and  c.PRIMAEYKEY= a.PRIMAEYKEY " +
            " left join drplus_data_type b on   b.primarykey_val = a.PRIMAEYKEY and b.drplus_platform_detailed_id = ${pid}" +
            " where a.PRIMAEYKEY ='${PRIMAEYKEY}'    ")
    LinkedHashMap<String,Object> getPatientOneAdd7(Integer pid, String PRIMAEYKEY);


    @Select(" select  a.*," +
            " isnull(b.review_type,0)  review_type ,isnull(b.report_type,0) report_type  " +
            " from drplus_center_table_data${pid}a a" +
            " left join drplus_data_type b on   b.primarykey_val = a.PRIMAEYKEY and b.drplus_platform_detailed_id = ${pid}" +
            " where a.PRIMAEYKEY ='${PRIMAEYKEY}'    ")
    LinkedHashMap<String,Object> getPatientOneAdd10A(Integer pid, String PRIMAEYKEY);


    @Select(" select * from drplus_center_table_data${pid}${tab} where PRIMAEYKEY='${key}' ")
    List<LinkedHashMap<String, Object>> getPatientOneAdd10B(Integer pid, String key, String tab);


    /**   这里是列表 看需要多少个列数据
     *  主键  住院号  姓名  主治医师  出院科室  出院时间/  结算时间          状态(审核)             审核时间         reprot_time-->上报时间       reprot_code-->上报状态码  report_content-->上报结果             操作(审核 /查看 /历史)
     *   PRIMAEYKEY     ZYH  NAME   ZZYS    CYKBMC    CYSJ/   JSSJ     drplus_data_type.review_type   drplus_data_type.first_review_time
     */
    @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,a.p434 ZZYS,a.p26 CYKBMC,a.CYSJ,a.CQSJ,   b.id cid," +
            "        b.review_type,b.first_review_time,b.first_review_msg ,isnull(b.report_type,0) report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid} a " +
            " left join drplus_data_type b on   a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id=${pid}" +
            " where   ${typesql}   " +
            " and (a.PRIMAEYKEY like '%${val}%' or a.ZYH like '%${val}%' or a.NAME like '%${val}%')" +
            " and cqsj between '${stime}' and '${etime}' " +
            " order by reprot_time desc ")
    List<LinkedHashMap<String, Object>> getReportResult2(Integer pid, String typesql, String val,String stime ,String etime);

    @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,a.p434 ZZYS,a.p26 CYKBMC,a.CYSJ,a.CQSJ,  b.id cid," +
            "        b.review_type,b.first_review_time,b.first_review_msg ,isnull(b.report_type,0) report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content " +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid} a " +
            " left join drplus_data_type b on   a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id=${pid}" +
            " where  ${typesql}   " +
            " and (a.PRIMAEYKEY like '%${val}%' or a.ZYH like '%${val}%' or a.NAME like '%${val}%')" +
            " and cqsj between '${stime}' and '${etime}' " +
            " order by reprot_time desc ")
    List<LinkedHashMap<String, Object>> getReportResult3(Integer pid, String typesql, String val,String stime ,String etime);

    @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME,a.ZZYSMC ZZYS,a.CYKBMC_BZ CYKBMC,a.CYSJ,a.CQSJ, b.id cid, b.revoke_code ," +
            "        b.review_type,b.first_review_time,b.first_review_msg ,isnull(b.report_type,0) report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content " +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid} a " +
            " left join drplus_data_type b on   a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id=${pid}" +
            " where  ${typesql}   " +
            " and (a.PRIMAEYKEY like '%${val}%' or a.ZYH like '%${val}%' or a.NAME like '%${val}%')" +
            " and cqsj between '${stime}' and '${etime}' " +
            " order by reprot_time desc ")
    List<LinkedHashMap<String, Object>> getReportResult5(Integer pid, String typesql, String val,String stime ,String etime);



    @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME, USERROLE ZZYS, KSROLE CYKBMC,a.CYSJ,a.CQSJ, b.id cid," +
            "        b.review_type,b.first_review_time,b.first_review_msg ,isnull(b.report_type,0) report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid}a a " +
            " left join drplus_data_type b on   a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id=${pid}" +
            " where  ${typesql}    " +
            " and (a.PRIMAEYKEY like '%${val}%' or a.ZYH like '%${val}%' or a.NAME like '%${val}%')" +
            " and cqsj between '${stime}' and '${etime}' " +
            " order by reprot_time desc ")
    List<LinkedHashMap<String, Object>> getReportResult6(Integer pid, String typesql, String val,String stime ,String etime);

    @Select(" select a.PRIMAEYKEY,a.ZYH,a.NAME, USERROLE ZZYS, KSROLE CYKBMC,a.CYSJ,a.CQSJ, b.id cid," +
            "        b.review_type,b.first_review_time,b.first_review_msg ,isnull(b.report_type,0) report_type,b.report_content," +
            "        b.reprot_code,b.reprot_time,b.revoke_time,b.revoke_content" +
            "        drplus_platform_detailed_id,drplus_extract_detailed_id " +
            " from drplus_center_table_data${pid} a " +
            " left join drplus_data_type b on   a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id=${pid}" +
            " where  ${typesql}    " +
            " and (a.PRIMAEYKEY like '%${val}%' or a.ZYH like '%${val}%' or a.NAME like '%${val}%')" +
            " and cqsj between '${stime}' and '${etime}' " +
            " order by reprot_time desc ")
    List<LinkedHashMap<String, Object>> getReportResult8(Integer pid, String typesql, String val,String stime ,String etime);

    @Select(" select top 1 name from drplus_center_table " +
            " where drplus_platform_detailed_id = ${pid} and isnull(source_column,'')='${column}'")
    String getColumnPrimaryOrTime(Integer pid, String column);

    @Select(" select * from drplus_center_table " +
            " where drplus_platform_detailed_id = ${pid} and isnull(source_column,'')!='' and isnull(report_column,'')!='' ")
    List<DrPlusCenterTable> getReportColumn(Integer pid);

    @Select(" select * from drplus_center_table " +
            " where drplus_platform_detailed_id = ${pid} and ((isnull(source_column,'')!='' and isnull(report_column,'')!='')  or name='PRIMAEYKEY' )")
    List<DrPlusCenterTable> getReportColumn2(Integer pid);

    @Select(" select * from drplus_center_table " +
            " where drplus_platform_detailed_id = ${pid} and isnull(name,'')!='' and table_type = '${tab}' and name not in ('CYSJ','ZYH','NAME','CQSJ','PRIMAEYKEY')")
    List<DrPlusCenterTable> getReportColumnNmme(Integer pid,String tab);

    @Select(" select name from drplus_center_table " +
            " where drplus_platform_detailed_id = ${pid} and isnull(name,'')!='' and table_type = '${tab}' and name not in ('CYSJ','ZYH','NAME','CQSJ','PRIMAEYKEY')")
    List<String> getReportColumnOnlyName(Integer pid,String tab);

    @Select(" select top 1  report_column from drplus_center_table " +
            " where drplus_platform_detailed_id = ${pid} and isnull(source_column,'')!='' and isnull(report_column,'')='${column}' ")
    String getReportColumnByCol(Integer pid,String column);


    @Select("${sql}")
    List<LinkedHashMap<String, Object>> getPatientData(String sql);

    @Select(" if Exists(select top 1 * from sysObjects where Id=OBJECT_ID(N'${name}') and xtype='U') select 1 else select 0 ")
    Integer isExistsTable(String name);

    @Insert("insert into drplus_center_table(drplus_platform_detailed_id,name,column_type,name_zh)" +
            " select ${pid},convert(varchar,字段名),convert(varchar,类型),convert(varchar,说明)  from (select a.name 字段名  , " +
            "case when b.name='int' then 'int' " +
            "  when b.name='varchar' then 'varchar('+ convert(varchar,COLUMNPROPERTY(a.id,a.name,'PRECISION'))+')'" +
            "  when b.name='decimal' then 'decimal(18,2)' else null end  as 类型 ," +
            " isnull(g.[value], ' ') AS 说明 " +
            " FROM syscolumns a " +
            " left join systypes b on a.xtype=b.xusertype " +
            " inner join sysobjects d on a.id=d.id and d.xtype='U' and d.name<>'dtproperties' " +
            " left join syscomments e on a.cdefault=e.id " +
            " left join sys.extended_properties g on a.id=g.major_id AND a.colid=g.minor_id " +
            " left join sys.extended_properties f on d.id=f.class and f.minor_id=0 " +
            " WHERE d.name='drplus_center_table_data${pid}'  ) tableCol  " +
            " where not exists(select 1 from drplus_center_table center where center.name =字段名 and center.drplus_platform_detailed_id=${pid} ) and 字段名!='drplus_extract_detailed_id' ")
    Integer insetColDate(Integer pid);



    @Insert("insert into drplus_center_table(drplus_platform_detailed_id,name,column_type,name_zh,table_type)" +
            " select ${pid},convert(varchar,字段名),convert(varchar,类型),convert(varchar,说明)  ,tableType from (select a.name 字段名  , " +
            "case when b.name='int' then 'int' " +
            "  when b.name='varchar' then 'varchar('+ convert(varchar,COLUMNPROPERTY(a.id,a.name,'PRECISION'))+')'" +
            "  when b.name='decimal' then 'decimal(18,2)' else null end  as 类型 ," +
            " isnull(g.[value], '') AS 说明 ," +
            " '${tableType}' tableType" +
            " FROM syscolumns a " +
            " left join systypes b on a.xtype=b.xusertype " +
            " inner join sysobjects d on a.id=d.id and d.xtype='U' and d.name<>'dtproperties' " +
            " left join syscomments e on a.cdefault=e.id " +
            " left join sys.extended_properties g on a.id=g.major_id AND a.colid=g.minor_id " +
            " left join sys.extended_properties f on d.id=f.class and f.minor_id=0 " +
            " WHERE d.name='drplus_center_table_data${pid}${tableType}'  ) tableCol  " +
            " where not exists(select 1 from drplus_center_table center where center.name =字段名  and center.drplus_platform_detailed_id=${pid} ) and 字段名!='drplus_extract_detailed_id'  ")
    Integer insetColDateAdd(Integer pid,String tableType);


    @Insert("insert into drplus_center_table(drplus_platform_detailed_id,name,column_type,name_zh,table_type)" +
            " select ${pid},convert(varchar,字段名),convert(varchar,类型),convert(varchar,说明)  ,tableType  from (select a.name 字段名  , " +
            "case when b.name='int' then 'int' " +
            "  when b.name='varchar' then 'varchar('+ convert(varchar,COLUMNPROPERTY(a.id,a.name,'PRECISION'))+')'" +
            "  when b.name='decimal' then 'decimal(18,2)' else null end  as 类型 ," +
            " isnull(g.[value], ' ') AS 说明 ," +
            " '${tableType}' tableType" +
            " FROM syscolumns a " +
            " left join systypes b on a.xtype=b.xusertype " +
            " inner join sysobjects d on a.id=d.id and d.xtype='U' and d.name<>'dtproperties' " +
            " left join syscomments e on a.cdefault=e.id " +
            " left join sys.extended_properties g on a.id=g.major_id AND a.colid=g.minor_id " +
            " left join sys.extended_properties f on d.id=f.class and f.minor_id=0 " +
            " WHERE d.name='drplus_center_table_data${pid}${tableType}'  ) tableCol  " +
            " where not exists(select 1 from drplus_center_table center where center.name =字段名 and center.drplus_platform_detailed_id=${pid} ) and 字段名!='drplus_extract_detailed_id' and 字段名!='PRIMAEYKEY' and 字段名!='CQSJ'")
    Integer insetColDateAddB(Integer pid,String tableType);


    @Insert("insert into drplus_center_table(drplus_platform_detailed_id,name,column_type,name_zh,table_type)" +
            " select ${pid},convert(varchar,字段名),convert(varchar,类型),convert(varchar,说明)  ,tableType  from (select a.name 字段名  , " +
            "case when b.name='int' then 'int' " +
            "  when b.name='varchar' then 'varchar('+ convert(varchar,COLUMNPROPERTY(a.id,a.name,'PRECISION'))+')'" +
            "  when b.name='decimal' then 'decimal(18,2)' else null end  as 类型 ," +
            " isnull(g.[value], ' ') AS 说明 ," +
            " '${tableType}' tableType" +
            " FROM syscolumns a " +
            " left join systypes b on a.xtype=b.xusertype " +
            " inner join sysobjects d on a.id=d.id and d.xtype='U' and d.name<>'dtproperties' " +
            " left join syscomments e on a.cdefault=e.id " +
            " left join sys.extended_properties g on a.id=g.major_id AND a.colid=g.minor_id " +
            " left join sys.extended_properties f on d.id=f.class and f.minor_id=0 " +
            " WHERE d.name='drplus_center_table_data${pid}${tableType}'  ) tableCol  " +
            " where not exists(select 1 from drplus_center_table center where center.name =字段名 and center.drplus_platform_detailed_id=${pid} and" +
            "  center.table_type ='${tableType}' ) and 字段名!='drplus_extract_detailed_id' and 字段名!='PRIMAEYKEY' and 字段名!='CQSJ'")
    Integer insetColDateAddOneToMany(Integer pid,String tableType);



}
