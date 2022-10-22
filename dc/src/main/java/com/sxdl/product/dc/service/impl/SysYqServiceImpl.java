package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.product.dc.entity.SysYq;
import com.sxdl.product.dc.service.SysYqService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sysYqService")
@Transactional
public class SysYqServiceImpl extends BaseServiceImpl<SysYq> implements SysYqService {

}
