package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.drplus.entity.DrPlusReportProcessData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrPlusReportProcessDataDao extends BaseUUIDDao<DrPlusReportProcessData> {


    @Select(" select a.* " +
            " from drplus_report_process_data a " +
            " left join drplus_data_type b on a.drplus_platform_detailed_id = b.drplus_platform_detailed_id and a.patient_key = b.primarykey_val " +
            " where a.drplus_history_report_id =${hid} and a.drplus_platform_detailed_id=${pid} " +
            " and (isnull(a.patient_name,'') like '%${val}%'  or isnull(a.patient_key,'') like '%${val}%' or isnull(a.patient_zyh,'') like '%${val}%'  )")
    List<DrPlusReportProcessData> getHistoryReportResultdrillDown1(Integer pid, Integer hid,String val);


    @Select(" select a.* " +
            " from drplus_report_process_data a " +
            " left join drplus_data_type b on  a.drplus_platform_detailed_id = b.drplus_platform_detailed_id and a.patient_key = b.primarykey_val " +
            " where a.drplus_history_report_id =${hid} and a.drplus_platform_detailed_id=${pid} " +
            " and isnull(b.report_type,0)=1 " +
            " and (isnull(a.patient_name,'') like '%${val}%'  or isnull(a.patient_key,'') like '%${val}%' or isnull(a.patient_zyh,'') like '%${val}%'  )")
    List<DrPlusReportProcessData> getHistoryReportResultdrillDown2(Integer pid, Integer hid,String val);


    @Select(" select a.* " +
            " from drplus_report_process_data a " +
            " left join drplus_data_type b on  a.drplus_platform_detailed_id = b.drplus_platform_detailed_id and a.patient_key = b.primarykey_val " +
            " where a.drplus_history_report_id =${hid} and a.drplus_platform_detailed_id=${pid} " +
            " and isnull(b.report_type,0)=-1 " +
            " and (isnull(a.patient_name,'') like '%${val}%'  or isnull(a.patient_key,'') like '%${val}%' or isnull(a.patient_zyh,'') like '%${val}%' ) ")
    List<DrPlusReportProcessData> getHistoryReportResultdrillDown3(Integer pid, Integer hid,String val);


}
