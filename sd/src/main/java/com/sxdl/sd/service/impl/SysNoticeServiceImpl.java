package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SysNoticeDao;
import com.sxdl.sd.entity.SysNotice;
import com.sxdl.sd.service.SysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysNoticeServiceImpl  extends BaseServiceImpl<SysNotice> implements SysNoticeService {
    @Autowired
    private SysNoticeDao sysNoticeDao;

    @Override
    public List<SysNotice> findByTime(String stime, String etime) {
        return sysNoticeDao.findByTime(stime,etime);
    }

    @Override
    public List<SysNotice> findByTimeByFlag(String stime, String etime) {
        return sysNoticeDao.findByTimeByFlag(stime,etime);
    }
}
