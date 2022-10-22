package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hpqc.dbo.DrQualityDBO;
import com.sxdl.hpqc.entity.DrPlusControlBzx;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrPlusControlBzxDao extends BaseDao<DrPlusControlBzx> {


    @Select(" select  *     from drplus_control_bzx   " +
            " where  drplus_platform_detailed_id = ${pid} and ( result_message like '%${val}%' or sql like '%${val}%')")
    List<DrPlusControlBzx> getBzxData(Integer pid, String val);

    @Select(" select  * , 1 as type from drplus_control_bzx   " +
            " where drplus_platform_detailed_id = ${pid} and isnull(isqy,0)=1 " +
            "    union all" +
            " select * ,2 as type from drplus_control_wzx   " +
            " where drplus_platform_detailed_id = ${pid} and isnull(isqy,0)=1 " +
            "    union all" +
            " select  * ,3 as type from drplus_control_ljx   " +
            " where drplus_platform_detailed_id = ${pid} and isnull(isqy,0)=1 "
    )
    List<DrQualityDBO> getQualityData(Integer pid);




}
