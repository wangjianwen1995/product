package com.sxdl.product.dc.service;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcEtlLog;

import java.util.List;

public interface DcEtlLogService  extends BaseService<DcEtlLog> {
    List<DcEtlLog>  findByFactor(String str);

    PageInfo selectBySome(PageInfo pageInfo, String startTime,String endTime, Integer status, String productId,String name);

    Boolean selectByPro(String prent_procedure_id,String batch);

    String selecsql(String sql);

}
