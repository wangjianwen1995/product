package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdInfoDao;
import com.sxdl.sd.entity.SdInfo;
import com.sxdl.sd.service.SdInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sdInfoService")
@Transactional
public class SdInfoServiceImpl extends BaseServiceImpl<SdInfo> implements SdInfoService {

    @Autowired
    private SdInfoDao  sdInfoDao;

    @Override
    public List<SdInfo> findAllSd() {
        return sdInfoDao.findAllSd();
    }
}
