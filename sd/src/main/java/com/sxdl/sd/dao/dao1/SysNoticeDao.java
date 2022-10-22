package com.sxdl.sd.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.sd.entity.SysNotice;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysNoticeDao extends BaseDao<SysNotice> {

    @Select("select * from sys_notice where update_time between '${stime}' and '${etime}' ")
    List<SysNotice> findByTime(String stime, String etime);

    @Select("select * from sys_notice where flag=1 and update_time between '${stime}' and '${etime}' ")
    List<SysNotice> findByTimeByFlag(String stime, String etime);
}
