package com.sxdl.fm.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.fm.entity.FmTargetItem;
import com.sxdl.fm.entity.HbiWlfks;
import com.sxdl.fm.service.FmTargetItemService;
import com.sxdl.fm.service.FmTargetService;
import com.sxdl.fm.service.HbiWlfksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "指标数据项管理")
@RestController
@RequestMapping("/targetItem")
public class FmTargetItemController {

    @Autowired
    FmTargetService fmTargetService;

    @Autowired
    FmTargetItemService fmTargetItemService;

    @Autowired
    HbiWlfksService hbiWlfksService;

    @ApiOperation(value = "查询所有", notes = "根据ID查询某指标下的所有数据项")
    @GetMapping("/findByTargetID")
    public ResultUtil<PageInfo<FmTargetItem>> findAll(PageInfo pageInfo, Integer targetID) {
        try {
            FmTargetItem item = new FmTargetItem();
            item.setTarget_id(targetID);
            PageInfo<FmTargetItem> list =fmTargetItemService.queryPageList(pageInfo,item);
            return ResultUtil.success ( list );
        }catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }

    }

    @ApiOperation(value = "查询启用", notes = "根据ID查询某指标下的所有启用数据项")
    @GetMapping("/findByTargetIDqy")
    public ResultUtil<List<FmTargetItem>> findAllqy(Integer targetID) {
        try {
            FmTargetItem item = new FmTargetItem();
            item.setTarget_id(targetID);
            item.setStatus("1");
            List<FmTargetItem> list = fmTargetItemService.select(item);
            return ResultUtil.success ( list );
        }catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }

    }

    @ApiOperation(value = "查询科室", notes = "查询科室")
    @GetMapping("/findKs")
    public ResultUtil<List<HbiWlfks>> findKs() {
        try {
            List<HbiWlfks> list = hbiWlfksService.findAll();
            return ResultUtil.success ( list );
        }catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }

    }


    @ApiOperation(value = "保存修改", notes = "保存数据项信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody FmTargetItem item) {
        if (item == null) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            Integer id=item.getId();
            if("".equals(id) || null==id){
                fmTargetItemService.insert(item);
            }else{
                fmTargetItemService.update(item);
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
            fmTargetItemService.deleteById(id);
            return ResultUtil.success("删除成功");
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }

    }
}
