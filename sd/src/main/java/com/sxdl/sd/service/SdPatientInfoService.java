package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoSource;
import com.sxdl.sd.entity.SdPatientInfo;

import java.util.List;
import java.util.Map;

public interface SdPatientInfoService extends BaseService<SdPatientInfo> {
    List<SdPatientInfo> findBySome(Integer status,Integer uid,Integer sid,String role_name);

    void updateSome(SdPatientInfo sdPatientInfo);

    SdPatientInfo selectOne(Integer sid,String patientCode);

    SdPatientInfo insertSome(List<SdInfoSource> sdInfoSourceList,Integer sid, String patientCode);

    Map<String, Integer> selectLs(String edate,String sdate);

    List<Map<String, Object>> findByKs(String status,String cysdate, String cyedate,String tjsdate, String tjedate);

    List<SdPatientInfo> findByksmx(String ks,String flag,  String status,String cysdate, String cyedate,String tjsdate, String tjedate);

    /*List<Map<String, Object>> findByKsTj(String status,String tjsdate, String tjedate);

    List<SdPatientInfo> findByksmxTj(String ks,String flag,  String status,String tjsdate, String tjedate);*/

    List<Map<String, Object>> findBydr(String status, String cysdate, String cyedate);
}
