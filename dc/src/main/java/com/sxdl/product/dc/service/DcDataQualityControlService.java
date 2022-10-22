package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcDataQualityControl;

import java.util.List;

public interface DcDataQualityControlService extends BaseService<DcDataQualityControl> {

    List<DcDataQualityControl> findByTableId(String id);
}
