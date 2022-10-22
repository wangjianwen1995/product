package com.sxdl.cf.dao.dao1;

import com.sxdl.cf.dao.BaseUUIDDao;
import com.sxdl.cf.dto.ToExamineDBO;
import com.sxdl.cf.entity.SysCustomerFormHistoryToexamineEntity;
import org.apache.ibatis.annotations.Select;

public interface SysCustomerFormHistoryToexamineDao extends BaseUUIDDao<SysCustomerFormHistoryToexamineEntity> {


    @Select(" select toexamine_process,toexamine_step,toexamine_branchs,toexamine_currentusers,toexamine_currentnames,toexamine_result ,'' toexamine_process_explain" +
            " from ${tablename} where id ='${dataid}' ")
    ToExamineDBO getToExamineDBO(String tablename,String dataid);

}
