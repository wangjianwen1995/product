package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoAF;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoAFService extends BaseService<SdInfoAF>{
 void insertOrUpdate(SdInfoAF sdInfoAF, SdPatientInfo sdPatientInfo);
}