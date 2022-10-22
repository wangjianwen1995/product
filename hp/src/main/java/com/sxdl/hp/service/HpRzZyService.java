package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpHomepageDao;
import com.sxdl.hp.dao.dao1.HpZyrzDao;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.entity.HpZyrzEntity;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import com.sxdl.hp.util.PoiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
@Transactional
public class HpRzZyService extends BaseUUIDServiceImpl<HpZyrzEntity> {

    @Autowired
    HpHomepageDao hpHomepageDao;
    @Autowired
    HpFileService hpFileService;
    @Autowired
    SysDictValService sysDictValService;
    String msg = "请先正确维护系统字典中,\"住院日志不允许修改限制日期\"字典的值,,格式为\"YYYY-MM-DD\",再来操作!";
    @Autowired
    private HpZyrzDao hpZyrzDao;

    /**
     * 查询病案日志列表
     */
    public List<HpZyrzEntity> selectByTjrq(String sdate, String edate)  {
        List<HpZyrzEntity> hpZyrzEntities = new ArrayList<>();
        if (StringUtil.trim(sdate).equals(StringUtil.trim(edate))) {//查一天
            hpZyrzEntities = hpZyrzDao.selectByTjrqOne(sdate);
        } else {
            hpZyrzEntities = hpZyrzDao.selectByTjrq(sdate, edate);//查一段时间
        }
        return hpZyrzEntities;
    }

    /**
     * 全部更新
     */
    public ResultUtil updateByTjrqAndTjkb(List<HpZyrzEntity> list)  {
        ResultUtil result = checkPreOption(list.get(0).getTjrq(), false);
        if (null != result) {
            return result;
        }
        int zr = list.stream().mapToInt(HpZyrzEntity::getTkzrrs).sum();
        int zc = list.stream().mapToInt(HpZyrzEntity::getZwtkrs).sum();
        if (zr != zc) {
            return ResultUtil.error("数据异常,转入人数(" + zr + ")和转出人数(" + zc + ")不匹配!请检查");
        }
        for (HpZyrzEntity hpZyrzEntity : list) {
            String tjrq = hpZyrzEntity.getTjrq();
            String tjkb = hpZyrzEntity.getTjkb();
            //当前留院人数数据
            int lyrs_g = null == hpZyrzEntity.getLyrs() ? 0 : hpZyrzEntity.getLyrs();
            //计算出的留院人数数据
            int lyrs_s = hpZyrzEntity.getYyrs() + hpZyrzEntity.getRyrs() + hpZyrzEntity.getTkzrrs() - hpZyrzEntity.getCyrs() - hpZyrzEntity.getZwtkrs();
            if (lyrs_s < 0) {
                return ResultUtil.error("数据异常,有留院人数是负数!请检查");
            }
            if (lyrs_g != lyrs_s) {
                int updatenum = lyrs_s - lyrs_g;
                String sql = "update hp_zyrz set yyrs = yyrs + (" + updatenum + ") ,lyrs = lyrs +(" + updatenum + ") where tjkb= '" + tjkb + "' and tjrq > '" + tjrq + "'";
                hpZyrzDao.updateSqlWithSQL(sql);
                hpZyrzEntity.setLyrs(lyrs_s);
            }
            hpZyrzEntity.setCyrsdb(0);
            hpZyrzDao.updateByPrimaryKeySelective(hpZyrzEntity);
        }
        return ResultUtil.success("保存成功!");
    }

    /**
     * 查询人数明细方法
     *
     * @param flag  方法标记,yyrs,日志原有患者明细;
     *              ryrs 日志入院患者明细;
     *              zrrs 日志转入患者明细;
     *              cyrs 日志出院患者明细;
     *              zcrs 转出患者明细;
     *              dbrs 病案出院患者明细
     * @param stjrq
     * @param etjrq
     * @param tjks
     * @return
     */
    public List<Map<String, Object>> selectByTjrqAndTjkb(String flag, String stjrq, String etjrq, String tjks)  {
        String sql = "";
        switch (flag) {
            case "yyrs":
                //日志原有患者明细
                if (StringUtil.trim(stjrq).equals(StringUtil.trim(etjrq))) {
                    //查询一天的数据
                    //sql = "select * from hp_tjhzmx where (ch0a27>'"+stjrq+"' or ch0a27 is null) and ch0a24 <'"+stjrq+"'";
                } else {
                    //sql = "select * from hp_tjhzmx where ch0a27>etjrq or ch0a27 is null ";
                }
                break;
            case "ryrs":
                //日志入院患者明细
                if (StringUtil.trim(stjrq).equals(StringUtil.trim(etjrq))) {
                    //查询一天的数据
                    sql = "SELECT [ID],[CHYear] ,[CH0A01] ,[CH0A24] CH0A27 ,[CH0A02] ,[CH0A03] ,[CH0A21] CH0A23,CH0A21_mc CH0A23_MC from hp_tjhzmx where CH0A21='" + tjks + "' and convert(varchar,ch0a24,23)  ='" + stjrq + "' order by CH0A27,CH0A01";
                } else {
                    sql = "SELECT [ID],[CHYear] ,[CH0A01] ,[CH0A24] CH0A27 ,[CH0A02] ,[CH0A03] ,[CH0A21] CH0A23  ,CH0A21_mc CH0A23_MC from hp_tjhzmx where CH0A21='" + tjks + "' and  convert(varchar,ch0a24,23) between '" + stjrq + "' and  '" + etjrq + "' order by CH0A27,CH0A01 ";
                }
                break;
            case "zrrs":
                //日志转入患者明细
                if (StringUtil.trim(stjrq).equals(StringUtil.trim(etjrq))) {
                    //查询一天的数据
                    sql = "SELECT [ID] ID,[CHYear] CHYear ,[CH0A01] CH0A01 ,[ZKRQ] CH0A27,[ZKHZXM] CH0A02,[ZKHZXB] CH0A03,[ZRKS] CH0A23 ,[ZRKS_MC] CH0A23_MC from hp_tjzkmx where ZRKS='" + tjks + "' and  convert(varchar,ZKRQ,23)  ='" + stjrq + "' order by CH0A27,CH0A01";
                } else {
                    sql = "SELECT [ID] ID,[CHYear] CHYear ,[CH0A01] CH0A01 ,[ZKRQ] CH0A27,[ZKHZXM] CH0A02,[ZKHZXB] CH0A03,[ZRKS] CH0A23 ,[ZRKS_MC] CH0A23_MC  from hp_tjzkmx where ZRKS='" + tjks + "' and convert(varchar,ZKRQ,23) between '" + stjrq + "' and  '" + etjrq + "'  order by CH0A27,CH0A01";
                }
                break;
            case "cyrs":
                //日志出院患者明细
                if (StringUtil.trim(stjrq).equals(StringUtil.trim(etjrq))) {
                    //查询一天的数据
                    sql = "SELECT [ID],[CHYear]  ,[CH0A01]  ,[CH0A27] ,[CH0A02] ,[CH0A03] ,[CH0A23],CH0A23_MC,[CH0A29]  from hp_tjhzmx where CH0A23='" + tjks + "' and convert(varchar,ch0a27,23)  ='" + stjrq + "' order by CH0A27,CH0A01";
                } else {
                    sql = "SELECT [ID],[CHYear]  ,[CH0A01]  ,[CH0A27] ,[CH0A02] ,[CH0A03] ,[CH0A23],CH0A23_MC,[CH0A29] from hp_tjhzmx where CH0A23='" + tjks + "'and  convert(varchar,ch0a27,23) between '" + stjrq + "' and  '" + etjrq + "' order by CH0A27,CH0A01 ";
                }
                break;
            case "zcrs":
                //转出患者明细
                if (StringUtil.trim(stjrq).equals(StringUtil.trim(etjrq))) {
                    //查询一天的数据
                    sql = "SELECT [ID] ID,[CHYear] CHYear ,[CH0A01] CH0A01 ,[ZKRQ] CH0A27,[ZKHZXM] CH0A02,[ZKHZXB] CH0A03,[ZCKS] CH0A23 ,[ZCKS_MC] CH0A23_MC from hp_tjzkmx where ZCKS='" + tjks + "' and  convert(varchar,ZKRQ,23) ='" + stjrq + "' order by CH0A27,CH0A01";
                } else {
                    sql = "SELECT [ID] ID,[CHYear] CHYear ,[CH0A01] CH0A01 ,[ZKRQ] CH0A27,[ZKHZXM] CH0A02,[ZKHZXB] CH0A03,[ZCKS] CH0A23,[ZCKS_MC] CH0A23_MC from hp_tjzkmx where ZCKS='" + tjks + "' and convert(varchar,ZKRQ,23) between '" + stjrq + "' and  '" + etjrq + "' order by CH0A27,CH0A01 ";
                }
                break;
            case "dbrs":
                //病案出院患者明细
                if (StringUtil.trim(stjrq).equals(StringUtil.trim(etjrq))) {
                    //查询一天的数据
                    etjrq = stjrq;
                }
                etjrq += " 23:59:59";
                sql = "select [ID],year [CHYear],bah [CH0A01],cyrq [CH0A27],name [CH0A02],xb [CH0A03],cyksdm [CH0A23],filetime [CH0A29],cyks CH0A23_MC " +
                        "from hp_mid_table where cyrq between '" + stjrq + "' and '" + etjrq + "' \n" +
                        "and cyksdm='" + tjks + "' order by cyrq,bah";
                break;
        }
        List<Map<String, Object>> mapList = hpZyrzDao.selectSqlWithSQL(sql);
        return mapList;
    }

    /**
     * 初始化病案日志数据
     */
    public List<HpZyrzEntity> insertSomeByMaxTjrq(String sdate)  {
        List<HpZyrzEntity> hpZyrzEntityList = new ArrayList<>();
        String maxTjrq = hpZyrzDao.selectMaxTjrqBySomeDay(sdate);
        String minTjrq = hpZyrzDao.selectMinTjrqBySomeDay(sdate);
        boolean hasBefor = StrUtil.isNotEmpty(maxTjrq);
        boolean hasAfter = StrUtil.isNotEmpty(minTjrq);
        //获取科室列表
        List<Map<String, Object>> list = selectSqlWithSQL("select isnull(code,'未知') code, isnull(name,'未知')  name, isnull(bed,0) bed from sys_ks where is_id=1 and is_on=1 order by name");
        if (CollUtil.isNotEmpty(list)) {
            HpZyrzEntity hpZyrz, before = null, after = null;
            for (Map<String, Object> e : list) {
                hpZyrz = new HpZyrzEntity(sdate);
                //System.out.println(hpZyrz);
                String kscode = null == e.get("code") ? "" : e.get("code").toString();
                String ksname = null == e.get("name") ? "" : e.get("name").toString();
                Integer kssjkfcws = null == e.get("bed") ? 0 : Integer.parseInt(e.get("bed").toString());
                hpZyrz.setTjkb(kscode);
                hpZyrz.setTjkb_name(ksname);
                Integer beforeCws = null, nowyyrs = null, nowlyrs = null;
                if (hasBefor) {//今天以前最大的一天留院人数数据,当作当天的期初原有人数
                    before = hpZyrzDao.selectOneByTjrqAndTjKb(maxTjrq, kscode);
                    if (null != before) {//今天以前最大的一天数据中,有这个科室的数据
                        nowyyrs = before.getLyrs();
                        beforeCws = before.getSjkfcws();//如果有则取之前的实开床位数
                    } else {//没有这个科室的数据
                        nowyyrs = 0;
                        beforeCws = kssjkfcws;//取科室中维护的实开床位数
                    }
                } else {//没有今天以前的数据
                    nowyyrs = 0;
                    beforeCws = kssjkfcws;
                }
                hpZyrz.setYyrs(nowyyrs);
                hpZyrz.setSjkfcws(beforeCws);
                if (hasAfter) {//今天以后的最近的数据
                    after = hpZyrzDao.selectOneByTjrqAndTjKb(minTjrq, kscode);
                    if (null != after) {//有这个科室的数据,今天以后最近的原有人数设置成当天的留院人数
                        nowlyrs = after.getYyrs();
                    } else {//没有这个科室的数据,将原有人数设置成留院人数
                        nowlyrs = nowyyrs;
                    }
                } else {//没有今天以后的数据,将原有人数设置成留院人数
                    nowlyrs = nowyyrs;
                }
                hpZyrz.setLyrs(nowlyrs);

                hpZyrz.setCyrs(0);
                hpZyrz.setTkzrrs(0);
                hpZyrz.setZwtkrs(0);
                hpZyrz.setRyrs(0);
                hpZyrz.setCyrsdb(0);
                hpZyrzDao.insert(hpZyrz);
                hpZyrzEntityList.add(hpZyrz);
            }
        }
        return hpZyrzEntityList;
    }

    public Map<String, Object> selectFormsByTjrq(String sdate, String edate, String tjkb)  {
        //tjkb="0801,0802,0803";
        String sql = "with jgsj as\n" + "(select  a.tjkb,tjkb_name,sum(isnull(ryrs,0)) ryrs,sum(isnull(tkzrrs,0)) tkzrrs,sum(isnull(cyrs,0)) cyrs,sum(isnull(zwtkrs,0)) zwtkrs ";
        // sql += ",sum(isnull(cyrsdb,0)) cyrsdb";
        sql += ",isnull(b.yyrs,0) yyrs,c.sjkfcws,c.lyrs,isnull(d.drygds,0) drygds ,ISNULL(e.sjcyrs,0)sjcyrs,ISNULL(e.cyzyrs,0)cyzyrs,ISNULL(e.cyhzrs,0)cyhzrs,ISNULL(e.cywyrs,0)cywyrs,ISNULL(e.cyswrs,0) cyswrs,ISNULL(e.cyqtrs,0)cyqtrs \n" + "from hp_zyrz a\n" + "left join (select tjkb,isnull(yyrs,0) yyrs from hp_zyrz where tjrq='" + sdate + "' ) b on a.tjkb=b.tjkb\n" + "left join (select tjkb,isnull(sjkfcws,0) sjkfcws,isnull(lyrs,0) lyrs  from hp_zyrz where tjrq='" + edate + "' ) c on a.tjkb=c.tjkb\n" + "left join (select cyksdm,isnull(COUNT(id),0) drygds  from hp_mid_table where convert(varchar,cyrq,23)  between '" + sdate + "' and '" + edate + "'  \n" + " group by cyksdm ) d on d.cyksdm=a.tjkb\n" + "left join (" + "SELECT isnull( cykb, '未知' ) cykb,\n" + "SUM ( CASE WHEN ZYZD_CYQK = '1' THEN 1 ELSE 0 END ) AS cyzyrs,\n" + "SUM ( CASE WHEN ZYZD_CYQK = '2' THEN 1 ELSE 0 END ) AS cyhzrs,\n" + "SUM ( CASE WHEN ZYZD_CYQK = '3' THEN 1 ELSE 0 END ) AS cywyrs,\n" + "SUM ( CASE WHEN ZYZD_CYQK = '4' THEN 1 ELSE 0 END ) AS cyswrs,\n" + "SUM ( CASE WHEN ZYZD_CYQK not in('1','2','3','4') THEN 1 ELSE 0 END ) AS cyqtrs,\n" + "isnull( COUNT ( * ), 0 ) sjcyrs \n" + "FROM hp_mid_table m,homepage h WHERE m.bah=h.bah \n" + "and cysj BETWEEN '" + sdate + "' AND '" + edate + " 23:59:59' \n" + "GROUP BY cykb) e ON e.cykb= a.tjkb \n" + "WHERE tjrq BETWEEN '" + sdate + "' AND '" + edate + "' ";
        if (StringUtil.isNotEmpty(tjkb.trim())) {
            String tjsql = "";
            if (tjkb.contains(",")) {
                tjsql = " and a.tjkb in (";
                String[] strings = tjkb.split(",");
                for (String s : strings) {
                    tjsql += "'" + s + "',";
                }
                tjsql = tjsql.substring(0, tjsql.length() - 1) + ")";
            } else {
                tjsql = " and a.tjkb='" + tjkb + "' ";
            }
            sql += tjsql;
        }

        sql += " group by a.tjkb,a.tjkb_name,b.yyrs,c.sjkfcws,c.lyrs,isnull(d.drygds,0),e.sjcyrs,e.cyzyrs,e.cyhzrs,e.cywyrs,e.cyswrs,e.cyqtrs )\n" + "select *  from jgsj union all\n" + "select '','总计',sum(ryrs) ryrs,sum(tkzrrs) tkzrrs,sum(cyrs) cyrs,sum(zwtkrs) zwtkrs";
        //sql +=",sum(cyrsdb) cyrsdb";
        sql += " ,sum(yyrs) yyrs,sum(sjkfcws) sjkfcws,sum(lyrs) lyrs,sum(isnull(drygds,0)) drygds ,SUM(ISNULL(sjcyrs,0)) sjcyrs,sum(cyzyrs) cyzyrs,sum(cyhzrs) cyhzrs,sum(cywyrs) cywyrs,sum(cyswrs) cyswrs,sum(cyqtrs) cyqtrs \n" + "from jgsj order by tjkb_name,tjkb desc";
        //System.out.println(sql);
        List<Map<String, Object>> mapList = hpZyrzDao.selectSqlWithSQL(sql);
        Map<String, Object> result = new HashMap<>();
        if (!mapList.isEmpty()) {
            mapList.forEach(e -> {
                String ks = String.valueOf(e.get("tjkb"));
                //科室为空时候,是总计
                if (StrUtil.isEmpty(ks) || "null".equals(ks)) {
                    e.put("tjkb", "总计");
                }
            });
        }
        HpHospiatlInfo hospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        result.put("hospital", hospiatlInfo.getJgmc());
        result.put("rz", mapList);
        return result;
    }

    /**
     * 导出报表
     *
     * @param sdate 开始
     * @param edate 结束
     * @param tjkb  科室
     */
    public void down(String sdate, String edate, String tjkb, HttpServletResponse response) throws Exception {
        Map<String, Object> zyrzEntityList = selectFormsByTjrq(sdate, edate, tjkb);
        List<Map<String, Object>> maps = (List<Map<String, Object>>) zyrzEntityList.get("rz");
        Map<String, String> colmap = new LinkedHashMap<>();
        colmap.put("tjkb", "科室代码");
        colmap.put("tjkb_name", "科室名称");
        colmap.put("ryrs", "日志入院人数");
        colmap.put("tkzrrs", "日志他科转入人数");
        colmap.put("cyrs", "日志出院人数");
        colmap.put("zwtkrs", "日志转往他可人数");
        //colmap.put("cyrsdb", "日志出院人数与病案录入出院人数对比");
        colmap.put("yyrs", "日志原有人数");
        colmap.put("sjkfcws", "实际开放床位数");
        colmap.put("lyrs", "日志留院人数");
        colmap.put("drygds", "病案已归档例数");
        colmap.put("sjcyrs", "病案已抽取出院人数");
        colmap.put("cyzyrs", "病案出院治愈人数");
        colmap.put("cyhzrs", "病案出院好转人数");
        colmap.put("cywyrs", "病案出院未愈人数");
        colmap.put("cyswrs", "病案出院死亡人数");
        colmap.put("cyqtrs", "病案出院其他人数");
        PoiUtil.createExcel("住院日志工作报表", response, maps, colmap);
    }

//    /**
//     * 更新住院日志中的出院人数对比数据,根据归档数据出院时间和出院科室
//     *
//     * @param midTable 归档数据
//     */
//    public void updateCyrsdb(HpMidTableEntity midTable)  {
//        HpZyrzEntity zyrz = new HpZyrzEntity();
//        zyrz.setTjkb(midTable.getCyksdm());
//        zyrz.setTjkb_name(midTable.getCyks());
//        zyrz.setTjrq(DateUtil.formatFromDate(midTable.getCyrq()));
//
//        List<HpZyrzEntity> zyrzs = select(zyrz);
//        if (CollUtil.isNotEmpty(zyrzs)) {
//            zyrz = zyrzs.get(0);
//            update(zyrz);
//        }
//    }

    /**
     * 检查是否能操作,只能在最早修改时间和今天的时间范围内操作
     *
     * @param sdate 想要修改或者查询的时间参数
     * @param flag  是否最早修改时间当天,true是当天;flase是最早到今天的时间段
     * @return ResultUtil   错误提示数据则直接返回页面,null则继续操作
     */
    public ResultUtil checkPreOption(String sdate, boolean flag)  {
        List<SysDictVal> dictVals = sysDictValService.findDictValsByTableId(127);
        if (null != dictVals && dictVals.size() > 0) {
            SysDictVal sysDictVal = dictVals.get(0);
            String val = sysDictVal.getVal();
            if (StrUtil.isEmpty(val) || !DateUtil.isDate(val.trim())) {
                return ResultUtil.error(msg);
            }
            if (flag) {//需要判断是最早可修改当天
                if (!sdate.equals(val.trim())) {//不是当天
                    return ResultUtil.error("当前时间:" + sdate + " 不可初始化," + val + " 可初始化");
                } else {
                    return null;
                }
            } else {//只需要判断在最早和今天范围内
                boolean in = DateUtil.isIn(DateUtil.parse(sdate), DateUtil.parse(val), DateUtil.parse(DateUtil.today()));
                if (in) {
                    return null;
                } else {
                    return ResultUtil.error("当前时间:" + sdate + " 的日志不在可修改范围之内," + val + " 到 今天 之间的数据才可可修改");
                }
            }
        } else {
            return ResultUtil.error(msg);
        }
    }

    /**
     * 检查是否自动抽取日志
     * return 1,手动;0,自动
     */
    public ResultUtil checkIsAuto()  {
        List<SysDictVal> dictVals = sysDictValService.findDictValsByTableId(128);
        if (CollUtil.isNotEmpty(dictVals) && dictVals.stream().anyMatch(e -> "手动录入".equals(e.getName()) && 1 == e.getIs_on())) {
            return null;
        } else {
            return ResultUtil.error("当前系统已经配置了自动抽取住院日志信息,无需手动抽取!");
        }
    }
}
