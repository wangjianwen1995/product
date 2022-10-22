package com.sxdl.report.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.report.entity.DrTable;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrTableDao  extends BaseDao<DrTable>  {

    @Select("SELECT *FROM dbo.dr_table WHERE template_id IN(SELECT id FROM dbo.dr_template WHERE template_type='3')")
    List<DrTable> getDBZDate();
}
