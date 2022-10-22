package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffZykDao;
import com.sxdl.hmi.entity.HmiInputStaffZykEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffZykService extends BaseServiceImpl<HmiInputStaffZykEntity> {

    @Autowired
    private HmiInputStaffZykDao hmiInputStaffZykDao;

}
