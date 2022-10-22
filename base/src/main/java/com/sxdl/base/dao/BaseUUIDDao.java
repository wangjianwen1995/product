package com.sxdl.base.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.base.select.SelectCountMapper;
import tk.mybatis.mapper.common.base.select.SelectOneMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public interface BaseUUIDDao<T> extends Mapper<T>, SelectOneMapper<T>, SelectCountMapper<T> {


/*    @Options(useGeneratedKeys = true,keyProperty = "id")
    @InsertProvider(type = SqlServerProvider.class, method = "dynamicSQL")
    int insert(T record);*/

    /**
     * 执行通用的更新相关的sql
     *
     * @param sql 如题
     */
    @Update("${sql}")
    int updateSqlWithSQL(String sql);

    @Delete("${sql}")
    int deleteSqlWithSQL(String sql);

    /**
     * 执行通用的查询相关的sql
     *
     * @param sql 如题
     */
    @Select("${sql}")
    List<Map<String, Object>> selectSqlWithSQL(String sql);

    @Select("${sql}")
    List selectOneColumnWithSQL(String sql);

    /**
     * 执行增加表中的数字(int)类型字段
     *
     * @param tableName 表名称
     * @param column    字段名称
     */
    @Update("alter table ${tableName} add ${column} int null")
    Integer addColumnOfIntToTable(String tableName, String column);

    /**
     * 执行增加表中字符(varchar)类型字段
     *
     * @param tableName 表名称
     * @param column    字段名称
     * @param colLength 字段字符长度
     */
    @Update("alter table ${tableName} add ${column} varchar(${colLength}) null")
    Integer addColumnOfStringToTable(String tableName, String column, Integer colLength);

    /**
     * 执行删除表中某个字段
     *
     * @param tableName  表名称
     * @param columnName 字段名称
     */
    @Update("alter table ${tableName} drop column ${columnName}")
    Integer deleteColumnFromTable(String tableName, String columnName);

    /**
     * 通过表名称获取表中的字段
     *
     * @param name 表名称
     */
    @Select("select stuff((SELECT ','+ convert(varchar(500),name)    FROM SYSCOLUMNS WHERE ID=OBJECT_ID('${name}' ) for xml path('')),1,1,'') ")
    String getColumnsFromOneTable(String name);

    /**
     * 执行调用存储过程
     *
     * @param pname 存储过程名称
     */
    @Select("{call dbo.${pname}()}")
    List<Map<String, Object>> excuteProcedue(String pname);

    /**
     * 执行带有时间段参数的存储过程
     *
     * @param pname 存储过程名称
     * @param start 开始时间
     * @param end   结束时间
     */
    @Select("{ call dbo.${pname}('${start}','${end}') }")
    List<Map<String, Object>> excuteProcedueWithParams(String pname, String start, String end);


    @Select("select * from ${tablename}")
    List<LinkedHashMap> selectAllTableData(String tablename);

    @Select("select * from ${tablename}")
    List<LinkedHashMap<String, Object>> selectAllTableData2(String tablename);

    @Select("${sql}")
    List<LinkedHashMap<String, Object>> getDataBySql(@Param("sql") String sql);

    @Select("SELECT convert(varchar(50),name)  AS name FROM SYSCOLUMNS WHERE ID=OBJECT_ID('${tablename}')")
    List<String> selectAllTableColumns(@Param("tablename") String tablename);

    @Select("if Exists(select top 1 * from sysObjects where Id=OBJECT_ID(N'${tablename}') and xtype='U') DROP TABLE ${tablename}   ")
    void dropTable(String tablename);


}
