package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.product.dc.dao.dao1.DcTransferDao;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcTransfer;
import com.sxdl.product.dc.service.DcTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dcTransferService")
@Transactional
public class DcTransferServiceImpl extends BaseUUIDServiceImpl<DcTransfer> implements DcTransferService {

    @Autowired
    private HandleDao handleDao;

    @Autowired
    private DcTransferDao dcTransferDao;

    @Override
    public String findInfo(String name, String fromType, String fromUrl, String username, String pwd, String linkStr) {
        //dcTransferDao.findInfo(name, fromType, fromUrl, username, pwd);
        return handleDao.findInfo(name, fromType, fromUrl, username, pwd, linkStr);

    }

    @Override
    public void deleteServerLink(String sql) {
        handleDao.execSelectSql(sql);
        //dcTransferDao.deleteServerLink(sql);
    }
}
