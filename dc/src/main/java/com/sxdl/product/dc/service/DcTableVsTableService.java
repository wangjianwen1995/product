package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcProcedure;
import com.sxdl.product.dc.entity.DcTableVsTable;

import java.util.List;

public interface DcTableVsTableService extends BaseService<DcTableVsTable> {
    List<DcTableVsTable> findByReplaceTableId(String id);

    List<DcTableVsTable> selectByPid(DcTableVsTable dcTableVsTable);

    List<DcTableVsTable> findByToTableId(String id);

    String testProcedure(DcProcedure dcProcedure);
}
