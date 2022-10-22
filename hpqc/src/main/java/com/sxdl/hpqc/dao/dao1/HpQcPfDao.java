package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hpqc.dbo.HpQcFzmxData;
import com.sxdl.hpqc.dbo.HpQmRuleData;
import com.sxdl.hpqc.entity.HpQcPfEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpQcPfDao extends BaseDao<HpQcPfEntity> {
    @Select("select ID,fields,sqls,message,can_forced,classify,classify_id,ordernum,is_west,fields_anchor,kind_score as kfz,\n" +
            "packages,packages_score from hp_qm_pf where ${colunm}=1 \n" +
            "union all\n" +
            "select ID,fields,sqls,message,can_forced,'标准性质控',classify_id,ordernum,null,fields_anchor,null,\n" +
            "null,null from hp_qm_bz where ${colunm}=1 \n" +
            "union all\n" +
            "select ID,fields,sqls,message,can_forced,classify,classify_id,orderum as ordernum ,null,fields_anchor,null,\n" +
            "null,null from hp_qm_wzl where ${colunm}=1 \n" +
            "union all\n" +
            "select ID,fields,sqls,message,can_forced,classify,classify_id, ordernum ,null,fields_anchor,null,\n" +
            "null,null from hp_qm_zh where ${colunm}=1 and classify_id ${tempSql} order by classify_id,ordernum")
    List<HpQmRuleData> findQmAllData(String tempSql, String colunm);

    @Select("select * from TB_HOMEPAGE_GROUP_RESULT where bah='${bah}' and cysj='${cysj}' and pay_mode=${pay_mode}")
    HpQcFzmxData selectFxmxByBahAndCysj(String bah, String cysj,Integer pay_mode);
}
