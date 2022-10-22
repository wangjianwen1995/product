package com.sxdl.fm.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.fm.entity.HbiWlfkh;
import com.sxdl.fm.service.HbiWlfkhService;
import org.springframework.stereotype.Service;

@Service
public class HbiWlfkhServiceImpl extends BaseServiceImpl<HbiWlfkh> implements HbiWlfkhService {
    @Override
    public void insertSQL(HbiWlfkh hbikh) {
        String sql=" insert into W_lf_khdy (xh,dm,mc) values('"+hbikh.getXh()+"','"+hbikh.getDm()+"','"+hbikh.getMc()+"') ";
        System.out.println(sql);
        baseDao.updateSqlWithSQL(sql);
    }
}
