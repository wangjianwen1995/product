package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoGC;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoGCService extends BaseService<SdInfoGC>{
 void insertOrUpdate(SdInfoGC sdInfoGC, SdPatientInfo sdPatientInfo);
}