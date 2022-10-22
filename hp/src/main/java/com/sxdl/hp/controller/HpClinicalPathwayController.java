package com.sxdl.hp.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpClinicalPathway;
import com.sxdl.hp.service.HpClinicalPathwayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "临床路径")
@RestController
@RequestMapping("/pathway")
public class HpClinicalPathwayController {


    @Autowired
    HpClinicalPathwayService hpClinicalPathwayService;


    @ApiOperation(value = "下拉框")
    @GetMapping("/findByCondition")
    public ResultUtil findByCondition() throws Exception {
        return ResultUtil.success(hpClinicalPathwayService.selectSelectsIfON());
    }

    @ApiOperation(value = "根据条件查询表内容")
    @GetMapping("/findByLikeSome")
    public ResultUtil findByLikeSome(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name,
                                     @RequestParam(value = "status", defaultValue = "2") String status) throws Exception {
        HpClinicalPathway hpClinicalPathway = new HpClinicalPathway();
        hpClinicalPathway.setName(name);
        hpClinicalPathway.setStatus(status);
        List<HpClinicalPathway> list = hpClinicalPathwayService.selectByLikeName(hpClinicalPathway);
        if (!status.equals("2")) {
            list = list.stream().filter(e -> null != e && e.getStatus().equals(status)).collect(Collectors.toList());
        }
        if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
            return ResultUtil.success(list);
        }
        Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
        return ResultUtil.success(listPage);
    }

    @ApiOperation(value = "新增或者修改保存")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody HpClinicalPathway hpClinicalPathway) throws Exception {
        hpClinicalPathway.setUpdate_time(DateUtil.formatFromDate2(new Date()));
        if (null == hpClinicalPathway.getId() || "".equals(hpClinicalPathway.getId())) {
            hpClinicalPathwayService.insertSelective(hpClinicalPathway);
        } else {
            hpClinicalPathwayService.updateSelective(hpClinicalPathway);
        }
        return ResultUtil.success("保存成功");
    }

}
