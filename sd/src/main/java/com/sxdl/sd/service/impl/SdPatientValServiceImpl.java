package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdPatientInfoDao;
import com.sxdl.sd.dao.dao1.SdPatientValDao;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.entity.SdPatientVal;
import com.sxdl.sd.service.SdPatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SdPatientValServiceImpl extends BaseServiceImpl<SdPatientVal> implements com.sxdl.sd.service.SdPatientValService {
    @Autowired
    SdPatientInfoDao sdPatientInfoDao;
    @Autowired
    SdPatientValDao sdPatientValDao;
    @Autowired
    SdPatientInfoService sdPatientInfoService;

    @Override
    public void insertOrUpdate(List<SdPatientVal> list, SdPatientInfo sdPatientInfo) {
       /* List<SdInfo> sdInfos = (List<SdInfo>) SdApplicationRunnerImpl.contextMap.get ( "sdInfos" );
        if (sdPatientInfo != null) {
            Integer id = sdPatientInfo.getId ();
            if (null != id && !"".equals ( id ) && id > 0) {
                sdPatientInfoDao.updateByPrimaryKeySelective ( sdPatientInfo );
            } else {
                //病人不存在  新增
                sdPatientInfoDao.insertSelective ( sdPatientInfo );
            }

            SdPatientVal sdPatientVal = new SdPatientVal ();
            list.forEach ( e -> {
                //获取 Sd_info_column_id
                List<SdInfo> sdInfoList = sdInfos.stream ().filter ( s -> s != null && s.getId ().equals ( e.getSd_info_id () ) ).collect ( Collectors.toList () );
                SdInfo sdInfo = sdInfoList.get ( 0 );
                List<SdInfoColumn> columns = sdInfo.getColumns ();
                columns = columns.stream ().filter ( u -> u != null && u.getName ().equals ( e.getSd_info_column_name () ) ).collect ( Collectors.toList () );
                if (columns != null && columns.size () > 0) {
                    SdInfoColumn sdInfoColumn = columns.get ( 0 );
                    e.setSd_info_column_id ( sdInfoColumn.getId () );
                }
                sdPatientVal.setSd_info_column_id ( e.getSd_info_column_id () );
                //sdPatientVal.setSd_info_column_name ( e.getSd_info_column_name () );
                sdPatientVal.setSd_info_id ( e.getSd_info_id () );
                Integer sd_patient_id = e.getSd_patient_id ();
                if (null != sd_patient_id && !"".equals ( sd_patient_id ) && sd_patient_id > 0) {
                    sdPatientVal.setSd_patient_id ( sd_patient_id );
                } else {
                    sdPatientVal.setSd_patient_id ( sdPatientInfo.getId () );
                }
                List<SdPatientVal> patientValList = sdPatientValDao.select ( sdPatientVal );
                if (patientValList != null && patientValList.size () > 0) {
                    sdPatientValDao.updateByPrimaryKey ( e );
                } else {
                    sdPatientValDao.insert ( e );
                }
            } );
        }*/
    }
}
