package com.sxdl.sd.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.SdInfoSourceDao;
import com.sxdl.sd.entity.SdInfoSource;
import com.sxdl.sd.service.SdInfoSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("sdInfoSourceService")
@Transactional
public class SdInfoSourceServiceImpl extends BaseServiceImpl<SdInfoSource> implements SdInfoSourceService {
    @Autowired
    SdInfoSourceDao sdInfoSourceDao;

    @Override
    public List<SdInfoSource> finByName(String name, String cdate, String edate) {
        List<SdInfoSource> list = new ArrayList<> ();
        SimpleDateFormat myFmt = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss " );
        Calendar instance = Calendar.getInstance ();
        if (null == edate || "".equals ( edate )) {
            edate = myFmt.format ( instance.getTime () );
        }
        if (null == cdate || "".equals ( cdate )) {
            instance.add ( Calendar.DAY_OF_YEAR, -10 );
            cdate = myFmt.format ( instance.getTime () );
        }
        cdate = "'" + cdate + "'";
        edate = "'" + edate + "'";
        if (null == name || "".equals ( name )) {
            list = sdInfoSourceDao.findByTime ( cdate, edate );
        } else {
            name = "'" + name + "%'";
            list = sdInfoSourceDao.findByTimeAndName ( cdate, edate, name );
        }
        return null != list && list.size () > 0 ? list : null;
    }
}
