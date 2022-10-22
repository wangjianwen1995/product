package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdInfoAECOPDDao;
import com.sxdl.sd.dao.dao1.SdPatientInfoDao;
import com.sxdl.sd.entity.SdInfoAECOPD;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdInfoAECOPDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class SdInfoAECOPDServiceImpl extends BaseServiceImpl<SdInfoAECOPD> implements SdInfoAECOPDService {
    @Autowired
    SdPatientInfoDao sdPatientInfoDao;
    @Autowired
    SdInfoAECOPDDao sdInfoAECOPDDao;

    @Override
    public void insertOrUpdate(SdInfoAECOPD sdInfoAECOPD, SdPatientInfo sdPatientInfo) {
        if (sdPatientInfo != null) {
            Integer id = sdPatientInfo.getId ();
            SimpleDateFormat myFmt = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
            String format = myFmt.format ( new Date () );
            sdPatientInfo.setSubmit_time ( format );
            if (null != id && !"".equals ( id ) && id > 0) {
                sdPatientInfoDao.updateByPrimaryKeySelective ( sdPatientInfo );
            } else {
                //前端没传递过来 pid
                SdPatientInfo sdPatientInfo1 = new SdPatientInfo ();
                sdPatientInfo1.setPatient_code ( sdPatientInfo.getPatient_code () );
                sdPatientInfo1.setSd_info_id ( sdPatientInfo.getSd_info_id () );
                SdPatientInfo sdPatientInfo2 = sdPatientInfoDao.selectOne ( sdPatientInfo1 );
                if (sdPatientInfo2 != null) {
                    Integer id1 = sdPatientInfo2.getId ();
                    if (null != id1 && !"".equals ( id1 ) && id1 > 0) {
                        sdPatientInfo.setId ( id1 );
                        sdPatientInfoDao.updateByPrimaryKeySelective ( sdPatientInfo );
                    }
                    //数据库就没有此病人
                    else {
                        sdPatientInfoDao.insertSelective ( sdPatientInfo );
                    }
                }
            }
        }
        if (sdInfoAECOPD != null) {
            Integer id = sdInfoAECOPD.getId ();
            if (null != id && !"".equals ( id ) && id > 0) {
                String format = sdPatientInfo.getCy_time();
                format=format.substring(0,16);
                sdInfoAECOPD.setCM_0_2_4_2(format);
                sdInfoAECOPDDao.updateByPrimaryKeySelective ( sdInfoAECOPD );
            } else {
                //病人不存在  新增
                sdInfoAECOPDDao.insertSelective ( sdInfoAECOPD );
            }
        }
    }
}