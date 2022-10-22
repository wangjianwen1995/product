package com.sxdl.hr.service.impl;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hr.dao.dao1.HrTgrBlmDao;
import com.sxdl.hr.entity.TgrBlmEntity;
import com.sxdl.hr.service.HrTgrBlmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("hrTgrBlmService")
@Transactional
public class HrTgrBlmServiceImpl extends BaseUUIDServiceImpl<TgrBlmEntity> implements HrTgrBlmService{
    @Autowired
    private HrTgrBlmDao hrTgrBlmDao;

    @Override
    public List<TgrBlmEntity> findByDcgid(String dcgid) {
        return hrTgrBlmDao.findByDcgid(dcgid);
    }
}
