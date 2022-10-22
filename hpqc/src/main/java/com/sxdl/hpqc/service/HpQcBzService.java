package com.sxdl.hpqc.service;


import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hpqc.dao.dao1.HpQcLinkResultDao;
import com.sxdl.hpqc.dao.dao1.HpQcBzDao;
import com.sxdl.hpqc.dao.dao1.HpQcResultDao;
import com.sxdl.hpqc.entity.HomepageQcLinkEntity;
import com.sxdl.hpqc.entity.HpLinkQcResult;
import com.sxdl.hpqc.entity.HpQcBz;
import com.sxdl.hpqc.util.ReflexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HpQcBzService extends BaseUUIDServiceImpl<HpQcBz> {

    @Autowired
    private HpQcBzDao hpQcBzDao;

    @Autowired
    private HpQcResultDao hpQcResultDao;
    @Autowired
    private HpQcLinkResultDao hpQcLinkResultDao;

   /* @Autowired
    private HpICCMHistoryDataDzDao hpICCMHistoryDataDzDao;*/


   /* *//**
     * @param homepageEntity 病案总表数据
     * @return 保存修改 字典数据控制结果 //TODO 小吉 新增保存 修改保存 的时候调用
     *//*
    public List<HpQmResult> saveDictQualityControlResult(HomepageEntity homepageEntity) {
        try {
            //1 先删除数据,根据质控类型 5 和出院时间  和 A表id
            Integer i = hpQmResultDao.deleteByTypeDict(homepageEntity.getBah(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(homepageEntity.getCysj()), 5);
            Integer i2 = hpQmResultDao.deleteByTypeDict(homepageEntity.getBah(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(homepageEntity.getCysj()), 8);

            //2 先获取需要处理的字典标准数据
            List<HpQmResult> hpQmResults = new ArrayList<>();
            HpQmBz hpQmBz = new HpQmBz();
            hpQmBz.setIs_on(1);
            List<HpQmBz> bzList = hpQmBzDao.select(hpQmBz);
            for (HpQmBz qmBz : bzList) {

                if (qmBz.getClassify_id() == 5) {
                    //获取雕龙标准字典中的数据
                    ArrayList<String> onlyDitVal = hpQmBzDao.getOnlyDitVal(qmBz.getDict_talbe_id());
                    //获取需要对照字典的 实际数据
                    //String sVal =  (String) ReflexUtil.getValByPropertiesName(homepageEntity.getClass(),homepageEntity,qmBz.getHome_col().toLowerCase(),0);
                    String sVal = ReflexUtil.getValByPropertiesName(homepageEntity.getClass(), homepageEntity, qmBz.getHome_col().toLowerCase(), 0) + "";
                    //不包含就添加到集合中
                    if (null == sVal || sVal.equals("") || sVal.equals("null")) {
                        continue;
                    }
                    if (!onlyDitVal.contains( sVal)) {
                        HpQmResult result = setHpQmResult(homepageEntity, qmBz);
                        hpQmResultDao.insert(result);
                        hpQmResults.add(result);
                    }
                } else {
                    String sicd = ReflexUtil.getValByPropertiesName(homepageEntity.getClass(), homepageEntity, qmBz.getHome_col().toLowerCase(), 0) + "";
                    //对应得字段没有值 跳过此次循环
                    if (null == sicd || sicd.equals("") || sicd.equals("null")) {
                        continue;
                    }
                    //获取标准代码库的编码
                    Integer type = qmBz.getDict_talbe_id();
                    String key = type + "_icd";
                    ArrayList<String> bzdmkList = (ArrayList<String>) HpApplicationRunnerImpl.contextMap.get(key);
                    //获取历史对照的编码
                    ArrayList<String> historyList = hpICCMHistoryDataDzDao.seleucode(type);
                    List<String> strings = Stream.of(bzdmkList, historyList)
                            .flatMap(Collection::stream)
                            .distinct()
                            .collect(Collectors.toList());
                    String sicdmc = ReflexUtil.getValByPropertiesName(homepageEntity.getClass(), homepageEntity, qmBz.getHome_col2().toLowerCase(), 0) + "";

                    //不包含就添加到集合中
                    strings = strings.stream().filter(e -> e.trim().equals(sicd.trim())).collect(Collectors.toList());
                    if (null == strings || strings.size() <= 0) {
                        HpQmResult result = setHpQmResult(homepageEntity, qmBz);
                        result.setClassify_id(8);
                        result.setMessage(sicd + "@" + sicdmc + "@" + qmBz.getDict_talbe_id());
                        hpQmResultDao.insert(result);
                        hpQmResults.add(result);
                    }

                }
            }
            return hpQmResults;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
*/

 /*   *//**
     * @param homepageQcLinkEntity 病案总表数据
     * @return 保存修改 字典数据控制结果
     *//*
    public List<HpLinkQcResult> saveDictQualityControlLinkResult(HomepageQcLinkEntity homepageQcLinkEntity) {
        try {
            //1 先删除数据,根据质控类型 5 和出院时间  和 A表id
            Integer i = hpQcResultDao.deleteByTypeDict(homepageQcLinkEntity.getBAH(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(homepageQcLinkEntity.getCYSJ()), 5);
           // Integer i2 = hpQcResultDao.deleteByTypeDict(homepageQcLinkEntity.getBah(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(homepageQcLinkEntity.getCysj()), 8);

            //2 先获取需要处理的字典标准数据
            List<HpLinkQcResult> hpLinkResults = new ArrayList<>();
            HpQcBz hpQcBz = new HpQcBz();
            hpQcBz.setIs_on(1);
            List<HpQcBz> bzList = hpQcBzDao.select(hpQcBz);
            for (HpQcBz qmBz : bzList) {
                if (qmBz.getClassify_id() == 5) {
                    //获取雕龙标准字典中的数据
                    ArrayList<String> onlyDitVal = hpQcBzDao.getOnlyDitVal(qmBz.getDict_talbe_id());
                    //获取需要对照字典的 实际数据
                    //String sVal =  (String) ReflexUtil.getValByPropertiesName(homepageEntity.getClass(),homepageEntity,qmBz.getHome_col().toLowerCase(),0);
                    String sVal = ReflexUtil.getValByPropertiesName(homepageQcLinkEntity.getClass(), homepageQcLinkEntity, qmBz.getHome_col().toLowerCase(), 0) + "";
                    //不包含就添加到集合中
                    if (null == sVal || sVal.equals("") || sVal.equals("null")) {
                        continue;
                    }
                    if (!onlyDitVal.contains( sVal)) {
                        HpLinkQcResult result = setHpLinkResult(homepageQcLinkEntity, qmBz);
                        hpQcLinkResultDao.insert(result);
                        hpLinkResults.add(result);
                    }
                }
                *//* 检查编码是否在标准范围内

                else {
                    String sicd = ReflexUtil.getValByPropertiesName(homepageLinkEntity.getClass(), homepageLinkEntity, qmBz.getHome_col().toLowerCase(), 0) + "";
                    //对应得字段没有值 跳过此次循环
                    if (null == sicd || sicd.equals("") || sicd.equals("null")) {
                        continue;
                    }
                    //获取标准代码库的编码
                    Integer type = qmBz.getDict_talbe_id();
                    String key = type + "_icd";
                    ArrayList<String> bzdmkList = (ArrayList<String>) HpApplicationRunnerImpl.contextMap.get(key);
                    //获取历史对照的编码
                    ArrayList<String> historyList = hpICCMHistoryDataDzDao.seleucode(type);
                    List<String> strings = Stream.of(bzdmkList, historyList)
                            .flatMap(Collection::stream)
                            .distinct()
                            .collect(Collectors.toList());
                    String sicdmc = ReflexUtil.getValByPropertiesName(homepageLinkEntity.getClass(), homepageLinkEntity, qmBz.getHome_col2().toLowerCase(), 0) + "";

                    //不包含就添加到集合中
                    strings = strings.stream().filter(e -> e.trim().equals(sicd.trim())).collect(Collectors.toList());
                    if (null == strings || strings.size() <= 0) {
                        HpLinkQmResult result = setHpLinkResult(homepageLinkEntity, qmBz);
                        result.setClassify_id(8);
                        result.setMessage(sicd + "@" + sicdmc + "@" + qmBz.getDict_talbe_id());
                        hpLinkResultDao.insert(result);

                        hpLinkResults.add(result);
                    }

                }*//*
            }
            *//*String sql= " insert  into hp_link_result_record \n" +
                    " select * from hp_link_result a where not exists (select 1 from hp_link_result_record r where a.bah=r.bah ) and a.classify_id=5" ;
            hpQcLinkResultDao.updateSqlWithSQL(sql);*//*
            return hpLinkResults;
        } catch (Exception e) {
           // System.out.println(e.getMessage());
            return null;
        }
    }*/

    public static void main(String[] args) {
        String s = "SSJCZBM29";
        String replace = s.replace("BM", "MC").toLowerCase();
       // System.out.println(replace);

    }

    /**
     * 设置数据
     *
     * @param homepageQcLinkEntity
     * @param qmBz
     * @return
     * @throws Exception
     */
    public HpLinkQcResult setHpLinkResult(HomepageQcLinkEntity homepageQcLinkEntity, HpQcBz qmBz) throws Exception {
        HpLinkQcResult result = new HpLinkQcResult();
        //  我真他妈的傻逼 result.setBah((String) ReflexUtil.getValByPropertiesName(homepageEntity.getClass(), homepageEntity, "A_id",0) );
        result.setBah(homepageQcLinkEntity.getBAH());
        result.setClassify("字典质控");
        result.setClassify_id(5);
        //result.setFields(qmBz.getFields());
        result.setMessage(qmBz.getMessage());
        result.setOrdernum(qmBz.getOrdernum());
        result.setFields_anchor(qmBz.getFields_anchor());
        result.setCan_forced(qmBz.getCan_forced());
        result.setFields(qmBz.getOrdernum()+":"+qmBz.getMessage()+qmBz.getFields());
        //result.setTime((String) ReflexUtil.getValByPropertiesName(homepageEntity.getClass(), homepageEntity, "cysj",2) );
        result.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(homepageQcLinkEntity.getCYSJ()));
        return result;
    }



    /* *//**
     * 设置数据
     *
     * @param homepageEntity
     * @param qmBz
     * @return
     * @throws Exception
     *//*
    public HpQmResult setHpQmResult(HomepageEntity homepageEntity, HpQmBz qmBz) throws Exception {
        HpQmResult result = new HpQmResult();
        result.setBah(homepageEntity.getBah());
        result.setClassify("字典质控");
        result.setClassify_id(5);
        //result.setFields(qmBz.getFields());
        result.setMessage(qmBz.getMessage());
        result.setOrdernum(qmBz.getOrdernum());
        result.setFields_anchor(qmBz.getFields_anchor());
        result.setCan_forced(qmBz.getCan_forced());
        result.setFields(qmBz.getOrdernum()+":"+qmBz.getMessage()+qmBz.getFields());
        //result.setTime((String) ReflexUtil.getValByPropertiesName(homepageEntity.getClass(), homepageEntity, "cysj",2) );
        result.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(homepageEntity.getCysj()));
        return result;
    }*/

}
