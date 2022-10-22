package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoAPTE;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoAPTEService extends BaseService<SdInfoAPTE>{
 void insertOrUpdate(SdInfoAPTE sdInfoAPTE, SdPatientInfo sdPatientInfo);
}
