package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpYygrDao;
import com.sxdl.hp.entity.HpYygr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class HpYygrService extends BaseUUIDServiceImpl<HpYygr> {

    @Autowired
    HpYygrDao hpYygrDao;

    public List<HpYygr> selectByLikeName(HpYygr hpYygr)  {
        Class<? extends Object> class1 = hpYygr.getClass();
        Example example = new Example(class1);
        String name = hpYygr.getName();
        String status = hpYygr.getStatus();
        if (StringUtil.isNotEmpty(name)) {
            example.or().andLike("name", "%" + name + "%");
            example.or().andLike("user_name", "%" + name + "%");
            example.or().andLike("ks_name", "%" + name + "%");
            return hpYygrDao.selectByExample(example);
        }
        return hpYygrDao.selectAll();
    }
}
