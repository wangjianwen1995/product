package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdInfoCoCDao;
import com.sxdl.sd.dao.dao1.SdPatientInfoDao;
import com.sxdl.sd.entity.SdInfoCoC;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdInfoCoCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SdInfoCoCServiceImpl extends BaseServiceImpl<SdInfoCoC> implements SdInfoCoCService {
    @Autowired
    SdPatientInfoDao sdPatientInfoDao;
    @Autowired
    SdInfoCoCDao  sdInfoCoCDao;
    
    @Override
    public void insertOrUpdate(SdInfoCoC sdInfoCoC, SdPatientInfo sdPatientInfo) {
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
        }        if (sdInfoCoC != null) {
            Integer id = sdInfoCoC.getId ();
            if (null != id && !"".equals ( id ) && id > 0) {
                String format = sdPatientInfo.getCy_time();
                format=format.substring(0,16);
                sdInfoCoC.setCM_0_2_4_2(format);
sdInfoCoCDao.updateByPrimaryKeySelective ( sdInfoCoC );
            } else {
                //???????????????  ??????
sdInfoCoCDao.insertSelective (  sdInfoCoC);
            }
        }
    }}