package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.dbo.CreatTableDBO;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcTable;
import com.sxdl.product.dc.entity.DcTransfer;

import java.util.List;

public interface DcTableService extends BaseService<DcTable> {

    DcTable selectByName (String name);

    void deleteWB(List<DcTable> dcTableList);

    void insertWB(DcTable dcTable, List<String> pid);

    List<DcTable> selectByNameAndProdect(String name, String i, String i1);

    void updateWB(DcTable DcTable,List<DcColumn> dcColumnList);

    List<DcTable> selectByName2(String name);

    @Override
    List<DcTable> findAll();

    List<DcTable> findAllByDcTable(DcTable dcTable);


    void creatTC(CreatTableDBO dbo, DcTransfer tsf);
}
