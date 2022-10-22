package com.sxdl.cf.dao.dao1;

import com.sxdl.cf.dao.BaseUUIDDao;
import com.sxdl.cf.entity.SysCustomerFormHeaderColumnEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysCustomerFormHeaderColumnDao extends BaseUUIDDao<SysCustomerFormHeaderColumnEntity> {


    @Select(" select * from sys_cf_headercolumn where facttable_id='${pid}' and (prop like '%${val}%' or label like '%${val}%' ) order by order_number" )
    List<SysCustomerFormHeaderColumnEntity> getTargetList(String pid, String val);




    @Delete(" delete from sys_cf_headercolumn where facttable_id='${pid}'")
    Integer deletebyPid(String pid);

    @Delete( " delete from sys_cf_headercolumn where facttable_id='${pid}' and prop = '${name}'")
    Integer deletebyPidAndName(String pid, String name);


    @Select( " select * from sys_cf_headercolumn where facttable_id='${pid}' and prop = '${name}'")
    SysCustomerFormHeaderColumnEntity getbyPidAndName(String pid, String name);

    @Select(" select * from sys_cf_headercolumn where facttable_id='${pid}' and isnull([type],'') in ('option','options','sql','sqls' ,'checkbox','radio')   " )
    List<SysCustomerFormHeaderColumnEntity> getoptionsList(String pid );



    @Select( " select [type]  from sys_cf_headercolumn where facttable_id='${pid}' and prop = '${name}' and isnull([type],'')!=''")
    String getTypebyPidAndName(String pid, String name);


    @Insert("${sql}")
    void insertBySql(@Param("sql") String sql);

    @Select("${sql}")
    String insertBackId(@Param("sql") String sql);
    @Delete("${sql}")
    void deleteBySql(@Param("sql") String sql);
}
