package com.sxdl.base.service.impl;

import com.sxdl.base.dao.dao1.SysMenuDao;
import com.sxdl.base.dao.dao1.SysRoleDao;
import com.sxdl.base.dao.dao1.SysRoleVsMenuDao;
import com.sxdl.base.entity.SysMenu;
import com.sxdl.base.entity.SysRole;
import com.sxdl.base.entity.SysRoleVsMenu;
import com.sxdl.base.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysRoleService")
@Transactional
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleVsMenuDao sysRoleVsMenuDao;
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public void insertOrUpdate(SysRole sysRole) {
        Integer id = sysRole.getId ();
        if ("".equals ( id ) || null == id) {
            sysRoleDao.insert ( sysRole );
        } else {
            sysRoleDao.updateByPrimaryKey ( sysRole );
        }
        Integer index_menu_id = sysRole.getIndex_menu_id ();
        updateSysRoleVsMenu ( sysRole.getId (), index_menu_id );
        SysMenu sysMenu = sysMenuDao.selectByPrimaryKey ( index_menu_id );
        Integer parent_code = sysMenu.getParent_code ();
        if (null != parent_code && !"".equals ( parent_code ) && parent_code > 0) {
            updateSysRoleVsMenu ( sysRole.getId (), parent_code );
        }
        //System.out.println (sysRoleVsMenuDao.selectAll ());

    }

    private void updateSysRoleVsMenu(Integer rid, Integer mid) {
        SysRoleVsMenu sysRoleVsMenu1 = new SysRoleVsMenu ();
        sysRoleVsMenu1.setRole_id ( rid );
        sysRoleVsMenu1.setMenu_id ( mid );
        sysRoleVsMenu1.setMenu_name ( "首页" );
        List<SysRoleVsMenu> roleVsMenus1 = sysRoleVsMenuDao.select ( sysRoleVsMenu1 );
        if (roleVsMenus1 == null || roleVsMenus1.size () <= 0) {
            sysRoleVsMenuDao.insert ( sysRoleVsMenu1 );
        }
    }
}
