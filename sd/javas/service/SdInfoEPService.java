package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoEP;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoEPService extends BaseService<SdInfoEP>{
 void insertOrUpdate(SdInfoEP sdInfoEP, SdPatientInfo sdPatientInfo);
}