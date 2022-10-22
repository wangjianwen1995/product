package com.sxdl.hr.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hr.entity.Handle1;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface Handle1Dao  extends BaseDao<Handle1> {
    @Select("${sql}")
    String excuteSqlWithSQL(String sql);

    @Select("${sql}")
    List<Map<String,String>> getCollection(String sql);

    @Update("${sql}")
    int updateSqlWithSQL(String sql);

    @Delete("${sql}")
    void deleteSqlWithSQL(String s);

    @Select("${sql}")
    int SqlWithSQL(String sql);


}
