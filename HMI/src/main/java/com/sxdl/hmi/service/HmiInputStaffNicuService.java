package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffNicuDao;
import com.sxdl.hmi.entity.HmiInputStaffNicuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffNicuService extends BaseServiceImpl<HmiInputStaffNicuEntity> {

    @Autowired
    private HmiInputStaffNicuDao hmiInputStaffNicuDao;

}
