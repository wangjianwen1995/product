package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.DrPlusStoredProcedureDao;
import com.sxdl.drplus.entity.DrPlusStoredProcedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class DrPlusStoredProcedureService extends BaseServiceImpl<DrPlusStoredProcedure> {

    @Autowired
    private DrPlusStoredProcedureDao storedProcedureDao;

    public void saveStoredProcedure(DrPlusStoredProcedure drPlusStoredProcedure) {
        if(StringUtils.isEmpty(drPlusStoredProcedure.getId())){
            int insert = storedProcedureDao.insert(drPlusStoredProcedure);
        }else{
            int insert = storedProcedureDao.updateByPrimaryKey(drPlusStoredProcedure);
        }
        return;
    }

    public List<DrPlusStoredProcedure> getStoredProcedureData(Integer pid,String val) {

        return storedProcedureDao.getStoredProcedureData(pid,val);
    }

    public void delStoredProcedureData(Integer id) {
        int i = storedProcedureDao.deleteByPrimaryKey(id);
        return;
    }

    public void execProc(String sql) {
        storedProcedureDao.execProc(sql);
        return;
    }
}
