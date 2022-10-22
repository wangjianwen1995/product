package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.DrplusIndexRemindDao;
import com.sxdl.drplus.entity.DrplusIndexRemind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DrplusIndexService extends BaseServiceImpl<DrplusIndexRemind> {

    @Autowired
    private DrplusIndexRemindDao remindDao;

    public Integer isExists(String keyRuleStr) {
        return remindDao.isExists(keyRuleStr);
    }

    public void OffIndexRemind(Integer id,Integer states) {
       Integer i =  remindDao.OffIndexRemind(id,states);
    }

    public List<DrplusIndexRemind> getOnRemind() {
        DrplusIndexRemind r = new DrplusIndexRemind();
        r.setStates(0);
        return remindDao.select(r);
    }

    public void expireRemind(Integer id, Integer i) {
          OffIndexRemind(id,i);
    }

    public List<DrplusIndexRemind> getRemindData() {
        return remindDao.getRemindData();
    }
}
