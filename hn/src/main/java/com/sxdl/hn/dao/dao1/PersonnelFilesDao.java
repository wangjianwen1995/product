package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnBasicInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//档案:基础模块 basic_info
public interface PersonnelFilesDao extends BaseDao<HnBasicInfo> {

    @Update(" update basic_info set leave_whether = ${state} where id = ${id}")
    Integer updatestate(Integer id, Integer state);

    @Select("${sql}")
    List<HnBasicInfo> findbySql(String sql);

    @Delete("delete from basic_info where id =${id}")
    Integer deleteById(Integer id);
}
