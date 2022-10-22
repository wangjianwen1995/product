package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcProduct;

import java.util.List;

public interface DcProductService extends BaseService<DcProduct> {

    List<DcProduct> selectByExample(DcProduct product);

    List<DcProduct> selectByIds(String ids);
}
