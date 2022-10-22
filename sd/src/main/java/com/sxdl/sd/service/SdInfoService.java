package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfo;

import java.util.List;

public interface SdInfoService extends BaseService<SdInfo> {
    List<SdInfo> findAllSd();
}
