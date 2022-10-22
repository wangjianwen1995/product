package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hp.dao.dao1.HpZYBZFHistoryDataDzDao;
import com.sxdl.hp.entity.HpZYBZFHistoricalDataDz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class HpZYBZFHistoryDataDzService extends BaseServiceImpl<HpZYBZFHistoricalDataDz> {
    @Autowired
    HpZYBZFHistoryDataDzDao hpZYBZFHistoryDataDzDao;

    public Boolean saveDz(String version, String stime, String etime, String version_name)  {
        HpZYBZFHistoricalDataDz hpZYBZFHistoricalDataDz = new HpZYBZFHistoricalDataDz();
        List<HpZYBZFHistoricalDataDz> list = hpZYBZFHistoryDataDzDao.selectSome(stime, etime);
        if (list == null || list.size() <= 0 || list.isEmpty()) {
            return false;
        }
        list.forEach(e -> {
            hpZYBZFHistoricalDataDz.setReport_version(version);
            hpZYBZFHistoricalDataDz.setUse_dm(e.getUse_dm());
            hpZYBZFHistoricalDataDz.setUse_mc(e.getUse_mc());
            List<HpZYBZFHistoricalDataDz> dzList = hpZYBZFHistoryDataDzDao.select(hpZYBZFHistoricalDataDz);
            Set<HpZYBZFHistoricalDataDz> set = new HashSet<>();

            if (dzList == null || dzList.size() <= 0 || dzList.isEmpty()) {
                e.setStatus("0");
                e.setReport_version(version);
                e.setReport_version_ch(version);
                e.setBm_stime(stime);
                e.setBm_etime(etime);
                hpZYBZFHistoryDataDzDao.insert(e);
            }
        });
        String sql = "update a set report_dm=b.code,report_mc=b.name,a.report_version='" + version + "',a.status='1' \n" +
                "from hp_history_zybzf_dz a,hp_bzdmk b where a.status='0' and  b.type=4 and b.version='" + version + "' and \n" +
                "((ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) and ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))) or(ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) )or(ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))))";
        int i = hpZYBZFHistoryDataDzDao.updateSqlWithSQL(sql);
        if (i < 0) {
            return false;
        }
        return true;
    }
}
