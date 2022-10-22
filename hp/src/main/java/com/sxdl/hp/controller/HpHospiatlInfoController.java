package com.sxdl.hp.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.service.HpBzdmkService;
import com.sxdl.hp.service.HpHospiatlInfoService;
import com.sxdl.hp.service.HpTableService;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "病案医院基本信息管理")
@RestController
@RequestMapping("/hospiatlInfo")
public class HpHospiatlInfoController {

    @Autowired
    HpBzdmkService bzdmkService;
    @Autowired
    private HpHospiatlInfoService hpHospiatlInfoService;
    @Autowired
    private HpTableService hpTableService;
    private HpHospiatlInfo hhi;
    private ResultUtil resultUtil;

    @ApiOperation(value = "查询医院信息列表")
    @GetMapping("/findAll")
    public ResultUtil findAll(PageInfo page) throws Exception {
        PageInfo pageInfo = null;
        HpHospiatlInfo hpHospiatlInfo = new HpHospiatlInfo();
        pageInfo = hpHospiatlInfoService.queryPageList(page, hpHospiatlInfo);
        return ResultUtil.success(pageInfo);
    }

    @ApiOperation(value = "查询本医院信息")
    @GetMapping("/findOne")
    public ResultUtil findAll() throws Exception {
        hhi = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (null == hhi) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        return ResultUtil.success(hhi);
    }

//    @GetMapping("test")
//    public ResultUtil test(@RequestBody Map<String, Object> map) throws Exception {
//        hhi = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
//        hpTableService.mergeSFY(hhi, map, "", new Date());
//        return ResultUtil.success("");
//    }

    @ApiOperation(value = "修改保存医院基本信息")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody HpHospiatlInfo hpHospiatlInfo, HttpServletRequest request) throws Exception {
        return hpHospiatlInfoService.saveorupdate(hpHospiatlInfo, request);
    }


    @ApiOperation(value = "删除医院基本信息")
    @DeleteMapping("/deleteById")
    public ResultUtil deleteById(@RequestParam(value = "id", required = true) String id) throws Exception {
        hpHospiatlInfoService.deleteById(id);
        HpApplicationRunnerImpl.contextMap.put("hpHospiatlInfo", null);
        return ResultUtil.success("操作成功");
    }
}
