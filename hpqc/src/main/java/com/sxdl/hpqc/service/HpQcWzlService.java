package com.sxdl.hpqc.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.hpqc.dao.dao1.HpQcPfDao;
import com.sxdl.hpqc.dao.dao1.HpQcWzlDao;
import com.sxdl.hpqc.dao.dao1.ZkTempDao;
import com.sxdl.hpqc.entity.HpQcWzlEntity;
import com.sxdl.hpqc.entity.ZkTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class HpQcWzlService extends BaseServiceImpl<HpQcWzlEntity> {


    @Autowired
    HpQcPfDao hpQcPfDao;
    @Autowired
    HpQcWzlDao hpQcWzlDao;
    @Autowired
    ZkTempDao zkTempDao;

    public void excuteQualityPro(String pname, String id) {
        hpQcWzlDao.excuteQualityPro(pname, id);
    }

    public void excuteQualitypfPro(String pname, String id, String isWest) {
        hpQcWzlDao.excuteQualityPropf(pname, id, isWest);
    }

    public List<Map<String, Object>> excuteQualityByDate(String pname, String sdate, String edate, String lever, String flag, String tableName, String onColumn, String type) {
        return hpQcWzlDao.excuteQualityByDate(pname, sdate, edate, lever, flag, tableName, onColumn, type);
    }

    public List<Map<String, Object>> excuteQualityBySix(String pname, String sdate, String edate, String lever, String flag, String tableName) {
        return hpQcWzlDao.excuteQualityBySix(pname, sdate, edate, lever, flag, tableName);
    }

    public String excuteQuality1(String p_zmzk_run, String sdate, String edate, String level, String sql, String qcTable, String onClumn, String is_link) {

        hpQcWzlDao.selectSqlWithSQL(sql);
        String qc_id = UUID.randomUUID().toString();
        String qc_time = DateUtil.getCurrentDateForDateTime();
        List<ZkTemp> zkTemps = zkTempDao.selectAll();
        long l1 = System.currentTimeMillis();
        for (ZkTemp zkTemp : zkTemps) {

            try {
                String s = zkTemp.getSqls();
               /* s.replaceAll("2022-10-08 13:58:29", qc_time);
                s.replaceAll("@@@", qc_time);
                s.replaceAll("0F35FF43-889C-4952-B9BB-9FFA9B4D6AF3", qc_id);
                s.replaceAll("!!!", qc_id);
                s.replaceAll("$$$", "2");*/
                hpQcWzlDao.selectSqlWithSQL(s);


            } catch (Exception e) {
                return "质控失败" + zkTemp.getId();
            }
        }
        System.out.println("总耗时：" + (System.currentTimeMillis() - l1) / 1000 + "s");
        return "成功";
    }

    public  List<Map<String, Object>> excuteQualityByNine(String pname,String Sdate, String Edate, String qm_id, String is_first, String qc_time, String onColumn, String is_link,String lever) {
        return hpQcWzlDao.excuteQualityByNine(pname, Sdate, Edate, qm_id, is_first, qc_time, onColumn, is_link,lever);
    }
}
