package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoTC;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoTCService extends BaseService<SdInfoTC>{
 void insertOrUpdate(SdInfoTC sdInfoTC, SdPatientInfo sdPatientInfo);
}