package com.sxdl.base.service;

import com.sxdl.base.entity.SysUser;
import com.sxdl.base.entity.SysUserVsKs;

import java.util.List;

public interface SysUserVsKsService extends BaseService<SysUserVsKs>{
    SysUserVsKs selectOne(SysUserVsKs sysUserVsKs1);

    void insertSysUserVsKs(SysUserVsKs sysUserVsKs);

    void insertSysUserVsKs1(SysUser sysUser);

    List<SysUserVsKs> findByuserId(Integer userid);
    List<String> findAllkscodes(Integer userid,Integer staffid);
}
