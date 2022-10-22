package com.sxdl.hpqc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.hpqc.entity.HomepageQcLinkEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface HpQcHomepageLinkDao extends BaseUUIDDao<HomepageQcLinkEntity> {

    @Select("select * from homepage_link where  convert(varchar,cysj,23)  between '${sdate}' and '${edate}' and isnull(status,'1')='1' and isnull(is_link,2)=2")
    List<HomepageQcLinkEntity> selectByCysj(String sdate, String edate);

    @Delete("delete homepage_link where bah='${bah}' and is_link=1")
    Integer deleteByBah(String bah);

    @Select("select * from homepage_link where id='${id}' and isnull(status,'1')='1' and isnull(is_link,2)=2")
    List<HomepageQcLinkEntity> selectById(String id);
}
