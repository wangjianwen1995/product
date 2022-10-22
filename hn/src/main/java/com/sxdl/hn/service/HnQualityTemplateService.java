package com.sxdl.hn.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hn.dao.dao1.HnHandleDao;
import com.sxdl.hn.dao.dao1.HnQualitySuborderDao;
import com.sxdl.hn.dao.dao1.HnQualityTemplateDao;
import com.sxdl.hn.entity.HnQualityTemplate;
import com.sxdl.hn.util.HNApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


//质量考核模板（核心）
@Service
@Transactional
public class HnQualityTemplateService extends BaseServiceImpl<HnQualityTemplate> {

    @Autowired
    private HnQualityTemplateDao templateDao;

    @Autowired
    private HnQualitySuborderDao suborderDao;

    @Autowired
    private HnHandleDao hnHandleDao;

    @Autowired
    private HNApplicationRunnerImpl runner;



    public Integer updateCache(HnQualityTemplate hnQualityTemplate) throws Exception{
        Integer update =  update(hnQualityTemplate);
        //更新缓存中的数据
        runner.putTemplate(hnQualityTemplate);
        runner.putStartAssessment(hnQualityTemplate.getId());
        return update;
    }


    public Integer delCache(Integer templateid){
        Integer delete =  deleteById(templateid);
        //更新缓存中的数据 非启用状态缓存中没有
        //runner.delTemplate(templateid);
        return delete;
    }

    public Integer enableTemplateState(HnQualityTemplate hnQualityTemplate) throws Exception{

        //启用的模板id
        Integer Oldtemplate_id = suborderDao.selectByPrimaryKey(hnQualityTemplate.getSuborder_id()).getTemplate_id();
        String disableTemplates = null;
        //启用一个模板
        String enableTemplate=null;
        if(StringUtils.isEmpty(Oldtemplate_id)){ //没有启用的 模板
            enableTemplate = " update quality_template set state = 1 where id = "+hnQualityTemplate.getId();
            int i1 = templateDao.updateSqlWithSQL(enableTemplate);
        }else{// 有启用 的模板

            //禁用旧的模板
            disableTemplates = " update quality_template set state = -1 where id = "+Oldtemplate_id;

            //启用新的模板
            enableTemplate = " update quality_template set state = 1 where id = "+hnQualityTemplate.getId();

            //删除缓存中的模板数据(因为禁用了 缓存中就不保留了)
            runner.delTemplate(Oldtemplate_id);
            //删除缓存中的 开始考核的数据
            runner.delstartAssessment(Oldtemplate_id);

        }

        String suborderSql = " update quality_suborder set template_id = "+hnQualityTemplate.getId().toString()+" where id = "+hnQualityTemplate.getSuborder_id().toString();
        int i1 = templateDao.updateSqlWithSQL(disableTemplates);
        int i2 = templateDao.updateSqlWithSQL(enableTemplate);
        int i3 = templateDao.updateSqlWithSQL(suborderSql);

        //更新缓存
        runner.setLmYm();
        //将新的模板添加到缓存中去
        runner.putTemplate(hnQualityTemplate);
        //将数据放到开始考核中
        runner.putStartAssessment(hnQualityTemplate.getId());
        return i1;
    }
}
