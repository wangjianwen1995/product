package com.sxdl.hn.dao.dao1;


import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnMainexperienceInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//mainexperience_info 主要经历
public interface HnMainexperienceInfoDao  extends BaseDao<HnMainexperienceInfo> {


    @Select(" select * from mainexperience_info where pid = ${pid}")
    List<HnMainexperienceInfo> getDataByPid(Integer pid);

    @Delete(" delete from mainexperience_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);
}
