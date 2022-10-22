package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hp.entity.HpEtlConfig;
import org.apache.ibatis.annotations.Select;

public interface HpEtlConfigDao extends BaseUUIDDao<HpEtlConfig> {
    /**
     * 检查是否已经有重抽费用按钮,保证只有一个
     */
    @Select("select top 1 * from hp_etl_config where type='2'")
    HpEtlConfig selectHasType2();

    /**
     * 检查是否已经有"到接口表"配置,保证只有一个
     */
    @Select("select top 1 * from hp_etl_config where name='到接口表'")
    HpEtlConfig selectHasToIF();

    /**
     * 检查是否已经有"全链路抽取"配置,保证只有一个
     */
    @Select("select top 1 * from hp_etl_config where name='全链路抽取'")
    HpEtlConfig selectHasAll();
}
