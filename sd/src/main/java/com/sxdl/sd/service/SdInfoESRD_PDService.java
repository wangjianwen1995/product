package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoESRD_PD;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoESRD_PDService extends BaseService<SdInfoESRD_PD>{
 void insertOrUpdate(SdInfoESRD_PD sdInfoESRD_PD, SdPatientInfo sdPatientInfo);
}