package com.sxdl.cf.controller;


import com.sxdl.cf.dao.dao1.SysRoleDao2;
import com.sxdl.cf.dao.dao1.SysUserDao2;
import com.sxdl.cf.entity.SysRole;
import com.sxdl.cf.entity.SysUser;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "角色|用户管理")
@RestController("sysRole")
@RequestMapping("/dev/sysRole")
@RequiredArgsConstructor
public class SysRoleController {

    private   final SysRoleDao2 sysRoleDao;
    private   final SysUserDao2 sysUserDao;


    @ApiOperation(value = "根据角色id获取角色内容", notes = "根据角色id获取角色内容")
    @GetMapping("/findAllRoles")
    public ResultUtil findAllRoles(@RequestParam(value = "name",required = false) String name) {

        List<SysRole> sysRoles = null;
        try {
            if(StringUtils.isEmpty(name)){
                sysRoles = sysRoleDao.selectAll ();
            }else {
                SysRole sysRole = new SysRole().setName(name);
                sysRoles = sysRoleDao.select (sysRole);
            }
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success ( sysRoles );
    }


    @ApiOperation(value = "查询所有用户模糊匹配name" )
    @GetMapping("/findAllUser")
    public ResultUtil findAllUser(@RequestParam(value = "name",required = false) String name) {

        List<SysUser> sysUsers = null;
        try {
            sysUsers = sysUserDao.selectAll ();
            if(!StringUtils.isEmpty(name)){
                sysUsers = sysUsers.stream().filter(e-> !StringUtils.isEmpty(e.getLogin_name())&& !StringUtils.isEmpty(e.getName()) && (e.getLogin_name().equals(name) || e.getName().contains(name)))
                        .collect(Collectors.toList());
            }


        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success ( sysUsers );
    }






}
