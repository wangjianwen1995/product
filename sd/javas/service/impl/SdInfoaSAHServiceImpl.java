package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdInfoaSAHDao;
import com.sxdl.sd.dao.dao1.SdPatientInfoDao;
import com.sxdl.sd.entity.SdInfoaSAH;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdInfoaSAHService;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SdInfoaSAHServiceImpl extends BaseServiceImpl<SdInfoaSAH> implements SdInfoaSAHService {
    @Autowired
    SdPatientInfoDao sdPatientInfoDao;
    @Autowired
    SdInfoaSAHDao  sdInfoaSAHDao;
    
    @Override
    public void insertOrUpdate(SdInfoaSAH sdInfoaSAH, SdPatientInfo sdPatientInfo) {
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
        }        if (sdInfoaSAH != null) {
            Integer id = sdInfoaSAH.getId ();
            if (null != id && !"".equals ( id ) && id > 0) { 
sdInfoaSAHDao.updateByPrimaryKeySelective ( sdInfoaSAH );
            } else {
                //病人不存在  新增
sdInfoaSAHDao.insertSelective (  sdInfoaSAH);
            }
        }
    }}