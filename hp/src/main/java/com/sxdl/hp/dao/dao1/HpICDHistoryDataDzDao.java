package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpICDHistoricalDataDz;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpICDHistoryDataDzDao extends BaseDao<HpICDHistoricalDataDz> {
    @Select("select distinct c.ch0c11 as use_dm ,c.ch0c03_desc as use_mc from vsch0a a ,vsCh0c c where a.id=c.A_id and a.ch0a27 between '${stime}' and '${etime}'")
    List<HpICDHistoricalDataDz> selectSome(@Param("stime") String stime, @Param("etime")String etime);

}
