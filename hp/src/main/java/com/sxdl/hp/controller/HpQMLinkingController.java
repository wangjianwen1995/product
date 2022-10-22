package com.sxdl.hp.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.dbo.ModelC;
import com.sxdl.hp.service.HpQmLinkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "环节质控")
@Controller
@RequestMapping("verify/linking")
public class HpQMLinkingController {

    @Autowired
    HpQmLinkingService hpQmLinkingService;

    @GetMapping("login")
    @ResponseBody
    public ResultUtil login(String noStaff, String ysName) {
        return hpQmLinkingService.login(noStaff, ysName);
    }

    @ApiOperation(value = "初始化页面数据")
    @GetMapping("")
    @ResponseBody
    public ResultUtil linking(String bah, String zycs, String cysj) throws Exception {
        return hpQmLinkingService.linking(bah, zycs, cysj);
    }

    @ApiOperation(value = "保存环节数据")
    @PostMapping("save")
    @ResponseBody
    public ResultUtil save(@RequestBody ModelC data) throws Exception {
        return hpQmLinkingService.save(data);
    }

    @ApiOperation(value = "查询病案数据")
    @GetMapping("find")
    @ResponseBody
    public ResultUtil find(String bah, String zycs) throws Exception {
        return hpQmLinkingService.find(bah, zycs);
    }
}
