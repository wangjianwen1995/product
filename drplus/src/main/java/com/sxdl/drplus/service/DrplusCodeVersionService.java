package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.*;
import com.sxdl.drplus.dto.ICDDBO;
import com.sxdl.drplus.entity.DrplusCodeVersion;
import com.sxdl.drplus.entity.DrplusJbicdMap;
import com.sxdl.drplus.entity.DrplusSsicdMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class DrplusCodeVersionService extends BaseServiceImpl<DrplusCodeVersion> {


    @Autowired
    private DrplusCodeVersionDao drplusCodeVersionDao;

    @Autowired
    private DrplusJbicdDao jbicdDao;

    @Autowired
    private DrplusSsicdDao ssicdDao;


    @Autowired
    private DrplusJbicdMapDao jbicdMapDao;

    @Autowired
    private DrplusSsicdMapDao ssicdMapDao;


    public List<DrplusCodeVersion> getVersionBytype(Integer type, String val) {
        return drplusCodeVersionDao.getVersionBytype(type,val);
    }

    public void saveICDVersion(DrplusCodeVersion drplusCodeVersion) {
        if(StringUtils.isEmpty(drplusCodeVersion.getId())){
            int insert = drplusCodeVersionDao.insert(drplusCodeVersion);
        }else{
            int i = drplusCodeVersionDao.updateByPrimaryKey(drplusCodeVersion);
        }

    }

    public Integer getCountBytype(Integer type,Integer pid) {
        Integer integer;
        if(type==1){
            integer  = jbicdDao.getCountBytype(pid);
        }else{
            integer = ssicdDao.getCountBytype(pid);
        }
        return integer;
    }

    public void delICDVersionById(Integer id) {
          drplusCodeVersionDao.deleteByPrimaryKey(id);
          return;
    }

    public void saveICD(ICDDBO icddbo) {
        if(!StringUtils.isEmpty(icddbo.getJbicd())){
            int insert = jbicdDao.insert(icddbo.getJbicd());
        }else{
            int insert = ssicdDao.insert(icddbo.getSsicd());
        }
    }

    public void delICD(ICDDBO icddbo) {


        if(!StringUtils.isEmpty(icddbo.getJbicd())){
            int insert = jbicdDao.deleteByPrimaryKey(icddbo.getJbicd().getId());
            DrplusJbicdMap jbicdMap = new DrplusJbicdMap();
            jbicdMap.setLeft_version_id(icddbo.getJbicd().getDrplus_code_version_id())
                    .setRight_code(icddbo.getJbicd().getCode())
                    .setLeft_name(icddbo.getJbicd().getName());
            int delete = jbicdMapDao.delete(jbicdMap);
            int i1 = jbicdMapDao.deleteSqlWithSQL(" delete from drplus_jbicd_map where left_code = '" + icddbo.getJbicd().getCode() + "' and left_name='" + icddbo.getJbicd().getName() + "' and  left_version_id=" + icddbo.getJbicd().getDrplus_code_version_id());
            int i =  jbicdMapDao.updateSqlWithSQL(" update drplus_jbicd_map set right_code=null ,right_name=null where right_code='" + icddbo.getJbicd().getCode() + "' and right_name='" + icddbo.getJbicd().getName() + "' and " +
                    " right_version_id=" + icddbo.getJbicd().getDrplus_code_version_id());

        }else{
            int insert = ssicdDao.deleteByPrimaryKey(icddbo.getSsicd().getId());
            DrplusSsicdMap  ssicdMap = new DrplusSsicdMap();
            ssicdMap.setLeft_version_id(icddbo.getSsicd().getDrplus_code_version_id())
                    .setRight_code(icddbo.getSsicd().getCode())
                    .setLeft_name(icddbo.getSsicd().getName());
            int delete = ssicdMapDao.delete(ssicdMap);
            int i1 = jbicdMapDao.deleteSqlWithSQL(" delete from drplus_ssicd_map where left_code = '" + icddbo.getSsicd().getCode() + "' and left_name='" + icddbo.getSsicd().getName() + "' and  left_version_id=" + icddbo.getSsicd().getDrplus_code_version_id());
            int i = jbicdMapDao.updateSqlWithSQL(" update  drplus_ssicd_map set right_code=null ,right_name=null where right_code='" + icddbo.getSsicd().getCode() + "' and right_name='" + icddbo.getSsicd().getName() + "' and "  +
                    " right_version_id=" + icddbo.getSsicd().getDrplus_code_version_id());
        }
    }
}
