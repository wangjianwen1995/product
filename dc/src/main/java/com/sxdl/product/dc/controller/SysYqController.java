package com.sxdl.product.dc.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.SysKs;
import com.sxdl.product.dc.entity.SysYq;
import com.sxdl.product.dc.service.SysKsService;
import com.sxdl.product.dc.service.SysYqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "医院院区管理")
@RestController
@RequestMapping("/sysYq")
public class SysYqController {

    @Autowired
    private SysYqService sysYqService;
    @Autowired
    private SysKsService sysKsService;

    @ApiOperation(value = "根据院区id获取院区内容", notes = "根据院区id获取院区内容")
    @GetMapping("/findAll")
    public ResultUtil findAll() {
        try {
            return ResultUtil.success(sysYqService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("查询错误!");
        }
    }

    @ApiOperation(value = "根据院区id获取院区内容", notes = "根据院区id获取院区内容")
    @GetMapping("/findBySysYqId")
    @ResponseBody
    public ResultUtil findBySysYqId(Integer id) {

        try {
            if (id != null && !id.equals("") && id > 0) {
                SysYq sysYq = sysYqService.findById(id);
                return ResultUtil.success(sysYq);
            }
            List<SysYq> list = sysYqService.findAll();
            return ResultUtil.success(list);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存院区信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysYq sysYq) {
        if (sysYq == null) {
            return ResultUtil.error("没有数据要保存");
        }
        try {
            Integer id = sysYq.getId();
            if ("".equals(id) || null == id) {
                sysYqService.insert(sysYq);
            } else {
                sysYqService.update(sysYq);
            }
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("保存失败");
        }
    }


    @ApiOperation(value = "删除院区", notes = "删除院区")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestBody SysYq sysYq) {
        try {
            List<SysYq> sysYqs = sysYqService.select(sysYq);
            if (sysYqs == null && sysYqs.size() <= 0) {
                return ResultUtil.error("该院区不存在");
            }
            SysKs sysKs = new SysKs();
            sysKs.setStandard_ks_id(sysYq.getCode());
            List<SysKs> ksList = sysKsService.select(sysKs);
            if (ksList != null && ksList.size() > 0) {
                return ResultUtil.error("该院区信息下有绑定科室，删除失败");
            }
            sysYqService.deleteById(sysYq.getId());
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }

    }


}
