package com.sxdl.hpqc.controller;

import com.sxdl.base.util.*;
import com.sxdl.hpqc.dao.dao1.HpQcResultDao;
import com.sxdl.hpqc.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Api(tags = "病案质控")
@RestController
@RequestMapping("/tjfx")
public class HpQcAnalysisController {


    @Autowired
    HpQcResultService hpQcResultService;
    @Autowired
    YmlUtil ymlUtil;
    @Autowired
    HpQcResultDao hpQcResultDao;


    //质控管理页面第er个接口
    //ascDesc true desc  flase asc
    //class_id 1,2   3  4,7
    @ApiOperation(value = "根据质控问题查询", notes = "质控问题查询")
    @GetMapping("/tjfxOne")
    @ResponseBody
    public ResultUtil tjfxOne(@RequestParam(value = "sdate", defaultValue = "") String sdate,
                              @RequestParam(value = "edate", defaultValue = "") String edate,
                              @RequestParam(value = "is_link", defaultValue = "2") Integer is_link) {

        try {
            String tableName = ymlUtil.getYmlValueOrDefault("qcTable", "homepage_link");

            Integer count = hpQcResultDao.selectCountByCysj(sdate, edate, tableName);
            if (0 == count) {
                return ResultUtil.success("此时间段内未查询到患者数据");
            }
            List<Map<String, Object>> mapList       = hpQcResultService.selectByCysj(sdate, edate, is_link, ">","l", tableName, count);
            List<Map<String, Object>> mapList_first = hpQcResultService.selectByCysj(sdate, edate, is_link, "<","b", tableName, count);

            Map map = new HashMap();
            map.put("first", mapList_first);
            map.put("last", mapList);
            return ResultUtil.success(map);
        } catch (Exception e) {
            return ResultUtil.error("查询失败" + e.getCause());
        }
    }

    //质控管理页面第er个接口
    //ascDesc true desc  flase asc
    //class_id 1,2   3  4,7
    @ApiOperation(value = "根据质控问题查询", notes = "质控问题查询")
    @GetMapping("/tjfxTwo")
    @ResponseBody
    public ResultUtil tjfxTwo(@RequestParam(value = "sdate", defaultValue = "") String sdate,
                              @RequestParam(value = "edate", defaultValue = "") String edate,
                              @RequestParam(value = "is_link", defaultValue = "2") Integer is_link) {

        try {
            String tableName = ymlUtil.getYmlValueOrDefault("qcTable", "homepage_link");
            Integer count = hpQcResultDao.selectCountByCysj(sdate, edate, tableName);
            if (0 == count) {
                return ResultUtil.success("此时间段内未查询到患者数据");
            }
            List<Map<String, Object>> mapList = hpQcResultService.selectByCykb(sdate, edate, is_link,tableName,count);
            return ResultUtil.success(mapList);
        } catch (Exception e) {
            return ResultUtil.error("查询失败" + e.getCause());
        }
    }
}
