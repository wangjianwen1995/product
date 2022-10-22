package com.sxdl.report.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.report.dao.dao1.DrReturnDao;
import com.sxdl.report.entity.DrReturn;
import com.sxdl.report.service.DrReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("drReturnService")
@Transactional
public class DrReturnServiceImpl extends BaseServiceImpl<DrReturn> implements DrReturnService {

    @Autowired
    private DrReturnDao drReturnDao;

    public List<DrReturn> findAllDesc() {
        return drReturnDao.findAllDesc();
    }
}
