package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcRequestAPI;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DcRequestAPIDao extends BaseUUIDDao<DcRequestAPI> {
    @Select ( "select * from dc_request_api where schedule_ids='#{id}' " )
    List<DcRequestAPI> selectRequestBySid(String id);
    @Select ( "select * from dc_request_api where id in (${substring}) " )
    List<DcRequestAPI> selectByIds(String substring);
    /*@Delete("delete  from dc_table where name =#{name}")
    List<DcTable> deleteTable(String name);*/

    /*@Delete("delete  from dc_column where table_name =#{tableName}")
    List<DcTable> deleteTable(String name);*/
}