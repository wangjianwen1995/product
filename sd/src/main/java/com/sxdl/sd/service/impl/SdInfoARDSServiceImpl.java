package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdInfoAPTEDao;
import com.sxdl.sd.dao.dao1.SdInfoARDSDao;
import com.sxdl.sd.dao.dao1.SdInfoEARDao;
import com.sxdl.sd.dao.dao1.SdPatientInfoDao;
import com.sxdl.sd.entity.SdInfoAPTE;
import com.sxdl.sd.entity.SdInfoARDS;
import com.sxdl.sd.entity.SdInfoEAR;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdInfoAPTEService;
import com.sxdl.sd.service.SdInfoARDSService;
import com.sxdl.sd.service.SdInfoEARService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class SdInfoARDSServiceImpl extends BaseServiceImpl<SdInfoEAR> implements SdInfoEARService {
    @Autowired
    SdPatientInfoDao sdPatientInfoDao;
    @Autowired
    SdInfoEARDao sdInfoEARDao;

    @Override
    public void insertOrUpdate(SdInfoEAR sdInfoEAR, SdPatientInfo sdPatientInfo) {
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
        }        if (sdInfoEAR != null) {
            Integer id = sdInfoEAR.getId ();
            if (null != id && !"".equals ( id ) && id > 0) {
                String format = sdPatientInfo.getCy_time();
                format=format.substring(0,16);
                sdInfoEAR.setCM_0_2_4_2(format);
                sdInfoEARDao.updateByPrimaryKeySelective ( sdInfoEAR );
            } else {
                //病人不存在  新增
                sdInfoEARDao.insertSelective (  sdInfoEAR);
            }
        }
    }}
