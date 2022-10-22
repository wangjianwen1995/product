package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.drplus.entity.DrPlusControlLjx;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrPlusControlLjxDao extends BaseDao<DrPlusControlLjx> {

    @Select(" select  *  from drplus_control_ljx   " +
            " where  drplus_platform_detailed_id=${pid} and(  result_message like '%${val}%' or sql like '%${val}%')")
    List<DrPlusControlLjx> getLjxData(Integer pid, String val);
}
