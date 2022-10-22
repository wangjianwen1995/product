package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoAVR;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoAVRService extends BaseService<SdInfoAVR>{
 void insertOrUpdate(SdInfoAVR sdInfoAVR, SdPatientInfo sdPatientInfo);
}