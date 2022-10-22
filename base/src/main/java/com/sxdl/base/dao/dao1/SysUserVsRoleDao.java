package com.sxdl.base.dao.dao1;

import com.sxdl.base.config.PrefixConfig;
import com.sxdl.base.dao.BaseDao;
import com.sxdl.base.entity.SysUserVsRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserVsRoleDao extends BaseDao<SysUserVsRole> {
    @Select("select * from "+ PrefixConfig.PREFIX +"sys_user_vs_role where user_id = ${id}")
    List<SysUserVsRole> findByuserId(Integer id);
}
