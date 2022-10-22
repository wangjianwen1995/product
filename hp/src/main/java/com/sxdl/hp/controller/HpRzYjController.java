package com.sxdl.hp.controller;

import cn.hutool.core.util.StrUtil;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpRzYj;
import com.sxdl.hp.service.HpRzYjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

//医技日志
@RestController
@RequestMapping("/rzyj")
public class HpRzYjController {
    @Autowired
    HpRzYjService hpRzYjService;
    @Autowired
    SysDictValService sysDictValService;

    /**
     * 查询列表
     *
     * @param ksid  科室id
     * @param xmid  科室项目id
     * @param start 开始时间
     */
    @GetMapping("/findlist")
    public ResultUtil findList(String ksid, String xmid, String start) throws Exception {
        return ResultUtil.success(hpRzYjService.findlist(ksid, xmid, start));
    }

    /**
     * 查询报表
     *
     * @param ksid  科室id
     * @param xmid  科室所属项目的id
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    @GetMapping("/find")
    public ResultUtil find(String ksid, String xmid, String start, String end) throws Exception {
        return ResultUtil.success(hpRzYjService.selectYJRZNew(ksid, xmid, start, end));
    }

    /**
     * 查询科室相关项目字典
     */
    @GetMapping("/yjksxm")
    public ResultUtil findWZQJYY(Integer ison, String ksid) throws Exception {
        return ResultUtil.success(hpRzYjService.getYJKSXMDict(ison, ksid));
    }

    /**
     * 查询医技科室列表
     */
    @GetMapping("/yjks")
    public ResultUtil findJZKS() throws Exception {
        return ResultUtil.success(hpRzYjService.getYJKSDict());
    }

    /**
     * 更新字典
     */
    @GetMapping("/updateRzDict")
    public ResultUtil update(SysDictVal val) throws Exception {
        if (null == val.getId()) {
            sysDictValService.insertDV(val);
        } else {
            sysDictValService.updateByPrimaryKeySelective(val);
        }
        return ResultUtil.success("保存成功!");
    }

    /**
     * 批量保存修改
     */
    @PostMapping("saveAll")
    public ResultUtil insertOrUpdateAll(@RequestBody List<HpRzYj> list, String time) {
        return hpRzYjService.saveall(list, time);
    }

    /**
     * 修改或删除医技日志信息
     */
    @PostMapping("/merge")
    public ResultUtil insert(@RequestBody HpRzYj hpRzYj) throws Exception {
        if (StrUtil.isEmpty(hpRzYj.getId())) {
            hpRzYjService.insert(hpRzYj);
        } else {
            hpRzYjService.update(hpRzYj);
        }
        return ResultUtil.success("保存成功!");
    }

    /**
     * 删除数据
     */
    @GetMapping("/del")
    public ResultUtil delete(String id) throws Exception {
        hpRzYjService.deleteById(id);
        return ResultUtil.success("删除成功!");
    }

    /**
     * 下载报表
     */
    @GetMapping("down")
    public void down(String ksid, String xmid, String start, String end, HttpServletResponse response) throws Exception {
        hpRzYjService.down(ksid, xmid, start, end, response);
    }
}
