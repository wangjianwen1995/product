package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpMidTableEntity;
import org.apache.ibatis.annotations.Select;

public interface HpMidTableDao extends BaseDao<HpMidTableEntity> {
    @Select("select id from hp_mid_table where bah='${id}'")
    String findIDByBah(String bah);
}
