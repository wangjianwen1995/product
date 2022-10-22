package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoICH;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoICHService extends BaseService<SdInfoICH>{
 void insertOrUpdate(SdInfoICH sdInfoICH, SdPatientInfo sdPatientInfo);
}