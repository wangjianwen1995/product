package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoHF;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoHFService extends BaseService<SdInfoHF>{
 void insertOrUpdate(SdInfoHF sdInfoHF, SdPatientInfo sdPatientInfo);
}