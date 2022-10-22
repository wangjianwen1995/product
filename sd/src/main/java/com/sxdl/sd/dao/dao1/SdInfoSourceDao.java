package com.sxdl.sd.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.sd.entity.SdInfoSource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SdInfoSourceDao extends BaseDao<SdInfoSource> {
    @Select("select * from sd_source where  CM_0_2_4_2 between ${cdate} and ${edate} ")
    List<SdInfoSource> findByTime(@Param(value = "cdate") String cdate, @Param(value = "edate") String edate);

    @Select("select * from sd_source where ( name  like ${name} or caseId like ${name}  ) and CM_0_2_4_2  between ${cdate} and ${edate}   ")
    List<SdInfoSource> findByTimeAndName(@Param(value = "cdate") String cdate, @Param(value = "edate") String edate, @Param(value = "name") String name);
}
