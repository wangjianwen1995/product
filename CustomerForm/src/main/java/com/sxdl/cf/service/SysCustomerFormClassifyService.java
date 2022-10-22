package com.sxdl.cf.service;

import com.sxdl.cf.dao.dao1.SysCustomerFormClassifyDao;
import com.sxdl.cf.entity.SysCustomerFormClassifyEntity;
import com.sxdl.cf.entity.SysCustomerFormFactTableEntity;
import com.sxdl.cf.service.base.BaseUUIDServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SysCustomerFormClassifyService extends BaseUUIDServiceImpl<SysCustomerFormFactTableEntity> {



    private final SysCustomerFormClassifyDao classifyDao;


    public List<SysCustomerFormClassifyEntity> getClassifyList() {
        return classifyDao.getAllClassify();
    }

    public void addClassify(SysCustomerFormClassifyEntity classifyEntity) {
        int insert = classifyDao.insert(classifyEntity);
    }

    public void setClassify(SysCustomerFormClassifyEntity classifyEntity) {
        int i = classifyDao.updateByPrimaryKey(classifyEntity);
    }

    public void delClassify(String id) {
        int i = classifyDao.deleteByPrimaryKey(id);
    }
}
