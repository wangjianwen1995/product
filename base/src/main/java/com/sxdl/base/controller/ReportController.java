package com.sxdl.base.controller;


import com.sxdl.base.entity.SysUser;
import com.sxdl.base.service.SysMenuService;
import com.sxdl.base.service.SysUserService;
import com.sxdl.base.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 报告控制器
 */
@Controller
@RequestMapping(value = "/HBI")
public class ReportController {
    /**
     * hbi新型
     */
    private static final String[][] HBI_NEW_TYPE = new String[][]{
            new String[]{"1", "报表", "/dsnreportpreview/mainpage?id="},
            new String[]{"2", "图形", "/dsnchartpreviewmain/page?id="},
            new String[]{"3", "组合页面", "/dsnpagepreview/page?id="},
            new String[]{"4", "选项卡页面", "/dsnpagepreview/tabpage?id="},
            new String[]{"5", "联动页面", "/dsnpagepreview/ldpage?id="},
            new String[]{"6", "自助分析", "/olaptargetpreview/page?id="},
            new String[]{"7", "自助查询", "/olapfieldpreview/page?id="},
            new String[]{"8", "报表引擎", "/reportjsonp/getreport?id="},
            new String[]{"9", "word报告", "/dsnreportwordpreviewmain/page?id="},
            new String[]{"10", "自定义表单", "/vanalysisfrompreview?btn=1111&fid="},
            new String[]{"11", "大屏", "/dsnbigscreen/preview?id="},
            new String[]{"12", "自定义api", "/dsnapiinterface/exec?id=testfunction"}
    };
    /**
     * hbitype
     */
    private static final String[][] HBIType = new String[][]{
            new String[]{"1", "报表", "view/dsnreport/vDsnReportPreviewMain.aspx"},
            new String[]{"2", "图形", "view/dsnreport/vDsnChartPreviewMain.aspx"},
            new String[]{"3", "组合页面", "view/dsnreport/vPagePreviewMain.aspx"},
            new String[]{"4", "对比图形", "view/dsnreport/vDsntjPagePreviewMain.aspx"},
            new String[]{"5", "自定义表单", "view/CustomFrom/vAnalysisFromPreview.aspx"},
            new String[]{"6", "excel", "view/ExcelExport/vExcelExpViewMain.aspx"},
            new String[]{"7", "自定义组合页面", "view/Dsnreport/vDsnZhPageZdyPreview.aspx"},
            new String[]{"9", "维表编辑", "view/marketdata/vweidata.aspx"},
            new String[]{"10", "OLAP自定义查询页面", "view/OLAP/vDsnOLAPPreview.aspx"},
            new String[]{"11", "简易表单", "view/CustomFrom/vCustomFromPreviewMain.aspx"}
    };

    /**
     * 系统菜单服务
     */
    @Autowired
    public SysMenuService sysMenuService;
    /**
     * 系统用户服务
     */
    @Autowired
    public SysUserService sysUserService;
    String publicKey, URL,token;
    @Autowired
    private YmlUtil ymlUtil;

    /**
     * 得到hbiinfo
     *
     * @param lx lx
     * @return {@link String[]}
     */
    public static String[] GetHBIInfo(String lx) {
        String[] Result = new String[]{"", ""};
        for (String[] HBIInfo : HBIType) {
            if (HBIInfo[0].equals(lx)) {
                Result[0] = HBIInfo[1];  //HBI调用模块的名称
                Result[1] = HBIInfo[2];  //HBI调用模块的URL地址
                break;
            }
        }
        return Result;
    }

    /**
     * hbi类型新
     *
     * @param lx lx
     * @return {@link String}
     */
    private String getHbiTypeNew(String lx) {
        for (String[] ss : HBI_NEW_TYPE) {
            if (ss[0].equals(lx)) {
                return ss[2];
            }
        }
        return null;
    }

    /**
     * getv
     *
     * @return {@link ResultUtil}
     */
    @RequestMapping(value = "/v")
    @ResponseBody
    public ResultUtil getV() {
        return ResultUtil.success(ymlUtil.getIsNew());
    }

    /**
     * 得到报告
     *
     * @param request  请求
     * @return {@link ResultUtil}
     */
    @RequestMapping(value = "/GetReport")
    @ResponseBody
    public ResultUtil getReport(HttpServletRequest request) {
        //从请求路径中获取当前报表的GUID和类型
        String GUID = request.getParameter("GUID") == null ? "" : request.getParameter("GUID");
        String uid = request.getParameter("uid") == null ? "" : request.getParameter("uid");
        String lx = request.getParameter("lx") == null ? "" : request.getParameter("lx");
        String yccs = request.getParameter("biyccs") == null ? "" : request.getParameter("biyccs");
        URL = ymlUtil.getHbiURL();
        if ("1".equals(ymlUtil.getIsNew())) {
            publicKey = ymlUtil.getPublicKey();
            if (StringUtil.isEmpty(publicKey)) {
                return ResultUtil.error("请联系系统管理员配置HBI密钥,并重启系统使用!");
            }
            lx = getHbiTypeNew(lx);
            if (StringUtil.isEmpty(lx)) {
                return ResultUtil.error("参数不正确!");
            }
            if (getToken()) return ResultUtil.error("请联系系统管理员配置HBI密钥,并重启系统使用!");
            URL += lx;
            URL += GUID;
            URL += "&ispage=false&biqtuser=&cxtj=&biyccs=&softkey=" + token;
            System.out.println("ok   " + URL);
            return ResultUtil.success(URL, "请求成功");
        }

        String menuCode = request.getParameter("MenuCode") == null ? "" : request.getParameter("MenuCode");
        String HBIType = request.getParameter("HBIURL") == null ? "HBIURL" : request.getParameter("HBIURL");

        SysUser user = new SysUser();
        user.setId(Integer.parseInt(uid));
        user = sysUserService.selectOne(user);

        String hbiName = ymlUtil.getYmlValue("HBI.name");

        String loginName = user.getLogin_name();
        String softKey = GetHBIParam(GUID, loginName, hbiName);

        String[] HBIInfo = GetHBIInfo(lx);
        String strPage = HBIInfo[1];

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String rand = df.format(new Date().getTime());
        String rptSRC = URL + "/" + strPage + "?biqtuser=" + loginName + "&id=" + GUID + "&softkey=" + softKey + "&biyccs=" + yccs + "&rand=" + rand + "&fid=" + GUID + "&cxtj=" + null + "&bivar=";
        System.out.println("ok   " + rptSRC);
        return ResultUtil.success(rptSRC, "请求成功");
    }

    /**
     * 获得令牌
     *
     * @return boolean
     */
    private boolean getToken() {
        Map<String, Object> map = ApplicationRunnerImpl.contextMap;
        if (map.containsKey("hbitoken")) {
            token = map.get("hbitoken").toString();
            return StringUtil.isEmpty(token);
        } else {
            return true;
        }
    }

    /**
     * 得到报告数据完整请求路径
     *
     * @param id id
     * @param cxtj 查询条件
     * @return {@link String} url路径
     */
    public ResultUtil getReportData(String id,String cxtj) {
        if (getToken()) return ResultUtil.error("请联系系统管理员配置HBI密钥,并重启系统使用!");
        URL = ymlUtil.getHbiURL();
        URL += "/reportjsonp/getreport?id=" + id;
        URL += "&softkey=" + token;
        URL += "&cxtj="+cxtj+"&biqtuser=&bivar=&biyccs=&topdata=&timew=&weiplan=";
        return ResultUtil.success(URL);
    }
    /**
     * 得到报告数据完整请求路径
     *
     * @param id id
     * @return {@link ResultUtil}
     */
    @RequestMapping("getReprotData")
    @ResponseBody
    public ResultUtil getReportData(String id) {
        if (getToken()) return ResultUtil.error("请联系系统管理员配置HBI密钥,并重启系统使用!");
        URL = ymlUtil.getHbiURL();
        URL += "/reportjsonp/getreport?id=" + id;
        URL += "&softkey=" + token;
        URL += "&cxtj=&biqtuser=&bivar=&biyccs=&topdata=&timew=&weiplan=";
        return ResultUtil.success(URL);
    }
    /**
     * 得到hbiparam
     *
     * @param strRptGID str rpt gid
     * @param loginName 登录名
     * @param hbiName   hbi名字
     * @return {@link String}
     */
    public String GetHBIParam(String strRptGID, String loginName, String hbiName) {
        Date newdate = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        df.format(newdate.getTime());
        String str = loginName + "longWebHBI" + strRptGID.toUpperCase() + df.format(newdate.getTime()) + hbiName;
        return MD5Util.MD5Encoder(MD5Util.MD5Encoder(str).toLowerCase()).toUpperCase();
    }
}
