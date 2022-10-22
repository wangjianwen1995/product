package com.sxdl.base.service;

import com.sxdl.base.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService extends BaseService<SysMenu> {
    /**
     * 根据菜单标题名称和路径模糊查询系统菜单
     * @param name 标题,名称,路劲
     * @return 列表
     */
    List<SysMenu> findAllMenus(String name);

    void insertOrUpdate(SysMenu sysMenu);

    List<SysMenu> findByIds(String roles);

    Map<String, Object> findByRoleId(Integer rid);

    // void insertOrUpdateChildren(Map<String, SysMenu> sysMenus);
}
