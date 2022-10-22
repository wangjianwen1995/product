package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffIcuDao;
import com.sxdl.hmi.entity.HmiInputStaffIcuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffIcuService extends BaseServiceImpl<HmiInputStaffIcuEntity> {

    @Autowired
    private HmiInputStaffIcuDao hmiInputStaffIcuDao;

}
