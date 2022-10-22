package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpColumn;
import com.sxdl.hp.entity.HpQueryTemplate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QueryTemplateDao extends BaseDao<HpQueryTemplate> {

    @Select(" select a.id,a.name,a.name_zh,a.column_type,a.size,a.scale," +
            "       a.table_id,a.table_name,a.is_report,a.is_show,a.is_zy," +
            "       a.web_name,a.is_query," +
            "       case when isnull(b.id,'')!='' then '1' " +
            "            else '0' end as isenable ,b.id template_id ,a.is_single , a.model_type " +
            " from hp_column a " +
            " right join hp_query_template b on a.id = b.column_id " +
            " where b.user_id =${user_id}  and (a.table_name!='dl_fllow' or  (a.table_name='dl_fllow' and isnull(is_show,0)=1)) order by b.xh ")
    List<HpColumn> findCanQueryCol(Integer user_id);

    @Delete("delete from hp_query_template where user_id = ${user_id}")
    Integer deleteByUserID(Integer user_id);

    @Select("select * from hp_column where isnull(is_gjcx,'0')='1' and (table_name ='homepage' or (table_name ='dl_fllow'  and isnull(is_show,0)=1)) )")
    List<HpColumn> findQueryCol();

    @Select("select * from hp_column where isnull(is_gjcx,'0')='1' and (table_name ='homepage' or (table_name ='dl_fllow' and isnull(is_show,0)=1 ) or (table_name ='${name}'))  ")
    List<HpColumn> findQueryCol2(String name);

    @Select("select * from hp_column where isnull(is_default,'0')='1'  and (table_name ='homepage' or table_name ='dl_fllow')  order by name_zh ")
    List<HpColumn> findIsDefaultCol();
}
