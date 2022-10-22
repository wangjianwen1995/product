package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoMEN;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoMENService extends BaseService<SdInfoMEN>{
 void insertOrUpdate(SdInfoMEN sdInfoMEN, SdPatientInfo sdPatientInfo);
}