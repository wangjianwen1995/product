package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoARDS;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoARDSService extends BaseService<SdInfoARDS>{
 void insertOrUpdate(SdInfoARDS sdInfoARDS, SdPatientInfo sdPatientInfo);
}
