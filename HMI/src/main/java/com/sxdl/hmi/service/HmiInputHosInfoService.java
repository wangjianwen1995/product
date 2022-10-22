package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputHosInfoDao;
import com.sxdl.hmi.entity.HmiInputHosInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputHosInfoService extends BaseUUIDServiceImpl<HmiInputHosInfoEntity> {

    @Autowired
    private HmiInputHosInfoDao hmiInputHosInfoDao;

}
