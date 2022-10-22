package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoVSD;
import com.sxdl.sd.entity.SdPatientInfo;

public interface SdInfoVSDService extends BaseService<SdInfoVSD>{
 void insertOrUpdate(SdInfoVSD sdInfoVSD, SdPatientInfo sdPatientInfo);
}