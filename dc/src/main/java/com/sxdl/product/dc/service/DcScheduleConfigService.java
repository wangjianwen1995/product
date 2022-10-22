package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcScheduleConfig;

import java.util.List;
import java.util.Map;

public interface DcScheduleConfigService extends BaseService<DcScheduleConfig> {


    List<DcScheduleConfig> findData(String flag);

    List<DcScheduleConfig> selectCanAutoRun(String info);

    List<DcScheduleConfig> selectByProduct(String id);

    List<DcScheduleConfig> findPzProduct();

    void insertOrupdate(Map<String, Object> map);

    List<DcScheduleConfig> selectBySingleId(String ids,String column,Integer is_single);

    List<DcScheduleConfig> selectSort(String ids,String singleId);

}
