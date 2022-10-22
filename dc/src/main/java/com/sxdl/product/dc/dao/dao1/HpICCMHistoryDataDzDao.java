package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.product.dc.entity.HpICCMHistoricalDataDz;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

public interface HpICCMHistoryDataDzDao extends BaseDao<HpICCMHistoricalDataDz> {
    @Select("select distinct c.ch0c11 as use_dm ,c.ch0c03_desc as use_mc from vsch0a a ,vsCh0c c where a.id=c.A_id and a.ch0a27 between '${stime}' and '${etime}'")
    List<HpICCMHistoricalDataDz> selectICDSome(@Param("stime") String stime, @Param("etime") String etime);

    @Select("select distinct c.ch0e05 as use_dm ,c.ch0e05_desc as use_mc from VsCH0A a ,vsch0e c where a.id=c.A_id and a.ch0a27 between '${stime}' and '${etime}'")
    List<HpICCMHistoricalDataDz> selectICCMSome(@Param("stime") String stime, @Param("etime") String etime);

    @Select("select distinct a.ch0a77 as use_dm ,a.ch0ack as use_mc from VsCH0A a where a.ch0a27 between '${stime}' and '${etime}'")
    List<HpICCMHistoricalDataDz> selectZLSome(@Param("stime") String stime, @Param("etime") String etime);

    @Select("with ls as(select  ch0k14ID,CH0K14,CH0K02ID,CH0K02,CH0K06ID,CH0K06,CH0K16ID,CH0K16,CH0K07ID,CH0K07,CH0K15ID,CH0K15 from  vsch0a a ,vsCh0k c where a.id=c.A_id  and a.ch0a27 between '${stime}' and '${etime}' )\n" +
            "select b.use_dm,b.use_mc from ( select  ch0k14ID as use_dm, CH0K14 as use_mc from ls union all select CH0K02ID , CH0K02    from ls \n" +
            "union all select CH0K06ID,  CH0K06 from ls union all select CH0K16ID , CH0K16   from ls union all select CH0K07ID , CH0K07  from ls \n" +
            "union all select CH0K15ID, CH0K15 from ls ) b")
    List<HpICCMHistoricalDataDz> selectZYSome(@Param("stime") String stime, @Param("etime") String etime);

    @Select("select distinct a.ch0a79 as use_dm ,a.ch0ass as use_mc from VsCH0A a where a.ch0a27 between '${stime}' and '${etime}'")
    List<HpICCMHistoricalDataDz> selectSSZDSome(@Param("stime") String stime, @Param("etime") String etime);


    @Select("select * from hp_history_iccm_dz where type=${type} and status=${status}  ")
    List<HpICCMHistoricalDataDz> selectByStatus(@Param("type") String type, @Param("status") String status);

    @Select("select a.use_dm from hp_history_iccm_dz a right join hp_bm_version b on  a.type = b.type where b.ison='1' and a.status=1 and b.type='${type}'")
    ArrayList<String> seleucode(Integer type);
}