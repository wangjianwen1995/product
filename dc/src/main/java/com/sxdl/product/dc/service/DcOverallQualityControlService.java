package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcOverallQualityControl;

import java.util.List;

public interface DcOverallQualityControlService extends BaseService<DcOverallQualityControl> {

    List<DcOverallQualityControl> findByTableId(String id);
}
