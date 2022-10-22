package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoCABG;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoCABGService extends BaseService<SdInfoCABG>{
 void insertOrUpdate(SdInfoCABG sdInfoCABG, SdPatientInfo sdPatientInfo);
}