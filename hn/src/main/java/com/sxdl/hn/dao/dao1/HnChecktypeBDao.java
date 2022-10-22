package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnChecktypeB;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface HnChecktypeBDao extends BaseDao<HnChecktypeB> {
    @Delete("delete from checktype_b  where assessment_id = ${pid}")
    Integer deleteByPid(Integer pid);



    @Select("select *  from checktype_b  where assessment_id = ${pid}")
    HnChecktypeB findByPid(Integer pid);
}
