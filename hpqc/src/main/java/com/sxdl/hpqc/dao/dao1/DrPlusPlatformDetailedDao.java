package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hpqc.entity.DrPlusPlatformDetailed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DrPlusPlatformDetailedDao extends BaseDao<DrPlusPlatformDetailed> {



/*    @Insert(" SET IDENTITY_INSERT  drplus_platform_detailed ON " +
            " INSERT  drplus_platform_detailed (id,drplus_platform_bigclass_name,drplus_platform_bigclass_id,name,source_table, report_url,content_type,obsolete_url,orgcode,token,reportname,reportpass,appid,accept,useragent,reportversion,reportmethod,path_file,file_name,file_header,current_ss_version_id,ask_ss_version_id,current_jb_version_id,ask_jb_version_id,extract_sql,report_sql,is_qy,is_autoextract,is_autoreview,is_autoreport,is_autocode,corn,source_table_add) " +
            " VALUES ( #{id},#{drplus_platform_bigclass_name},#{drplus_platform_bigclass_id},#{name},#{source_table}, #{report_url},#{content_type},#{obsolete_url},#{orgcode},#{token},#{reportname},#{reportpass},#{appid},#{accept},#{useragent},#{reportversion},#{reportmethod},#{path_file},#{file_name},#{file_header},#{current_ss_version_id},#{ask_ss_version_id},#{current_jb_version_id},#{ask_jb_version_id},#{extract_sql},#{report_sql},#{is_qy},#{is_autoextract},#{is_autoreview},#{is_autoreport},#{is_autocode},#{corn},#{source_table_add}) " +
            " SET IDENTITY_INSERT  drplus_platform_detailed OFF ")
    Integer saveDetailed(DrPlusPlatformDetailed detailed);*/


    @Insert(" SET IDENTITY_INSERT  drplus_platform_detailed ON " +
            " INSERT  drplus_platform_detailed (id) " +
            " VALUES ( ${id}) " +
            " SET IDENTITY_INSERT  drplus_platform_detailed OFF ")
    Integer saveDetailedId(Integer id);

    @Select(" select count(*) from drplus_platform_detailed where id = ${id}")
    Integer getCountById(Integer id);

    @Update("update drplus_platform_detailed set is_qy=${type} where id = ${id}")
    Integer updateType(Integer id, Integer type);


    @Select(" select * from drplus_platform_detailed where is_qy = 1")
    List<DrPlusPlatformDetailed> getSheduledData();

    @Update(" update drplus_platform_detailed " +
            " set is_autoextract = ${is_autoextract}" +
                ",is_autocode = ${is_autocode}" +
                ",is_autoreview=${is_autoreview}" +
                ",is_autoreport=${is_autoreport}" +
                ",cron = '${cron}' " +
                ",isopen = ${isopen} " +
                ",offset = ${offset} " +
                ",e_days = ${e_days} " +
            " where id = ${id} ")
    Integer setSheduledData(Integer id, Integer is_autoextract,Integer is_autocode, Integer is_autoreview,  Integer is_autoreport, String cron, Integer isopen, Integer offset, Integer e_days);
    @Select(" select count(1) from drplus_platform_detailed where is_qy=1 and cron='${cron}'")
    Integer getcountByCron(String cron);

    @Select("select * from  drplus_platform_detailed where is_qy=1 and cron='${cron}'")
    List<DrPlusPlatformDetailed> getScheduledByCron(String cron);


    @Update(" update drplus_platform_detailed " +
            " set  cron2 = '${cron2}' " +
            ",isopen2 = ${isopen2} " +
            ",offset2 = ${offset2} " +
            ",e_days2 = ${e_days2} " +
            " where id = ${id} ")
    Integer setSheduledData2(Integer id, String cron2, Integer isopen2, Integer offset2, Integer e_days2);


    @Insert(" ${sql}")
    void   insertSql(@Param("sql")  String sql);


}
