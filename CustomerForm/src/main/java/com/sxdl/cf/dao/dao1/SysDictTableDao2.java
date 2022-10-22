package com.sxdl.cf.dao.dao1;

import com.sxdl.cf.config.PrefixConfig;
import com.sxdl.cf.dao.BaseDao;
import com.sxdl.cf.entity.SysDictTable;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;


public interface SysDictTableDao2 extends BaseDao<SysDictTable> {



    @Select(" select distinct  val,name  from "+ PrefixConfig.PREFIX +"sys_dict_val where dict_id = ${pid} ")
    List<LinkedHashMap<String,Object> > getDictData(String pid);

    @Select(" select * from ${table_name} where id = '${data_id}'" )
    LinkedHashMap<String, Object> getDataFormById(String table_name, String data_id);


    @Select(" select * from ${table_name} where maintable_id = '${pid}'  " )
    List<LinkedHashMap<String, Object>> getDataFormByPid(String table_name, String pid);


    @Select(" select * from ${table_name} where maintable_id = '${pid}'  " )
    LinkedHashMap<String, Object> getDataFormByPidOfOneToOne(String table_name, String pid);
}