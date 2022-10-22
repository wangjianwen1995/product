package com.sxdl.report.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.report.entity.DrProcdure;
import com.sxdl.report.service.DrProcdureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "上报存储管理")
@RestController
@RequestMapping("/procdure")
public class DrProcdureController {

    @Autowired
    private DrProcdureService drProcdureService;

    @ApiOperation(value = "查询", notes = "查询所有存储信息")
    @GetMapping("/findAll")
    public ResultUtil<PageInfo<DrProcdure>> findAll(PageInfo pageInfo, @RequestParam(value = "name",defaultValue = "",required = false) String name) {
        try {
            DrProcdure procdure = new DrProcdure();
            procdure.setName(name);
            PageInfo<DrProcdure> list =drProcdureService.queryPageList(pageInfo,procdure);
            return ResultUtil.success ( list );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "根据模板id查询存储", notes = "根据模板id查询存储")
    @GetMapping("/findByTempId")
    @ResponseBody
    public ResultUtil findByTempId(PageInfo pageInfo, @RequestParam(value = "id",required = true) Integer id) {

        DrProcdure procdure = new DrProcdure();
        procdure.setTemplate_id(id);


        try {
            PageInfo<List<DrProcdure>> list = drProcdureService.queryPageList(pageInfo,procdure);
            return ResultUtil.success (list);
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }






}
