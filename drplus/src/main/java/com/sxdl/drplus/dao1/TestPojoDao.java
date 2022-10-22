package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.drplus.entity.TestPojo;
import org.apache.ibatis.annotations.Select;

public interface TestPojoDao extends BaseDao<TestPojo> {


    @Select("${sql}")
    String getID(String sql);

}
