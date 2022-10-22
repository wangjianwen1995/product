package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoCAC;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoCACService extends BaseService<SdInfoCAC>{
 void insertOrUpdate(SdInfoCAC sdInfoCAC, SdPatientInfo sdPatientInfo);
}