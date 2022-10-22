package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffYwkDao;
import com.sxdl.hmi.entity.HmiInputStaffRskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffRskService extends BaseServiceImpl<HmiInputStaffRskEntity> {

    @Autowired
    private HmiInputStaffYwkDao hmiInputStaffRskDao;

}
