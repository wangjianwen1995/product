package com.sxdl.hr.dao.dao1;

import com.sxdl.base.dao.BaseUUIDDao;
import com.sxdl.base.service.BaseService;
import com.sxdl.hr.entity.TgrBlmEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.poi.ss.formula.functions.T;


/**
 * @author shqrpknife
 * @create 2022-08-07-17:58
 */

public interface HrPrevalenceRate  {
    /*@Select("exec Xhl_DataImport  '${dcgid}', '${strkslist}', '${dcsj}','','${name}'")
    void addPR(String dcgid, String strkslist, String dcsj,  String name);

    @Delete("delete from tgr_blm where dcgid = '${dcgid}'")
    int delPR(String dcgid);

    Integer update(T obj);

    @Select("select * from tgr_blm where gid= '${gid}'")
    TgrBlmEntity checkInfo(String gid);*/
}
