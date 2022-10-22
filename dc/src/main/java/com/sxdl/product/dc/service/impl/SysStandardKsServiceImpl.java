package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.product.dc.entity.SysStandardKs;
import com.sxdl.product.dc.service.SysStandardKsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysStandardKsService")
@Transactional
public class SysStandardKsServiceImpl extends BaseServiceImpl<SysStandardKs> implements SysStandardKsService {

}
