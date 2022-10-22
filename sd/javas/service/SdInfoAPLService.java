package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoAPL;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoAPLService extends BaseService<SdInfoAPL>{
 void insertOrUpdate(SdInfoAPL sdInfoAPL, SdPatientInfo sdPatientInfo);
}