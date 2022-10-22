package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoDVT;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoDVTService extends BaseService<SdInfoDVT>{
 void insertOrUpdate(SdInfoDVT sdInfoDVT, SdPatientInfo sdPatientInfo);
}