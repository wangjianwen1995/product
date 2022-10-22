package com.sxdl.base.service.impl;

import com.sxdl.base.dao.dao1.SysDictValDao;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.ApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("SysDictValService")
@Transactional
public class SysDictValServiceImpl extends BaseServiceImpl<SysDictVal> implements SysDictValService {
    @Autowired
    private SysDictValDao dcDitValDao;

    @Override
    public void updateAppDcDitVal() {
        //符合 国家标准的字典表类型
        List<SysDictVal> dcDitVals = dcDitValDao.selectAll();
        Map<Integer, List<SysDictVal>> dvOnMap, dvAllMap;
        dvOnMap = dcDitVals.stream().filter(e -> null != e && e.getIs_on() == 1).collect(Collectors.groupingBy(e -> e.getDict_id()));
        dvAllMap = dcDitVals.stream().filter(e -> null != e).collect(Collectors.groupingBy(e -> e.getDict_id()));
        ApplicationRunnerImpl.contextMap.put("dvAllMap", dvAllMap);
        ApplicationRunnerImpl.contextMap.put("dvOnMap", dvOnMap);

    }

    @Override
    public void insertDV(SysDictVal dcDitVal) {
        dcDitValDao.insertSelective(dcDitVal);
        updateAppDcDitVal();
    }

    /**
     * 根据字典表id查询字典数据
     *
     * @param tableid
     * @return
     */
    @Override
    public List<SysDictVal> findDictValsByTableId(Integer tableid) {
        List<SysDictVal> dicts = ((Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("dvAllMap")).get(tableid);
        dicts.sort(Comparator.comparing(SysDictVal::getName));
        return dicts;
    }

    @Override
    public void updateByPrimaryKeySelective(SysDictVal dcDitVal) {
        dcDitValDao.updateByPrimaryKeySelective(dcDitVal);
        updateAppDcDitVal();
    }


    public List<SysDictVal> getDictionariesByName(String dictName, String val) {
        return dcDitValDao.getDictionariesByName(dictName, val);
    }

    public List<SysDictVal> getDictionariesByNameMuch(String dictNames) {
        return dcDitValDao.getDictionariesByNameMuch(dictNames);
    }

    public List<SysDictVal> getDictionariesBySourceNameMuch(String sourceName) {
        return dcDitValDao.getDictionariesBySourceNameMuch(sourceName);
    }
}
