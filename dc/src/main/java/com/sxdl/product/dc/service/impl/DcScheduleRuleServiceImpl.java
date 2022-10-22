package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.product.dc.entity.DcScheduleRule;
import com.sxdl.product.dc.service.DcScheduleRuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dcScheduleRuleService")
@Transactional
public class DcScheduleRuleServiceImpl extends BaseServiceImpl<DcScheduleRule> implements DcScheduleRuleService {

}
