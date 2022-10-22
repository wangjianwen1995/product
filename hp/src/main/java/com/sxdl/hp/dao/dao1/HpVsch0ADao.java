package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hp.entity.HpVsch0AEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpVsch0ADao extends BaseUUIDDao<HpVsch0AEntity> {

    /**
     * 查询A表有数据,homepage表没有数据的,旧病案数据
     */
    @Select("select * from VsCH0A  where ID  not   in  (select A_ID  from homepage where cysj between '${stardate}' and '${enddate}' ) and CH0A27 between '${stardate}' and '${enddate}' ")
    List<HpVsch0AEntity> selectAWithNotInHomepage(String stardate , String enddate);

    /**
     * 查询mid表中有相关病案号的数据,说明是正常病案室操作
     */
    @Select("select top 1 bah from hp_mid_table where bah ='${bah}'")
    String selectMidWithNotInA(String bah);

    /**
     * 查A表中是否有环节
     */
    @Select("select top 1 id from vsch0a where status ='6' and ch0a01 ='${bah}'")
    String selectAHasLinkingSave(String bah);

    /**
     * 查询是否手工录入的数据
     */
    @Select("select count(*) from vsch0a where isnull(isManual,'')!='' and isnull(InputReason,'')!='' and ch0a01='${bah}'")
    Integer selectByShouGong(String bah);
}
