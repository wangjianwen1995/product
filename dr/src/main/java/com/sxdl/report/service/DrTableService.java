package com.sxdl.report.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.report.entity.DrTable;
import com.sxdl.report.entity.DrTemplate;

import java.util.LinkedHashMap;
import java.util.List;

public interface DrTableService extends BaseService<DrTable> {
    ResultUtil creatTableByLinkView(DrTable table);

    public void delete(Integer id);
    int EtlDRG(String type,DrTable table,String startTime,String endTime,String no);
    List<DrTable> findByTempId(Integer tempID);
    LinkedHashMap<String ,String >  fileDRGTemplate(LinkedHashMap map, DrTemplate templat,String keycol) throws Exception;
    List<DrTable> getDBZDate();


}
