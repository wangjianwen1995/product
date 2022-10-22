package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoPD;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoPDService extends BaseService<SdInfoPD>{
 void insertOrUpdate(SdInfoPD sdInfoPD, SdPatientInfo sdPatientInfo);
}