package com.sxdl.hpqc.service;


import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.hpqc.dao.dao1.HpQcPfDao;
import com.sxdl.hpqc.dao.dao1.HpQcPfResultDao;
import com.sxdl.hpqc.dbo.DrQualityDBO;
import com.sxdl.hpqc.dbo.HpQcFzmxData;
import com.sxdl.hpqc.dbo.HpQmRuleData;
import com.sxdl.hpqc.entity.DrPlusErrorQualityLog;
import com.sxdl.hpqc.entity.HpQcLog;
import com.sxdl.hpqc.entity.HpQcPfEntity;
import com.sxdl.hpqc.entity.HpQcPfResultEntity;
import com.sxdl.hpqc.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpQcPfService extends BaseServiceImpl<HpQcPfEntity> {

    @Autowired
    HpQcPfDao hpQcPfDao;
   @Autowired
    HpQcPfResultDao hpQcPfResultDao;
    @Autowired
    YmlUtil ymlUtil;

    HpQcPfResultEntity entity;
    Map<String, List<HpQcPfResultEntity>> HpQmPfMap;
    List<HpQcPfResultEntity> pfResults, fyResults, jbResults, shResults, zdResults, zlResults;

    public Double getKfz(double kfz, List<HpQcPfResultEntity> resultEntities) {
        if (null != resultEntities && resultEntities.size() > 0) {
            entity = resultEntities.get(0);
            if (entity.getPackages_score() / entity.getKfz() > resultEntities.size()) {
                resultEntities.forEach(e -> {
                    e.setBz("该类应扣为" + entity.getKfz() * resultEntities.size() + "分，实际扣分" + entity.getKfz() * resultEntities.size() + "分");
                });
                kfz += entity.getKfz() * resultEntities.size();
            } else {
                resultEntities.forEach(e -> {
                    e.setBz("该类应扣" + entity.getKfz() * resultEntities.size() + "分，实际扣分" + entity.getPackages_score() + "分");
                });
                kfz += entity.getPackages_score();
            }
        }
        return kfz;
    }










    /**
     * 计算评分总分和分项总分
     *
     * @param bah    病案号
     * @param result 返回的数据容器
     * @return 数据
     */
    public Map getPfInfo(String bah, Map result, String iswest, List<HpQcPfResultEntity>  pfResults) {
        Double kfz = 0D;

        if (null == pfResults || pfResults.size() <= 0) {
            result.put("pf", pfResults);
            result.put("pfzf", 100);
            return result;

        }
        if ("2".equals(iswest)) {
            //
            HpQmPfMap = pfResults.stream().filter(e -> null != e).collect(Collectors.groupingBy(e -> e.getPackages()));
            if (null == HpQmPfMap || HpQmPfMap.size() == 0) {
                return result;
            }
           if (HpQmPfMap.containsKey("无")) {
                pfResults = HpQmPfMap.get("无");
            } else {
                pfResults = new ArrayList<>();
            }
            if (HpQmPfMap.containsKey("费用类")) {
                fyResults = HpQmPfMap.get("费用类");
                kfz = getKfz(kfz, fyResults);
                result.put("pf_fy", fyResults);
            } else {
                result.put("pf_fy", null);
            }
            if (HpQmPfMap.containsKey("基本类")) {
                jbResults = HpQmPfMap.get("基本类");
                kfz = getKfz(kfz, jbResults);
                result.put("pf_jb", jbResults);
            } else {
                result.put("pf_jb", null);
            }
            if (HpQmPfMap.containsKey("其他手术")) {
                shResults = HpQmPfMap.get("其他手术");
                kfz = getKfz(kfz, shResults);
                result.put("pf_sh", shResults);
            } else {
                result.put("pf_sh", null);
            }
            if (HpQmPfMap.containsKey("其他诊断")) {
                zdResults = HpQmPfMap.get("其他诊断");
                kfz = getKfz(kfz, zdResults);
                result.put("pf_zd", zdResults);
            } else {
                result.put("pf_zd", null);
            }
            if (HpQmPfMap.containsKey("诊疗类")) {
                zlResults = HpQmPfMap.get("诊疗类");
                kfz = getKfz(kfz, zlResults);
                result.put("pf_zl", zlResults);
            } else {
                result.put("pf_zl", null);
            }
        }
        if (null != pfResults && pfResults.size() > 0) {
            for (HpQcPfResultEntity en : pfResults) {
                if (null != en.getKfz()) {
                    kfz += en.getKfz();
                }
            }
        }

        result.put("pf", pfResults);
        result.put("pfzf", 100 - kfz > 0 ? 100 - kfz : 0);
        return result;
    }

    public Map getPfMap(List<HpQcPfResultEntity> pfResults, Map result, String iswest) {
        Double kfz = 0D;
        // pfResults = hpQcPfResultDao.selectbyBah(bah);
        if (null == pfResults || pfResults.size() <= 0) {
            result.put("pf", pfResults);
            result.put("pfzf", 100);
            return result;

        }
        if ("2".equals(iswest)) {
            HpQmPfMap = pfResults.stream().filter(e -> null != e).collect(Collectors.groupingBy(e -> e.getPackages()));
            if (null == HpQmPfMap || HpQmPfMap.size() == 0) {
                return result;
            }
            if (HpQmPfMap.containsKey("无")) {
                pfResults = HpQmPfMap.get("无");
            } else {
                pfResults = new ArrayList<>();
            }
            if (HpQmPfMap.containsKey("费用类")) {
                fyResults = HpQmPfMap.get("费用类");
                kfz = getKfz(kfz, fyResults);
                result.put("pf_fy", fyResults);
            } else {
                result.put("pf_fy", null);
            }
            if (HpQmPfMap.containsKey("基本类")) {
                jbResults = HpQmPfMap.get("基本类");
                kfz = getKfz(kfz, jbResults);
                result.put("pf_jb", jbResults);
            } else {
                result.put("pf_jb", null);
            }
            if (HpQmPfMap.containsKey("其他手术")) {
                shResults = HpQmPfMap.get("其他手术");
                kfz = getKfz(kfz, shResults);
                result.put("pf_zd", shResults);
            } else {
                result.put("pf_zd", null);
            }
            if (HpQmPfMap.containsKey("其他诊断")) {
                zdResults = HpQmPfMap.get("其他诊断");
                kfz = getKfz(kfz, zdResults);
                result.put("pf_sh", zdResults);
            } else {
                result.put("pf_sh", null);
            }
            if (HpQmPfMap.containsKey("诊疗类")) {
                zlResults = HpQmPfMap.get("诊疗类");
                kfz = getKfz(kfz, zlResults);
                result.put("pf_zl", zlResults);
            } else {
                result.put("pf_zl", null);
            }
        }
        if (null != pfResults && pfResults.size() > 0) {
            for (HpQcPfResultEntity en : pfResults) {
                if (null != en.getKfz()) {
                    kfz += en.getKfz();
                }
            }
        }
        result.put("pf", pfResults);
        result.put("pfzf", 100 - kfz > 0 ? 100 - kfz : 0);
        return result;
    }

    /**
     * 计算评分总分和分项总分
     *
     * @param bah 病案号
     * @return 数据
     */
    public Double getScore(String bah, String iswest,String is_Link) {
        Double kfz = 0D;
        pfResults = hpQcPfResultDao.selectbyBahAndFirst(bah,"desc",is_Link,"a");
        if (null == pfResults || pfResults.size() <= 0) {
            kfz = 100D;
            return kfz;

        }
        if ("2".equals(iswest)) {
            HpQmPfMap = pfResults.stream().filter(e -> null != e).collect(Collectors.groupingBy(e -> e.getPackages()));
            if (null == HpQmPfMap || HpQmPfMap.size() == 0) {
                kfz = 100D;
                return kfz;
            }
            if (HpQmPfMap.containsKey("无")) {
                pfResults = HpQmPfMap.get("无");
            } else {
                pfResults = new ArrayList<>();
            }
            if (HpQmPfMap.containsKey("费用类")) {
                fyResults = HpQmPfMap.get("费用类");
                kfz = getKfz(kfz, fyResults);
            }
            if (HpQmPfMap.containsKey("基本类")) {
                jbResults = HpQmPfMap.get("基本类");
                kfz = getKfz(kfz, jbResults);
            }
            if (HpQmPfMap.containsKey("其他手术")) {
                shResults = HpQmPfMap.get("其他手术");
                kfz = getKfz(kfz, shResults);
            }
            if (HpQmPfMap.containsKey("其他诊断")) {
                zdResults = HpQmPfMap.get("其他诊断");
                kfz = getKfz(kfz, zdResults);
            }
            if (HpQmPfMap.containsKey("诊疗类")) {
                zlResults = HpQmPfMap.get("诊疗类");
                kfz = getKfz(kfz, zlResults);
            }
        }
        if (null != pfResults && pfResults.size() > 0) {
            for (HpQcPfResultEntity en : pfResults) {
                if (null != en.getKfz()) {
                    kfz += en.getKfz();
                }
            }
        }
        return 100 - kfz > 0 ? 100 - kfz : 0;
    }

    public void qualityByListOrOne(String sdate, String edate, String flag, String level, String column) {
        List<HpQcLog> logList = new ArrayList<>();
        String hpLink = ymlUtil.getYmlValue("hpLink");
        String tempSql = "=4";
        if ("2".equals(level)) {
            tempSql = " in (4,7)";
        }

        List<HpQmRuleData> qualityData = hpQcPfDao.findQmAllData(tempSql, "is_on");
        if (StringUtil.isNotEmpty(flag)) {
            tempSql = "select * into ##temp from " + hpLink + " where " + column + "='" + flag + "'";
        }else{
            tempSql = "select * into ##temp from " + hpLink + " where  convert(varchar(10)," + column + ",23) between '" + sdate + "' and '"+edate+"'";
        }
        hpQcPfDao.selectSqlWithSQLStr(tempSql);
        StringBuilder sb = null;
       /* for (HpQmRuleData qualityDatum : qualityData) {
            String stime = DataUtil.getDateTime();
            try {
                sb = new StringBuilder();
                sb.append(" insert into drplus_control_result(id,save_time,drplus_platform_detailed_id,drplus_extract_detailed_id,primary_keyval,result_message,type,drplus_quality_id,termlevel,field_name) ");
                sb.append(" select Newid(),convert(varchar(19),getdate(),120)," + pid + "," + extract_id + ",PRIMAEYKEY," + "'" + qualityDatum.getResult_message() + "'," + qualityDatum.getType() + "," + qualityDatum.getId() + "," + qualityDatum.getTermlevel() + ",'" + qualityDatum.getField_name() + "' ");
                sb.append(" from drplus_center_table_data_ioc" + pid + " a ");
                sb.append(" where ( " + qualityDatum.getSqls() + " ) And ");
                sb.append(" not exists( select 1 from drplus_control_result b " +
                        "where  b.drplus_platform_detailed_id =   " + pid +
                        " and  a.drplus_extract_detailed_id = b.drplus_extract_detailed_id " +
                        " and  a.PRIMAEYKEY = b.primary_keyval and b.drplus_quality_id = " + qualityDatum.getId() + " and b.type =" + qualityDatum.getType() + ")");

                int i1 = resultDao.insertSql(sb.toString());
            } catch (Exception e) {
                Integer type = qualityDatum.getType();
                String a = "";
                if (type == 1) {
                    a = "标准质控-->";
                } else if (type == 2) {
                    a = "完整质控-->";
                } else if (type == 3) {
                    a = "逻辑质控-->";
                }

                DrPlusErrorQualityLog logentity = new DrPlusErrorQualityLog();
                logentity.setDrplus_platform_detailed_id(pid)
                        .setDrplus_extract_detailed_id(extract_id)
                        .setMessage(a + qualityDatum.getResult_message() + "-->" + e.getCause().toString())
                        .setDrplus_quality_id(qualityDatum.getId())
                        .setType(qualityDatum.getType())
                        .setCreate_time(DataUtil.getDateTime());
                logList.add(logentity);
                logger.error("DrPlusControlResultService.qualityByList方法错误 :" + e);
            }
            String etime = DataUtil.getDateTime();
            long dateSubSeconds = DataUtil.getDateSubSeconds(stime, etime);
            if (dateSubSeconds > 5) {
                System.out.println("质控类型:" + qualityDatum.getType() + ">id:" + qualityDatum.getId() + ">用时:" + dateSubSeconds);
            }
        }
        logList.forEach(e -> {
            int insert = errorQualityLogDao.insert(e);
        });*/
        return;
    }

    public HpQcFzmxData selectFxmxByBahAndCysj(String bah, String cysj,Integer paymode) {
      return   hpQcPfDao.selectFxmxByBahAndCysj(bah,cysj,paymode);
    }
}
