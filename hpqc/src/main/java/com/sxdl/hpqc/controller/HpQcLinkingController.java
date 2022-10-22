package com.sxdl.hpqc.controller;


import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.hpqc.HpqcMain;
import com.sxdl.hpqc.dao.dao1.HpQcPfResultDao;
import com.sxdl.hpqc.entity.*;
import com.sxdl.hpqc.service.*;
import com.sxdl.hpqc.util.HpqcApplicationRunnerImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "环节质控")
//@RestController
@Controller
@RequestMapping("verify/linking")
public class HpQcLinkingController {
    private JSONObject j;
    @Autowired
    private HpQcHomepageLinkService hpQcHomepageLinkService;
    @Autowired
    private HpQcPfService hpQcPfService;
    @Autowired
    private HpQcResultService hpQcResultService;


    @Autowired
    HpQcWzlService hpQcWzlService;
    @Autowired
    HpQcBzService hpQcBzService;
    @Autowired
    HpQcZhService hpQcZhService;
    @Autowired
    HpQcPfResultDao hpQcPfResultDao;

    List<HpQcPfResultEntity> pfResults;

    /* @GetMapping("getToken")
     @ResponseBody
     public ResultUtil getToken(String noStaff, String ysName) {
         boolean flag = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
         if (!flag) {
             return ResultUtil.error("当前客户没有正确注册系统,需要安排商务对接,详情咨询\"雕龙科技\"微信公众号!");
         }
         if (!"2".equals(HpqcApplicationRunnerImpl.contextMap.get("hasLinking"))) {
             return ResultUtil.error("当前客户没有使用环节质控功能权限,需要安排商务对接,详情咨询\"雕龙科技\"微信公众号!");
         }
         StpUtil.login(0);
         SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
         j = new JSONObject();
         j.putOpt("tokenName", "sxdl");
         j.putOpt("tokenValue", tokenInfo.getTokenValue());
         j.putOpt("SessionTimeout", tokenInfo.getSessionTimeout());

         //System.out.println(tokenInfo.getSessionTimeout());
         return ResultUtil.success(j, "请求成功");
         //return null;
     }*/
    /*noStaff  用户code
     * ysName   用户名称
     * */
    @GetMapping("getToken")
    @ResponseBody
    public ResultUtil getToken(String noStaff, String ysName) {

        StpUtil.login(noStaff);
        SysUser user = new SysUser();
        user.setCode(noStaff);
        user.setName(ysName);
        StpUtil.getSession(true).set("user", user);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        j = new JSONObject();
        j.putOpt("tokenName", "sxdl");
        j.putOpt("tokenValue", tokenInfo.getTokenValue());
        j.putOpt("SessionTimeout", tokenInfo.getSessionTimeout());
        j.putOpt("user", tokenInfo.getTokenValue());
        //System.out.println(tokenInfo.getSessionTimeout());
        return ResultUtil.success(j, "请求成功");
        //return null;
    }


    @PostMapping("/Qm")
    @ResponseBody
    public ResultUtil insert(@RequestBody HomepageQcLinkEntity homepageQcLinkEntity, HttpServletRequest request) throws Exception {
        boolean flag = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
        if (!flag) {
            return ResultUtil.error("当前客户没有正确注册系统,需要安排商务对接,详情咨询\"雕龙科技\"微信公众号!");
        }
        if (!"2".equals(HpqcApplicationRunnerImpl.contextMap.get("hasLinking"))) {
            return ResultUtil.error("当前客户没有使用环节质控功能权限,需要安排商务对接,详情咨询\"雕龙科技\"微信公众号!");
        }
        if (null == homepageQcLinkEntity) {
            return ResultUtil.error("参数异常");
        }
        String level;
        Boolean verify = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
        if (!verify) {
            //level = "1";
            return ResultUtil.error("未注册质控");
        } else {
            level = (String) HpqcApplicationRunnerImpl.contextMap.get("level");
            if (StringUtil.isEmpty(level)) {
                level = "1";
            }
        }
        String bah = homepageQcLinkEntity.getBAH();
        Date cysj = homepageQcLinkEntity.getCYSJ();
        String zxflag = homepageQcLinkEntity.getZXFLAG();
        if (StringUtil.isEmpty(StringUtil.trim(bah)) || null == cysj || StringUtil.isEmpty(StringUtil.trim(zxflag))) {
            return ResultUtil.error("病案号、出院时间、中西医标志等必填参数异常");
        }
        List<Map<String, Object>> mapList = null;
        mapList = hpQcHomepageLinkService.insertOrUpdate(homepageQcLinkEntity,level);
        ResultUtil resultUtil = fzQm(mapList, bah, zxflag,level);
        return resultUtil;
    }

    /*  @PostMapping("/QmHtml")
      //@ResponseBody
      public ModelAndView QmHtml(@RequestBody HomepageQcLinkEntity homepageQcLinkEntity, HttpServletRequest request, HttpServletResponse response) throws Exception {
          boolean flag = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
          ModelAndView modelAndView = new ModelAndView();
          String view = "";
          String msg = "质控中";

          if (!flag) {
              msg = "系统未注册请联系管理员";
              view = "redirect:/error.html?msg=" + msg;
              modelAndView.setViewName(view);
              return modelAndView;
          }
          if (!"2".equals(HpqcApplicationRunnerImpl.contextMap.get("hasLinking"))) {
              msg = "没有环节质控权限";
              view = "redirect:/error.html?msg=" + msg;
              modelAndView.setViewName(view);
              return modelAndView;
          }
          if (null == homepageQcLinkEntity) {
              msg = "参数异常";
              view = "redirect:/error.html?msg=" + msg;
              modelAndView.setViewName(view);
              return modelAndView;
          }
          String bah = homepageQcLinkEntity.getBAH();
          String cysj = DateUtil.formatFromDate(homepageQcLinkEntity.getCYSJ());
          String zxflag = homepageQcLinkEntity.getZXFLAG();
          if (StringUtil.isEmpty(StringUtil.trim(bah)) || StringUtil.isEmpty(StringUtil.trim(cysj)) || StringUtil.isEmpty(StringUtil.trim(zxflag))) {
              msg = "病案号、出院时间、中西医标志等必填参数异常";
              view = "redirect:/error.html?msg=" + msg;
              modelAndView.setViewName(view);
              return modelAndView;
          }
          hpQcHomepageLinkService.insertByEntity(homepageQcLinkEntity);
          view = "redirect:/link.html?msg=" + msg + "&bah=" + bah + "&zxflag=" + zxflag+"&cysj="+cysj;
          modelAndView.setViewName(view);
          return modelAndView;
      }*/
    @Autowired
    YmlUtil ymlUtil;
    @PostMapping("/QmHtml")
    @ResponseBody
    public ResultUtil QmHtml(@RequestBody HomepageQcLinkEntity homepageQcLinkEntity, HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean flag = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
        String msg = "质控中";
        String hpqcip = ymlUtil.getYmlValue("hpqcip");
        if (!flag) {
            msg = "系统未注册请联系管理员";
            hpqcip+="/error.html?msg=" + msg;
            return ResultUtil.error(hpqcip);
        }
        if (!"2".equals(HpqcApplicationRunnerImpl.contextMap.get("hasLinking"))) {
            msg = "没有环节质控权限";
            hpqcip+="/error.html?msg=" + msg;
            return ResultUtil.error(hpqcip);
        }
        if (null == homepageQcLinkEntity) {
            msg = "参数异常";
            hpqcip+="/error.html?msg=" + msg;
            return ResultUtil.error(hpqcip);
        }
        String bah = homepageQcLinkEntity.getBAH();
        String cysj = DateUtil.formatFromDate(homepageQcLinkEntity.getCYSJ());
        String zxflag = homepageQcLinkEntity.getZXFLAG();
        if (StringUtil.isEmpty(StringUtil.trim(bah)) || StringUtil.isEmpty(StringUtil.trim(cysj)) || StringUtil.isEmpty(StringUtil.trim(zxflag))) {
            msg = "病案号、出院时间、中西医标志等必填参数异常";
            hpqcip+="/error.html?msg=" + msg;
            return ResultUtil.error(hpqcip);
        }
        hpQcHomepageLinkService.insertByEntity(homepageQcLinkEntity);
        hpqcip+="/link.html?bah=" + bah + "&zxflag=" + zxflag + "&cysj=" + cysj;
        return ResultUtil.success(hpqcip);
    }


    @GetMapping("/getQmResult")
    @ResponseBody
    public ResultUtil getQmResult(String bah, String cysj, String zxflag)  {
        if (StringUtil.isEmpty(StringUtil.trim(bah)) || null == cysj || StringUtil.isEmpty(StringUtil.trim(zxflag))) {
            return ResultUtil.error("病案号、出院时间、中西医标志等必填参数异常");
        }
        String level;
        Boolean verify = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
        if (!verify) {
            //level = "1";
            return ResultUtil.error("未注册质控");
        } else {
            level = (String) HpqcApplicationRunnerImpl.contextMap.get("level");
            if (StringUtil.isEmpty(level)) {
                level = "1";
            }
        }
        List<Map<String, Object>> mapList = hpQcHomepageLinkService.qmByBah(bah, cysj, zxflag,level);
        ResultUtil resultUtil = fzQm(mapList, bah, zxflag,level);
        return resultUtil;


    }

    private ResultUtil fzQm(List<Map<String, Object>> mapList, String bah, String zxflag,String lever) {
        if (CollUtil.isEmpty(mapList)) {
            return ResultUtil.error("质控失败");
        }
        Object status = mapList.get(0).get("sta");
        if ("0".equals(status)) {
            return ResultUtil.error(mapList.get(0).get("msg") + "");
        }
        try {
        Map map = new HashMap();
        if (StringUtil.isNotEmpty(StringUtil.trim(bah)) && StringUtil.isNotEmpty(StringUtil.trim(zxflag))) {
            String qc_time = mapList.get(0).get("qc_time").toString();
            String qc_id = mapList.get(0).get("qc_id").toString();
            if (StringUtil.isNotEmpty(StringUtil.trim(qc_time)) || StringUtil.isNotEmpty(StringUtil.trim(qc_time))) {
                map = hpQcHomepageLinkService.selectByBahAndTime(bah, "1", zxflag, qc_time, qc_id,lever);
            } else {
                map = hpQcHomepageLinkService.selectByBah(bah, "1", zxflag,lever);
            }
        }
        return ResultUtil.success(map, "质控成功");
        } catch (Exception e) {
            // e.printStackTrace();
            if(e.getMessage().contains("请重新运行该事务")){
                Map map = hpQcHomepageLinkService.selectByBah(bah, "1", zxflag,lever);
                if(CollUtil.isNotEmpty(map)){
                    return ResultUtil.success(map,"质控完成");
                }
            }
            return ResultUtil.error( "质控失败,请重新保存后质控");
        }

    }


    @GetMapping("/getJson")
    @ResponseBody
    public ResultUtil getJson() {
        /*List<HomepageQcLinkEntity> select = hpqcHomepageLinkService.findAll();
        HomepageQcLinkEntity homepageQcLinkEntity = select.get(0);*/
        HomepageQcLinkEntity homepageQcLinkEntity = new HomepageQcLinkEntity();
        JSONObject jsonObject = JSONUtil.parseObj(homepageQcLinkEntity);
        return ResultUtil.success(homepageQcLinkEntity);
    }


    @GetMapping("/getQm")
    @ResponseBody
    public ResultUtil getQm(@RequestParam String bah, @RequestParam String flag) {
        Map<String, Object> resultMap = new HashMap<>();
        //修改一下哦 2022/02/21 重新获取返回值
        pfResults = hpQcPfResultDao.selectbyBahAndFirst(bah, "desc", "1", "a");
        if (pfResults.stream().anyMatch(e -> null != e && 2 == e.getIs_first())) {
            //多次质控 返回最后一次质控结果
            pfResults = pfResults.stream().filter(e -> null != e && 2 == e.getIs_first()).collect(Collectors.toList());
        }
        resultMap = hpQcPfService.getPfInfo(bah, resultMap, flag, pfResults);
        resultMap.put("zk", hpQcResultService.selectbyBah(bah));
        JSONObject jsonObject = JSONUtil.parseObj(resultMap);
        return ResultUtil.success(jsonObject.toString());
    }

    /*
      type :0 评分 1完整率 2 综合
      leve : 1:vip 2:vip+
      link ；1 环节 2 终末
    *
    * */
    @GetMapping("/updatePro")
    @ResponseBody
    public ResultUtil updatePro(@RequestParam Integer type, @RequestParam String leve, @RequestParam Integer link) {

        String sql = "";
        String idList = "";
        String delSql = " =4";
        String proName;
        StringBuffer ids = new StringBuffer();
        //List<HpQmZhEntity> allzh = (List<HpQmZhEntity>) HpApplicationRunnerImpl.contextMap.get("allzh");
        List<HpQcZhEntity> allzh = hpQcZhService.findAll();
        try {
            switch (type) {
                //评分存储
                case 0:
                    List<HpQcPfEntity> allpf = hpQcPfService.findAll();
                    if (1 == link) {
                        proName = "P_LINK_Pf";
                        allpf = allpf.stream().filter(e -> null != e && e.getLink_on() == 1).collect(Collectors.toList());

                    } else {
                        proName = "P_QM_Pf";
                        allpf = allpf.stream().filter(e -> null != e && e.getIs_on() == 1).collect(Collectors.toList());
                    }
                    sql = " alter PROCEDURE [dbo].[" + proName + "] @id varchar(100)\n" +
                            "AS \n" +
                            "BEGIN\n" +
                            "-- select * from homepage\n" +
                            "-- exec P_QM_Pf '53E2FCAD-7057-4256-8996-ED2F6BD8E99D','0'\n" +
                            "-- select * from hp_qm_pf_result\n" +
                            "\n" +
                            "declare @bah varchar(50)\n" +
                            "declare @cysj varchar(50)\n" +
                            "declare @isWest  int \n" +
                            "declare @cykb  varchar(50)\n" +
                            "declare @cykb_name varchar(50)\n" +
                            "declare @link int \n" +
                            "select @bah=BAH,@cysj=CONVERT(varchar(100), CYSJ, 120) ,@isWest=zxflag,@cykb=cykb,@cykb_name=cykbmc,@link=isnull(is_link,2) from homepage_link where id=@id\n" +
                            "delete hp_link_pf_result where bah=@bah \n" +
                            "select * into #temp from hp_qm_pf where is_west=@isWest and  id in \n" +
                            "(select id from  ( select \n";
                    int j = 0;
                    for (HpQcPfEntity e : allpf) {
                        sql += "case when " + e.getSqls() + " then '" + e.getId() + "' else '' end  as id_" + j + ", \n";
                        ids = ids.append("id_" + j + ",");
                        j++;
                    }
                    idList = ids.toString().substring(0, ids.length() - 1);
                    sql += " '' as floor1 \n";
                    sql += " from homepage_link where id = @id ) a \n ";
                    sql += " UNPIVOT(ID FOR Subject IN(" + idList + ")) T \n ";
                    sql += " )  \n" +
                            " delete from  hp_link_pf_result where bah = @bah\n" +
                            "\n" +
                            " select * into #result from hp_link_pf_result where 1=2 \n" +
                            " insert  into #result \n" +
                            " select NEWID(),@bah,fields_anchor,message,ordernum,@cysj,kind_score,CAST(ordernum as varchar(100))+'：'+message+fields ,packages,packages_score,@isWest,@cykb,@cykb_name,@link  from (\n" +
                            " select \n" +
                            " fields_anchor,message,ordernum,kind_score,fields ,packages,packages_score\n" +
                            " from #temp ) result " +
                            " insert  into hp_link_pf_result \n" +
                            " select * from  #result\n" +
                            " insert  into hp_link_pf_result_record \n" +
                            " select * from (select * from  #result\n" +
                            " union\n" +
                            " select NEWID(),@bah,'','总分','',@cysj,\n" +
                            " case when 100-SUM(kfz)<=0 then 0 else 100-SUM(kfz) end,\n" +
                            " '','',null,@isWest,@cykb,@cykb_name,@link  from  #result) a where not exists (select 1 from hp_link_pf_result_record r where a.bah=r.bah)" +
                            " end ";

                    hpQcHomepageLinkService.selectSqlWithSQL(sql);
                    break;
                case 1:
                    //完整率存储

                    List<HpQcWzlEntity> allwzl = hpQcWzlService.findAll();
                    //allwzl = allwzl.stream().filter(e -> null != e && e.getLink_on() == 1).collect(Collectors.toList());
                    if (1 == link) {
                        proName = "P_LINKQM_Wzl";
                        allwzl = allwzl.stream().filter(e -> null != e && e.getLink_on() == 1).collect(Collectors.toList());
                    } else {
                        proName = "P_QM_Wzl";
                        allwzl = allwzl.stream().filter(e -> null != e && e.getIs_on() == 1).collect(Collectors.toList());
                    }
                    sql = " alter PROCEDURE " + proName + " @id varchar(100) \n" +
                            "AS \n" +
                            "BEGIN\n" +
                            "declare @bah varchar(50)\n" +
                            "declare @cysj varchar(50)\n" +
                            "declare @isWest varchar(50)\n" +
                            "declare @cykb varchar(50)\n" +
                            "declare @cykb_name varchar(50)\n" +
                            "declare @link int \n" +
                            "select @bah=BAH,@cysj=CONVERT(varchar(100), CYSJ, 120) ,@isWest=zxflag,@cykb=cykb,@cykb_name=cykbmc,@link=isnull(is_link,2) from homepage_link where id=@id \n" +
                            "delete hp_link_result where bah=@bah and classify_id in (1,2,3) \n" +
                            "insert into hp_link_result " +
                            "select  newID(),@bah,classify,null,message,classify_id,orderum,fields_anchor,can_forced,@cysj ,@isWest,@cykb,@cykb_name,@link  from hp_qm_wzl where id in  \n" +
                            "(select id from  ( select  \n";
                    int i = 0;
                    for (HpQcWzlEntity e : allwzl) {
                        if (e.getClassify_id() == 1) {
                            sql += "case when " + e.getSqls() + " then '" + e.getId() + "' else '' end  as id_" + i + ", \n";
                        } else {
                            sql += "case when " + e.getSqls() + " then ''  else '" + e.getId() + "' end  as id_" + i + ", \n";
                        }
                        ids = ids.append("id_" + i + ",");
                        i++;
                    }
                    idList = ids.toString().substring(0, ids.length() - 1);
                    sql += " '' as floor1 \n";
                    sql += " from homepage_link where id = @id ) a \n ";
                    sql += " UNPIVOT(ID FOR Subject IN(" + idList + ")) T )  \n ";
                    sql += " insert  into hp_link_result_record \n" +
                            " select * from hp_link_result a where not exists (select 1 from hp_link_result_record r where a.bah=r.bah and a.classify_id=r.classify_id ) and a.classify_id in (1,2,3)" +
                            " end ";


                    hpQcHomepageLinkService.selectSqlWithSQL(sql);
                    break;


                case 2:
                    //综合存储
                    switch (leve) {
                        // 用户等级
                        case "1":
                            delSql = " =4";
                            break;
                        case "2":
                            delSql = " in (4,7)";
                            break;
                    }
                    if (1 == link) {
                        proName = "P_LINKQM_ZH_";
                        allzh = allzh.stream().filter(e -> e.getLink_on() == 1).collect(Collectors.toList());
                    } else {
                        proName = "P_QM_ZH_";
                        allzh = allzh.stream().filter(e -> e.getIs_on().equals("1")).collect(Collectors.toList());
                    }

                    sql = " alter PROCEDURE " + proName + "" + leve + " @id varchar(100) \n" +
                            "AS \n" +
                            "BEGIN\n" +
                            "declare @bah varchar(50)\n" +
                            "declare @cysj varchar(50) \n" +
                            "declare @isWest     int\n" +
                            "declare @cykb      varchar(50)\n" +
                            "declare @cykb_name varchar(50)\n" +
                            "declare @link       int \n" +
                            "select @bah=BAH,@cysj=CONVERT(varchar(100), CYSJ, 120) ,@isWest=zxflag,@cykb=cykb,@cykb_name=cykbmc ,@link=isnull(is_link,2) from homepage_link where id=@id \n" +
                            "delete hp_link_result where bah=@bah and classify_id " + delSql + " \n" +
                            " insert into hp_link_result \n" +
                            " select  newID(),@bah,classify,null,message,classify_id,ordernum,fields_anchor,can_forced,@cysj,@isWest,@cykb,@cykb_name,@link      from hp_qm_zh where   lever<=" + leve + " and id in  \n" +
                            " (select id from  ( select  \n";
                    int i3 = 0;
                    //sql+="select ";
                    for (HpQcZhEntity e : allzh) {
                        if ("ID".equals(e.getConnetType())) {
                            sql += "case when " + e.getSqls() + " then '" + e.getId() + "' else '' end  as id_" + i3 + ", \n";
                        } else {
                            sql += "case when " + e.getSqls() + " then '' else '" + e.getId() + "' end  as id_" + i3 + ", \n";
                        }
                        ids = ids.append("id_" + i3 + ",");
                        i3++;
                    }
                    idList = ids.toString().substring(0, ids.length() - 1);
                    sql += " '' as floor1 \n";
                    sql += " from homepage_link where id = @id ) a \n ";
                    sql += " UNPIVOT(ID FOR Subject IN(" + idList + ")) T )  \n ";
                    sql += " insert  into hp_link_result_record \n" +
                            " select * from hp_link_result a where not exists (select 1 from hp_link_result_record r where a.bah=r.bah and a.classify_id=r.classify_id ) and a.classify_id " + delSql + "" +
                            " end ";
                    hpQcHomepageLinkService.selectSqlWithSQL(sql);
                    break;
            }
            return ResultUtil.success("更新成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }


}
