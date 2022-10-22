package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcSchedule;
import org.apache.ibatis.annotations.Select;


public interface DcScheduleDao extends BaseUUIDDao<DcSchedule> {
    @Select("select max(ordernum) from dc_schedule")
    public Integer getMaxOrdernum();
}