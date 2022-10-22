package com.sxdl.ae.config;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.sxdl.ae.entity.AESummaryChild;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 *
 *
 * 处理 一对一 时候的数据
 */


public class AESummaryChildHandler extends BaseTypeHandler<List<AESummaryChild>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<AESummaryChild> parameter, JdbcType jdbcType) throws SQLException {
        if(StringUtils.isEmpty(parameter)){
            return;
        }

        JSONArray jsonArray =  JSONUtil.parseArray(parameter);
        ps.setString(i,jsonArray.toString());

    }

    @Override
    public List<AESummaryChild> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        //根据字段名在rs中获取字段值
        String jsonStr = rs.getString(columnName);
        if(StringUtils.isEmpty(jsonStr)||  !JSONUtil.isJsonArray(jsonStr)){
            return null;
        }
        JSONArray array = JSONUtil.parseArray(jsonStr);
        List<AESummaryChild> childList = JSONUtil.toList(array, AESummaryChild.class);
        return childList;
    }

    @Override
    public List<AESummaryChild> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        //根据字段名在rs中获取字段值
        String jsonStr = rs.getString(columnIndex);
        if(StringUtils.isEmpty(jsonStr)||  !JSONUtil.isJsonArray(jsonStr)){
            return null;
        }
        JSONArray array = JSONUtil.parseArray(jsonStr);
        List<AESummaryChild> childList = JSONUtil.toList(array, AESummaryChild.class);
        return childList;
    }

    @Override
    public List<AESummaryChild> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        //根据字段名在rs中获取字段值
        String jsonStr = cs.getString(columnIndex);
        if(StringUtils.isEmpty(jsonStr)||  !JSONUtil.isJsonArray(jsonStr)){
            return null;
        }
        JSONArray array = JSONUtil.parseArray(jsonStr);
        List<AESummaryChild> childList = JSONUtil.toList(array, AESummaryChild.class);
        return childList;
    }
}
