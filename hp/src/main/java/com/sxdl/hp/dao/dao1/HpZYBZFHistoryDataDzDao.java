package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpZYBZFHistoricalDataDz;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpZYBZFHistoryDataDzDao extends BaseDao<HpZYBZFHistoricalDataDz> {
    @Select("with ls as(select  ch0k14ID,CH0K14,CH0K02ID,CH0K02,CH0K06ID,CH0K06,CH0K16ID,CH0K16,CH0K07ID,CH0K07,CH0K15ID,CH0K15 from  vsch0a a ,vsCh0k c where a.id=c.A_id  and a.ch0a27 between '${stime}' and '${etime}' )\n" +
            "select b.use_dm,b.use_mc from ( select  ch0k14ID as use_dm, CH0K14 as use_mc from ls union all select CH0K02ID , CH0K02    from ls \n" +
            "union all select CH0K06ID,  CH0K06 from ls union all select CH0K16ID , CH0K16   from ls union all select CH0K07ID , CH0K07  from ls \n" +
            "union all select CH0K15ID, CH0K15 from ls ) b")
    List<HpZYBZFHistoricalDataDz> selectSome(@Param("stime") String stime, @Param("etime")String etime);
}
