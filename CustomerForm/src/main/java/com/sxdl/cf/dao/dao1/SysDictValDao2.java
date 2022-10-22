package com.sxdl.cf.dao.dao1;

import com.sxdl.cf.config.PrefixConfig;
import com.sxdl.cf.dao.BaseDao;
import com.sxdl.cf.entity.SysDictVal;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SysDictValDao2 extends BaseDao<SysDictVal> {

    @Select(" select * from "+ PrefixConfig.PREFIX +"sys_dict_val where dict_name  = '${dictName}' and (val like '%${val}%' or   name like '%${val}%' )")
    List<SysDictVal> getDictionariesByName(String dictName, String val);

    @Select(" select * from "+PrefixConfig.PREFIX+"sys_dict_val where dict_name in( ${dictNames}) ")
    List<SysDictVal> getDictionariesByNameMuch(String dictNames);


    @Select(" select a.* from "+PrefixConfig.PREFIX+"sys_dict_val a left join "+PrefixConfig.PREFIX+"sys_dict_table b on a.dict_id=b.id and a.dict_name=b.name" +
            " where b.source_name =   '${sourceName}' ")
    List<SysDictVal> getDictionariesBySourceNameMuch(String sourceName);
}