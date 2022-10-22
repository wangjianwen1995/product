package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoTHR;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoTHRService extends BaseService<SdInfoTHR>{
 void insertOrUpdate(SdInfoTHR sdInfoTHR, SdPatientInfo sdPatientInfo);
}