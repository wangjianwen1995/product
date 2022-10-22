package com.sxdl.fm.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.fm.entity.FmKhdy;
import com.sxdl.fm.service.FmKhdyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("khdy")
public class FmKhdyController {
    @Autowired
    FmKhdyService fmKhdyService;

    private PageInfo<FmKhdy> pi;
    private FmKhdy khdy;

    private List<FmKhdy> khdys;

    //查询某个名称的考核单元信息
    @GetMapping("find")
    public ResultUtil findone(String name) {
        if (null == name || name.trim().equals("")) return ResultUtil.error("参数不能为空");
        khdy = new FmKhdy();
        khdy.setName(name);
        khdy = fmKhdyService.selectOne(khdy);
        if (null == khdy) return ResultUtil.error("查询结果为空");
        return ResultUtil.success(khdy);
    }

    //查询已启用的某个名称的考核单元信息
    @GetMapping("findOn")
    public ResultUtil findOn(String name) {
        if (null == name || name.trim().equals("")) return ResultUtil.error("参数不能为空");
        khdy = new FmKhdy();
        khdy.setName(name);
        khdy.setIson(1);
        fmKhdyService.selectOne(khdy);
        if (null == khdy) return ResultUtil.error("查询结果为空");
        return ResultUtil.success(khdy);
    }

    @GetMapping("listByPage")
    public ResultUtil listByPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize, String name,Integer ison) {
        pi=new PageInfo<>();
        pi.setPageNum(pageNum);
        pi.setPageSize(pageSize);
        khdy = new FmKhdy();
        if(StringUtil.isNotEmpty(name))  khdy.setName(name);
        if(null!=ison) khdy.setIson(ison);
        pi = fmKhdyService.queryPageList(pi, khdy);
        return ResultUtil.success(pi);
    }

    @GetMapping("list")
    public ResultUtil list() {
        khdy = new FmKhdy();
        khdy.setIson(1);
        khdys = fmKhdyService.select(khdy);
        if (null == khdys || khdys.size() == 0) ResultUtil.error("查询结果为空");
        return ResultUtil.success(khdys);
    }

    @PostMapping("add")
    public ResultUtil add(@RequestBody FmKhdy fmKhdy) {
        if (null == fmKhdy || null == fmKhdy.getName() || null == fmKhdy.getIson()) return ResultUtil.error("参数不能为空");
        int result=fmKhdyService.insert(fmKhdy);
        if(result==-1) return ResultUtil.error("已经存在相同名字的信息!");
        return ResultUtil.success("保存成功");
    }

    @PutMapping("update")
    public ResultUtil update(@RequestBody FmKhdy fmKhdy) {
       if(null==fmKhdy.getIson())fmKhdy.setIson(0);
        fmKhdyService.update(fmKhdy);
        return ResultUtil.success("修改成功");
    }
}
