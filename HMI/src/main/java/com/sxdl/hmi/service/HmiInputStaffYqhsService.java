package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffYqhsDao;
import com.sxdl.hmi.entity.HmiInputBqhsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffYqhsService extends BaseServiceImpl<HmiInputBqhsEntity> {

    @Autowired
    private HmiInputStaffYqhsDao hmiInputStaffYqhsDao;

}
