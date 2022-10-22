package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnChecktypeC;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface HnChecktypeCDao extends BaseDao<HnChecktypeC> {
    @Delete("delete from checktype_c  where assessment_id = ${pid}")
    Integer deleteByPid(Integer pid);


    @Select("select *  from checktype_c  where assessment_id = ${pid}")
    HnChecktypeC findByPid(Integer pid);
}
