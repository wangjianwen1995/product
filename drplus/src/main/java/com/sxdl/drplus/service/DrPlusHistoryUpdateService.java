package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.DrPlusHistoryUpdateDao;
import com.sxdl.drplus.dto.PatientDataDBO;
import com.sxdl.drplus.entity.DrPlusHistoryUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DrPlusHistoryUpdateService extends BaseServiceImpl<DrPlusHistoryUpdate> {

    @Autowired
    private DrPlusHistoryUpdateDao historyUpdateDao;


    /***
     *  没有删除这么一说 所有的操作都应该被记录 下来
     * @param patientDataDBO
     */
    public void saveHistoryPatient(PatientDataDBO patientDataDBO ) {
        List<DrPlusHistoryUpdate> updates = patientDataDBO.getUpdates();
        for (DrPlusHistoryUpdate historyUpdate : updates) {
            int insert = historyUpdateDao.insert(historyUpdate);
        }
    }

    public List<DrPlusHistoryUpdate> getPatientOneHistoryUpdate(Integer pid, String bah) {
        return historyUpdateDao.getPatientOneHistoryUpdate(pid,bah);
    }
}
