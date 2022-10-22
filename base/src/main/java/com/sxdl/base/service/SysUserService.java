package com.sxdl.base.service;

import com.sxdl.base.entity.SysUser;

import java.util.List;

public interface SysUserService extends BaseService<SysUser> {
    SysUser selectOne(SysUser dcUser1);

    void updateByPrimaryKey(SysUser dcUser);

    List<SysUser> selectAll();

    Integer AutoUpateUser();

    void insertSysUser(SysUser sysUser);

    void updateSysUser(SysUser sysUser);

    void deleteUserById(Integer id);

    void insertBaUser(SysUser sysUser);
}
