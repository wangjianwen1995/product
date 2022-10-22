package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmRyhzpgbDao;
import com.sxdl.hn.dao.dao1.HmsssycDao;
import com.sxdl.hn.entity.HmRyhzpgb;
import com.sxdl.hn.entity.Hmsssyc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmsssycService extends BaseServiceImpl<Hmsssyc> {

    @Autowired
    private HmsssycDao hmsssycDao;

    public List<Hmsssyc> selectByExample(Example example) {
        return hmsssycDao.selectByExample(example);
    }


}
