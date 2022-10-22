package com.sxdl.product.dc.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.dao.dao1.DcScheduleRuleDao;
import com.sxdl.product.dc.entity.DcScheduleRule;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("调度任务频率规则接口")
@RestController
@RequestMapping("scheduleRule")
public class DcScheduleRuleController {
    @Autowired
    private DcScheduleRuleDao dcScheduleRuleDao;

    //接口列表展示
    @ApiOperation(value = "查询所有调度信息", notes = "查询所有调度信息")
    @GetMapping("/findAll")
    public ResultUtil<List<DcScheduleRule>> findAll() {
        try {
            List<DcScheduleRule> schedules = dcScheduleRuleDao.selectAll ();
            return ResultUtil.success ( schedules );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }



}
