package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffHlbDao;
import com.sxdl.hmi.entity.HmiInputStaffHlbEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffHlbService extends BaseUUIDServiceImpl<HmiInputStaffHlbEntity> {

    @Autowired
    private HmiInputStaffHlbDao hmiInputStaffYwkDao;

}
