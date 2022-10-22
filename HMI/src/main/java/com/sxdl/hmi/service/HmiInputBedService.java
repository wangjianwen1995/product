package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputBedDao;
import com.sxdl.hmi.entity.HmiInputBedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputBedService extends BaseServiceImpl<HmiInputBedEntity> {

    @Autowired
    private HmiInputBedDao hmiInputBedDao;

}
