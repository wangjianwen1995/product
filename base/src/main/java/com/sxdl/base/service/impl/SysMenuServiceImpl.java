package com.sxdl.base.service.impl;

import cn.hutool.core.util.StrUtil;
import com.sxdl.base.config.PrefixConfig;
import com.sxdl.base.dao.dao1.SysMenuDao;
import com.sxdl.base.dao.dao1.SysRoleVsMenuDao;
import com.sxdl.base.entity.SysMenu;
import com.sxdl.base.entity.SysRoleVsMenu;
import com.sxdl.base.service.SysMenuService;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.MD5Util;
import com.sxdl.base.util.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("sysMenuService")
@Transactional
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysRoleVsMenuDao sysRoleVsMenuDao;
    private String sql;
    private List<SysMenu> menus;
    private Map<String, Object> meta;
    @Override
    public List<SysMenu> findAllMenus(String name) {
        sql="select * from "+ PrefixConfig.PREFIX+"sys_menu where menu_type !=4 ";
        if(StrUtil.isNotEmpty(name)){
            sql+="and (title like '%"+name+"%' or name like'%"+name+"%' or path like'%"+name+"%')";
        }
        List<SysMenu> menus = selectListWithSQL(sql,SysMenu.class);
        if(StrUtil.isNotEmpty(name)){
            return menus;
        }
        menus = menus.stream().filter(e -> e != null && e.getMenu_type() != 4).collect(Collectors.toList());
        menus.forEach(e -> {
            e.setIndex(e.getPath());
            Map<String, Object> meta = new HashMap<>();
            meta.put("title", e.getTitle());
            meta.put("icon", e.getIcon());
            meta.put("affix", e.getAffix());
            meta.put("cs", e.getCs());
            e.setMeta(meta);
        });
        List<SysMenu> tree = TreeUtils.tree(menus, SysMenu::getId, SysMenu::getParent_code, SysMenu::getChildren,SysMenu::setChildren, null);
        return tree;
    }

    @Override
    public void insertOrUpdate(SysMenu sysMenu) {
        Integer id = sysMenu.getId();
        Integer menuType = sysMenu.getMenu_type();
        if ("".equals(id) || null == id) {
            if (menuType.equals(5)) {
                menuType = sysMenuDao.findSysMaxXh();
            } else {
                menuType = sysMenuDao.findMaxXh();
            }
            sysMenu.setXh(menuType + 1);
            //sysMenu.setHaschildren ( false );
            sysMenuDao.insert(sysMenu);
        } else {
            sysMenuDao.updateByPrimaryKeySelective(sysMenu);
        }
    }
    String port;
    @Override
    public List<SysMenu> findByIds(String roles) {
        if(roles.trim().endsWith(",")){
            roles=roles.substring(0,roles.lastIndexOf(","));
        }
        sql = "select * from  "+ PrefixConfig.PREFIX+"sys_menu where id in(select DISTINCT menu_id from "+ PrefixConfig.PREFIX+"sys_role_vs_menu where role_id in(" + roles + ")) order by xh";
        menus = selectListWithSQL(sql, SysMenu.class);
        Environment env = (Environment) ApplicationRunnerImpl.contextMap.get("env");
        port=env.getProperty("server.port");
        port=StrUtil.isEmpty(port)?"233999":port;
        menus.stream().forEach(e -> {
            meta = new HashMap<>();
            meta.put("title", e.getTitle());
            meta.put("icon", e.getIcon());
            meta.put("affix", e.getAffix());
            meta.put("cs", e.getCs());
            if(StrUtil.isEmpty(e.getComponent().trim())){
                meta.put("target", "_blank");
                e.setPath(e.getPath()+"?val="+ MD5Util.encryptSelf("sxdlmicroserversl"+port));
            }
            e.setMeta(meta);
        });
        menus = TreeUtils.tree(menus, SysMenu::getId, SysMenu::getParent_code, SysMenu::getChildren, SysMenu::setChildren, null);
        //Collections.reverse(menus);
        return menus;
    }

    @Override
    public Map<String, Object> findByRoleId(Integer rid) {
        Map<String, Object> map = new HashMap<>();
        SysRoleVsMenu sysRoleVsMenu = new SysRoleVsMenu();
        sysRoleVsMenu.setRole_id(rid);
        List<Integer> menus = new ArrayList<>();
        List<SysRoleVsMenu> sysRoleVsMenus = sysRoleVsMenuDao.select(sysRoleVsMenu);
        sysRoleVsMenus.forEach(e -> {
            SysMenu sysMenu = sysMenuDao.selectByPrimaryKey(e.getMenu_id());
            if (sysMenu.getHaschildren() != null && !sysMenu.getHaschildren()) {
                menus.add(e.getMenu_id());
            }
        });
        // menus.stream ().filter ( e -> e != null && e.g () != 1 ).collect ( Collectors.toList () );
        List<SysMenu> sysMenus = sysMenuDao.selectAll();
        //sysMenus = sysMenus.stream ().filter ( e -> e != null && e.getMenu_type ()>1 ).collect ( Collectors.toList () );
        List<SysMenu> tree = TreeUtils.tree(sysMenus, SysMenu::getId, SysMenu::getParent_code, SysMenu::getChildren,
                SysMenu::setChildren, null);
        //System.out.println (tree);
        map.put("allMenus", tree);
        map.put("ids", menus);
        return map;
    }
}
