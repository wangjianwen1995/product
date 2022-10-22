package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffCcuDao;
import com.sxdl.hmi.entity.HmiInputStaffCcuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffCcuService extends BaseServiceImpl<HmiInputStaffCcuEntity> {

    @Autowired
    private HmiInputStaffCcuDao hmiInputStaffCcuDao;

}
