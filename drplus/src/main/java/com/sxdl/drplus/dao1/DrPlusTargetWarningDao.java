package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.drplus.entity.DrPlusTargetWarning;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DrPlusTargetWarningDao extends BaseDao<DrPlusTargetWarning> {


    @Select(" select * from drplus_target_warning where drplus_platform_detailed_id = ${pid} and name like '%${val}%'")
    List<DrPlusTargetWarning> getTargetList(Integer pid, String val);


    @Update(" update drplus_target_warning set isqy = ${onOff} where id = ${id}")
    void enableTarget(Integer id, Integer onOff);

    @Select("   ${sql}  ")
    Integer TestTarget(  String sql);
}
