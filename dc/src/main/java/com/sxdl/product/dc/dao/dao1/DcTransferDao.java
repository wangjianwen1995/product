package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.product.dc.entity.DcTransfer;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DcTransferDao extends BaseUUIDDao<DcTransfer> {

    @Select("${sql}")
    void deleteServerLink(String sql);

    @Select(" select *  from dc_transfer where job_id in(${substring})")
    List<DcTransfer> selectByIds(String substring);
    @Select(" select *  from dc_transfer where job_id ='${id}'")
    List<DcTransfer> selectByJobId(String id);

    @Update("update dc_transfer set etlp_type=${type} where job_id ='${id}' ")
    void updateByJobAndType(String id, Integer type);
}