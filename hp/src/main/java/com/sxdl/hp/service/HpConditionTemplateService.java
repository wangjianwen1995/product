package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hp.dao.dao1.HpConditionTemplateDao;
import com.sxdl.hp.entity.HpConditionGroup;
import com.sxdl.hp.entity.HpConditionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HpConditionTemplateService extends BaseServiceImpl<HpConditionTemplate> {

    @Autowired
    private HpConditionTemplateDao templateDao;

    /**
     * 变更用户的条件组开启/关闭状态,实际上是增加/删除条件组模版表数据
     */
    public void saveConditionTemplate(Integer user_id, HpConditionGroup hpConditionGroup)  {
        if ("0".equals(hpConditionGroup.getIsenable())) {//禁用
            templateDao.deleteByUserId(user_id, hpConditionGroup.getId());
        } else if ("1".equals(hpConditionGroup.getIsenable())) {//启用
            HpConditionTemplate template = new HpConditionTemplate();
            template.setUser_id(user_id);
            template.setGroup_id(hpConditionGroup.getId());
            List<HpConditionTemplate> select = templateDao.select(template);
            if (CollUtil.isEmpty(select)) {
                templateDao.insert(template);
            }
        }
    }
}
