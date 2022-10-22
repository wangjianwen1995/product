package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoSAP;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoSAPService extends BaseService<SdInfoSAP> {
    void insertOrUpdate(SdInfoSAP sdInfoSAP, SdPatientInfo sdPatientInfo);
}
