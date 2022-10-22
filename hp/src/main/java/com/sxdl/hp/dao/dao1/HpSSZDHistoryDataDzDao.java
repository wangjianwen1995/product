package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpSSZDHistoricalDataDz;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpSSZDHistoryDataDzDao extends BaseDao<HpSSZDHistoricalDataDz> {
    @Select("select distinct a.ch0a79 as use_dm ,a.ch0ass as use_mc from VsCH0A a where a.ch0a27 between '${stime}' and '${etime}'")
    List<HpSSZDHistoricalDataDz> selectSome(@Param("stime") String stime, @Param("etime")String etime);
}
