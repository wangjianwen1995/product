package com.sxdl.performance.controller;

import com.sxdl.base.controller.SysMenuController;
import com.sxdl.base.entity.SysMenu;
import com.sxdl.base.service.SysMenuService;
import com.sxdl.base.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PpMenuController extends SysMenuController {
    @Autowired
    SysMenuService sysMenuService;

    @GetMapping("/indexHbiMenu")
    public ResultUtil getIndexHbiMenu() {
        try {
            SysMenu sm = new SysMenu();
            sm.setMenu_type(4);
            sm.setHaschildren(false);
            List<SysMenu> menus = sysMenuService.select(sm);
            return ResultUtil.success(menus);
        } catch (Exception e) {
            return ResultUtil.success(e.getCause());
        }
    }
}
