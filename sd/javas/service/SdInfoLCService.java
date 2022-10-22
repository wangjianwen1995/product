package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoLC;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoLCService extends BaseService<SdInfoLC>{
 void insertOrUpdate(SdInfoLC sdInfoLC, SdPatientInfo sdPatientInfo);
}