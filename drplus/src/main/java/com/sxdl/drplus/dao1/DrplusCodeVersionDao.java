package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.drplus.entity.DrplusCodeVersion;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DrplusCodeVersionDao extends BaseDao<DrplusCodeVersion> {


    @Select(" select * from drplus_code_version where type = ${type} and (name like '%${val}%' or code  like '%${val}%' or msg like '%${val}%')")
    List<DrplusCodeVersion> getVersionBytype(Integer type, String val);

}
