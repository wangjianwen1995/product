package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnQualitydetails;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//护理质量考核细目
public interface HnQualitydetailsDao extends BaseDao<HnQualitydetails> {

    @Select("select * from quality_details where suborder_id = ${pid}")
    List<HnQualitydetails> findBySuborderId(Integer pid);
}
