package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hp.dao.dao1.HpTumourHistoryDataDzDao;
import com.sxdl.hp.entity.HpTumourHistoricalDataDz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HpTumourHistoryDataDzService extends BaseServiceImpl<HpTumourHistoricalDataDz> {
    @Autowired
    HpTumourHistoryDataDzDao hpTumourHistoryDataDzDao;

    public Boolean saveDz(String version, String stime, String etime, String version_name)  {
        HpTumourHistoricalDataDz hpTumourHistoricalDataDz = new HpTumourHistoricalDataDz();
        List<HpTumourHistoricalDataDz> list = hpTumourHistoryDataDzDao.selectSome(stime, etime);
        if (list == null || list.size() <= 0) {
            return false;
        }
        list.forEach(e -> {
            hpTumourHistoricalDataDz.setReport_version(version);
            hpTumourHistoricalDataDz.setUse_dm(e.getUse_dm());
            hpTumourHistoricalDataDz.setUse_mc(e.getUse_mc());
            List<HpTumourHistoricalDataDz> dzList = hpTumourHistoryDataDzDao.select(hpTumourHistoricalDataDz);
            if (dzList == null || dzList.size() <= 0) {
                e.setStatus("0");
                e.setReport_version(version);
                e.setReport_version_ch(version_name);
                e.setBm_stime(stime);
                e.setBm_etime(etime);
                hpTumourHistoryDataDzDao.insert(e);
            }
        });
        String sql = "update a set report_dm=b.code,report_mc=b.name,a.report_version='" + version + "',a.status='1' \n" +
                "from hp_history_tumour_dz a,hp_bzdmk b where a.status='0' and  b.type=2 and b.version='" + version + "' and \n" +
                "((ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) and ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))) or(ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) )or(ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))))";
        int i = hpTumourHistoryDataDzDao.updateSqlWithSQL(sql);
        if (i < 0) {
            return false;
        }
        return true;

    }
}
