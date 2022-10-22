package com.sxdl.base.service;

import com.sxdl.base.entity.SysUserVsRole;

import java.util.List;

public interface SysUserVsRoleService extends BaseService<SysUserVsRole>{
    SysUserVsRole selectOne(SysUserVsRole sysUserVsRole1);

    void insertSysUserVsRole(SysUserVsRole sysUserVsRole);

    List<SysUserVsRole> findByuserId(Integer id);
}
