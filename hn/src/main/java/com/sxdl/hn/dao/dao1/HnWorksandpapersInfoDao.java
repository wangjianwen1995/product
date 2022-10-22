package com.sxdl.hn.dao.dao1;


import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnWorksandpapersInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// worksandpapers_info  著作与论文登记
public interface HnWorksandpapersInfoDao     extends BaseDao<HnWorksandpapersInfo> {


    @Select(" select * from worksandpapers_info where pid = ${pid}")
    List<HnWorksandpapersInfo> getDataByPid(Integer pid);

    @Delete(" delete from worksandpapers_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);

}
