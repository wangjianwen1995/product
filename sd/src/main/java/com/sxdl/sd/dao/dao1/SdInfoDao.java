package com.sxdl.sd.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.sd.entity.SdInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SdInfoDao extends BaseDao<SdInfo> {

    @Select("select * from sd_info ORDER BY group_id ")
    List<SdInfo> findAllSd();
}
