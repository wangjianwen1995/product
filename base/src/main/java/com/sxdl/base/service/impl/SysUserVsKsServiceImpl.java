package com.sxdl.base.service.impl;

import cn.hutool.core.util.StrUtil;
import com.sxdl.base.dao.dao1.SysUserDao;
import com.sxdl.base.dao.dao1.SysUserVsKsDao;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.entity.SysUserVsKs;
import com.sxdl.base.service.SysUserVsKsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("sysUserVsKsService")
@Transactional
public class SysUserVsKsServiceImpl extends BaseServiceImpl<SysUserVsKs> implements SysUserVsKsService {
    @Autowired
    SysUserVsKsDao sysUserVsKsDao;
    @Autowired
    SysUserDao sysUserDao;
 /*   @Autowired
    SysKsDao sysKsDao;
    @Autowired
    SysStandardKsDao sysStandardKsDao;
*/

    @Override
    public SysUserVsKs selectOne(SysUserVsKs sysUserVsKs1) {
        SysUserVsKs sysUserVsKs = sysUserVsKsDao.selectOne(sysUserVsKs1);
        return sysUserVsKs;
    }

    @Override
    public void insertSysUserVsKs(SysUserVsKs sysUserVsKs) {
        sysUserVsKsDao.insertSelective(sysUserVsKs);
        SysUser sysUser = sysUserDao.selectByPrimaryKey(sysUserVsKs.getUser_id());
        SysUserVsKs sysUserVsKs1 = new SysUserVsKs();
        sysUserVsKs1.setUser_id(sysUserVsKs.getUser_id());
        List<SysUserVsKs> sysUserVsKsList = sysUserVsKsDao.select(sysUserVsKs1);
        if (sysUserVsKsList.size() > 1) {
            /*kss.append ( "in (" );
            kss.append ( sysUserVsKsList.get ( 0 ).getKs_id () );
            for (int i = 1; i < sysUserVsKsList.size (); i++) {
                kss.append ( ","+ sysUserVsKsList.get (i ).getKs_id () );
            }
            kss.append ( ")" );*/
            String userSql = getUserSql(sysUserVsKsList);
            String userStandard = getUserStandard(sysUserVsKsList);
            sysUser.setKk_ks(userSql);
            sysUser.setKk_standard(userStandard);
            sysUserDao.updateByPrimaryKeySelective(sysUser);
        }
    }

    @Override
    public void insertSysUserVsKs1(SysUser sysUser) {
        SysUser sysUser1 = sysUserDao.selectOne(sysUser);
        //本次新增的科室
        List<SysUserVsKs> sysUserVsKss = sysUser.getKss();
        SysUserVsKs sysUserVsKs1 = new SysUserVsKs();
        sysUserVsKs1.setUser_id(sysUser.getId());
        for (SysUserVsKs sysUserVsKs : sysUserVsKss) {
            sysUserVsKs1.setKs_id(sysUserVsKs.getKs_id());
            //查看当前用户是否已有此科室权限
            List<SysUserVsKs> userVsKs = sysUserVsKsDao.select(sysUserVsKs1);
            //System.out.println ("cc" + userVsKs);
            if (userVsKs != null && userVsKs.size() > 0) {
                sysUserVsKsDao.updateByPrimaryKey(userVsKs.get(0));
            } else {
                sysUserVsKs.setUser_id(sysUser.getId());
                sysUserVsKs.setUser_name(sysUser1.getName());
                sysUserVsKsDao.insert(sysUserVsKs);
            }
        }
        SysUserVsKs sysUserVsKs2 = new SysUserVsKs();
        sysUserVsKs2.setUser_id(sysUser.getId());
        //当前用户所有科室权限
        List<SysUserVsKs> sysUserVsKs = sysUserVsKsDao.select(sysUserVsKs2);
        if (sysUserVsKss.size() >= 1) {
            //String userSql = getUserSql ( sysUserVsKs );
            String userKs = getUserStandard1(sysUserVsKs);
            String userStandard = getUserStandard(sysUserVsKs);
            sysUser.setKk_ks(userKs);
            sysUser.setKk_standard(userStandard);
            sysUserDao.updateByPrimaryKeySelective(sysUser);
        }
    }

    @Override
    public List<SysUserVsKs> findByuserId(Integer userid) {
        return sysUserVsKsDao.findByuserId(userid);
    }

    @Override
    public List<String> findAllkscodes(Integer userid, Integer staffid) {
        if (staffid ==null || StrUtil.isEmpty(staffid.toString().trim())) {
            return sysUserVsKsDao.findAddkscode(userid);
        }
        return sysUserVsKsDao.findAddkscodes(userid, staffid);
    }

    public String getUserSql(List<SysUserVsKs> sysUserVsKsList) {
        StringBuilder kss = new StringBuilder();
        kss.append("in (");
        kss.append(sysUserVsKsList.get(0).getKs_id());
        for (int i = 1; i < sysUserVsKsList.size(); i++) {
            kss.append("," + sysUserVsKsList.get(i).getKs_id());
        }
        kss.append(")");
        return kss.toString();
    }

    public String getUserStandard(List<SysUserVsKs> sysUserVsKsList) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        //SysKs sysKs=new SysKs ();
        sysUserVsKsList.forEach(e -> {

            //
            set.add(e.getStandard_id());
        });

        set.forEach(e -> {
            list.add(e);
        });
        StringBuilder kss = new StringBuilder();
        if (list.size() > 1) {
            kss.append("in (");
            kss.append("'" + list.get(0) + "'");
            for (int i = 1; i < list.size(); i++) {
                kss.append(",'" + list.get(i) + "'");
            }
            kss.append(")");
        } else if (list.size() == 1) {
            kss.append("=");
            kss.append(list.get(0));
        }
        return kss.toString();
    }


    public String getUserStandard1(List<SysUserVsKs> sysUserVsKsList) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        //SysKs sysKs=new SysKs ();
        sysUserVsKsList.forEach(e -> {

           /* sysKs.setCode (  e.getKs_id ());
            SysKs sysKs1 = sysKsDao.selectOne ( sysKs );*/
            set.add(e.getKs_id());
        });

        set.forEach(e -> {
            list.add(e);
        });
        StringBuilder kss = new StringBuilder();
        if (list.size() > 1) {
            kss.append("in (");
            kss.append("'" + list.get(0) + "'");
            for (int i = 1; i < list.size(); i++) {
                kss.append(",'" + list.get(i) + "'");
            }
            kss.append(")");
        } else if (list.size() == 1) {
            kss.append("=");
            kss.append(list.get(0));
        }
        //System.out.println (kss);
        return kss.toString();
    }

}
