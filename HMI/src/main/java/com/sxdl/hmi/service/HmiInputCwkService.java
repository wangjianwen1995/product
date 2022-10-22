package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputCwkDao;
import com.sxdl.hmi.entity.HmiInputCwkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputCwkService extends BaseServiceImpl<HmiInputCwkEntity> {

    @Autowired
    private HmiInputCwkDao hmiInputCwkDao;

}
