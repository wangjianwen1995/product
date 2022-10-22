package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.HpBmVersion;
import org.apache.ibatis.annotations.Select;

public interface HpBmVersionDao extends BaseUUIDDao<HpBmVersion> {
    @Select("select top 1 * from  hp_bm_version b  where ison='1' and type=${type} ")
    HpBmVersion selectByStatus(String type);
}
