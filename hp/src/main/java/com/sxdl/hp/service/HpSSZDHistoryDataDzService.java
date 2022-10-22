package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hp.dao.dao1.HpSSZDHistoryDataDzDao;
import com.sxdl.hp.entity.HpSSZDHistoricalDataDz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HpSSZDHistoryDataDzService extends BaseServiceImpl<HpSSZDHistoricalDataDz> {
    @Autowired
    HpSSZDHistoryDataDzDao hpSSZDHistoryDataDzDao;

    public Boolean saveDz(String version, String stime, String etime, String version_name)  {
        HpSSZDHistoricalDataDz hpSSZDHistoricalDataDz = new HpSSZDHistoricalDataDz();
        List<HpSSZDHistoricalDataDz> list = hpSSZDHistoryDataDzDao.selectSome(stime, etime);
        if (list == null || list.size() <= 0) {
            return false;
        }
        list.forEach(e -> {
            hpSSZDHistoricalDataDz.setReport_version(version);
            hpSSZDHistoricalDataDz.setUse_dm(e.getUse_dm());
            hpSSZDHistoricalDataDz.setUse_mc(e.getUse_mc());
            List<HpSSZDHistoricalDataDz> dzList = hpSSZDHistoryDataDzDao.select(hpSSZDHistoricalDataDz);
            if (dzList == null || dzList.size() <= 0) {
                e.setStatus("0");
                e.setReport_version(version);
                e.setReport_version_ch(version_name);
                e.setBm_stime(stime);
                e.setBm_etime(etime);
                hpSSZDHistoryDataDzDao.insert(e);
            }
        });
        String sql = "update a set report_dm=b.code,report_mc=b.name,a.report_version='" + version + "',a.status='1' \n" +
                "from hp_history_sszd_dz a,hp_bzdmk b where a.status='0' and  b.type=3 and b.version='" + version + "' and \n" +
                "((ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) and ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))) or(ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) )or(ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))))";
        int i = hpSSZDHistoryDataDzDao.updateSqlWithSQL(sql);

        if (i < 0) {
            return false;
        }
        return true;
    }
}
