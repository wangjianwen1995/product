package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcJob;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DcJobDao extends BaseUUIDDao<DcJob> {

    @Select("select * from dc_job where id in (${substring})")
    List<DcJob> selectByIds(String substring);
}