package com.sxdl.product.dc.service;

import cn.hutool.json.JSONArray;
import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcProcedure;

import java.util.List;

public interface DcProcedureService extends BaseService<DcProcedure> {


    //public void saveTableColumn(Integer product_id,String tableName,String tableName_zh);
    public void saveTableColumn(String product_id,String transfername,String dbname, String tableName, String tableName_zh,String type,Integer iscreateatdc,String etlptype);

    public void updateTable(DcProcedure dcProcedure);

    public List<DcProcedure> findByScheduleId(Integer Schedule_id);

    public void updateByPrimaryKeySelective(DcProcedure dcProcedure);


    public void saveMappingTable(DcProcedure dcProcedure);

    DcProcedure findByToNameAndType(DcProcedure dcProcedure);

    void saveMappingWBTable(List<DcProcedure> dcProcedures);

    List<DcProcedure> findByName(String str);
    public void saveAutoEverySql(JSONArray jsonArray) throws Exception;

    public void saveAutoEverySql2(JSONArray jsonArray);
    public void saveAutoEverySql3(JSONArray jsonArray);

    List<DcProcedure> selectByIds(String substring);
}
