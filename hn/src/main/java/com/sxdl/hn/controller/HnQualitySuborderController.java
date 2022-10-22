package com.sxdl.hn.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.entity.HnQualityCategory;
import com.sxdl.hn.entity.HnQualitySuborder;
import com.sxdl.hn.service.HnQualitySuborderService;
import com.sxdl.hn.util.HNApplicationRunnerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "护理质量考核亚目")
@RestController
@RequestMapping("/suborder")
public class HnQualitySuborderController {


    @Autowired
    private HnQualitySuborderService suborderService;

    @Autowired
    private   HNApplicationRunnerImpl runner;


    @ApiOperation(value = "缓存中获取类目亚目关系下拉框")
    @GetMapping("/findCategorySuborder")
    public ResultUtil findCategorySuborder() {
        List<HnQualityCategory> lmym = new ArrayList<>();
        try {
            lmym = HNApplicationRunnerImpl.getLmYm();
        }catch (Exception e){
           return ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(lmym);
    }


    @ApiOperation(value = "缓存中获取类目下的亚目")
    @GetMapping("/findSuborderByCategoryid")
    public ResultUtil findSuborderByCategoryid(@RequestParam(value = "pid",required = true) Integer pid) {
        List<HnQualitySuborder> suborders = new ArrayList<>();
        try {
            List<HnQualityCategory> lmYm = HNApplicationRunnerImpl.getLmYm();
            for (HnQualityCategory hnQualityCategory : lmYm) {
                if(pid.equals(hnQualityCategory.getId())){
                    suborders = hnQualityCategory.getSuborders();
                }
            }
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(suborders);
    }


    @ApiOperation(value = "新增 修改亚目数据 更新缓存")
    @PostMapping("/updateSuborderCache")
    public ResultUtil updateSuborderCache(@RequestBody HnQualitySuborder suborder){
        try {
            //修改数据，并且处理缓存中的数据 放到 事物中c处理数据
            if(StringUtils.isEmpty(suborder.getId())){
                Integer integer = suborderService.insert(suborder);
            }else {
                Integer integer = suborderService.update(suborder);
            }
            runner.setLmYm();
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "删除亚目数据 更新缓存")
    @GetMapping("/delSuborderCache")
    public ResultUtil delSuborderCache(@RequestParam(value = "id",required = true) Integer id){

        try {
            //修改数据，并且处理缓存中的数据 放到 事物中c处理数据
            boolean b = suborderService.delSuborder(id);
            if(!b){
                return ResultUtil.error("删除失败，改亚目下有子集细目不能删除");
            }
            runner.setLmYm();
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }




}
