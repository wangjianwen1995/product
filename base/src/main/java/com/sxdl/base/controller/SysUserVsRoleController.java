package com.sxdl.base.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysUserVsRole;
import com.sxdl.base.service.SysUserVsRoleService;
import com.sxdl.base.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户角色管理")
@RestController
@RequestMapping("/sysUserVsRole")
public class SysUserVsRoleController {

    @Autowired
    private SysUserVsRoleService sysUserVsRoleService;

    @ApiOperation(value = "根据用户角色id获取用户角色内容", notes = "根据用户角色id获取用户角色内容")
    @GetMapping("/findBySysUserVsRoleId")
    @ResponseBody
    public ResultUtil findBySysUserVsRoleId(PageInfo pageInfo, @RequestParam(value = "id",required = true) Integer id) {

        SysUserVsRole sysUserVsRole = new SysUserVsRole();
        sysUserVsRole.setId ( id );

        try {
            PageInfo<List<SysUserVsRole>> list = sysUserVsRoleService.queryPageList(pageInfo,sysUserVsRole);
            return ResultUtil.success (list);
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存用户角色信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysUserVsRole sysUserVsRole ) {
        SysUserVsRole sysUserVsRole1 = new SysUserVsRole ();
        sysUserVsRole1.setUser_id ( sysUserVsRole.getUser_id () );
        sysUserVsRole1.setRole_id ( sysUserVsRole.getRole_id () );
        try {
            SysUserVsRole sysUserVsRole2 = sysUserVsRoleService.selectOne ( sysUserVsRole1 );
            if (sysUserVsRole2 != null) {
                return ResultUtil.error ( "该用户已存在当前角色权限" );
            }
            sysUserVsRoleService.insertSysUserVsRole ( sysUserVsRole );
            return ResultUtil.success ( "操作成功" );
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }

    }


    @ApiOperation(value="删除用户角色",notes="删除用户角色")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestBody SysUserVsRole sysUserVsRole ){
        try{
            SysUserVsRole sysUserVsRole1 = sysUserVsRoleService.selectOne ( sysUserVsRole );
            if(sysUserVsRole1==null){
                return ResultUtil.error("该用户没有此角色权限");
            }
            sysUserVsRoleService.delete(sysUserVsRole1);
            return ResultUtil.success("删除成功");
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
    }
}
