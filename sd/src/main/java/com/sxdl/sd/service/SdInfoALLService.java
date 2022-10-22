package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoALL;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoALLService extends BaseService<SdInfoALL>{
 void insertOrUpdate(SdInfoALL sdInfoALL, SdPatientInfo sdPatientInfo);
}