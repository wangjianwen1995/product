package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmtspfDao;
import com.sxdl.hn.dao.dao1.HmttpfDao;
import com.sxdl.hn.entity.Hmtspf;
import com.sxdl.hn.entity.Hmttpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmtspfService extends BaseServiceImpl<Hmtspf> {

    @Autowired
    private HmtspfDao hmtspfDao;

    public List<Hmtspf> selectByExample(Example example) {
        return hmtspfDao.selectByExample(example);
    }


}
