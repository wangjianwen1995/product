package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnQualitySuborder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//护理质量考核亚目
public interface HnQualitySuborderDao extends BaseDao<HnQualitySuborder> {

    @Select("select * from quality_suborder where category_id=${pid}")
    List<HnQualitySuborder> selectBypid(Integer pid);

}
