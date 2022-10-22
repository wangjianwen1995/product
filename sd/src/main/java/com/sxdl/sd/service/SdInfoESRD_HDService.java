package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoESRD_HD;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoESRD_HDService extends BaseService<SdInfoESRD_HD>{
 void insertOrUpdate(SdInfoESRD_HD sdInfoESRD_HD, SdPatientInfo sdPatientInfo);
}
