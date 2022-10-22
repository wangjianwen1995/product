package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.drplus.entity.DrPlusStoredProcedure;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DrPlusStoredProcedureDao extends BaseDao<DrPlusStoredProcedure> {

    @Update("${sql}")
    void execProc(String sql);

    @Select(" select * from drplus_stored_procedure where drplus_platform_detailed_id=${pid} and (isnull(name,'') like '%${val}%' or isnull(namesql,'') like '%${val}%' )")
    List<DrPlusStoredProcedure> getStoredProcedureData(Integer pid, String val);
}
