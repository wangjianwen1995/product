package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputCwkEntity;
import com.sxdl.hmi.service.HmiInputCwkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "财务科信息录入")
@RestController
@RequestMapping("/inputCwk")
public class HmiInputCwkController {

    @Autowired
    private HmiInputCwkService hmiInputCwkService;




    @ApiOperation(value = "查询所有信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputCwkEntity entity = new HmiInputCwkEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputCwkEntity> hmiKfk  = hmiInputCwkService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiKfk);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputCwkEntity hmiKfk ) {
        try {
            if(StringUtil.isEmpty(hmiKfk.getId())){
                hmiInputCwkService.insert(hmiKfk);
            }else{
                hmiInputCwkService.update(hmiKfk);
            }

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/delById")
    public ResultUtil delColumnById(@RequestParam(value = "id",required = true) String id ) {
        try {
            hmiInputCwkService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
