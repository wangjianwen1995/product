package com.sxdl.report.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.report.entity.DrTemplate;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrTemplateDao extends BaseDao<DrTemplate> {

    @Select("select * from dr_template where template_type='3' ")
    List<DrTemplate> getTemplateByType();
}
