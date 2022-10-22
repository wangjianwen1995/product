package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmycpfDao;
import com.sxdl.hn.dao.dao1.HmzlnlpfDao;
import com.sxdl.hn.entity.Hmycpf;
import com.sxdl.hn.entity.Hmzlnlpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmzlnlpfService extends BaseServiceImpl<Hmzlnlpf> {

    @Autowired
    private HmzlnlpfDao hmzlnlpfDao;

    public List<Hmzlnlpf> selectByExample(Example example) {
        return hmzlnlpfDao.selectByExample(example);
    }


}
