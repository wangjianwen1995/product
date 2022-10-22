package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.product.dc.dao.dao1.DcOverallQualityControlDao;
import com.sxdl.product.dc.entity.DcOverallQualityControl;
import com.sxdl.product.dc.service.DcOverallQualityControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dcoverallqualitycontrol")
@Transactional
public class DcOverallQualityControlServiceImpl extends BaseUUIDServiceImpl<DcOverallQualityControl> implements DcOverallQualityControlService {

    @Autowired
    DcOverallQualityControlDao dcOverallQualityControlDao;


    @Override
    public List<DcOverallQualityControl> findByTableId(String id) {
        DcOverallQualityControl e = new DcOverallQualityControl();
        e.setTable_id(id);
        List<DcOverallQualityControl> select = dcOverallQualityControlDao.select(e);
        return select;
    }
}
