package com.sxdl.hp.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpEtlConfig;
import com.sxdl.hp.service.HpEtlConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("etlConfig")
public class HpEtlConfigController {

    @Autowired
    HpEtlConfigService hpEtlConfigService;

    /**
     * 数据抽取页面调用方法
     */
    @GetMapping("findList")
    public ResultUtil findList() throws Exception {
        List<Map<String, Object>> list = ((PageInfo) hpEtlConfigService.findList(null, null, "1", null).getT()).getList();
        return ResultUtil.success(list.stream().collect(Collectors.groupingBy(e -> e.get("status"))));
    }

    /**
     * 抽取配置页面调用方法
     */
    @GetMapping("findAll")
    public ResultUtil findAll(PageInfo p, String name, String type, String status) throws Exception {
        return hpEtlConfigService.findList(p, name, type, status);
    }

    @GetMapping("del")
    public ResultUtil delete(String id) throws Exception {
        hpEtlConfigService.deleteById(id);
        return ResultUtil.success("删除成功");
    }

    @GetMapping("save")
    public ResultUtil insertOrUpdate(HpEtlConfig hpEtlConfig) throws Exception {
        return hpEtlConfigService.insertOrUpdate(hpEtlConfig);
    }
}
