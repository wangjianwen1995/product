package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoTSCC;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoTSCCService extends BaseService<SdInfoTSCC>{
 void insertOrUpdate(SdInfoTSCC sdInfoTSCC, SdPatientInfo sdPatientInfo);
}