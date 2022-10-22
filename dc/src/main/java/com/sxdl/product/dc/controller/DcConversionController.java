package com.sxdl.product.dc.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.DcConversion;
import com.sxdl.product.dc.service.DcConversionService;
import com.sxdl.product.dc.service.DcEtlLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = ("行列转换"))
@RestController
@RequestMapping("/conversion")
public class DcConversionController {
    @Autowired
    private DcEtlLogService dcEtlLogService;

    @Autowired
    private DcConversionService dcConversionService;


    @ApiOperation(value = "回显转换配置", notes = "回显转换配置")
    @GetMapping("/findByTableId")
    public ResultUtil findByAll(@RequestParam(value = "table_id", defaultValue = "") String table_id) {
        try {
            DcConversion dcConversion=new DcConversion();
            dcConversion.setFrom_table_id(table_id);
            List<DcConversion> conversionList = dcConversionService.select(dcConversion);
            return ResultUtil.success(conversionList, "查询成功");

        } catch (Exception e) {
            return ResultUtil.error("查询失败"+e.getCause());
        }
    }

    @ApiOperation(value = "新增修改", notes = "新增修改行列转换配置")
    @PutMapping("/insertOrUpdate")
    public ResultUtil insertOrUpdate(@RequestBody DcConversion dcConversion) {
        try {
            dcConversionService.insertOrUpdate(dcConversion);
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("操作失败"+e.getCause());
        }
    }

    @ApiOperation(value = "置空行列转换配置", notes = "置空行列转换配置")
    @PutMapping("/delete")
    public ResultUtil delete(@RequestParam(value = "table_id", defaultValue = "") String table_id) {
        try {
            ResultUtil resultUtil = dcConversionService.deleteByDcConversion(table_id);
            return resultUtil;
        } catch (Exception e) {
            return ResultUtil.error("操作失败"+e.getCause());
        }
    }

}
