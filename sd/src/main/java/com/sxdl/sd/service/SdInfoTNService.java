package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoTN;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoTNService extends BaseService<SdInfoTN>{
 void insertOrUpdate(SdInfoTN sdInfoTN, SdPatientInfo sdPatientInfo);
}