package com.sxdl.hn.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.entity.HnQualityCategory;
import com.sxdl.hn.service.HnQualityCategoryService;
import com.sxdl.hn.util.HNApplicationRunnerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "护理质量考核类目")
@RestController
@RequestMapping("/hnCategory")
public class HnQualityCategoryController {


    @Autowired
    private HnQualityCategoryService categoryService;

    @Autowired
    private HNApplicationRunnerImpl runner;

    @ApiOperation(value = "查询全部类目")
    @GetMapping("/findAllcategory")
    public ResultUtil findAllcategory() {
        List<HnQualityCategory> all =null;
        try {
            all = HNApplicationRunnerImpl.getLmYm();
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(all);
    }


    @ApiOperation(value = "添加修改类目")
    @PostMapping("/updatecategory")
    public ResultUtil updatecategory(@RequestBody HnQualityCategory category){
        try {
            if(StringUtils.isEmpty(category.getId())){
                Integer insert = categoryService.insert(category);
            }else{
                Integer update = categoryService.update(category);
            }
            //担心事务回滚查询有问题,放到外面
            runner.setLmYm();
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "删除类目")
    @GetMapping("/delcategory")
    public ResultUtil delcategory(@RequestParam(value =  "id" ,required = true) Integer id){
        try {
            boolean b = categoryService.deleteByidExistschil(id);
            if(!b){
               return  ResultUtil.error("该类目下有对应的子集亚目，不允许删除");
            }
            //担心事务回滚查询有问题,放到外面
            runner.setLmYm();
        }catch (Exception e){
            return  ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("操作成功");
    }









}
