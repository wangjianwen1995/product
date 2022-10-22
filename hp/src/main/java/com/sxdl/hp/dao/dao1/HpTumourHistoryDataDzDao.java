package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpTumourHistoricalDataDz;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpTumourHistoryDataDzDao extends BaseDao<HpTumourHistoricalDataDz> {
    @Select("select distinct a.ch0a77 as use_dm ,a.ch0ack as use_mc from VsCH0A a where a.ch0a27 between '${stime}' and '${etime}'")
    List<HpTumourHistoricalDataDz> selectSome(@Param("stime") String stime, @Param("etime")String etime);
}
