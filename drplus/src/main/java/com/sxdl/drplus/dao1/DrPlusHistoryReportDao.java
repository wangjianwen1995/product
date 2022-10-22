package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.drplus.entity.DrPlusHistoryReport;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Deprecated
public interface DrPlusHistoryReportDao extends BaseDao<DrPlusHistoryReport> {


    @Select(" select * from drplus_history_report where drplus_platform_detailed_id = ${pid} " +
            " and convert(varchar(10),create_time,120) between '${stime}' and '${etime}' order by id desc ")
    List<DrPlusHistoryReport> getHistoryReportResult(Integer pid, String stime, String etime);
}
