package com.sxdl.cf.dao.dao1;

import com.sxdl.cf.dao.BaseUUIDDao;
import com.sxdl.cf.entity.SysCustomerFormClassifyEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysCustomerFormClassifyDao extends BaseUUIDDao<SysCustomerFormClassifyEntity> {


    @Select(" select * from sys_cf_classify order by order_number asc ")
    List<SysCustomerFormClassifyEntity> getAllClassify();

}
