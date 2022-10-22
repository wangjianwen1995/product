package com.sxdl.product.dc.service;

import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.product.dc.entity.HpRzJzYy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HpRzJzYyService extends BaseUUIDServiceImpl<HpRzJzYy> {
    String sql;

    public List<HpRzJzYy> findByJZRZid(String id) throws Exception {
        if (StrUtil.isEmpty(id)) {
            return new ArrayList<>();
        }
        sql = "select * from hp_rz_jz_qjyy where rzjzid='" + id + "' order by wzqjyyName";
        return selectListWithSQL(sql, HpRzJzYy.class);
    }
}
