package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SdInfoSource;

import java.util.List;

public interface SdInfoSourceService extends BaseService<SdInfoSource> {
    List<SdInfoSource> finByName(String name, String cdate, String edate);
}
