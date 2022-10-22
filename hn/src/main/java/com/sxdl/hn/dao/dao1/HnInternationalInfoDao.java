package com.sxdl.hn.dao.dao1;


import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnInternationalInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//international_info 出国短期学习、考察及参加国际学术活动等情况
public interface HnInternationalInfoDao extends BaseDao<HnInternationalInfo> {


    @Select(" select * from international_info where pid = ${pid}")
    List<HnInternationalInfo> getDataByPid(Integer pid);

    @Delete(" delete from international_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);
}
