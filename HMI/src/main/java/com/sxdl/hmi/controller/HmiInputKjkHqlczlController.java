package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputKjkHqlczlEntity;
import com.sxdl.hmi.service.HmiInputKjkHqlczlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "获取临床专利")
@RestController
@RequestMapping("/inputKjkHqlczl")
public class HmiInputKjkHqlczlController {

    @Autowired
    private HmiInputKjkHqlczlService hmiInputKjkHqlczlService;




    @ApiOperation(value = "查询所有信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputKjkHqlczlEntity entity = new HmiInputKjkHqlczlEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputKjkHqlczlEntity> hmiKfk  = hmiInputKjkHqlczlService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiKfk);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputKjkHqlczlEntity hmiKfk ) {
        try {
            if(StringUtil.isEmpty(hmiKfk.getId())){
                hmiInputKjkHqlczlService.insert(hmiKfk);
            }else{
                hmiInputKjkHqlczlService.update(hmiKfk);
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
            hmiInputKjkHqlczlService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
