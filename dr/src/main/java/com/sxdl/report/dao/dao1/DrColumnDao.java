package com.sxdl.report.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.report.entity.DrColumn;
import org.apache.ibatis.annotations.Delete;

public interface DrColumnDao extends BaseDao<DrColumn> {
    @Delete("delete from dr_column where table_id = #{tableId}")
    void deleByPid(Integer tableId);


}
