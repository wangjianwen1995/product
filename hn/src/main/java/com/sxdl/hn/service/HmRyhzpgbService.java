package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmRyhzpgbDao;
import com.sxdl.hn.dao.dao1.HmblsjDao;
import com.sxdl.hn.entity.HmRyhzpgb;
import com.sxdl.hn.entity.Hmblsj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmRyhzpgbService extends BaseServiceImpl<HmRyhzpgb> {

    @Autowired
    private HmRyhzpgbDao ryhzpgbDao;

    public List<HmRyhzpgb> selectByExample(Example example) {
        return ryhzpgbDao.selectByExample(example);
    }


}
