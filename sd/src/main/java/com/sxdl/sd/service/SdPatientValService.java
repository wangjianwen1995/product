package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.entity.SdPatientVal;

import java.util.List;

public interface SdPatientValService extends BaseService<SdPatientVal> {
    void insertOrUpdate(List<SdPatientVal> list, SdPatientInfo sdPatientInfo);
}
