package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hpqc.entity.HpQcZhEntity;
import org.apache.ibatis.annotations.Select;

public interface HpQcZhDao extends BaseUUIDDao<HpQcZhEntity> {
    @Select("SELECT max(${column}) FROM ${tablename} ")
    Integer findSysMaxOrdernum(String column,String tablename);
}
