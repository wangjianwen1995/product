package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputKjkHqlczlDao;
import com.sxdl.hmi.entity.HmiInputKjkHqlczlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputKjkHqlczlService extends BaseServiceImpl<HmiInputKjkHqlczlEntity> {

    @Autowired
    private HmiInputKjkHqlczlDao hmiInputKjkHqlczlDao;

}
