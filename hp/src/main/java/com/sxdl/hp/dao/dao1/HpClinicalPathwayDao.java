package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hp.entity.HpClinicalPathway;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface HpClinicalPathwayDao extends BaseUUIDDao<HpClinicalPathway> {

    @Select("select name,ks_code,ks_name from sys_dict_clinical_pathway where status=1")
    List<Map<String, Object>> selectSelectsIfON();
}
