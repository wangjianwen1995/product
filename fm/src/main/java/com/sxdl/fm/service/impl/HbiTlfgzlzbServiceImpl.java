package com.sxdl.fm.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.fm.dao.dao2.HbiTlfgzlzbDao;
import com.sxdl.fm.entity.HbiTlfgzlzb;
import com.sxdl.fm.service.HbiTlfgzlzbService;
import com.sxdl.fm.util.app.FmAllTwenty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HbiTlfgzlzbServiceImpl extends BaseServiceImpl<HbiTlfgzlzb> implements HbiTlfgzlzbService {
    @Autowired
    HbiTlfgzlzbDao hbiTlfgzlzbDao;
    String sql;
    HbiTlfgzlzb hbiTlfgzlzb;
    @Override
    public void insertSome(List<FmAllTwenty> list, String time) {
        if (list == null || list.size () < 0) {
            return;
        }
        sql=" DELETE from T_lf_gzlzb where creattime BETWEEN '"+time+"' and '"+time+"' ";
        hbiTlfgzlzbDao.updateSqlWithSQL(sql);
        list.forEach ( e -> {
            hbiTlfgzlzb = new HbiTlfgzlzb ();
            hbiTlfgzlzb.setYs ( e.getYs () );
            hbiTlfgzlzb.setKs ( e.getKs () );
            hbiTlfgzlzb.setKh ( e.getKh () );
            hbiTlfgzlzb.setCreattime ( time );
//            List<HbiTlfgzlzb> hbiTlfgzlzbs = hbiTlfgzlzbDao.select ( hbiTlfgzlzb );
//            if (hbiTlfgzlzbs != null && hbiTlfgzlzbs.size () >=1) {
//                HbiTlfgzlzb hbiTlfgzlzb1 = hbiTlfgzlzbs.get ( 0 );
//                HbiTlfgzlzb hbiTlfgzlzb2 = setNew ( hbiTlfgzlzb1, e );
//                hbiTlfgzlzbDao.updateByPrimaryKeySelective ( hbiTlfgzlzb2 );
//            } else{
            hbiTlfgzlzb= setNew ( hbiTlfgzlzb, e );
            hbiTlfgzlzbDao.insertSelective ( hbiTlfgzlzb );
//            }
        } );
    }

    private HbiTlfgzlzb  setNew(HbiTlfgzlzb hbiTlfgzlzb, FmAllTwenty e){
        hbiTlfgzlzb.setDy3h ( Float.parseFloat ( e.getDy3h () ) );
        hbiTlfgzlzb.setJrssls ( Float.parseFloat ( e.getJrssls () ) );
        hbiTlfgzlzb.setJzssls ( Float.parseFloat ( e.getJzssls () ) );
        hbiTlfgzlzb.setMjzrs ( Float.parseFloat ( e.getMjzrs () ) );
        hbiTlfgzlzb.setSjssls ( Float.parseFloat ( e.getSjssls () ) );
        hbiTlfgzlzb.setSsbfzls ( Float.parseFloat ( e.getSsbfzls () ) );
        hbiTlfgzlzb.setSscs ( Float.parseFloat ( e.getSscs () ) );
        hbiTlfgzlzb.setSzrs ( Float.parseFloat ( e.getSzrs () ) );
        hbiTlfgzlzb.setWcssls ( Float.parseFloat ( e.getWcssls () ) );
        hbiTlfgzlzb.setXy1h ( Float.parseFloat ( e.getXy1h () ) );
        hbiTlfgzlzb.setYlqkgrls ( Float.parseFloat ( e.getYlqkgrls () ) );
        hbiTlfgzlzb.setYlqkshls ( Float.parseFloat ( e.getYlqkshls () ) );
        hbiTlfgzlzb.setZ1d3h ( Float.parseFloat ( e.getZ1d3h () ) );
        hbiTlfgzlzb.setYzssls ( Float.parseFloat ( e.getYzssls () ) );
        hbiTlfgzlzb.setZdssls ( Float.parseFloat ( e.getZdssls () ) );
        hbiTlfgzlzb.setZlczls ( Float.parseFloat ( e.getZlczls () ) );
        hbiTlfgzlzb.setZqssls ( Float.parseFloat ( e.getZqssls () ) );
        return hbiTlfgzlzb;
    }
}
