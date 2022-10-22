package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hpqc.dbo.HpQcFzmxData;
import com.sxdl.hpqc.entity.HpQcResult;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpQcResultDao extends BaseUUIDDao<HpQcResult> {


    @Delete(" delete from hp_link_result WITH(NOLOCK) where bah ='${a_id}' and time = '${cysj}' and classify_id = ${type} ")
    Integer deleteByTypeDict(String a_id, String cysj, Integer type);


    @Select("select * from hp_link_result WITH(NOLOCK) where classify_id in ( ${classify} ) and bah='${bah}' and is_link=${is_link} and qc_time=(\n" +
            "select top 1 qc_time  from hp_link_result WITH(NOLOCK) where classify_id in ( ${classify} ) and bah='${bah}' and is_link=${is_link} GROUP BY qc_time order  by qc_time  desc\n" +
            ")")
    List<HpQcResult> selectbyClassify(String classify, String bah, String is_link);


    @Select("select * from hp_link_result where bah = '${aid}'  order by ordernum ")
    List<HpQcResult> selectbyBah(String aid);

    @Select("select * from hp_link_result WITH(NOLOCK) where bah='${bah}' and is_link=${is_link}  and qc_time=(\n" +
            "select top 1 ${aOrB}.qc_time   from  hp_qm_log a WITH(NOLOCK) left join hp_link_result b WITH(NOLOCK) on a.id=b.qc_id where  bah='${bah}' and is_link=${is_link}  GROUP BY ${aOrB}.qc_time order  by ${aOrB}.qc_time  ${ascDesc}\n" +
            ")")
    List<HpQcResult> selectbyBahAndFirst(String bah, String is_link, String ascDesc,String aOrB);

    @Select("select isnull(count(id),0) num  from ${tableName} where cysj between '${sdate}'  and '${edate}'")
    Integer selectCountByCysj(String sdate, String edate, String tableName);

    @Select("${sql}")
    List<HpQcFzmxData> selectBySome(String sql);

    @Select("select * from hp_link_result WITH(NOLOCK) where classify_id in ( ${classify} ) and bah='${bah}' and is_link=${is_link} and qc_time='${qc_time}' and qc_id='${qc_id}' order  by ordernum,home_type  ")
    List<HpQcResult> selectbyClassifyAndTime(String classify, String bah, String is_link,String qc_time, String qc_id);
}
