package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputKjkLcjszhDao;
import com.sxdl.hmi.entity.HmiInputKjkLcjszhEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputKjkLcjszhService extends BaseServiceImpl<HmiInputKjkLcjszhEntity> {

    @Autowired
    private HmiInputKjkLcjszhDao hmiInputKjkLcjszhDao;

}
