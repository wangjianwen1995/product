package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpConditionGroup;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpConditionGroupDao extends BaseDao<HpConditionGroup> {

    @Select("${sql}")
    List<HpConditionGroup> findIsEnable(String sql);


    @Select(" select a.*, case when isnull(b.id,'')!='' then '1' else '0' end  as isenable " +
            " from hp_condition_group a " +
            " right join hp_condition_template  b on a.id =b.group_id" +
            " where b.user_id='${user_id}' " +
            " order by create_time ")
    List<HpConditionGroup> IsEnableData(Integer user_id);


}
