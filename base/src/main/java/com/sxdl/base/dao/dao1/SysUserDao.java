package com.sxdl.base.dao.dao1;

import com.sxdl.base.config.PrefixConfig;
import com.sxdl.base.dao.BaseDao;
import com.sxdl.base.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysUserDao extends BaseDao<SysUser> {

    @Update (
            " begin tran " +
            " begin try " +
            " DECLARE @start INT,@end INT " +
            " SELECT @start=COUNT(*) FROM "+ PrefixConfig.PREFIX +"sys_user sys_user " +
            " INSERT INTO "+ PrefixConfig.PREFIX +"sys_user(status, name,code,login_name,pwd,title,position,yq_id,yq_name,ks_id,ks_name,staff_type,update_time,staff_id,kk_ks)" +
            " SELECT 2 status, name,code,code login_name,SUBSTRING(sys.fn_sqlvarbasetostr(HashBytes('MD5',code+'123')),3,32) pwd , " +
            "       title,position,yq_id,yq_name,ks_id,ks_name,staff_type,CONVERT(VARCHAR(19),GETDATE(),120) update_time,id staff_id,'='+ks_id" +
            " FROM  sys_staff" +
            " WHERE not  EXISTS(SELECT 1 FROM  "+ PrefixConfig.PREFIX +"sys_user sys_user WHERE sys_user.code = sys_staff.code) " +
            " INSERT INTO "+ PrefixConfig.PREFIX +"sys_user_vs_role ( user_id , user_name , role_id , role_name ) " +
            " SELECT id,name,7 role_id,'医护组'   role_name " +
            " FROM "+ PrefixConfig.PREFIX +"sys_user sys_user " +
            " WHERE NOT EXISTS(SELECT * FROM "+ PrefixConfig.PREFIX +"sys_user_vs_role sys_user_vs_role WHERE sys_user_vs_role.user_id=sys_user.id) " +
            "INSERT INTO "+ PrefixConfig.PREFIX +"sys_user_vs_ks( user_id , user_name , ks_id , ks_name )" +
            "SELECT id,name,ks_id ks_id,ks_name   ks_name " +
            "FROM "+ PrefixConfig.PREFIX +"sys_user sys_user WHERE NOT EXISTS(SELECT * FROM "+ PrefixConfig.PREFIX +"sys_user_vs_ks sys_user_vs_ks WHERE sys_user_vs_ks.user_id=sys_user.id )"+
            " SELECT @end=COUNT(*) FROM "+ PrefixConfig.PREFIX +"sys_user " +
            " SELECT  @end-@start " +
            " end try " +
             " begin catch " +
             "  SELECT -1 " +
             "  rollback tran " +
             "end catch")
    Integer AutoUpateUser();

    @Update("update "+ PrefixConfig.PREFIX +"sys_user   set  pwd = ?1 where  id =?2")
    void updatePwd(@Param ( "newpwd" ) String newpwd,@Param ( "id" ) Integer id);


    @Select("select * from "+ PrefixConfig.PREFIX +"sys_user  where status = 2")
    List<SysUser> selectEable();

    @Update("update "+ PrefixConfig.PREFIX +"sys_user set ks_id=${kscode} ,ks_name=${ksname} where id = ${userid}")
    Integer updatePlaceKs(Integer userid, String kscode, String ksname);


    @Select(" select * from "+ PrefixConfig.PREFIX +"sys_user where status = 2 and (name like '${val}' or code like '${val}') ")
    List<SysUser> selectByVal(String val);
    @Select(" select * from "+ PrefixConfig.PREFIX +"sys_user where ks_id = '${kscode}' and status = 2  and ( name like '${val}' or code like '${val}')")
    List<SysUser> selectVal(  String val);

    @Select(" select * from "+ PrefixConfig.PREFIX +"sys_user where  status = 2  and ( name like '${val}' or code like '${val}')")
    List<SysUser> selectKsAndVal(String kscode, String val);
}
