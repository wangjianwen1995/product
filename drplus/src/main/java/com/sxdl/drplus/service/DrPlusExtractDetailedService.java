package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.DrPlusExtractDetailedDao;
import com.sxdl.drplus.dto.QQRDBO;
import com.sxdl.drplus.entity.DrPlusExtractDetailed;
import com.sxdl.drplus.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DrPlusExtractDetailedService extends BaseServiceImpl<DrPlusExtractDetailed> {

    @Autowired
    private DrPlusExtractDetailedDao extractDetailedDao;

    public DrPlusExtractDetailed insertData(Integer pid, String stime, String etime, Integer type,Integer isAuto) {
        DrPlusExtractDetailed extractDetailed = new DrPlusExtractDetailed();
        extractDetailed.setDrplus_platform_detailed_id(pid);
        extractDetailed.setStart_time(stime);
        extractDetailed.setEnd_time(etime);
        extractDetailed.setType(type);
        extractDetailed.setIs_auto(isAuto);
        extractDetailed.setCreate_time(DataUtil.getDateTime());
        int i = extractDetailedDao.insertSelective(extractDetailed);
        return  extractDetailed;
    }


    public void updateData(Integer id, String stime, String etime, Integer type) {
        DrPlusExtractDetailed extractDetailed = extractDetailedDao.selectByPrimaryKey(id);
        extractDetailed.setStart_time(stime);
        extractDetailed.setEnd_time(etime);
        extractDetailed.setType(type);
        int i = extractDetailedDao.updateByPrimaryKey(extractDetailed);
    }

    public List<DrPlusExtractDetailed> getQualityResultData(Integer pid   ,Integer is_auto,String tab) {
        return extractDetailedDao.getQualityResultData(pid, is_auto,tab);
    }

    public Integer insetSql(String sql) {
        return extractDetailedDao.insetSql(sql);
    }


    //将数据插入到 drplus_data_type 表中 同时修改抽取状态
    public void setConfig(Integer pid, Integer extract_id) {
        String tab="";
        if(6==pid||7==pid||10==pid||15==pid)
            tab = "a";
        String sql =" insert into drplus_data_type(id,drplus_platform_detailed_id,primarykey_val,review_type) " +
                " select NEWID(),"+pid+" ,PRIMAEYKEY ,0 from drplus_center_table_data"+pid+tab+" a " +
                " where drplus_extract_detailed_id="+extract_id+"  and " +
                " not exists(select 1 from drplus_data_type b where b.primarykey_val= a.PRIMAEYKEY and b.drplus_platform_detailed_id="+pid+" )";
        Integer update = insetSql(sql);

        Integer update2 = updateSqlWithSQL("update drplus_extract_detailed set state=1 where id = "+extract_id);

    }


    //将数据插入到 drplus_data_type 表中 同时修改抽取状态
    public void setConfigDataType(Integer pid, Integer extract_id) {
        String tab="";
        if(6==pid||7==pid||10==pid||15==pid)
            tab = "a";
        String sql =" insert into drplus_data_type(id,drplus_platform_detailed_id,primarykey_val,review_type) " +
                " select NEWID(),"+pid+" ,PRIMAEYKEY ,1 from drplus_center_table_data"+pid+tab+" a " +
                " where drplus_extract_detailed_id="+extract_id+"  and " +
                " not exists(select 1 from drplus_data_type b where b.primarykey_val= a.PRIMAEYKEY and b.drplus_platform_detailed_id="+pid+" )";
        Integer update = insetSql(sql);

        Integer update2 = updateSqlWithSQL("update drplus_extract_detailed set state=1 where id = "+extract_id);

    }


    /**
     *
     * @param pid
     * @param eid
     */
    public void delExtractData(Integer pid, Integer eid) {
        //1 判断 drplus_center_table_data+pid  where drplus_extract_detailed_id=eid 表中是否有数据 有删除
        //2 判断 drplus_control_result   where drplus_extract_detailed_id=eid
        //3 判断 drplus_errorlog   where drplus_extract_detailed_id
        //4 判断 drplus_extract_detailed where id=eid
        if(6==pid||7==pid||10==pid ||15==pid){
            String sql =" select count(1) from drplus_center_table_data"+pid+"a where drplus_extract_detailed_id="+eid;
            Integer integer = extractDetailedDao.selectNUM(sql);
            if(integer>0){
                String dela =" delete  from drplus_center_table_data"+pid+"a where drplus_extract_detailed_id="+eid;
                Integer integer1 = extractDetailedDao.deleteToSql(dela);
                String delb =" delete  from drplus_center_table_data"+pid+"b where drplus_extract_detailed_id="+eid;
                integer1 = extractDetailedDao.deleteToSql(delb);
                if(10==pid){
                    String delc =" delete  from drplus_center_table_data"+pid+"c where drplus_extract_detailed_id="+eid;
                    integer1 = extractDetailedDao.deleteToSql(delc);
                    String deld =" delete  from drplus_center_table_data"+pid+"d where drplus_extract_detailed_id="+eid;
                    integer1 = extractDetailedDao.deleteToSql(deld);
                }
                if(15==pid){
                    String delc =" delete  from drplus_center_table_data"+pid+"c where drplus_extract_detailed_id="+eid;
                    integer1 = extractDetailedDao.deleteToSql(delc);
                    String deld =" delete  from drplus_center_table_data"+pid+"d where drplus_extract_detailed_id="+eid;
                    integer1 = extractDetailedDao.deleteToSql(deld);
                    String dele =" delete  from drplus_center_table_data"+pid+"e where drplus_extract_detailed_id="+eid;
                    integer1 = extractDetailedDao.deleteToSql(dele);
                    String delf =" delete  from drplus_center_table_data"+pid+"f where drplus_extract_detailed_id="+eid;
                    integer1 = extractDetailedDao.deleteToSql(delf);
                    String delg =" delete  from drplus_center_table_data"+pid+"g where drplus_extract_detailed_id="+eid;
                    integer1 = extractDetailedDao.deleteToSql(delg);
                }
            }
        }else{
            String sql ="select count(1) from drplus_center_table_data"+pid+" where drplus_extract_detailed_id="+eid;
            Integer integer = extractDetailedDao.selectNUM(sql);
            if(integer>0){
                String del ="delete  from drplus_center_table_data"+pid+" where drplus_extract_detailed_id="+eid;
                integer = extractDetailedDao.deleteToSql(del);
            }
        }

        String sql2="select count(1) from drplus_control_result where drplus_extract_detailed_id="+eid;
        Integer integer2 = extractDetailedDao.selectNUM(sql2);
        if(integer2>0){
            String del2="delete  from drplus_control_result where drplus_extract_detailed_id="+eid;
            integer2 = extractDetailedDao.deleteToSql(del2);
        }

        String sql3="select count(1) from drplus_errorlog where drplus_extract_detailed_id="+eid;
        Integer integer3 = extractDetailedDao.selectNUM(sql3);
        if(integer3>0){
            String del3="delete  from drplus_errorlog where drplus_extract_detailed_id="+eid;
            integer3 = extractDetailedDao.deleteToSql(del3);
        }

        String sql4="select count(1) from drplus_extract_detailed where id="+eid;
        Integer integer4 = extractDetailedDao.selectNUM(sql4);
        if(integer4>0){
            String del4="delete  from drplus_extract_detailed where id="+eid;
            integer4 = extractDetailedDao.deleteToSql(del4);
        }
    }

    public List<QQRDBO> getQualityQuestionResult(Integer pid, Integer eid) {

        return extractDetailedDao.getQualityQuestionResult(pid,eid);
    }

}
