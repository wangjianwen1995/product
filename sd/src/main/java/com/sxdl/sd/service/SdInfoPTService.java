package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoPT;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoPTService extends BaseService<SdInfoPT>{
 void insertOrUpdate(SdInfoPT sdInfoPT, SdPatientInfo sdPatientInfo);
}