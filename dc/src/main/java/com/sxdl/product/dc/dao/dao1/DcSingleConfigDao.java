package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcSingleConfig;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DcSingleConfigDao extends BaseUUIDDao<DcSingleConfig> {


    @Select("select * from dc_single_config where Product_id in (${id})")
    List<DcSingleConfig> selectByProductIds(String ids);
}