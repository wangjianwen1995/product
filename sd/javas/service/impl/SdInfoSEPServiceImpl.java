package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdInfoSEPDao;
import com.sxdl.sd.dao.dao1.SdPatientInfoDao;
import com.sxdl.sd.entity.SdInfoSEP;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdInfoSEPService;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SdInfoSEPServiceImpl extends BaseServiceImpl<SdInfoSEP> implements SdInfoSEPService {
    @Autowired
    SdPatientInfoDao sdPatientInfoDao;
    @Autowired
    SdInfoSEPDao  sdInfoSEPDao;
    
    @Override
    public void insertOrUpdate(SdInfoSEP sdInfoSEP, SdPatientInfo sdPatientInfo) {
       if (sdPatientInfo != null) {
            Integer id = sdPatientInfo.getId ();
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
        }        if (sdInfoSEP != null) {
            Integer id = sdInfoSEP.getId ();
            if (null != id && !"".equals ( id ) && id > 0) { 
sdInfoSEPDao.updateByPrimaryKeySelective ( sdInfoSEP );
            } else {
                //???????????????  ??????
sdInfoSEPDao.insertSelective (  sdInfoSEP);
            }
        }
    }}