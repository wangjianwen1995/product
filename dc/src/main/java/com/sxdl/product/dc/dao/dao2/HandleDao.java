package com.sxdl.product.dc.dao.dao2;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.product.dc.entity.DcHandle;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface HandleDao extends BaseDao<DcHandle> {
    //    /**
//     * 执行建表语句，使用参数
//     *
//     * @param tn 表名称
//     * @param cs 字段定义列表，PS："name nvarchar(255)"
//     */
//    @Update("CREATE TABLE dbo.${tn} (id int IDENTITY(1,1) NOT NULL, ${cs} , PRIMARY KEY (id))")
//    void excuteSqlWithParams(@Param("tn") String tn, @Param("cs") String cs);
//
//    //测试执行建表语句
//    @Update("IF OBJECT_ID(N'aaa', N'U') IS  NOT  NULL DROP TABLE aaa CREATE TABLE dbo.aaa( id int IDENTITY(1,1) NOT NULL,name nvarchar(255), PRIMARY KEY (id))")
//    void excuteSql();
//
//    //    @Select("{call dbo.test(#{name,jdbcType=VARCHAR,mode=IN},#{gender,jdbcType=VARCHAR,mode=OUT})}")
//    //测试调用执行存储过程
//   /* @Select("{call dbo.test()}")
//    void excuteCallProcedue();*/
//
//
//    @Update("ALTER PROCEDURE [dbo].[test]\n" +
//            "AS\n" +
//            "BEGIN\n" +
//            "\tselect \n" +
//            "\t\tname \n" +
//            "\t\tinto \n" +
//            "\t\t\t#test\n" +
//            "\tfrom abc\n" +
//            "\t\n" +
//            "\tinsert into aaa(name) \n" +
//            "\t\tselect name from #test\n" +
//            "END")
//    void excuteProcedue();
//
    @Update("${sql}")
    int excuteSqlWithSQL(String sql);

    //
    @Select("{call dbo.${pname}()}")
    String excuteCallProcedue(String pname);

    @Select("{ call dbo.${pname}('${start}','${end}') }")
    String excuteCallProcedueWithParams(@Param(value = "pname") String pname, @Param(value = "start") String start, @Param(value = "end") String end);

    @Select("{ call dbo.${pname}('${param1}','${param2}','${param3}') }")
    String excuteCallProcedueWithSomeParams(@Param(value = "pname") String pname, @Param(value = "param1") String param1,
                                            @Param(value = "param2") String param2,@Param(value = "param3") String param3);


    //
//
    @Select("select count(*) from ${tablename}")
    int countSum(String tablename);

    //
//    @Select("{call dbo.${pname}()}")
//    List<Map<String,String>> excuteCallProcedueReturnMap(String pname);
//    @Select("{ call dbo.${pname}('${start}','${end}') }")
//    List<Map<String,String>>  excuteCallProcedueWithParamsReturnMap(@Param(value = "pname")String pname,@Param(value = "start") String  start,@Param(value = "end") String end);
//
//
    //测试调用执行存储过程
    @Select("{call dbo.etl_dc_ots_test(#{name},#{fromType},#{fromUrl},#{username},#{pwd},#{linkStr})}")
    String findInfo(@Param(value = "name") String name, @Param(value = "fromType") String fromType, @Param(value = "fromUrl") String fromUrl, @Param(value = "username") String username, @Param(value = "pwd") String pwd,
                    @Param(value = "linkStr") String linkStr);

    //
//
    @Select("${sql}")
    String execSelectSql(String sql);

    //
//    /**
//     *  通过表名称获取表中的字段
//     * @param name 表名称
//     * @return
//     */
    @Select("select stuff((SELECT ','+ convert(varchar(500),name)    FROM SYSCOLUMNS WHERE ID=OBJECT_ID('${name}' ) for xml path('')),1,1,'') ")
    String getOneTableOfColumns(String name);

    @Select("select distinct ${name} as vals from ${tname}")
    List<String> findInstanceData(String tname, String name);

    //
//    /**
//     * 给数据表添加字段
//     * @param tableName
//     * @param column
//     * @return
//     */
    @Update("alter table ${tableName} add ${column} int null")
    Integer addTableOfInt(@Param(value = "tableName") String tableName, @Param(value = "column") String column);

    //
    @Update("alter table ${tableName} add ${column} varchar (${colLength}) null")
    Integer addTableOfString(@Param(value = "tableName") String tableName, @Param(value = "column") String column, @Param(value = "colLength") Integer colLength);

    //
    @Update("alter table ${tableName} drop column ${columnName}")
    int deleteTable(@Param(value = "tableName") String tableName, @Param(value = "columnName") String columnName);

    //
//
//
    @Update("${sql}")
    int createNewTable(String sql);

    @Select("${str}")
    List<Map<String, Object>> findDbInfo(String s);

    @Update("alter table ${tableName} add ${column} ${datetime} null")
    void addTableOfDate(@Param(value = "tableName") String tableName, @Param(value = "column") String column, @Param(value = "datetime") String datetime);

    @Update("alter table ${tableName} alter column  ${column} ${s} ")
    void alertTable(@Param(value = "tableName") String tableName, @Param(value = "column") String column, @Param(value = "s") String s);

    @Select("USE [${database_name}] \r\n" +
            "GO \r\n" +
            "sp_columns  ${tableName} ")
    List<Map<String, Object>> findColumByDb(@Param(value = "database_name") String database_name, @Param(value = "tableName") String tableName);
//
//    /**
//     * 通用拼接sql接口
//     * @param str
//     * @return ist<Map<String, String>>
//     */
//    @Select("${str}")
//    List<Map<String, Object>> findDbInfo(String str);
}
