package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.product.dc.entity.DcLogError;
import com.sxdl.product.dc.service.DcLogErrorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dcLogErrorService")
@Transactional
public class DcLogErrorServiceImpl extends BaseServiceImpl<DcLogError> implements DcLogErrorService {
}
