package com.sxdl.product.dc.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.product.dc.dao.dao1.HpBmVersionDao;
import com.sxdl.product.dc.dao.dao1.HpICCMHistoryDataDzDao;
import com.sxdl.product.dc.entity.HpBmVersion;
import com.sxdl.product.dc.entity.HpICCMGxb;
import com.sxdl.product.dc.entity.HpICCMHistoricalDataDz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpICCMHistoryDataDzService extends BaseServiceImpl<HpICCMHistoricalDataDz> {
    @Autowired
    HpICCMHistoryDataDzDao hpICCMHistoryDataDzDao;
    @Autowired
    HpICCMGxbService hpICCMGxbService;
    @Autowired
    HpBmVersionDao hpBmVersionDao;
    @Autowired
    HpBzdmkService bzdmkService;

    public Boolean saveDz(String version, String stime, String etime, String version_name, String type) throws Exception {
        HpICCMHistoricalDataDz hpICCMHistoricalDataDz = new HpICCMHistoricalDataDz();
        List<HpICCMHistoricalDataDz> list = new ArrayList<>();
        String tableName = "";
        switch (type) {
            case "0":
                //疾病
                list = hpICCMHistoryDataDzDao.selectICDSome(stime, etime);
                tableName = "hp_ICDAutoDz";
                break;
            case "1":
                //手术
                list = hpICCMHistoryDataDzDao.selectICCMSome(stime, etime);
                tableName = "hp_ICCMAutoDz";
                break;
            case "2":
                //肿瘤
                list = hpICCMHistoryDataDzDao.selectZLSome(stime, etime);
                tableName = "hp_TumourAutoDz";
                break;
            case "3":
                //损伤
                list = hpICCMHistoryDataDzDao.selectSSZDSome(stime, etime);
                tableName = "hp_SSZDAutoDz";
                break;
            case "4":
                //中医病症法
                list = hpICCMHistoryDataDzDao.selectZYSome(stime, etime);
                tableName = "hp_ZYBZFAutoDz";
                break;
        }
        if (list == null || list.size() <= 0) {
            return false;
        }
        list.forEach(e -> {
            hpICCMHistoricalDataDz.setReport_version(version);
            hpICCMHistoricalDataDz.setType(type);
            hpICCMHistoricalDataDz.setUse_dm(e.getUse_dm());
            hpICCMHistoricalDataDz.setUse_mc(e.getUse_mc());
            List<HpICCMHistoricalDataDz> dzList = hpICCMHistoryDataDzDao.select(hpICCMHistoricalDataDz);
            if (dzList == null || dzList.size() <= 0) {
                e.setStatus("0");
                e.setReport_version(version);
                e.setReport_version_ch(version_name);
                e.setBm_stime(stime);
                e.setBm_etime(etime);
                e.setType(type);
                hpICCMHistoryDataDzDao.insert(e);
            }
        });
        String sql = "update a set report_dm=b.code,report_mc=b.name,a.status='1' \n" +
                "from hp_history_iccm_dz a,hp_bzdmk b where a.status='0' and  b.type=" + type + " and b.version='" + version + "' and \n" +
                "((ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) and ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))) or(ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) )or(ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))))";
        int i = hpICCMHistoryDataDzDao.updateSqlWithSQL(sql);
        if (i < 0) {
            return false;
        } else {
            List<HpICCMHistoricalDataDz> wdzList = hpICCMHistoryDataDzDao.selectByStatus(type, "0");
            if (null == wdzList || wdzList.size() <= 0) {
                return true;
            }
            List<Map<String, Object>> colum = hpICCMGxbService.getTableColum(tableName);
            HpICCMGxb hpICCMGxb = hpICCMGxbService.getVersion(version, "");
            String left_mc = hpICCMGxb.getLeft_mc();
            String left_bm = hpICCMGxb.getLeft_bm();
            List<Map<String, Object>> colum1 = colum.stream().filter(e -> null != e && e.equals(left_mc) || e.equals(left_bm)).collect(Collectors.toList());
            if (null == colum1 || colum1.size() <= 0) {
                return true;
            }
            List<Map<String, Object>> colum2 = colum.stream().filter(e -> null != e && !e.equals(left_mc) || !e.equals(left_bm)).collect(Collectors.toList());
            String column = getColumn(colum2);
            String sql1 = "update a set report_dm=b." + left_bm + ",report_mc=b." + left_bm + ",a.status='1' \n" +
                    "from hp_history_iccm_dz a," + tableName + " b where a.status='0' and (" + column + ")";
            //System.out.println(sql1);
            int i1 = hpICCMHistoryDataDzDao.updateSqlWithSQL(sql1);
            //将标准代码库插入到永久临时表中
            bzdmkService.initBiaozuns();
            if (i1 < 0) {
                return false;
            }
        }
        return true;
    }

    public List<Map<String, Object>> selectBySome(String version, String status, String type, String stime, String etime) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from hp_history_iccm_dz  where type= " + type);
        if (!version.equals("")) {
            sb.append(" and report_version=" + version);
        }
        if (status.equals("0") || status.equals("1")) {
            sb.append(" and status=" + status);
        }
        if (!stime.equals("")) {
            sb.append(" and bm_stime between '" + stime + "' and '" + etime + "'");
        }
        if (!etime.equals("")) {
            sb.append(" and bm_etime between '" + stime + "' and '" + etime + "'");
        }
        List<Map<String, Object>> mapList = hpICCMHistoryDataDzDao.selectSqlWithSQL(sb.toString());
        return mapList;
    }

    private String getColumn(List<Map<String, Object>> colum) throws Exception {
        if (null != colum && colum.size() > 0) {
            StringBuilder colums = new StringBuilder();
            colum.forEach(e -> {
                String name = e.get("name").toString();
                //((ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) and ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))) or(ltrim(rtrim(a.use_dm))=ltrim(rtrim(b.code)) )or(ltrim(rtrim(a.use_mc))=ltrim(rtrim(b.name))))
                if (name.contains("dm")) {
                    colums.append("ltrim(rtrim(a.use_dm))=ltrim(rtrim(b." + name + "))").append("or ");
                }
                if (name.contains("mc")) {
                    colums.append("ltrim(rtrim(a.use_mc))=ltrim(rtrim(b." + name + "))").append("or ");
                }
            });
            String s = colums.toString().substring(0, colums.length() - 3);
            return s;
        } else {
            return null;
        }
    }

    public void saveOrUpdate(HpICCMHistoricalDataDz hpDataDz) throws Exception {
        HpBmVersion hpBmVersion = hpBmVersionDao.selectByStatus(hpDataDz.getType());
        HpICCMHistoricalDataDz hpDataDz1 = new HpICCMHistoricalDataDz();
        hpDataDz1.setUse_dm(hpDataDz.getUse_dm());
        hpDataDz1.setUse_mc(hpDataDz.getUse_mc());
        //hpDataDz1.setStatus("0");
        hpDataDz1.setType(hpDataDz.getType());
        hpDataDz1.setReport_version_ch(hpBmVersion.getVersion_name());
        hpDataDz1.setReport_version(hpBmVersion.getVersion());
        List<HpICCMHistoricalDataDz> dataDzs = hpICCMHistoryDataDzDao.select(hpDataDz1);


        if (null == dataDzs || dataDzs.size() <= 0) {
            //不存在 新增
            hpDataDz.setReport_version_ch(hpBmVersion.getVersion_name());
            hpDataDz.setReport_version(hpBmVersion.getVersion());
            hpDataDz.setStatus("1");
            hpICCMHistoryDataDzDao.insertSelective(hpDataDz);
        } else {
            HpICCMHistoricalDataDz dataDz = dataDzs.get(0);
            dataDz.setReport_dm(hpDataDz.getReport_dm());
            dataDz.setReport_mc(hpDataDz.getReport_mc());
            dataDz.setStatus("1");
            hpICCMHistoryDataDzDao.updateByPrimaryKeySelective(dataDz);
        }
        //将标准代码库插入到永久临时表中
        bzdmkService.initBiaozuns();
    }
}
