package com.sxdl.sd.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.sd.entity.Handle1;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface Handle1Dao  extends BaseDao<Handle1> {
    @Select("{ call dbo.${etl_template}('${tempname}','${id}','${caseId}') }")
    String excuteProcedueWithTpParams(String etl_template, String tempname, String id, String caseId);

    //@patientcode VARCHAR(100),@cysj VARCHAR(100),@sid varchar(100), @tempname varchar(100)
    @Select("{ call dbo.${etl_load_template}('${patientcode}','${cysj}','${sid}','${tempname}') }")
    List<Map<String, Object>> excuteProcedueWithTpLoad(String etl_load_template, String patientcode, String cysj, String sid, String tempname);

    @Delete("delete from ${str}  where tempname ='${tempname}'")
    int deleteByTpName(String str,String tempname);

    @Update("${sql}")
    int excuteSqlWithSQL(String sql);
}
