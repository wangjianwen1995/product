package com.sxdl.product.dc.service;


import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcProcedure;
import com.sxdl.product.dc.entity.DcSchedule;

import java.util.List;
import java.util.Map;

public interface DcScheduleService extends BaseService<DcSchedule> {
    void updateStatus(DcSchedule dcSchedule, Map<Object, List<DcSchedule>> map, Integer ispy);

    void updateStatus1(DcSchedule dcSchedule, Map<Object, List<DcSchedule>> map);

    //返回规则绑定的id
    String createSchedule(String Procedure_id, Integer rule_id, Integer scope, String Hospital_id,
                          String Product_id, String webName, String tag, String type, String Procedure_name);

    String createSchedule(DcProcedure entity, String type);

    String updateSchedule(DcProcedure entity, String type);

    //修改规则的时候
    void updateSchedule(String scheduleid, Integer rule_id, String Procedure_id, Integer scope, String
            Hospital_id, String Product_id, String webName, String tag, String type, String Procedure_name);

    List<Map<String, Object>> selectBySome(String name, String stime, String etime, String type, String product_id);
}
