package com.sxdl.hn.dao.dao1;


import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnAcademicInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//档案:学术团体  academic_info
public interface HnAcademicInfoDao  extends BaseDao<HnAcademicInfo> {

    @Select(" select * from academic_info where pid = ${pid}")
    List<HnAcademicInfo> getDataByPid(Integer pid);

    @Delete(" delete from academic_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);




}
