package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.drplus.entity.SysScheduleTaskEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface SysScheduleTaskDao extends BaseUUIDDao<SysScheduleTaskEntity> {

    @Select("${sql}")
    List<ConcurrentHashMap<String, Object>> getListConcurrentHashMap(String sql);
}
