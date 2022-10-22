package com.sxdl.base.controller;


import com.sxdl.base.entity.SysMenu;
import com.sxdl.base.entity.SysRole;
import com.sxdl.base.entity.SysUserVsRole;
import com.sxdl.base.service.SysMenuService;
import com.sxdl.base.service.SysRoleService;
import com.sxdl.base.service.SysUserVsRoleService;
import com.sxdl.base.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserVsRoleService sysUserVsRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "根据角色id获取角色内容", notes = "根据角色id获取角色内容")
    @GetMapping("/findAllRoles")
    @ResponseBody
    public ResultUtil findAllRoles(Integer roleId) {
        //System.out.println ("role"+roleId);
        try {
            if(roleId!=null && !"".equals ( roleId )&& roleId>0){
                SysRole role = sysRoleService.findById ( roleId );
                //System.out.println (role);
                return ResultUtil.success ( role );
            }
            List<SysRole> sysRoles = sysRoleService.findAll ();
            return ResultUtil.success ( sysRoles );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存角色信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysRole sysRole) {
        try {
            SysMenu sysMenu = sysMenuService.findById ( sysRole.getIndex_menu_id () );
            sysRole.setIndex_url ( sysMenu.getPath () );
            sysRoleService.insertOrUpdate ( sysRole);
            return ResultUtil.success ( "操作成功" );
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }


    @ApiOperation(value = "删除角色", notes = "删除角色")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestBody SysRole sysRole) {
        try {
            List<SysRole> sysRoles = sysRoleService.select ( sysRole );
            if (sysRoles == null || sysRoles.size () <= 0) {
                return ResultUtil.error ( "角色不存在" );
            }
            SysUserVsRole sysUserVsRole = new SysUserVsRole ();
            sysUserVsRole.setRole_id ( sysRole.getId () );
            List<SysUserVsRole> sysUserVsRoles = sysUserVsRoleService.select ( sysUserVsRole );
            if (sysUserVsRoles != null && sysUserVsRoles.size () > 0) {
                return ResultUtil.error ( "已有用户绑定此角色，不能删除" );
            }
            sysRoleService.deleteById ( sysRole.getId () );
            return ResultUtil.success ( "删除成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }
}
