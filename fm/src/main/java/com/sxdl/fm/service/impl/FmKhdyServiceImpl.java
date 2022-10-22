package com.sxdl.fm.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.fm.entity.FmKhdy;
import com.sxdl.fm.entity.HbiWlfkh;
import com.sxdl.fm.service.FmKhdyService;
import com.sxdl.fm.service.HbiWlfkhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FmKhdyServiceImpl extends BaseServiceImpl<FmKhdy> implements FmKhdyService {
    @Autowired
    HbiWlfkhService hbiWlfkhService;
    HbiWlfkh hbikh;
    FmKhdy khdy;
    List<FmKhdy> khdies;
    List<HbiWlfkh> hbiWlfkhs;
    @Override
    public Integer insert(FmKhdy fmKhdy) {
        khdy=new FmKhdy();
        khdy.setName(fmKhdy.getName());
        int size = baseDao.select(khdy).size();
        if(size>0) return -1;
        int insert = baseDao.insertSelective(fmKhdy);
        synchUpdate();
        return insert;
    }
    @Override
    public Integer update(FmKhdy fmKhdy) {
        int update = baseDao.updateByPrimaryKey(fmKhdy);
        synchUpdate();
        return update;
    }

    /**
     * 同步更新HBI中的考核单元维表数据
     */
    Map<String, List<FmKhdy>> stringListMap;
    Map<String, List<HbiWlfkh>> stringListMapHbi;
    public void synchUpdate(){
        khdies = baseDao.selectAll();
        stringListMap= khdies.stream().collect(Collectors.groupingBy(FmKhdy::getName));
        hbiWlfkhs = hbiWlfkhService.findAll();
        stringListMapHbi= hbiWlfkhs.stream().collect(Collectors.groupingBy(HbiWlfkh::getDm));
        stringListMap.keySet().stream().filter(e->!stringListMapHbi.containsKey(e)).forEach(e->{
            hbikh=new HbiWlfkh();
            khdy=stringListMap.get(e).get(0);
            hbikh.setXh(khdy.getId()+"");
            hbikh.setDm(khdy.getName());
            hbikh.setMc(khdy.getName());
            hbiWlfkhService.insertSQL(hbikh);
        });
    }
}
