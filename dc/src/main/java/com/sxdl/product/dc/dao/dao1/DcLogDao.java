package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcEtlLog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DcLogDao extends BaseUUIDDao<DcEtlLog> {

    @Select("${str}")
    List<DcEtlLog> findByFactor(String str);

    @Select("${sql}")
    String execSelectSql(String sql);

}