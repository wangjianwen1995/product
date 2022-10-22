package com.sxdl.hr.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.base.service.BaseService;
import com.sxdl.hr.entity.TxhlGrbwxxEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shqrpknife
 * @create 2022-08-10-14:51
 */
public interface HrTxhlGrbwxx extends BaseUUIDDao<TxhlGrbwxxEntity> {
    @Select("select gid,grbwdm,zyh,(case WHEN  grlx='医院感染' THEN  1 when  grlx='社区感染' THEN 2 ELSE  3 END ) Grlx,grbwmc,TbSj,grgid from txhl_grbwxx")
    List<TxhlGrbwxxEntity>getGrbw();
}
