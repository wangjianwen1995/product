package com.sxdl.ae.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.base.select.SelectCountMapper;
import tk.mybatis.mapper.common.base.select.SelectOneMapper;

import java.util.LinkedHashMap;
import java.util.List;


public interface MapperDao<T> extends Mapper<T>, SelectOneMapper<T>, SelectCountMapper<T> {


    @Delete(" truncate table ${name} drop table ${name} ")
    void dropTable(@Param("name") String name);

    /**
     * 执行sql更新脚本
     *

     */
    @Update("${sql}")
    void execSqlText(@Param("sql") String sql);

    @Update("${sql}")
    Integer updateSql(@Param("sql") String sql);
    /**
     * 执行增加表中的数字(int)类型字段
     *
     * @param tableName 表名称
     * @param column    字段名称
     */
    @Update("alter table ${tableName} add ${column}   null")
    Integer addField(String tableName, String column);


    /**
     * 执行删除表中某个字段
     *
     * @param tableName  表名称
     * @param columnName 字段名称
     */
    @Update("alter table ${tableName} drop column ${columnName}")
    Integer delField(String tableName, String columnName);

    /**
     * 通过表名称获取表中的字段
     *
     * @param name 表名称
     */
    @Select("select stuff((SELECT ','+ convert(varchar(500),name)    FROM SYSCOLUMNS WHERE ID=OBJECT_ID('${name}' ) for xml path('')),1,1,'') ")
    String selectField(String name);





    @Select("${sql}")
    List<LinkedHashMap<String, Object>> selectListLinkedMap(@Param("sql") String sql);

    @Select("${sql}")
    List<T> selectListObj(@Param("sql") String sql);

    @Select("${sql}")
    String selectString(@Param("sql") String sql);

    @Select("${sql}")
    Integer selectInteger(@Param("sql") String sql);

    @Select("select  COUNT(1) from sysObjects where Id=OBJECT_ID(N'${name}') and xtype='U'")
    Integer existsTableByTableName(@Param("name") String name);
}
