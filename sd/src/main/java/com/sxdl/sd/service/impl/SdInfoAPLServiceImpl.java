package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdInfoAPLDao;
import com.sxdl.sd.dao.dao1.SdPatientInfoDao;
import com.sxdl.sd.entity.SdInfoAPL;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdInfoAPLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class SdInfoAPLServiceImpl extends BaseServiceImpl<SdInfoAPL> implements SdInfoAPLService {
    @Autowired
    SdPatientInfoDao sdPatientInfoDao;
    @Autowired
    SdInfoAPLDao  sdInfoAPLDao;
    
    @Override
    public void insertOrUpdate(SdInfoAPL sdInfoAPL, SdPatientInfo sdPatientInfo) {
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
        }        if (sdInfoAPL != null) {
            Integer id = sdInfoAPL.getId ();
            if (null != id && !"".equals ( id ) && id > 0) {
                String format = sdPatientInfo.getCy_time();
                format=format.substring(0,16);
                sdInfoAPL.setCM_0_2_4_2(format);
sdInfoAPLDao.updateByPrimaryKeySelective ( sdInfoAPL );
            } else {
                //???????????????  ??????
sdInfoAPLDao.insertSelective (  sdInfoAPL);
            }
        }
    }}