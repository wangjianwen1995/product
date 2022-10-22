package com.sxdl.sd.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.sd.entity.SysNotice;

import java.util.List;

public interface SysNoticeService extends BaseService<SysNotice> {
    List<SysNotice> findByTime(String stime, String etime);

    List<SysNotice> findByTimeByFlag(String stime, String etime);
}
