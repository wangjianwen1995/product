package com.sxdl.report.dao.dao1;

import com.sxdl.report.dao.BaseDao;
import com.sxdl.report.entity.Handle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface HandleDao extends BaseDao<Handle> {
    /**
     * 执行建表语句，使用参数
     *
     * @param tn 表名称
     * @param cs 字段定义列表，PS："name nvarchar(255)"
     */
    @Update("CREATE TABLE dbo.${tn} (id int IDENTITY(1,1) NOT NULL, ${cs} , PRIMARY KEY (id))")
    void excuteSqlWithParams(@Param("tn") String tn, @Param("cs") String cs);

    //测试执行建表语句
    @Update("IF OBJECT_ID(N'aaa', N'U') IS  NOT  NULL DROP TABLE aaa CREATE TABLE dbo.aaa( id int IDENTITY(1,1) NOT NULL,name nvarchar(255), PRIMARY KEY (id))")
    void excuteSql();

    //    @Select("{call dbo.test(#{name,jdbcType=VARCHAR,mode=IN},#{gender,jdbcType=VARCHAR,mode=OUT})}")
    //测试调用执行存储过程
   /* @Select("{call dbo.test()}")
    void excuteCallProcedue();*/


    @Update("ALTER PROCEDURE [dbo].[test]\n" +
            "AS\n" +
            "BEGIN\n" +
            "\tselect \n" +
            "\t\tname \n" +
            "\t\tinto \n" +
            "\t\t\t#test\n" +
            "\tfrom abc\n" +
            "\t\n" +
            "\tinsert into aaa(name) \n" +
            "\t\tselect name from #test\n" +
            "END")
    void excuteProcedue();

    @Update("${sql}")
    int excuteSqlWithSQL(String sql);

    @Select("{call dbo.${pname}()}")
    String excuteCallProcedue(String pname);

    @Select("{call dbo.${pname}(${param})}")
    String excuteCallProcedueParam(String pname,String param);

    @Select("{ call dbo.${pname}(${start},${end}) }")
    String excuteCallProcedueWithParams(String pname, String  start, String end);

    @Select("{ call dbo.createtable(${name},${linkName},${dbName},${view},${type}) }")
    void excuteCopytable(String name, String linkName,String dbName,String  view, Integer type);


    @Select("select count(*) from ${tablename}")
    int countSum(String tablename);

    @Select("{call dbo.${pname}()}")
    List<Map<String,String>> excuteCallProcedueReturnMap(String pname);
    @Select("{ call dbo.${pname}('${start}','${end}') }")
    List<Map<String,String>>  excuteCallProcedueWithParamsReturnMap(String pname, String  start, String end);


    //测试调用执行存储过程
    @Select("{call dbo.CreatLinkService(#{name},#{fromType},#{fromUrl},#{username},#{pwd})}")
    String creatLinkService(String name, String fromType, String fromUrl, String username, String pwd);


    @Select("${sql}")
    String execSelectSql(String sql);

    @Insert("${sql}")
    void createSql(String sql);
    /**
     *  通过表名称获取表中的字段
     * @param name 表名称
     */
    @Select("select stuff((SELECT ','+ convert(varchar(500),name)    FROM SYSCOLUMNS WHERE ID=OBJECT_ID('${name}' ) for xml path('')),1,1,'') ")
    String getOneTableOfColumns(String name);

    /**
     * 给数据表添加字段
     * @param tableName tableName
     * @param column column
     */
    @Update("alter table ${tableName} add ${column} int null")
    Integer addTableOfInt(String tableName,String column);

    @Update("alter table ${tableName} add ${column} varchar(${colLength}) null")
    Integer addTableOfString(String tableName,String column,Integer colLength);

    @Update("alter table ${tableName} drop column ${columnName}")
    int deleteTable(String tableName,String columnName);



    @Update("${sql}")
    int createNewTable(String sql);

    /**
     * 通用拼接sql接口
     * @param str str
     * @return List<Map<String, String>>
     */
    @Select("${str}")
    List<Map<String, Object>> findDbInfo(String str);
    @Select("${str}")
    List<Map> selectAllTableData (String str);


    @Select("select * from ${tablename}")
    List<LinkedHashMap> selectAllTableData2 (String tablename);

    @Select("SELECT convert(varchar(50),name)  AS name FROM SYSCOLUMNS WHERE ID=OBJECT_ID('${tablename}')")
    List<String> selectAllTableColumns (@Param("tablename") String tablename);


}
