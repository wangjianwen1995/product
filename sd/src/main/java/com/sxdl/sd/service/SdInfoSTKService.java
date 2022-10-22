package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoSTK;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoSTKService extends BaseService<SdInfoSTK>{
 void insertOrUpdate(SdInfoSTK sdInfoSTK, SdPatientInfo sdPatientInfo);
}