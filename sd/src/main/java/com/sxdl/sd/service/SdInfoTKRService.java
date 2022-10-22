package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoTKR;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoTKRService extends BaseService<SdInfoTKR>{
 void insertOrUpdate(SdInfoTKR sdInfoTKR, SdPatientInfo sdPatientInfo);
}