package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoDDH;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoDDHService extends BaseService<SdInfoDDH>{
 void insertOrUpdate(SdInfoDDH sdInfoDDH, SdPatientInfo sdPatientInfo);
}