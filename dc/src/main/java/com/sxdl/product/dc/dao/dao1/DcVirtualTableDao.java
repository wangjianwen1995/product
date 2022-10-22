package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.dbo.KeyValueDBO;
import com.sxdl.product.dc.entity.DcVirtualTable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DcVirtualTableDao extends BaseUUIDDao<DcVirtualTable> {


    @Select( "select distinct a.procedure_id keyid,b.name value  " +
            " from dc_virtual_table a  " +
            " left join dc_procedure b on a.procedure_id = b.id " +
            " where a.relation_column_id='${id}' or a.son_column_id='${id}' " )
    List<KeyValueDBO> usedColumn(@Param(value = "id") String id);


}