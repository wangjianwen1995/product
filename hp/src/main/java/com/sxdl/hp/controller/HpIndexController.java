package com.sxdl.hp.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.service.HpIndexService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("indata")
public class HpIndexController {
    @Autowired
    HpIndexService hpIndexService;

    @ApiOperation(value = "首页获取工作量相关数据")
    @GetMapping("gzl")
    public ResultUtil getGZL(String start, String end, String istb) throws Exception {
        Map<String, Object> allmaps = new HashMap<>();
        allmaps.put("kk", hpIndexService.getGZL(start, end, istb));
        allmaps.put("zxt", hpIndexService.getZXT(start, end));
        return ResultUtil.success(allmaps);
    }

    @ApiOperation(value = "首页数据汇总", notes = "首页数据汇总")
    @GetMapping("/index1")
    public ResultUtil indexInfo(@RequestParam(value = "start", required = true) String start, @RequestParam(value = "end", required = true) String end, @RequestParam(value = "flag", defaultValue = "") String flag, @RequestParam(value = "kscode", defaultValue = "") String kscode) throws Exception {
        Map<String, Object> allmaps = new HashMap<>();
        Map<String, String> maps;
        if (flag.equals("病案")) {
            maps = hpIndexService.findCount2(start, end, flag, "");
        } else {
            maps = hpIndexService.findCount2(start, end, flag, kscode);
        }
        allmaps.put("zxt", hpIndexService.getZXT(start, end));
        allmaps.put("kk", maps);
        return ResultUtil.success(allmaps);
    }
}
