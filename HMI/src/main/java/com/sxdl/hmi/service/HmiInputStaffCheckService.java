package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffCheckDao;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffCheckService extends BaseServiceImpl<HmiInputStaffCheckEntity> {

    @Autowired
    private HmiInputStaffCheckDao hmiInputStaffCheckDao;

}
