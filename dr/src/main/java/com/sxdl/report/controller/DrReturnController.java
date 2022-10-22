package com.sxdl.report.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.report.entity.DrReturn;
import com.sxdl.report.service.impl.DrReturnServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "平台返回信息表")
@RestController
@RequestMapping("/drReturn")
public class DrReturnController {

    @Autowired
    private DrReturnServiceImpl returnService;

    @ApiOperation(value = "查询", notes = "查询所有返回信息")
    @GetMapping("/findAll")
    public ResultUtil findAll(PageInfo pageInfo, @RequestParam(value = "name",defaultValue = "",required = false) String name) {
        try {
           // DrReturn drReturn = new DrReturn();
          //  PageInfo<DrReturn> list = returnService.queryPageListDesc(pageInfo,drReturn);
            List<DrReturn> list = returnService.findAllDesc();
            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(),pageInfo.getPageSize(), list);
            return ResultUtil.success ( listPage );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "根据条件查询", notes = "根据条件查询")
    @GetMapping("/findByCondition")
    public ResultUtil findByCondition(PageInfo pageInfo, Integer batchId,Integer tempID) {
        try {
            return ResultUtil.success ("暂时停用此功能");
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }




}
