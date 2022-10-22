package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffJzkDao;
import com.sxdl.hmi.entity.HmiInputStaffJzkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffJzkService extends BaseServiceImpl<HmiInputStaffJzkEntity> {

    @Autowired
    private HmiInputStaffJzkDao hmiInputStaffJzkDao;

}
