package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnChecktypeA;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HnChecktypeADao extends BaseDao<HnChecktypeA> {

    @Delete("delete from checktype_a  where assessment_id = ${pid}")
    Integer deleteByPid(Integer pid);

    @Select("select *  from checktype_a  where assessment_id = ${pid}")
    List<HnChecktypeA> findByPid(Integer pid);

}
