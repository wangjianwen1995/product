package com.sxdl.hn.dao.dao1;


import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnAssessmentInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//考核登记  assessment_info
public interface HnAssessmentInfoDao extends BaseDao<HnAssessmentInfo> {


    @Select(" select * from assessment_info where pid = ${pid}")
    List<HnAssessmentInfo> getDataByPid(Integer pid);

    @Delete(" delete from assessment_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);


}
