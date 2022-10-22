package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoTIA;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoTIAService extends BaseService<SdInfoTIA>{
 void insertOrUpdate(SdInfoTIA sdInfoTIA, SdPatientInfo sdPatientInfo);
}