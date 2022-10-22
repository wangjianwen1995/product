package com.sxdl.report.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.report.dao.dao1.DrColumnDao;
import com.sxdl.report.entity.DrColumn;
import com.sxdl.report.service.DrColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("drColumnService")
@Transactional
public class DrColumnServiceImpl extends BaseServiceImpl<DrColumn> implements DrColumnService {

    @Autowired
    private DrColumnDao drColumnDao;

    @Override
    public Integer deleteByPid(Integer id) {
         drColumnDao.deleByPid(id);
        return 1;
    }
}
