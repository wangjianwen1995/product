package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hpqc.dbo.ProcessDataDBO;
import com.sxdl.hpqc.dbo.RevokeDBO;
import com.sxdl.hpqc.entity.DrPlusDataType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrPlusDataTypeDao extends BaseUUIDDao<DrPlusDataType> {


    @Select(" select count(1) from drplus_data_type " +
            " where drplus_platform_detailed_id=${pid} and   primarykey_val= '${PRIMAEYKEY}' ")
    Integer getCountData(Integer pid, String PRIMAEYKEY);

    @Select(" select * from drplus_data_type " +
            " where drplus_platform_detailed_id=${pid} and   primarykey_val= '${PRIMAEYKEY}' ")
    DrPlusDataType getDatabyBah(Integer pid, String PRIMAEYKEY);




    @Select(" select ${pid} drplus_platform_detailed_id,  ${eid} drplus_extract_detailed," +
            "        a.PRIMAEYKEY patient_key, a.NAME patient_name, a.ZYH patient_zyh, a.CYSJ patient_cysj  " +
            " from  drplus_center_table_data${pid}${tab} a " +
            " inner join drplus_data_type b on b.drplus_platform_detailed_id=${pid} and b.primarykey_val = a.PRIMAEYKEY " +
            " where a.drplus_extract_detailed_id  = ${eid} " +
            " and (a.NAME like '%${val}%' or a.ZYH like '%${val}%' or a.PRIMAEYKEY like '%${val}%')")
    List<ProcessDataDBO> drillDownExtract(Integer pid, Integer eid, String val, String tab);

    @Select(" select ${pid} drplus_platform_detailed_id,  ${eid} drplus_extract_detailed," +
            "        a.PRIMAEYKEY patient_key, a.NAME patient_name, a.ZYH patient_zyh, a.CYSJ patient_cysj  " +
            " from  drplus_center_table_data${pid}${tab} a " +
            " inner join drplus_data_type b on b.drplus_platform_detailed_id=${pid} and b.primarykey_val = a.PRIMAEYKEY and b.review_type=${flag} " +
            " where  a.drplus_extract_detailed_id  = ${eid} " +
            " and (a.NAME like '%${val}%' or a.ZYH like '%${val}%' or a.PRIMAEYKEY like '%${val}%')")
    List<ProcessDataDBO> drillDownReview(Integer pid, Integer eid, String val,Integer flag,String tab);


    @Select(" select ${pid} drplus_platform_detailed_id,  ${eid} drplus_extract_detailed," +
            "        a.PRIMAEYKEY patient_key, a.NAME patient_name, a.ZYH patient_zyh, a.CYSJ patient_cysj ,b.report_content ,b.revoke_code " +
            " from  drplus_center_table_data${pid}${tab} a " +
            " inner join drplus_data_type b on b.drplus_platform_detailed_id=${pid} and  b.primarykey_val = a.PRIMAEYKEY and b.report_type=${flag} " +
            " where   a.drplus_extract_detailed_id  = ${eid}  " +
            " and (a.NAME like '%${val}%' or a.ZYH like '%${val}%' or a.PRIMAEYKEY like '%${val}%')")
    List<ProcessDataDBO> drillDownReport(Integer pid, Integer eid, String val, Integer flag,String tab);


    @Select(" select      a.PRIMAEYKEY revoke_key ,b.revoke_code  " +
            " from  drplus_center_table_data${pid} a " +
            " right join drplus_data_type b on b.drplus_platform_detailed_id=${pid} and  b.primarykey_val = a.PRIMAEYKEY and (b.report_type=1 or b.report_type=-2) " +
            " where   a.drplus_extract_detailed_id  = ${eid}   ")
    List<RevokeDBO> getRevokeCodes (Integer pid, Integer eid);




    @Select(" ${sql} ")
    Integer getReportResultNum(String sql);


    @Select(  "select distinct a.PRIMAEYKEY patient_key, a.NAME patient_name, a.ZYH patient_zyh, a.CYSJ patient_cysj " +
            " from  dbo.drplus_center_table_data${pone}${taba} a  " +
            " inner  join  drplus_data_type b on  b.drplus_platform_detailed_id=${pone}  and a.PRIMAEYKEY = b.primarykey_val and report_type = 1" +
            " where  convert(varchar(10),b.reprot_time,120) between '${stime}' and '${etime}' " +
            "  except " +
            "select distinct a.PRIMAEYKEY patient_key, a.NAME patient_name, a.ZYH patient_zyh, a.CYSJ patient_cysj " +
            " from  dbo.drplus_center_table_data${ptwo}${tabb} a  " +
            " inner  join  drplus_data_type b on  b.drplus_platform_detailed_id=${ptwo}  and a.PRIMAEYKEY = b.primarykey_val and report_type = 1" +
            " where  convert(varchar(10),b.reprot_time,120)  between '${stime}' and '${etime}' "  )
    List<ProcessDataDBO> drillDownDiff(Integer pone, Integer ptwo, String stime, String etime,String taba,String tabb);

}
