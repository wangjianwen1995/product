package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.drplus.entity.DrPlusHistoryUpdate;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrPlusHistoryUpdateDao extends BaseDao<DrPlusHistoryUpdate> {



    @Select("select * from drplus_history_update where drplus_platform_detailed_id =${pid} and primarykey_val ='${bah}' order by update_time desc")
    List<DrPlusHistoryUpdate> getPatientOneHistoryUpdate(Integer pid, String bah);





}
