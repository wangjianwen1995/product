package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.drplus.dto.PIODBO;
import com.sxdl.drplus.entity.DrplusJbicd;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrplusJbicdDao extends BaseUUIDDao<DrplusJbicd> {

    @Select(" select count(1) from drplus_jbicd where drplus_code_version_id =${pid}")
    Integer getCountBytype(Integer pid);

    @Select(" select * from drplus_jbicd where drplus_code_version_id =${pid} and ( name like '%${name}%'  or code like '%${name}%'  )order by code ")
    List<DrplusJbicd> getDetailedByPid(Integer pid, String name);


    @Select("${sql}")
    List<PIODBO> test(String sql);

    @Insert(" ${sqltext}")
    Integer saveImportDataICD(String sqltext);

    @Delete(" delete from drplus_jbicd where drplus_code_version_id =${pid}")
    Integer delByVersionId(Integer pid);



}
