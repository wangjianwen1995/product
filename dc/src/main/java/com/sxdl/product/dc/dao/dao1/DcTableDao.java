package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DcTableDao extends BaseUUIDDao<DcTable> {

    @Select("select * from dc_table where name='${name}' ")
    DcTable selectByName(String name);

    @Select("select * from dc_table where name='${name}' and product_id ='${pid}'")
    DcTable selectByNameAndProdectID(String name, String pid);

    @Select("select * from dc_table where name='${name}' and product_id in ('${pid1}','${pid2}') ")
    List<DcTable> selectByNameAndProdect(@Param("name") String name, @Param("pid1") String pid1, @Param("pid2") String pid2);

    @Select("select * from dc_table where name='${name}' ")
    List<DcTable> selectByName2(String name);

    @Select("SELECT  distinct rtrim(ltrim(${fcolumns}))   FROM ${ftable_name}  ")
    List<String> selectBySome(String ftable_name, String fcolumns);

    @Delete("delete from dc_table where id = '${to_table_id}' and product_id='${product_id}'")
    void deleteByTableId(String to_table_id,String product_id);
}
