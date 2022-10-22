package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpCondition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpConditionDao extends BaseDao<HpCondition> {

    @Delete("delete from hp_condition where pid = '${id}'")
    Integer deleteByPid(String id);

    @Select(" select a.* ,b.column_type,b.is_query,b.web_name " +
            " from hp_condition a " +
            " left join hp_column b on a.column_id = b.id " +
            " where pid ='${pid}'" +
            " order by xh")
    List<HpCondition> findConditionByGroup(String pid);

    @Select("${s}")
    List<Integer> testSql(String s);
}
