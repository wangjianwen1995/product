package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffGrkDao;
import com.sxdl.hmi.entity.HmiInputStaffGrkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffGrkService extends BaseServiceImpl<HmiInputStaffGrkEntity> {

    @Autowired
    private HmiInputStaffGrkDao hmiInputStaffGrkDao;

}
