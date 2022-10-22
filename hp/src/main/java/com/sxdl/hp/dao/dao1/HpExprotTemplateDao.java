package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpExportTemplate;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HpExprotTemplateDao extends BaseDao<HpExportTemplate> {

    @Select(" select * from  hp_exporttemplate where user_id =${user_id} ")
    List<HpExportTemplate> findDataByUserId(Integer user_id);

    @Update("update hp_exporttemplate set is_default = 0 where user_id = ${user_id}")
    void offUserDefault(Integer user_id);

    @Update("update hp_exporttemplate set is_default = 1 where id = ${id}")
    void onUserDefault(Integer id);

    @Select(" select top 1 id from  hp_exporttemplate where  is_default = 1 ")
    Integer findDefault();

    /**
     * 排除自己以外是否有默认的模版
     * @param id
     * @return
     */
    @Select(" select 1 from  hp_exporttemplate where  is_default = 1 and id !=${id}")
    Integer findDefaultExceptSelf(Integer id);

    /**
     * 查询模版中字段不为空的
     * @return
     */
    @Select("select * from  hp_exporttemplate where id in(select DISTINCT export_id from hp_exportexecl) ")
    List<HpExportTemplate> getTemplateByColNotNull();

    /**
     * 查所有模版
     * @return
     */
    @Select("select * from hp_exporttemplate ")
    List<HpExportTemplate> getAllTemplate();

    /**
     * 查除了自己以外的总条数
     * @param id
     * @return
     */
    @Select("select count(*) from hp_exporttemplate where id !=${id}")
    Integer getAllTemplateExceptSelf(Integer id);

    /**
     * 查除了自己以外的配置的字段最少的模版
     * @return
     */
    @Select("select top 1 id from hp_exporttemplate where id in(" +
            "select export_id from hp_exportexecl GROUP BY export_id HAVING count(export_id)=(" +
            "select min(cnt) from (" +
            "select export_id,count(export_id) as cnt from hp_exportexecl GROUP BY export_id)a)) and id!=${id}")
    Integer getMinLenColsTemplateExceptSelf(Integer id);

    /**
     * 更新自己的为默认,其他全部置空
     * @param id
     */
    @Select("update hp_exporttemplate set is_default=case when id=${id} then 1 end")
    void updateSelfDefault(Integer id);
}
