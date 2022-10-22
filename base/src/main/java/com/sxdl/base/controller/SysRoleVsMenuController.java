package com.sxdl.base.controller;


import com.sxdl.base.entity.SysRoleVsMenu;
import com.sxdl.base.service.SysRoleVsMenuService;
import com.sxdl.base.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "角色菜单管理")
@RestController
@RequestMapping("/sysRoleVsMenu")
public class SysRoleVsMenuController {

    @Autowired
    private SysRoleVsMenuService sysRoleVsMenuService;

    @ApiOperation(value = "根据角色菜单id获取角色菜单内容", notes = "根据角色菜单id获取角色菜单内容")
    @GetMapping("/findBySysRoleVsMenuId")
    @ResponseBody
    public ResultUtil findBySysRoleVsMenuId(@RequestParam(value = "id", required = true) Integer rid) {
        try {
            List<SysRoleVsMenu> list = sysRoleVsMenuService.findByRoleId ( rid );
            return ResultUtil.success ( list );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    /*@ApiOperation(value = "保存修改", notes = "保存角色菜单信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody  List<SysRoleVsMenu> postDate) {
        try {
            System.out.println (postDate
            );
            //List<SysRoleVsMenu> roleVsMenus = map.values ().stream ().collect ( Collectors.toList () ).get ( 0 );
            if(postDate==null||postDate.size ()<=0){
                return ResultUtil.error ( "没有数据要保存" );
            }
            //List<SysRoleVsMenu> oldRoleVsMenus = sysRoleVsMenuService.findByRoleId ( roleVsMenus.get ( 0 ).getRole_id () );
            sysRoleVsMenuService.insertOrUpdate ( postDate );

            return ResultUtil.success ( "操作成功" );
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }
*/
    @ApiOperation(value = "保存修改", notes = "保存角色菜单信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody Map<String,List<SysRoleVsMenu>> map) {
        try {
            //System.out.println (map);
            List<SysRoleVsMenu> roleVsMenus = (List<SysRoleVsMenu>) map.values ().stream ().collect ( Collectors.toList () ).get ( 0 );
            if (roleVsMenus == null || roleVsMenus.size () <= 0) {
                return ResultUtil.error ( "没有数据要保存" );
            }
            //List<SysRoleVsMenu> oldRoleVsMenus = sysRoleVsMenuService.findByRoleId ( roleVsMenus.get ( 0 ).getRole_id () );
            sysRoleVsMenuService.insertOrUpdate ( roleVsMenus );

            return ResultUtil.success ( "操作成功" );
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }
    @ApiOperation(value = "根据角色菜单id获取角色菜单内容", notes = "根据角色id获取角色菜单内容")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtil findById(@RequestParam(value = "id", required = true) Integer id) {
        try {
            SysRoleVsMenu roleVsMenu = sysRoleVsMenuService.findById ( id );
            return ResultUtil.success ( roleVsMenu );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

}
