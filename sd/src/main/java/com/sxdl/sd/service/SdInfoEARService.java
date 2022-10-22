package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoEAR;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoEARService extends BaseService<SdInfoEAR>{
 void insertOrUpdate(SdInfoEAR sdInfoEAR, SdPatientInfo sdPatientInfo);
}
