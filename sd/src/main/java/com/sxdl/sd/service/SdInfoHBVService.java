package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoHBV;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoHBVService extends BaseService<SdInfoHBV>{
 void insertOrUpdate(SdInfoHBV sdInfoHBV, SdPatientInfo sdPatientInfo);
}