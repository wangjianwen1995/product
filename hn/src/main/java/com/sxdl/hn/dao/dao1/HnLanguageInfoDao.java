package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnLanguageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//language_info 外语能力
public interface HnLanguageInfoDao  extends BaseDao<HnLanguageInfo> {


    @Select(" select * from language_info where pid = ${pid}")
    List<HnLanguageInfo> getDataByPid(Integer pid);

    @Delete(" delete from language_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);
}
