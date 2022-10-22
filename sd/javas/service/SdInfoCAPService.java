package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoCAP;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoCAPService extends BaseService<SdInfoCAP>{
 void insertOrUpdate(SdInfoCAP sdInfoCAP, SdPatientInfo sdPatientInfo);
}