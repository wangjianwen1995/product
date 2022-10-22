package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcDataSource;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DcDataSourceDao extends BaseUUIDDao<DcDataSource> {

    @Select("select * from dc_data_source where name like'%${name}%' or name_zh like '%${name}%'")
    List<DcDataSource> findByCondition(String name);

}
