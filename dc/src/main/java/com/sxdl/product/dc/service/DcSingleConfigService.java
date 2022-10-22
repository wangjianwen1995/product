package com.sxdl.product.dc.service;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcSingleConfig;

import java.util.List;

public interface DcSingleConfigService extends BaseService<DcSingleConfig> {


    PageInfo selectBySome(PageInfo pageInfo, String name, String product_id);

    void deleteSomeById(String id);

    List<DcSingleConfig> selectByProduct(String ids);
}
