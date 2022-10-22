package com.sxdl.base.service;

import com.github.pagehelper.PageInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    /**
     * 带模糊查询的查询方法
     *
     * @param pageInfo 如题
     * @param obj 如题
     */
    PageInfo<T> queryPageList(PageInfo<T> pageInfo, Object obj);
    PageInfo<T> queryPageListDesc(PageInfo<T> pageInfo, Object obj);
    PageInfo<T> queryPageListOrderBy(PageInfo<T> pageInfo, Object obj,String col,String orby);

    /**
     * 查询多个id
     *
     * @param pageInfo 如题
     * @param obj 如题
     * @param ids 如题
     */
    PageInfo<T> queryPageListByIds(PageInfo<T> pageInfo, Object obj, Integer[] ids);


    PageInfo<T> queryPageListBuffer(PageInfo<T> pageInfo, Object obj, String columnTime, String starTime, String endTime);

    /**
     * 保存单个对象
     *
     * @param obj 如题
     */
    Integer insert(T obj);


    /**
     * 保存单个对象
     *
     * @param obj
     */
    Integer insertSelective(T obj);
    Integer saveSimple(T obj) ;


    /**
     * 修改单个对象
     *
     * @param obj 如题
     */
    Integer update(T obj);


    /**
     * 删除单个对象
     *
     * @param obj 如题
     */
    Integer delete(T obj);


    Integer deleteById(Object id);

    /**
     * 根据主键id查信息
     *
     * @param id 如题
     */
    T findById(Object id);


    List<T> findAll();

    List<T> select(T t);
    T selectOne(T t);

    T selectByKey(Object t);



    /**
     * 执行通用的更新相关的sql
     *
     * @param sql 如题
     */
    int updateSqlWithSQL(String sql);

    /**
     * 执行通用的查询相关的sql
     *
     * @param sql 如题
     */
    List<Map<String, Object>> selectSqlWithSQL(String sql);

    /**
     * 执行通用的查询相关的sql,返回指定类型的list
     * @param sql 如题
     * @param c 如题
     */
    List<T> selectListWithSQL(String sql,Class<T> c );

    /**
     * 根据sql查询分页数据,按照系统内置的entity进行转换,可能有风险
     * @param c             查询的类型
     * @param colums        查询的字段列表的sql片段
     * @param fromAndWhere  from和where的sql片段
     * @param order         排序的字段
     * @param p             分页的参数
     * @param isDesc        是否降序
     * @return              分页的数据
     */
    PageInfo<T> selectPageinfoWithSQL(Class<T> c,String colums, String fromAndWhere, String order, PageInfo p, boolean isDesc);

    /**
     * 据sql查询分页数据
     * @param colums        查询的字段列表的sql片段
     * @param fromAndWhere  from和where的sql片段
     * @param order         排序的字段
     * @param p             分页的参数
     * @param isDesc        是否降序
     * @return              分页的数据
     */
    PageInfo<T> selectPageinfoWithSQL(String colums, String fromAndWhere, String order, PageInfo p,boolean isDesc);
    /**
     * 执行通用sql,返回需要查询的总数
     * @param fromAndWhere sql语句中从from 开始的语句
     *                     示例:原有查询语句为 select * from a where a.id=1 and ......
     *                     需要传入的语句为 from a where a.id=1 and ......
     * @return Long 总数
     */
    Long selectCountWithSQL(String fromAndWhere);
    /**
     * 执行增加表中的数字(int)类型字段
     *
     * @param tableName 表名称
     * @param column    字段名称
     */
    Integer addColumnOfIntToTable(String tableName, String column);

    /**
     * 执行增加表中字符(varchar)类型字段
     *
     * @param tableName 表名称
     * @param column    字段名称
     * @param colLength 字段字符长度
     */
    Integer addColumnOfStringToTable(String tableName, String column, Integer colLength);

    /**
     * 执行删除表中某个字段
     *
     * @param tableName  表名称
     * @param columnName 字段名称
     */
    Integer deleteColumnFromTable(String tableName, String columnName);

    /**
     * 通过表名称获取表中的字段
     *
     * @param name 表名称
     */
    String getColumnsFromOneTable(String name);

    /**
     * 执行调用存储过程
     *
     * @param pname 存储过程名称
     */
    List<Map<String, Object>> excuteProcedue(String pname);

    /**
     * 执行带有时间段参数的存储过程
     *
     * @param pname 存储过程名称
     * @param start 开始时间
     * @param end   结束时间
     */
    List<Map<String, Object>> excuteProcedueWithParams(String pname, String start, String end);

    List<LinkedHashMap<String,Object>> execAllData2(String tablename);
    List<LinkedHashMap<String,Object>> execAllData3(String tablename);
    List<LinkedHashMap<String,Object>> execAllData4(String tablename);
    List<LinkedHashMap> execAllData(String tablename);
    List<LinkedHashMap> selectAllTableData(String tablename);
    List<LinkedHashMap<String,Object>> selectAllTableData2(String tablename);


    void deleteList(List<T> list);

    List<LinkedHashMap<String, Object>> getDataBySql( String sql);

    /**
     * 如果数据库中存在表则删除
     */
    void ifExistsTableThenDrop(String name);
    /**
     * 如果数据库中存在存储过程则删除
     */
    void ifExistsProcureThenDrop(String name);
    /**
     * 如果数据库中存在视图则删除
     */
    void ifExistsViewThenDrop(String name);
    /**
     * 如果数据库中存在临时表则删除
     */
    void ifExistsTempTableThenDrop(String name);
}
