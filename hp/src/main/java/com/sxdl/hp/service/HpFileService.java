package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpMidTableDao;
import com.sxdl.hp.entity.HpMidTableEntity;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import com.sxdl.hp.util.PoiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
@Transactional
public class HpFileService extends BaseServiceImpl<HpMidTableEntity> {

    @Autowired
    HpMidTableDao hpMidTableDao;

    @Autowired
    HpBmVersionService hpBmVersionService;
    @Autowired
    HpVsch0AService hpVsch0AService;

    /**
     * 病案管理查询列表
     *
     * @param pageInfo 分页
     * @param strTime  开始时间
     * @param endTime  结束时间
     * @param bah      病历号
     * @param status   状态,0,未归档;1,已归档;2,已录入;4,已审核;5,已废弃;99,全部状态
     * @param kscode   科室code
     * @return 列表
     */
    public PageInfo findAll(PageInfo pageInfo, String strTime, String endTime, String bah, int status, String kscode) {
        Map<String, String> sqlinfos = new HashMap<>();
        if (99 == status) {//全部状态
            StringBuilder sb = new StringBuilder("from (select ");
            sqlinfos = getAfterBas("CH0A27", bah, kscode, strTime, endTime, "'2','4','5'");
            sb.append(sqlinfos.get("col")).append(sqlinfos.get("from")).append(" union select ");
            sqlinfos = getFiledBas("cyrq", bah, kscode, strTime, endTime);
            sb.append(sqlinfos.get("col")).append(sqlinfos.get("from")).append(" union select ");
            sqlinfos = getUnFileBas("ch0m27", bah, kscode, strTime, endTime);
            sb.append(sqlinfos.get("col")).append(sqlinfos.get("from")).append(") alll");
            sqlinfos = getRetrun("cyrq", "*", sb.toString());
            String sql = SQLPackageUtil.getPageSQL(sqlinfos.get("col"), sqlinfos.get("from"), sqlinfos.get("order"), pageInfo, true);
            pageInfo.setList(selectListWithSQL(sql, HpMidTableEntity.class));
            pageInfo.setTotal(getAllBasCnt(strTime, endTime, bah));
            return pageInfo;
        } else if (0 == status) {//未归档
            sqlinfos = getUnFileBas("ch0m27", bah, kscode, strTime, endTime);
        } else if (1 == status) {//已归档
            sqlinfos = getFiledBas("cyrq", bah, kscode, strTime, endTime);
        } else if (2 == status || 4 == status || 5 == status) {//已录入,已审核,已排除
            sqlinfos = getAfterBas("CH0A27", bah, kscode, strTime, endTime, "'" + status + "'");
        } else {
            return pageInfo;
        }
        pageInfo = selectPageinfoWithSQL(HpMidTableEntity.class, sqlinfos.get("col"), sqlinfos.get("from"), sqlinfos.get("order"), pageInfo, false);
        return pageInfo;
    }

    /**
     * 获取全部状态下的病案号总数sql
     */
    Integer getAllBasCnt(String strTime, String endTime, String bah) {
        String sqls = "select count(DISTINCT bah) cnt from (" +
                "select ch0a01 bah from VsCH0A where isnull(ch0a01,'')!='' and ISNULL(status,'') in ('2','4','5')  @@ " +
                "UNION " +
                "select ch0m01 bah " +
                "from dcLinkvsch_PatientInfo where isnull(ch0m01,'')!='' @@@@ ) a", w1 = "", w2 = "";
        if (StrUtil.isNotEmpty(bah)) {
            w1 = " and ch0a01 like '%" + bah + "%'";
            w2 = " and ch0m01 like '%" + bah + "%'";
        } else if (StrUtil.isNotEmpty(strTime)) {
            w1 = " and CH0A27 between '" + strTime + "' and '" + endTime + "'  ";
            w2 = " and ch0m27 between '" + strTime + "' and '" + endTime + "'  ";
        }
        return NumberUtil.parseInt(selectSqlWithSQL(sqls.replace("@@@@", w2).replace("@@", w1).replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString())).get(0).get("cnt").toString());
    }

    /**
     * 统一处理sql碎片语句
     */
    Map<String, String> getRetrun(String order, String col, String from) {
        Map<String, String> sqlInfos = new HashMap<>();
        sqlInfos.put("order", order);
        sqlInfos.put("col", col);
        sqlInfos.put("from", from);
        return sqlInfos;
    }

    /**
     * 获取已录入以后的数据的语句
     */
    public Map<String, String> getAfterBas(String order, String bah, String kscode, String strTime, String endTime, String status) {
        String columnsSql = " b.ID as id,CH0A00 as blh,CH0A01 as bah,CH0AZYCS as zycs,CH0A02 as name ," +
                "case when CH0A03=0 then '未知的性别'  when CH0A03=1 then '男'  when CH0A03=2 then '女'  when CH0A03=9 then '未说明的性别'  end   as xb, " +
                "CH0A27 as cyrq, ISNULL(CH0A23,'') as cyksdm,ISNULL(c.name,'') as cyks,CH0A34 as zyys,ISNULL(CH0A34DM,'') as zyysdm, ISNULL(b.status,'') as status," +
                "CHYear as year,@@@@ (select c.CH0C03_Desc  from vsch0C c where b.id=c.A_id and CH0C02=0 ) zzd, " +
                " (select e.CH0E05_Desc  from vsch0E e where b.id=e.A_id and CH0E07=1 ) zss \n";
        String fromAndWhereSql = " from VsCH0A b \n" +
                "left join sys_ks c on b.CH0A23=c.code @@\n" +
                "where ISNULL(b.status,'') in (" + status + ") ", excludeCols = "", excludeTableWhere = "";
        if ("'5'".equals(status)) {
            excludeCols = " d.user_name,d.time,d.reason, ";
            excludeTableWhere = " left join hp_data_cancel d on d.hp_bah = b.ch0a01 and d.type=b.status ";
        }
        if (StrUtil.isNotEmpty(strTime)) {
            fromAndWhereSql += " and CH0A27 between '" + strTime + "' and '" + endTime + "'  ";
        }

        if (!"".equals(bah) && bah != null) {
            fromAndWhereSql += " and CH0A01 like '%" + bah + "%'   ";
        }
        if (!"".equals(kscode) && kscode != null) {
            fromAndWhereSql += " and CH0A23 like '%" + kscode + "%'   ";
        }
        return getRetrun(order, columnsSql.replace("@@@@", excludeCols).replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString()), fromAndWhereSql.replace("@@", excludeTableWhere).replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString()));
    }

    /**
     * 获取已归档数据的语句
     */
    public Map<String, String> getFiledBas(String order, String bah, String kscode, String strTime, String endTime) {
        String columnsSql = "id,blh,bah,zycs,name,xb,cyrq,cyksdm,cyks,zyys,zyysdm,status,year," +
                "( SELECT TOP 1 s.name FROM hp_zdbz s,dcLinkvsch_ch0c vc WHERE (s.code =upper(isnull(vc.ch0c03,'')) or s.use_dm=upper(isnull(vc.ch0c03,'')) or s.name=isnull(vc.ch0c03_desc,'') or s.use_mc=isnull(vc.ch0c03_desc,'')) and vc.ch0c01=bah order by ch0c02 asc) zzd," +
                "( SELECT TOP 1 s.name FROM hp_ssbz s,dcLinkvsch_CH0E ve WHERE (s.code = isnull( ve.CH0E05, '' ) OR isnull( ve.CH0E05, '' ) = s.use_dm OR s.name= ve.ch0e05_desc OR s.use_mc= ve.CH0E05_Desc) and ve.ch0e01=bah order by ch0e07 asc) zss ";
        String fromAndWhereSql = " from hp_mid_table where status= '1' and bah not in(select ch0a01 from vsch0a " +
                "where status in('2','4','5') @@@@)", abiaoWhere = "";
        if (StrUtil.isNotEmpty(bah)) {
            fromAndWhereSql += " and bah like '%" + bah + "%'   ";
            abiaoWhere += " and ch0a01 like '%" + bah + "%'   ";
        }
        if (StrUtil.isNotEmpty(kscode)) {
            fromAndWhereSql += " and cyksdm like '%" + kscode + "%'";
            abiaoWhere += " and CH0A23 like '%" + kscode + "%'";
        }
        if (StrUtil.isNotEmpty(strTime)) {
            fromAndWhereSql += " and cyrq BETWEEN '" + strTime + "' AND '" + endTime + "'";
            abiaoWhere += " and ch0a27 BETWEEN '" + strTime + "' AND '" + endTime + "'";
        }
        return getRetrun(order, columnsSql.replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString()), fromAndWhereSql.replace("@@@@", abiaoWhere).replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString()));
    }

    /**
     * 获取未归档数据的语句
     */
    public Map<String, String> getUnFileBas(String order, String bah, String kscode, String strTime, String endTime) {
        String columnsSql = "'' AS id,CH0M00 AS blh,CH0M01 AS bah,CH0MZYCS AS zycs,CH0M02 AS name," +
                "CASE WHEN CH0M03 = 0 THEN '未知的性别' WHEN CH0M03 = 1 THEN '男' WHEN CH0M03 = 2 THEN '女'  WHEN CH0M03 = 9 THEN '未说明的性别' END AS xb," +
                "CH0M27 AS cyrq,ISNULL( CH0M23, '' ) AS cyksdm,ISNULL( c.name, '' ) AS cyks,CH0M34 AS zyys,ISNULL( CH0M34DM, '' ) AS zyysdm,'0' AS status,CHYear AS YEAR," +
                "( SELECT TOP 1 s.name FROM hp_zdbz s,dcLinkvsch_ch0c vc WHERE (s.code =upper(isnull(vc.ch0c03,'')) or s.use_dm=upper(isnull(vc.ch0c03,'')) or s.name=isnull(vc.ch0c03_desc,'') or s.use_mc=isnull(vc.ch0c03_desc,'')) and vc.ch0c01=ch0m01 order by ch0c02 asc) zzd," +
                "( SELECT TOP 1 s.name FROM hp_ssbz s,dcLinkvsch_CH0E ve WHERE (s.code = isnull( ve.CH0E05, '' ) OR isnull( ve.CH0E05, '' ) = s.use_dm OR s.name= ve.ch0e05_desc OR s.use_mc= ve.CH0E05_Desc) and ve.ch0e01=ch0m01 order by ch0e07 asc) zss ";
        String fromAndWhereSql = " from dcLinkvsch_PatientInfo b LEFT JOIN sys_ks c ON b.CH0M23= c.code " +
                " where ch0m01 not in(select bah from hp_mid_table where 1=1 @@ ) " +
                "and ch0m01 not in(select ch0a01 from vsch0a where status!=6 @@@@)";
        String midWhere = "", jiekouWhere = "", abiaoWhere = "";
        if (StrUtil.isNotEmpty(bah)) {
            midWhere += " and bah like '%" + bah + "%' ";
            jiekouWhere += " and CH0M01 like '%" + bah + "%'   ";
            abiaoWhere += " and CH0a01 like '%" + bah + "%'   ";
        }
        if (StrUtil.isNotEmpty(kscode)) {
            midWhere += " and cyksdm like '" + kscode + "' ";
            jiekouWhere += " and CH0M23 like '" + kscode + "'";
            abiaoWhere += " and CH0a23 like '" + kscode + "'";
        }
        if (StrUtil.isNotEmpty(strTime)) {
            midWhere += " and cyrq BETWEEN '" + strTime + "' AND '" + endTime + "'";
            jiekouWhere += " and CH0M27 BETWEEN '" + strTime + "' AND '" + endTime + "'";
            abiaoWhere += " and CH0a27 BETWEEN '" + strTime + "' AND '" + endTime + "'";
        }
        fromAndWhereSql = fromAndWhereSql.replace("@@@@", abiaoWhere).replace("@@", midWhere).replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString()) + jiekouWhere;
        return getRetrun(order, columnsSql.replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString()), fromAndWhereSql);
    }

    /**
     * 检查是否数据重复提交
     *
     * @param bah   病案号
     * @param year  年度
     * @param table 表名
     * @return
     */
    public ResultUtil<Object> getTakUpResult(String bah, String year, String table) {
        if (StrUtil.isEmpty(bah) || StrUtil.isEmpty(year)) {
            return ResultUtil.error("数据不完整,请核实后再保存!");
        }
        String msg = HpApplicationRunnerImpl.getCache(bah + year, table);
        if (StrUtil.isNotEmpty(msg)) {
            return ResultUtil.success(msg);
        }
        return null;
    }

    public Map<String, String> findCount(String strTime, String endTime) {
        String sql = "SELECT  * \n" +
                "FROM  (  SELECT isnull(SUM   ( CASE WHEN ISNULL( a.status, '' ) = 0 THEN 1 ELSE 0 END ),0) AS s0,   isnull(SUM ( CASE WHEN ISNULL( a.status, '' ) = 1 THEN 1 ELSE 0 END ),0) AS s1   FROM   dcLinkvsch_PatientInfo b   LEFT JOIN hp_mid_table a ON a.blh= b.CH0M00    AND a.name= b.CH0M02    AND a.zycs= b.CH0MZYCS    AND a.cyrq= b.CH0M27   LEFT JOIN sys_ks c ON b.CH0M23= c.code   WHERE  CH0M27 BETWEEN '" + strTime + "'   AND '" + endTime + "' " +
                " ) AS a1,  (  SELECT isnull(SUM   ( CASE WHEN ISNULL( b.status, '' ) = 2 THEN 1 ELSE 0 END ),0) AS s2,   isnull(SUM ( CASE WHEN ISNULL( b.status, '' ) = 3 THEN 1 ELSE 0 END ),0) AS s3,   isnull(SUM ( CASE WHEN ISNULL( b.status, '' ) = 4 THEN 1 ELSE 0 END ),0) AS s4,   isnull(SUM ( CASE WHEN ISNULL( b.status, '' ) = 5 THEN 1 ELSE 0 END ),0) AS s5   FROM   VsCH0A b   LEFT JOIN hp_mid_table a ON a.blh= b.CH0A00    AND a.name= b.CH0A02    AND a.zycs= b.CH0AZYCS    AND a.cyrq= b.CH0A27   LEFT JOIN sys_ks c ON b.CH0A23= c.code   WHERE  CH0A27 BETWEEN '" + strTime + "'   AND '" + endTime + "' " +
                " ) AS a2";
        List<Map<String, Object>> maps = hpMidTableDao.selectSqlWithSQL(sql.replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString()));
        Map<String, String> map = new HashMap<>();
        String s0, s1, s2, s3, s4, s5;
        if (null == maps || maps.size() <= 0) {
            s0 = s1 = s2 = s3 = s4 = s5 = "0";
        } else {
            Map<String, Object> result = maps.get(0);
            if (null == result || result.size() <= 0) {
                s0 = s1 = s2 = s3 = s4 = s5 = "0";
            } else {
                s0 = result.get("s0").toString();
                s1 = result.get("s1").toString();
                s2 = result.get("s2").toString();
                s3 = result.get("s3").toString();
                s4 = result.get("s4").toString();
                s5 = result.get("s5").toString();
            }
        }
        map.put("wgd", s0);
        map.put("ygd", s1);
        map.put("ylr", s2);
        map.put("dsh", s3);
        map.put("ysh", s4);
        map.put("yfq", s5);
        return map;
    }

    /**
     * 查询超期归档人数列表(分页)
     *
     * @param ksid    科室id
     * @param start   开始时间
     * @param end     结束时间
     * @param p       分页信息
     * @param fileday 归档天数
     * @return 结果
     */
    public PageInfo findlist(String ksid, String start, String end, PageInfo p, String fileday) {
        String sql = "from hp_mid_table where 1=1\n";
        sql = addParams(sql, ksid, start, end, fileday, "", "");
        fileday = StrUtil.emptyToDefault(fileday, "1");
        p = selectPageinfoWithSQL(" * ,(fileday-" + fileday + ") as 超期天数 ", sql, "cyrq", p, true);
        return p;
    }

    /**
     * 组装参数重用的部分
     *
     * @param sql     原装sql
     * @param ksid    科室
     * @param start   开始时间
     * @param end     结束时间
     * @param fileday 归档天数,可以为空
     * @param sjparam 时间参数字段,默认是cyrq,可以传入不同的参数
     * @param sjparam 科室参数字段,默认是cyksdm,可以传入不同的参数
     * @return
     */
    public String addParams(String sql, String ksid, String start, String end, String fileday, String sjparam, String ksparam) {
        if (StringUtil.isNotEmpty(ksid)) {
            if (StrUtil.isEmpty(ksparam)) {
                ksparam = "cyksdm";
            }
            sql += " and " + ksparam + "='" + ksid + "'\n";
        }
        if (StringUtil.isNotEmpty(start) & StringUtil.isNotEmpty(end)) {
            if (StrUtil.isEmpty(sjparam)) {
                sjparam = "cyrq";
            }
            sql += "and " + sjparam + " between '" + start + "' and '" + end + " 23:59:59' \n";
        }
        if (StringUtil.isNotEmpty(fileday)) {
            sql += "and fileday >=" + fileday;
        }
        return sql;
    }

    /**
     * 查询超期归档人数明细报表
     *
     * @param ksid    科室id
     * @param start   开始时间
     * @param end     结束时间
     * @param fileday 归档天数
     * @return
     */
    public Map<String, Object> findBeyondDeadline(String ksid, String start, String end, String fileday) {
        fileday = StrUtil.emptyToDefault(fileday, "1");
        String sql = "select bah as 病案号,name as 姓名,cyks as 出院科室,zyys as 住院医师,cyrq as 出院日期,filetime as 归档日期,fileday as 归档天数,(fileday-" + fileday + ") as 超期天数\n";
        String fromsql = "from hp_mid_table where 1=1 ";
        fromsql = addParams(fromsql, ksid, start, end, fileday, "", "");
        sql += fromsql;
        long cnt = selectCountWithSQL(fromsql);
        List<Map<String, Object>> maps = selectSqlWithSQL(sql);
        Map<String, Object> result = new HashMap<>();
        result.put("cnt", cnt);
        result.put("list", maps);
        return result;
    }

    /**
     * 查询超期归档率分科报表
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public Map<String, Object> findBeyondDeadlineByKs(String ksid, String start, String end) {
        String sqla = "select c.name as [科室],a.ks,a.cntall as [抽取病案],b.cntmid [归档病案],\n" +
                "cast( b.cntmid*100.0/case when a.cntall=0 then 1.0 else a.cntall end as NUMERIC(18,2)) as [归档率],\n" +
                "cast( b.gdl2r*100.0/case when a.cntall=0 then 1.0 else a.cntall end as NUMERIC(18,2)) as [2日归档率],\n" +
                "cast( b.gdl3r*100.0/case when a.cntall=0 then 1.0 else a.cntall end as NUMERIC(18,2)) as [3日归档率],\n" +
                "cast( b.gdl7r*100.0/case when a.cntall=0 then 1.0 else a.cntall end as NUMERIC(18,2)) as [7日归档率],\n" +
                "cast( b.gdl15r*100.0/case when a.cntall=0 then 1.0 else  a.cntall end as NUMERIC(18,2)) as [15日归档率] from \n" +
                "(select ch0m23 as ks,count(*) cntall,'' as cntmid ,'' as gdl2r,'' as gdl3r,'' as gdl7r,'' as gdl15r " +
                "from dcLinkvsch_patientinfo where 1=1 ";
        sqla = addParams(sqla, ksid, start, end, "", "CH0M27", "CH0M23");
        sqla += "GROUP BY CH0M23 ) a,\n" +
                "(select cyksdm as ks,'' as cntall,count(*) cntmid,sum(case when fileday<=2 then 1 else 0 end) as gdl2r,\n" +
                "sum(case when fileday<=3 then 1 else 0 end) as gdl3r,\n" +
                "sum(case when fileday<=7 then 1 else 0 end) as gdl7r,\n" +
                "sum(case when fileday<=15 then 1 else 0 end) as gdl15r\n" +
                "from hp_mid_table where 1=1 \n";
        sqla = addParams(sqla, ksid, start, end, "", "", "");
        sqla += "GROUP BY cyksdm ) b,\n" +
                "(select code ,name from sys_ks) c\n" +
                "where a.ks=b.ks and c.code=a.ks ORDER BY c.name ";
        List<Map<String, Object>> maps = selectSqlWithSQL(sqla.replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString()));
        Map<String, Object> result = new HashMap<>();
        result.put("list", maps);
        //查询总计数据
        sqla = "select '' as ks,'' as [科室] ,a.cntall as [抽取病案],b.cntmid [归档病案],\n" +
                "cast( b.cntmid*100.0/case when a.cntall=0 then 1.0 else a.cntall end as NUMERIC(18,2)) as [归档率],cast( b.gdl2r*100.0/case when a.cntall=0 then 1.0 else a.cntall end as NUMERIC(18,2)) as [2日归档率],cast( b.gdl3r*100.0/case when a.cntall=0 then 1.0 else a.cntall end as NUMERIC(18,2)) as [3日归档率],cast( b.gdl7r*100.0/case when a.cntall=0 then 1.0 else a.cntall end as NUMERIC(18,2)) as [7日归档率],cast( b.gdl15r*100.0/case when a.cntall=0 then 1.0 else  a.cntall end as NUMERIC(18,2)) as [15日归档率]\n" +
                "from \n" +
                "(select count(*) cntall,'' as cntmid ,'' as gdl2r,'' as gdl3r,'' as gdl7r,'' as gdl15r from dcLinkvsch_patientinfo where 1=1 ";
        sqla = addParams(sqla, ksid, start, end, "", "CH0M27", "CH0M23");
        sqla += ") a,\n" +
                "(select '' as cntall,count(*) cntmid,sum(case when fileday<=2 then 1 else 0 end) as gdl2r,\n" +
                "sum(case when fileday<=3 then 1 else 0 end) as gdl3r,\n" +
                "sum(case when fileday<=7 then 1 else 0 end) as gdl7r,\n" +
                "sum(case when fileday<=15 then 1 else 0 end) as gdl15r\n" +
                "from hp_mid_table where 1=1 ";
        sqla = addParams(sqla, ksid, start, end, "", "", "");
        sqla += ") b ";
        result.put("cnt", selectSqlWithSQL(sqla.replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString())));
        return result;
    }

    /**
     * 下载超期归档人数报表
     *
     * @param ksid     科室id
     * @param start    开始时间
     * @param end      结束时间
     * @param fileday  归档天数
     * @param response 页面响应
     * @return
     */
    public void down(String ksid, String start, String end, String fileday, HttpServletResponse response) throws Exception {
        Map<String, Object> result = findBeyondDeadline(ksid, start, end, fileday);
        List<Map<String, Object>> maps = (List<Map<String, Object>>) result.get("list");
        Map<String, String> colmap = new HashMap<>();
        //病案号,name as 姓名,cyks as 出院科室,zyys as 住院医师,cyrq as 出院日期,filetime as 归档日期,fileday as 归档天数,(fileday-" + fileday + ") as 超期天数
        colmap.put("病案号", "病案号");
        colmap.put("姓名", "姓名");
        colmap.put("出院科室", "出院科室");
        colmap.put("住院医师", "住院医师");
        colmap.put("出院日期", "出院日期");
        colmap.put("归档日期", "归档日期");
        colmap.put("归档天数", "归档天数");
        colmap.put("归档天数", "归档天数");
        colmap.put("超期天数", "超期天数");

        PoiUtil.createExcel("超期归档人数报表", response, maps, colmap);
    }

    /**
     * 下载归档率报表
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public void downKS(String ksid, String start, String end, HttpServletResponse response) throws Exception {
        Map<String, Object> map = findBeyondDeadlineByKs(ksid, start, end);
        List<Map<String, Object>> maps = (List<Map<String, Object>>) map.get("list");
        Map<String, String> colmap = new LinkedHashMap<>();
        colmap.put("ks", "科室代码");
        colmap.put("科室", "科室");
        colmap.put("抽取病案", "抽取病案");
        colmap.put("归档病案", "归档病案");
        colmap.put("归档率", "归档率");
        colmap.put("2日归档率", "2日归档率");
        colmap.put("3日归档率", "3日归档率");
        colmap.put("7日归档率", "7日归档率");
        colmap.put("15日归档率", "15日归档率");
        PoiUtil.createExcel("归档率报表", response, maps, colmap);
    }

    /**
     * 点击切换单双休后统一更新,归档日期
     *
     * @param date 某个日期
     * @
     */
    public void updateMidFIledayAfterChangeWeekend(String date) {
        String sql = "update m set m.fileday=fd from  hp_mid_table m,\n" +
                "(select (select count(*) cnt from VsHolidays where sfsjjr=0 and DATE  between cyrq and filetime) fd,* from hp_mid_table ";
        //如果传入时间不为空,按照传入日期在 出院日期和归档日期之间的归档数据,全部更新成设置好的归档天数
        if (StrUtil.isNotEmpty(date)) {
            sql += " where cyrq<='" + date + "' and filetime>='" + date + "'";
        }
        //如果传入时间为空,全部更新成设置好的归档天数
        sql += ") as aaa where aaa.id=m.id";
        selectSqlWithSQL(sql);
    }

    /**
     * 是否存在数据
     */
    public boolean ifExistData(HpMidTableEntity midTable) {
        String bah = midTable.getBah();
        Integer year = midTable.getYear();
        if (StrUtil.isEmpty(bah)) {//异常参数,当作库中没有数据
            return false;
        }
        String sql = "select case when count(*)=1 then 1 else 0 end cnt from hp_mid_table where bah='" + bah + "' ";
        if (null != year && 0 < year && year < 3000) {
            sql += " and year=" + year;
        }
        sql = selectSqlWithSQL(sql).get(0).get("cnt").toString();
        if (sql.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 插入归档数据
     *
     * @param midTable 归档数据
     * @
     */
    public String insertobj(HpMidTableEntity midTable) {
        Date date = new Date();
        midTable.setFiletime(new Date());
        //当前操作日期-出院日期
//                Long time = DateUtil.betweenDay(midTable.getCyrq(), date, true);
        //出院日期 到 当前日期这段时间内,工作日的天数,就是归档天数
        String sql = " from VsHolidays where sfsjjr=0 and DATE BETWEEN '" + DateUtil.formatDateTime(midTable.getCyrq()) + "' and '" + DateUtil.formatDateTime(date) + "' ";
        Long time = selectCountWithSQL(sql);
        midTable.setFileday(time.intValue());
        insert(midTable);
        return hpMidTableDao.findIDByBah(midTable.getBah());
    }

    /**
     * 查询工作量总计报表
     *
     * @param kscode 科室
     * @param start  开始时间
     * @param end    结束时间
     * @return
     */
    public List<Map<String, Object>> findGzlList(String kscode, String start, String end) {
        String sql = "select fileman,count(fileman) cnt from hp_mid_table\n" +
                "where ";
        if (StrUtil.isNotEmpty(start) && StrUtil.isNotEmpty(end)) {
            sql += " filetime between '" + start + "' and '";
            if (end.indexOf(":") == 0) {
                end += " 23:59:59' ";
            } else {
                end += "'";
            }
            sql += end;
            if (StrUtil.isNotEmpty(kscode)) {
                sql += " and CYKsdm='" + kscode + "'";
            }
            sql += " GROUP BY fileman with rollup";
        }
        List<Map<String, Object>> maps = selectSqlWithSQL(sql);
        if (CollUtil.isEmpty(maps)) {
            return null;
        }
        maps.forEach(e -> {
            if (null == e.get("fileman")) {
                e.put("fileman", "总计");
            }
        });
        return maps;
    }

    /**
     * 下载工作量报表
     *
     * @param kscode   科室code
     * @param start    开始时间
     * @param end      结束时间
     * @param response 系统响应
     * @
     */
    public void downGzllist(String kscode, String start, String end, HttpServletResponse response) throws Exception {
        List<Map<String, Object>> maps = findGzlList(kscode, start, end);
        Map<String, String> colmap = new LinkedHashMap<>();
        colmap.put("fileman", "操作员");
        colmap.put("cnt", "总数");
        PoiUtil.createExcel("工作量报表", response, maps, colmap);
    }

    /**
     * 查询工作量明细数据
     *
     * @param p        分页
     * @param fileName 归档人
     * @param kscode   病人科室code
     * @param start    开始时间
     * @param end      结束时间
     */
    public PageInfo findGzlmxList(PageInfo p, String fileName, String kscode, String start, String end) {
        String sql = getGzlmxSql(fileName, kscode, start, end);
        p = selectPageinfoWithSQL(HpMidTableEntity.class, "fileman,bah,zycs,name,xb,cyks,zyys,cyrq,filetime,fileday,year", sql, "filetime", p, true);
        return p;
    }

    /**
     * 拼接查询工作量明细sql
     *
     * @param fileName
     * @param kscode
     * @param start
     * @param end
     * @return
     */
    private String getGzlmxSql(String fileName, String kscode, String start, String end) {
        String sql = " from hp_mid_table where 1=1 ";
        if (StrUtil.isNotEmpty(start) & StrUtil.isNotEmpty(start)) {
            sql += " and  filetime between '" + start + "' and '";
            if (end.indexOf(":") == 0) {
                end += " 23:59:59'";
            } else {
                end += "'";
            }
            sql += end;
        }
        if (StrUtil.isNotEmpty(kscode)) {
            sql += " and cyksdm='" + kscode + "'";
        }
        if (null != fileName) {
            sql += " and fileman='" + fileName + "'";
        }
        return sql;
    }

    /**
     * 下载工作量明细报表
     *
     * @param fileName 操作人员名称
     * @param kscode   科室code
     * @param start    开始时间
     * @param end      结束时间
     * @param response 页面响应
     * @
     */
    public void downGzlmxList(String fileName, String kscode, String start, String end, HttpServletResponse response) throws Exception {
        String sql = getGzlmxSql(fileName, kscode, start, end);
        List<Map<String, Object>> maps = selectSqlWithSQL("select fileman,bah,zycs,name,xb,cyks,zyys,cyrq,filetime,fileday,year " + sql);
        Map<String, String> colmap = new LinkedHashMap<>();
        colmap.put("fileman", "操作员");
        colmap.put("bah", "病案号");
        colmap.put("zycs", "住院次数");
        colmap.put("name", "患者姓名");
        colmap.put("xb", "患者性别");
        colmap.put("cyks", "出院科室");
        colmap.put("zyys", "住院医师");
        colmap.put("cyrq", "出院日期");
        colmap.put("filetime", "归档时间");
        colmap.put("fileday", "归档天数");
        colmap.put("year", "年度");
        PoiUtil.createExcel("工作量明细报表", response, maps, colmap);
    }

    /**
     * 检测是否有环节质控前置的数据,如果有则变更状态为已录入
     */
    public boolean hasLinking(String bah) {
        String sql = "select id from vsch0a where status='6' and ch0a01='" + bah + "'";
        List<Map<String, Object>> maps = selectSqlWithSQL(sql);
        if (CollUtil.isNotEmpty(maps)) {
            hpVsch0AService.changeStatus(maps.get(0).get("id").toString(), "2");
            return true;
        } else {
            return false;
        }
    }
}