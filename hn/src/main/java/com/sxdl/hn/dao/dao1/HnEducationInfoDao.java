package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnEducationInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//education_info  学历信息
public interface HnEducationInfoDao  extends BaseDao<HnEducationInfo> {


    @Select(" select * from education_info where pid = ${pid}")
    List<HnEducationInfo> getDataByPid(Integer pid);

    @Delete(" delete from education_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);
}
