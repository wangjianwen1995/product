package com.sxdl.hp.controller;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpTracerBorrow;
import com.sxdl.hp.service.HpTracerBorrowLogService;
import com.sxdl.hp.service.HpTracerBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

//示踪_借阅
@RestController
@RequestMapping("/tracer/jy")
public class HpTracerBorrowController {

    @Autowired
    HpTracerBorrowService hpTracerBorrowService;
    @Autowired
    HpTracerBorrowLogService hpTracerBorrowLogService;
    @Autowired
    SysDictValService sysDictValService;

    //查询所有科室
    @GetMapping("findAllKs")
    public ResultUtil findAllKs() throws Exception {
        return ResultUtil.success(hpTracerBorrowService.findAllKs());
    }

    //查询在档的列表
    @GetMapping("findOn")
    public ResultUtil findOn(PageInfo p, String start, String end, String ks, String ys, String bah, String txm, String bxm) throws Exception {
        p = hpTracerBorrowService.findOn(p, start, end, ks, ys, bah, txm, bxm);
        return ResultUtil.success(p);
    }

    //借阅用途
    @GetMapping("findJyyt")
    public ResultUtil findJyyt() throws Exception {
        return ResultUtil.success(sysDictValService.findDictValsByTableId(135));
    }

    //人员职级
    @GetMapping("findRyzj")
    public ResultUtil findRyzj() throws Exception {
        return ResultUtil.success(sysDictValService.findDictValsByTableId(136));
    }

    //借阅保存
    @PostMapping("saveAll")
    public ResultUtil saveAll(@RequestBody ArrayList<HpTracerBorrow> tracerBorrows) throws Exception {
        if (CollUtil.isEmpty(tracerBorrows)) {
            return ResultUtil.error("参数不能为空");
        }
        hpTracerBorrowService.saveAll(tracerBorrows);
        return ResultUtil.success("保存成功");
    }

    //查询待归还列表
    @GetMapping("findBack")
    public ResultUtil findBack(PageInfo p, String start, String end, String borrowerKs, String borrowerId, String borrowerTitleLevel, String bah, String txm, String bxm) throws Exception {
        PageInfo<HpTracerBorrow> pageInfo = hpTracerBorrowService.findBack(p, start, end, borrowerKs, borrowerId, borrowerTitleLevel, bah, txm, bxm);
        return ResultUtil.success(pageInfo);
    }

    //归还保存
    @PostMapping("saveAllBack")
    public ResultUtil saveAllBack(@RequestBody ArrayList<HpTracerBorrow> tracerBorrows) throws Exception {
        if (CollUtil.isEmpty(tracerBorrows)) {
            return ResultUtil.error("参数不能为空");
        }
        hpTracerBorrowService.saveAllBack(tracerBorrows);
        return ResultUtil.success("保存成功");
    }

    //挂失保存
    @PostMapping("saveAllLost")
    public ResultUtil saveAllLost(@RequestBody ArrayList<HpTracerBorrow> tracerBorrows) throws Exception {
        if (CollUtil.isEmpty(tracerBorrows)) {
            return ResultUtil.error("参数不能为空");
        }
        hpTracerBorrowService.saveAllLost(tracerBorrows);
        return ResultUtil.success("保存成功");
    }

    //查询挂失列表
    @GetMapping("findLost")
    public ResultUtil findLost(PageInfo p, String start, String end, String borrowerKs, String borrowerId, String borrowerTitleLevel, String bah, String txm, String bxm) throws Exception {
        PageInfo<HpTracerBorrow> pageInfo = hpTracerBorrowService.findLost(p, start, end, borrowerKs, borrowerId, borrowerTitleLevel, bah, txm, bxm);
        return ResultUtil.success(pageInfo);
    }

    //归还保存
    @PostMapping("saveAllLookingForBack")
    public ResultUtil saveAllLookingForBack(@RequestBody ArrayList<HpTracerBorrow> tracerBorrows) throws Exception {
        if (CollUtil.isEmpty(tracerBorrows)) {
            return ResultUtil.error("参数不能为空");
        }
        hpTracerBorrowService.saveAllLookingForBack(tracerBorrows);
        return ResultUtil.success("保存成功");
    }

    //查询借阅记录列表
    @GetMapping("findHistory")
    public ResultUtil findHistory(PageInfo p, String startBor, String endBor, String startCy, String endCy, String ksBor, String bks, String bah, String txm, String bxm, String status,String xm) throws Exception {
        return hpTracerBorrowService.findHistory(p, startBor, endBor, startCy, endCy, ksBor, bks, bah, txm, bxm, status,xm);
    }

    //查询催还借阅病案列表
    @GetMapping("findUrgeToReturn")
    public ResultUtil findUrgeToReturn(String startBor, String endBor, String startCy, String endCy, String ksBor, String bks) throws Exception {
        return hpTracerBorrowService.findUrgeToReturn(startBor, endBor, startCy, endCy, ksBor, bks);
    }

    //导出催还单
    @GetMapping("downUrgeToReturn")
    public void downUrgeToReturn(String startBor, String endBor, String startCy, String endCy, String ksBor, String bks, HttpServletResponse response) throws Exception {
        hpTracerBorrowService.downUrgeToReturn(startBor, endBor, startCy, endCy, ksBor, bks, response);
    }

    //查询借阅统计报表
    @GetMapping("findReport")
    public ResultUtil findReport(String startBor, String endBor, String startCy, String endCy, String ksBor, String bks) throws Exception {
        return hpTracerBorrowService.findReport(startBor, endBor, startCy, endCy, ksBor, bks);
    }

    //导出借阅统计报表
    @GetMapping("downReport")
    public void downReport(String startBor, String endBor, String startCy, String endCy, String ksBor, String bks, HttpServletResponse response) throws Exception {
        hpTracerBorrowService.downReport(startBor, endBor, startCy, endCy, ksBor, bks, response);
    }
}
