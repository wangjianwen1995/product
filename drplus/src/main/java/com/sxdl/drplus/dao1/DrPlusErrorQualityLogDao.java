package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.drplus.entity.DrPlusErrorQualityLog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrPlusErrorQualityLogDao extends BaseUUIDDao<DrPlusErrorQualityLog> {

    @Select(" select * from drplus_errorlog where drplus_platform_detailed_id = ${pid} and drplus_extract_detailed_id=${eid} ")
    List<DrPlusErrorQualityLog> drillDownError(Integer pid, String eid );

}
