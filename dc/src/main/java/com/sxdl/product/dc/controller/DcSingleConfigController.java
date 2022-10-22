package com.sxdl.product.dc.controller;


import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.*;
import com.sxdl.product.dc.service.impl.DcRequestAPIServiceImpl;
import com.sxdl.product.dc.util.DcApplicationRunnerImpl;
import com.sxdl.product.dc.util.WeiNingDataParseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "单抽接口")
@RestController
@RequestMapping("/dcSingleConfig")
public class DcSingleConfigController {


    @Autowired
    private DcScheduleConfigService dcScheduleConfigService;
    @Autowired
    private DcProductService dcProductService;
    @Autowired
    private DcSingleConfigService dcSingleConfigService;
    private List<DcScheduleConfig> dcScheduleConfigs, webs, todcs, fromdcs;
    @Autowired
    private DcRequestAPIServiceImpl dcRequestAPIService;
    @Autowired
    DcProcedureController dcProcedureController;

    @Autowired
    WeiNingDataParseUtil weiNingDataParseUtil;

    @Autowired
    private DcEtlLogService dcEtlLogService;
    @Autowired
    private HandleSerice handleSerice;
    private DcScheduleConfig dcScheduleConfig;
    private String info, pname, startTime, endTime, resultS, ids, bah, kscode, flag;
    ;
    private String sql = "IF  EXISTS ( SELECT name FROM dbo.sysobjects WHERE id = object_id( '[@@@]' ) AND OBJECTPROPERTY( id, 'IsProcedure' ) = 1 )\n" +
            "   select 1\n" +
            "else\n" +
            "   select 2 ";


    @ApiOperation(value = "查询", notes = "查询配置好的调度信息")
    @GetMapping("/findBySome")
    @ResponseBody
    public ResultUtil findAll(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name, @RequestParam(value = "product_id", defaultValue = "") String product_id) {
        try {
            if (null != pageInfo) {
                pageInfo = dcSingleConfigService.selectBySome(pageInfo, name, product_id);
                return ResultUtil.success(pageInfo);
            } else {
                DcSingleConfig dcSingleConfig = new DcSingleConfig();
                if (StringUtil.isNotEmpty(name)) {
                    dcSingleConfig.setName(name);
                }
                if (StringUtil.isNotEmpty(product_id)) {
                    dcSingleConfig.setProduct_id(product_id);
                }

                List<DcSingleConfig> dcSingleConfigs = dcSingleConfigService.select(dcSingleConfig);
                return ResultUtil.success(dcSingleConfigs);
            }


        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }


    @ApiOperation(value = "查询", notes = "查询配置好的调度信息(对接病案)")
    @GetMapping("/findAll")
    @ResponseBody
    public ResultUtil findAll() {
        try {
            List<DcSingleConfig> all = dcSingleConfigService.findAll();

            Map<String, List<DcSingleConfig>> map = all.stream().filter(e-> e.getStatus()==1).collect(Collectors.groupingBy(e->e.getProduct_name()));

            return ResultUtil.success(map);



        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }



    //保存单抽配置
    @ApiOperation(value = "保存", notes = "保存单抽配置")
    @PostMapping("/insertOrUpdate")
    public ResultUtil insertOrUpdate(@RequestBody DcSingleConfig dcSingleConfig) {
        if (dcSingleConfig == null) {
            return ResultUtil.error("没有数据要保存");
        }
        try {
            if (StringUtil.isNotEmpty(dcSingleConfig.getId())) {
                dcSingleConfigService.update(dcSingleConfig);
            } else {
                dcSingleConfigService.insert(dcSingleConfig);
            }
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //删除单抽配置
    @ApiOperation(value = "删除", notes = "删除单抽配置")
    @PostMapping("/delete")
    public ResultUtil delete(@RequestBody Map<String, String> id) {
        if (CollUtil.isEmpty(id)) {
            return ResultUtil.error("没有数据要删除");
        }
        try {
            if (id.containsKey("id")) {
                dcSingleConfigService.deleteSomeById(id.get("id"));
            }
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }

    }

    //执行单抽 ids="'1234','3456','234','xxx'"
    @ApiOperation(value = "执行单抽", notes = "执行单抽")
    @PostMapping("/insertAndExec")
    public ResultUtil insertAndExec(@RequestBody Map<String, String> stringMap) {
        if (CollUtil.isEmpty(stringMap)) {
            return ResultUtil.error("没有数据要保存");
        }
        try {
            if (stringMap.containsKey("ids")) {
                ids = stringMap.get("ids");
            }
            if (stringMap.containsKey("startTime")) {
                startTime = DateUtil.beginOfDay(DateUtil.parse(stringMap.get("startTime"))).toString();
            }
            if (stringMap.containsKey("endTime")) {
                endTime = DateUtil.endOfDay(DateUtil.parse(stringMap.get("endTime"))).toString();
            }

            if (stringMap.containsKey("bah")) {
                bah = stringMap.get("bah");
            }
            if (stringMap.containsKey("flag")) {
                flag = stringMap.get("flag");
            } else {
                flag = "单抽执行";
            }
            dcScheduleConfigs = new ArrayList<>();
            if (DcApplicationRunnerImpl.contextMap.containsKey(ids)) {
                DcApplicationRunnerImpl.contextMap.remove(ids);
            }
            //ids="'"+ids+"'";
            if (StringUtil.isNotEmpty(flag) && "手动调度执行".equals(flag)) {
                //调度执行
                dcScheduleConfigs = dcScheduleConfigService.selectBySingleId(ids, "Product_id", 1);
            } else {
                //单抽执行
                dcScheduleConfigs = dcScheduleConfigService.selectBySingleId(ids, "single_id", 2);
            }
            if (CollUtil.isEmpty(dcScheduleConfigs)) {
                return ResultUtil.error("调度链条数据为空，请先配置");
            }

            //去重
            dcScheduleConfigs = dcScheduleConfigs.stream().filter(e -> null != e && null != e.getType_id() && e.getType_id() != 0).collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<DcScheduleConfig>
                    (Comparator.comparing(DcScheduleConfig::getProcedure_id))), ArrayList::new));
            //遍历配置 为序号是null的设置序号
            dcScheduleConfigs.forEach(e -> {
                if (null == e.getOrdernum()) {
                    e.setOrdernum(0);
                }
                //设置所有的状态为 等待
                e.setStatus(0);
            });
            //排序
            dcScheduleConfigs.sort(Comparator.comparing(DcScheduleConfig::getOrdernum));
            //把本次所有配置相关信息放入缓存中
            DcApplicationRunnerImpl.contextMap.put(ids, dcScheduleConfigs);
           /* //根据存储和web 分组 0工单1web2存储
            Map<Integer, List<DcScheduleConfig>> map = dcScheduleConfigs.stream().parallel().collect(Collectors.groupingBy(e -> e.getType_id()));*/
            long s, e;
            DcRequestAPI requestAPI = new DcRequestAPI();
            Map<String,String> result =new HashMap<>();
            for (DcScheduleConfig dsc : dcScheduleConfigs) {
                dsc.setStatus(3);
                DcApplicationRunnerImpl.contextMap.put(ids, dcScheduleConfigs);
                s = System.currentTimeMillis();
                if (dsc.getType_id() == 1) {
                    //web
                    requestAPI = dcRequestAPIService.selectByKey(dsc.getProcedure_id());
                    //判断加参数
                    requestAPI.setStartTime(startTime);
                    requestAPI.setEndTime(endTime);
                    result = exeWeb(requestAPI, dsc);
                }
                if (2 == dsc.getType_id()) {
                //存储
                    result = exPro(dsc, bah, startTime, endTime, flag);
                }
                if ("true".equals(result.get("status"))) {
                    //执行失败
                    dsc.setStatus(2);
                    dsc.setMessage(result.get("mes"));
                } else {
                    //执行成功
                    dsc.setStatus(1);
                    dsc.setMessage(result.get("mes"));
                }
                e = System.currentTimeMillis();
                e -= s;
                dsc.setDuration(e + "");
                DcApplicationRunnerImpl.contextMap.put(ids, dcScheduleConfigs);
            }

            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }

    }

    @Autowired
    private DcProcedureService dcProcedureService;
    //执行存储过程前先查询是否存在,如果不存在则不处理  //true 运行过程存在问题 false 运行无问题

    public Map<String,String> exPro(DcScheduleConfig ds, String bah, String startTime, String endTime, String flag) throws Exception {
        Map<String,String> result =new HashMap<>();
        pname = ds.getProcedure_name();
        DcProcedure dp = dcProcedureService.findById(ds.getProcedure_id());
        resultS = handleSerice.selecsql(sql.replace("@@@", pname));
        //存储不存在
        if (StringUtil.isEmpty(resultS) || resultS.equals("2")) {
            result.put("status","true");
            result.put("mes","存储在库中不存在");
            return result;
        }
        Integer scope = ds.getScope();
        if (null == scope || scope <= 0) {
            scope = 1;
        }
       /* startTime = WebSoapUtil.getAutoStartTiem(10, scope);
        endTime = WebSoapUtil.getAutoEndDateTime(10);*/
        Integer param = ds.getParam();
        String isyc = "";
        long begin = System.currentTimeMillis(), end;
        StringBuilder sb = new StringBuilder("exec ");
        sb.append(ds.getProcedure_name()).append(" ");

        // 1 有参
        if (1==dp.getIsparam()) {
            // 1 支持单抽 0 否
            if (null != dp.getSupport_single() && "1".equals(dp.getSupport_single())) {
                //支持单抽的调度执行
                sb.append("'" + startTime).append("','").append(endTime + "',").append("'" + bah).append("'");
            } else {
                //不支持单抽的调度执行
                sb.append("'" + startTime).append("','").append(endTime + "'");
            }
        }

        try {
            handleSerice.selectSqlWithSQL(sb.toString());
            List<Map<String, Object>> s = handleSerice.selectSqlWithSQL(sb.toString());
            if (CollUtil.isNotEmpty(s)) {
                for (Map<String, Object> e : s) {
                    if (e.containsKey("状态")) {
                        Object status = e.get("状态");
                        if ("err".equals(status.toString().toLowerCase())) {
                            result.put("status","true");
                            result.put("mes","运行出错！返回消息:" + s.toString());
                            return result;
                        }
                    }
                }
            }
            result.put("status","false");
            result.put("mes","执行成功");
            return result;

        } catch (Exception e) {
            result.put("status","true");
            result.put("mes","运行出错！错误原因：" + e.getCause() + ";" + isyc);
            return result;
        }
    }

    /***
     * 手动抽取数据
     */
    @Autowired
    private DcRequestAPIServiceImpl dcRequestAPIServiceImpl;

    public Map<String,String> exeWeb(DcRequestAPI dcRequestAPI, DcScheduleConfig dcScheduleConfig) {
        Map<String,String> result =new HashMap<>();

        ResultUtil resultUtil = new ResultUtil();
        DcSchedule dcSchedule = new DcSchedule();
        dcSchedule.setParam_unit(dcScheduleConfig.getParam_unit());
        dcSchedule.setParam(dcScheduleConfig.getParam());
        try {
            if (1 == dcRequestAPI.getIsparam()) { //时间范围 类型的web接口
                //存放切割后的时间对
                List<String> timeList = weiNingDataParseUtil.getSplicTimeParamJc(dcRequestAPI.getStartTime(),
                        dcRequestAPI.getEndTime(), dcSchedule.getParam_unit(), false,dcSchedule.getParam());

                //List<String> timeList = WebSoapUtil.getSplicTimeParam(dcRequestAPI.getStartTime(), dcRequestAPI.getEndTime(), dcSchedule.getParam_unit(), dcSchedule.getParam());

                if (9 == (dcRequestAPI.getIs_standard())) {//单独处理卫宁数据
                    resultUtil = dcRequestAPIServiceImpl.autoWNDATAByParams(dcRequestAPI, dcSchedule);
                }else if(10 == (dcRequestAPI.getIs_standard())){
                    dcRequestAPIServiceImpl.autoJCDATA(dcRequestAPI, timeList);
                }else{
                    dcRequestAPIServiceImpl.AutoData1(dcRequestAPI, timeList);
                }
            } else if (3 == dcRequestAPI.getIsparam()) { //无参数类型的web接口\
                resultUtil = dcRequestAPIServiceImpl.AutoData2(dcRequestAPI);
            }
            if (resultUtil.getState().equals("success")) {
                result.put("status","false");
                result.put("mes","执行成功");
                return result;
            } else {
                result.put("status","true");
                result.put("mes","执行错误："+resultUtil.getMsg());
                return result;
            }
        } catch (Exception e) {
            result.put("status","true");
            result.put("mes","执行错误："+e.getCause().toString());
            return result;
        }

    }

    @ApiOperation(value = "查询", notes = "查询配置好的调度信息")
    @GetMapping("/findSingleStatus")
    @ResponseBody

    public ResultUtil findSingleStatus(@RequestParam(value = "ids", defaultValue = "") String ids, String flag) {
        try {
            String msg = "";
            List<DcScheduleConfig> dcScheduleConfigs = (List<DcScheduleConfig>) DcApplicationRunnerImpl.contextMap.get(ids);
            if (CollUtil.isEmpty(dcScheduleConfigs)) {

                if (StringUtil.isNotEmpty(flag) && "手动调度执行".equals(flag)) {
                    //调度执行
                    dcScheduleConfigs = dcScheduleConfigService.selectBySingleId(ids, "Product_id", 1);
                } else {
                    //单抽执行
                    dcScheduleConfigs = dcScheduleConfigService.selectBySingleId(ids, "single_id", 2);
                }
                if (CollUtil.isEmpty(dcScheduleConfigs)) {
                    return ResultUtil.error("调度链条数据为空，请先配置");
                }

                //去重
                dcScheduleConfigs = dcScheduleConfigs.stream().filter(e -> null != e && null != e.getType_id() && e.getType_id() != 0).collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<DcScheduleConfig>
                        (Comparator.comparing(DcScheduleConfig::getProcedure_id))), ArrayList::new));

                //遍历配置 为序号是null的设置序号
                dcScheduleConfigs.forEach(e -> {
                    if (null == e.getOrdernum()) {
                        e.setOrdernum(0);
                    }
                    //设置所有的状态为 等待
                    e.setStatus(0);
                });
                //排序
                dcScheduleConfigs.sort(Comparator.comparing(DcScheduleConfig::getOrdernum));
                //把本次所有配置相关信息放入缓存中
                DcApplicationRunnerImpl.contextMap.put(ids, dcScheduleConfigs);
                return ResultUtil.success(msg);
            }
            Map<Integer, List<DcScheduleConfig>> map = dcScheduleConfigs.stream().parallel().collect(Collectors.groupingBy(e -> e.getStatus()));

            if (map.containsKey(0) || map.containsKey(3)) {

                msg = "运行中";
            }
            if (!map.containsKey(0) && !map.containsKey(3)) {
                msg = "运行完成";
            }

            return ResultUtil.success(dcScheduleConfigs, msg);
        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }
}
