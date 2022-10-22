package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoDKD;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoDKDService extends BaseService<SdInfoDKD>{
 void insertOrUpdate(SdInfoDKD sdInfoDKD, SdPatientInfo sdPatientInfo);
}