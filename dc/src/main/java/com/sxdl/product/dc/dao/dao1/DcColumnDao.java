package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcColumn;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DcColumnDao extends BaseUUIDDao<DcColumn> {

    @Select("select * from dc_column where table_id='${tableid}' and column_name='${name}' ")
    DcColumn selectByTidName(@Param(value = "tableid") String tableid, @Param(value = "name") String name);

    @Select("select * from dc_column where table_id='${tableid}' order by ordernum ")
    List<DcColumn> selectByTableid(@Param(value = "tableid") String tableid);

    @Select("select * from dc_column where table_id='${tableid}' and column_name='${colName}'")
    DcColumn selectByTableidAndName(String tableid,String colName);

    @Select("select  table_name +'.'+column_name   from   dc_column   where id= '${id}' order by column_name ")
    String findtableAndcolName(@Param(value = "id") String id);

    @Select("select * from dc_column where table_id='${tableid}'  and ( column_name like '${name}' or column_name_zh like '${name}') order by ordernum ")
    List<DcColumn> selectBySome(@Param(value = "tableid") String tableid, @Param(value = "name") String name);

    @Select("select rtrim(ltrim(column_name)) from dc_column where table_id='${tableid}'")
    List<String> selectColumByTableid(String id);
 /*   @Select( "select * from dc_column where is_dict=1 and isnull(is_on,1)=1 and (column_name='${name}' or column_name_zh='${name}' ) " )
    List<DcColumn> selectIdDictByName(String name);*/

    @Update(" update dc_column set is_on = ${is_on} where id = '${id}'")
    Integer updateDictIsOn(String id, Integer is_on);

    @Delete("delete from dc_column where table_id = '${to_table_id}'  ")
    void deleteByTableId(String to_table_id);

    @Select("select */*,(select top 1 his_code from hp_hospiatlInfo) his_code ," +
            " (select top 1 his_name from hp_hospiatlInfo) his_name*/ " +
            " from dc_column " +
            " where table_name='dataCenter' and (column_name like '%${name}%' or  column_name_zh like '%${name}%' )")
    List<DcColumn> findMappingColumn(String name);

    @Select("select *,(select top 1 temp_id from hp_report_temp) his_code ," +
            " (select top 1 temp_mc from hp_report_temp) his_name " +
            " from dc_column " +
            " where table_name='homepage'  and  is_hisenable=1 and (column_name like '%${name}%' or  column_name_zh like '%${name}%' )")
    List<DcColumn> findReportTempColumn(String name);

    @Update(" update dc_column set is_on = ${is_hisenable} where id = '${id}'")
    Integer updateMappingEnable(String id, Integer is_hisenable);
}
