package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoESRD-PD;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoESRD-PDService extends BaseService<SdInfoESRD-PD>{
 void insertOrUpdate(SdInfoESRD-PD sdInfoESRD-PD, SdPatientInfo sdPatientInfo);
}