package com.sxdl.hn.dao.dao1;


import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.HnAwardInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//  创造发明、科研成果和技术业务工作授奖登记 award_info
public interface HnAwardInfoDao  extends BaseDao<HnAwardInfo> {


    @Select(" select * from award_info where pid = ${pid}")
    List<HnAwardInfo> getDataByPid(Integer pid);

    @Delete(" delete from award_info where pid = ${pid}")
    Integer delDataByPid(Integer pid);

}
