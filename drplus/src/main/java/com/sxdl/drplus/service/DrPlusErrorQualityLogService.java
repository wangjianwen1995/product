package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.drplus.dao1.DrPlusErrorQualityLogDao;
import com.sxdl.drplus.entity.DrPlusErrorQualityLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DrPlusErrorQualityLogService extends BaseUUIDServiceImpl<DrPlusErrorQualityLog> {

    @Autowired
    private DrPlusErrorQualityLogDao errorQualityLogDao;


}
