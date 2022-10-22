package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hpqc.dbo.QualityDBO;
import com.sxdl.hpqc.entity.HpQcPfResultEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpQcPfResultDao extends BaseUUIDDao<HpQcPfResultEntity> {


// SELECT * FROM [dbo].[hp_link_pf_result]
    @Select("select * from hp_link_pf_result WITH(NOLOCK) where bah = '${bah}'  and is_link=${is_link} and qc_time=(\n" +
            "select top 1 ${aOrB}.qc_time   from  hp_qm_log a WITH(NOLOCK)  left join hp_link_pf_result b WITH(NOLOCK)  on a.id=b.qc_id   where bah = '${bah}' and is_link=${is_link}  GROUP BY ${aOrB}.qc_time order  by ${aOrB}.qc_time  ${ascDesc} \n" +
            ") ")
    List<HpQcPfResultEntity> selectbyBahAndFirst(String bah, String ascDesc,String is_link,String aOrB);


   /* @Select("select * from hp_link_pf_result WITH(NOLOCK) where bah = '${bah}'  and is_link=${is_link}  and 1 > (select count(*) from hp_link_pf_result where bah = a.bah and qc_time ${ascDesc} a.qc_time ) ")
    List<HpQcPfResultEntity> selectbyBahAndFirst(String bah, String ascDesc,String is_link);*/

    @Select("select * from hp_link_pf_result WITH(NOLOCK) where bah = '${bah}' and is_link=${is_link} and qc_time='${qc_time}' and qc_id='${qc_id}'  order by orde_rum, home_type  ")
    List<HpQcPfResultEntity> selectbyTime(String bah, String qc_time, String qc_id, String is_link);

}
