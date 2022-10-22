package com.sxdl.hr.dao.dao2;

import com.sxdl.base.dao.BaseDao;

import com.sxdl.hr.entity.Handle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface HandleDao extends BaseDao<Handle> {

    @Update("${sql}")
    int excuteSqlWithSQL(String sql);
}
