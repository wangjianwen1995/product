package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hp.entity.HpComp;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface HpCompDao extends BaseUUIDDao<HpComp> {

    @Select("select name,ks_code,ks_name from sys_dict_comp where status=1")
    List<Map<String, Object>> selectSelectsIfON();
}
