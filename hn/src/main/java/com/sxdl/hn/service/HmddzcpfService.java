package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmddzcpfDao;
import com.sxdl.hn.dao.dao1.HmzlnlpfDao;
import com.sxdl.hn.entity.Hmddzcpf;
import com.sxdl.hn.entity.Hmzlnlpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmddzcpfService extends BaseServiceImpl<Hmddzcpf> {

    @Autowired
    private HmddzcpfDao hmddzcpfDao;

    public List<Hmddzcpf> selectByExample(Example example) {
        return hmddzcpfDao.selectByExample(example);
    }


}
