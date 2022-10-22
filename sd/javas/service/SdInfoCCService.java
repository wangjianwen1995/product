package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoCC;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoCCService extends BaseService<SdInfoCC>{
 void insertOrUpdate(SdInfoCC sdInfoCC, SdPatientInfo sdPatientInfo);
}