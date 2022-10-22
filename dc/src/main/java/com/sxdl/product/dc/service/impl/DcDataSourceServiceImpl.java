package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.product.dc.dao.dao1.DcDataSourceDao;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcDataSource;
import com.sxdl.product.dc.service.DcDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dcDataSourceService")
@Transactional
public class DcDataSourceServiceImpl extends BaseUUIDServiceImpl<DcDataSource> implements DcDataSourceService {

    @Autowired
    DcDataSourceDao dcDataSourceDao;

    @Autowired
    private HandleDao handleDao;

    @Override
    public String findInfo(String name, String fromType, String fromUrl, String username, String pwd, String linkStr) {
        return handleDao.findInfo(name, fromType, fromUrl, username, pwd, linkStr);

    }

    @Override
    public void deleteServerLink(String sql) {
        handleDao.execSelectSql(sql);
    }

    @Override
    public List<DcDataSource> findByCondition(String name) {
        return dcDataSourceDao.findByCondition(name);
    }


}
