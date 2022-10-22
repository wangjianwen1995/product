package com.sxdl.report.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.report.entity.DrColumn;

public interface DrColumnService  extends BaseService<DrColumn>  {
    Integer deleteByPid(Integer id);
}
