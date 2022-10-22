package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffRskDao;
import com.sxdl.hmi.entity.HmiInputStaffYwkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffYwkService extends BaseServiceImpl<HmiInputStaffYwkEntity> {

    @Autowired
    private HmiInputStaffRskDao hmiInputStaffYwkDao;

}
