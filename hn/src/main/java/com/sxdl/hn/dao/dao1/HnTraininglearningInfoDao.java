package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnTraininglearningInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//  traininglearning_info  培训学习记录
public interface HnTraininglearningInfoDao  extends BaseDao<HnTraininglearningInfo> {
    @Select(" select * from traininglearning_info where pid = ${pid}")
    List<HnTraininglearningInfo> getDataByPid(Integer pid);

    @Delete(" delete from traininglearning_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);
}
