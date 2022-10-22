package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.product.dc.dao.dao1.DcVirtualTableDao;
import com.sxdl.product.dc.dbo.KeyValueDBO;
import com.sxdl.product.dc.entity.DcVirtualTable;
import com.sxdl.product.dc.service.DcVirtualTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dcVirtualTableService")
@Transactional
public class DcVirtualTableServiceImpl extends BaseUUIDServiceImpl<DcVirtualTable> implements DcVirtualTableService {

    @Autowired
    private  DcVirtualTableDao  dcVirtualTableDao;

    @Override
    public List<DcVirtualTable> selectByPid(DcVirtualTable dcVirtualTable) {

        List<DcVirtualTable> dcVirtualTableList = dcVirtualTableDao.select(dcVirtualTable);

        return dcVirtualTableList;
    }


    public List<KeyValueDBO> usedColumn(String id) {

        return dcVirtualTableDao.usedColumn(id);
    }
}
