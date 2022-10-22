package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoHBIPS;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoHBIPSService extends BaseService<SdInfoHBIPS>{
 void insertOrUpdate(SdInfoHBIPS sdInfoHBIPS, SdPatientInfo sdPatientInfo);
}