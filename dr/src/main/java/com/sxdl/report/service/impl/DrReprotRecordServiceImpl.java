package com.sxdl.report.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.report.dao.dao1.DrReprotRecordDao;
import com.sxdl.report.entity.DrReprotRecord;
import com.sxdl.report.service.DrReprotRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;

@Service("drColRuleService")
@Transactional
public class DrReprotRecordServiceImpl extends BaseServiceImpl<DrReprotRecord> implements DrReprotRecordService {

    @Autowired
    DrReprotRecordDao drReprotRecordDao;

    @Override
    public List<LinkedHashMap<String, Object>> getExcelData(String sql) {
        return drReprotRecordDao.getExcelData(sql);
    }
}
