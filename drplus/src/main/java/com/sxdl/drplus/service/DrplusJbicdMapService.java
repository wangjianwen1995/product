package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.drplus.dao1.DrplusJbicdDao;
import com.sxdl.drplus.dao1.DrplusJbicdMapDao;
import com.sxdl.drplus.entity.DrplusJbicdMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class DrplusJbicdMapService extends BaseUUIDServiceImpl<DrplusJbicdMap> {

    @Autowired
    private DrplusJbicdMapDao jbicdMapDao;
    @Autowired
    private DrplusJbicdDao jbicdDao;



    public List<DrplusJbicdMap> getContrastDate(Integer leftid, Integer rightid,String lval,String rval,String rval2) {
        if(StringUtils.isEmpty(rval2)){
            return jbicdMapDao.getContrastDate(leftid,rightid,lval,rval);
        }else{
            return jbicdMapDao.getNotContrastDate(leftid,rightid,lval);
        }
    }

    public List<DrplusJbicdMap> selectLeftData(Integer lid, String lval) {
        return jbicdMapDao.selectLeftData(lid,lval);
    }

    public Integer autoContrastICD(Integer lid, Integer rid) {
        // 1 先插入左侧数据
        Integer i = jbicdMapDao.isnertsql(lid,rid);
        // 2 更新 对映关系
        return jbicdMapDao.autoContrastICD(lid,rid);
    }

    public Integer cleanMapping(Integer lid, Integer rid) {
        return jbicdMapDao.cleanMapping(lid,rid);
    }

    public Integer getCount(Integer lid, Integer rid) {
        return jbicdMapDao.getCount(lid,rid);
    }

    /**
     *
     * 大同医保上报
     * 编码转换 核心代码
     * @param lid
     * @param rid
     */
    public void transformationICD3(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p321","p322");
         i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p324","p325");
         i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p327","p328");
         i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p3291","p3292");
         i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p3294","p3295");
         i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p3297","p3298");
         i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p3281","p3282");
         i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p3284","p3285");
         i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p3287","p3288");
         i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p3271","p3272");
         i =  jbicdMapDao.transformationICD3(pid,extractId,lid,rid,"p3274","p3275");
    }




    public void transformationICD5(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer i =  jbicdMapDao.transformationICD67a(pid,extractId,lid,rid,"ZYZDBM_YB","ZYZDMC_YB");

        for (int j = 1; j < 16; j++) {
            i =  jbicdMapDao.transformationICD67b(pid,extractId,lid,rid,"QTZDBM"+j+"_YB","QTZDMC"+j+"_YB");
        }
    }

    public void transformationICD6(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer i =  jbicdMapDao.transformationICD67a(pid,extractId,lid,rid,"ZYZD_JBBM","ZYZD");
        i =  jbicdMapDao.transformationICD67a(pid,extractId,lid,rid,"JBBM1","WBYY");
        i =  jbicdMapDao.transformationICD67a(pid,extractId,lid,rid,"JBBM2","BLZD");
        for (int j = 1; j < 41; j++) {
            i =  jbicdMapDao.transformationICD67b(pid,extractId,lid,rid,"ZYZD_JBBM"+j,"QTZD"+j);
        }
    }

    public void transformationICD7(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  jbicdMapDao.transformationICD67a(pid,extractId,lid,rid,"C03C","C04N");
        integer =  jbicdMapDao.transformationICD67a(pid,extractId,lid,rid,"F02C","F03N");
        integer =  jbicdMapDao.transformationICD67a(pid,extractId,lid,rid,"C01C","C02N");
        //下面两个是病理 /损伤的
        integer =  jbicdMapDao.transformationICD67a(pid,extractId,lid,rid,"C09C","C10N");
        integer =  jbicdMapDao.transformationICD67a(pid,extractId,lid,rid,"C12C","C13N");
        for (int i = 1; i < 41; i++) {
            String j = i<10?"0"+i:i+"";
            integer =  jbicdMapDao.transformationICD67b(pid,extractId,lid,rid,"C06x"+j+"C","C07x"+j+"N");
        }
    }

    public void transformationICD8(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  jbicdMapDao.transformationICD8(pid,extractId,lid,rid,"JBDM","MZD_ZYZD");
        integer =  jbicdMapDao.transformationICD8(pid,extractId,lid,rid,"JBBM","MZZD_XYZD");
        integer =  jbicdMapDao.transformationICD8(pid,extractId,lid,rid,"ZB_JBBM","ZB");
        for(int i = 1;i < 8;i++){
            integer =  jbicdMapDao.transformationICD8(pid,extractId,lid,rid,"ZZ_JBBM"+i,"ZZ"+i);
            integer =  jbicdMapDao.transformationICD8(pid,extractId,lid,rid,"ZYZD_JBBM"+i,"QTZD"+i);
        }
        //下面两个是病理 /损伤的
        integer =  jbicdMapDao.transformationICD8(pid,extractId,lid,rid,"JBBM2","BLZD");
        integer =  jbicdMapDao.transformationICD8(pid,extractId,lid,rid,"JBBM1","WBYY");
        return;
    }

    public void transformationICD9(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBBM","MZZD");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBDM","ZYZD");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"H23","WBYY");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBMM","BLZD");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBDM1","QTZD1");
        for (int i = 2; i <16 ; i++) {
            integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBDM"+i,"QTZD"+i);
        }
    }




    public void transformationICD10(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  jbicdMapDao.transformationICD10(pid,extractId,lid,rid,"diag_code","diag_name");
    }

    public void transformationICD13(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBBM","MZZD");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBDM","ZYZD");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"WBYYBM","WBYY");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBMM","BLZD");
        for (int i = 1; i <16 ; i++) {
            integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBDM"+i,"QTZD"+i);
        }
    }


    public void transformationICD14(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBDM","MZZD");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBBM_GL","MZZD_GL");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBBM","ZYZD");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBDM_GL","ZYZD_GL");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"WBYY","SSHZDWBYY");
        integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"BLZD","BLZDJBBM");
        for (int i = 1; i <16 ; i++) {
            integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBBM"+i,"QTZD"+i);
            integer =  jbicdMapDao.transformationICD9(pid,extractId,lid,rid,"JBBM"+i+"_GL","QTZD"+i+"_GL");
        }
    }

    public void transformationICD15(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  jbicdMapDao.transformationICD15(pid,extractId,lid,rid,"diag_code","diag_name");
    }

    /**
     *         insert into drplus_jbicd_map ( left_code,left_name,right_code,right_name,left_version_id,right_version_id)
     *         select code,name,null,null,参数版本1 ,参数版本2 from drplus_jbicd
     *         where drplus_code_version_id =参数版本1 and  not exists( select 1 from drplus_jbicd_map where left_version_id =drplus_jbicd.id and  left_code = name)
     *
     *
     *          update a set a.right_code = b.right_code ,a.right_name = b.right_name
     *          from drplus_jbicd_map a,(前端脚本) b where a.left_code = b.left_code
     *
     *      *   key 前端脚本:  select distinct left_code as left_code ,left_name as left_name ,right_code as right_code,right_name as right_name  ,前端加 left_version_id  ,前端加  right_version_id from ttt where
     * @param sqltext
     * @param lvid
     * @param rvid
     * @return
     */
    public Integer saveImportDataICD(String sqltext,Integer lvid,Integer rvid) {
        StringBuilder sb = new StringBuilder();
        sb.append("  insert into drplus_jbicd_map ( left_code,left_name,right_code,right_name,left_version_id,right_version_id)");
        sb.append(" select code,name,null,null,"+lvid+","+rvid+" from drplus_jbicd where drplus_code_version_id = "+lvid);
        sb.append("  and  not exists( select 1 from drplus_jbicd_map where left_version_id =drplus_jbicd.id and  left_code = name) ");
        String str = sb.toString();
        Integer  integer = jbicdMapDao.insertbysql(str);

        StringBuilder sb2 = new StringBuilder();
        sb2.append(" update a set a.right_code = b.right_code ,a.right_name = b.right_name ");
        sb2.append(" from drplus_jbicd_map a,("+sqltext+") b where a.left_code = b.left_code and a.left_version_id = "+lvid+" and a.right_version_id="+rvid);
        Integer  integer2 = jbicdMapDao.updateSqlWithSQL(sb2.toString());
        //第二步
        return integer2;
    }

    public Integer getCountByVersionId(Integer lvid, Integer rvid) {
        return jbicdMapDao.getCountByVersionId(lvid,rvid);
    }

    // key sqltext:  select distinct left_code as left_code ,left_name as left_name ,right_code as right_code,right_name as right_name  ,前端加 left_version_id  ,前端加  right_version_id from ttt where
    public void delinsertICDSql(Integer lvid, Integer rvid, String sqltext) {
        Integer integer = jbicdMapDao.delByVersionId(lvid,rvid);
        StringBuilder sb = new StringBuilder();
        sb.append("  insert into drplus_jbicd_map (left_version_id,right_version_id, left_code,left_name,right_code,right_name)");
        sb.append(sqltext);
        String str = sb.toString();
        Integer integer2 = jbicdMapDao.insertbysql(str);
    }
}
