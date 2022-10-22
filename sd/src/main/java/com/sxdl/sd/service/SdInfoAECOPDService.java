package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoAECOPD;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoAECOPDService extends BaseService<SdInfoAECOPD>{
 void insertOrUpdate(SdInfoAECOPD sdInfoAECOPD, SdPatientInfo sdPatientInfo);
}