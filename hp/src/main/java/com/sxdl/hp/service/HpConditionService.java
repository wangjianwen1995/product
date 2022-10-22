package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hp.dao.dao1.HpConditionDao;
import com.sxdl.hp.dao.dao1.HpConditionGroupDao;
import com.sxdl.hp.entity.HpCondition;
import com.sxdl.hp.entity.HpConditionGroup;
import com.sxdl.hp.util.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpConditionService extends BaseServiceImpl<HpCondition> {

    @Autowired
    private HpConditionDao conditionDao;

    @Autowired
    private HpConditionGroupDao groupDao;

    /**
     * 保存数据:先删除这个组下面的所有条件数据,然后保存条件数据,最后更新条件组中的 总slq脚本
     *
     * @param
     * @return
     */
    public Map<String, String> saveCondition(HpConditionGroup conditionGroup)  {
        String pid = conditionGroup.getId();
        Map<String, String> map = new HashMap<>();
        List<HpCondition> hpConditions = conditionGroup.getHpConditions();
        String retrunsql = SqlUtil.retrunsql(hpConditions);
        StringBuilder sb = new StringBuilder();
        sb.append(" where ");
        String testsql = "select 1 " + retrunsql + " where  " + conditionGroup.getTotal_sql();
        try {
            List<Integer> i = conditionDao.testSql(testsql);
        } catch (Exception e) {
            map.put("type", "-1"); //1 成功  -1失败
            map.put("sql", testsql + "\r\n error : " + e.getMessage());
            return map;
        }
        Integer integer = conditionDao.deleteByPid(pid);
        int index = 0;
        for (HpCondition hpCondition : hpConditions) {
            hpCondition.setXh(index);
            int insert = conditionDao.insert(hpCondition);
            index++;
        }
        int i1 = groupDao.updateByPrimaryKey(conditionGroup);
        map.put("type", "1"); //1 成功  -1失败
        map.put("sql", testsql);
        return map;
    }

    public List<HpCondition> findConditionByGroup(String pid)  {
        return conditionDao.findConditionByGroup(pid);
    }
}
