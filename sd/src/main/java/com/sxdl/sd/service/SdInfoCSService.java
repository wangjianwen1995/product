package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoCS;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoCSService extends BaseService<SdInfoCS>{
 void insertOrUpdate(SdInfoCS sdInfoCS, SdPatientInfo sdPatientInfo);
}