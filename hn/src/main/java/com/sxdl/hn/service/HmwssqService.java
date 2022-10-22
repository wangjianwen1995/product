package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmwkvteDao;
import com.sxdl.hn.dao.dao1.HmwssqDao;
import com.sxdl.hn.entity.Hmwkvte;
import com.sxdl.hn.entity.Hmwssq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmwssqService extends BaseServiceImpl<Hmwssq> {

    @Autowired
    private HmwssqDao hmwssqDao;

    public List<Hmwssq> selectByExample(Example example) {
        return hmwssqDao.selectByExample(example);
    }


}
