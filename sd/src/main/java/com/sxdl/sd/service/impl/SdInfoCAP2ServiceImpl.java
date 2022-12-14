package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdInfoCAP2Dao;
import com.sxdl.sd.dao.dao1.SdPatientInfoDao;
import com.sxdl.sd.entity.SdInfoCAP2;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdInfoCAP2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class SdInfoCAP2ServiceImpl extends BaseServiceImpl<SdInfoCAP2> implements SdInfoCAP2Service {
    @Autowired
    SdPatientInfoDao sdPatientInfoDao;
    @Autowired
    SdInfoCAP2Dao  sdInfoCAP2Dao;
    
    @Override
    public void insertOrUpdate(SdInfoCAP2 sdInfoCAP2, SdPatientInfo sdPatientInfo) {
       if (sdPatientInfo != null) {
            Integer id = sdPatientInfo.getId ();
           SimpleDateFormat myFmt = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
           String format = myFmt.format ( new Date () );
           sdPatientInfo.setSubmit_time ( format );
            if (null != id && !"".equals ( id ) && id > 0) {
                sdPatientInfoDao.updateByPrimaryKeySelective ( sdPatientInfo );
            } else {
                SdPatientInfo sdPatientInfo1=new SdPatientInfo ();
                sdPatientInfo1.setPatient_code ( sdPatientInfo.getPatient_code () );
                sdPatientInfo1.setSd_info_id ( sdPatientInfo.getSd_info_id () );
                SdPatientInfo sdPatientInfo2 = sdPatientInfoDao.selectOne ( sdPatientInfo1 );
                if(sdPatientInfo2!=null){
                    Integer id1 = sdPatientInfo2.getId ();
                    if (null != id1 && !"".equals ( id1 ) && id1 > 0) {
                        sdPatientInfo.setId ( id1);
                        sdPatientInfoDao.updateByPrimaryKeySelective ( sdPatientInfo );
                    }
                    else {
                        sdPatientInfoDao.insertSelective ( sdPatientInfo );
                    }
                }
            }
        }        if (sdInfoCAP2 != null) {
            Integer id = sdInfoCAP2.getId ();
            if (null != id && !"".equals ( id ) && id > 0) {
                String format = sdPatientInfo.getCy_time();
                format=format.substring(0,16);
                sdInfoCAP2.setCM_0_2_4_2(format);
sdInfoCAP2Dao.updateByPrimaryKeySelective ( sdInfoCAP2 );
            } else {
                //???????????????  ??????
sdInfoCAP2Dao.insertSelective (  sdInfoCAP2);
            }
        }
    }}