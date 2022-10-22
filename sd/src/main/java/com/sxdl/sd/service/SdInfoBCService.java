package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoBC;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoBCService extends BaseService<SdInfoBC>{
 void insertOrUpdate(SdInfoBC sdInfoBC, SdPatientInfo sdPatientInfo);
}