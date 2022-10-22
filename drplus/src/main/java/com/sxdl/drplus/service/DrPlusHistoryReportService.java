package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.DrPlusHistoryReportDao;
import com.sxdl.drplus.entity.DrPlusHistoryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Deprecated
public class DrPlusHistoryReportService extends BaseServiceImpl<DrPlusHistoryReport> {

    @Autowired
    private DrPlusHistoryReportDao historyReportDao;

    public List<DrPlusHistoryReport> getHistoryReportResult(Integer pid, String stime, String etime) {
        return historyReportDao.getHistoryReportResult(pid,stime,etime);
    }
}
