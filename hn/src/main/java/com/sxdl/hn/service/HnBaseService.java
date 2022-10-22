package com.sxdl.hn.service;

import com.sxdl.base.dao.dao1.SysUserDao;
import com.sxdl.base.dao.dao1.SysUserVsKsDao;
import com.sxdl.base.dao.dao1.SysUserVsRoleDao;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.entity.SysUserVsRole;
import com.sxdl.hn.dao.dao1.HnHandleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HnBaseService {

//
//    @Autowired
//    private SysKsDao sysKsDao;

//    @Autowired
//    private YmlUtil ymlUtil;
//
    @Autowired
    private SysUserVsKsDao sysUserVsKsDao;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    SysUserVsRoleDao sysUserVsRoleDao;


    @Autowired
    private HnHandleDao hnHandleDao;

    /***
     * 消息提示
     */
    public List<LinkedHashMap<String,String>> getWarningYj(String code ){
        List<LinkedHashMap<String, String>> linkedHashMaps = hnHandleDao.execProcYj(code  );
        return linkedHashMaps;
    }
    public List<LinkedHashMap<String,String>> getWarningKj(String code ){
        List<LinkedHashMap<String, String>> linkedHashMaps = hnHandleDao.execProcKj(code );
        return linkedHashMaps;
    }

//    /**
//     * 查询所有科室
//     * @return
//     */
//    public List<SysKs> findAllKs() {
//        List<SysKs> sysKs = sysKsDao.selectAll();
//        return sysKs;
//    }


    /**
     *查询可看科室
     * @param userid
     * @return
     */
    public List<Map<String,Object>> findCanseeKs(Integer userid) {
        return sysUserVsKsDao.findByuserId2(userid);
    }

    /**
     * 修改所属科室
     * @param userid
     * @param kscode
     * @param ksname
     * @return
     */
    public Integer updatePlaceKs(Integer userid, String kscode, String ksname) {
        Integer integer = sysUserDao.updatePlaceKs(userid,kscode,ksname);
        return integer;

    }

    /**
     * 查看所属科室
     * @param userid
     * @return
     */
    public SysUser findPlaceKs(Integer userid) {
        SysUser sysUser = sysUserDao.selectByPrimaryKey(userid);
        return sysUser;
    }



    public List<SysUserVsRole> findroleByuserid(Integer userid) {
        return sysUserVsRoleDao.findByuserId(userid);
    }



    public List<SysUser> findAllNurse() {
        List<SysUser> sysUsers = sysUserDao.selectEable();
        return sysUsers;

    }

    public List<SysUser> findNurseBynameOrCode(String kscode, String val) {
        List<SysUser> sysUsers = null;
        if("".equals(kscode)){
            sysUsers = sysUserDao.selectByVal("%"+val+"%");
        }else{
            sysUsers = sysUserDao.selectKsAndVal(kscode,"%"+val+"%");
        }
        return sysUsers;

    }

}
