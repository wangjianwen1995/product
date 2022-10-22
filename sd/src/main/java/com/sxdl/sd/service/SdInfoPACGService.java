package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoPACG;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoPACGService extends BaseService<SdInfoPACG>{
 void insertOrUpdate(SdInfoPACG sdInfoPACG, SdPatientInfo sdPatientInfo);
}