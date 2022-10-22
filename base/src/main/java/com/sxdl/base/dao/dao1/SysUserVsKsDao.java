package com.sxdl.base.dao.dao1;

import com.sxdl.base.config.PrefixConfig;
import com.sxdl.base.dao.BaseDao;
import com.sxdl.base.entity.SysUserVsKs;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SysUserVsKsDao extends BaseDao<SysUserVsKs> {
    @Select("select * from "+ PrefixConfig.PREFIX +"sys_user_vs_ks a left join sys_ks b  ON b.id = a.id where  user_id = ${userid} ")
    List<SysUserVsKs> findByuserId(Integer userid);




    @Select("select distinct ''''+ ks_id+'''' as kscode  from  sys_staff where id =${staffid}" +
            "union" +
            " select distinct ''''+b.code+'''' from "+ PrefixConfig.PREFIX +"sys_user_vs_ks a left join sys_ks b on a.ks_id = b.id where a.user_id =${userid} ")
    List<String> findAddkscodes(Integer userid ,Integer staffid);

    @Select( " select distinct ''''+isnull(b.code,'')+'''' from "+ PrefixConfig.PREFIX +"sys_user_vs_ks a left join sys_ks b on a.ks_id = b.id where a.user_id =${userid} ")
    List<String> findAddkscode(Integer userid);

    @Select("select a.ks_id code,a.ks_name name from "+ PrefixConfig.PREFIX +"sys_user_vs_ks a left join sys_ks b  ON b.id = a.id where  user_id = ${userid} ")
    List<Map<String, Object>> findByuserId2(Integer userid);
}
