package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmblsjDao;
import com.sxdl.hn.dao.dao1.HmnkvteDao;
import com.sxdl.hn.entity.Hmblsj;
import com.sxdl.hn.entity.Hmnkvte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmblsjService extends BaseServiceImpl<Hmblsj> {

    @Autowired
    private HmblsjDao hmblsjDao;

    public List<Hmblsj> selectByExample(Example example) {
        return hmblsjDao.selectByExample(example);
    }


}
