package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hp.entity.HpZyrzEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpZyrzDao extends BaseUUIDDao<HpZyrzEntity> {

    /**
     * 分组查时间段内的全部数据,关联期初那天的原有人数,关联期末那天的留院人数和实开床位数
     */
    @Select("  with tjzy as (select * from hp_zyrz where tjrq between '${sdate}' and '${edate}')\n" +
            "  select a.tjkb,a.tjkb_name,a.ryrs,a.tkzrrs,a.cyrs,a.zwtkrs,a.cyrsdb,b.yyrs,c.sjkfcws,c.lyrs from \n" +
            "  (select  tjkb,tjkb_name,sum(ryrs) ryrs,sum(tkzrrs) tkzrrs,sum(cyrs) cyrs,sum(zwtkrs) zwtkrs,sum(cyrsdb) cyrsdb from tjzy group  by tjkb,tjkb_name) a\n" +
            "  left join (select tjkb,yyrs from tjzy where tjrq='${sdate}'  group by tjkb,yyrs) b on a.tjkb=b.tjkb\n" +
            "  left join (select tjkb,sjkfcws,lyrs  from tjzy where tjrq='${edate}' group by tjkb,sjkfcws,lyrs ) c on a.tjkb=c.tjkb")
    List<HpZyrzEntity> selectByTjrq(@Param(value = "sdate") String sdate, @Param(value = "edate") String edate);

    /**
     * 查一天的数据,关联mid表中一天的数据总量
     */
    @Select("select z.id,tjrq,tjkb,sjkfcws,yyrs,ryrs,tkzrrs,cyrs,zwtkrs,lyrs,tjkb_name," +
            "(case when isnull(m.gdrs,'')!='' then m.gdrs else 0 end )as cyrsdb from hp_zyrz z " +
            "left join (select cyksdm,count(cyksdm) gdrs from hp_mid_table where cyrq between '${sdate}' and '${sdate} 23:59:59' GROUP BY cyksdm) m " +
            "on z.tjkb=m.cyksdm where tjrq='${sdate}' order by tjkb_name,tjkb")
    List<HpZyrzEntity> selectByTjrqOne(@Param(value = "sdate") String sdate);

    @Select("select * from hp_zyrz where tjrq>='${sdate}' order by tjrq")
    List<HpZyrzEntity> selectFromTjrq(String tjrq);

    @Select("select * from hp_zyrz where tjrq='${sdate}' and tjkb='${tjkb}'")
    HpZyrzEntity selectOneByTjrqAndTjKb(String sdate, String tjkb);

    /**
     * 今天以后最小的一天
     */
    @Select("SELECT min(tjrq) FROM [dbo].[hp_zyrz] where tjrq>'${sdate}'")
    String selectMinTjrqBySomeDay(String sdate);

    /**
     * 今天以前最大的一天
     */
    @Select("SELECT max(tjrq) FROM [dbo].[hp_zyrz] where tjrq<'${sdate}'")
    String selectMaxTjrqBySomeDay(String sdate);
}
