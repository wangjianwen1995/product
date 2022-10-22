package com.sxdl.base.service;

import com.sxdl.base.entity.SysDictTable;
import com.sxdl.base.entity.SysDictVal;

import java.util.List;

public interface SysDictTableService extends BaseService<SysDictTable> {


    void updateDT(SysDictTable dcDitTable, List<SysDictVal> dcDitVals);

    void updateAppDcDitTable();

    void insertDT(SysDictTable dcDitTable);
}
