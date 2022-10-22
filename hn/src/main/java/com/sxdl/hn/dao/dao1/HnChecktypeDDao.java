package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnChecktypeD;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HnChecktypeDDao extends BaseDao<HnChecktypeD> {

    @Delete("delete from checktype_d  where assessment_id = ${pid}")
    Integer deleteByPid(Integer pid);

    @Select("select *  from checktype_d  where assessment_id = ${pid}")
    List<HnChecktypeD> findByPid(Integer pid);
}
