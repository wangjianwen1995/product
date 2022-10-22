package com.sxdl.product.dc.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.service.DcWarningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = ("预警信息"))
@RestController
@RequestMapping("/warning")
public class DcWarningController {
    @Autowired
    private DcWarningService dcWarningService;


    @ApiOperation(value = "查询", notes = "查询所有etl日志信息")

    @GetMapping("/findAll")
    public ResultUtil findByAll(PageInfo pageInfo, @RequestParam(value = "startTime", defaultValue = "") String startTime,
                                @RequestParam(value = "endTime", defaultValue = "") String endTime,
                                @RequestParam(value = "schedule_id", defaultValue = "") String schedule_id,
                                @RequestParam(value = "productId", defaultValue = "") String productId,
                                @RequestParam(value = "exec_id", defaultValue = "") String exec_id) {
        try {
            pageInfo = dcWarningService.selectBySome(pageInfo, startTime, endTime, schedule_id, productId, exec_id);
            return ResultUtil.success(pageInfo, "查询错误日志成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }



}
