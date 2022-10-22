package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoPIP;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoPIPService extends BaseService<SdInfoPIP>{
 void insertOrUpdate(SdInfoPIP sdInfoPIP, SdPatientInfo sdPatientInfo);
}