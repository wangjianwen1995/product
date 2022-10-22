package com.sxdl.product.dc.dao.dao2;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.product.dc.entity.SysKs;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysKsDao extends BaseDao<SysKs> {

    @Select("${sql}")
    List<SysKs> findBysql(String sql);
}
