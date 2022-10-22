package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoPA;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoPAService extends BaseService<SdInfoPA>{
 void insertOrUpdate(SdInfoPA sdInfoPA, SdPatientInfo sdPatientInfo);
}