package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpColumn;
import com.sxdl.hp.entity.HpExprotExecl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpExprotExeclDao extends BaseDao<HpExprotExecl> {

    /**
     * 根据导出模版id查询配置的字段列表
     */
    @Select(" select * from  hp_exportexecl where export_id =${export_id} ")
    List<HpExprotExecl> findDataByExportId(Integer export_id);

    @Delete(" delete from    hp_exportexecl where export_id =${export_id} ")
    Integer delDataByExportId(Integer export_id);

    @Select("select name,name_zh,table_name,export_case from hp_column  where isnull(is_export,'0')='1'  " +
            "and (table_name!='dl_fllow' or  (table_name='dl_fllow' and isnull(is_show,0)=1)) order by name ")
    List<HpColumn> findCanExeclColumn();
}
