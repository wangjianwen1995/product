package com.sxdl.hpqc.service;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.*;
import com.sxdl.hpqc.dao.dao1.*;
import com.sxdl.hpqc.dbo.QualityDBO;
import com.sxdl.hpqc.entity.*;
import com.sxdl.hpqc.util.HpqcApplicationRunnerImpl;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Transactional
public class HpQcHomepageLinkService extends BaseUUIDServiceImpl<HomepageQcLinkEntity> {
    @Autowired
    private HpQcHomepageLinkDao hpQcHomepageLinkDao;
    private Map result;
    String hid, bah, zxflag, level;
    List<HpQcResult> dlResults, rzResults, hpQcResults, wzlResults, fzbmResults, hlResults;
    List<Map<String, Object>> maps;
    @Autowired
    private HpQcWzlDao hpQcWzlDao;
    @Autowired
    private HpQcResultDao hpQcResultDao;
    @Autowired
    private HpQcPfService hpQcPfService;
    @Autowired
    private HpQcBzService hpQcBzService;


    @Autowired
    HpQcPfResultDao hpQcPfResultDao;


    public List<Map<String, Object>> insertOrUpdate(HomepageQcLinkEntity homepageQcLinkEntity,String level) {
        bah = homepageQcLinkEntity.getBAH();
        String cysj = DateUtil.formatFromDate(homepageQcLinkEntity.getCYSJ());
        zxflag = homepageQcLinkEntity.getZXFLAG();
       /* hpQcHomepageLinkDao.deleteByBah(bah);
        homepageQcLinkEntity.setIS_LINK("1");
        homepageQcLinkEntity.setZKRQ(DateUtil.strToDate(DateUtil.formatFromDate2(new Date())));
        homepageQcLinkEntity.setId(null);
        hpQcHomepageLinkDao.insertSelective(homepageQcLinkEntity);*/
        insertByEntity(homepageQcLinkEntity);
        List<Map<String, Object>> mapList = qmByBah(bah, cysj, zxflag,level);
        return mapList;
       /* result = new HashMap<String, List>();
        String hid = homepageQcLinkEntity.getId();
        //??????????????????
        Boolean verify = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
        if (!verify) {
            level = "1";
        } else {
            level = (String) HpqcApplicationRunnerImpl.contextMap.get("level");
            if (StringUtil.isEmpty(level)) {
                level = "1";
            }
        }
        //TODO ?????????
        //level = "2";
       *//* hpQcWzlDao.excuteQualityByBah("p_hjzk_run", bah, level);
        result = selectByBah(hid, "1", zxflag);*//*
        String sql = "SELECT b.* into ##Tempomepage FROM  homepage_link  b with(nolock) Where  CONVERT(varchar(100), case when isdate(convert(varchar,b.cysj)) =1 then  \n" +
                "   cast (b.cysj as datetime) else convert(varchar(19),b.cysj) end , 23) between ''" + cysj + "'' and ''" + cysj + "''";
        if (StringUtil.isNotEmpty(StringUtil.trim(bah))) {
            sql += " and bah=''" + bah + "''";
        }
        List<Map<String, Object>> mapList = hpQcWzlDao.excuteQualityByDate("p_zmzk_run", cysj, cysj, level, sql, "homepage_link", "1", "1");*/



    }

    public List<HomepageQcLinkEntity> selectByCysj(String sdate, String edate) {
        return hpQcHomepageLinkDao.selectByCysj(sdate, edate);
    }


    public List<HomepageQcLinkEntity> selectById(String id) {
        return hpQcHomepageLinkDao.selectById(id);
    }

    @Autowired
    YmlUtil ymlUtil;

    public PageInfo selectSome(String sdate, String edate, String cykb, String bahorxm, PageInfo pageInfo, Integer is_link) {
        String sql1 = "";
        //String sql2 = "";
        String sql3 = "";

        String columnsSql = "  case when  t.status=1 then '?????????' when t.status=2 then '?????????' when a.status=4 then '?????????' else '?????????' end as status,a.A_id ,DateName(year,a.CYSJ)  CHYear,isnull (a.zxflag,'1') zxflag,isnull(a.bah,'??????') bah ,isnull(a.xm,'??????')  xm   ,isnull(a.cykb,'??????') cykb ,case when isnull(a.cykbmc,'')!='' then cykbmc else  isnull(a.cykb,'??????') end cykbmc ,isnull(CONVERT(varchar(100), a.CYSJ, 120),'???')   CYSJ  ,\n" +
                "isnull(ZYZD_JBBM,'???')ZYZD_JBBM ,isnull(zyzd,'???') zyzd,isnull(SSJCZBM1,'???')  SSJCZBM1   , isnull(SSJCZMC1,'???') SSJCZMC1 ,isnull(zyys,'??????')   zyys  ,isnull(bmy,'??????')    bmy \n";
        String fromAndWhereSql = " from  " + ymlUtil.getYmlValueOrDefault("qcTable", "homepage_link") + " a WITH(NOLOCK) left join ( select distinct bah,time, case when  isnull(c.can_forced,0)=1 then 1 when isnull(c.can_forced,0)=0 then  2 else 0 end as status  from hp_link_result c   WITH(NOLOCK) where c.is_link=" + is_link + " and c.can_forced=1 \n" +
                " !!! and qc_time=(select max( l.qc_time )  from  hp_qm_log l WITH(NOLOCK) left join  hp_link_result B  WITH(NOLOCK) on l.id=b.qc_id  where b.is_link=" + is_link + " and c.can_forced=b.can_forced and c.[bah]=B.[bah] and c.time=b.time and c.cykb=b.cykb " +
                "   ))t   on a.BAH=t.bah and a.CYSJ=t.[time]\n" +
                " where 1=1    ###   \n";
        if (StringUtil.isNotEmpty(sdate.trim()) && StringUtil.isNotEmpty(edate.trim())) {
            //fromAndWhereSql += " and convert(varchar(10),c.time,23) between '" + sdate + "'  and '" + edate + "'";
            sql1 += "and c.time between '" + sdate + "'  and '" + edate + "'";
            // sql2 += "and convert(varchar(10),b.time,23) between '" + sdate + "'  and '" + edate + "'";
            sql3 += "and a.cysj between '" + sdate + "'  and '" + edate + "'";
        }
        if (StringUtil.isNotEmpty(cykb)) {
            sql1 += " and c.cykb='" + cykb + "'";
            // sql2 += " and b.cykb='" + cykb + "'";
            sql3 += " and a.cykb='" + cykb + "'";
        }
        if (StringUtil.isNotEmpty(bahorxm)) {
            sql1 += " and c.bah='" + bahorxm + "'";
            //sql2 += " and b.bah='" + bahorxm + "'";
            sql3 += " and a.bah='" + bahorxm + "'";

        }
        fromAndWhereSql = fromAndWhereSql.replaceAll("!!!", sql1);
        //fromAndWhereSql = fromAndWhereSql.replaceAll("@@@", sql2);
        fromAndWhereSql = fromAndWhereSql.replaceAll("###", sql3);
        //columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, "a.cysj,a.bah", pageInfo, false);
        System.out.println(columnsSql);
        pageInfo = selectPageinfoWithSQL(columnsSql, fromAndWhereSql, "a.cysj,a.bah", pageInfo, false);
        return pageInfo;
    }

    public Map selectByBah(String bah, String is_link, String zxflag,String level) {

        result = new HashMap<String, List>();
        //???????????? ??????????????????????????????
        List<HpQcPfResultEntity> pfResults = hpQcPfResultDao.selectbyBahAndFirst(bah, "desc", is_link, "a");
        //??????
        result = hpQcPfService.getPfInfo(bah, result, zxflag, pfResults);
        maps = new ArrayList<>();
        //?????????
        List<HpQcResult> wzlResults = hpQcResultDao.selectbyClassify("1,2,3", bah, is_link);
        result.put("wzl", wzlResults);
        //??????????????????(????????????)
        List<HpQcResult> hpQcResults = hpQcResultDao.selectbyClassify("5", bah, is_link);
        result.put("zd", hpQcResults);
        //??????????????????(??????????????????)   ????????????????????????????????????????????????????????????????????????????????????????????????????????????
       // dlResults = hpQcResultDao.selectbyClassify("4", bah, is_link);
        hlResults = new ArrayList<>();
        rzResults = new ArrayList<>();
        fzbmResults = new ArrayList<>();
        hlResults = hpQcResultDao.selectbyClassify("7", bah, is_link);
        if (level.equals("2")) {
            //?????? ???????????????????????????
            rzResults = hpQcResultDao.selectbyClassify("9", bah, is_link);
            fzbmResults = hpQcResultDao.selectbyClassify("10", bah, is_link);
        }
        //result.put("zh", dlResults);
        result.put("hl", hlResults);
        result.put("rz", rzResults);
        result.put("fzbm", fzbmResults);
        if (CollUtil.isNotEmpty(wzlResults) || CollUtil.isNotEmpty(hpQcResults) || (CollUtil.isNotEmpty(hlResults) && hlResults.stream().anyMatch(e -> null != e && 1 == e.getCan_forced())) || (CollUtil.isNotEmpty(rzResults) && rzResults.stream().anyMatch(e -> null != e && 1 == e.getCan_forced()))) {
            result.put("msg", "?????????????????????");
        } else {
            result.put("msg", "?????????????????????");
        }
        return result;
    }


    public Map selectByBahAndFirst(String bah, String is_link, String zxflag, String ascDesc, String ab,String level) {
        /*String level;
        Boolean verify = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
        if (!verify) {
            level = "1";
        } else {
            level = (String) HpqcApplicationRunnerImpl.contextMap.get("level");
            if (StringUtil.isEmpty(level)) {
                level = "1";
            }
        }*/
        result = new HashMap<String, List>();

        maps = new ArrayList<>();
        List<HpQcPfResultEntity> pfResults = hpQcPfResultDao.selectbyBahAndFirst(bah, ascDesc, is_link, ab);
        //??????
        result = hpQcPfService.getPfInfo(bah, result, zxflag, pfResults);
        wzlResults = new ArrayList<>();
        hpQcResults = new ArrayList<>();
        //dlResults = new ArrayList<>();
        rzResults = new ArrayList<>();
        fzbmResults = new ArrayList<>();
        hlResults = new ArrayList<>();


        //??????????????????????????????
        List<HpQcResult> Results = hpQcResultDao.selectbyBahAndFirst(bah, is_link, ascDesc, ab);
        //?????????????????? ??????
        Map<Integer, List<HpQcResult>> ResultsMap = Results.stream().filter(e -> null != e).collect(Collectors.groupingBy(e -> e.getClassify_id()));
        if (ResultsMap.containsKey(1)) {
            wzlResults = ResultsMap.get(1);
        }
        if (ResultsMap.containsKey(2)) {
            wzlResults.addAll(ResultsMap.get(2));
        }
        if (ResultsMap.containsKey(3)) {
            wzlResults.addAll(ResultsMap.get(3));
        }
        if (ResultsMap.containsKey(5)) {
            hpQcResults = ResultsMap.get(5);
        }
       /* if (ResultsMap.containsKey(4)) {
            dlResults = ResultsMap.get(4);
        }*/
        if (ResultsMap.containsKey(7)) {
            hlResults = ResultsMap.get(7);
        }
        if (level.equals("2")) {
            if (ResultsMap.containsKey(9)) {
                rzResults = ResultsMap.get(9);
            }
            if (ResultsMap.containsKey(10)) {
                fzbmResults = ResultsMap.get(10);
            }
        }
        result.put("wzl", wzlResults);
        result.put("zd", hpQcResults);
        //result.put("zh", dlResults);
        result.put("hl", hlResults);
        result.put("rz", rzResults);
        result.put("fzbm", fzbmResults);
     /*   if (CollUtil.isNotEmpty(wzlResults) || CollUtil.isNotEmpty(hpQcResults) || (CollUtil.isNotEmpty(dlResults) && dlResults.stream().anyMatch(e -> null != e && 1 == e.getCan_forced())) || (CollUtil.isNotEmpty(hlResults) && hlResults.stream().anyMatch(e -> null != e && 1 == e.getCan_forced()))) {
            result.put("msg", "?????????????????????");
        } else {
            result.put("msg", "?????????????????????");
        }*/
        return result;
    }

    public PageInfo findQmNumber(String sdate, String edate, String cykb, String platform_on,
                                 PageInfo pageInfo, Integer is_link, String classfiy_id, String order, boolean ascDesc, String table_name) {

        String sql1 = "";
        String sql2 = "";
        String sql = "";
        String columnsSql = " case when  a.home_type=1 then '????????????' when a.home_type=2 then '????????????' when a.home_type=3 then '????????????' when a.home_type=4 then '????????????'  else '????????????' end  as homeType, a.classify,case when  can_forced=1 then '[??????]'+a.message  else '[??????]'+a.message end as message,COUNT(a.message) num,fields as messsage_id ";
        String fromAndWhereSql = "from " + table_name + " a WITH(NOLOCK)  where  \n" +
               // "  a.qc_time=(select max( l.qc_time )  from  hp_qm_log l   WITH(NOLOCK) left join   " + table_name + "  b  WITH(NOLOCK) on l.id=b.qc_id  where 1=1  @@@ ) !!!" +
                // "and b.classify_id  in ("+classfiy_id+" ) \n" +
                " 1 > (select count(*) from hp_link_result WITH(NOLOCK)  where bah = a.bah and qc_time > a.qc_time ) \n" +
                " and 1> (select count(*) from hp_qm_log WITH(NOLOCK)  where  id = a.qc_id and qc_time > a.qc_time ) !!! \n" +
                " group by a.home_type, a.classify,a.can_forced ,a.message,a.fields";
        if (StringUtil.isNotEmpty(StringUtil.trim(sdate)) && StringUtil.isNotEmpty(StringUtil.trim(edate))) {

            sql1 += "and a.time between '" + sdate + "'  and '" + edate + "'";

        }
        if (StringUtil.isNotEmpty(StringUtil.trim(cykb))) {
            sql1 += " and a.cykb='" + cykb + "'";

        }
        if (!classfiy_id.contains("6")) {
            sql1 += " and a.platform_on like '%" + platform_on + "%'";
            sql1 += "  and a.classify_id in ( " + classfiy_id + " )";
        }
        fromAndWhereSql = fromAndWhereSql.replaceAll("!!!", sql1);

        if (StringUtil.isEmpty(StringUtil.trim(order))) {
            order = " COUNT(a.message) ";
        }
        if (null == pageInfo) {
            pageInfo = new PageInfo();
            sql = SQLPackageUtil.getNotPageSQL(columnsSql, fromAndWhereSql, order, ascDesc);
        } else {
            sql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, order, pageInfo, ascDesc);
        }
       // System.out.println(sql);
        List<Map<String, Object>> maps = selectSqlWithSQL(sql);
        long cnt = selectCountWithSQL1(columnsSql, fromAndWhereSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(cnt);

        //pageInfo = selectPageinfoWithSQL(columnsSql, fromAndWhereSql, order, pageInfo, ascDesc);
        return pageInfo;
    }


    public PageInfo findQmByMessage(String sdate, String edate, String cykb, String platform_on, PageInfo pageInfo, Integer is_link,
                                    String classfiy_id, String order, boolean ascDesc, String table_name, String message, String bah) {
        String sql1 = "";
        String sql2 = "";
        String sql = "";
        String columnsSql = " h.id ,h.A_ID,DateName(year,h.CYSJ)  CHYear\n" +
                ",isnull (h.zxflag,'1') zxflag,isnull(a.bah,'??????') bah ,isnull(h.xm,'??????')  xm   ,isnull(h.cykb,'??????') cykb ,\n" +
                "case when isnull(h.cykbmc,'')!='' then cykbmc else  isnull(h.cykb,'??????') end cykbmc ,isnull(CONVERT(varchar(100), h.CYSJ, 120),'???')CYSJ  ,\n" +
                "isnull(ZYZD_JBBM,'???')ZYZD_JBBM ,isnull(zyzd,'???') zyzd,isnull(SSJCZBM1,'???')  SSJCZBM1   , isnull(SSJCZMC1,'???') SSJCZMC1 ,\n" +
                "isnull(zyys,'??????')   zyys  ,isnull(bmy,'??????')    bmy ,isnull(zycs,0) zycs,a.message ";

        String fromAndWhereSql = "from " + table_name + " a  WITH(NOLOCK) left join dl_merge.dbo.homepage h on  a.bah=h.bah and a.time=h.cysj and a.cykb=h.cykb  where  \n" +
                " 1 > (select count(*) from hp_link_result WITH(NOLOCK)  where bah = a.bah and qc_time > a.qc_time ) \n" +
                " and 1> (select count(*) from hp_qm_log WITH(NOLOCK)  where  id = a.qc_id and qc_time > a.qc_time ) !!! " ;
              //  "  a.qc_time=(select max( l.qc_time )  from  hp_qm_log l left join   " + table_name + "  b on l.id=b.qc_id where 1=1  @@@ ) !!!";


        if (StringUtil.isNotEmpty(StringUtil.trim(sdate)) && StringUtil.isNotEmpty(StringUtil.trim(edate))) {
            sql1 += "and a.time between '" + sdate + "'  and '" + edate + "'";
           // sql2 += "and b.time between '" + sdate + "'  and '" + edate + "'";
        }
        if (StringUtil.isNotEmpty(StringUtil.trim(cykb))) {
            sql1 += " and a.cykb='" + cykb + "'";
            //sql2 += " and b.cykb='" + cykb + "'";
        }
        if (StringUtil.isNotEmpty(StringUtil.trim(message))) {
            sql1 += " and a.fields='" + message + "' ";
        }
        if (!classfiy_id.contains("6")) {
            sql1 += " and a.platform_on like '%" + platform_on + "%'";
            sql1 += "  and a.classify_id in ( " + classfiy_id + " )";
        }

        if (StringUtil.isNotEmpty(StringUtil.trim(bah))) {
            sql1 += " and h.bah='" + bah + "'";

        }
        fromAndWhereSql = fromAndWhereSql.replaceAll("!!!", sql1);
        if (StringUtil.isEmpty(StringUtil.trim(order))) {
            order = " h.bah,h.cysj ";
        }
        if (null == pageInfo) {
            pageInfo = new PageInfo();
            sql = SQLPackageUtil.getNotPageSQL(columnsSql, fromAndWhereSql, order, ascDesc);
        } else {
            sql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, order, pageInfo, ascDesc);
        }
       // System.out.println(sql);
        List<Map<String, Object>> maps = selectSqlWithSQL(sql);
        long cnt = selectCountWithSQL1(columnsSql, fromAndWhereSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(cnt);

        //pageInfo = selectPageinfoWithSQL(columnsSql, fromAndWhereSql, order, pageInfo, ascDesc);
        return pageInfo;

    }

    public PageInfo findFzbmQmNumber(String sdate, String edate, String cykb, PageInfo pageInfo) {
        String sql1 = "";
        String fzbmNumSql = ymlUtil.getYmlValue("fzbmNumSql");

        if (StringUtil.isNotEmpty(StringUtil.trim(sdate)) && StringUtil.isNotEmpty(StringUtil.trim(edate))) {
            sql1 += "and c.cysj between '" + sdate + "'  and '" + edate + "'";
        }
        if (StringUtil.isNotEmpty(StringUtil.trim(cykb))) {
            sql1 += " and c.cykb='" + cykb + "'";
        }
        fzbmNumSql = fzbmNumSql.replaceAll("@@@", sql1);
        List<Map<String, Object>> mapList = selectSqlWithSQL(fzbmNumSql);
        if (null == pageInfo) {
            pageInfo = new PageInfo();
        }
        if (CollUtil.isNotEmpty(mapList)) {
            if (!"0".equals(mapList.get(0).get("num").toString())) {
                //?????????
                pageInfo.setList(mapList);
                pageInfo.setTotal(1);
                return pageInfo;
            }
        }
        pageInfo.setList(mapList = new ArrayList<>());
        pageInfo.setTotal(0);
        return pageInfo;
    }

    public PageInfo findByfzbmHzSql(String sdate, String edate, String cykb, PageInfo pageInfo) {
        String sql1 = "";
        String fzbmNumSql = ymlUtil.getYmlValue("fzbmHzSql");

        if (StringUtil.isNotEmpty(StringUtil.trim(sdate)) && StringUtil.isNotEmpty(StringUtil.trim(edate))) {
            sql1 += "and c.cysj between '" + sdate + "'  and '" + edate + "'";
        }
        if (StringUtil.isNotEmpty(StringUtil.trim(cykb))) {
            sql1 += " and c.cykb='" + cykb + "'";
        }
        fzbmNumSql = fzbmNumSql.replaceAll("@@@", sql1);
        List<Map<String, Object>> mapList = selectSqlWithSQL(fzbmNumSql);

        if (null == pageInfo) {
            pageInfo = new PageInfo();
            if (CollUtil.isNotEmpty(mapList)) {
                pageInfo.setTotal(mapList.size());
                pageInfo.setList(mapList);
            }
            return pageInfo;
        }
        pageInfo = PageList.getListPage1(pageInfo, mapList);
        return pageInfo;
    }

    public Map selectByBahAndTime(String bah, String is_link, String zxflag, String qc_time, String qc_id,String level) {

        result = new HashMap<String, List>();
        //???????????? ???????????????????????????
        List<HpQcPfResultEntity> pfResults = hpQcPfResultDao.selectbyTime(bah, qc_time, qc_id, is_link);
        //??????
        result = hpQcPfService.getPfInfo(bah, result, zxflag, pfResults);
        maps = new ArrayList<>();
        //?????????
        List<HpQcResult> wzlResults = hpQcResultDao.selectbyClassifyAndTime("1,2,3", bah, is_link, qc_time, qc_id);
        result.put("wzl", wzlResults);
        //??????????????????(????????????)
        List<HpQcResult> hpQcResults = hpQcResultDao.selectbyClassifyAndTime("5", bah, is_link, qc_time, qc_id);
        result.put("zd", hpQcResults);
        //??????????????????(??????????????????)   ????????????????????????????????????????????????????????????????????????????????????????????????????????????

        //dlResults = hpQcResultDao.selectbyClassifyAndTime("4", bah, is_link, qc_time, qc_id);

        hlResults = new ArrayList<>();
        rzResults = new ArrayList<>();
        fzbmResults = new ArrayList<>();

        hlResults = hpQcResultDao.selectbyClassifyAndTime("7", bah, is_link, qc_time, qc_id);
        if (level.equals("2")) {
            //?????? ??????????????????

            rzResults = hpQcResultDao.selectbyClassifyAndTime("9", bah, is_link, qc_time, qc_id);
            fzbmResults = hpQcResultDao.selectbyClassifyAndTime("10", bah, is_link, qc_time, qc_id);
        }
        result.put("zh", dlResults);
        result.put("hl", hlResults);
        result.put("rz", rzResults);
        result.put("fzbm", fzbmResults);
        if (CollUtil.isNotEmpty(wzlResults) || CollUtil.isNotEmpty(hpQcResults) || (CollUtil.isNotEmpty(dlResults) && dlResults.stream().anyMatch(e -> null != e && 1 == e.getCan_forced())) || (CollUtil.isNotEmpty(hlResults) && hlResults.stream().anyMatch(e -> null != e && 1 == e.getCan_forced())) || (CollUtil.isNotEmpty(rzResults) && rzResults.stream().anyMatch(e -> null != e && 1 == e.getCan_forced()))) {
            result.put("msg", "?????????????????????");
        } else {
            result.put("msg", "?????????????????????");
        }
        return result;
    }


    public void insertByEntity(HomepageQcLinkEntity homepageQcLinkEntity) {
        hpQcHomepageLinkDao.deleteByBah(homepageQcLinkEntity.getBAH());
        homepageQcLinkEntity.setIS_LINK("1");
        homepageQcLinkEntity.setZKRQ(DateUtil.strToDate(DateUtil.formatFromDate2(new Date())));
        homepageQcLinkEntity.setId(null);
        hpQcHomepageLinkDao.insertSelective(homepageQcLinkEntity);
    }

    public List<Map<String, Object>> qmByBah(String bah,String cysj,String zxflag,String level) {
        result = new HashMap<String, List>();
        String sql = "SELECT b.* into ##Tempomepage FROM  homepage_link  b  WITH(NOLOCK) Where  CONVERT(varchar(100), case when isdate(convert(varchar,b.cysj)) =1 then  \n" +
                "   cast (b.cysj as datetime) else convert(varchar(19),b.cysj) end , 23) between ''" + cysj + "'' and ''" + cysj + "''";
        if (StringUtil.isNotEmpty(StringUtil.trim(bah))) {
            sql += " and bah=''" + bah + "''";
        }
        List<Map<String, Object>> mapList = hpQcWzlDao.excuteQualityByDate("p_zmzk_run", cysj, cysj, level, sql, "homepage_link", "1", "1");
        return mapList;

    }


}
