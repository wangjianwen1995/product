package com.sxdl.fm.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.fm.dao.dao2.FmSecondHandlerDao;
import com.sxdl.fm.entity.FmSecondHandler;
import com.sxdl.fm.service.FmSecondHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FmSecondHandlerServiceImpl extends BaseServiceImpl<FmSecondHandler> implements FmSecondHandlerService {
    @Autowired
    FmSecondHandlerDao fmSecondHandlerDao;

    static String YS = " W_lfys ", KS = " W_lfks ", insertCondForW = " (dm,mc) values('",sql;

    @Override
    public List<Map<String, Object>> selectWys() {
        return fmSecondHandlerDao.selectSqlWithSQL ( " select dm,mc from " + YS );
    }

    @Override
    public List<Map<String, Object>> selectWks() {
        return fmSecondHandlerDao.selectSqlWithSQL ( " select dm,mc from " + KS );
    }

    @Override
    public List<Map<String, Object>> selectWksByName(String name) {
        return fmSecondHandlerDao.selectSqlWithSQL ( " select dm,mc from " + KS + " where mc like '%" + name + "'%" );
    }

    @Override
    public List<Map<String, Object>> selectWksByDm(String dm) {
        return fmSecondHandlerDao.selectSqlWithSQL ( " select dm,mc from " + KS + " where mc like '%" + dm + "'%" );
    }

    @Override
    public List<Map<String, Object>> selectWysByName(String name) {
        return fmSecondHandlerDao.selectSqlWithSQL ( " select dm,mc from " + YS + " where mc like '%" + name + "'%" );
    }

    @Override
    public List<Map<String, Object>> selectWysByDm(String dm) {
        return fmSecondHandlerDao.selectSqlWithSQL ( " select dm,mc from " + YS + " where mc like '%" + dm + "'%" );
    }

    @Override
    public List<Map<String, Object>> selectGzlSum(String sdate, String edate) {
        String sql = "select isnull(sum(mjzrs),0) as mjzrs,isnull(sum(szrs),0) as szrs,isnull(sum(sscs),0) as sscs,isnull(sum(zdssls),0) as zdssls,isnull(sum(yzssls),0) as yzssls,isnull(sum(zqssls),0) as zqssls,isnull(sum(jzssls),0) as jzssls,isnull(sum(xy1h),0) as xy1h,isnull(sum(z1d3h),0) as z1d3h,isnull(sum(dy3h),0) as dy3h,isnull(sum(zlczls),0) as zlczls,isnull(sum(sjssls),0) as sjssls,isnull(sum(wcssls),0) as wcssls,isnull(sum(jrssls),0) as jrssls,isnull(sum(ylqkshls),0) as ylqkshls,isnull(sum(ylqkgrls),0) as ylqkgrls,isnull(sum(ssbfzls),0) as ssbfzls\n" +
                "from T_lf_gzlzb where \n" +
                "creattime between '" + sdate + "'  and '" + edate + "' and ys='合计'";
        List<Map<String, Object>> mapList = fmSecondHandlerDao.selectSqlWithSQL ( sql );
        return mapList;
    }

    @Override
    public Map<Object, Object> selectByYear(String sDate1, String edate1, String sDate2, String eDate2, String sDate3, String eDate3, String nameParam, int year) {
        Map<Object, Object> map = new HashMap<> ();
        List<Map<String, Object>> s1 = selectSome ( sDate1, edate1, nameParam );
        List<Map<String, Object>> s2 = selectSome ( sDate2, eDate2, nameParam );
        List<Map<String, Object>> s3 = selectSome ( sDate3, eDate3, nameParam );
        List<Integer> x = new ArrayList<> ();
        List<Object> y = new ArrayList<> ();

        if (year == 1) {
            x.add ( 11 );
            x.add ( 12 );
            x.add ( year );
        } else if (year == 2) {
            x.add ( 12 );
            x.add ( year - 1 );
            x.add ( year );
        } else {
            x.add ( year - 2 );
            x.add ( year - 1 );
            x.add ( year );
        }
        y.add ( s3.get ( 0 ) != null && s3.get ( 0 ).size () > 0 ? s3.get ( 0 ).get ( nameParam ) : 0 );
        y.add ( s2.get ( 0 ) != null && s2.get ( 0 ).size () > 0 ? s2.get ( 0 ).get ( nameParam ) : 0 );
        y.add ( s1.get ( 0 ) != null && s1.get ( 0 ).size () > 0 ? s1.get ( 0 ).get ( nameParam ) : 0 );
        map.put ( "x", x );
        map.put ( "y", y );
        return map;
    }

    @Override
    public List<Map<String, Object>>  findBySd(String sDate, String eDate) {
        Map<Object, Object> map = new HashMap<> ();
        List<String> x = new ArrayList<> ();
        List<String> y = new ArrayList<> ();
        String cxSql = "select isnull(COUNT(caseId),0) ls,sd_info_name  from T_fm_sdinfo where cysj  between '" + sDate + "'  and  '" + eDate + "' group by sd_info_name order by ls desc";
        List<Map<String, Object>> mapList = fmSecondHandlerDao.selectSqlWithSQL ( cxSql );

        return mapList;
    }

    @Override
    public List<Map<String, Object>>  findByKsAndSd(String sDate, String eDate, String sid) {
        Map<Object, Object> map = new HashMap<> ();
        String cxSql = "select cast (SUM(zyts)*1.0/COUNT(*) as decimal(18,2)) pjts,cast (sum(zfy)*1.0/COUNT(*) as decimal(18,2)) pjfy,\n" +
                "cast (sum(sfsw)*100.0/COUNT(*) as decimal(18,2)) swl, isnull((select count(cyks) from T_fm_sdinfo b  where \n" +
                "cfts<=15 and cfts>1 and a.cyks=b.cyks group by cyks  ) ,0) cf15, isnull((select count(cyks) from T_fm_sdinfo b where \n" +
                "cfts<=1 and cfts>0 and a.cyks=b.cyks group by cyks ),0)cf1, isnull((select count(cyks) from T_fm_sdinfo  b where  \n" +
                "cfts<=30 and cfts>15 and a.cyks=b.cyks group by cyks ),0)cf30, c.mc  cyks from T_fm_sdinfo  a left join W_lf_baks c on a.cyks=c.dm where cysj \n" +
                "between '" + sDate + "'  and  '" + eDate + "' and sd_info_id= "+ sid+ " group by cyks,c.mc order by  pjfy desc";
        List<Map<String, Object>> mapList = fmSecondHandlerDao.selectSqlWithSQL ( cxSql );

        return mapList;
    }

    @Override
    public List<Map<String, Object>> findSd() {
        Map<Object, Object> map = new HashMap<> ();
        String cxSql ="select dm,mc  from W_fm_sd_info";
        List<Map<String, Object>> mapList = fmSecondHandlerDao.selectSqlWithSQL ( cxSql );
        return mapList;
    }

    @Override
    public List<Map<String, Object>> selectByHBTB(String sDate, String eDate, LocalDate hbsDate, LocalDate hbeDate, LocalDate tbsDate, LocalDate tbeDate, String nameParam) {
        String sql = "select d.kh as ks,sum(szrs) szrs ,sum(hb) hb,sum(tb) tb from (select a.kh,  sum(" + nameParam + ") szrs ,isnull(( sum (" + nameParam + ")-b.hbz)/b.hbz,0) as hb, isnull( ( sum (" + nameParam + ")-d.tbz)/d.tbz ,0)tb  \n" +
                "from T_lf_gzlzb  a\n" +
                "left join (select c.kh, sum(c." + nameParam + ") hbz  from T_lf_gzlzb c \n" +
                "where c.kh!='合计' and c.kh!='平均值' and c.kh!='最大值' and c.kh!='最小值' \n" +
                "and creattime>='" + hbsDate + "' and creattime<='" + hbeDate + "' \n" +
                "and " + nameParam + " >0 \n" +
                "GROUP BY c.kh) b on a.kh=b.kh\n" +
                "\n" +
                "left join (select e.kh, sum(e." + nameParam + ") tbz  from T_lf_gzlzb e \n" +
                "where e.kh!='合计' and e.kh!='平均值' and e.kh!='最大值' and e.kh!='最小值' \n" +
                "and creattime>='" + tbsDate + "' and creattime<='" + tbeDate + "' \n" +
                "and " + nameParam + " >0 \n" +
                "GROUP BY e.kh) d\n" +
                "on a.kh=d.kh\n" +
                "where a.kh!='合计' and a.kh!='平均值' and a.kh!='最大值' and a.kh!='最小值' \n" +
                "and creattime>='" + sDate + "' and creattime<='" + eDate + "' \n" +
                "and " + nameParam + " >0 \n" +
                "GROUP BY a.kh,b.hbz,d.tbz ) d GROUP  BY d.kh order by szrs DESC";
        List<Map<String, Object>> mapList = fmSecondHandlerDao.selectSqlWithSQL ( sql );
        List<Map<String, Object>> sum = selectBytbhuSum ( sDate, eDate, hbsDate, hbeDate, tbsDate, tbeDate, nameParam );
        if (sum != null && sum.size () > 0) {
            if (sum.get ( 0 ) != null && sum.get ( 0 ).size () > 0) {
                mapList.add ( 0, sum.get ( 0 ) );
            }
        }
        return mapList;
    }

    private List<Map<String, Object>> selectSome(String sDate1, String edate1, String nameParam) {
        String sql = "select  sum(" + nameParam + ") as " + nameParam + " from T_lf_gzlzb where \n" +
                "creattime between  '" + sDate1 + "'  and  '" + edate1 + "'  and ys='合计' ";
        List<Map<String, Object>> mapList = fmSecondHandlerDao.selectSqlWithSQL ( sql );
        return mapList;
    }


    public Map<String, Object> selectByKs(String sDate1, String edate1, String nameParam, String ks) {
        Map<String, Object> map = new HashMap<> ();
        String sql = "select ys, sum(" + nameParam + ") as mjzrs  from T_lf_gzlzb \n" +
                "where ys!='合计' and ys!='平均值' and ys!='最大值' and ys!='最小值' \n" +
                "and creattime between  '" + sDate1 + "'  and  '" + edate1 + "' \n" +
                "and kh='" + ks + "'\n" +
                "and " + nameParam + " >0 \n" +
                "GROUP BY ys \n" +
                "ORDER BY sum(" + nameParam + ") DESC";
        List<Map<String, Object>> mapList = fmSecondHandlerDao.selectSqlWithSQL ( sql );
        String sql_avg = "select  cast(round(avg (b.mjzrs),2)   as    numeric(20,2))  as avg  from (select ys,  sum(" + nameParam + ") as  mjzrs from T_lf_gzlzb \n" +
                "where ys!='合计' and ys!='平均值' and ys!='最大值' and ys!='最小值' \n" +
                "and creattime between  '" + sDate1 + "'  and  '" + edate1 + "' \n" +
                "and kh='" + ks + "'\n" +
                "and " + nameParam + " >0 \n" +
                "GROUP BY ys ) b ";
        List<Map<String, Object>> avg = fmSecondHandlerDao.selectSqlWithSQL ( sql_avg );
        map.put ( "avg", avg );
        map.put ( "ys", mapList );
        return map;
    }


    private List<Map<String, Object>> selectBytbhuSum(String sDate, String eDate, LocalDate hbsDate, LocalDate hbeDate, LocalDate tbsDate, LocalDate tbeDate, String nameParam) {
        String sql = "select ks , sum(" + nameParam + ")  szrs ,sum (isnull((" + nameParam + "-b.hbz)/b.hbz,0)) as hb, sum (isnull( (yzssls-d.tbz)/d.tbz ,0))tb  \n" +
                "from T_lf_gzlzb  a,\n" +
                "(select sum(c." + nameParam + ") hbz  from T_lf_gzlzb c \n" +
                "where ys='合计' \n" +
                "and creattime>='" + hbsDate + "' and creattime<='" + hbeDate + "' \n" +
                "and " + nameParam + " >0 \n" +
                ") b , (select sum(e." + nameParam + ") tbz  from T_lf_gzlzb e \n" +
                "where ys='合计'\n" +
                "and creattime>='" + tbsDate + "' and creattime<='" + tbeDate + "' \n" +
                "and " + nameParam + " >0) d \n" +
                "where ys='合计'\n" +
                "and creattime>='" + sDate + "' and creattime<='" + eDate + "' \n" +
                "and " + nameParam + ">0 group by ks ";
        List<Map<String, Object>> mapList = fmSecondHandlerDao.selectSqlWithSQL ( sql );
        return mapList;
    }

    private List<Map<String, Object>> selectByKsAvg(String sDate1, String edate1, String nameParam, String ks) {
        String sql_avg = "select  cast(round(avg (b.mjzrs),2)   as    numeric(20,2))  as avg  from (select ys,  sum(" + nameParam + ") as " + nameParam + " from T_lf_gzlzb \n" +
                "where ys!='合计' and ys!='平均值' and ys!='最大值' and ys!='最小值' \n" +
                "and creattime between  '" + sDate1 + "'  and  '" + edate1 + "' \n" +
                "and ks='" + ks + "'\n" +
                "and " + nameParam + " >0 \n" +
                "GROUP BY ys ) b ";
        List<Map<String, Object>> mapList = fmSecondHandlerDao.selectSqlWithSQL ( sql_avg );
        return mapList;
    }

    @Override
    public void updateWFromDrgs(Integer type) {
        if(null==type ||type<=0||type >=6) return ;
        switch (type) {
            case 1:
                sql = "insert into W_fm_drgs_kzr  select distinct kzr,kzr from T_fm_drgs_dr where kzr is not null and kzr not in (select dm from W_fm_drgs_kzr )";
                break;
            case 2:
                sql = "insert into W_fm_drgs_zrys  select distinct zrys,zrys from T_fm_drgs_dr where zrys is not null and zrys not in (select dm from W_fm_drgs_zrys )";
                break;
            case 3:
                sql = "insert into W_fm_drgs_zzys  select distinct zzys,zzys from T_fm_drgs_dr where zzys is not null and zzys not in (select dm from W_fm_drgs_zzys )";
                break;
            case 4:
                sql = "insert into W_fm_drgs_zyys  select distinct zyys,zyys from T_fm_drgs_dr where zyys is not null and zyys not in (select dm from W_fm_drgs_zyys )";
                break;
            case 5:
                sql=" MERGE INTO T_fm_drgs_dr a USING T_fm_drgs_dr_temp b ON ( a.bah= b.bah AND a.cyrq= b.cyrq ) " +
                        " WHEN matched THEN UPDATE " +
                        " SET a.biyear=b.biyear,a.biquarter=b.biquarter,a.bimonth=b.bimonth,a.biweek=b.biweek," +
                        "a.bah=b.bah,a.ryrq=b.ryrq,a.cyrq=b.cyrq,a.lyfs=b.lyfs,a.xm=b.xm,a.xb=b.xb,a.nl=b.nl,a.cyks=b.cyks,a.zyts=b.zyts," +
                        "a.drgsbm=b.drgsbm,a.drgsmc=b.drgsmc,a.bzmc=b.bzmc,a.rw=b.rw,a.zyzdbm=b.zyzdbm,a.zyzdmc=b.zyzdmc,a.dyssbm=b.dyssbm," +
                        "a.dyssmc=b.dyssmc,a.zfy=b.zfy,a.xyf=b.xyf,a.zyf=b.zyf,a.hcf=b.hcf,a.kzr=b.kzr,a.zrys=b.zrys,a.zzys=b.zzys,a.zyys=b.zyys" +
                        " WHEN NOT matched THEN " +
                        " INSERT ( biyear, biquarter, bimonth, biweek, bah, ryrq, cyrq, lyfs, xm, xb, nl, cyks, zyts, drgsbm, drgsmc, bzmc, rw, zyzdbm, zyzdmc, dyssbm, dyssmc, zfy, xyf, zyf, hcf, kzr, zrys, zzys, zyys ) " +
                        " VALUES " +
                        "( biyear, biquarter, bimonth, biweek, bah, ryrq, cyrq, lyfs, xm, xb, nl, cyks, zyts, drgsbm, drgsmc, bzmc, rw, zyzdbm, zyzdmc, dyssbm, dyssmc, zfy, xyf, zyf, hcf, kzr, zrys, zzys, zyys );";
                break;
        }
        fmSecondHandlerDao.selectSqlWithSQL(sql);
    }

    @Override
    public List<Map<String, Object>> selectIndexCYZY() {
        String yestoday=LocalDate.now().plusDays(-1).toString();
        sql="SELECT (" +
                "SELECT COUNT( rysj ) " +
                "\tFROM\n" +
                "\t\tT_lf_ryhzinfo \n" +
                "\tWHERE\n" +
                "\t\trysj IS NOT NULL \n" +
                "\t\tAND cysj IS NULL \n" +
                "\t\tAND rysj > dateadd( YEAR, - 1, GETDATE( ) ) \n" +
                "\t) AS 昨日在院患者总数,\n" +
                "\t(\n" +
                "\tSELECT COUNT( rysj ) \n" +
                "\tFROM\n" +
                "\t\tT_lf_ryhzinfo \n" +
                "\tWHERE\n" +
                "\t\trysj IS NOT NULL \n" +
                "\t\tAND cysj IS NOT NULL \n" +
                "\t\tAND rysj > dateadd( YEAR, - 1, GETDATE( ) ) \n" +
                "\t\tAND cysj BETWEEN '"+yestoday+" 00:00:00' \n" +
                "\tAND '"+yestoday+" 23:59:59' \n" +
                "\t) AS 昨日出院患者总数";
        return fmSecondHandlerDao.selectSqlWithSQL(sql);
    }

    ;
    //    @Override
//    public Integer insertWys(String dm,String mc){
//        return fmSecondHandlerDao.updateSqlWithSQL(" insert into "+YS+insertCondForW+dm+"','"+mc+"')");
//    }
//    @Override
//    public Integer insertWks(String dm,String mc){
//        return fmSecondHandlerDao.updateSqlWithSQL(" insert into "+KS+insertCondForW+dm+"','"+mc+"')");
//    }
//
//    @Override
//    public Integer deleteWys(String dm){
//        return fmSecondHandlerDao.updateSqlWithSQL(" DELETE from "+YS+" where dm='"+dm+"'");
//    }
//    @Override
//    public Integer deleteWks(String dm){
//        return fmSecondHandlerDao.updateSqlWithSQL(" DELETE from "+KS+" where dm='"+dm+"'");
//    }
}
