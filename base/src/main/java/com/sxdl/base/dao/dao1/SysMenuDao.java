package com.sxdl.base.dao.dao1;

import com.sxdl.base.config.PrefixConfig;
import com.sxdl.base.dao.BaseDao;
import com.sxdl.base.entity.SysMenu;
import org.apache.ibatis.annotations.Select;

public interface SysMenuDao extends BaseDao<SysMenu> {

    @Select("SELECT max(xh) FROM [dbo].["+ PrefixConfig.PREFIX +"sys_menu] where menu_type!=5")
    Integer findMaxXh();


    @Select("SELECT max(xh) FROM [dbo].["+ PrefixConfig.PREFIX +"sys_menu] where menu_type=5")
    Integer findSysMaxXh();
}
