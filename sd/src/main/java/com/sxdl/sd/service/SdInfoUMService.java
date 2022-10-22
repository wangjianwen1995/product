package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoUM;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoUMService extends BaseService<SdInfoUM>{
 void insertOrUpdate(SdInfoUM sdInfoUM, SdPatientInfo sdPatientInfo);
}