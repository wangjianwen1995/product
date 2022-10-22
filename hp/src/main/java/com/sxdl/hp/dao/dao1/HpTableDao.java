package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpTable;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface HpTableDao extends BaseDao<HpTable> {

    @Select(" select distinct table_name from hp_condition a " +
            " left join hp_condition_group b on a.pid = b.id  " +
            " left join hp_condition_template c on b.id = c.group_id " +
            " where user_id = ${userid} and table_name!='homepage' " +
            " union     " +
            " select distinct b.table_name  " +
            " from hp_query_template a  " +
            " left join hp_column b on b.id = a.column_id   " +
            " where user_id = ${userid} and b.table_name!='homepage' " )
    List<String> getUseTableName(Integer userid);

    @Select(" select distinct table_name from hp_condition a " +
            " left join hp_condition_group b on a.pid = b.id  " +
            " left join hp_condition_template c on b.id = c.group_id " +
            " where user_id = ${userid} and table_name!='homepage' " +
            " union     " +
            " select distinct b.table_name  " +
            " from hp_query_template a  " +
            " left join hp_column b on b.id = a.column_id   " +
            " where user_id = ${userid} and b.table_name!='homepage' " +
            " union " +
            " select distinct b.table_name   from hp_exporttemplate  a " +
            " left join hp_exportexecl b on a.id = b.export_id " +
            " where  a.user_id=${user_id}  and b.table_name!='homepage' ")
    List<String> getUseTableName2(Integer userid);

    /**
     * 查询是附页的,且不是院内附页的,且开启的某个省的附页
     * @param sheng_code 如题
     */
    @Select(" select count(*) from hp_table where sheng_code = '${sheng_code}' and " +
            " ispage =1 and is_diaolong =0 and is_enable = 1 ")
    Integer judgeEable(String sheng_code);

    @Update(" update hp_table set is_enable = ${type} where id = '${id}'")
    Integer upEableType(String id, Integer type);

    @Select("select distinct id,name,name_zh from hp_table")
    List<Map<String, String>> findtablename();
}
