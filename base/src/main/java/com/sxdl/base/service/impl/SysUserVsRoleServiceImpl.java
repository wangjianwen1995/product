package com.sxdl.base.service.impl;

import com.sxdl.base.dao.dao1.SysUserVsRoleDao;
import com.sxdl.base.entity.SysUserVsRole;
import com.sxdl.base.service.SysUserVsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysUserVsRoleService")
@Transactional
public class SysUserVsRoleServiceImpl extends BaseServiceImpl<SysUserVsRole> implements SysUserVsRoleService {
    @Autowired
    SysUserVsRoleDao sysUserVsRoleDao;

    @Override
    public SysUserVsRole selectOne(SysUserVsRole sysUserVsRole1) {
        return sysUserVsRoleDao.selectOne ( sysUserVsRole1 );
    }

    @Override
    public void insertSysUserVsRole(SysUserVsRole sysUserVsRole) {
        sysUserVsRoleDao.insertSelective ( sysUserVsRole );
    }

    @Override
    public List<SysUserVsRole> findByuserId(Integer id) {
        return sysUserVsRoleDao.findByuserId(id);
    }


}
