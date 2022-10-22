package com.sxdl.product.dc.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.HpHospiatlInfoDao;
import com.sxdl.product.dc.entity.HospiatlInfo;
import com.sxdl.product.dc.service.HospiatlInfoService;
import com.sxdl.product.dc.util.DcApplicationRunnerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Api(tags = "病案医院基本信息管理")
@RestController
@RequestMapping("/hospiatlInfo")
public class HospiatlInfoController {

    @Autowired
    HpHospiatlInfoDao hospiatlInfoDao;
    @Autowired
    private HospiatlInfoService hpHospiatlInfoService;
//    @Autowired
//    private HpTableService hpTableService;
    private HospiatlInfo hhi;
    private ResultUtil resultUtil;

    @ApiOperation(value = "测试")
    @GetMapping("/tests")
    public ResultUtil tests(PageInfo page) throws Exception {
        PageInfo pageInfo = null;
        hospiatlInfoDao.selectAll();
        return ResultUtil.success(pageInfo);
    }


    @ApiOperation(value = "查询医院信息列表")
    @GetMapping("/findAll")
    public ResultUtil findAll(PageInfo page) throws Exception {
         PageInfo pageInfo = null;
        HospiatlInfo hpHospiatlInfo = new HospiatlInfo();
        pageInfo = hpHospiatlInfoService.queryPageList(page, hpHospiatlInfo);
        return ResultUtil.success(pageInfo);
    }

    @ApiOperation(value = "查询本医院信息")
    @GetMapping("/findOne")
    public ResultUtil findAll() throws Exception {
        hhi = (HospiatlInfo) DcApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (null == hhi) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        return ResultUtil.success(hhi);
    }

    @GetMapping("test")
    public ResultUtil test(@RequestBody Map<String, Object> map) throws Exception {
        hhi = (HospiatlInfo) DcApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        //hpTableService.mergeSFY(hhi, map, "", new Date());
        return ResultUtil.success("");
    }

    @ApiOperation(value = "修改保存医院基本信息")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody HospiatlInfo hpHospiatlInfo, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        session.setAttribute("his_code", hpHospiatlInfo.getHis_code());
        session.setAttribute("his_name", hpHospiatlInfo.getHis_name());
        //resultUtil = hpTableService.selectEnables(hpHospiatlInfo);
        if (resultUtil.getState().equals("error")) return resultUtil;
        hpHospiatlInfo = (HospiatlInfo) resultUtil.getT();
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            hpHospiatlInfoService.insert(hpHospiatlInfo);
        } else {
            hpHospiatlInfoService.update(hpHospiatlInfo);
        }
        DcApplicationRunnerImpl.contextMap.put("hpHospiatlInfo", hpHospiatlInfo);
        //将标准代码库插入到永久临时表中
        //bzdmkService.initBiaozuns();
        return ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "删除医院基本信息")
    @DeleteMapping("/deleteById")
    public ResultUtil deleteById(@RequestParam(value = "id", required = true) String id) throws Exception {
        hpHospiatlInfoService.deleteById(id);
        DcApplicationRunnerImpl.contextMap.put("hpHospiatlInfo", null);
        return ResultUtil.success("操作成功");
    }
}
