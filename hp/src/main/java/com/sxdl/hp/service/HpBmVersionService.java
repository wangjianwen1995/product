package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hp.dao.dao1.HpBmVersionDao;
import com.sxdl.hp.entity.HpBmVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HpBmVersionService extends BaseUUIDServiceImpl<HpBmVersion> {

    @Autowired
    HpBmVersionDao hpBmVersionDao;

    /**
     * 插入当前编码版本,设置状态为开启,更新其他版本为关闭
     */
    public void updateVersion(HpBmVersion hpBmVersion)  {
        if (hpBmVersion.getIson().equals("1")) {//启用当前版本
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
        }
        hpBmVersionDao.insert(hpBmVersion);
    }

}
