package com.sxdl.analyse.controller;

import com.sxdl.base.controller.SysMenuController;
import com.sxdl.base.entity.SysMenu;
import com.sxdl.base.service.SysMenuService;
import com.sxdl.base.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/idexMenu")
public class DaMenuController extends SysMenuController {


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
