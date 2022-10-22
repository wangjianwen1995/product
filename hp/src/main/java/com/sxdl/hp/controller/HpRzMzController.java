package com.sxdl.hp.controller;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpRzMz;
import com.sxdl.hp.service.HpRzMzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//门诊日志
@RestController
@RequestMapping("/rzmz")
public class HpRzMzController {
    @Autowired
    HpRzMzService hpRzMzService;
    @Autowired
    SysDictValService sysDictValService;

    /**
     * 查询列表
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     * @param p     分页信息
     * @return 结构
     */
    @GetMapping("/findlist")
    public ResultUtil findList(String ksid, String start, String end, PageInfo p) throws Exception {
        return ResultUtil.success(hpRzMzService.findlist(ksid, start, end, p));
    }

    /**
     * 查询报表
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    @GetMapping("/find")
    public ResultUtil find(String ksid, String start, String end) throws Exception {
        return ResultUtil.success(hpRzMzService.selectMZRZ(ksid, start, end));
    }

    /**
     * 查询门诊科室列表
     */
    @GetMapping("/mzks")
    public ResultUtil findMZKS() throws Exception {
        return ResultUtil.success(hpRzMzService.getMzKSDict());
    }

    /**
     * 更新字典
     *
     * @param val 字典信息
     * @return
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
     * 预处理批量保存或者修改
     */
    @GetMapping("/toMergeAll")
    public ResultUtil toInsertAll(String start) throws Exception {
        return hpRzMzService.toInsertAll(start);
    }

    /**
     * 批量修改保存
     */
    @PostMapping("/mergeAll")
    public ResultUtil insertAll(@RequestBody Map data) throws Exception {
        return hpRzMzService.insertAll((List<LinkedHashMap>) data.get("list"), data.get("start").toString());
    }

    /**
     * 修改或删除门诊日志信息
     *
     * @param hpRzMz 门诊日志信息
     * @return
     */
    @PostMapping("/merge")
    public ResultUtil insert(@RequestBody HpRzMz hpRzMz) throws Exception {
        if (StrUtil.isEmpty(hpRzMz.getId())) {
            hpRzMzService.insert(hpRzMz);
        } else {
            hpRzMzService.update(hpRzMz);
        }
        return ResultUtil.success("保存成功!");
    }

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @GetMapping("/del")
    public ResultUtil delete(String id) throws Exception {
        hpRzMzService.deleteById(id);
        return ResultUtil.success("删除成功!");
    }

    /**
     * 下载报表
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     */
    @GetMapping("down")
    public void down(String ksid, String start, String end, HttpServletResponse response) throws Exception {
        hpRzMzService.down(ksid, start, end, response);
    }
}
