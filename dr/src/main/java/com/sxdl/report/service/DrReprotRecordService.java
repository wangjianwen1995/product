package com.sxdl.report.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.report.entity.DrReprotRecord;

import java.util.LinkedHashMap;
import java.util.List;

public interface DrReprotRecordService extends BaseService<DrReprotRecord> {


    List<LinkedHashMap<String,Object>> getExcelData(String sql);


}
