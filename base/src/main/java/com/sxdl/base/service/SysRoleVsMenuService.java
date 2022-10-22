package com.sxdl.base.service;

import com.sxdl.base.entity.SysRoleVsMenu;

import java.util.List;

public interface SysRoleVsMenuService extends BaseService<SysRoleVsMenu>{
        List<SysRoleVsMenu> findByRoleId(Integer RoleId);

        void insertOrUpdate(List<SysRoleVsMenu> sysRoleVsMenus);
}
