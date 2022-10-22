package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hp.entity.HomepageEntity;
import org.apache.ibatis.annotations.Select;

public interface HpHomepageDao extends BaseUUIDDao<HomepageEntity> {

    @Select(" select * from homepage where A_id = '${Aid}'   ")
    HomepageEntity selectByAid(String Aid);

    @Select(" select id from homepage where A_id = '${id}'   ")
    String selectHid(String id);

    @Select(" select id from vsch0a where ch0a01 = '${id}'   ")
    String selectAid(String id);
}
