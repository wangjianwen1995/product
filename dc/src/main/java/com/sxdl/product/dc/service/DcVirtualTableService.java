package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcVirtualTable;

import java.util.List;

public interface DcVirtualTableService extends BaseService<DcVirtualTable> {

    List<DcVirtualTable> selectByPid(DcVirtualTable dcVirtualTable);
}
