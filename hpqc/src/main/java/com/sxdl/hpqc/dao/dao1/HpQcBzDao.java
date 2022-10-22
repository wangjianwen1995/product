package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hpqc.entity.HpQcBz;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface HpQcBzDao extends BaseUUIDDao<HpQcBz> {


    @Select(" select RTRIM(LTRIM(val)) from sys_dict_val where dict_id = ${pid} and val is not null")
    ArrayList<String> getOnlyDitVal(Integer pid);
}
