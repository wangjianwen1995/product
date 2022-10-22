package com.sxdl.product.dc.service;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcWarning;

public interface DcWarningService extends BaseService<DcWarning> {

    PageInfo selectBySome(PageInfo pageInfo, String startTime, String endTime, String schedule_id, String productId, String exec_id);
}
