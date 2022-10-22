package com.sxdl.hn.dao.dao1;


import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnMaintechnologyInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// maintechnology_info  担任过得主要技术工作
public interface HnMaintechnologyInfoDao  extends BaseDao<HnMaintechnologyInfo> {
    @Select(" select * from maintechnology_info where pid = ${pid}")
    List<HnMaintechnologyInfo> getDataByPid(Integer pid);

    @Delete(" delete from maintechnology_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);
}
