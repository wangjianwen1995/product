package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.dbo.KeyValueDBO;
import com.sxdl.product.dc.entity.DcTableVsTable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DcTableVsTableDao extends BaseUUIDDao<DcTableVsTable> {

    @Select( "select * from dc_table_vs_table where from_table_column_id='#{colId}' " )
    DcTableVsTable selectByColId(Integer colId);

    @Select( "select * from dc_table_vs_table where relation_replace_table_id='#{rid}' " )
    List<DcTableVsTable> selectByReplaceTableId(String rid);
    @Select( "select * from dc_table_vs_table where to_table_id='#{tid}' " )
    List<DcTableVsTable> selectByToTableId(String tid);

    @Select( "select distinct procedure_id keyid,b.name value  from dc_table_vs_table a  " +
            " left join dc_procedure b on a.procedure_id = b.id " +
            " where a.from_table_column_id='${id}' or a.to_table_column_id='${id}' " )
    List<KeyValueDBO> usedColumn(@Param(value = "id") String id);

}
