package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdInfoESRD-HDDao;
import com.sxdl.sd.dao.dao1.SdPatientInfoDao;
import com.sxdl.sd.entity.SdInfoESRD-HD;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdInfoESRD-HDService;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SdInfoESRD-HDServiceImpl extends BaseServiceImpl<SdInfoESRD-HD> implements SdInfoESRD-HDService {
    @Autowired
    SdPatientInfoDao sdPatientInfoDao;
    @Autowired
    SdInfoESRD-HDDao  sdInfoESRD-HDDao;
    
    @Override
    public void insertOrUpdate(SdInfoESRD-HD sdInfoESRD-HD, SdPatientInfo sdPatientInfo) {
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
        }        if (sdInfoESRD-HD != null) {
            Integer id = sdInfoESRD-HD.getId ();
            if (null != id && !"".equals ( id ) && id > 0) { 
sdInfoESRD-HDDao.updateByPrimaryKeySelective ( sdInfoESRD-HD );
            } else {
                //病人不存在  新增
sdInfoESRD-HDDao.insertSelective (  sdInfoESRD-HD);
            }
        }
    }}