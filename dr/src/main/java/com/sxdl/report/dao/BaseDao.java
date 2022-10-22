package com.sxdl.report.dao;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.SqlServerMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;

public interface BaseDao<T> extends BaseSelectMapper<T>,
        BaseUpdateMapper<T>,
        BaseDeleteMapper<T>,
        ExampleMapper<T>,
        RowBoundsMapper<T>,
        Marker, SqlServerMapper<T> {
}