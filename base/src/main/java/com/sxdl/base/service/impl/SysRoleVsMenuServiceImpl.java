package com.sxdl.base.service.impl;

import com.sxdl.base.dao.dao1.SysMenuDao;
import com.sxdl.base.dao.dao1.SysRoleVsMenuDao;
import com.sxdl.base.entity.SysMenu;
import com.sxdl.base.entity.SysRoleVsMenu;
import com.sxdl.base.service.SysRoleVsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("sysRoleVsMenuService")
@Transactional
public class SysRoleVsMenuServiceImpl extends BaseServiceImpl<SysRoleVsMenu> implements SysRoleVsMenuService {
    @Autowired
    private SysRoleVsMenuDao sysRoleVsMenuDao;
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysRoleVsMenu> findByRoleId(Integer RoleId) {
        SysRoleVsMenu sysRoleVsMenu = new SysRoleVsMenu ();
        sysRoleVsMenu.setRole_id ( RoleId );
        List<SysRoleVsMenu> sysRoleVsMenus = sysRoleVsMenuDao.select ( sysRoleVsMenu );
        return sysRoleVsMenus;
    }

    @Override
    public void insertOrUpdate(List<SysRoleVsMenu> sysRoleVsMenus) {
        SysRoleVsMenu sysRoleVsMenu = new SysRoleVsMenu ();
        if (sysRoleVsMenus.size () > 0) {
            SysRoleVsMenu sysRoleVsMenu1 = new SysRoleVsMenu ();
            sysRoleVsMenu1.setRole_id ( sysRoleVsMenus.get ( 0 ).getRole_id () );
            sysRoleVsMenuDao.delete ( sysRoleVsMenu1 );
            sysRoleVsMenus.forEach ( e -> {
           sysRoleVsMenu.setMenu_id( e.getMenu_id());
                sysRoleVsMenu.setRole_id(e.getRole_id());
                sysRoleVsMenu.setMenu_name(e.getMenu_name());
                sysRoleVsMenuDao.insert ( sysRoleVsMenu );
            } );
        }
    }

    private List<SysRoleVsMenu> updateList(List<SysRoleVsMenu> sysRoleVsMenus) {
        Set<Integer> set = new HashSet<> ();
        //set.addAll ( sysRoleVsMenus );
        sysRoleVsMenus.forEach ( e -> {
            set.add ( e.getMenu_id () );
           /* SysMenu sysMenu = sysMenuDao.selectByPrimaryKey ( e.getMenu_id () );
            if (sysMenu.getParent_code () != null) {
                if(set)
            }*/
        } );
        sysRoleVsMenus.forEach ( e -> {
           SysMenu sysMenu = sysMenuDao.selectByPrimaryKey ( e.getMenu_id () );
            Integer parent_code = sysMenu.getParent_code ();
            if (parent_code != null) {
                if(set.contains ( parent_code )){}
            }
        } );
        return  null;
    }
}
