package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.product.dc.entity.HpBzdmkEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpBzdmkDao extends BaseDao<HpBzdmkEntity> {

    @Select("select a.* from hp_bzdmk a right join hp_bm_version b on a.version=b.version and a.type = b.type where ison='1' and b.type='${type}' ")
    List<HpBzdmkEntity> getEnableByType(String type);

    @Select("select a.code from hp_bzdmk a right join hp_bm_version b on a.version=b.version and a.type = b.type where ison='1' and b.type='${type}' ")
    List<String> getCodeByType(String s);
}
