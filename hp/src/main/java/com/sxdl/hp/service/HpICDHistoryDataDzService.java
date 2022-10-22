package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hp.dao.dao1.HpICDHistoryDataDzDao;
import com.sxdl.hp.entity.HpICDHistoricalDataDz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HpICDHistoryDataDzService extends BaseServiceImpl<HpICDHistoricalDataDz> {
    @Autowired
    HpICDHistoryDataDzDao hpICDHistoryDataDzDao;

    public Boolean saveDz(String version, String stime, String etime, String version_name)  {
        HpICDHistoricalDataDz hpICDHistoricalDataDz = new HpICDHistoricalDataDz();
        List<HpICDHistoricalDataDz> list = hpICDHistoryDataDzDao.selectSome(stime, etime);
        if (list == null || list.size() <= 0) {
            return false;
        }
        list.forEach(e -> {
            hpICDHistoricalDataDz.setReport_version(version);
            hpICDHistoricalDataDz.setUse_dm(e.getUse_dm());
            hpICDHistoricalDataDz.setUse_mc(e.getUse_mc());
            List<HpICDHistoricalDataDz> dzList = hpICDHistoryDataDzDao.select(hpICDHistoricalDataDz);
            if (dzList == null || dzList.size() <= 0) {
                e.setStatus("0");
                e.setReport_version(version);
                e.setReport_version_ch(version_name);
                e.setBm_stime(stime);
                e.setBm_etime(etime);
                hpICDHistoryDataDzDao.insertSelective(e);
            }
        });
        String sql = "update a set report_dm=b.code,report_mc=b.name,a.report_version='" + version + "',a.status='1' \n" +
                "from hp_history_icd_dz a,hp_bzdmk b where a.status='0' and  b.type=0 and b.version='" + version + "' and \n" +
                "((ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) and ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))) or(ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) )or(ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))))";
        //System.out.println(sql);
        int i = hpICDHistoryDataDzDao.updateSqlWithSQL(sql);
        if (i < 0) {
            return false;
        }
        return true;
    }
}
