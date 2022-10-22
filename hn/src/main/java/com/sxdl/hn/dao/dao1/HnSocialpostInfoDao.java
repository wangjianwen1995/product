package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnSocialpostInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//socialpost_info  社会兼职
public interface HnSocialpostInfoDao extends BaseDao<HnSocialpostInfo> {
    @Select(" select * from socialpost_info where pid = ${pid}")
    List<HnSocialpostInfo> getDataByPid(Integer pid);

    @Delete(" delete from socialpost_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);
}
