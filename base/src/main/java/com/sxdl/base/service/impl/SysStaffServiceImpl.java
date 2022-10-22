package com.sxdl.base.service.impl;

import com.sxdl.base.entity.SysStaff;
import com.sxdl.base.service.SysStaffService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysStaffService")
@Transactional
public class SysStaffServiceImpl extends BaseServiceImpl<SysStaff> implements SysStaffService {

}
