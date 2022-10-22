package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoMVR;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoMVRService extends BaseService<SdInfoMVR>{
 void insertOrUpdate(SdInfoMVR sdInfoMVR, SdPatientInfo sdPatientInfo);
}