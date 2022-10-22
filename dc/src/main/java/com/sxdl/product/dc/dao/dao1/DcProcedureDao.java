package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.dbo.KeyValueDBO;
import com.sxdl.product.dc.entity.DcProcedure;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DcProcedureDao extends BaseUUIDDao<DcProcedure> {

    @Select(value = "select * from dc_procedure where schedule_id='${ScheduleId}'")
    public List<DcProcedure> findByScheduleId(@Param(value = "ScheduleId") Integer ScheduleId );

    @Select("${str}")
    List<DcProcedure> findByName(@Param(value = "str") String str);

    @Select(value = "select distinct id keyid,name value from dc_procedure where where_sql like '${colname}'")
    List<KeyValueDBO> usedColumn(@Param(value = "colname") String colname);
    @Select(value = "select * from dc_procedure where id in(${substring})")
    List<DcProcedure> selectByIds(String substring);
    @Select(value = "select * from dc_procedure where job_id='${id}'")
    List<DcProcedure> selectByJobId(String id);
}
