package com.sxdl.sd.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.sd.entity.SdInfoColumn;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SdInfoColumnDao extends BaseDao<SdInfoColumn> {
    @Select("select a.name as name,c.name as sd_info_name  from sd_info_column  a left join sd_info_column_old_bak b on  a.sd_info_id=b.sd_info_id  and a.name=b.name left join sd_info c on a.sd_info_id=c.id\n" +
            " where b.name is null")
    List<SdInfoColumn> selectSome();
}
