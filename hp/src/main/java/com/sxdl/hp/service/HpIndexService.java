package com.sxdl.hp.service;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.hp.dbo.IndexHBI;
import com.sxdl.hp.dbo.IndexHbiAll;
import com.sxdl.hp.entity.HpTable;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpIndexService extends BaseServiceImpl<HpTable> {

    static String AT = "%40", SHUGANG = "%7C", FENHAO = "%3B";
    @Autowired
    YmlUtil ymlUtil;

    String path = "/reportjsonp/getreport?id=@@@@&dcxx=&dccxtj=&pageid=&ispage=false&biqtuser=&topdata=&timew=&biyccs=&bivar=&weiplan=&softkey=";
    String url, hbitoken;
    IndexHBI ih;
    List<IndexHBI> ihs;
    JSONArray jdata;
    Map infomap;
    IndexHbiAll ihall, child;
    List<IndexHbiAll> childs;
    IndexHBI heji;

    public Map<String, Object> getZXT(String start, String end)  {
        String sql = "select isnull(ks, '未匹配' ) as ks,sum(cnt) as 总数量,sum(cnt2) as 负担数量,sum(cnt3) as 归档数量,sum(cnt4) as 病案质量 from \n" +
                "( select CYKBMC as ks,count(*) as cnt,0 as cnt2,0 as cnt3,0 as cnt4 from homepage  where STATUS =4  and cysj between '" + start + "' AND '" + end + "' GROUP BY CYKBMC\n" +
                "   UNION\n" +
                "select CH0A23_mc as ks,0 as cnt,count(Ch0ABE) as cnt2,0 as cnt3,0 as cnt4 from VsCH0A where STATUS = 4 and ch0a27 between '" + start + "' AND '" + end + "' GROUP BY CH0A23_mc,Ch0ABE\n" +
                " UNION\n" +
                " select  CH0A23_mc as ks,0 as cnt,0 as cnt2,count(*) as cnt3,0 as cnt4 from hp_mid_table m LEFT JOIN vsch0a a on a.ch0a01=m.bah and a.chyear=m.year where a.STATUS = 4 and m.fileday<=2 and cyrq between '" + start + "' AND '" + end + "'  GROUP BY CH0A23_mc\n" +
                " UNION\n" +
                " select CYKBMC as ks,0 as cnt,0 as cnt2,0 as cnt3,count(BAZL) as cnt4 from homepage h  where BAZL='1' and cysj between '" + start + "' AND '" + end + "' and STATUS =4 GROUP BY CYKBMC,BAZL) as aaa \n" +
                " GROUP BY ks";
        List<Map<String, Object>> maps = selectSqlWithSQL(sql);
        List<String> fdsl, gdsl, bazl, ks, zsl;
        Map map;
        if (maps.size() == 0) {
            map = new HashMap<>();
            return map;
        }
        ks = maps.stream().map(e -> e.get("ks").toString()).collect(Collectors.toList());
        zsl = maps.stream().map(e -> e.get("总数量").toString()).collect(Collectors.toList());
        fdsl = maps.stream().map(e -> e.get("负担数量").toString()).collect(Collectors.toList());
        gdsl = maps.stream().map(e -> e.get("归档数量").toString()).collect(Collectors.toList());
        bazl = maps.stream().map(e -> e.get("病案质量").toString()).collect(Collectors.toList());

        map = new HashMap<>();
        map.put("同期病历总数量", zsl);
        map.put("病案人员负担数量", fdsl);
        map.put("2日内归档数量", gdsl);
        map.put("甲级病案数量", bazl);
        map.put("主诊断正确数量", zsl);
        map.put("ks", ks);
        return map;
    }

    /**
     * 查询各个状态下的待完成工作量
     *
     * @param strTime
     * @param endTime
     * @return
     */
    public Map<String, String> findCount2(String strTime, String endTime, String flag, String kscode)  {
        StringBuilder sb = new StringBuilder();
        sb.append("with dc as (select a.status,b.CH0M83 ,b.CH0M29, b.ch0M24,b.ch0M27 FROM dbo.dcLinkvsch_PatientInfo b LEFT JOIN hp_mid_table a ON a.blh= b.CH0M00 AND a.name= b.CH0M02 AND a.zycs= b.CH0MZYCS AND a.cyrq= b.CH0M27\n" +
                " LEFT JOIN dbo.sys_ks c ON b.CH0M23= c.code WHERE CH0M27 BETWEEN '" + strTime + "' AND '" + endTime + "'");
        if (StringUtil.isEmpty(kscode)) {
            sb.append(" )");
        } else {
            sb.append(" and b.CH0M23='" + kscode + "')");
        }
        sb.append(" SELECT *  FROM\n" +
                " (SELECT isnull(SUM ( CASE WHEN ISNULL( status, '' ) = 0 THEN 1 ELSE 0 END ),0) AS s0,\n" +
                " isnull(SUM ( CASE WHEN ISNULL( status, '' ) = 1 THEN 1 ELSE 0 END ),0) AS s1");
        if (StringUtil.isNotEmpty(flag)) {
            sb.append(" ,isnull( SUM ( CASE WHEN ISNULL( CH0M83, 0 ) < 5 THEN 1 ELSE 0 END ), 0 ) AS s61, ");
            sb.append(" isnull(SUM ( CASE WHEN ISNULL( CH0M29, DATEDIFF( d, ch0M24, ch0M27 ) ) > 60 THEN 1 ELSE 0 END ),0 ) AS s62,");
            sb.append(" isnull(SUM ( CASE WHEN DATEDIFF( d, ch0M27, CONVERT ( DATE, '2018-11-08', 0 ) )  > 60 and status=0 THEN 1 ELSE 0 END ),0) AS s7 FROM dc  ) AS a1,");
            sb.append(" (SELECT   isnull( SUM ( CASE WHEN ISNULL( b.CH0B83, 0 ) < 5 THEN 1 ELSE 0 END ), 0 ) AS s63,   isnull(SUM ( CASE WHEN ISNULL( a.CH0A29, DATEDIFF( d, a.ch0a24, a.ch0a27 ) ) > 60 THEN 1 ELSE 0 END ),0) AS s64 \n" +
                    " FROM   VsCH0A a   LEFT JOIN VsCH0b b ON a.id= b.A_ID   LEFT JOIN  sys_ks c ON a.CH0A23= c.code \n" +
                    " WHERE   CH0A27 BETWEEN '" + strTime + "' AND '" + endTime + "'");

        } else {
            sb.append(" FROM dc ) AS a1,");
            sb.append(" ( SELECT isnull(SUM ( CASE WHEN ISNULL( b.status, '' ) = 2 THEN 1 ELSE 0 END ),0) AS s2,");
            sb.append(" isnull(SUM ( CASE WHEN ISNULL( b.status, '' ) = 3 THEN 1 ELSE 0 END ),0) AS s3,");
            sb.append(" isnull(SUM ( CASE WHEN ISNULL( b.status, '' ) = 4 THEN 1 ELSE 0 END ),0) AS s4,");
            sb.append(" isnull(SUM ( CASE WHEN ISNULL( b.status, '' ) = 5 THEN 1 ELSE 0 END ),0) AS s5,0 As s7");
            sb.append(" FROM VsCH0A b LEFT JOIN hp_mid_table a ON a.blh= b.CH0A00 AND a.name= b.CH0A02 AND a.zycs= b.CH0AZYCS AND a.cyrq= b.CH0A27 LEFT JOIN sys_ks c ON b.CH0A23= c.code where CH0A27 BETWEEN '" + strTime + "' AND '" + endTime + "'");
        }
        if (StringUtil.isEmpty(kscode)) {
            sb.append(" ) AS a3");
        } else {
            sb.append(" and b.CH0A23='" + kscode + "') AS a3");
        }
        List<Map<String, Object>> maps = selectSqlWithSQL(sb.toString().replaceAll("dcLink", HpApplicationRunnerImpl.contextMap.get("dcLink").toString()));
        Map<String, String> map = new HashMap<>();
        String s0, s1, s2, s3, s4, s5, s61, s62, s63, s64, s7;
        if (null == maps || maps.size() <= 0) {
            s0 = s1 = s2 = s3 = s4 = s5 = s7 = "0";
        } else {
            Map<String, Object> result = maps.get(0);
            if (null == result || result.size() <= 0) {
                s0 = s1 = s2 = s3 = s4 = s5 = s7 = "0";
            } else {
                if (StringUtil.isNotEmpty(flag)) {
                    s2 = result.get("s61").toString();
                    s3 = result.get("s62").toString();
                    s4 = result.get("s63").toString();
                    s5 = result.get("s64").toString();
                } else {
                    s2 = result.get("s2").toString();
                    s3 = result.get("s3").toString();
                    s4 = result.get("s4").toString();
                    s5 = result.get("s5").toString();
                }
                s0 = result.get("s0").toString();
                s1 = result.get("s1").toString();
                s7 = result.get("s7").toString();
            }
        }
        if (StringUtil.isEmpty(flag)) {
            map.put("yc", s2 + s3 + s4 + s5);
            map.put("cc", s7);
        } else {
            map.put("ylr", s2);
            map.put("dsh", s3);
            map.put("ysh", s4);
            map.put("yfq", s5);
        }
        map.put("wgd", s0);
        map.put("ygd", s1);

        return map;
    }

    /**
     * 获取环比报表路径
     *
     * @param start  开始
     * @param end    结束
     * @param htoken hbitoken
     * @param hurl   报表路径
     * @return 报表完整路径
     */
    public String getLastMonthHbiUrl(String start, String end, String htoken, String hurl)  {
        StringBuilder stringBuilder = new StringBuilder(hurl);
        String idnex = ymlUtil.getYmlValue("HBI.index");
        if (StrUtil.isEmpty(idnex)) {
            return "";
        }
        path = path.replace("@@@@", idnex);
        stringBuilder.append(path).append(htoken).append("&cxtj=%40novalue").append(SHUGANG)
                .append(DateUtil.getLastMonthDate(start))//基期开始时间
                .append(FENHAO).append(DateUtil.getLastMonthDate(end)).append(FENHAO)//基期结束时间
                .append(start).append(FENHAO).append(end).append(SHUGANG);//
        return stringBuilder.toString();
    }

    /**
     * 获取同比报表路径
     *
     * @param start  开始
     * @param end    结束
     * @param htoken hbitoken
     * @param hurl   报表路径
     * @return 报表完整路径
     */
    public String getLastYearHbiUrl(String start, String end, String htoken, String hurl)  {
        StringBuilder stringBuilder = new StringBuilder(hurl);
        String idnex = ymlUtil.getYmlValue("HBI.index");
        if (StrUtil.isEmpty(idnex)) {
            return "";
        }
        path = path.replace("@@@@", idnex);
        stringBuilder.append(path).append(htoken).append("&cxtj=%40novalue").append(SHUGANG)
                .append(DateUtil.getLastYearDate(start))//基期开始时间
                .append(FENHAO).append(DateUtil.getLastYearDate(end)).append(FENHAO)//基期结束时间
                .append(start).append(FENHAO).append(end).append(SHUGANG);//当前期起止时间
        return stringBuilder.toString();
    }

    /**
     * 获取工作量数据
     *
     * @param start 开始
     * @param end   结束
     * @param istb  是否同比,1同比,0环比
     */
    public Map<String, Object> getGZL(String start, String end, String istb)  {
        Map titleMap = new HashMap<>();
        if (StringUtil.isEmpty(istb)) {
            return titleMap;
        }
        hbitoken = (String) ApplicationRunnerImpl.contextMap.get("hbitoken");
        ymlUtil.getHbiURL();
        if ("0".equals(istb)) {
            url = getLastMonthHbiUrl(start, end, hbitoken, ymlUtil.getHbiURL());
        } else if ("1".equals(istb)) {
            url = getLastYearHbiUrl(start, end, hbitoken, ymlUtil.getHbiURL());
        } else {
            return titleMap;
        }
        if (StrUtil.isEmpty(url)) {
            return titleMap;
        }
        String result = HttpUtil.get(url);
        titleMap = parseJson(result, titleMap);
        return buildDate(titleMap);
    }

    /**
     * 解析json数据
     *
     * @param s 返回的json格式字符串
     * @return 包含数据和标题列表, 方便前端展示
     */
    public Map<String, Object> parseJson(String s, Map<String, Object> resultMap)  {
        if (StrUtil.isEmpty(s) || s.contains("Error")) return resultMap;
        JSONObject j = JSON.parseObject(s);
        List<IndexHBI> ihs = new ArrayList<>();
        JSONArray jatitle = j.getJSONObject("title").getJSONArray("column");
        String[] ss = jatitle.getString(0).split(",");
        resultMap.put("h0", ss[1]);
        resultMap.put("h1", ss[5]);
        resultMap.put("h2", ss[9]);
        resultMap.put("h3", ss[13]);
        resultMap.put("h4", ss[17]);
        resultMap.put("h5", ss[21]);
        resultMap.put("h6", ss[25]);
        resultMap.put("h7", ss[29]);
        resultMap.put("h8", ss[33]);
        resultMap.put("h9", ss[37]);
        JSONArray ja = j.getJSONObject("rows").getJSONArray("row");
        for (Object e : ja) {
            j = (JSONObject) e;
            jdata = j.getJSONArray("cell");
            if (jdata.size() > 0) {
                if (jdata.getString(0).contains("合计")) {
                    heji = parseIndexHBI(jdata);
                } else {
                    ihs.add(parseIndexHBI(jdata));
                }
            }
        }
        resultMap.put("list", ihs);
        resultMap.put("heji", heji);
        return resultMap;
    }

    /**
     * 解析单行数据转化成entity便于计算
     *
     * @param js 单行数据
     * @return IndexHBI数据
     */
    public IndexHBI parseIndexHBI(JSONArray js)  {
        ih = new IndexHBI();
        infomap = new HashMap();
        ih.setKs(js.getString(0));
        ih.setH0_jq(NumberUtil.parseInt(js.getString(1)));
        ih.setH0_bgq(NumberUtil.parseInt(js.getString(2)));
        ih.setH0_zzl(Double.parseDouble(StrUtil.blankToDefault(js.getString(3),"0")));
        ih.setH0_zzlv(Double.parseDouble(StrUtil.blankToDefault(js.getString(4),"0")));
        ih.setH1_jq(NumberUtil.parseInt(js.getString(5)));
        ih.setH1_bgq(NumberUtil.parseInt(js.getString(6)));
        ih.setH1_zzl(Double.parseDouble(StrUtil.blankToDefault(js.getString(7),"0")));
        ih.setH1_zzlv(Double.parseDouble(StrUtil.blankToDefault(js.getString(8),"0")));
        ih.setH2_jq(NumberUtil.parseInt(js.getString(9)));
        ih.setH2_bgq(NumberUtil.parseInt(js.getString(10)));
        ih.setH2_zzl(Double.parseDouble(StrUtil.blankToDefault(js.getString(11),"0")));
        ih.setH2_zzlv(Double.parseDouble(StrUtil.blankToDefault(js.getString(12),"0")));
        ih.setH3_jq(NumberUtil.parseInt(js.getString(13)));
        ih.setH3_bgq(NumberUtil.parseInt(js.getString(14)));
        ih.setH3_zzl(Double.parseDouble(StrUtil.blankToDefault(js.getString(15),"0")));
        ih.setH3_zzlv(Double.parseDouble(StrUtil.blankToDefault(js.getString(16),"0")));
        ih.setH4_jq(NumberUtil.parseInt(js.getString(17)));
        ih.setH4_bgq(NumberUtil.parseInt(js.getString(18)));
        ih.setH4_zzl(Double.parseDouble(StrUtil.blankToDefault(js.getString(19),"0")));
        ih.setH4_zzlv(Double.parseDouble(StrUtil.blankToDefault(js.getString(20),"0")));
        ih.setH5_jq(NumberUtil.parseInt(js.getString(21)));
        ih.setH5_bgq(NumberUtil.parseInt(js.getString(22)));
        ih.setH5_zzl(Double.parseDouble(StrUtil.blankToDefault(js.getString(23),"0")));
        ih.setH5_zzlv(Double.parseDouble(StrUtil.blankToDefault(js.getString(24),"0")));
        ih.setH6_jq(NumberUtil.parseInt(js.getString(25)));
        ih.setH6_bgq(NumberUtil.parseInt(js.getString(26)));
        ih.setH6_zzl(Double.parseDouble(StrUtil.blankToDefault(js.getString(27),"0")));
        ih.setH6_zzlv(Double.parseDouble(StrUtil.blankToDefault(js.getString(28),"0")));
        ih.setH7_jq(NumberUtil.parseInt(js.getString(29)));
        ih.setH7_bgq(NumberUtil.parseInt(js.getString(30)));
        ih.setH7_zzl(Double.parseDouble(StrUtil.blankToDefault(js.getString(31),"0")));
        ih.setH7_zzlv(Double.parseDouble(StrUtil.blankToDefault(js.getString(32),"0")));
        ih.setH8_jq(NumberUtil.parseInt(js.getString(33)));
        ih.setH8_bgq(NumberUtil.parseInt(js.getString(34)));
        ih.setH8_zzl(Double.parseDouble(StrUtil.blankToDefault(js.getString(35),"0")));
        ih.setH8_zzlv(Double.parseDouble(StrUtil.blankToDefault(js.getString(36),"0")));
        ih.setH9_jq(NumberUtil.parseInt(js.getString(37)));
        ih.setH9_bgq(NumberUtil.parseInt(js.getString(38)));
        ih.setH9_zzl(Double.parseDouble(StrUtil.blankToDefault(js.getString(39),"0")));
        ih.setH9_zzlv(Double.parseDouble(StrUtil.blankToDefault(js.getString(40),"0")));
        infomap = new HashMap();
        infomap.put("h0_jq", NumberUtil.parseInt(js.getString(1)));
        infomap.put("h0_bgq", NumberUtil.parseInt(js.getString(2)));
        infomap.put("h0_zzl", Double.parseDouble(StrUtil.blankToDefault(js.getString(3),"0")));
        infomap.put("h0_zzlv", Double.parseDouble(StrUtil.blankToDefault(js.getString(4),"0")));
        infomap.put("h1_jq", NumberUtil.parseInt(js.getString(5)));
        infomap.put("h1_bgq", NumberUtil.parseInt(js.getString(6)));
        infomap.put("h1_zzl", Double.parseDouble(StrUtil.blankToDefault(js.getString(7),"0")));
        infomap.put("h1_zzlv", Double.parseDouble(StrUtil.blankToDefault(js.getString(8),"0")));
        infomap.put("h2_jq", NumberUtil.parseInt(js.getString(9)));
        infomap.put("h2_bgq", NumberUtil.parseInt(js.getString(10)));
        infomap.put("h2_zzl", Double.parseDouble(StrUtil.blankToDefault(js.getString(11),"0")));
        infomap.put("h2_zzlv", Double.parseDouble(StrUtil.blankToDefault(js.getString(12),"0")));
        infomap.put("h3_jq", NumberUtil.parseInt(js.getString(13)));
        infomap.put("h3_bgq", NumberUtil.parseInt(js.getString(14)));
        infomap.put("h3_zzl", Double.parseDouble(StrUtil.blankToDefault(js.getString(15),"0")));
        infomap.put("h3_zzlv", Double.parseDouble(StrUtil.blankToDefault(js.getString(16),"0")));
        infomap.put("h4_jq", NumberUtil.parseInt(js.getString(17)));
        infomap.put("h4_bgq", NumberUtil.parseInt(js.getString(18)));
        infomap.put("h4_zzl", Double.parseDouble(StrUtil.blankToDefault(js.getString(19),"0")));
        infomap.put("h4_zzlv", Double.parseDouble(StrUtil.blankToDefault(js.getString(20),"0")));
        infomap.put("h5_jq", NumberUtil.parseInt(js.getString(21)));
        infomap.put("h5_bgq", NumberUtil.parseInt(js.getString(22)));
        infomap.put("h5_zzl", Double.parseDouble(StrUtil.blankToDefault(js.getString(23),"0")));
        infomap.put("h5_zzlv", Double.parseDouble(StrUtil.blankToDefault(js.getString(24),"0")));
        infomap.put("h6_jq", NumberUtil.parseInt(js.getString(25)));
        infomap.put("h6_bgq", NumberUtil.parseInt(js.getString(26)));
        infomap.put("h6_zzl", Double.parseDouble(StrUtil.blankToDefault(js.getString(27),"0")));
        infomap.put("h6_zzlv", Double.parseDouble(StrUtil.blankToDefault(js.getString(28),"0")));
        infomap.put("h7_jq", NumberUtil.parseInt(js.getString(29)));
        infomap.put("h7_bgq", NumberUtil.parseInt(js.getString(30)));
        infomap.put("h7_zzl", Double.parseDouble(StrUtil.blankToDefault(js.getString(31),"0")));
        infomap.put("h7_zzlv", Double.parseDouble(StrUtil.blankToDefault(js.getString(32),"0")));
        infomap.put("h8_jq", NumberUtil.parseInt(js.getString(33)));
        infomap.put("h8_bgq", NumberUtil.parseInt(js.getString(34)));
        infomap.put("h8_zzl", Double.parseDouble(StrUtil.blankToDefault(js.getString(35),"0")));
        infomap.put("h8_zzlv", Double.parseDouble(StrUtil.blankToDefault(js.getString(36),"0")));
        infomap.put("h9_jq", NumberUtil.parseInt(js.getString(37)));
        infomap.put("h9_bgq", NumberUtil.parseInt(js.getString(38)));
        infomap.put("h9_zzl", Double.parseDouble(StrUtil.blankToDefault(js.getString(39),"0")));
        infomap.put("h9_zzlv", Double.parseDouble(StrUtil.blankToDefault(js.getString(40),"0")));
        ih.setMap(infomap);
        return ih;
    }


    /**
     * 构建每个模块中的相关的列表信息
     *
     * @param ihs   整个报表列表
     * @param start 规范的开头名称
     * @return 单个模块的中列表
     */
    public List<IndexHbiAll> buildChild(List<IndexHBI> ihs, String start)  {
        childs = new ArrayList<>();
        ihs.forEach(e -> {
            infomap = e.getMap();
            if (infomap.size() < 0) return;
            child = new IndexHbiAll(Integer.parseInt(infomap.get(start + "_bgq").toString()), Integer.parseInt(infomap.get(start + "_jq").toString()), Double.parseDouble(infomap.get(start + "_zzl").toString()), Double.parseDouble(infomap.get(start + "_zzlv").toString()), e.getKs());
            childs.add(child);
        });
        return childs;
    }

    /**
     * 构建返回数据十个模块的汇总数据
     *
     * @param resultMap 返回的数据
     * @return 十个模块的汇总数据
     */
    public Map<String, Object> buildDate(Map<String, Object> resultMap)  {
        ihs = (List<IndexHBI>) resultMap.get("list");
        heji = (IndexHBI) resultMap.get("heji");
        if(null==heji){
            return resultMap;
        }
        ihall = new IndexHbiAll(heji.getH0_bgq(), heji.getH0_jq(), heji.getH0_zzl(), heji.getH0_zzlv(), resultMap.get("h0").toString(), buildChild(ihs, "h0"));
        resultMap.put("h0", ihall);

        ihall = new IndexHbiAll(heji.getH1_bgq(), heji.getH1_jq(), heji.getH1_zzl(), heji.getH1_zzlv(), resultMap.get("h1").toString(), buildChild(ihs, "h0"));
        resultMap.put("h1", ihall);
        ihall = new IndexHbiAll(heji.getH2_bgq(), heji.getH2_jq(), heji.getH2_zzl(), heji.getH2_zzlv(), resultMap.get("h2").toString(), buildChild(ihs, "h0"));
        resultMap.put("h2", ihall);
        ihall = new IndexHbiAll(heji.getH3_bgq(), heji.getH3_jq(), heji.getH3_zzl(), heji.getH3_zzlv(), resultMap.get("h3").toString(), buildChild(ihs, "h0"));
        resultMap.put("h3", ihall);
        ihall = new IndexHbiAll(heji.getH4_bgq(), heji.getH4_jq(), heji.getH4_zzl(), heji.getH4_zzlv(), resultMap.get("h4").toString(), buildChild(ihs, "h0"));
        resultMap.put("h4", ihall);
        ihall = new IndexHbiAll(heji.getH5_bgq(), heji.getH5_jq(), heji.getH5_zzl(), heji.getH5_zzlv(), resultMap.get("h5").toString(), buildChild(ihs, "h0"));
        resultMap.put("h5", ihall);
        ihall = new IndexHbiAll(heji.getH6_bgq(), heji.getH6_jq(), heji.getH6_zzl(), heji.getH6_zzlv(), resultMap.get("h6").toString(), buildChild(ihs, "h0"));
        resultMap.put("h6", ihall);
        ihall = new IndexHbiAll(heji.getH7_bgq(), heji.getH7_jq(), heji.getH7_zzl(), heji.getH7_zzlv(), resultMap.get("h7").toString(), buildChild(ihs, "h0"));
        resultMap.put("h7", ihall);
        ihall = new IndexHbiAll(heji.getH8_bgq(), heji.getH8_jq(), heji.getH8_zzl(), heji.getH8_zzlv(), resultMap.get("h8").toString(), buildChild(ihs, "h0"));
        resultMap.put("h8", ihall);
        ihall = new IndexHbiAll(heji.getH9_bgq(), heji.getH9_jq(), heji.getH9_zzl(), heji.getH9_zzlv(), resultMap.get("h9").toString(), buildChild(ihs, "h0"));
        resultMap.put("h9", ihall);

        resultMap.remove("list");
        resultMap.remove("heji");
        return resultMap;
    }
}
