package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoCoC;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoCoCService extends BaseService<SdInfoCoC>{
 void insertOrUpdate(SdInfoCoC sdInfoCoC, SdPatientInfo sdPatientInfo);
}