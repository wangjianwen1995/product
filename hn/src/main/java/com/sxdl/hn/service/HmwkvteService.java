package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmsssycDao;
import com.sxdl.hn.dao.dao1.HmwkvteDao;
import com.sxdl.hn.entity.Hmsssyc;
import com.sxdl.hn.entity.Hmwkvte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmwkvteService extends BaseServiceImpl<Hmwkvte> {

    @Autowired
    private HmwkvteDao hmwkvteDao;

    public List<Hmwkvte> selectByExample(Example example) {
        return hmwkvteDao.selectByExample(example);
    }


}
