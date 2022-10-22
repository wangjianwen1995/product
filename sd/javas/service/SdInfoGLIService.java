package com.sxdl.sd.service;

import com.sxdl.sd.entity.SdInfoGLI;

import com.sxdl.base.service.BaseService;

import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoGLIService extends BaseService<SdInfoGLI>{
 void insertOrUpdate(SdInfoGLI sdInfoGLI, SdPatientInfo sdPatientInfo);
}