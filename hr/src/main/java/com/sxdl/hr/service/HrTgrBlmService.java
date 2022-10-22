package com.sxdl.hr.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.hr.entity.TgrBlmEntity;

import java.util.List;

public interface HrTgrBlmService  extends BaseService<TgrBlmEntity> {

    List<TgrBlmEntity> findByDcgid(String dcgid);
}
