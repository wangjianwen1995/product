package com.sxdl.report.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.report.entity.DrReturn;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrReturnDao extends BaseDao<DrReturn> {
    @Select(" select * from dr_return order by id desc")
    List<DrReturn> findAllDesc();

}
