package com.sxdl.product.dc.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.DcKnowledge;
import com.sxdl.product.dc.entity.DcOverallQualityControl;
import com.sxdl.product.dc.service.DcDataQualityControlService;
import com.sxdl.product.dc.service.DcOverallQualityControlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "整体质控")
@RestController
@RequestMapping("/overallQc")
public class DcOverallQualityControlController {

    @Autowired
    private DcDataQualityControlService dcDataQualityControlService;

    @Autowired
    private DcOverallQualityControlService dcOverallQualityControlService;


    @ApiOperation(value = "根据表名查询", notes = "根据表名查询")
    @GetMapping("/findByTable")
    public ResultUtil findByTable(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String id) {
        try {
            DcOverallQualityControl entity = new DcOverallQualityControl();
            entity.setTable_id(id);
            pageInfo = dcOverallQualityControlService.queryPageList(pageInfo, entity);
            return ResultUtil.success(pageInfo);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }


    @ApiOperation(value = "删除", notes = "删除指标信息")
    @DeleteMapping("/delete")
    public ResultUtil<DcKnowledge> delete(@RequestBody String id) {
        try {
            dcOverallQualityControlService.deleteById(id);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "新增修改", notes = "新增修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil insertOrUpdate(@RequestBody DcOverallQualityControl doqc) {
        try {
            String msg="";
            if(!"".equals(doqc.getId()) && null!=doqc.getId()){
                dcOverallQualityControlService.update(doqc);
                msg="修改成功";
            }else{
                dcOverallQualityControlService.insert(doqc);
                msg="添加成功";
            }
            return ResultUtil.success(msg);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }







}
