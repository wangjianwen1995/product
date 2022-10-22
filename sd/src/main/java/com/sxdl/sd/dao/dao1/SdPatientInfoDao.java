package com.sxdl.sd.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.sd.entity.SdPatientInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SdPatientInfoDao extends BaseDao<SdPatientInfo> {
   /* @Select ( "select * from sd_patient_info where ks_code in '${ks}' and '${role}'='${userCode}'" )
    List<SdPatientInfo> selectSome(@Param ( value = "ks")  Integer[] ks,@Param ( value = "role")  String role, @Param ( value = "userCode") String userCode);
    */
   //@Select( "select * from sd_patient_info where  ${ks} and ${role}=${userCode}" )
   @Select( "select * from sd_patient_info where  ${role}=${userCode} order by cy_time desc" )
   List<SdPatientInfo> selectSome(@Param ( value = "ks")  String ks,@Param ( value = "role")  String role, @Param ( value = "userCode") String userCode);
   @Select( "select * from sd_patient_info where  ${ks}  order by cy_time desc" )
   List<SdPatientInfo> selectByKs(String ks);
   @Select( "select isnull(count(*),0) ls from sd_patient_info where  ${submit_time} between '${sdate} ' and '${format}'" )
    Integer selectls(@Param ( value = "submit_time")String submit_time, @Param ( value = "format")String format,@Param ( value = "sdate")String sdate);
   @Select( "select isnull(count(*),0) ls from sd_patient_info where  status=${s}" )
   Integer selectwls(String s);

   @Select( "${s}" )
   List<SdPatientInfo> findByksmx(String s);
}
