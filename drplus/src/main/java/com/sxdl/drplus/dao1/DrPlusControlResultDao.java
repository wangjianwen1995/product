package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.drplus.entity.DrPlusControlResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrPlusControlResultDao extends BaseUUIDDao<DrPlusControlResult> {

    @Insert(" ${sql}")
    Integer  insertSql(String sql);


    @Select(" select count(1) from drplus_control_result " +
            " where drplus_platform_detailed_id = ${pid} and primary_keyval = '${PRIMAEYKEY}' and termlevel = 1")
    Integer getCountData(Integer pid, String PRIMAEYKEY);


    @Select("   select distinct PRIMAEYKEY from drplus_center_table_data${pid}a a        " +
            "    where      convert(verchar(19),${col},120) between '${stime}' and '${etime}' " +
            "    and not exists(select 1 from drplus_data_type b where b.drplus_platform_detailed_id=${pid}  and b.primarykey_val = a.PRIMAEYKEY and isnull(b.review_type,0)=1 )")
    List<String> getPassData(Integer pid ,String col,String stime,String etime);

    @Select("   select distinct PRIMAEYKEY from drplus_center_table_data${pid}a  a        " +
            "    where      convert(verchar(19),${col},120) between '${stime}' and '${etime}' " +
            "    not exists(select 1 from drplus_data_type b where b.drplus_platform_detailed_id=${pid}  and b.primarykey_val = a.PRIMAEYKEY and isnull(b.review_type,0)=1 )")
    List<String> getPassDataAdd(Integer pid ,String col,String stime,String etime);

    @Select("   select distinct PRIMAEYKEY from drplus_center_table_data${pid}a  a        " +
            "    where     a.drplus_extract_detailed_id=${eid}  " +
            "     and convert(verchar(19),${col},120) between '${stime}' and '${etime}' " +
            "    and not exists(select 1 from drplus_control_result b where a.drplus_platform_detailed_id=${pid} and a.drplus_extract_detailed_id=b.drplus_extract_detailed_id and b.primary_keyval = a.PRIMAEYKEY and b.termlevel=1 )")
    List<String> getPassDataAuto(Integer pid, Integer eid ,String col,String stime,String etime);

    @Select("   select distinct PRIMAEYKEY from drplus_center_table_data${pid}a a        " +
            "    where     a.drplus_extract_detailed_id=${eid}  " +
            "     and convert(verchar(19),${col},120) between '${stime}' and '${etime}' " +
            "    and not exists(select 1 from drplus_control_result b where a.drplus_platform_detailed_id=${pid} and a.drplus_extract_detailed_id=b.drplus_extract_detailed_id and b.primary_keyval = a.PRIMAEYKEY and b.termlevel=1 )")
    List<String> getPassDataAutoAdd(Integer pid, Integer eid ,String col,String stime,String etime);




    @Select("   select distinct PRIMAEYKEY " +
            " from drplus_center_table_data${pid}${tab}   a        " +
            "    where    a.drplus_extract_detailed_id=${eid}  " +
            "    and not exists(select 1 from drplus_data_type b where b.drplus_platform_detailed_id=${pid}  and b.primarykey_val = a.PRIMAEYKEY and isnull(b.review_type,0)=1 )")
    List<String> getPassDataBypid(Integer pid ,Integer eid,String tab);

}
