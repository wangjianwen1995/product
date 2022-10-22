package com.sxdl.sd.service.impl;

import com.sxdl.base.dao.dao1.SysUserDao;
import com.sxdl.base.dao.dao1.SysUserVsKsDao;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.sd.dao.dao1.Handle1Dao;
import com.sxdl.sd.dao.dao1.SdInfoColumnDao;
import com.sxdl.sd.dao.dao1.SdInfoDao;
import com.sxdl.sd.dao.dao1.SdPatientInfoDao;
import com.sxdl.sd.dao.dao2.HandleDao;
import com.sxdl.sd.entity.SdInfo;
import com.sxdl.sd.entity.SdInfoColumn;
import com.sxdl.sd.entity.SdInfoSource;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdPatientInfoService;
import com.sxdl.sd.util.SdApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class SdPatientInfoServiceImpl extends BaseServiceImpl<SdPatientInfo> implements SdPatientInfoService {
    @Autowired
    SdPatientInfoDao sdPatientInfoDao;
    @Autowired
    SysUserVsKsDao sysUserVsKsDao;
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    SdInfoDao sdInfoDao;
    @Autowired
    HandleDao handleDao;
    @Autowired
    Handle1Dao handle1Dao;

    @Autowired
    SdInfoColumnDao sdInfoColumnDao;

    @Autowired(required = false)
    HttpServletRequest request;


    @Override
    public List<SdPatientInfo> findBySome(Integer status, Integer uid, Integer sid, String role_name) {
        List<SdPatientInfo> sdPatientInfoList = null;
        SdPatientInfo sdPatientInfo = new SdPatientInfo ();
        // 根据用户查询--管理员类
        if (uid.equals ( 0 )) {
            //根据单病种查询--有sid
            if (sid != null && !sid.equals ( "" ) && sid > 0) {
                sdPatientInfo.setSd_info_id ( sid );
                sdPatientInfoList = sdPatientInfoDao.select ( sdPatientInfo );
                //根据状态查询--查所有
                if (status.equals ( 7 )) {
                    return sdPatientInfoList;
                } else {
                    //根据状态查询--有其他状态
                    if (sdPatientInfoList != null && sdPatientInfoList.size () > 0) {
                        sdPatientInfoList = sdPatientInfoList.stream ().filter
                                ( e -> e != null && e.getStatus ().equals ( status ) ).collect ( Collectors.toList () );
                    }
                }
                return sdPatientInfoList;
            } else {
                //根据单病种查询--没有sid
                //根据状态查询--查所有
                if (status.equals ( 7 )) {
                    sdPatientInfoList = sdPatientInfoDao.selectAll ();
                    return sdPatientInfoList;
                } else {
                    //根据状态查询--有其他状态
                    sdPatientInfo.setStatus ( status );
                    sdPatientInfoList = sdPatientInfoDao.select ( sdPatientInfo );
                    return sdPatientInfoList;
                }
            }
        } else {
            //根据用户查询--医生科主任各看各的-----因为科室是国家编码，所以可能导致权限变大
            //Integer[] ks = getKs ( uid );
            SysUser sysUser = getUserCode ( uid );
            //String ks = "ks_code  " + sysUser.getKk_standard ();
            String ks = "ks_code  " + sysUser.getKk_ks ();
            String code = sysUser.getCode ();
            if (role_name.equals ( "医生组" )) {
                //医生自己看自己的
                code = "'" + code + "'";
                sdPatientInfoList = sdPatientInfoDao.selectSome ( ks, "dr_code", code );
                //因为从病案拿不到主治医师的数据
                //sdPatientInfoList = sdPatientInfoDao.selectByKs ( ks );
            } else if (role_name.equals ( "科主任组" ) || role_name.equals ( "医务组" ) || role_name.equals ( "上报组" )) {
                //科主任/医务组看科室所有需要审核的数据
                sdPatientInfoList = sdPatientInfoDao.selectByKs ( ks );
                //科主任看提交给自己审核的数据
                //sdPatientInfoList = sdPatientInfoDao.selectSome ( ks, "director_code", code );
            } /*else if(role_name.equals ( "医务组" )){
                //sdPatientInfoList = sdPatientInfoDao.selectSome ( ks, "medical_code", code );
            }*/

            //根据单病种查询--有sid
            if (sid != null && !sid.equals ( "" ) && sid > 0) {
                if (sdPatientInfoList != null && sdPatientInfoList.size () > 0) {
                    sdPatientInfoList = sdPatientInfoList.stream ().filter
                            ( e -> e != null && e.getSd_info_id ().equals ( sid ) ).collect ( Collectors.toList () );
                    if (status.equals ( 7 )) {
                        return sdPatientInfoList;
                    } else {
                        if (sdPatientInfoList != null && sdPatientInfoList.size () > 0) {
                            sdPatientInfoList = sdPatientInfoList.stream ().filter
                                    ( e -> e != null && e.getStatus ().equals ( status ) ).collect ( Collectors.toList () );
                        }
                        return sdPatientInfoList;
                    }
                }
                return sdPatientInfoList;
            } else {
                if (status.equals ( 7 )) {
                    return sdPatientInfoList;
                }
                if (sdPatientInfoList != null && sdPatientInfoList.size () > 0) {
                    sdPatientInfoList = sdPatientInfoList.stream ().filter
                            ( e -> e != null && e.getStatus ().equals ( status ) ).collect ( Collectors.toList () );
                }
                return sdPatientInfoList;
            }
        }
    }

    private SysUser getUserCode(Integer uid) {
        SysUser sysUser = new SysUser ();
        sysUser.setId ( uid );
        SysUser sysUser1 = sysUserDao.selectOne ( sysUser );
        return sysUser1;
    }

    @Override
    public void updateSome(SdPatientInfo sdPatientInfo) {
        //此病人存在  修改
        Integer id = sdPatientInfo.getId ();
        Integer status = sdPatientInfo.getStatus ();
        SdPatientInfo sdPatientInfoOld = sdPatientInfoDao.selectByPrimaryKey ( id );
        String reject_reason = sdPatientInfo.getReject_reason ();
        if(status == -1 || status==3 ||status==5){
            if (reject_reason != null) {
                String reject_reasonOld = sdPatientInfoOld.getReject_reason ();
                if (reject_reasonOld != null) {
                    sdPatientInfo.setReject_reason ( reject_reasonOld + ";" + reject_reason );
                } else {
                    sdPatientInfo.setReject_reason ( reject_reason );
                }
            }
        }

        SimpleDateFormat myFmt = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
        String format = myFmt.format ( new Date () );
        if (status == 6) {
            sdPatientInfo.setCheck_ztime ( format );
        } else if (status == 4) {
            sdPatientInfo.setCheck_time ( format );
        }
        sdPatientInfoDao.updateByPrimaryKeySelective ( sdPatientInfo );
    }


    @Override
    public SdPatientInfo selectOne(Integer sid, String patientCode) {
        SdPatientInfo sdPatientInfo1 = new SdPatientInfo ();
        sdPatientInfo1.setPatient_code ( patientCode );
        sdPatientInfo1.setSd_info_id ( sid );
        SdPatientInfo sdPatientInfo2 = sdPatientInfoDao.selectOne ( sdPatientInfo1 );
        return sdPatientInfo2;
    }

    @Override
    public Map<String, Integer> selectLs(String edate, String sdate) {
        Map<String, Integer> map = new HashMap<> ();
        Integer jrtb = sdPatientInfoDao.selectls ( "submit_time", edate, sdate );
        Integer jrsh = sdPatientInfoDao.selectls ( "check_time", edate, sdate );
        Integer jrzs = sdPatientInfoDao.selectls ( "check_ztime", edate, sdate );
        Integer wtb = sdPatientInfoDao.selectwls ( "1" );
        Integer wsh = sdPatientInfoDao.selectwls ( "2" );
        Integer wzs = sdPatientInfoDao.selectwls ( "4" );
        map.put ( "jrtb", jrtb );
        map.put ( "jrsh", jrsh );
        map.put ( "jrzs", jrzs );
        map.put ( "wtb", wtb );
        map.put ( "wsh", wsh );
        map.put ( "wzs", wzs );
        return map;
    }

    @Override
    public List<Map<String, Object>> findByKs(String status, String cysdate, String cyedate,String tjsdate, String tjedate) {
        String sql = "select isnull(count(*),0) ls,b.name ks,b.code kscode from sd_patient_info a  left join sys_ks b   on a.ks_code=b.code  where  " + status +
                "  and (cy_time between '" + cysdate + "'  and '" + cyedate +  "'  or submit_time between '" + tjsdate + "'  and '" + tjedate + "')  group by b.name,b.code order by  ls desc";
//        System.out.println(sql);
        List<Map<String, Object>> list = sdPatientInfoDao.selectSqlWithSQL ( sql );
        return list;
    }

    /*@Override
    public List<Map<String, Object>> findByKsTj(String status, String tjsdate, String tjedate) {
        String sql = "select isnull(count(*),0) ls,b.name ks,b.code kscode from sd_patient_info a  left join sys_ks b   on a.ks_code=b.code  where  " + status +
                "  and submit_time between '" + tjsdate + "'  and '" + tjedate + "'  group by b.name,b.code order by  ls desc";
        List<Map<String, Object>> list = sdPatientInfoDao.selectSqlWithSQL ( sql );
        return list;
    }

    @Override
    public List<SdPatientInfo> findByksmxTj(String ks, String flag,String status,String tjsdate, String tjedate) {
        String sql="select d.name_zh source,  a.patient_code, a.name,b.name ks_code,c.name dr_code,director_code,a.cy_time,a.submit_time,a.check_time,a.check_ztime,a.reject_reason,SUBSTRING(a.reject_time,1,10) reject_time from sd_patient_info a left join sys_ks b on a.ks_code=b.code left join sys_user c on  a.dr_code=c.code LEFT JOIN dbo.sd_info d ON a.sd_info_id =d.id where  "+status+" and "+flag+"= '"+ks+"' and submit_time between'" +tjsdate + "' and '"+ tjedate +"'";
        List<SdPatientInfo> list=sdPatientInfoDao.findByksmx(sql );
        return  list;
    }*/

    @Override
    public List<Map<String, Object>> findBydr(String status, String cysdate, String cyedate) {
        String sql = "select isnull(count(*),0) ls,b.name dr ,b.code drcode from sd_patient_info a  left join sys_user b   on a.dr_code=b.code  where  " + status +
                "  and  cy_time between '" + cysdate + "'  and '" + cyedate + "'  group by b.name ,b.code order by  ls desc";
        List<Map<String, Object>> list = sdPatientInfoDao.selectSqlWithSQL ( sql );
        return list;
    }

    @Override
    public List<SdPatientInfo> findByksmx(String ks, String flag,String status,String cysdate, String cyedate,String tjsdate, String tjedate) {
        String sql="select d.name_zh source,  a.patient_code, a.name,b.name ks_code,c.name dr_code,director_code,a.cy_time,a.submit_time,a.check_time,a.check_ztime,a.reject_reason,SUBSTRING(a.reject_time,1,10) reject_time from sd_patient_info a left join sys_ks b on a.ks_code=b.code left join sys_user c on  a.dr_code=c.code LEFT JOIN dbo.sd_info d ON a.sd_info_id =d.id where  "+status+" and "+flag+"= '"+ks+"' and (cy_time between'" +cysdate + "' and '"+ cyedate +"' or submit_time between '" + tjsdate + "' and '" + tjedate + "')";
//        System.out.println(sql);
        List<SdPatientInfo> list=sdPatientInfoDao.findByksmx(sql );
        return  list;
    }



    @Override
    public SdPatientInfo insertSome(List<SdInfoSource> sdInfoSourceList, Integer sid, String patientCode) {
        //保存  sdPatientInfo
        SdPatientInfo sdPatientInfo1 = new SdPatientInfo ();
        SdInfoSource sdInfoSource1 = sdInfoSourceList.get ( 0 );
        sdPatientInfo1.setSd_info_id ( sid );
        sdPatientInfo1.setPatient_code ( patientCode );
        sdPatientInfo1.setKs_code ( sdInfoSource1.getCM_0_1_1_5 () );
        sdPatientInfo1.setStatus ( 1 );
        SimpleDateFormat myFmt = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss " );
        sdPatientInfo1.setCreate_time ( myFmt.format ( new Date () ) );
        sdPatientInfo1.setCy_time ( sdInfoSource1.getCM_0_2_4_2 () );
        sdPatientInfo1.setDirector_code ( sdInfoSource1.getDirector_code () );
        SysUser user = (SysUser)request.getSession().getAttribute("user");
        String code = user.getCode();
        sdPatientInfo1.setDr_code ( code);
        //sdPatientInfo1.setDr_code ( sdInfoSource1.getCM_0_1_1_3 () );
        sdPatientInfo1.setName ( sdInfoSource1.getName () );
        SdInfo sdInfo = sdInfoDao.selectByPrimaryKey ( sid );
        sdPatientInfo1.setSd_group_id ( sdInfo.getGroup_id () );
        sdPatientInfo1.setSource ( "补录" );
        sdPatientInfoDao.insert ( sdPatientInfo1 );
        SdPatientInfo sdPatientInfo = sdPatientInfoDao.selectByPrimaryKey ( sdPatientInfo1.getId () );
        System.out.println("cs11");
        //保存单病种
        List<SdInfo> sdInfos = (List<SdInfo>) SdApplicationRunnerImpl.contextMap.get ( "sdInfos" );
        List<SdInfo> sdInfoList = sdInfos.stream ().filter ( e -> null != e && e.getId ().equals ( sid ) ).collect ( Collectors.toList () );
        SdInfo sdInfo1 = sdInfoList.get ( 0 );
  /*      SdInfoColumn sdInfoColumn=new SdInfoColumn ();
        sdInfoColumn.setSd_info_id ( sid );
        List<SdInfoColumn> sdInfoColumns = sdInfoColumnDao.select (sdInfoColumn);*/

        List<SdInfoColumn> sdInfoColumns = sdInfo1.getColumns ();
        List<String> list = new ArrayList<> ();
        Set<String> set = new HashSet<> ();
        sdInfoColumns = sdInfoColumns.stream ().filter ( e -> null != e && e.getName ().contains ( "CM_" ) ).collect ( Collectors.toList () );
        //System.out.println (sdInfoColumns);
        //sdInfoColumns.forEach ( e -> list.add ( e.getName () ) );
        sdInfoColumns.forEach ( e -> set.add ( e.getName () ) );
        //System.out.println (sdInfoColumns);
        StringBuilder colum = new StringBuilder ();
        colum.append ( "caseId,age" );
        //list.forEach ( e -> colum.append ( "," + e ) );
        set.forEach ( e -> colum.append ( "," + e ) );
        //System.out.println (list);
        String columns = colum.toString ();
        //colum.append ( ")" );
        String name = sdInfo1.getName ();
        name = "sd_info_" + name;
        StringBuilder sql = new StringBuilder ();
        sql.append ( " begin tran " +
                " begin try \n" +
                " DECLARE @start INT,@end INT \n" +
                " SELECT @start=COUNT(*) FROM dbo." + name +
                " INSERT INTO " + name + "(" + columns + " )\n" +
                " SELECT  " + columns + "\n" +
                " FROM  sd_source where sd_source.caseId =" + patientCode + "\n" +
                " update " + name + " set CM_0_1_1_3= b.name , CM_0_1_1_5= c.standard_ks_name from " + name + " a,sys_user b,sys_ks c  where a.caseId=" + patientCode + " and a.CM_0_1_1_3=b.code and  a.CM_0_1_1_5=c.code\n" +
                " SELECT @end=COUNT(*) FROM dbo." + name + "\n" +
                " SELECT  @end-@start \n" +
                " end try \n" +
                " begin catch \n" +
                "  SELECT -1 \n" +
                "  rollback tran \n" +
                "end catch" );
        int i = handle1Dao.excuteSqlWithSQL ( sql.toString () );
        return sdPatientInfo;
    }
}
