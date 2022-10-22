package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hp.dao.dao1.HpConditionDao;
import com.sxdl.hp.dao.dao1.HpConditionGroupDao;
import com.sxdl.hp.entity.HpConditionGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class HpConditionGroupService extends BaseServiceImpl<HpConditionGroup> {


    @Autowired
    private HpConditionGroupDao hpConditionGroupDao;

    @Autowired
    private HpConditionDao hpConditionDao;

    public Integer deleteByIdAndChil(String id)  {
        int i = hpConditionGroupDao.deleteByPrimaryKey(id);
        Integer integer = hpConditionDao.deleteByPid(id);
        return integer;
    }

    public List<HpConditionGroup> findIsEnable(Integer user_id, String name)  {
        StringBuilder sb = new StringBuilder();
//        sb.append(" select a.*, case when isnull(b.id,'')!='' then '1' else '0' end  as isenable " +
//                " from hp_condition_group a left join hp_condition_template  b on a.id =b.group_id where b.user_id='"+user_id+"' ");
        sb.append(" select a.*, case when isnull(b.id,'')!='' then '1' else '0' end  as isenable " +
                " from hp_condition_group a left join hp_condition_template  b on a.id =b.group_id and user_id='" + user_id + "' " +
                " where  1=1  ");
        if (!StringUtils.isEmpty(name)) sb.append(" and name like '%" + name + "%' ");
        sb.append("   order by create_time ");
        String sql = sb.toString();
        List<HpConditionGroup> list = hpConditionGroupDao.findIsEnable(sql);
        return list;
    }

    public List<HpConditionGroup> IsEnableData(Integer userid)  {
        return hpConditionGroupDao.IsEnableData(userid);
    }
}
