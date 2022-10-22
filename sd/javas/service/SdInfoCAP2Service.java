package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoCAP2;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoCAP2Service extends BaseService<SdInfoCAP2>{
 void insertOrUpdate(SdInfoCAP2 sdInfoCAP2, SdPatientInfo sdPatientInfo);
}