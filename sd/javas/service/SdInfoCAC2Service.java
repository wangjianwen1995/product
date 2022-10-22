package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoCAC2;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoCAC2Service extends BaseService<SdInfoCAC2>{
 void insertOrUpdate(SdInfoCAC2 sdInfoCAC2, SdPatientInfo sdPatientInfo);
}