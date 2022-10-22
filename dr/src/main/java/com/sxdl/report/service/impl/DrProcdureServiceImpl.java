package com.sxdl.report.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.report.entity.DrProcdure;
import com.sxdl.report.service.DrProcdureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("drProcdureService")
@Transactional
public class DrProcdureServiceImpl  extends BaseServiceImpl<DrProcdure> implements DrProcdureService {
}
