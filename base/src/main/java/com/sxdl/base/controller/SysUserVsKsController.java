package com.sxdl.base.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.entity.SysUserVsKs;
import com.sxdl.base.entity.SysUserVsRole;
import com.sxdl.base.service.SysUserService;
import com.sxdl.base.service.SysUserVsKsService;
import com.sxdl.base.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户科室管理")
@RestController
@RequestMapping("/sysUserVsKs")
public class SysUserVsKsController {

    @Autowired
    private SysUserVsKsService sysUserVsKsService;
    @Autowired
    private SysUserService sysUserService;
    //假设拿到的是科室code

    @ApiOperation(value = "根据用户科室id获取用户角色内容", notes = "根据用户科室id获取用户角色内容")
    @GetMapping("/findBySysUserVsKsId")
    @ResponseBody
    public ResultUtil findBySysUserVsKsId(PageInfo pageInfo, @RequestParam(value = "id", required = true) Integer id) {

        SysUserVsKs sysUserVsKs = new SysUserVsKs ();
        sysUserVsKs.setId ( id );

        try {
            PageInfo<List<SysUserVsRole>> list = sysUserVsKsService.queryPageList ( pageInfo, sysUserVsKs );
            return ResultUtil.success ( list );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

   /* @ApiOperation(value = "保存修改", notes = "保存用户科室信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysUser sysUser) {
        SysUser sysUser1 = sysUserService.selectOne ( sysUser );
        if (sysUser1 == null) {
            return ResultUtil.error ( "没有用户数据要保存" );
        }
        List<SysUserVsKs> sysUserVsKss = sysUser.getKss ();
        if (sysUserVsKss == null) {
            return ResultUtil.error ( "没有用户科室数据要保存" );
        }
        SysUserVsKs sysUserVsKs1 = new SysUserVsKs ();
        sysUserVsKs1.setUser_id ( sysUser.getId () );
        sysUserVsKs1.setUser_name ( sysUser.getName () );
        try {
            for (SysUserVsKs sysUserVsKs : sysUserVsKss) {

                sysUserVsKs1.setKs_id ( sysUserVsKs.getKs_id () );
                SysUserVsKs userVsKs = sysUserVsKsService.selectOne ( sysUserVsKs1 );
                if (userVsKs != null) {
                     sysUserVsKsService.update ( userVsKs );
                }else{
                    sysUserVsKs.setUser_id ( sysUser1.getId () );
                    sysUserVsKs.setUser_name ( sysUser1.getName () );
                    sysUserVsKsService.insertSysUserVsKs ( sysUserVsKs );
                }
            }
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
        return ResultUtil.success ( "操作成功" );
    }*/

   @ApiOperation(value = "保存", notes = "保存用户科室信息")
   @PostMapping("/save")
   @ResponseBody
   public ResultUtil insert(@RequestBody SysUser sysUser) {
       List<SysUserVsKs> sysUserVsKss = sysUser.getKss ();
       if (sysUserVsKss == null) {
           return ResultUtil.error ( "没有用户科室数据要保存" );
       }
       try {
           sysUserVsKsService.insertSysUserVsKs1 ( sysUser );
       } catch (Exception e) {
           return ResultUtil.error ( "保存失败" );
       }
       return ResultUtil.success ( "操作成功" );
   }


    @ApiOperation(value = "删除用户科室", notes = "删除用户科室")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestBody SysUserVsKs sysUserVsKs) {
        try {
            SysUserVsKs sysUserVsKs1 = sysUserVsKsService.selectOne ( sysUserVsKs );
            if (sysUserVsKs1 == null) {
                return ResultUtil.error ( "该用户没有此科室权限" );
            }
            sysUserVsKsService.delete ( sysUserVsKs1 );
            return ResultUtil.success ( "删除成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }

    }
}
