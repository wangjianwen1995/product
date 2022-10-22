package com.sxdl.base.controller;

import com.github.pagehelper.PageInfo;
import com.sun.javafx.collections.MappingChange;
import com.sxdl.base.entity.SysVersion;
import com.sxdl.base.service.SysVersionService;
import com.sxdl.base.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v")
public class SysVersionController {
    @Autowired
    SysVersionService sysVersionService;
    Integer size;
    List<SysVersion> fmAppVersionList, apps, pcs;

    @GetMapping("listAll")
    public ResultUtil listAll() {
        fmAppVersionList = sysVersionService.findAll();
        if (fmAppVersionList.size() == 0) return ResultUtil.error("没有查到数据");
        Collections.sort(fmAppVersionList);
        apps = fmAppVersionList.stream().filter(e -> e.getType() == 2).collect(Collectors.toList());
        pcs = fmAppVersionList.stream().filter(e -> e.getType() == 1).collect(Collectors.toList());
        Map<String, List<SysVersion>> maps=new HashMap<>();
        maps.put("apps",apps);
        maps.put("pcs",pcs);
        return ResultUtil.success(maps);
    }

    @GetMapping("listApp")
    public ResultUtil listApp() {
        List<SysVersion> fmAppVersionList = sysVersionService.findAll();
        fmAppVersionList = fmAppVersionList.stream().filter(e -> e.getType() == 2).collect(Collectors.toList());
        Collections.sort(fmAppVersionList);
        return ResultUtil.success(fmAppVersionList);
    }

    @GetMapping("list")
    public ResultUtil list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pi = new PageInfo();
        pi.setPageSize(pageSize);
        pi.setPageNum(pageNum);
        pi = sysVersionService.queryPageList(pi, new SysVersion());
        if (pi.getList().size() == 0) return ResultUtil.error("查询数据为空");
        return ResultUtil.success(pi);
    }

    @PostMapping("add")
    public ResultUtil add(@RequestBody SysVersion sv) {
        try {
            sysVersionService.insert(sv);
        } catch (Exception e) {
            return ResultUtil.error("保存失败");
        }
        return ResultUtil.success("保存成功");
    }

    @GetMapping("findOne/{id:\\d+}")
    public ResultUtil findOne(@PathVariable Integer id) {
        SysVersion sysVersion = sysVersionService.findById(id);
        if (null == sysVersion) return ResultUtil.error("没有查到数据");
        return ResultUtil.success(sysVersion);
    }

    @GetMapping("findLast")
    public ResultUtil findLast() {
        fmAppVersionList = sysVersionService.findAll();
        fmAppVersionList = fmAppVersionList.stream().filter(e -> e.getType() == 2).collect(Collectors.toList());
        size = fmAppVersionList.size();
        if (size == 0) return ResultUtil.error("没有查到数据");
        --size;
        return ResultUtil.success(fmAppVersionList.get(size));
    }

    @PutMapping("update")
    public ResultUtil update(@RequestBody SysVersion sv) {
        try {
            sysVersionService.update(sv);
        } catch (Exception e) {
            return ResultUtil.error("保存失败");
        }
        return ResultUtil.success("保存成功");
    }
}
