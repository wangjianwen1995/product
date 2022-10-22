package com.sxdl.drplus.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.drplus.entity.DrplusIndexRemind;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DrplusIndexRemindDao extends BaseDao<DrplusIndexRemind> {


    @Select(" select count(1) from drplus_index_remind where id_rule = '${str}'")
    Integer isExists(String str);

    @Update(" update drplus_index_remind set states =${states} , operate_time =convert(varchar(19),getDate(),120)  where id = ${id}")
    Integer OffIndexRemind(Integer id,Integer states);


    @Select(" select  * from drplus_index_remind order by id desc ")
    List<DrplusIndexRemind> getRemindData();

}
