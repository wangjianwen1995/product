package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.drplus.dao1.DrplusSsicdMapDao;
import com.sxdl.drplus.entity.DrplusSsicdMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class DrplusSsicdMapService extends BaseUUIDServiceImpl<DrplusSsicdMap> {

    @Autowired
    private DrplusSsicdMapDao ssicdMapDao;


    public List<DrplusSsicdMap> getContrastDate(Integer leftid, Integer rightid,String lval,String rval,String rval2) {
        if(StringUtils.isEmpty(rval2)){
            return ssicdMapDao.getContrastDate(leftid,rightid,lval,rval);
        }else{
            return ssicdMapDao.getNotContrastDate(leftid,rightid,lval);
        }

    }

    public List<DrplusSsicdMap> selectLeftData(Integer leftid, String lval) {
        return ssicdMapDao.selectLeftData(leftid,lval);
    }
    public Integer autoContrastICD(Integer lid, Integer rid) {
        // 1 先插入左侧数据
        Integer i = ssicdMapDao.isnertsql(lid,rid);
        // 2 更新 对映关系
        return ssicdMapDao.autoContrastICD(lid,rid);
    }

    public Integer cleanMapping(Integer lid, Integer rid) {
        return ssicdMapDao.cleanMapping(lid,rid);

    }

    public Integer getCount(Integer lid, Integer rid) {
        return ssicdMapDao.getCount(lid,rid);
    }

    /**
     * 编码转换 核心代码
     * @param lid
     * @param rid
     */
    public void transformationICD3(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer i =  ssicdMapDao.transformationICD3(pid,extractId,lid,rid,"p490","p492");
        i =  ssicdMapDao.transformationICD3(pid,extractId,lid,rid,"p4911","p4913");
        i =  ssicdMapDao.transformationICD3(pid,extractId,lid,rid,"p4922","p4924");
        i =  ssicdMapDao.transformationICD3(pid,extractId,lid,rid,"p4533","p4535");
        i =  ssicdMapDao.transformationICD3(pid,extractId,lid,rid,"p4544","p4546");
        i =  ssicdMapDao.transformationICD3(pid,extractId,lid,rid,"p45002","p45004");
        i =  ssicdMapDao.transformationICD3(pid,extractId,lid,rid,"p45014","p45016");
        return;
    }

    /**
     * 编码转换 核心代码
     * @param lid
     * @param rid
     */
    public void transformationICD5(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer = null;
        for (int i = 1; i < 11; i++) {
            integer = ssicdMapDao.transformationICD3(pid,extractId,lid,rid," SSJCZBM_YB"+i,"SSJCZMC_YB"+i);
        }
        return;
    }


    public void transformationICD6(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  ssicdMapDao.transformationICD67a(pid,extractId,lid,rid,"SSJCZBM1","SSJCZMC1");
        for (int i = 2; i < 42; i++) {
            integer =  ssicdMapDao.transformationICD67b(pid,extractId,lid,rid,"SSJCZBM"+i,"SSJCZMC"+i);
        }
        return;
    }

    public void transformationICD7(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  ssicdMapDao.transformationICD67a(pid,extractId,lid,rid,"C14x01C","C15x01N");
        for (int i = 1; i < 41; i++) {
            String j = i<10?"0"+i:i+"";
            integer =  ssicdMapDao.transformationICD67b(pid,extractId,lid,rid,"C35x"+j+"C","C36x"+j+"N");
        }
        return;
    }

    public void transformationICD8(Integer pid,Integer extractId,Integer lid, Integer rid) {
        for (int i = 1; i < 7; i++) {
            Integer integer =  ssicdMapDao.transformationICD8(pid,extractId,lid,rid,"SSJCZBM"+i,"SSJCZMC"+i);
        }
        return;
    }

    public void transformationICD9(Integer pid,Integer extractId,Integer lid, Integer rid) {
        for (int i = 1; i < 8; i++) {
            Integer integer =  ssicdMapDao.transformationICD9(pid,extractId,lid,rid,"SSJCZBM"+i,"SSJCZMC"+i);
        }
        return;
    }

    public void transformationICD10(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  ssicdMapDao.transformationICD10(pid,extractId,lid,rid,"oprn_oprt_code","oprn_oprt_name");
        return;
    }
    public void transformationICD15(Integer pid,Integer extractId,Integer lid, Integer rid) {
        Integer integer =  ssicdMapDao.transformationICD15(pid,extractId,lid,rid,"oprn_oprt_code","oprn_oprt_name");
        return;
    }

    public void transformationICD13(Integer pid,Integer extractId,Integer lid, Integer rid) {
        for (int i = 1; i <= 10; i++) {
            Integer integer =  ssicdMapDao.transformationICD9(pid,extractId,lid,rid,"SSJCZBM"+i,"SSJCZBM"+i);
        }
    }

    public void transformationICD14(Integer pid,Integer extractId,Integer lid, Integer rid) {
        for (int i = 1; i <= 8; i++) {
            Integer integer =  ssicdMapDao.transformationICD9(pid,extractId,lid,rid,"SSJCZBM"+i,"SSJCZBM"+i);
            Integer integer2 =  ssicdMapDao.transformationICD9(pid,extractId,lid,rid,"SSJCZBM"+i+"_GL","SSJCZBM"+i+"_GL");
        }
    }

    public Integer getCountByVersionId(Integer lvid, Integer rvid) {
        return ssicdMapDao.getCountByVersionId(lvid,rvid);
    }






    /**
     *         insert into drplus_jbicd_map ( left_code,left_name,right_code,right_name,left_version_id,right_version_id)
     *         select code,name,null,null,参数版本1 ,参数版本2 from drplus_jbicd
     *         where drplus_code_version_id =参数版本1 and  not exists( select 1 from drplus_jbicd_map where left_version_id =drplus_jbicd.id and  left_code = name)
     *
     *
     *          update a set a.right_code = b.right_code ,a.right_name = b.right_name
     *          from drplus_jbicd_map a,(前端脚本) b where a.left_code = b.left_code
     * key 前端脚本:  select distinct left_code as left_code ,left_name as left_name ,right_code as right_code,right_name as right_name  ,前端加 left_version_id  ,前端加  right_version_id from ttt where
     * @param sqltext
     * @param lvid
     * @param rvid
     * @return
     */
    public Integer saveImportDataICD(String sqltext,Integer lvid,Integer rvid) {
        StringBuilder sb = new StringBuilder();
        sb.append("  insert into drplus_ssicd_map ( left_code,left_name,right_code,right_name,left_version_id,right_version_id)");
        sb.append(" select code,name,null,null,"+lvid+","+rvid+" from drplus_ssicd where drplus_code_version_id = "+lvid);
        sb.append("  and  not exists( select 1 from drplus_ssicd_map where left_version_id =drplus_ssicd.id and  left_code = name) ");
        String str = sb.toString();
        Integer  integer = ssicdMapDao.insertbysql(str);

        StringBuilder sb2 = new StringBuilder();
        sb2.append(" update a set a.right_code = b.right_code ,a.right_name = b.right_name ");
        sb2.append(" from drplus_ssicd_map a,("+sqltext+") b where a.left_code = b.left_code and a.left_version_id = "+lvid+" and a.right_version_id="+rvid);
        Integer  integer2 = ssicdMapDao.updateSqlWithSQL(sb2.toString());
        //第二步
        return integer2;
    }


    // key sqltext:  select distinct left_code as left_code ,left_name as left_name ,right_code as right_code,right_name as right_name  ,前端加 left_version_id  ,前端加  right_version_id from ttt where
    public void delinsertICDSql(Integer lvid, Integer rvid, String sqltext) {
        Integer integer = ssicdMapDao.delByVersionId(lvid,rvid);
        StringBuilder sb = new StringBuilder();
        sb.append("  insert into drplus_ssicd_map (left_version_id,right_version_id, left_code,left_name,right_code,right_name)");
        sb.append(sqltext);
        String str = sb.toString();
        Integer integer2 = ssicdMapDao.insertbysql(str);
        return;
    }


}

