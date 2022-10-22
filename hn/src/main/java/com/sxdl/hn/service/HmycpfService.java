package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmtspfDao;
import com.sxdl.hn.dao.dao1.HmycpfDao;
import com.sxdl.hn.entity.Hmtspf;
import com.sxdl.hn.entity.Hmycpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmycpfService extends BaseServiceImpl<Hmycpf> {

    @Autowired
    private HmycpfDao hmycpfDao;

    public List<Hmycpf> selectByExample(Example example) {
        return hmycpfDao.selectByExample(example);
    }


}
