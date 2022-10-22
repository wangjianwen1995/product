package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.drplus.entity.DrplusJbicdMap;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DrplusJbicdMapDao extends BaseUUIDDao<DrplusJbicdMap> {



    @Select(" select * from drplus_jbicd_map " +
            " where left_version_id =${leftid} " +
            "       and right_version_id = ${rightid} " +
            "       and (isnull(left_code,'') like '%${lval}%' or isnull(left_name,'')  like '%${lval}%' ) " +
            "       and (isnull(right_code,'')  like '%${rval}%'or isnull(right_name,'')  like '%${rval}%' ) " +
            " order by left_code ")
    List<DrplusJbicdMap> getContrastDate( Integer leftid, Integer rightid ,String lval, String rval);

    @Select(" select * from drplus_jbicd_map " +
            " where left_version_id =${leftid} " +
            "       and right_version_id = ${rightid} " +
            "       and (isnull(left_code,'') like '%${lval}%' or isnull(left_name,'')  like '%${lval}%' ) " +
            "       and (isnull(right_code,'')=''or isnull(right_name,'')= '' ) " +
            " order by left_code ")
    List<DrplusJbicdMap> getNotContrastDate( Integer leftid, Integer rightid ,String lval );


    @Select(" select code left_code, name left_name ,${lid} left_version_id from drplus_jbicd " +
            " where drplus_code_version_id = ${lid} and (isnull(name,'') like '%${lval}%' or isnull(code,'') like '%${lval}%') " +
            " order by left_code ")
    List<DrplusJbicdMap> selectLeftData(Integer lid, String lval);



    @Update(" update a set a.right_code =b.code,a.right_name = b.name   " +
            " from  drplus_jbicd_map a,  (select code,name from drplus_jbicd where drplus_code_version_id = ${rid}) b" +
            " where isnull(a.left_code,'')!='' " +
            "       and isnull(a.right_code,'')=''  " +
            "       and a.left_version_id=${lid} and a.right_version_id=${rid} and a.left_code = b.code ")
    Integer autoContrastICD(Integer lid, Integer rid);

    @Insert(" insert into drplus_jbicd_map (id,left_code,left_name,left_version_id,right_version_id ) " +
            " select newid(),a.code,a.name,a.drplus_code_version_id ,${rid}" +
            " from drplus_jbicd a" +
            " where drplus_code_version_id = ${lid} and isnull(code,'')!='' " +
            " and not exists( select 1 from drplus_jbicd_map c where c.left_code=a.code and c.left_version_id = ${lid} and c.right_version_id = ${rid}) " )
    Integer isnertsql(Integer lid,Integer rid);

    @Update(" update drplus_jbicd_map set right_code = null,right_name = null where left_version_id =${lid} and right_version_id  =${rid} ")
    Integer cleanMapping(Integer lid, Integer rid);

    @Select(" select count(1) from drplus_jbicd_map where left_version_id = ${lid} and  right_version_id = ${rid}")
    Integer getCount(Integer lid, Integer rid);

    @Update(" update a set a.${jbBm}=b.right_code ,a.${jbMc} = b.right_name " +
            "   from drplus_center_table_data${pid} a ," +
            "       (select left_code,right_code,right_name from drplus_jbicd_map where left_version_id=${lid} and right_version_id = ${rid} ) b " +
            "   where    drplus_extract_detailed_id = ${eid}" +
            "    and isnull(a.${jbBm},'')!=''" +
            "    and a.${jbBm} = b.left_code ")
    Integer transformationICD3(Integer pid,Integer eid,Integer lid, Integer rid,String jbBm,String jbMc);


    @Update(" update a set a.${jbBm}=b.right_code ,a.${jbMc} = b.right_name " +
            "   from drplus_center_table_data${pid}a a ," +
            "       (select left_code,right_code,right_name from drplus_jbicd_map where left_version_id=${lid} and right_version_id = ${rid} ) b " +
            "   where    drplus_extract_detailed_id = ${eid}  and isnull(a.${jbBm},'')!=''    and a.${jbBm} = b.left_code ")
    Integer transformationICD67a(Integer pid,Integer eid,Integer lid, Integer rid,String jbBm,String jbMc);

    @Update(" update a set a.${jbBm}=b.right_code ,a.${jbMc} = b.right_name " +
            "   from drplus_center_table_data${pid}b a ," +
            "       (select left_code,right_code,right_name from drplus_jbicd_map where left_version_id=${lid} and right_version_id = ${rid} ) b " +
            "   where    drplus_extract_detailed_id = ${eid}  and isnull(a.${jbBm},'')!=''    and a.${jbBm} = b.left_code ")
    Integer transformationICD67b(Integer pid,Integer eid,Integer lid, Integer rid,String jbBm,String jbMc);

    @Update(" update a set a.${jbBm}=b.right_code ,a.${jbMc} = b.right_name " +
            "   from drplus_center_table_data${pid} a ," +
            "       (select left_code,right_code,right_name from drplus_jbicd_map where left_version_id=${lid} and right_version_id = ${rid} ) b " +
            "   where    drplus_extract_detailed_id = ${eid}" +
            "    and isnull(a.${jbBm},'')!=''" +
            "    and a.${jbBm} = b.left_code ")
    Integer transformationICD8(Integer pid,Integer eid,Integer lid, Integer rid,String jbBm,String jbMc);

    @Update(" update a set a.${jbBm}=b.right_code ,a.${jbMc} = b.right_name " +
            "   from drplus_center_table_data${pid} a ," +
            "       (select left_code,right_code,right_name from drplus_jbicd_map where left_version_id=${lid} and right_version_id = ${rid} ) b " +
            "   where    drplus_extract_detailed_id = ${eid}" +
            "    and isnull(a.${jbBm},'')!=''" +
            "    and a.${jbBm} = b.left_code ")
    Integer transformationICD9(Integer pid,Integer eid,Integer lid, Integer rid,String jbBm,String jbMc);

    @Update(" update a set a.${jbBm}=b.right_code ,a.${jbMc} = b.right_name " +
            "   from drplus_center_table_data${pid}b a ," +
            "       (select left_code,right_code,right_name from drplus_jbicd_map where left_version_id=${lid} and right_version_id = ${rid} ) b " +
            "   where    drplus_extract_detailed_id = ${eid}" +
            "    and isnull(a.${jbBm},'')!=''" +
            "    and a.${jbBm} = b.left_code ")
    Integer transformationICD10(Integer pid,Integer eid,Integer lid, Integer rid,String jbBm,String jbMc);


    @Update(" update a set a.${jbBm}=b.right_code ,a.${jbMc} = b.right_name " +
            "   from drplus_center_table_data${pid}d a ," +
            "       (select left_code,right_code,right_name from drplus_jbicd_map where left_version_id=${lid} and right_version_id = ${rid} ) b " +
            "   where    drplus_extract_detailed_id = ${eid}" +
            "    and isnull(a.${jbBm},'')!=''" +
            "    and a.${jbBm} = b.left_code ")
    Integer transformationICD15(Integer pid,Integer eid,Integer lid, Integer rid,String jbBm,String jbMc);

    @Select(" select count(1) from  drplus_jbicd_map where left_version_id = ${lvid} and right_version_id=${rvid}  ")
    Integer getCountByVersionId(Integer lvid, Integer rvid);

    @Insert(" ${str}")
    Integer insertbysql(String str);

    @Delete(" delete from drplus_jbicd_map where left_version_id = ${lvid} and right_version_id=${rvid} ")
    Integer delByVersionId(Integer lvid, Integer rvid);
}
