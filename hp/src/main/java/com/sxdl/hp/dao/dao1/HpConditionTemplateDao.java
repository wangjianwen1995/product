package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpConditionTemplate;
import org.apache.ibatis.annotations.Delete;

public interface HpConditionTemplateDao extends BaseDao<HpConditionTemplate> {

    @Delete("delete from hp_condition_template where user_id = ${user_id} and group_id = '${group_id}'")
    Integer deleteByUserId(Integer user_id,String group_id);
}
