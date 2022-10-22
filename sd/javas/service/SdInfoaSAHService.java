package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoaSAH;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoaSAHService extends BaseService<SdInfoaSAH>{
 void insertOrUpdate(SdInfoaSAH sdInfoaSAH, SdPatientInfo sdPatientInfo);
}