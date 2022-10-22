package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hpqc.entity.HpQcWzlEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface HpQcWzlDao extends BaseDao<HpQcWzlEntity> {

    @Select("{call dbo.${pname}('${id}')} ")
    void excuteQualityPro(String pname, String id);

    @Select("{call dbo.${pname}('${id}' ,'${isWest}')} ")
    void excuteQualityPropf(String pname, String id, String isWest);

    @Select("{call dbo.${pname}('${sdate}' ,'${edate}', '${lever}','${flag}','${tableName}','${oncolumn}','${type}')} ")
    List<Map<String, Object>> excuteQualityByDate(String pname, String sdate, String edate, String lever, String flag, String tableName, String oncolumn, String type);

    @Select("{call dbo.${pname}('${bah}' ,'${level}')} ")
    void excuteQualityByBah(String pname, String bah, String level);

    @Select("{call dbo.${pname}('${sdate}' ,'${edate}', '${lever}','${flag}','${tableName}')} ")
    List<Map<String, Object>> excuteQualityBySix(String pname, String sdate, String edate, String lever, String flag, String tableName);

    @Select("{call dbo.${pname}('${Sdate}' ,'${Edate}', '${qm_id}','${is_first}','${qc_time}','${onColumn}','${is_link}','${lever}')} ")
    List<Map<String, Object>> excuteQualityByNine(String pname, String Sdate, String Edate, String qm_id, String is_first, String qc_time, String onColumn, String is_link, String lever);

    @Select("Select id,sqls,message,classify,classify_id,orderum orderum,fields_anchor,can_forced,isnull(platform_on,'01') platform_on,isnull(home_type,5) home_type from hp_qm_wzl Where is_on=1 and isnull(link_on,0)>=${is_link} \n" +
            "  union all Select id,sqls,message,classify,classify_id,ordernum orderum,fields_anchor,can_forced,'01' platform_on,isnull(home_type,5) home_type from hp_qm_bz Where  is_on=1 and classify_id=5 and isnull(link_on,0)>=${is_link} \n" +
            "  union all Select id,sqls,message,classify,classify_id,ordernum orderum,fields_anchor,can_forced ,isnull(platform_on,'01') platform_on ,isnull(home_type,5) home_type from hp_qm_zh Where is_on=1 and isnull(link_on,0)>=${is_link}  /* and classify_id=7*/ and lever<=${level}")
    List<HpQcWzlEntity> selectByQ(String level, String is_link);
    @Insert(" ${sql}")
    Integer insertBySql(String sql);
}
