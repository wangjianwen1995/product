package com.sxdl.base.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.base.entity.SysLog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao extends BaseDao<SysLog> {
    @Select("${str}")
    List<SysLog> findByFactor(String toString);
    @Select("${str}")
    List<String> findSingleCol(String str);
}
