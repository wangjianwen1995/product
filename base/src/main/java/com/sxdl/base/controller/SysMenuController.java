package com.sxdl.base.controller;


import cn.hutool.core.util.StrUtil;
import com.sxdl.base.entity.SysMenu;
import com.sxdl.base.entity.SysRoleVsMenu;
import com.sxdl.base.service.SysMenuService;
import com.sxdl.base.service.SysRoleVsMenuService;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.TreeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "菜单管理")
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleVsMenuService sysRoleVsMenuService;
    private List<SysMenu> menus, newMeus;

    @GetMapping("/indexShortcutMenus")
    public ResultUtil getIndexHbiMenu(String roles, String ischeck, String da) {
        try {
            SysMenu sm = new SysMenu();
            List<SysRoleVsMenu> roleVsMenus;
            sm.setHaschildren(false);
            List<SysMenu> menus = sysMenuService.select(sm);
            menus = menus.stream().filter(e -> !e.getTitle().equals("首页")).collect(Collectors.toList());
            List<SysMenu> newMeus = new ArrayList<>();
            List<Integer> collect;
            if (StringUtil.isNotEmpty(da)) {
                menus = menus.stream().filter(e -> e.getMenu_type().equals(4)).collect(Collectors.toList());
            }
            if (null == roles) {
                return ResultUtil.success(menus);
            } else if (roles.contains(",")) {//多个角色
                for (String s : roles.split(",")) {
                    roleVsMenus = sysRoleVsMenuService.findByRoleId(Integer.parseInt(s));
                    for (SysMenu m : menus) {
                        for (SysRoleVsMenu rm : roleVsMenus) {
                            if (m.getId().equals(rm.getMenu_id())) {
                                collect = newMeus.stream().map(SysMenu::getId).collect(Collectors.toList());
                                if (!collect.contains(m.getId())) {
                                    newMeus.add(m);
                                }
                            }
                        }
                    }
                }
            } else {//假设单个角色
                roleVsMenus = sysRoleVsMenuService.findByRoleId(Integer.parseInt(roles));
                for (SysMenu m : menus) {
                    for (SysRoleVsMenu rm : roleVsMenus) {
                        if (m.getId().equals(rm.getMenu_id())) {
                            collect = newMeus.stream().map(SysMenu::getId).collect(Collectors.toList());
                            if (!collect.contains(m.getId())) {
                                newMeus.add(m);
                            }
                        }
                    }
                }
            }
            if (StringUtil.isNotEmpty(ischeck)) {
                newMeus = newMeus.stream().filter(e -> StringUtil.isNotEmpty(e.getIscheck()) && e.getIscheck().equals(ischeck)).collect(Collectors.toList());
            }
            return ResultUtil.success(newMeus);
        } catch (Exception e) {
            return ResultUtil.success(e.getCause());
        }
    }

    @PostMapping("/indexUpdateShortcutMenus")
    public ResultUtil updateShortcutMenus(@RequestBody ArrayList<SysMenu> menuss) {
        try {
//            System.out.println(menuss);
            menuss.forEach(e -> {
                sysMenuService.update(e);
            });
            return ResultUtil.success("保存成功!");
        } catch (Exception e) {
            return ResultUtil.success(e.getCause());
        }
    }

    @ApiOperation(value = "根据菜单标题名称和路径模糊查询菜单", notes = "根据菜单标题名称和路径模糊查询菜单")
    @GetMapping("/findAllMenus")
    @ResponseBody
    public ResultUtil findAllMenus(String name) {
        try {
            List<SysMenu> tree = sysMenuService.findAllMenus(name);
            return ResultUtil.success(tree);
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }

    @ApiOperation(value = "获取首页菜单", notes = "获取首页菜单")
    @GetMapping("/findIndexMenu")
    @ResponseBody
    public ResultUtil findIndexMenu() {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setLevel(1);
        sysMenu.setTitle("首页");
        try {
            List<SysMenu> sysMenus = sysMenuService.select(sysMenu);
            return ResultUtil.success(sysMenus);
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }

    @ApiOperation(value = "获取报表菜单", notes = "获取报表菜单")
    @GetMapping("/findHBIMenu")
    @ResponseBody
    public ResultUtil findHBIMenu(String name) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenu_type(4);
        try {
            List<SysMenu> sysMenus = sysMenuService.select(sysMenu);
            if (StrUtil.isNotEmpty(name)) {
                sysMenus = sysMenus.stream().filter(e -> e != null && (e.getTitle().contains(name) || e.getName().contains(name) ||e.getCs().contains(name)|| e.getPath().contains(name))).collect(Collectors.toList());
                return ResultUtil.success(sysMenus);
            }
            List<SysMenu> tree = TreeUtils.tree(sysMenus, SysMenu::getId, SysMenu::getParent_code, SysMenu::getChildren, SysMenu::setChildren, null);
            return ResultUtil.success(tree);
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }

    @ApiOperation(value = "获取DC文件分类菜单", notes = "获取DC文件分类菜单")
    @GetMapping("/findFileMenu")
    @ResponseBody
    public ResultUtil findFileMenu(String name) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenu_type(8);
        try {
            List<SysMenu> sysMenus = sysMenuService.select(sysMenu);
            if (StrUtil.isNotEmpty(name)) {
                sysMenus = sysMenus.stream().filter(e -> e != null && (e.getTitle().contains(name) || e.getName().contains(name) ||e.getCs().contains(name)|| e.getPath().contains(name))).collect(Collectors.toList());
                return ResultUtil.success(sysMenus);
            }
            List<SysMenu> tree = TreeUtils.tree(sysMenus, SysMenu::getId, SysMenu::getParent_code, SysMenu::getChildren, SysMenu::setChildren, null);
            return ResultUtil.success(tree);
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }

    @ApiOperation(value = "获取DC文件分类下拉框", notes = "获取DC文件分类下拉框")
    @GetMapping("/findFileMenuSelect")
    @ResponseBody
    public ResultUtil findFileMenuSelect(String name) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenu_type(8);
        try {
            List<SysMenu> sysMenus = sysMenuService.select(sysMenu);
            if (StrUtil.isNotEmpty(name)) {
                sysMenus = sysMenus.stream().filter(e -> e != null && !e.getHaschildren() && (e.getTitle().contains(name) || e.getName().contains(name) ||e.getCs().contains(name)|| e.getPath().contains(name))).collect(Collectors.toList());
                return ResultUtil.success(sysMenus);
            }
            sysMenus = sysMenus.stream().filter(e -> e != null && !e.getHaschildren() ).collect(Collectors.toList());

            return ResultUtil.success(sysMenus);
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }


    @ApiOperation(value = "获取报表菜单", notes = "获取报表菜单")
    @GetMapping("/findCustomFormMenu")
    @ResponseBody
    public ResultUtil findCustomFormMenu(String name) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenu_type(9);
        try {
            List<SysMenu> sysMenus = sysMenuService.select(sysMenu);
            if (StrUtil.isNotEmpty(name)) {
                sysMenus = sysMenus.stream().filter(e -> e != null && (e.getTitle().contains(name) || e.getName().contains(name) ||e.getCs().contains(name)|| e.getPath().contains(name))).collect(Collectors.toList());
                return ResultUtil.success(sysMenus);
            }
            List<SysMenu> tree = TreeUtils.tree(sysMenus, SysMenu::getId, SysMenu::getParent_code, SysMenu::getChildren, SysMenu::setChildren, null);
            return ResultUtil.success(tree);
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }

    @ApiOperation(value = "根据角色id获取菜单内容", notes = "根据角色id获取菜单内容")
    @GetMapping("/findMenusByRole")
    @ResponseBody
    public ResultUtil findMenusByRole(String roles) {
        try {
            if (roles.isEmpty()) {
                roles = "2";
            }
            return ResultUtil.success(sysMenuService.findByIds(roles));
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println (e.getMessage ());
            return ResultUtil.error("操作失败");
        }
    }

    @ApiOperation(value = "根据角色id获取菜单内容", notes = "根据角色id获取菜单内容")
    @GetMapping("/findMenusByRoleId")
    @ResponseBody
    public ResultUtil findMenusByRoleId(Integer rid) {
        try {

            //TODO  拿到角色找彩蛋
            Map<String, Object> map = sysMenuService.findByRoleId(rid);
            // List<SysMenu> tree = sysMenuService.findAllMenus();
            return ResultUtil.success(map);
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存菜单信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysMenu sysMenu) {
        try {
            sysMenuService.insertOrUpdate(sysMenu);
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("保存失败");
        }
    }
    /*@ApiOperation(value = "新增下级", notes = "新增下级")
    @PostMapping("/saveChildren")
    @ResponseBody
    public ResultUtil saveChildren(@RequestBody Map<String,SysMenu> sysMenus) {
        try {
            sysMenuService.insertOrUpdateChildren ( sysMenus );
            return ResultUtil.success ( "操作成功" );
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }*/


    @ApiOperation(value = "删除菜单", notes = "删除菜单")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestBody SysMenu sysMenu) {
        try {
            List<SysMenu> menus = sysMenuService.select(sysMenu);
            if (menus == null || menus.size() <= 0) {
                return ResultUtil.error("菜单不存在");
            }
            SysRoleVsMenu sysRoleVsMenu = new SysRoleVsMenu();
            sysRoleVsMenu.setMenu_id(sysMenu.getId());
            List<SysRoleVsMenu> sysRoleVsMenus = sysRoleVsMenuService.select(sysRoleVsMenu);
            if (sysRoleVsMenus != null && sysRoleVsMenus.size() > 0) {
                return ResultUtil.error("菜单已绑定角色，不能删除");
            }
            sysMenuService.deleteById(sysMenu.getId());
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            return ResultUtil.error("操作失败");
        }
    }
}

