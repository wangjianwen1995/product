package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoSEP;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoSEPService extends BaseService<SdInfoSEP>{
 void insertOrUpdate(SdInfoSEP sdInfoSEP, SdPatientInfo sdPatientInfo);
}