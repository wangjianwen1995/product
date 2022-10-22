package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnWorkexperienceInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// workexperience_info 工作经历
public interface HnWorkexperienceInfoDao   extends BaseDao<HnWorkexperienceInfo> {

    @Select(" select * from workexperience_info where pid = ${pid}")
    List<HnWorkexperienceInfo> getDataByPid(Integer pid);

    @Delete(" delete from workexperience_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);
}
