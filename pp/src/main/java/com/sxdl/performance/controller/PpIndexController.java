package com.sxdl.performance.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.performance.service.PpIndexServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/indata")
public class PpIndexController {
    @Autowired
    PpIndexServiceImpl ppIndexService;

    @ApiOperation(value = "首页获取工作量相关数据")
    @GetMapping("gzl")
    public ResultUtil getGZL(String start, String end, String istb) {
        Map<String, Object> allmaps = new HashMap<>();
        allmaps.put("kk", ppIndexService.getGZL(start, end, istb));
//        allmaps.put("zxt",ppIndexService.getZXT(start, end));
        return ResultUtil.success(allmaps);
    }
}
