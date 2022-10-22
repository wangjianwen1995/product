package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpColumn;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.LinkedHashMap;
import java.util.List;

public interface HpColumnDao extends BaseDao<HpColumn> {
    @Update("alter table ${tableName} drop column ${columnName}")
    int deleteTable(@Param(value = "tableName") String tableName, @Param(value = "columnName") String columnName);

    @Select("select distinct ${name} as vals from ${tname}")
    List<String> findInstanceData(String tname, String name);

    @Select("select * from hp_column where isnull(operable_show,'0')='1' and table_id in (select id from hp_table where is_diaolong=1 ) order by name,name_zh ")
    List<HpColumn> findDLPageByTableId();

    @Select("select name,isnull(cast(is_show as varchar(1)),'0') is_show from hp_column where  isnull(operable_show,'0')='1' and  table_id in (select id from hp_table where is_diaolong=1 )")
    List<LinkedHashMap<String, String>> findDLPageShow();

    @Select("select name,isnull(cast(is_show as varchar(1)),'0') is_show from hp_column where  isnull(operable_show,'0')='1' and  table_name='${tableName}' ")
    List<LinkedHashMap<String, String>> findBytableName(String tableName);

    @Select("select * from hp_column where  isnull(cast(operable_show as varchar(1)),'0')='1' and  table_name='${tableName}' order by name,name_zh ")
    List<HpColumn> findColumnByTableName(String tableName);

    @Select(" select * from hp_column " +
            " where isnull(is_gjcx,'0')='1' and  (table_name='homepage' or (table_name='dl_fllow') or table_name='${tableName}}') " +
            "   and (name like '%${name}%' or name_zh like '%${name}%' )")
    List<HpColumn> findColumnSettingsAndTableName(String name, String tableName);

    @Select(" select * from hp_column " +
            " where isnull(is_gjcx,'0')='1' and (table_name='homepage' or (table_name='dl_fllow') " +
            "   and (name like '%${name}%' or name_zh like '%${name}%' ) ")
    List<HpColumn> findColumnSettings(String name);

    @Update("${sql}")
    void excuteSqlWithSQL(String sql);

    /**
     * 查询可以对照的字典列表,不区分是否启用
     *
     * @param name 字段名称
     * @return
     */
    @Select("select *,(select top 1 his_code from hp_hospiatlInfo) his_code ," +
            " (select top 1 his_name from hp_hospiatlInfo) his_name " +
            " from hp_column " +
            " where table_name='dataCenter' and (name_zh like '%${name}%' or  name like '%${name}%' )")
    List<HpColumn> findMappingColumn(String name);

    @Select("select *,(select top 1 temp_id from hp_report_temp) his_code ," +
            " (select top 1 temp_mc from hp_report_temp) his_name " +
            " from hp_column " +
            " where table_name='homepage'  and  is_hisenable=1 and (name_zh like '%${name}%' or  name like '%${name}%' )")
    List<HpColumn> findReportTempColumn(String name);

    @Update(" update hp_column set is_hisenable = ${is_hisenable} where id = '${id}'")
    Integer updateMappingEnable(String id, Integer is_hisenable);

    @Select(" select * from hp_column where table_name like '%${tablename}%' and ( name like '%${name}%' or name_zh  like '%${name}%' )")
    List<HpColumn> findColumnsByHeader(String name, String tablename);
}
