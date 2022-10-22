package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputKjkLcjszhEntity;
import com.sxdl.hmi.service.HmiInputKjkLcjszhService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "临床技术转化专利")
@RestController
@RequestMapping("/inputKjkLcjszh")
public class HmiInputKjkLcjszhController {

    @Autowired
    private HmiInputKjkLcjszhService hmiInputKjkLcjszhService;




    @ApiOperation(value = "查询所有信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputKjkLcjszhEntity entity = new HmiInputKjkLcjszhEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputKjkLcjszhEntity> hmiKfk  = hmiInputKjkLcjszhService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiKfk);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputKjkLcjszhEntity hmiKfk ) {
        try {
            if(StringUtil.isEmpty(hmiKfk.getId())){
                hmiInputKjkLcjszhService.insert(hmiKfk);
            }else{
                hmiInputKjkLcjszhService.update(hmiKfk);
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
            hmiInputKjkLcjszhService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
