package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnTrainingtalentsInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// trainingtalents_info 培养人才情况登记
public interface HnTrainingtalentsInfoDao  extends BaseDao<HnTrainingtalentsInfo> {

    @Select(" select * from trainingtalents_info where pid = ${pid}")
    List<HnTrainingtalentsInfo> getDataByPid(Integer pid);


    @Delete(" delete from trainingtalents_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);
}
