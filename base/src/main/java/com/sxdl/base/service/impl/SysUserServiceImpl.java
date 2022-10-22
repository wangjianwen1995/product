package com.sxdl.base.service.impl;

import com.sxdl.base.dao.dao1.SysRoleDao;
import com.sxdl.base.dao.dao1.SysUserDao;
import com.sxdl.base.dao.dao1.SysUserVsKsDao;
import com.sxdl.base.dao.dao1.SysUserVsRoleDao;
import com.sxdl.base.entity.SysRole;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.entity.SysUserVsKs;
import com.sxdl.base.entity.SysUserVsRole;
import com.sxdl.base.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysUserService")
@Transactional
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    SysUserVsRoleDao sysUserVsRoleDao;
    @Autowired
    SysUserVsKsDao sysUserVsKsDao;
    @Autowired
    SysRoleDao sysRoleDao;
  /*  @Autowired
    SysKsDao sysKsDao;
*/

    @Override
    public SysUser selectOne(SysUser dcUser1) {
        return sysUserDao.selectOne ( dcUser1 );
    }

    @Override
    public void updateByPrimaryKey(SysUser dcUser) {
        sysUserDao.updateByPrimaryKeySelective ( dcUser );
    }

    @Override
    public List<SysUser> selectAll() {
        return sysUserDao.selectAll ();
    }

    @Override
    public Integer AutoUpateUser() {
        Integer integer = sysUserDao.AutoUpateUser ();
        return integer;
    }

    //新增用户
    @Override
    public void insertSysUser(SysUser sysUser) {
        sysUserDao.insertSelective ( sysUser );
    }

  /*  @Override
    public void insertSysUser(SysUser sysUser) {
        sysUserDao.insertSelective ( sysUser );
        List<SysUserVsRole> roles = sysUser.getRoles ();
        roles.forEach ( e -> {
            e.setUser_id ( sysUser.getId () );
            sysUserVsRoleDao.insertSelective ( e );
        } );
        List<SysUserVsKs> kss = sysUser.getKss ();
        kss.forEach ( e -> {
            e.setUser_id ( sysUser.getId () );
            sysUserVsKsDao.insertSelective ( e );
        } );
        if (kss.size () > 1) {
            String userSql = getUserSql ( kss );
            sysUser.setSql ( userSql );
        }

    }*/

    @Override
    public void updateSysUser(SysUser sysUser) {

        sysUserDao.updateByPrimaryKeySelective ( sysUser );
      /*  List<SysUserVsRole> roles = sysUser.getRoles ();
        roles.forEach ( e -> {
            sysUserVsRoleDao.updateByPrimaryKeySelective (e);
        });*/
    }

    @Override
    public void insertBaUser(SysUser sysUser) {
        // 判断科室
    /*    if(null==sysUser.getKs_name()||"".equals(sysUser.getKs_name())){
            SysKs sysKs=new SysKs();
            sysKs.setName("病案室");
            List<SysKs> sysKsList = sysKsDao.select(sysKs);
            if(null==sysKsList||sysKsList.size()<=0){
                sysKs.setName("病案室");
                sysKs.setCode("bas");
                sysKsDao.insert(sysKs);
            }
            sysUser.setKs_id("bas");
            sysUser.setKs_name("病案室");
        }*/
        sysUserDao.insertSelective ( sysUser );
        // 判断角色
        SysUserVsRole sysUserVsRole=new SysUserVsRole();
        sysUserVsRole.setUser_id(sysUser.getId());
        SysRole sysRole=new SysRole();
        sysRole.setName("病案组");
        List<SysRole> list = sysRoleDao.select(sysRole);
        if(null==list||list.size()<=0){
            sysRole.setIndex_url("/index");
            sysRole.setIndex_menu_id(3);
            sysRoleDao.insertSelective(sysRole);
            sysUserVsRole.setRole_id(sysRole.getId());
            sysUserVsRole.setRole_name(sysRole.getName());
        } else {
            SysRole role = list.get(0);
            sysUserVsRole.setRole_id(role.getId());
            sysUserVsRole.setRole_name(role.getName());
        }
        sysUserVsRoleDao.insertSelective(sysUserVsRole);

    }

    @Override
    public void deleteUserById(Integer id) {
        SysUserVsRole sysUserVsRole = new SysUserVsRole ();
        sysUserVsRole.setUser_id ( id );
        SysUserVsKs sysUserVsKs = new SysUserVsKs ();
        sysUserVsKs.setUser_id ( id );
        List<SysUserVsKs> userVsKs = sysUserVsKsDao.select ( sysUserVsKs );
        if (userVsKs != null && userVsKs.size () > 0) {
            userVsKs.forEach ( e -> {
                sysUserVsKsDao.delete ( sysUserVsKs );
            } );
        }
        List<SysUserVsRole> userVsRoles = sysUserVsRoleDao.select ( sysUserVsRole );
        if (userVsRoles != null && userVsRoles.size () > 0) {
            userVsRoles.forEach ( e -> {
                sysUserVsRoleDao.delete ( sysUserVsRole );
            } );
        }
        sysUserDao.deleteByPrimaryKey ( id );
    }

    public String getUserSql(List<SysUserVsKs> sysUserVsKsList) {
        StringBuilder kss = new StringBuilder ();
        kss.append ( "in (" );
        kss.append ( sysUserVsKsList.get ( 0 ).getKs_id () );
        for (int i = 1; i < sysUserVsKsList.size (); i++) {
            kss.append ( "," + sysUserVsKsList.get ( i ).getKs_id () );
        }
        kss.append ( ")" );
        return kss.toString ();
    }
}