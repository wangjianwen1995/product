package com.sxdl.hmi.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hmi.dao.dao1.HmiInputStaffRicuDao;
import com.sxdl.hmi.entity.HmiInputStaffRicuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HmiInputStaffRicuService extends BaseServiceImpl<HmiInputStaffRicuEntity> {

    @Autowired
    private HmiInputStaffRicuDao hmiInputStaffRicuDao;

}
