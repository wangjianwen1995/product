package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoASD;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoASDService extends BaseService<SdInfoASD>{
 void insertOrUpdate(SdInfoASD sdInfoASD, SdPatientInfo sdPatientInfo);
}