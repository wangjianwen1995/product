package com.sxdl.product.dc.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.product.dc.dao.dao1.HpBmVersionDao;
import com.sxdl.product.dc.entity.HpBmVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HpBmVersionService extends BaseUUIDServiceImpl<HpBmVersion> {

    @Autowired
    HpBmVersionDao hpBmVersionDao;

    public void updateVersion(HpBmVersion hpBmVersion) throws Exception {
        String ison = hpBmVersion.getIson();
        if (!ison.equals("1")) {
            hpBmVersionDao.insert(hpBmVersion);
        } else {
            HpBmVersion hpBmVersion_old = new HpBmVersion();
            //当前分类下是否有启用的版本
            hpBmVersion_old.setIson("1");
            hpBmVersion_old.setType(hpBmVersion.getType());
            hpBmVersion_old.setHid(hpBmVersion.getHid());
            HpBmVersion bmVersion = hpBmVersionDao.selectOne(hpBmVersion_old);
            if (bmVersion != null) {
                //当前分类下有启用的版本---停用
                bmVersion.setEtime(hpBmVersion.getStime());
                bmVersion.setIson("2");
                hpBmVersionDao.updateByPrimaryKeySelective(bmVersion);
            }
            hpBmVersionDao.insert(hpBmVersion);
        }

    }

}
