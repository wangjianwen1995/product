package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpClinicalPathwayDao;
import com.sxdl.hp.entity.HpClinicalPathway;
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
public class HpClinicalPathwayService extends BaseUUIDServiceImpl<HpClinicalPathway> {

    @Autowired
    HpClinicalPathwayDao hpClinicalPathwayDao;

    public List<HpClinicalPathway> selectByLikeName(HpClinicalPathway hpClinicalPathway)  {
        Class<? extends Object> class1 = hpClinicalPathway.getClass();
        Example example = new Example(class1);
        String name = hpClinicalPathway.getName();
        String status = hpClinicalPathway.getStatus();
        if (StringUtil.isNotEmpty(name)) {
            example.or().andLike("name", "%" + name + "%");
            example.or().andLike("user_name", "%" + name + "%");
            example.or().andLike("ks_name", "%" + name + "%");
            return hpClinicalPathwayDao.selectByExample(example);
        }
        return hpClinicalPathwayDao.selectAll();
    }

    /**
     * 查询状态时开启的数据,并转成下拉框需要的数据
     *
     * @return 下拉框中需要的数据
     */
    public List<Map<String, Object>> selectSelectsIfON() {
        List<Map<String, Object>> select = hpClinicalPathwayDao.selectSelectsIfON(),list=new ArrayList<>();
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

    //    @CachePut(cacheNames = "HpClinicalPathwayService.selectSelectsIfON")
    @Override
    public Integer insertSelective(HpClinicalPathway hpClinicalPathway) {
        return baseDao.insertSelective(hpClinicalPathway);
    }

    //    @CachePut(cacheNames = "HpClinicalPathwayService.selectSelectsIfON")
    @Override
    public Integer updateSelective(HpClinicalPathway hpClinicalPathway) {
        return super.updateSelective(hpClinicalPathway);
    }
}
