package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoSTEMI;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoSTEMIService extends BaseService<SdInfoSTEMI>{
 void insertOrUpdate(SdInfoSTEMI sdInfoSTEMI, SdPatientInfo sdPatientInfo);
}