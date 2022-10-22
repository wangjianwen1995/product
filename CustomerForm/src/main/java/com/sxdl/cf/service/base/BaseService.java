package com.sxdl.cf.service.base;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

public interface BaseService<T> {

    void execSqlText(String sql);
    public PageInfo<T> getListPage(PageInfo<T> pageInfo, String sql);
    public PageInfo<T> getListPage(PageInfo<T> pageInfo );

    public Integer insert(T obj);

    public Integer insertSelective(T obj);
    public Integer saveSimple(T obj) throws Exception;
    public Integer update(T obj);

    public Integer updateSelective(T obj);

    public Integer delete(T obj);

    public Integer deleteById(Object id);

    public T findById(Object id);

    public List<T> findAll();

    public List<T> select(T t);

    public T selectOne(T t);

    public T selectByKey(Object o) ;



    public List<T> getList(String sql )  ;



    public Integer addField(String tableName, String column)  ;


    public Integer delField(String tableName, String columnName) ;

    public String getField(String name) ;



    public List<LinkedHashMap<String, Object>> getLinkedMap(String sql)  ;


    void  dropTable (@Param("name") String name);

    Integer existsTableByTableName(  String name);


    String selectString( String sql);


    Integer selectInteger( String sql);

}
