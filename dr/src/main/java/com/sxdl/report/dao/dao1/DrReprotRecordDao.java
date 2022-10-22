package com.sxdl.report.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.report.entity.DrReprotRecord;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;

public interface DrReprotRecordDao extends BaseDao<DrReprotRecord>  {
    @Select("${str}")
    List<LinkedHashMap<String, Object>> getExcelData(String sql);
}
