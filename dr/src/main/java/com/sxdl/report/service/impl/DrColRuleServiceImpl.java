package com.sxdl.report.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.report.entity.DrColRule;
import com.sxdl.report.service.DrColRuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ColRuleService")
@Transactional
public class DrColRuleServiceImpl extends BaseServiceImpl<DrColRule> implements DrColRuleService {
}
