package com.sxdl.hpqc.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.entity.SysMenu;
import com.sxdl.base.entity.SysRoleVsMenu;
import com.sxdl.base.util.*;
import com.sxdl.hpqc.dao.dao1.HpQcPfResultDao;
import com.sxdl.hpqc.dao.dao1.HpQcResultDao;
import com.sxdl.hpqc.dbo.DrQualityDBO;
import com.sxdl.hpqc.dbo.FieldAnchor;
import com.sxdl.hpqc.dbo.HpQcFzmxData;
import com.sxdl.hpqc.dbo.QualityDBO;
import com.sxdl.hpqc.util.DataUtil;
import com.sxdl.hpqc.util.HpqcApplicationRunnerImpl;
import com.sxdl.hpqc.entity.*;
import com.sxdl.hpqc.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.runtime.Desc;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Api(tags = "病案质控")
@RestController
@RequestMapping("/hp_qc")
public class HpQcController {

    @Autowired
    HpQcWzlService hpQcWzlService;

    @Autowired
    HpQcPfService hpQcPfService;

    @Autowired
    HpQcLogService hpQcLogService;

    @Autowired
    HpQcPfResultDao hpQcPfResultDao;
    @Autowired
    HpQcResultDao hpQcResultDao;
    @Autowired
    HpQcBzService hpQcBzService;
    @Autowired
    HpQcZhService hpQcZhService;
    @Autowired
    HpQcResultService hpQcResultService;
    @Autowired
    HpQcHomepageLinkService hpQcHomepageLinkService;
    StringBuilder sb;
    List<HpQcResult> dlResults;
    HomepageQcLinkEntity homepage;
    Map result;
    @Autowired
    YmlUtil ymlUtil;
   /* @Autowired
    PoiUtils poiUtils;*/

    @ApiOperation(value = "查询", notes = "查询某一个质控条件组")
    @GetMapping("/findOneType")
    public ResultUtil findOneType(PageInfo pageInfo, @RequestParam(value = "type", defaultValue = "0") String type, String lever, String name, @RequestParam(value = "is_link", defaultValue = "0") Integer is_link) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        try {
            switch (type) {
                case "0":
                    // 评分
                    mapList = hpQcZhService.selectByLeverOrName("hp_qm_pf", lever, name, is_link);
                    break;
                case "1":
                    //完整
                    mapList = hpQcZhService.selectByLeverOrName("hp_qm_wzl", lever, name, is_link);
                    break;
                case "2":
                    //综合
                    mapList = hpQcZhService.selectByLeverOrName("hp_qm_zh", lever, name, is_link);
                    break;
                case "3":
                    // 字典
                    mapList = hpQcZhService.selectByLeverOrName("hp_qm_bz", lever, name, is_link);
                    break;
            }
            if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                return ResultUtil.success(mapList);
            }

            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), mapList);
            return ResultUtil.success(listPage);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }

    /*@ApiOperation(value = "查询", notes = "查询某一个质控条件组")
    @GetMapping("/findOneType")
    public ResultUtil findOneType(PageInfo pageInfo, @RequestParam(value = "type", defaultValue = "0") String type, String lever, String name, @RequestParam(value = "is_link", defaultValue = "0") Integer is_link) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        try {
            switch (type) {
                case "0":
                    // 评分
                    pageInfo = hpQcZhService.selectByType(pageInfo,"hp_qm_pf", lever, name, is_link,"(6)");
                    break;
                case "1":
                    //完整
                    pageInfo = hpQcZhService.selectByType(pageInfo,"hp_qm_zh", lever, name, is_link,"(1)");
                    break;
                case "2":
                    //综合
                    pageInfo = hpQcZhService.selectByType(pageInfo,"hp_qm_zh", lever, name, is_link,"(4,7)");
                    break;
                case "3":
                    // 字典
                    pageInfo = hpQcZhService.selectByType(pageInfo,"hp_qm_zh", lever, name, is_link,"(5)");
                    break;
            }
            return ResultUtil.success(pageInfo);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }
*/
    @ApiOperation(value = "新增或者更新质控条件sql", notes = "新增或者更新质控条件sql")
    @PutMapping("/insertOrUpdateQmSql")
    @ResponseBody
    public ResultUtil insertOrUpdateQmSql(@RequestBody Map<String, Object> map) {
        if (null == map && map.size() <= 0) {
            return ResultUtil.error("没有数据要保存");
        }
        List<FieldAnchor> list = new ArrayList<>();
        try {
            if (!map.containsKey("type") || !map.containsKey("qcEntity")) {
                return ResultUtil.error("参数异常");
            }
            String type = String.valueOf(map.get("type"));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Object object1 = map.get("qcEntity");
            Integer ordernum = 0;
            switch (type) {
                case "0":
                    // 评分
                    HpQcPfEntity hpQcPfEntity = objectMapper.convertValue(object1, HpQcPfEntity.class);
                    // hpQcPfEntity.setFields(hpQcPfEntity.getFields_anchor());
                    if (StringUtil.isNotEmpty(hpQcPfEntity.getId())) {
                        hpQcPfService.updateSelective(hpQcPfEntity);
                    } else {
                        ordernum = hpQcZhService.findSysMaxOrdernum("ordernum", "hp_qm_pf");
                        hpQcPfEntity.setOrdernum(ordernum + 1);
                        hpQcPfService.insertSelective(hpQcPfEntity);
                    }
                    break;
                case "1":
                    //完整
                    HpQcWzlEntity hpQcWzlEntity = objectMapper.convertValue(object1, HpQcWzlEntity.class);
                    // hpQcWzlEntity.setFields(hpQcWzlEntity.getFields_anchor());
                    if (StringUtil.isNotEmpty(hpQcWzlEntity.getId())) {
                        hpQcWzlService.updateSelective(hpQcWzlEntity);
                    } else {
                        ordernum = hpQcZhService.findSysMaxOrdernum("orderum", "hp_qm_wzl");
                        hpQcWzlEntity.setOrderum(ordernum + 1);
                        hpQcWzlService.insertSelective(hpQcWzlEntity);
                    }
                    break;
                case "2":
                    //综合
                    HpQcZhEntity hpQcZhEntity = objectMapper.convertValue(object1, HpQcZhEntity.class);
                    //hpQcZhEntity.setFields(hpQcZhEntity.getFields_anchor());
                    if (StringUtil.isNotEmpty(hpQcZhEntity.getId())) {
                        hpQcZhService.updateSelective(hpQcZhEntity);
                    } else {
                        ordernum = hpQcZhService.findSysMaxOrdernum("ordernum", "hp_qm_zh");
                        hpQcZhEntity.setOrdernum(ordernum + 1);
                        hpQcZhService.insertSelective(hpQcZhEntity);
                    }
                    break;
                case "3":
                    // 字典
                    HpQcBz hpBzEntity = objectMapper.convertValue(object1, HpQcBz.class);
                    //hpBzPfEntity.setFields(hpBzPfEntity.getFields_anchor());
                    if (StringUtil.isNotEmpty(hpBzEntity.getId())) {
                        hpQcBzService.updateSelective(hpBzEntity);
                    } else {
                        ordernum = hpQcZhService.findSysMaxOrdernum("ordernum", "hp_qm_bz");
                        hpBzEntity.setOrdernum(ordernum + 1);
                        // hpBzEntity.setMessage("11111");
                        hpQcBzService.insertSelective(hpBzEntity);
                    }
                    break;
            }
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("操作失败 " + e.getCause());
        }
    }

    @ApiOperation(value = "测试质控条件sql", notes = "测试质控条件sql")
    @PutMapping("/testQmSql")
    @ResponseBody
    public ResultUtil testQmSql(@RequestBody HpQcZhEntity hpQcZhEntity) {
        try {
            String home_fields = hpQcZhEntity.getHome_fields();
            String sqls = hpQcZhEntity.getSqls();

            sb = new StringBuilder();
            sb.append("select top 10 bah,cysj,id,xm");
            if (StringUtil.isNotEmpty(home_fields)) {
                sb.append(",").append(home_fields);
            }
            sb.append(" from homepage_link  ");
            if (StringUtil.isNotEmpty(sqls)) {
                sb.append(" where ").append(sqls);
            }
            List<Map<String, Object>> list = hpQcZhService.selectSqlWithSQL(sb.toString());
            return ResultUtil.success(list, "测试成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "查询字段", notes = "查询字段")
    @GetMapping("/findColumn")
    @ResponseBody
    public ResultUtil findColumn(PageInfo pageInfo, String name) {
        try {
            String sql = "select home_column,home_content,split_column from fileMarket where 1=1";
            if (StringUtil.isNotEmpty(name)) {
                sql += " and home_column like '%" + name + "%' or home_content like '%" + name + "%'";
            }
            List<Map<String, Object>> list = hpQcZhService.selectSqlWithSQL(sql);
            if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                return ResultUtil.success(list);
            }
            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
            return ResultUtil.success(listPage);
        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }


    /*
     * flag 0:批量质控 else 单个质控的id
     *
     * */
    /*@ApiOperation(value = "数据质控", notes = "数据质控")
    @GetMapping("/insertQuality")
    @ResponseBody
    public ResultUtil Quality(@RequestParam(value = "sdate", defaultValue = "") String sdate, @RequestParam(value = "edate", defaultValue = "") String edate, String flag) {
        try {
            String level;
            Boolean verify = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
            if (!verify) {
                level = "1";
            } else {
                level = (String) HpqcApplicationRunnerImpl.contextMap.get("level");
                if (StringUtil.isEmpty(level)) {
                    level = "1";
                }
            }
            //level = "2";

            hpQcWzlService.excuteQualityByDate("p_zmzk_run", sdate,edate,level);
            return ResultUtil.success("质控成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("质控失败" + e.getMessage());
        }

    }*/

    @ApiOperation(value = "数据质控", notes = "数据质控")
    @GetMapping("/insertQuality")
    @ResponseBody
    public ResultUtil Quality(@RequestParam(value = "sdate", defaultValue = "") String sdate,
                              @RequestParam(value = "edate", defaultValue = "") String edate,
                              String flag, String column, String bah, String zxflag, String is_link) {

        // long l1 = System.currentTimeMillis();
        if (StringUtil.isEmpty(StringUtil.trim(sdate)) || StringUtil.isEmpty(StringUtil.trim(edate))) {
            return ResultUtil.error("参数有误");
        }
        String onClumn = "";
        String hp_status = "";
        String type = "";
        if (StringUtil.isEmpty(is_link)) {
            is_link = "2";
            hp_status = "2";
            onClumn = "0";
        }
        if (!is_link.equals("2")) {
            if (StringUtil.isEmpty(StpUtil.getTokenValue())) {
                return ResultUtil.error("未提供token,请先访问获取token的接口：verify/linking/getToken");
            }
            //环节
            hp_status = "6";
            onClumn = "1";
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


        try {

            String qcTable = ymlUtil.getYmlValueOrDefault("qcTable", "homepage_link");
            String sql = "SELECT b.* into ##Tempomepage FROM " + qcTable + " b WITH(NOLOCK)  Where status=" + hp_status +
                    " and CONVERT(varchar(100),cysj,23)  between ''" + sdate + "'' and ''" + edate + "''";
        /* if (StringUtil.isNotEmpty(StringUtil.trim(flag)) && StringUtil.isNotEmpty(StringUtil.trim(column))) {
            column += "=''" + flag + "''";
        }*/
            if (StringUtil.isNotEmpty(StringUtil.trim(bah))) {
                sql += " and bah=''" + bah + "''";
            }
            //System.out.println(sql);
            // long l = System.currentTimeMillis();
            List<Map<String, Object>> mapList = hpQcWzlService.excuteQualityByDate("p_zmzk_run", sdate, edate, level, sql, qcTable, onClumn, is_link);
            // System.out.println(bah+"质控耗时：" + (System.currentTimeMillis() - l) / 1000 + "s");
            // long l2 = System.currentTimeMillis();
            if (CollUtil.isEmpty(mapList)) {
                return ResultUtil.error("质控失败");
            }
            Object status = mapList.get(0).get("sta");
            if ("0".equals(status)) {
                return ResultUtil.error(mapList.get(0).get("msg") + "");
            }
            if (StringUtil.isNotEmpty(StringUtil.trim(bah)) && StringUtil.isNotEmpty(StringUtil.trim(zxflag))) {
                Map map = new HashMap();
                String qc_time = mapList.get(0).get("qc_time").toString();
                String qc_id = mapList.get(0).get("qc_id").toString();
                if (StringUtil.isNotEmpty(StringUtil.trim(qc_time)) || StringUtil.isNotEmpty(StringUtil.trim(qc_time))) {
                    map = hpQcHomepageLinkService.selectByBahAndTime(bah, is_link, zxflag, qc_time, qc_id, level);
                } else {
                    map = hpQcHomepageLinkService.selectByBah(bah, is_link, zxflag, level);
                }
                //map = hpQcHomepageLinkService.selectByBah(bah, is_link, zxflag);
                //System.out.println(bah+"回显耗时：" + (System.currentTimeMillis() - l2) / 1000 + "s");
                //System.out.println(bah+"总耗时：" + (System.currentTimeMillis() - l1) / 1000 + "s");
                return ResultUtil.success(map, "质控成功");
            }
            return ResultUtil.success(mapList, "质控完成");
        } catch (Exception e) {
            // e.printStackTrace();
            if (e.getMessage().contains("请重新运行该事务")) {
                Map map = hpQcHomepageLinkService.selectByBah(bah, is_link, zxflag, level);
                if (CollUtil.isNotEmpty(map)) {
                    return ResultUtil.success(map, "质控完成");
                }
            }
            return ResultUtil.error("质控失败,请重新保存后质控");
        }

    }

   /* @ApiOperation(value = "字典数据质控", notes = "字典数据质控")
    public boolean QualityBz(String sdate, String edate, String flag) {
        try {
            List<HomepageQcLinkEntity> homepageQcLinkEntityList = new ArrayList<>();
            List<Map<String, List>> list = new ArrayList<>();
            if (StringUtil.isNotEmpty(flag) && !"0".equals(flag)) {
                //单个质控
                homepageQcLinkEntityList = hpQcHomepageLinkService.selectById(flag);
            } else {
                //查询 出院时间段内 没有质控过的患者 isnull(status,'1')=1 并且是 终末质控 isnull(is_link,2)=2
                homepageQcLinkEntityList = hpQcHomepageLinkService.selectByCysj(sdate, edate);
            }
            if (CollUtil.isNotEmpty(homepageQcLinkEntityList)) {

                for (HomepageQcLinkEntity e : homepageQcLinkEntityList) {
                    //字典质控
                    List<HpLinkQcResult> hpQcResults = hpQcBzService.saveDictQualityControlLinkResult(e);
                    // 修改状态为已质控 1:未质控 2:已质控
                    e.setSTATUS("2");
                    e.setIS_LINK(2);
                    e.setZKRQ(DateUtil.strToDate(DateUtil.formatFromDate2(new Date())));
                    hpQcHomepageLinkService.updateSelective(e);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }*/


    @ApiOperation(value = "查看质控日志", notes = "查看质控日志")
    @GetMapping("/findQmRz")
    @ResponseBody
    public ResultUtil findQmRz(PageInfo pageInfo, @RequestParam(value = "sdate", defaultValue = "") String sdate, @RequestParam(value = "edate", defaultValue = "") String edate) {
        try {
            pageInfo = hpQcLogService.queryPageListBufferOrderByTime(pageInfo, new HpQcLog(), "qc_time", sdate, edate);
            return ResultUtil.success(pageInfo);
        } catch (Exception e) {
            return ResultUtil.error("查看质控结果失败" + e.getCause());
        }
    }


    @ApiOperation(value = "查看质控结果一览表", notes = "查看质控结果一览表")
    @GetMapping("/findQmResult")
    @ResponseBody
    public ResultUtil findQmResult(PageInfo pageInfo, String sdate, String edate, String cykb, String bah, @RequestParam(value = "is_link", defaultValue = "2") Integer is_link) {
        try {
            //查询出院时间段内的所有患者
            if (StringUtil.isEmpty(sdate.trim()) && StringUtil.isEmpty(edate.trim()) && StringUtil.isEmpty(cykb) && StringUtil.isEmpty(bah)) {
                return ResultUtil.error("查看质控结果失败,因为参数错误");
            }
            if (StrUtil.isNotEmpty(sdate) && StrUtil.isNotEmpty(edate)) {
                if (10 == sdate.length()) {//年月日
                    sdate += " 00:00:00";
                    edate += " 23:59:59";
                } else if (19 == sdate.length()) {//年月日时分秒
                    edate = DateUtil.endOfDay(DateUtil.parse(edate)).toString();
                } else {
                    return ResultUtil.error("参数必须是时间类型");
                }
            }
            pageInfo = hpQcHomepageLinkService.selectSome(sdate, edate, cykb, bah, pageInfo, is_link);
            return ResultUtil.success(pageInfo);
        } catch (Exception e) {
            return ResultUtil.error("查看质控结果失败" + e.getCause());
        }
    }

    @ApiOperation(value = "根据病案号查看病例明细", notes = "根据病案号查看病例明细")
    @GetMapping("/findHomepage")
    @ResponseBody
    public ResultUtil findHomepage(@RequestParam(value = "id", defaultValue = "") String id, String zxflag, String is_link) {
        try {
            if (StringUtil.isEmpty(id)) {
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
            System.out.println(id);

            Map map = hpQcHomepageLinkService.selectByBahAndFirst(id, is_link, zxflag, "desc", "a", level);
            //map.put("DIC", HpqcApplicationRunnerImpl.contextMap.get("baMapSimple"));
            return ResultUtil.success(map);
        } catch (Exception e) {
            return ResultUtil.error("查看质控结果失败" + e.getCause());
        }
    }

    @ApiOperation(value = "根据病案号查看回顾分析", notes = "根据病案号查看回顾分析")
    @GetMapping("/findCompare")
    @ResponseBody
    public ResultUtil findCompare(@RequestParam(value = "bah", defaultValue = "") String bah, @RequestParam(value = "zxflag", defaultValue = "") String zxflag, @RequestParam(value = "is_link", defaultValue = "2") String is_link) {
        try {
            if (StringUtil.isEmpty(StringUtil.trim(bah)) || StringUtil.isEmpty(StringUtil.trim(zxflag))) {
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
            Map map = hpQcHomepageLinkService.selectByBahAndFirst(bah, is_link, zxflag, "ASC", "b", level);
            Map map2 = hpQcHomepageLinkService.selectByBahAndFirst(bah, is_link, zxflag, "Desc", "a", level);
            Map<String, Map> resultMap = new HashMap<>();
            resultMap.put("first", map);
            resultMap.put("last", map2);
            return ResultUtil.success(resultMap);
        } catch (Exception e) {
            return ResultUtil.error("查看质控结果失败" + e.getCause());
        }
    }

    @ApiOperation(value = "根据病案号查看分组情况", notes = "根据病案号查看分组情况")
    @GetMapping("/findFz")
    @ResponseBody
    public ResultUtil findFz(@RequestParam(value = "bah", defaultValue = "") String bah,
                             @RequestParam(value = "cysj", defaultValue = "") String cysj,
                             @RequestParam(value = "aid", defaultValue = "") String aid, @RequestParam(value = "paymode", defaultValue = "3") Integer paymode) {
        try {
            if (StringUtil.isEmpty(StringUtil.trim(bah)) || StringUtil.isEmpty(StringUtil.trim(cysj)) || StringUtil.isEmpty(StringUtil.trim(aid))) {
                return ResultUtil.error("参数异常");
            }
            String level = "1";
            Boolean verify = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
            if (!verify) {
                // level = "1";
                return ResultUtil.error("未注册质控");
            } else {
                level = (String) HpqcApplicationRunnerImpl.contextMap.get("level");
                if (StringUtil.isEmpty(level)) {
                    level = "1";
                }
            }
            if ("1".equals(level)) {
                return ResultUtil.error("暂未查到数据");
            }
            HpQcFzmxData hpQcRzmxData = hpQcPfService.selectFxmxByBahAndCysj(bah, cysj, paymode);
            if (null == hpQcRzmxData) {
                return ResultUtil.error("暂未查到数据");
            }
            return ResultUtil.success(hpQcRzmxData);
        } catch (Exception e) {
            return ResultUtil.error("查看质控结果失败" + e.getCause());
        }
    }


    @ApiOperation(value = "质控分类", notes = "质控分类")
    @GetMapping("/findQmDict")
    @ResponseBody
    public ResultUtil findQmDict() {
        try {
            Map<Integer, List<SysDictVal>> baBmMap = (Map<Integer, List<SysDictVal>>) HpqcApplicationRunnerImpl.contextMap.get("baBmMap");
            List<SysDictVal> list = baBmMap.get(93);
            return ResultUtil.success(list);
        } catch (Exception e) {
            return ResultUtil.error("字典查询失败" + e.getCause());
        }
    }


    //质控管理页面第一个接口
    //ascDesc true desc  flase asc
    //class_id 1,2   3  4,7
    @ApiOperation(value = "质控问题查询", notes = "质控问题查询")
    @GetMapping("/findQmNumber")
    @ResponseBody
    public ResultUtil findQmNumber(PageInfo pageInfo,
                                   @RequestParam(value = "sdate", defaultValue = "") String sdate,
                                   @RequestParam(value = "edate", defaultValue = "") String edate,
                                   @RequestParam(value = "cykb", defaultValue = "") String cykb,
                                   @RequestParam(value = "platform_on", defaultValue = "") String platform_on,
                                   @RequestParam(value = "order", defaultValue = "") String order,
                                   @RequestParam(value = "ascDesc", defaultValue = "true") boolean ascDesc,
                                   @RequestParam(value = "is_link", defaultValue = "2") Integer is_link,
                                   @RequestParam(value = "classfiy_id", defaultValue = "3") String classfiy_id) {

        try {
            String tableName = "hp_link_result";
            if (StringUtil.isEmpty(StringUtil.trim(sdate)) && StringUtil.isEmpty(StringUtil.trim(edate)) && StringUtil.isEmpty(StringUtil.trim(cykb))) {
                return ResultUtil.error("查看质控结果失败,因为参数错误");
            }
            if (StrUtil.isNotEmpty(sdate) && StrUtil.isNotEmpty(edate)) {
                if (10 == sdate.length()) {//年月日
                    sdate += " 00:00:00";
                    edate += " 23:59:59";
                } else if (19 == sdate.length()) {//年月日时分秒
                    edate = DateUtil.endOfDay(DateUtil.parse(edate)).toString();
                } else {
                    return ResultUtil.error("参数必须是时间类型");
                }
            }
            /*String level = "1";
            Boolean verify = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
            if (!verify) {
                level = "1";
            } else {
                level = (String) HpqcApplicationRunnerImpl.contextMap.get("level");
                if (StringUtil.isEmpty(level)) {
                    level = "1";
                }
            }
            if ("10".equals(classfiy_id)) {
                if ("2".equals(level)) {
                    pageInfo = hpQcHomepageLinkService.findFzbmQmNumber(sdate, edate, cykb, pageInfo);
                }
                return  ResultUtil.success(pageInfo);
            }*/
            if (classfiy_id.contains("6")) {
                tableName = "hp_link_pf_result";
            }
            pageInfo = hpQcHomepageLinkService.findQmNumber(sdate, edate, cykb, platform_on,
                    pageInfo, is_link, classfiy_id, order, ascDesc, tableName);
            return ResultUtil.success(pageInfo);
        } catch (Exception e) {
            return ResultUtil.error("查询失败" + e.getCause());
        }
    }


    //质控管理页面第一个接口 导出数据
    //ascDesc true desc  flase asc
    //class_id 1,2   3  4,7
    @ApiOperation(value = "质控问题导出", notes = "质控问题导出")
    @GetMapping("/downfindQmNumber")
    @ResponseBody
    public void downfindQmNumber(HttpServletResponse response,
                                 @RequestParam(value = "sdate", defaultValue = "") String sdate,
                                 @RequestParam(value = "edate", defaultValue = "") String edate,
                                 @RequestParam(value = "cykb", defaultValue = "") String cykb,
                                 @RequestParam(value = "platform_on", defaultValue = "") String platform_on,
                                 @RequestParam(value = "order", defaultValue = "") String order,
                                 @RequestParam(value = "ascDesc", defaultValue = "true") boolean ascDesc,
                                 @RequestParam(value = "is_link", defaultValue = "2") Integer is_link,
                                 @RequestParam(value = "classfiy_id", defaultValue = "3") String classfiy_id, String classfiy) {

        try {
            PageInfo pageInfo = null;
            String tableName = "hp_link_result";
            //整理时间
            if (StrUtil.isNotEmpty(sdate) && StrUtil.isNotEmpty(edate)) {
                if (10 == sdate.length()) {//年月日
                    sdate += " 00:00:00";
                    edate += " 23:59:59";
                } else if (19 == sdate.length()) {//年月日时分秒
                    edate = DateUtil.endOfDay(DateUtil.parse(edate)).toString();
                } else {
                    return;
                }
            }
            //评分
            if (classfiy_id.contains("6")) {
                tableName = "hp_link_pf_result";
            }
            //查询
            pageInfo = hpQcHomepageLinkService.findQmNumber(sdate, edate, cykb, platform_on,
                    null, is_link, classfiy_id, order, ascDesc, tableName);
            //导出
            List list = pageInfo.getList();
            Map<String, String> colmap = new LinkedHashMap<>();
            colmap.put("rn", "序号");
            colmap.put("homeType", "问题类型");
            colmap.put("classify", "条件类别");
            colmap.put("message", "问题描述");
            colmap.put("num", "问题数");
            colmap.put("messsage_id", "问题描述规则id");
            PoiUtils.createExcel(classfiy + "类质控问题数导出", response, list, colmap);

        } catch (Exception e) {
            return;
        }
    }

    //质控管理页面第er个接口
    //ascDesc true desc  flase asc
    //class_id 1,2   3  4,7
    @ApiOperation(value = "根据质控问题查询", notes = "质控问题查询")
    @GetMapping("/findQmByMessage")
    @ResponseBody
    public ResultUtil findQmByMessage(PageInfo pageInfo,
                                      @RequestParam(value = "sdate", defaultValue = "") String sdate,
                                      @RequestParam(value = "edate", defaultValue = "") String edate,
                                      @RequestParam(value = "cykb", defaultValue = "") String cykb,
                                      @RequestParam(value = "platform_on", defaultValue = "") String platform_on,
                                      @RequestParam(value = "order", defaultValue = "") String order,
                                      @RequestParam(value = "ascDesc", defaultValue = "true") boolean ascDesc,
                                      @RequestParam(value = "is_link", defaultValue = "2") Integer is_link,
                                      @RequestParam(value = "classfiy_id", defaultValue = "3") String classfiy_id,
                                      @RequestParam(value = "message", defaultValue = "") String message, String bah) {

        try {
            String tableName = "hp_link_result";
            if (StringUtil.isEmpty(StringUtil.trim(sdate)) && StringUtil.isEmpty(StringUtil.trim(edate)) && StringUtil.isEmpty(StringUtil.trim(cykb))) {
                return ResultUtil.error("查看质控结果失败,因为参数错误");
            }
            if (StrUtil.isNotEmpty(sdate) && StrUtil.isNotEmpty(edate)) {
                if (10 == sdate.length()) {//年月日
                    sdate += " 00:00:00";
                    edate += " 23:59:59";
                } else if (19 == sdate.length()) {//年月日时分秒
                    edate = DateUtil.endOfDay(DateUtil.parse(edate)).toString();
                } else {
                    return ResultUtil.error("参数必须是时间类型");
                }
            }
           /* String level = "1";
            Boolean verify = (Boolean) HpqcApplicationRunnerImpl.contextMap.get("verify");
            if (!verify) {
                level = "1";
            } else {
                level = (String) HpqcApplicationRunnerImpl.contextMap.get("level");
                if (StringUtil.isEmpty(level)) {
                    level = "1";
                }
            }
            if ("10".equals(classfiy_id)) {
                if ("2".equals(level)) {
                    pageInfo = hpQcHomepageLinkService.findByfzbmHzSql(sdate, edate, cykb,  pageInfo);
                }
                return  ResultUtil.success(pageInfo);
            }
*/

            if (classfiy_id.contains("6")) {
                tableName = "hp_link_pf_result";
            }
            pageInfo = hpQcHomepageLinkService.findQmByMessage(sdate, edate, cykb, platform_on,
                    pageInfo, is_link, classfiy_id, order, ascDesc, tableName, message, bah);
            return ResultUtil.success(pageInfo);
        } catch (Exception e) {
            return ResultUtil.error("查询失败" + e.getCause());
        }
    }

    //质控管理页面第er个接口
    //ascDesc true desc  flase asc
    //class_id 1,2   3  4,7
    @ApiOperation(value = "根据质控问题导出", notes = "质控问题导出")
    @GetMapping("/downfindQmByMessage")
    @ResponseBody
    public void downfindQmByMessage(HttpServletResponse response,
                                    @RequestParam(value = "sdate", defaultValue = "") String sdate,
                                    @RequestParam(value = "edate", defaultValue = "") String edate,
                                    @RequestParam(value = "cykb", defaultValue = "") String cykb,
                                    @RequestParam(value = "platform_on", defaultValue = "") String platform_on,
                                    @RequestParam(value = "order", defaultValue = "") String order,
                                    @RequestParam(value = "ascDesc", defaultValue = "true") boolean ascDesc,
                                    @RequestParam(value = "is_link", defaultValue = "2") Integer is_link,
                                    @RequestParam(value = "classfiy_id", defaultValue = "3") String classfiy_id,
                                    @RequestParam(value = "message", defaultValue = "") String message, String classfiy, String bah) {

        try {
            PageInfo pageInfo = null;
            String tableName = "hp_link_result";
            if (StrUtil.isNotEmpty(sdate) && StrUtil.isNotEmpty(edate)) {
                if (10 == sdate.length()) {//年月日
                    sdate += " 00:00:00";
                    edate += " 23:59:59";
                } else if (19 == sdate.length()) {//年月日时分秒
                    edate = DateUtil.endOfDay(DateUtil.parse(edate)).toString();
                } else {
                    return;
                }
            }
            if (classfiy_id.contains("6")) {
                tableName = "hp_link_pf_result";
            }
            pageInfo = hpQcHomepageLinkService.findQmByMessage(sdate, edate, cykb, platform_on, null, is_link, classfiy_id, order, ascDesc, tableName, message, bah);
            List list = pageInfo.getList();
            Map<String, String> colmap = new LinkedHashMap<>();

            colmap.put("rn", "序号");
            colmap.put("bah", "病案号");
            colmap.put("zycs", "住院次数");
            colmap.put("xm", "患者姓名");
            colmap.put("cykbmc", "出院科室");
            colmap.put("cysj", "出院时间");
            colmap.put("zyzd", "主要诊断");
            colmap.put("SSJCZMC1", "主要手术");
            colmap.put("zyys", "住院医师");
            colmap.put("bmy", "编码员");
            colmap.put("message", "问题描述");
            PoiUtils.createExcel(classfiy + "类质控问题导出", response, list, colmap);

        } catch (Exception e) {
            return;
        }
    }

    @ApiOperation(value = "删除质控日志", notes = "删除质控日志")
    @DeleteMapping("/deleteLog")
    @ResponseBody
    public ResultUtil deleteLog(@RequestParam(value = "id", defaultValue = "") String id) {
        try {
            hpQcLogService.deleteById(id);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }


    @ApiOperation(value = "数据质控")
    @GetMapping("/qualityByOne")
    public ResultUtil qualityByOne(@RequestParam(value = "sdate", defaultValue = "") String sdate,
                                   @RequestParam(value = "edate", defaultValue = "") String edate,
                                   String flag, String column, String bah, String zxflag, String is_link) throws Exception {


        if (StringUtil.isEmpty(StringUtil.trim(sdate)) || StringUtil.isEmpty(StringUtil.trim(edate))) {
            return ResultUtil.error("参数有误");
        }
        String onClumn = "";
        String hp_status = "2";
        String type = "";
        if (StringUtil.isEmpty(is_link)) {
            is_link = "2";
            hp_status = "2";
            onClumn = "0";
        }
        if (!is_link.equals("2")) {
            if (StringUtil.isEmpty(StpUtil.getTokenValue())) {
                return ResultUtil.error("未提供token,请先访问获取token的接口：verify/linking/getToken");
            }
            //环节
            hp_status = "6";
            onClumn = "1";
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
        String qcTable = ymlUtil.getYmlValueOrDefault("qcTable", "homepage_link");
        String sql = "    IF EXISTS(select * from tempdb..sysobjects where id=object_id('tempdb..##Tempomepage')) BEGIN DROP TABLE ##Tempomepage  END    SELECT b.* into ##Tempomepage FROM " + qcTable + " b WITH(NOLOCK)  Where status=" + hp_status +
                " and CONVERT(varchar(100),cysj,23)  between '" + sdate + "' and '" + edate + "'";

        if (StringUtil.isNotEmpty(StringUtil.trim(bah))) {
            sql += " and bah='" + bah + "'";
        }
        //System.out.println(sql);
        long l1 = System.currentTimeMillis();
        String p_zmzk_run = hpQcWzlService.excuteQuality1("p_zmzk_run", sdate, edate, level, sql, qcTable, onClumn, is_link);
        System.out.println(bah + "总耗时：" + (System.currentTimeMillis() - l1) / 1000 + "s");

        return ResultUtil.success(p_zmzk_run);


    }


    @ApiOperation(value = "数据质控")
    @GetMapping("/qualityByOne1")
    public ResultUtil qualityByOne1(@RequestParam(value = "sdate", defaultValue = "") String sdate,
                                    @RequestParam(value = "edate", defaultValue = "") String edate,
                                    String flag, String column, String bah, String zxflag, String is_link) throws Exception {


        if (StringUtil.isEmpty(StringUtil.trim(sdate)) || StringUtil.isEmpty(StringUtil.trim(edate))) {
            return ResultUtil.error("参数有误");
        }
        String onClumn = "";
        String hp_status = "2";
        String type = "";
        if (StringUtil.isEmpty(is_link)) {
            is_link = "2";
            hp_status = "2";
            onClumn = "0";
        }
        if (!is_link.equals("2")) {
            if (StringUtil.isEmpty(StpUtil.getTokenValue())) {
                return ResultUtil.error("未提供token,请先访问获取token的接口：verify/linking/getToken");
            }
            //环节
            hp_status = "6";
            onClumn = "1";
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
       String qcTable = ymlUtil.getYmlValueOrDefault("qcTable", "homepage_link");
        String sql = "    IF EXISTS(select * from tempdb..sysobjects where id=object_id('tempdb..##Tempomepage')) BEGIN DROP TABLE ##Tempomepage  END    SELECT b.* into ##Tempomepage FROM " + qcTable + " b WITH(NOLOCK)  Where status=" + hp_status +
                " and CONVERT(varchar(100),cysj,23)  between '" + sdate + "' and '" + edate + "'";

        if (StringUtil.isNotEmpty(StringUtil.trim(bah))) {
            sql += " and bah='" + bah + "'";
        }
        String qc_id = UUID.randomUUID().toString();
        String qc_time = DateUtil.getCurrentDateForDateTime();
        String is_first = "1";
        String ispf_first = "1";
        try {
        String sql1 = "  declare @qm_id varchar(50),@ispf_first varchar (1),@is_first varchar (1),@qc_time varchar(50),@msg varchar(max),@type varchar(50)\n" +
                "        set @qc_time=convert(varchar,GETDATE(),120)\n" +
                "        set @type=case when "+is_link+"='2' then '终末质控' else '环节质控' end\n" +
                "        IF EXISTS ( select 1 from hp_qm_log  where start_cysj='"+sdate+"' and end_cysj='"+edate+"' and bz=@type + '_'+'"+bah+"') begin\n" +
                "        select @qm_id=id from hp_qm_log  where start_cysj='"+sdate+"'  and end_cysj='"+edate+"'  and bz=@type + '_'+'"+bah+"'end \n" +
                "  else begin set @qm_id=NEWID()\n" +
                "        insert into hp_qm_log(id,start_cysj,end_cysj,qc_time,status,qc_message,bz)\n" +
                "        values(@qm_id,'"+sdate+"','"+edate+"',@qc_time,1,@type+'质控成功',@type + '_'+'"+bah+"')\n" +
                "        end\n" +
                "        IF EXISTS ( select 1 from hp_link_result  where qc_id=@qm_id) begin\n" +
                "        set @is_first='2'  end else begin set @is_first='1' end   " +
                "  IF EXISTS ( select 1 from hp_link_pf_result  where qc_id=@qm_id) begin \n" +
                " set @ispf_first='2'  end else begin set @ispf_first='1' end\n" +
                "        select  @qm_id as qm_id ,@qc_time as qc_time ,@is_first as is_first, @ispf_first as  ispf_first";
        List<Map<String, Object>> mapList = hpQcLogService.selectSqlWithSQL(sql1);
        if (CollUtil.isNotEmpty(mapList)) {

            qc_time = mapList.get(0).get("qc_time").toString();
            qc_id = mapList.get(0).get("qm_id").toString();
            is_first  = mapList.get(0).get("is_first").toString();
            ispf_first= mapList.get(0).get("ispf_first").toString();

        }
        //执行插入数据
        hpQcLogService.selectSqlWithSQL(sql);
        //执行各个存储
      /*  task_pf(sdate, edate, qc_id, is_first, qc_time, onClumn, is_link);
        task_wzl(sdate, edate, qc_id, is_first, qc_time, onClumn, is_link);
        task_zd(sdate, edate, qc_id, is_first, qc_time, onClumn, is_link);
        task_zh(sdate, edate, qc_id, is_first, qc_time, onClumn, is_link,level);*/
       /* if (level.equals("2") && "2".equals(is_link)) {
            task_fzbm(sdate, edate, qc_id, is_first, qc_time, onClumn, is_link);
           // task_rz(sdate, edate, qc_id, is_first, qc_time, onClumn, is_link);
        }*/
        String sql2="   declare @msg varchar(max)\n" +
                "  IF EXISTS ( select 1 from hp_error_log b where  b.qm_id='"+qc_id+"' and b.qc_time='"+qc_time+"' ) begin \n" +
                "  /*有错误 更改此次质控状态为失败*/\n" +
                "  select @msg=qc_message from hp_error_log b where  b.qm_id='"+qc_id+"' and b.qc_time='"+qc_time+"'  \n" +
                " \n" +
                "  update hp_qm_log set hp_qm_log.qc_message='质控失败,错误原因为'+@msg,status=0,qc_time='"+qc_time+"' \n" +
                "  where id='"+qc_id+"' \n" +
                "  end \n" +
                " /*没有错误 更改此次质控状态为成功*/\n" +
                "  else begin \n" +
                "  update hp_qm_log set hp_qm_log.qc_message='质控成功',status=1,qc_time='"+qc_time+"'  where id='"+qc_id+"'\n" +
                "  end\n" +
                "  /*返回质控状态以及消息*/\n" +
                " select isnull(status,1) as sta,isnull(qc_message,'') as msg,'"+qc_id+"' as qc_id,'"+qc_time+"' as qc_time from hp_qm_log a where id='"+qc_id+"'";
        List<Map<String, Object>> mapList2 = hpQcLogService.selectSqlWithSQL(sql2);
        if (CollUtil.isEmpty(mapList2)) {
            return ResultUtil.error("质控失败");
        }
        Object status = mapList2.get(0).get("sta");
        if ("0".equals(status)) {
            return ResultUtil.error(mapList2.get(0).get("msg") + "");
        }
        if (StringUtil.isNotEmpty(StringUtil.trim(bah)) && StringUtil.isNotEmpty(StringUtil.trim(zxflag))) {
            Map map = new HashMap();
            qc_time = mapList2.get(0).get("qc_time").toString();
           qc_id = mapList2.get(0).get("qc_id").toString();
            if (StringUtil.isNotEmpty(StringUtil.trim(qc_time)) || StringUtil.isNotEmpty(StringUtil.trim(qc_time))) {
                map = hpQcHomepageLinkService.selectByBahAndTime(bah, is_link, zxflag, qc_time, qc_id, level);
            } else {
                map = hpQcHomepageLinkService.selectByBah(bah, is_link, zxflag, level);
            }
            //map = hpQcHomepageLinkService.selectByBah(bah, is_link, zxflag);
            //System.out.println(bah+"回显耗时：" + (System.currentTimeMillis() - l2) / 1000 + "s");
            //System.out.println(bah+"总耗时：" + (System.currentTimeMillis() - l1) / 1000 + "s");
            return ResultUtil.success(map, "质控成功");
        }
        return ResultUtil.success(mapList, "质控完成");
    } catch (Exception e) {
        // e.printStackTrace();
        if (e.getMessage().contains("请重新运行该事务")) {
            Map map = hpQcHomepageLinkService.selectByBah(bah, is_link, zxflag, level);
            if (CollUtil.isNotEmpty(map)) {
                return ResultUtil.success(map, "质控完成");
            }
        }
        return ResultUtil.error("质控失败,请重新保存后质控");
    }
    }

  /*  @Async
    private void task_pf(String Sdate, String Edate, String qm_id, String is_first, String qc_time, String onColumn, String is_link) {
        long l = System.currentTimeMillis();




       // hpQcWzlService.excuteQualityByDate("p_zmzk_pf", Sdate, Edate, qm_id, is_first, qc_time, onColumn, is_link);
        System.out.println("p_zmzk_pf 总耗时：" + (System.currentTimeMillis() - l) / 1000 + "s");
    }

    @Async
    private void task_wzl(String Sdate, String Edate, String qm_id, String is_first, String qc_time, String onColumn, String is_link) {
        long l = System.currentTimeMillis();
        hpQcWzlService.excuteQualityByDate("p_zmzk_wzl", Sdate, Edate, qm_id, is_first, qc_time, onColumn, is_link);
        System.out.println("p_zmzk_wzl 总耗时：" + (System.currentTimeMillis() - l) / 1000 + "s");
    }

    @Async
    private void task_zd(String Sdate, String Edate, String qm_id, String is_first, String qc_time, String onColumn, String is_link) {
        long l = System.currentTimeMillis();
        hpQcWzlService.excuteQualityByDate("p_zmzk_bz", Sdate, Edate, qm_id, is_first, qc_time, onColumn, is_link);
        System.out.println("p_zmzk_bz 总耗时：" + (System.currentTimeMillis() - l) / 1000 + "s");
    }

    @Async
    private void task_zh(String Sdate, String Edate, String qm_id, String is_first, String qc_time, String onColumn, String is_link,String lever) {
        long l = System.currentTimeMillis();
        hpQcWzlService.excuteQualityByNine("p_zmzk_zsszd", Sdate, Edate, qm_id, is_first, qc_time, onColumn, is_link,lever);
        System.out.println("p_zmzk_zsszd 总耗时：" + (System.currentTimeMillis() - l) / 1000 + "s");
    }

    //   if(@lever='2') begin
    //  if(@type='终末质控') begin
    //  Exec p_zmzk_rzjc @Sdate,@Edate,@qm_id ,@is_first,@qc_time,@onColumn,@is_link
    //  Exec p_zmzk_fzbm @Sdate,@Edate,@qm_id ,@is_first,@qc_time
    @Async
    private void task_fzbm(String Sdate, String Edate, String qm_id, String is_first, String qc_time, String onColumn, String is_link) {
        long l = System.currentTimeMillis();
        hpQcWzlService.excuteQualityBySix("p_zmzk_fzbm", Sdate, Edate, qm_id, is_first, qc_time);
        System.out.println("p_zmzk_fzbm 总耗时：" + (System.currentTimeMillis() - l) / 1000 + "s");
    }

    @Async
    private void task_rz(String Sdate, String Edate, String qm_id, String is_first, String qc_time, String onColumn, String is_link) {
        long l = System.currentTimeMillis();
        hpQcWzlService.excuteQualityByDate("p_zmzk_rzjc", Sdate, Edate, qm_id, is_first, qc_time, onColumn, is_link);
        System.out.println("p_zmzk_rzjc 总耗时：" + (System.currentTimeMillis() - l) / 1000 + "s");
    }*/

}
