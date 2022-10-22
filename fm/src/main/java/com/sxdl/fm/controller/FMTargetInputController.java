package com.sxdl.fm.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.fm.entity.FmTargetInput;
import com.sxdl.fm.service.FmTargetInputService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Api(tags = "指标录入")
@RestController
@RequestMapping("/targetInput")
public class FMTargetInputController {

    @Autowired
    FmTargetInputService fmTargetInputService;

    @ApiOperation(value = "查询", notes = "查询已录入的指标数据")
    @GetMapping("/findAll")
    public ResultUtil<PageInfo<FmTargetInput>> findAll(PageInfo pageInfo,String name) {
        try {
            FmTargetInput target = new FmTargetInput();
            target.setItem_name(name);
            PageInfo<FmTargetInput> list =fmTargetInputService.queryPageList(pageInfo,target);
            return ResultUtil.success ( list );
        }catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "保存修改", notes = "指标录入及修改信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody FmTargetInput targetInput, HttpServletRequest request) {
        if (targetInput == null) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            Integer id=targetInput.getId();
            if("".equals(id) || null==id){
                HttpSession session = request.getSession();
                SysUser user = (SysUser) session.getAttribute("user");
                targetInput.setInput_user_id(user.getId().toString());
                targetInput.setInput_user_name(user.getName());
                fmTargetInputService.insert(targetInput);
            }else{
                fmTargetInputService.update(targetInput);
                HttpSession session = request.getSession();
                SysUser user = (SysUser) session.getAttribute("user");
                targetInput.setInput_user_id(user.getId().toString());
                targetInput.setInput_user_name(user.getName());
                return ResultUtil.success ( "修改成功！" );
            }
            return  ResultUtil.success("保存成功");
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }



    @ApiOperation(value="删除",notes="删除录入数据")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestParam(value = "id",required = true) Integer id ){
        try{
            fmTargetInputService.deleteById(id);
            return ResultUtil.success("删除成功");
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }

    }





}
