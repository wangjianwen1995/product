package com.sxdl.product.dc.service;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcTarget;

public interface DcTargetService extends BaseService<DcTarget> {

    PageInfo likeFind(PageInfo pageInfo, String name);
}
