package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hpqc.entity.DrPlusControlWzx;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrPlusControlWzxDao extends BaseDao<DrPlusControlWzx> {


    @Select(" select  * from drplus_control_wzx  " +
            " where  drplus_platform_detailed_id = ${pid} and  ( result_message like '%${val}%' or sql like '%${val}%')")
    List<DrPlusControlWzx> getWzxData(Integer pid, String val);
}
