package com.sxdl.fm.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.fm.entity.FmTarget;
import com.sxdl.fm.service.FmTargetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "指标管理")
@RestController
@RequestMapping("/target")
public class FmTargetController {

    @Autowired
    FmTargetService fmTargetService;

    @ApiOperation(value = "查询", notes = "查询所有三级指标")
    @GetMapping("/findAll")
    public ResultUtil<PageInfo<FmTarget>> findAll(PageInfo pageInfo, String name) {
        try {
            FmTarget target = new FmTarget();
            target.setName(name);
            PageInfo<FmTarget> list =fmTargetService.queryPageList(pageInfo,target);
            return ResultUtil.success ( list );
        }catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }

    }

    @ApiOperation(value = "查询启用", notes = "查询所有启用的三级指标")
    @GetMapping("/findAllqy")
    public ResultUtil<List<FmTarget>> findAllqy() {
        try {
            FmTarget target = new FmTarget();
            target.setStatus("1");
            target.setSource("1");
            List<FmTarget> list = fmTargetService.select(target);
            return ResultUtil.success ( list );
        }catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }

    }


    @ApiOperation(value = "保存修改", notes = "保存指标信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody FmTarget target) {
        if (target == null) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            Integer id=target.getId();
            if("".equals(id) || null==id){
                fmTargetService.insert(target);
            }else{
                fmTargetService.update(target);
                return ResultUtil.success ( "修改成功！" );
            }
            return  ResultUtil.success("保存成功");
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }

    @ApiOperation(value="删除指标",notes="删除指标")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestParam(value = "id",required = true) Integer id ){
        try{
            fmTargetService.deleteById(id);
            return ResultUtil.success("删除成功");
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }

    }
}
