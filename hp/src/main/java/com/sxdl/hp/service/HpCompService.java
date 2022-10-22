package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpCompDao;
import com.sxdl.hp.entity.HpComp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpCompService extends BaseUUIDServiceImpl<HpComp> {

    @Autowired
    HpCompDao hpCompDao;

    public List<HpComp> selectByLikeName(HpComp hpComp)  {
        Class<? extends Object> class1 = hpComp.getClass();
        Example example = new Example(class1);
        String name = hpComp.getName();
        String status = hpComp.getStatus();
        if (StringUtil.isNotEmpty(name)) {
            example.or().andLike("name", "%" + name + "%");
            example.or().andLike("user_name", "%" + name + "%");
            example.or().andLike("ks_name", "%" + name + "%");
            return hpCompDao.selectByExample(example);
        }
        return hpCompDao.selectAll();
    }

    /**
     * 查询病案山西附页并发症下拉框
     *
     * @return 结构化数据
     */
    public List<Map<String, Object>> selectSelectsIfON()  {
        List<Map<String, Object>> select = hpCompDao.selectSelectsIfON(),list=new ArrayList<>();
        if(CollUtil.isEmpty(select)){
            return select;
        }
        select.stream().collect(Collectors.groupingBy(e -> e.get("ks_name")))
                .forEach((k, v) -> {
                    Map<String, Object> map = new HashMap();
                    map.put("ks", k);
                    map.put("xl", v);
                    list.add(map);
                });
        return list;
    }
}
