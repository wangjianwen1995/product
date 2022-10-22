package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcDictMap;

import java.util.List;
import java.util.Map;

public interface DcDictMapService extends BaseService<DcDictMap> {


    public List<DcDictMap> findDataByHisCodeAndColId(String his_code, String col_id) ;
    public Map<String, Object> operationMappingDictData(Map<String, Object> map,String hiscode);
    public Map<String, Object> operationMappingDictDataAtoa(Map<String, Object> map,String hiscode);
    public Integer save(DcColumn dcColumn);
}
