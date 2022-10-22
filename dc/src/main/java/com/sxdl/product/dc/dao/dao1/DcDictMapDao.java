package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.product.dc.entity.DcDictMap;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DcDictMapDao extends BaseDao<DcDictMap> {


    @Select("select * from dc_dict_map where his_code = '${his_code}' and dc_column_id = '${col_id}' order by dc_val_id")
    List<DcDictMap> findDataByHisCodeAndColId(String his_code, String col_id);


//    @Cacheable(value = "HpDictMapDao.findDataByHisEnableAndHisCodeData",key="#hiscode")
    @Select("select a.* from dc_dict_map a right join dc_column b on a.dc_column_id=b.id where a.his_code = '${hiscode}' and isnull(b.is_on,0)=1 ")
    List<DcDictMap> findDataByHisEnableAndHisCodeData(String hiscode);

    @Delete("delete from dc_dict_map where his_code='${his_code}' and dc_column_id = '${id}'")
    Integer deleteByHisCodeAndColId(String his_code, String id);


}
