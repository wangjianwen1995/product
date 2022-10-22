package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.product.dc.entity.SysGroupKs;
import com.sxdl.product.dc.service.SysGroupKsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysGroupKsService")
@Transactional
public class SysGroupKsServiceImpl extends BaseServiceImpl<SysGroupKs> implements SysGroupKsService {

}
