package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnChecktypeE;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface HnChecktypeEDao extends BaseDao<HnChecktypeE> {
    @Delete("delete from checktype_e  where assessment_id = ${pid}")
    Integer deleteByPid(Integer pid);



    @Select("select *  from checktype_e  where assessment_id = ${pid}")
    HnChecktypeE findByPid(Integer pid);
}
