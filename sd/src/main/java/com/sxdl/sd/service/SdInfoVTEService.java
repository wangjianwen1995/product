package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoVTE;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoVTEService extends BaseService<SdInfoVTE>{
 void insertOrUpdate(SdInfoVTE sdInfoVTE, SdPatientInfo sdPatientInfo);
}