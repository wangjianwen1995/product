package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoRD;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoRDService extends BaseService<SdInfoRD>{
 void insertOrUpdate(SdInfoRD sdInfoRD, SdPatientInfo sdPatientInfo);
}