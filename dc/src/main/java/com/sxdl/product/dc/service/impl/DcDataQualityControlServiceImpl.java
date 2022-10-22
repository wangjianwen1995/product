package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.product.dc.dao.dao1.DcDataQualityControlDao;
import com.sxdl.product.dc.entity.DcDataQualityControl;
import com.sxdl.product.dc.service.DcDataQualityControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dcdataqualitycontrol")
@Transactional
public class DcDataQualityControlServiceImpl extends BaseUUIDServiceImpl<DcDataQualityControl> implements DcDataQualityControlService {

    @Autowired
    DcDataQualityControlDao dcDataQualityControlDao;


    @Override
    public List<DcDataQualityControl> findByTableId(String id) {
        DcDataQualityControl e = new DcDataQualityControl();
        e.setTable_id(id);
        List<DcDataQualityControl> select = dcDataQualityControlDao.select(e);
        return select;
    }
}
