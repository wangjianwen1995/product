package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.drplus.entity.DrplusSsicd;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrplusSsicdDao extends BaseUUIDDao<DrplusSsicd> {

    @Select(" select count(1) from drplus_ssicd where drplus_code_version_id =${pid}")
    Integer getCountBytype(Integer pid);

    @Select(" select * from drplus_ssicd where drplus_code_version_id =${pid}  and ( name like '%${val}%'  or code like '%${val}%'  ) order by code  ")
    List<DrplusSsicd> getDetailedByPid(Integer pid, String val);

    @Insert(" ${sqltext}")
    Integer saveImportDataICD(String sqltext);

    @Delete(" delete from drplus_ssicd where  drplus_code_version_id =${pid} ")
    Integer delByVersionId(Integer pid);
}
