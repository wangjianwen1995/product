package com.sxdl.performance.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.hp.dbo.IndexHBI;
import com.sxdl.hp.dbo.IndexHbiAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PpIndexServiceImpl {
    @Autowired
    YmlUtil ymlUtil;
    String path = "/reportjsonp/getreport?id=@@@@&dcxx=&dccxtj=&pageid=&ispage=false&biqtuser=&topdata=&timew=&biyccs=&bivar=&weiplan=&softkey=";
    String url, result, hbitoken, dbName;
    static String AT = "%40", SHUGANG = "%7C", FENHAO = "%3B";
    JSONArray jdata;
    /**
     * 获取工作量数据
     *
     * @param start 开始
     * @param end   结束
     * @param istb  是否同比,1同比,0环比
     */
    public Map<String, Object> getGZL(String start, String end, String istb) {
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
        if(StrUtil.isEmpty(url)){
            return titleMap;
        }
        String result = HttpUtil.get(url);
        titleMap = parseJson(result, titleMap);
        return buildDate(titleMap);
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
    public String getLastMonthHbiUrl(String start, String end, String htoken, String hurl) {
        StringBuilder stringBuilder = new StringBuilder(hurl);
        String idnex=ymlUtil.getYmlValue("HBI.index");
        if(StrUtil.isEmpty(idnex)){
            return "";
        }
        path=path.replace("@@@@",idnex);
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
    public String getLastYearHbiUrl(String start, String end, String htoken, String hurl) {
        StringBuilder stringBuilder = new StringBuilder(hurl);
        String idnex=ymlUtil.getYmlValue("HBI.index");
        if(StrUtil.isEmpty(idnex)){
            return "";
        }
        path=path.replace("@@@@",idnex);
        stringBuilder.append(path).append(htoken).append("&cxtj=%40novalue").append(SHUGANG)
                .append(DateUtil.getLastYearDate(start))//基期开始时间
                .append(FENHAO).append(DateUtil.getLastYearDate(end)).append(FENHAO)//基期结束时间
                .append(start).append(FENHAO).append(end).append(SHUGANG);//当前期起止时间
        return stringBuilder.toString();
    }
    IndexHBI heji;
    /**
     * 解析json数据
     *
     * @param s 返回的json格式字符串
     * @return 包含数据和标题列表, 方便前端展示
     */
    public Map<String, Object> parseJson(String s, Map<String, Object> resultMap) {
        if (s.contains("Error")) return resultMap;
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
                if(jdata.getString(0).contains("合计")){
                    heji= parseIndexHBI(jdata);
                }else {
                    ihs.add(parseIndexHBI(jdata));
                }
            }
        }
        resultMap.put("list", ihs);
        resultMap.put("heji",heji);
        return resultMap;
    }
    IndexHBI ih;
    List<IndexHBI> ihs;
    Map infomap;
    IndexHbiAll ihall, child;
    /**
     * 解析单行数据转化成entity便于计算
     *
     * @param js 单行数据
     * @return IndexHBI数据
     */
    public IndexHBI parseIndexHBI(JSONArray js) {
        ih = new IndexHBI();
        infomap = new HashMap();
        ih.setKs(js.getString(0));
        ih.setH0_jq(js.getInteger(1));
        ih.setH0_bgq(js.getInteger(2));
        ih.setH0_zzl(js.getDouble(3));
        ih.setH0_zzlv(js.getDouble(4));
        ih.setH1_jq(js.getInteger(5));
        ih.setH1_bgq(js.getInteger(6));
        ih.setH1_zzl(js.getDouble(7));
        ih.setH1_zzlv(js.getDouble(8));
        ih.setH2_jq(js.getInteger(9));
        ih.setH2_bgq(js.getInteger(10));
        ih.setH2_zzl(js.getDouble(11));
        ih.setH2_zzlv(js.getDouble(12));
        ih.setH3_jq(js.getInteger(13));
        ih.setH3_bgq(js.getInteger(14));
        ih.setH3_zzl(js.getDouble(15));
        ih.setH3_zzlv(js.getDouble(16));
        ih.setH4_jq(js.getInteger(17));
        ih.setH4_bgq(js.getInteger(18));
        ih.setH4_zzl(js.getDouble(19));
        ih.setH4_zzlv(js.getDouble(20));
        ih.setH5_jq(js.getInteger(21));
        ih.setH5_bgq(js.getInteger(22));
        ih.setH5_zzl(js.getDouble(23));
        ih.setH5_zzlv(js.getDouble(24));
        ih.setH6_jq(js.getInteger(25));
        ih.setH6_bgq(js.getInteger(26));
        ih.setH6_zzl(js.getDouble(27));
        ih.setH6_zzlv(js.getDouble(28));
        ih.setH7_jq(js.getInteger(29));
        ih.setH7_bgq(js.getInteger(30));
        ih.setH7_zzl(js.getDouble(31));
        ih.setH7_zzlv(js.getDouble(32));
        ih.setH8_jq(js.getInteger(33));
        ih.setH8_bgq(js.getInteger(34));
        ih.setH8_zzl(js.getDouble(35));
        ih.setH8_zzlv(js.getDouble(36));
        ih.setH9_jq(js.getInteger(37));
        ih.setH9_bgq(js.getInteger(38));
        ih.setH9_zzl(js.getDouble(39));
        ih.setH9_zzlv(js.getDouble(40));
        infomap = new HashMap();
        infomap.put("h0_jq", js.getInteger(1));
        infomap.put("h0_bgq", js.getInteger(2));
        infomap.put("h0_zzl", js.getDouble(3));
        infomap.put("h0_zzlv", js.getDouble(4));
        infomap.put("h1_jq", js.getInteger(5));
        infomap.put("h1_bgq", js.getInteger(6));
        infomap.put("h1_zzl", js.getDouble(7));
        infomap.put("h1_zzlv", js.getDouble(8));
        infomap.put("h2_jq", js.getInteger(9));
        infomap.put("h2_bgq", js.getInteger(10));
        infomap.put("h2_zzl", js.getDouble(11));
        infomap.put("h2_zzlv", js.getDouble(12));
        infomap.put("h3_jq", js.getInteger(13));
        infomap.put("h3_bgq", js.getInteger(14));
        infomap.put("h3_zzl", js.getDouble(15));
        infomap.put("h3_zzlv", js.getDouble(16));
        infomap.put("h4_jq", js.getInteger(17));
        infomap.put("h4_bgq", js.getInteger(18));
        infomap.put("h4_zzl", js.getDouble(19));
        infomap.put("h4_zzlv", js.getDouble(20));
        infomap.put("h5_jq", js.getInteger(21));
        infomap.put("h5_bgq", js.getInteger(22));
        infomap.put("h5_zzl", js.getDouble(23));
        infomap.put("h5_zzlv", js.getDouble(24));
        infomap.put("h6_jq", js.getInteger(25));
        infomap.put("h6_bgq", js.getInteger(26));
        infomap.put("h6_zzl", js.getDouble(27));
        infomap.put("h6_zzlv", js.getDouble(28));
        infomap.put("h7_jq", js.getInteger(29));
        infomap.put("h7_bgq", js.getInteger(30));
        infomap.put("h7_zzl", js.getDouble(31));
        infomap.put("h7_zzlv", js.getDouble(32));
        infomap.put("h8_jq", js.getInteger(33));
        infomap.put("h8_bgq", js.getInteger(34));
        infomap.put("h8_zzl", js.getDouble(35));
        infomap.put("h8_zzlv", js.getDouble(36));
        infomap.put("h9_jq", js.getInteger(37));
        infomap.put("h9_bgq", js.getInteger(38));
        infomap.put("h9_zzl", js.getDouble(39));
        infomap.put("h9_zzlv", js.getDouble(40));
        ih.setMap(infomap);
        return ih;
    }
    List<IndexHbiAll> childs;

    /**
     * 构建每个模块中的相关的列表信息
     *
     * @param ihs   整个报表列表
     * @param start 规范的开头名称
     * @return 单个模块的中列表
     */
    public List<IndexHbiAll> buildChild(List<IndexHBI> ihs, String start) {
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
    public Map<String, Object> buildDate(Map<String, Object> resultMap) {
        ihs = (List<IndexHBI>) resultMap.get("list");
        heji=(IndexHBI) resultMap.get("heji");
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
