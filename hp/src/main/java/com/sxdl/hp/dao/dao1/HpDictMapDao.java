package com.sxdl.hp.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hp.entity.HpDictMap;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HpDictMapDao extends BaseDao<HpDictMap> {

    @Select("select * from hp_dict_map where his_code = '${his_code}' and hp_column_id = '${col_id}' order by hp_val_id")
    List<HpDictMap> findDataByHisCodeAndColId(String his_code, String col_id);

    @Select("select * from hp_dict_map where his_code = '${hiscode}' and hp_column_name = '${colname}' order by hp_val_id")
    List<HpDictMap> findDataByHisCodeAndColName(String hiscode, String colname);

    @Select("select a.* from hp_dict_map a right join hp_column b on a.hp_column_id=b.id where a.his_code = '${hiscode}' and isnull(b.is_hisenable,0)=1 ")
    List<HpDictMap> findDataByHisEnableAndHisCodeData(String hiscode);

    @Delete(" delete from hp_dict_map where his_code='${his_code}' and hp_column_id = '${id}'")
    Integer deleteByHisCodeAndColId(String his_code, String id);

    @Select("select * from hp_dict_map where his_code='${hisCode}'")
    List<HpDictMap> findDataByHisCode(String hisCode);
}
