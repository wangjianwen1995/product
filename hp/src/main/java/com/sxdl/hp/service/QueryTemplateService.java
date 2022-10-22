package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.QueryTemplateDao;
import com.sxdl.hp.entity.HpColumn;
import com.sxdl.hp.entity.HpQueryTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QueryTemplateService extends BaseServiceImpl<HpQueryTemplate> {

    @Autowired
    private QueryTemplateDao queryTemplateDao;

    public List<HpColumn> findCanQueryCol(Integer user_id)  {
        return queryTemplateDao.findCanQueryCol(user_id);
    }

    public Integer saveDragAndDrop(Integer user_id, List<HpColumn> hpColumns)  {
        //1 先删除查询模板中 该用户的数据
        Integer del = queryTemplateDao.deleteByUserID(user_id);
        HpQueryTemplate template = null;
        for (int i = 0; i < hpColumns.size(); i++) {
            template = new HpQueryTemplate();
            template.setUser_id(user_id);
            template.setColumn_name(hpColumns.get(i).getName());
            template.setColumn_id(hpColumns.get(i).getId());
            template.setColumn_type(hpColumns.get(i).getColumn_type());
            template.setDecimal_size(hpColumns.get(i).getSize());
            template.setIs_query(hpColumns.get(i).getIs_query());
            template.setWeb_name(hpColumns.get(i).getWeb_name());
            template.setXh(StringUtil.isEmpty(hpColumns.get(i).getXh() + "") ? i : hpColumns.get(i).getXh());
            int insert = queryTemplateDao.insert(template);
        }
        return 1;
    }

    public List<HpColumn> findQueryCol()  {
        return queryTemplateDao.findQueryCol();
    }

    public List<HpColumn> findQueryCol(String name)  {
        return queryTemplateDao.findQueryCol2(name);
    }

    public List<HpColumn> findIsDefaultCol()  {
        return queryTemplateDao.findIsDefaultCol();
    }
}
