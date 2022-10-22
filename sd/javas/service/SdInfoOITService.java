package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoOIT;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoOITService extends BaseService<SdInfoOIT>{
 void insertOrUpdate(SdInfoOIT sdInfoOIT, SdPatientInfo sdPatientInfo);
}