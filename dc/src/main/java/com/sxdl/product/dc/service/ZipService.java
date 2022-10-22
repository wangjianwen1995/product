package com.sxdl.product.dc.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.product.dc.dao.dao1.AreaZipDao;
import com.sxdl.product.dc.entity.HpAreaZip;
import com.sxdl.product.dc.util.DcApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ZipService extends BaseServiceImpl<HpAreaZip> {


    @Autowired
    private AreaZipDao areaZipDao;

    public Integer save(HpAreaZip hpAreaZip) {
        int insert;
        if (StringUtils.isEmpty(hpAreaZip.getId())) {
            insert = areaZipDao.insert(hpAreaZip);
            List<HpAreaZip> hpAreaZips = areaZipDao.selectAll();
            DcApplicationRunnerImpl.contextMap.put("areaZip", hpAreaZips);
        } else {
            insert = areaZipDao.updateByPrimaryKey(hpAreaZip);
            List<HpAreaZip> hpAreaZips = areaZipDao.selectAll();
            DcApplicationRunnerImpl.contextMap.put("areaZip", hpAreaZips);
        }

        return insert;
    }

    public Integer updateState(Integer id, Integer isoff) {

        HpAreaZip hpAreaZip = areaZipDao.selectByPrimaryKey(id);
        hpAreaZip.setIsoff(isoff);
        Integer insert = areaZipDao.updateByPrimaryKey(hpAreaZip);
        List<HpAreaZip> hpAreaZips = areaZipDao.selectAll();
        DcApplicationRunnerImpl.contextMap.put("areaZip", hpAreaZips);
        return insert;
    }

    public List<HpAreaZip> findCityByProId(String parent_code) {
        List<HpAreaZip> areaZipList = (List<HpAreaZip>) DcApplicationRunnerImpl.contextMap.get("areaZip");
        return areaZipList.stream().filter(e -> "3".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
    }

    public List<HpAreaZip> findCountyByCityId(String parent_code) {
        List<HpAreaZip> areaZipList = (List<HpAreaZip>) DcApplicationRunnerImpl.contextMap.get("areaZip");
        return areaZipList.stream().filter(e -> "4".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
    }
}