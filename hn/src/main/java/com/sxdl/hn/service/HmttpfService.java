package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmttpfDao;
import com.sxdl.hn.dao.dao1.HmwkvteDao;
import com.sxdl.hn.entity.Hmttpf;
import com.sxdl.hn.entity.Hmwkvte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmttpfService extends BaseServiceImpl<Hmttpf> {

    @Autowired
    private HmttpfDao hmttpfDao;

    public List<Hmttpf> selectByExample(Example example) {
        return hmttpfDao.selectByExample(example);
    }


}
