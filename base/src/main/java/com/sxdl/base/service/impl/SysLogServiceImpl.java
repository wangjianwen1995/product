package com.sxdl.base.service.impl;

import com.sxdl.base.entity.SysLog;
import com.sxdl.base.service.SysLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysLogServiceImpl extends BaseServiceImpl<SysLog> implements SysLogService {
}
