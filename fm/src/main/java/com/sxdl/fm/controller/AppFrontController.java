package com.sxdl.fm.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.EscapeUtil;
import cn.hutool.http.HttpRequest;
import com.sxdl.base.controller.ReportController;
import com.sxdl.base.controller.SysUserController;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.util.*;
import com.sxdl.fm.service.FmSecondHandlerService;
import com.sxdl.fm.service.HbiTlfgzlzbService;
import com.sxdl.fm.util.FMApplicationRunnerImpl;
import com.sxdl.fm.util.app.FMone;
import com.sxdl.fm.util.app.FmAllTwenty;
import com.sxdl.fm.util.app.FmSingle;
import com.sxdl.fm.util.app.FmSingleToFront;
import org.apache.commons.io.input.BOMInputStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("app")
public class AppFrontController extends ReportController {

    static String gzlGuid = "a97ab58d-5743-4fdd-ac5e-31631bec26fb";//精细化管理,工作量报表id
    static String gzlYsGuid = "fffcb493-1fe1-4583-9598-42af119b7ade";//精细化管理,工作量报表id
    //    @Autowired
//    FmStaffMidService fmStaffMidService;
    @Autowired
    HbiTlfgzlzbService hbiTlfgzlzbService;
    @Autowired
    FmSecondHandlerService fmSecondHandlerService;
    Map<String, Object> datamap;//一个查询数据map,包含所有数据和分组数据

    String charset;
    BOMInputStream bis;
    InputStreamReader isr;
    Iterator<Element> elementIterator;
    Element next;
    String textTrim, wbcode;
    FmAllTwenty fmAllTwentys;
    FmSingle fsingle;
    List<FmSingle> ysfmsingls, ksfmsingls, khfmsingls;
    Map<String, List<FmSingle>> ysgroup, ksgroup, khgroup;
    double sum, avg, groupval;
    String min = "", max = "";
    FmSingle single;
    //    static String gzlYsGuid = "05fcda80-306c-487e-bb87-c1f162793292";//精细化管理,工作量报表id
    private final String GUID = "";
    private final String uid = "";
    private final String loginName = "";
    private String softKey = "";
    private String cxtj = "";
    private String url = "";
    private String requestBody2 = "";
    private String data = "";
    private final String titlexml = "";
    private String dataxml = "";
    private String sql;
    private String[] times;
    private int size, start, end;
    private FmSingleToFront ftf;
    private FmSingle fmSingle, f;
    private InputStream inputStreamboy;
    private Document read;
    private ResultUtil x;
    private List<String> cols1, cols2, cols3, cols4, cols5, cols6, cols7, cols8, cols9, cols10, cols11, cols12, cols13, cols14,
            cols15, cols16, cols17, cols18, cols19, cols20;
    private List<FmSingle> fmSingles, singles, headers, lasters, listData;
    private List<FmAllTwenty> list, someONe, reportDatas, reportDatasForYs;
    private List<Node> nodes;
    private LinkedHashMap<String, Object> dataMaps;
    private List<Map<String, Object>> datas;
    /**
     * 全局使用的处理后的map们，包含yslist，kslist，ksgroup，khlist，khgroup
     */
    private Map<Integer, Map<String, Object>> maps;
    private final Map<String, Object> cacheMap = FMApplicationRunnerImpl.contextMap;
    private Map<String, Object> mapResult, mapData;
    private Map<String, List<FmSingle>> mapSingles;

    @GetMapping("m")
    public ResultUtil m() {
        ArrayList<String> tos = CollUtil.newArrayList(
                "sxtaiyuanzd@163.com",
                "502658195@qq.com");
        String send = BaseMailUtil.sendEmail(tos, "测试", "邮件来自zzz测试");

        return ResultUtil.success(send);
    }

    @GetMapping("c")
    public ResultUtil c() {

        File file = new File("files/image/upload");
        System.out.println("目录  " + file.getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File("files/image/upload/" + "123.txt");
        System.out.println("文件 " + file.getPath());

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.error(e.getMessage());
        }
        FileUtil.appendString("测试成功啦!~!!", file, CharsetUtil.UTF_8);
        return ResultUtil.success("成功");
    }

    @GetMapping("ttt")
    public void tt() {
        SysUserController sc = new SysUserController();
        List<SysUser> users = sysUserService.findAll();
        users.forEach(e -> {
            e.setPwd(sc.toMD5(e.getLogin_name() + "123"));
            sysUserService.update(e);
        });
    }

    /**
     * 获取登录用户的全部工作量信息
     *
     * @param time time
     * @param name name
     * @param ks   科室名称，是院领导时候查询合计总数
     * @return
     */
    @GetMapping("getMyInfo")
    public ResultUtil getMyInfo(String time, String name, String ks) {
        if (null == name || null == time) return ResultUtil.error("参数不能为空");
        checkCacheAndInit(name, time, time + "|@novalue");//获取数据
        if ("院领导".equals(ks)) {//如果是院领导查看time时间段内的全部的合计信息
            if (null == reportDatas) return ResultUtil.success("没有查到相关数据");
            return ResultUtil.success(reportDatas.get(0));
        } else {
            if (null == reportDatasForYs) return ResultUtil.success("没有查到相关数据");
            someONe = reportDatasForYs.stream().filter(e -> name.equals(e.getYs())).collect(Collectors.toList());
        }
        if (someONe.size() == 0) return ResultUtil.success("没有该用户的数据");
        return ResultUtil.success(someONe.get(0));
    }

    /**
     * 获取当前用户,当前时间范围内,某个工作量的参与考核科室或者考核单元列表数组
     *
     * @param time  时间
     * @param type  工作量类型
     * @param name  登录用户名称
     * @param isAll 查询情况
     * @return
     */
    @GetMapping("getChildSelect")
    public ResultUtil getChildSelect(String time, Integer type, String name, Integer isAll) {
//        if (null == name || null == time || null == isAll) return ResultUtil.error("参数不能为空");
//        if (isAll <= 1 || isAll > 3) return ResultUtil.error("参数错误");
//        checkCacheAndInit(name, time, time + "|@novalue");//获取数据
        x = checkParams(time, type, isAll);
        if (x != null) return x;
        if (StringUtil.isEmpty(name)) return ResultUtil.error("参数不能为空");
        if (null == maps || maps.size() == 0) return ResultUtil.success("没有该用户的数据");
        singles = ((List<FmSingle>) maps.get(type).get("yslist")).stream().filter(e -> name.equals(e.getYs())).collect(Collectors.toList());
        if (singles.size() == 0) return ResultUtil.success("没有该用户的数据");
        if (isAll == 2) {
            return ResultUtil.success(singles.get(0).getMyks());
        } else {
            return ResultUtil.success(singles.get(0).getMykh());
        }
    }

    /**
     * 获取某个医生的,某个类型工作量的数据
     *
     * @param time time
     * @param name name
     * @param type type
     * @param ks    科室名称
     * @param isAll 是否全部,1全部;2科室;3考核单元
     * @param khdy  考核单元名字
     * @return
     */
    @GetMapping("getSomeOne")
    public ResultUtil getSomeOne(String time, String name, Integer type, String ks, Integer isAll, String khdy) {
//        if (null == name || null == type || null == time || null == ks) return ResultUtil.error("参数不能为空");
//        if (type > 17 || type < 1) return ResultUtil.error("查询的工作量类型错误");//目前17种工作量
//        if (isAll < 1 || isAll > 3) return ResultUtil.error("查询类型错误");
//        checkCacheAndInit(name, time, time + "|@novalue");//获取数据
        x = checkParams(time, type, isAll);
        if (x != null) return x;
        if (StringUtil.isEmpty(name) || StringUtil.isEmpty(ks)) return ResultUtil.error("参数不能为空");
        if (null == reportDatas) return ResultUtil.success("没有查到相关数据");
        if ("院领导".equals(ks)) {//如果是院领导查看time时间段内的全部的合计信息
            if (isAll != 3) {//不明确查询考核单元默认查询科室情况
                singles = (List<FmSingle>) maps.get(type).get("kslist");
            } else {//查询考核情况
                singles = (List<FmSingle>) maps.get(type).get("khlist");
            }
            size = singles.size();
            if (size == 0) return ResultUtil.success("没有查到相关数据");
            singles = singles.subList(4, size);
            return ResultUtil.success(singles);
        } else if (isAll == 1) {//普通用户,查询全院
            singles = (List<FmSingle>) maps.get(type).get("yslist");//获取某一个类型的工作量数据
            if (singles.size() == 0) return ResultUtil.success("没有查到相关数据");
        } else if (isAll == 2) {//普通用户,查询科室
            singles = ((Map<String, List<FmSingle>>) maps.get(type).get("ksmap")).get(ks);
            if (singles.size() == 0) return ResultUtil.success("没有查到相关数据");
        } else if (isAll == 3) {//普通用户,查询考核单元
            if (null == khdy) return ResultUtil.success("参数不能为空");
            singles = ((Map<String, List<FmSingle>>) maps.get(type).get("khmap")).get(khdy);
            if (singles.size() == 0) return ResultUtil.success("没有查到相关数据");
        }
        f = new FmSingle();//实现了equlse方法,通过name判断该类型,如果name为空,判断ks,如果ks为空,判断khdy
        f.setYs(name);
        int i = singles.indexOf(f);
        if (i < 0) return ResultUtil.success("查无此人在时间段 :" + time + " 内该项数据");
        fmSingle = singles.get(i);
        ftf = new FmSingleToFront();
        ftf.setYs(fmSingle.getYs());
        ftf.setKs(fmSingle.getKs());
        ftf.setKh(fmSingle.getKh());
        ftf.setVal(fmSingle.getVal());
        ftf.setTotle(singles.get(0).getVal());
        ftf.setAvg(singles.get(1).getVal());
        ftf.setMax(singles.get(2).getVal());
        ftf.setMin(singles.get(3).getVal());
        ftf.setPm(fmSingle.getPm());
        ftf.setKspm(fmSingle.getKspm());
        ftf.setKhdypm(fmSingle.getKhdypm());
        return ResultUtil.success(ftf);
    }

    /**
     * 查询某时间段内,某类型的工作量数据的排名前十数据
     *
     * @param type type
     * @param time time
     * @param ks ks
     * @param isAll 是否全部,1全部;2科室;3考核单元
     * @param khdy  考核单元名字
     * @return
     */
    @GetMapping("findTop")
    public ResultUtil getTop(String time, Integer type, String ks, Integer isAll, String khdy) {
        x = getResultUtil(time, type, ks, isAll, khdy);
        if (x.getState().equals("error")) return x;
        else singles = (List<FmSingle>) x.getT();

        size = singles.size();
        if (size == 0) return ResultUtil.success("没有查到相关数据");
        start = 4;
        end = 14;//默认查询顶部10条,singles头部有4条数据是合计,平均,最大,最小
        if (size < 15) end = size;
        return ResultUtil.success(singles.subList(start, end));
    }

    /**
     * 根据条件查询数据结果
     *
     * @param time 如题
     * @param type 如题
     * @param ks 如题
     * @param isAll 如题
     * @param khdy 如题
     * @return
     */
    public ResultUtil getResultUtil(String time, Integer type, String ks, Integer isAll, String khdy) {
        x = checkParams(time, type, isAll);
        if (x != null) return x;
        if (StringUtil.isEmpty(ks)) return ResultUtil.error("参数不能为空");
        if ("院领导".equals(ks)) {//如果是院领导查看time时间段内的全部的合计信息
            if (isAll != 3) {
                singles = (List<FmSingle>) maps.get(type).get("kslist");
            } else {
                singles = (List<FmSingle>) maps.get(type).get("khlist");
            }
        } else if (isAll == 1) {
            singles = (List<FmSingle>) maps.get(type).get("yslist");
        } else if (isAll == 2) {
            singles = ((Map<String, List<FmSingle>>) maps.get(type).get("ksmap")).get(ks);
        } else if (isAll == 3) {
            if (null == khdy) return ResultUtil.error("参数不能为空");
            singles = ((Map<String, List<FmSingle>>) maps.get(type).get("khmap")).get(khdy);
        }
        if (null == singles) return ResultUtil.error("没有查到相关数据");

        return ResultUtil.success(singles);
    }

    /**
     * 检查传入的参数列表，并且初始化数据
     *
     * @param time 如题
     * @param type 如题
     * @param isAll 如题
     * @return
     */
    public ResultUtil checkParams(String time, Integer type, Integer isAll) {
        if (null == type || StringUtil.isEmpty(time) || null == isAll) return ResultUtil.error("参数不能为空");
        if (type > 17 || type < 1) return ResultUtil.error("查询的工作量类型错误");//目前17种工作量
        if (isAll < 1 || isAll > 3) return ResultUtil.error("查询的类型错误");
        checkCacheAndInit(null, time, time + "|@novalue");//获取数据
        if (null == reportDatas) return ResultUtil.error("没有查到相关数据");
        return null;
    }

    /**
     * 获取排名数据,根据传入pagenum查询出需要的数据
     *
     * @param type 如题
     * @param pagenum 需要查询的页数,第一次传null
     * @param time 如题
     * @param name 如题
     * @param ks 如题
     * @param isAll   是否全部,1全部;2科室;3考核单元
     * @param khdy    考核单元名字
     * @return
     */
    @GetMapping("findSort")
    public ResultUtil getSort(String time, Integer type, String ks, Integer isAll, String khdy, Integer pagenum, String name) {
        x = getResultUtil(time, type, ks, isAll, khdy);
        if (x.getState().equals("error")) return x;
        else singles = (List<FmSingle>) x.getT();

        size = singles.stream().filter(e -> e.getDoubleVal() > 0).collect(Collectors.toList()).size();
        if (size == 0) return ResultUtil.success("没有查到相关数据");
        size = size - 4;//数据总数
        int pagesize = size / 10;//总页数
        if (size % 10 != 0) {//除不尽的话页数+1
            pagesize++;
        }
        if (null == pagenum) {//第一次进来查询当前登录医生所在排行榜位置的页数
            if ("院领导".equals(ks)) {
                pagenum = 1;//如果是院领导第一次查询全部排行榜,从头开始展示
            } else {
                f = new FmSingle();
                f.setYs(name);
                int j = singles.indexOf(f) - 3;//singles头部有4条数据是合计,平均,最大,最小,不参与排名i-4;因为获取的list的index,从0开始,i-4+1
                if (j < 0) return ResultUtil.success("查无此人数据");
                if (j <= 10) {//如果是第一页数据
                    pagenum = 1;
                } else {
                    pagenum = j / 10;
                    if (j / 10 != 0) {//除不尽的话页数+1
                        pagenum++;
                    }
                }
            }
        } else if (pagenum < 1 || pagenum > 9999) return ResultUtil.error("请求页数错误");
        if (pagenum > pagesize) {
            return ResultUtil.error("请求页数错误");
        }
        start = 0;//开始截取下标
        end = 0;//终止截取下标
        if (pagenum == 1) {
            start = 4;
            end = 14;
        } else {
            start = (pagenum - 1) * 10 + 4;
            end = (pagenum - 1) * 10 + 14;
            if (end > size) {//如果终止截取下标超出list长度
                end = size;
            }
        }
        if (size < 14) {
            start = 4;
            end = size + 4;
        }
        mapResult = new HashMap<>();
        mapResult.put("obj", singles.subList(start, end));
        mapResult.put("pageNo", pagenum);
        mapResult.put("pageMax", pagesize);
        return ResultUtil.success(mapResult);
    }

    /**
     * @param time    时间
     * @param type    查询类型，工作量
     * @param ks      科室，判断是否院领导
     * @param isAll   查询类型，全院，科室，考核单元
     * @param name    姓名
     * @param queryKs 查询科室
     * @param queryKh 查询考核单元
     * @return
     */
    @GetMapping("getDetail")
    public ResultUtil getDetail(String time, Integer type, String ks, Integer isAll, String name, String queryKs, String queryKh) {
        x = checkParams(time, type, isAll);
        if (null != x) return x;
        if (StringUtil.isEmpty(ks)) return ResultUtil.error("参数不能为空");
        if ("院领导".equals(ks)) {//院领导
            if (isAll <= 2) {
                if (StringUtil.isEmpty(queryKs)) return ResultUtil.error("参数不能为空");
                else
                    mapSingles = (Map<String, List<FmSingle>>) (maps.get(type).get("ksmap"));
                if (!mapSingles.containsKey(queryKs)) return ResultUtil.error("没有查到相关数据");
                mapSingles =
                        mapSingles.get(queryKs).subList(4, mapSingles.get(queryKs).size()).stream().filter(e -> e.getDoubleVal() > 0).collect(Collectors.groupingBy(FmSingle::getYs));
            } else if (isAll == 3) {
                if (StringUtil.isEmpty(queryKh)) return ResultUtil.error("参数不能为空");
                else
                    mapSingles = (Map<String, List<FmSingle>>) (maps.get(type).get("khmap"));
                mapSingles =
                        mapSingles.get(queryKh).subList(4, mapSingles.get(queryKh).size()).stream().filter(e -> e.getDoubleVal() > 0).collect(Collectors.groupingBy(FmSingle::getYs));
            }
            singles = new ArrayList<>();
            mapSingles.keySet().forEach(key -> {
                fmSingles = mapSingles.get(key);
                if (fmSingles.size() > 0) {
                    groupval = fmSingles.stream().map(FmSingle::getDoubleVal).reduce(0.0, (a, b) -> a + b);
                    fmSingle = new FmSingle(groupval + "");
                    fmSingle.setYs(key);
                    fmSingle.setKspm(fmSingles.get(0).getKspm());
                    fmSingle.setKhdypm(fmSingles.get(0).getKhdypm());
                    singles.add(fmSingle);
                }
            });
            Collections.sort(singles);
            return ResultUtil.success(singles);
        } else if (StringUtil.isEmpty(name)) return ResultUtil.error("参数不能为空");
        else {//普通医生
            sql = FMone.getSql(type);
            if (isAll == 2) {
                if (StringUtil.isEmpty(queryKs)) return ResultUtil.error("参数不能为空");
                else sql += " And ksname='" + queryKs + "' ";
            } else if (isAll == 3) {
                if (StringUtil.isEmpty(queryKh)) return ResultUtil.error("参数不能为空");
                else sql += " And khdyname='" + queryKh + "' ";
            }
            if (!time.contains(";")) return ResultUtil.error("时间参数格式错误");
            times = time.split(";");
            sql = sql.replace("@!@", times[0]).replace("@!!@", times[1]).replace("@!!!@", name);
            datas = fmSecondHandlerService.selectSqlWithSQL(sql);
            return ResultUtil.success(datas);
        }
    }

    /**
     * 检查缓存中有否数据,如果没有则初始化数据
     *
     * @param name 当前登录用户名
     * @param time 当前查询时间段
     * @param cxtj 查询条件
     */
    public void checkCacheAndInit(String name, String time, String cxtj) {
        dataMaps = (LinkedHashMap<String, Object>) cacheMap.get("data");

        if (!dataMaps.containsKey(time)) {
            datamap = new HashMap<>();
            long s = System.currentTimeMillis();
            reportDatasForYs = getHttpReport(gzlYsGuid, name, cxtj);
            long e = System.currentTimeMillis();
            System.out.println("查询耗时了 " + (e - s));
            reportDatas = getHttpReport(gzlGuid, name, cxtj);
            System.out.println("查询耗时了 " + (System.currentTimeMillis() - e));
            if (null == reportDatas) return;
            maps = getIntegerListMap(reportDatas, time);
            datamap.put(time + "All", reportDatas);
            datamap.put(time + "Map", maps);
            datamap.put(time + "YsAll", reportDatasForYs);
            dataMaps.put(time, datamap);
        } else {
            datamap = (Map<String, Object>) dataMaps.get(time);
            maps = (Map<Integer, Map<String, Object>>) datamap.get(time + "Map");
            reportDatas = (List<FmAllTwenty>) datamap.get(time + "All");
            reportDatasForYs = (List<FmAllTwenty>) datamap.get(time + "YsAll");
        }
    }
@Autowired
YmlUtil ymlUtil;
    /**
     * 查询报表基础方法,使用http方式
     *
     * @param guid 如题
     * @param loginName 如题
     * @param cxtj 如题
     * @return
     */
    public List<FmAllTwenty> getHttpReport(String guid, String loginName, String cxtj) {
        softKey = GetHBIParam(guid, loginName, ymlUtil.getYmlValue("HBI.name"));
        url = ymlUtil.getYmlValue("HBI.url") + "/view/Dsnreport/Ajax/AjaxCreateReport.ashx?dcxx=&dccxtj=&pageid=&ispage=false&biqtuser=" + loginName + "&Action=reportxml&id=" + guid + "&cxtj=" + cxtj + "&topdata=&timew=&biyccs=&bivar=&weiplan=-99&plantj=&isdsn=1&r=0.9160926348163132&_=1603768990017&softkey=" + softKey;
        requestBody2 = HttpRequest.get(url).execute().body();
        if (null == requestBody2) return null;
        data = EscapeUtil.unescape(requestBody2);
        dataxml = data.substring(data.indexOf("dataxml") + 10, data.lastIndexOf("}") - 1);
        list = new ArrayList<>();
        try {
            inputStreamboy = new ByteArrayInputStream(dataxml.getBytes(StandardCharsets.UTF_8));
            bis = new BOMInputStream(inputStreamboy);
            charset = CharsetUtil.UTF_8;
            if (bis.hasBOM()) {
                charset = bis.getBOMCharsetName();
            }
            isr = new InputStreamReader(bis, charset);
            read = new SAXReader().read(isr);
            nodes = read.selectNodes("//rows/row");
            if (null == nodes || nodes.size() == 0) return null;
            for (Node element : nodes) {
                list.add(initData((Element) element));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("解析数据失败,参数是 : " + guid + " , " + cxtj);
        }
        if (list.size() == 0) return null;
        System.out.println("解析数据成功,参数是 : " + guid + " , " + cxtj);
        return list;
    }

    /**
     * 将用http方式请求回来的数据,把每一行数据解析成需要的数据
     *
     * @param element 每一行数据
     * @return
     */
    public FmAllTwenty initData(Element element) {
        elementIterator = element.elementIterator();
        int i = 0;
        fmAllTwentys = new FmAllTwenty();
        fsingle = new FmSingle();
        while (elementIterator.hasNext()) {
            wbcode = element.attribute("id").getValue();
            next = elementIterator.next();
            textTrim = next.getTextTrim();
            if (textTrim.contains("^")) {
                textTrim = textTrim.split("\\^")[0];
            }
            if (StringUtil.isEmpty(textTrim)) {
                textTrim = "0";
            }
            fmAllTwentys = matchFmData(i, fmAllTwentys, textTrim.trim());
            i++;
        }
        return fmAllTwentys;
    }

    /**
     * 匹配数据
     *
     * @param type 工作量类型
     * @param f 如题
     * @param str 如题
     * @return
     */
    public FmAllTwenty matchFmData(int type, FmAllTwenty f, String str) {
        //type=0这一列是序号
        switch (type) {
            case 1:
                f.setYs(str);
                break;
            case 2:
                f.setKs(str);
                break;
            case 3:
                f.setKh(str);
                break;
            case 4:
                f.setMjzrs(str);
                break;
            case 5:
                f.setSzrs(str);
                break;
            case 6:
                f.setSscs(str);
                break;
            case 7:
                f.setZdssls(str);
                break;
            case 8:
                f.setYzssls(str);
                break;
            case 9:
                f.setZqssls(str);
                break;
            case 10:
                f.setJzssls(str);
                break;
            case 11:
                f.setXy1h(str);
                break;
            case 12:
                f.setZ1d3h(str);
                break;
            case 13:
                f.setDy3h(str);
                break;
            case 14:
                f.setZlczls(str);
                break;
            case 15:
                f.setSjssls(str);
                break;
            case 16:
                f.setWcssls(str);
                break;
            case 17:
                f.setJrssls(str);
                break;
            case 18:
                f.setYlqkshls(str);
                break;
            case 19:
                f.setYlqkgrls(str);
                break;
            case 20:
                f.setSsbfzls(str);
                break;
        }
        return f;
    }

    /**
     * 将包含3列基础数据的20列的数据转成17个包含3列基础数据的数据
     *
     * @param listFmTwentyThreeW 如题
     * @param ks 如题
     * @return
     */
    public Map<Integer, Map<String, Object>> getIntegerListMap(List<FmAllTwenty> listFmTwentyThreeW, String ks) {
//        listFmTwentyThreeW.stream().collect(Collectors.groupingBy(FmAllTwenty::getYs, Collectors.summingDouble(f -> Double.valueOf(f.getMjzrs()))));
        //按列拆分成20列数据
        cols1 = listFmTwentyThreeW.stream().map(FmAllTwenty::getYs).collect(Collectors.toList());
        cols2 = listFmTwentyThreeW.stream().map(FmAllTwenty::getKs).collect(Collectors.toList());
        cols3 = listFmTwentyThreeW.stream().map(FmAllTwenty::getKh).collect(Collectors.toList());
        cols4 = listFmTwentyThreeW.stream().map(FmAllTwenty::getMjzrs).collect(Collectors.toList());
        cols5 = listFmTwentyThreeW.stream().map(FmAllTwenty::getSzrs).collect(Collectors.toList());
        cols6 = listFmTwentyThreeW.stream().map(FmAllTwenty::getSscs).collect(Collectors.toList());
        cols7 = listFmTwentyThreeW.stream().map(FmAllTwenty::getZdssls).collect(Collectors.toList());
        cols8 = listFmTwentyThreeW.stream().map(FmAllTwenty::getYzssls).collect(Collectors.toList());
        cols9 = listFmTwentyThreeW.stream().map(FmAllTwenty::getZqssls).collect(Collectors.toList());
        cols10 = listFmTwentyThreeW.stream().map(FmAllTwenty::getJzssls).collect(Collectors.toList());
        cols11 = listFmTwentyThreeW.stream().map(FmAllTwenty::getXy1h).collect(Collectors.toList());
        cols12 = listFmTwentyThreeW.stream().map(FmAllTwenty::getZ1d3h).collect(Collectors.toList());
        cols13 = listFmTwentyThreeW.stream().map(FmAllTwenty::getDy3h).collect(Collectors.toList());
        cols14 = listFmTwentyThreeW.stream().map(FmAllTwenty::getZlczls).collect(Collectors.toList());
        cols15 = listFmTwentyThreeW.stream().map(FmAllTwenty::getSjssls).collect(Collectors.toList());
        cols16 = listFmTwentyThreeW.stream().map(FmAllTwenty::getWcssls).collect(Collectors.toList());
        cols17 = listFmTwentyThreeW.stream().map(FmAllTwenty::getJrssls).collect(Collectors.toList());
        cols18 = listFmTwentyThreeW.stream().map(FmAllTwenty::getYlqkshls).collect(Collectors.toList());
        cols19 = listFmTwentyThreeW.stream().map(FmAllTwenty::getYlqkgrls).collect(Collectors.toList());
        cols20 = listFmTwentyThreeW.stream().map(FmAllTwenty::getSsbfzls).collect(Collectors.toList());

        maps = new HashMap<>();

        Arrays.stream(FMone.values()).forEach(e -> {
            fmSingles = new ArrayList<>();
            //按要求组合成17组数据,每组数据包含3列公共维度+一列数据值
            for (int i = 0; i < cols1.size(); i++) {
                fmSingle = new FmSingle();
                fmSingle.setYs(cols1.get(i));
                fmSingle.setKs(cols2.get(i));
                fmSingle.setKh(cols3.get(i));
                fmSingle.setType(e.code);
                switch (e.code) {
                    case 1:
                        fmSingle.setVal(cols4.get(i));
                        break;
                    case 2:
                        fmSingle.setVal(cols5.get(i));
                        break;
                    case 3:
                        fmSingle.setVal(cols6.get(i));
                        break;
                    case 4:
                        fmSingle.setVal(cols7.get(i));
                        break;
                    case 5:
                        fmSingle.setVal(cols8.get(i));
                        break;
                    case 6:
                        fmSingle.setVal(cols9.get(i));
                        break;
                    case 7:
                        fmSingle.setVal(cols10.get(i));
                        break;
                    case 8:
                        fmSingle.setVal(cols11.get(i));
                        break;
                    case 9:
                        fmSingle.setVal(cols12.get(i));
                        break;
                    case 10:
                        fmSingle.setVal(cols13.get(i));
                        break;
                    case 11:
                        fmSingle.setVal(cols14.get(i));
                        break;
                    case 12:
                        fmSingle.setVal(cols15.get(i));
                        break;
                    case 13:
                        fmSingle.setVal(cols16.get(i));
                        break;
                    case 14:
                        fmSingle.setVal(cols17.get(i));
                        break;
                    case 15:
                        fmSingle.setVal(cols18.get(i));
                        break;
                    case 16:
                        fmSingle.setVal(cols19.get(i));
                        break;
                    case 17:
                        fmSingle.setVal(cols20.get(i));
                        break;

                }
                fmSingles.add(fmSingle);
            }
            mapData = new HashMap<>();
//            mapData.put("oslist", fmSingles);//原始数据

            headers = fmSingles.subList(0, 4);
            lasters = fmSingles.subList(4, fmSingles.size());
            //按医生名字分组
            ysfmsingls = new ArrayList<>();
            ksfmsingls = new ArrayList<>();
            khfmsingls = new ArrayList<>();
            ysgroup = lasters.stream().collect(Collectors.groupingBy(FmSingle::getYs));
            ysgroup.keySet().stream().forEach(key -> {
                //将某医生分组，某个指标的list的val按double类型求和，如果没结果返回0
                groupval = ysgroup.get(key).stream().map(FmSingle::getDoubleVal).reduce(0.0, (a, b) -> a + b);
                fmSingle = new FmSingle(groupval + "");
                fmSingle.setYs(key);
                //将某医生分组，某个指标的list按科室分组，筛选出值大于零的
                fmSingle.setMyks(ysgroup.get(key).stream().filter(f -> f.getDoubleVal() > 0).collect(Collectors.groupingBy(FmSingle::getKs)).keySet());
                //将某医生分组，某个指标的list按考核单元分组，筛选出值大于零的
                fmSingle.setMykh(ysgroup.get(key).stream().filter(f -> f.getDoubleVal() > 0).collect(Collectors.groupingBy(FmSingle::getKh)).keySet());
                ysfmsingls.add(fmSingle);
            });
            ysfmsingls = reBuilderData(ysfmsingls, 1);//整理出医生全院某个指标排行列表，相当于单独医生维的某个指标的报表信息
            mapData.put("yslist", ysfmsingls);//医生数据

            ksgroup = lasters.stream().collect(Collectors.groupingBy(FmSingle::getKs));//按科室名字分组
            khgroup = lasters.stream().collect(Collectors.groupingBy(FmSingle::getKh));//按考核单元名字分组
            ksfmsingls = new ArrayList<>();
            khfmsingls = new ArrayList<>();
            ksgroup.keySet().stream().forEach(key -> {
                groupval = ksgroup.get(key).stream().map(FmSingle::getDoubleVal).reduce(0.0, (a, b) -> a + b);
                fmSingle = new FmSingle(groupval + "");
                fmSingle.setKs(key);
                ksfmsingls.add(fmSingle);
                ksgroup.put(key, reBuilderData(ksgroup.get(key), 2));
            });
            ksfmsingls = reBuilderData(ksfmsingls, 2);//整理出科室全院某个指标排行列表
            mapData.put("kslist", ksfmsingls);//科室的工作总量,领导查看部分
            mapData.put("ksmap", ksgroup);//科室维度下的明细数据，领导查看部分

            khgroup.keySet().stream().forEach(key -> {
                groupval = khgroup.get(key).stream().map(FmSingle::getDoubleVal).reduce(0.0, (a, b) -> a + b);
                fmSingle = new FmSingle(groupval + "");
                fmSingle.setKh(key);
                khfmsingls.add(fmSingle);
                khgroup.put(key, reBuilderData(khgroup.get(key), 3));
            });
            khfmsingls = reBuilderData(khfmsingls, 3);//整理出考核单元维度某个指标排行列表
            mapData.put("khlist", khfmsingls);//考核单元的工作总量
            mapData.put("khmap", khgroup);//考核单元维度下的明细数据

            maps.put(e.code, mapData);//key是各种类型工作量的编号
        });
//        maps.forEach((k, v) -> {
//            listData = (List<FmSingle>) v.get("list");
//            headers = listData.subList(0, 4);
//            lasters = listData.subList(4, listData.size());
////            Collections.sort(lasters);//降序排序,FmSingle实现了Compareable使用val的int值进行排序
////            lasters.forEach(e -> {//给每条信息增加排名信息
////                e.setPm(lasters.indexOf(e) + 1 + "");
////            });
//            ysgroup = lasters.stream().collect(Collectors.groupingBy(FmSingle::getYs));//按医生名字分组
//            ksgroup = lasters.stream().collect(Collectors.groupingBy(FmSingle::getKs));//按科室名字分组
//            khgroup = lasters.stream().collect(Collectors.groupingBy(FmSingle::getKh));//按考核单元名字分组
//            ysgroup.forEach((kk,vv)->{//将分组后的，张三：科一，科二，科三，重新组装成张三：总数
//
//            });
//            List<FmSingle> kslist = new LinkedList();
//            ksgroup.forEach((kk, vv) -> {
//                reBuilderData(kslist, vv, 2);
//            });
//            headers.addAll(lasters);
////            v.put("list", headers);
////            v.put("map", ksgroup);
//            v.put("list", headers);
//            v.put("map", ksgroup);
//            Collections.sort(kslist);
//            kslist.forEach(e -> {
//                e.setKspm((kslist.indexOf(e) + 1) + "");
//            });
//            kslist.add(0, new FmSingle("最大", "最大", "最大", "0"));
//            kslist.add(0, new FmSingle("最小", "最小", "最小", "0"));
//            kslist.add(0, new FmSingle("平均", "平均", "平均", "0"));
//            kslist.add(0, new FmSingle("合计", "合计", "合计", "0"));
//            v.put("kslist", kslist);
//        });
        return maps;
    }

    /**
     * 重新构建数据,包括合计，平均，最小，最大;并降序排序
     *
     * @param vv   需要重构的list
     * @param type 类型，1为医生，2为科室，3为考核单元
     */
    public List<FmSingle> reBuilderData(List<FmSingle> vv, int type) {
        if (null == vv) return new ArrayList<>();
        size = vv.size();
        if (size <= 0) return new ArrayList<>();
        sum = 0;
        avg = 0;
        min = "";
        max = "";
        single = vv.get(0);
        if (size == 1) {
            avg = sum = single.getDoubleVal();
            max = min = sum + "";
            if (type == 1) {
                single.setPm("1");
            } else if (type == 2) {
                single.setKspm("1");
            } else if (type == 3) {
                single.setKhdypm("1");
            }
        } else {//当list长度不止是1时
            Collections.sort(vv);//倒序排序
            for (int l = vv.size() - 1; l >= 0; l--) {//因为降序排序，所以这里倒序遍历
                if (vv.get(l).compareTo(new FmSingle("0")) < 0) {//因为降序排序，所以0-vv.get(l).getval()<0,为最小有效值
                    min = vv.get(l).getVal();
                    break;
                }
            }
            max = vv.get(0).getVal();//因为降序排序，第一个是最大的
            sum = vv.stream().map(FmSingle::getDoubleVal).reduce(0.0, (a, b) -> a + b);//合计值
            //更新排名情况
            vv.forEach(e -> {
                String order = (vv.indexOf(e) + 1) + "";
                if (type == 1) {
                    e.setPm(order);
                } else if (type == 2) {
                    e.setKspm(order);
                } else if (type == 3) {
                    e.setKhdypm(order);
                }
            });
            avg = sum / size;
        }
        vv.add(0, new FmSingle("最小", "最小", "最小", min));
        vv.add(0, new FmSingle("最大", "最大", "最大", max));
        vv.add(0, new FmSingle("平均", "平均", "平均", new DecimalFormat("#.00").format(avg)));
        vv.add(0, new FmSingle("合计", "合计", "合计", sum + ""));
//        relist.add(new FmSingle(single.getKs(), single.getKs(), single.getKs(), sum + ""));
        return vv;
    }

    @GetMapping("save")
    public ResultUtil save() {
        try {
            Calendar instance = Calendar.getInstance();
            String edate = DateUtil.dateToStr(instance.getTime());
            instance.add(Calendar.DAY_OF_YEAR, -15);
            String sdate = DateUtil.dateToStr(instance.getTime());
            List<String> list = DateUtil.getSplicTimeParam(sdate, edate, "天", 1);
            list.forEach(e -> {
                cxtj = e + ";" + e + "|@novalue";//"2019-11-14;2020-11-14";
                List<FmAllTwenty> list1 = getHttpReport(gzlGuid, "admin", cxtj);
                if (null != list1 && list1.size() > 0) {
                    hbiTlfgzlzbService.insertSome(list1, e);
                    maps = getIntegerListMap(list1, e);
                    datamap = new HashMap<>();
                    datamap.put(e + "All", reportDatas);
                    datamap.put(e + "Map", maps);
                    reportDatasForYs = getHttpReport(gzlYsGuid, "admin", cxtj);
                    datamap.put(e + "YsAll", reportDatasForYs);
                    dataMaps.put(e, datamap);
                }
            });

        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
        return ResultUtil.success("操作成功");
    }

    @GetMapping("saveHistory")
    public ResultUtil saveHistory(String sdate, String edate) {
        try {
            List<String> list = DateUtil.getSplicTimeParam(sdate, edate, "天", 1);
            list.forEach(e -> {
                cxtj = e + ";" + e + "|@novalue";//"2019-11-14;2020-11-14";
                List<FmAllTwenty> list1 = getHttpReport(gzlGuid, "admin", cxtj);
                if (list1 != null && list1.size() > 0) {
                    hbiTlfgzlzbService.insertSome(list1, e);
                }
            });
        } catch (ParseException e) {
            e.printStackTrace();
            return ResultUtil.error("操作失败");
        }
        return ResultUtil.success("操作成功");
    }
}
