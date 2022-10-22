package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoCSE;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoCSEService extends BaseService<SdInfoCSE>{
 void insertOrUpdate(SdInfoCSE sdInfoCSE, SdPatientInfo sdPatientInfo);
}