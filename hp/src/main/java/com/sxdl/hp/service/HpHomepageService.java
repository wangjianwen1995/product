package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpHomepageDao;
import com.sxdl.hp.dao.dao1.HpVsch0ADao;
import com.sxdl.hp.dbo.ModelC;
import com.sxdl.hp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class HpHomepageService extends BaseUUIDServiceImpl<HomepageEntity> {

    @Autowired
    HpHomepageDao hpHomepageDao;
    @Autowired
    HpVsch0AService hpVsch0AService;
    @Autowired
    HpVsch0BService hpVsch0BService;
    @Autowired
    HpVsch0CService hpVsch0CService;
    @Autowired
    HpVsch0EService hpVsch0EService;
    @Autowired
    HpFllowService hpFllowService;
    @Autowired
    HpVsch0PService hpVsch0PService;
    @Autowired
    HpVsch0FService hpVsch0FService;
    @Autowired
    HpTableService hpTableService;
    @Autowired
    HpBzdmkService hpBzdmkService;
    @Autowired
    HpVsch0KService hpVsch0KService;
    @Autowired
    HpVsch0HService hpVsch0HService;
    @Autowired
    HpVsch0ADao hpVsch0ADao;
    @Autowired
    HpVsch0SService hpVsch0SService;
    @Autowired
    HpVsWt47CfnewService hpVsWt47CfnewService;
    @Autowired
    HpFileService hpFileService;
    @Autowired
    HpHomepageService hpHomepageService;

    /**
     * 保存核心正式数据,包含abcde....,和homepage
     */
    public ResultUtil saveCoreData(ModelC data, HpHospiatlInfo hpHospiatlInfo)  {
        if (null == data) {
            return ResultUtil.error("参数不能空,保存异常,请联系雕龙管理员!");
        }
        HpVsch0AEntity entityA = data.getA();
        if (null == entityA) {
            return ResultUtil.error("参数不能空,保存异常,请联系雕龙管理员!");
        }
        if (StrUtil.isNotEmpty(entityA.getSTATUS()) && "4".equals(entityA.getSTATUS())) {
            return ResultUtil.error("当前病例状态为\"已审核\",不可以执行修改的操作,请按照正常操作执行!");
        }
        //保存初始化病案状态为质控中(2)
        entityA.setSTATUS("2");
        String aid, year = entityA.getCHYear(), bah = entityA.getCH0A01();
        Date cysj = entityA.getCH0A27();
        Integer zycs = entityA.getCH0AZYCS();
        if (null == zycs || zycs <= 0) {
            return ResultUtil.error("住院次数不能为空,且必须大于0!");
        }
        if (StrUtil.isEmpty(year)) {
            year = DateUtil.year(cysj) + "";
            entityA.setCHYear(year);
            if (StrUtil.isEmpty(entityA.getCH0A00())) {
                entityA.setCH0A00(bah.substring(0, bah.length() - 2));
            }
        }
        ResultUtil error = hpFileService.getTakUpResult(bah, year, "a");
        if (error != null) {
            return error;
        }
        //数据库层面消除幂等性
        String deletesql = "delete VSCH0C where ch0c01 ='" + bah + "'\n" +
                "delete VSCH0S where ch0s01 ='" + bah + "'\n" +
                "delete VSCH0A where ch0a01 ='" + bah + "'\n" +
                "delete VSCH0b where ch0b01 ='" + bah + "'\n" +
                "delete VSCH0h where ch0h01 ='" + bah + "'\n" +
                "delete VSCH0f where ch0f01 ='" + bah + "'\n" +
                "delete VSCH0k where ch0k01 ='" + bah + "'\n" +
                "delete VSCH0p where ch0p01 ='" + bah + "'\n" +
                "delete dl_fllow where ch0a01 ='" + bah + "'\n" +
                "delete VsWT47_CFNew where wt4701 ='" + bah + "'\n" +
                "delete homepage where bah ='" + bah + "'\n" +
                "delete " + hpTableService.getSfyTableName() + " where ch0p01 ='" + bah + "'\n" +
                "delete VSCH0E where ch0e01 ='" + bah + "'\n";
        hpVsch0AService.updateSqlWithSQL(deletesql);
        if (StringUtil.isEmpty(year)) {
            entityA.setCHYear(DateUtil.year(cysj) + "");
        }
        hpVsch0AService.insert(entityA);
        aid = entityA.getID();

        HpVsch0BEntity entityB = data.getB();
        if (null != entityB) {
            entityB = entityB.toBuilder().A_ID(aid).CHYear(year).CH0B01(bah).CYSJ(cysj).build();
            error = hpFileService.getTakUpResult(bah, year, "b");
            if (error != null) {
                return error;
            }
            hpVsch0BService.insert(entityB);
        }

        List<HpVsch0CEntity> ListEntityC = data.getC();
        List<HpVsch0CEntity> ListEntityCNew = new ArrayList<>();
        if (CollUtil.isNotEmpty(ListEntityC)) {
            error = hpFileService.getTakUpResult(bah, year, "c");
            if (error != null) {
                return error;
            }
            for (int i = 0; i < ListEntityC.size(); i++) {
                HpVsch0CEntity c = ListEntityC.get(i);
                c = c.toBuilder().A_ID(aid).CHYear(year).CH0C01(bah).CH0C02(i).CYSJ(cysj).build();
                hpVsch0CService.insert(c);
                ListEntityCNew.add(c);
            }
            Collections.sort(ListEntityCNew, Comparator.comparing(HpVsch0CEntity::getCH0C02));
        }

        List<HpVsch0EEntity> ListEntityE = data.getE();
        List<HpVsch0EEntity> ListEntityENew = new ArrayList<>();
        if (CollUtil.isNotEmpty(ListEntityE)) {
            error = hpFileService.getTakUpResult(bah, year, "e");
            if (error != null) {
                return error;
            }
            for (int i = 0; i < ListEntityE.size(); i++) {
                HpVsch0EEntity e = ListEntityE.get(i);
                e = e.toBuilder().A_ID(aid).CHYear(year).Ch0E01(bah).CH0E07(i + 1).CYSJ(cysj).build();
                hpVsch0EService.insert(e);
                ListEntityENew.add(e);
            }
            Collections.sort(ListEntityENew, Comparator.comparing(HpVsch0EEntity::getCH0E07));
        }

        HpfllowEntity entityFlow = data.getF();
        if (null != entityFlow) {
            entityFlow = entityFlow.toBuilder().id(null).A_ID(aid).CH0A01(bah).CHYear(year).CYSJ(cysj).build();
            error = hpFileService.getTakUpResult(bah, year, "dlflow");
            if (error != null) {
                return error;
            }
            hpFllowService.insert(entityFlow);
        }

        HpVsch0HEntity entityH = data.getH();
        if (null != entityH) {
            entityH = entityH.toBuilder().A_ID(aid).CHYear(year).Ch0H01(bah).CYSJ(cysj).build();
            entityH.setID(null);
            error = hpFileService.getTakUpResult(bah, year, "h");
            if (error != null) {
                return error;
            }
            hpVsch0HService.insert(entityH);
        }

        HpVsch0KEntity entityK = data.getK();
        if (null != entityK) {
            entityK = entityK.toBuilder().A_ID(aid).CHYear(year).Ch0K01(bah).CYSJ(cysj).build();
            entityK.setID(null);
            error = hpFileService.getTakUpResult(bah, year, "k");
            if (error != null) {
                return error;
            }
            hpVsch0KService.insert(entityK);
        }

        List<HpVsch0SEntity> listEntityS = data.getS();
        List<HpVsch0SEntity> listEntitySNew = new ArrayList<>();
        if (CollUtil.isNotEmpty(listEntityS)) {
            error = hpFileService.getTakUpResult(bah, year, "s");
            if (error != null) {
                return error;
            }
            for (int i = 0; i < listEntityS.size(); i++) {
                HpVsch0SEntity s = listEntityS.get(i);
                s = s.toBuilder().A_ID(aid).CHYEAR(year).CH0S01(bah).CH0S02(i).CYSJ(cysj).build();
                hpVsch0SService.insert(s);
                listEntitySNew.add(s);
            }
        }

        HpVsWt47CfnewEntity entityNEW = data.getNEW();
        if (null != entityNEW) {
            entityNEW = entityNEW.toBuilder().A_ID(aid).ChYear(year).WT4701(bah).CYSJ(cysj).build();
            entityNEW.setID(null);
            error = hpFileService.getTakUpResult(bah, year, "wt47");
            if (error != null) {
                return error;
            }
            hpVsWt47CfnewService.insert(entityNEW);
        }

        HpVsch0FEntity entitySW = data.getSW();
        if (null != entitySW) {
            entitySW = entitySW.toBuilder().A_ID(aid).CHYear(year).Ch0F01(bah).CYSJ(cysj).build();
            entitySW.setID(null);
            error = hpFileService.getTakUpResult(bah, year, "sw");
            if (error != null) {
                return error;
            }
            hpVsch0FService.insert(entitySW);
        }

        //省附页信息更新
        error = hpFileService.getTakUpResult(bah, year, "p");
        if (error != null) {
            return error;
        }
        Map<String, Object> sfy = hpTableService.mergeSFY(hpHospiatlInfo, data.getP(), aid, cysj);
        Long cfts = getCfts(zycs, aid);
        HomepageEntity homepageNew = SingleToMain.convert(data, aid, cfts.intValue());

        error = hpFileService.getTakUpResult(bah, year, "homepage");
        if (error != null) {
            return error;
        }
        hpHomepageService.insert(homepageNew);
        Map ids = new HashMap();
        ids.put("homID", homepageNew.getId());
        ids.put("AID", aid);
        ids.put("A", entityA);
        ids.put("B", entityB);
        ids.put("F", entityFlow);
        ids.put("H", entityH);
        ids.put("K", entityK);
        ids.put("SW", entitySW);
        ids.put("NEW", entityNEW);
        ids.put("E", ListEntityENew);
        ids.put("C", ListEntityCNew);
        ids.put("S", listEntitySNew);
        ids.put("P", sfy);
        ids.put("bah", bah);
        return ResultUtil.success(ids, "保存成功");
    }

    /**
     * 录入或修改,保存病案数据,并且更新归档表
     */
    public ResultUtil inserOrUpdate(ModelC data, HpHospiatlInfo hpHospiatlInfo)  {
        ResultUtil rst = saveCoreData(data, hpHospiatlInfo);
        if (rst.isSuc()) {
            return rst;
        }
        Object o = ((Map<String, Object>) rst.getT()).get("bah");
        if (null == o) {
            return rst;
        }
        String bah = o.toString();
        //更新中间表mid
        String m_id = data.getMID(), sql = "update hp_mid_table set status=2 where ";
        if (StringUtil.isNotEmpty(m_id)) {
            sql += " id='" + m_id + "'";
        } else if (StringUtil.isNotEmpty(bah)) {
            sql += " bah='" + bah + "'";
        } else {
            return rst;
        }
        hpFileService.selectSqlWithSQL(sql);
        return rst;
    }

    /**
     * 根据a表id查询是否有重返天数
     *
     * @param zycs 住院次数
     * @param aid  a表id
     * @return
     */
    public Long getCfts(Integer zycs, String aid)  {
        Long cfts = 0L;
        //如果多次住院再查
        if (1 < zycs) {
            //用身份证号关联a表历史数据查询是否有重返天数,以防止病案号更换找不到数据
            String sql = "select  old.CH0AZYCS,old.ch0a27,c.ch0c11,new.CH0AZYCS,new.ch0a24,new.zzd,datediff(dd,old.ch0a27,new.ch0a24) cfts \n" +
                    "from VsCH0A old \n" +
                    "left join(select a_id id,ZYZD_JBBM zzd,RYSJ ch0a24,SFZH ch0a05,ZYCS CH0AZYCS from homepage where ZYCS>1 and isnull(SFZH,'')!='') new \n" +
                    "on old.ch0a05=new.ch0a05 and old.CH0AZYCS=(new.CH0AZYCS-1) and new.ch0a24>old.ch0a27\n" +
                    "left join vsch0c c on c.ch0c01=old.ch0a01 and c.ch0c02=0  \n" +
                    "where c.CH0C11=new.zzd  and old.Ch0ANG=1 and new.id='" + aid + "'";
            List<Map<String, Object>> maps = hpVsch0AService.selectSqlWithSQL(sql);
            if (maps.size() > 0) {
                Object cftsStr = maps.get(0).get("cfts");
                if (null != cftsStr) {
                    cfts = Long.parseLong(cftsStr.toString());
                    //如果当前出入院,重返天数为1
                    if (0 == cfts) {
                        cfts = 1L;
                    }
                }
            }
        }
        return cfts;
    }

    /**
     * 高级查询拼装sql并查询功能
     *
     * @param page    分页
     * @param sql     页面拼接sql
     * @param user_id 用户id
     */
    public PageInfo seniorQueryData(PageInfo page, String sql, Integer user_id)  {
        StringBuilder sbColumn = new StringBuilder();
        StringBuilder sbFrom = new StringBuilder();
        Map<String, Object> listPage = null;
        // 52.住院号、姓名、出生日期、入出院时间、出院科别、主治医师、主要诊断，离院方式
        List<String> useTableName = hpTableService.getUseTableName(user_id);
        sbColumn.append("select distinct homepage.ID, homepage.A_ID, homepage.bah,homepage.zyh,homepage.xm,homepage.CSRQ,(case when homepage.xb=0 then '未知的性别'  when homepage.xb=1 then '男' when  homepage.xb=2 then '女'  when  homepage.xb=9 then '未说明的性别'  end ) as xb   ,homepage.rysj,homepage.cysj,homepage.CYKBMC,homepage.zzys,(case when homepage.lyfs=1 then '医嘱离院'  when homepage.lyfs=2 then '医嘱转院' when  homepage.lyfs=3 then '医嘱转社区卫生服务机构/乡镇卫生院'  when  homepage.lyfs=4 then '非医嘱离院' when  homepage.lyfs=5 then '死亡'  else  '其他' end ) as lyfs,homepage.ZYZD,homepage.ZYZD_JBBM   ");
        sbFrom.append(" from homepage ");
        if (CollUtil.isNotEmpty(useTableName)) {
            for (String e : useTableName) {
                if (StringUtil.isNotEmpty(sql) && sql.contains(e)) {
                    sbFrom.append("  left join  " + e + " on homepage.A_ID = " + e + ".A_ID \n");
                }
            }
        }
        if (StringUtil.isNotEmpty(sql)) {
            sbFrom.append(" where 1=1 " + sql);
        }
        sql = SQLPackageUtil.getPageSQL(sbColumn.toString(), sbFrom.toString(), "homepage.cysj", page, true);
//        List<HomepageEntity> ts = selectListWithSQL(sql, HomepageEntity.class);
        page.setList(selectListWithSQL(sql, HomepageEntity.class));
        sql = SQLPackageUtil.getCountSQL(" from (" + sbColumn + sbFrom + ") a");
        long cnt = Long.parseLong(selectSqlWithSQL(sql).get(0).get("cnt").toString());
        page.setTotal(cnt);
        return page;
    }

    /**
     * 根据aid查询homepage数据
     */
    public HomepageEntity selectByAid(String aId) {
        return hpHomepageDao.selectByAid(aId);
    }
}
