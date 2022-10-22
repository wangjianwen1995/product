package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.DcConversion;

public interface DcConversionService extends BaseService<DcConversion> {
    void insertOrUpdate(DcConversion dcConversion);

    ResultUtil deleteByDcConversion(String table_id);
}
