package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HmddzcpfDao;
import com.sxdl.hn.dao.dao1.HmglhcpfDao;
import com.sxdl.hn.entity.Hmddzcpf;
import com.sxdl.hn.entity.Hmglhcpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
@Transactional
public class HmglhcpfService extends BaseServiceImpl<Hmglhcpf> {

    @Autowired
    private HmglhcpfDao hmglhcpfDao;

    public List<Hmglhcpf> selectByExample(Example example) {
        return hmglhcpfDao.selectByExample(example);
    }


}
