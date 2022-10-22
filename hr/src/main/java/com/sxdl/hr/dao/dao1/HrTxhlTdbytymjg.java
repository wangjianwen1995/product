package com.sxdl.hr.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.base.service.BaseService;
import com.sxdl.hr.entity.TxhlGrbwxxEntity;
import com.sxdl.hr.entity.TxhlTdbytymjgEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shqrpknife
 * @create 2022-08-10-14:59
 */
public interface HrTxhlTdbytymjg extends BaseUUIDDao<TxhlTdbytymjgEntity> {
    @Select("select  *  from txhl_tdbytymjg")
    List<TxhlTdbytymjgEntity> getTdBytYmjg();
    @Select("select  *  from txhl_tdbytymjg where ywdm is not null ")
    List<TxhlTdbytymjgEntity> getYmjg();
}
