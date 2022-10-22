package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffMzkDao;
import com.sxdl.hmi.entity.HmiInputStaffMzkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffMzkService extends BaseServiceImpl<HmiInputStaffMzkEntity> {

    @Autowired
    private HmiInputStaffMzkDao hmiInputStaffMzkDao;

}
