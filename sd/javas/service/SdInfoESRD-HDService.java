package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoESRD-HD;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoESRD-HDService extends BaseService<SdInfoESRD-HD>{
 void insertOrUpdate(SdInfoESRD-HD sdInfoESRD-HD, SdPatientInfo sdPatientInfo);
}