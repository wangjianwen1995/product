package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.drplus.dao1.*;
import com.sxdl.drplus.dto.DrQualityDBO;
import com.sxdl.drplus.dto.PatientDataDBO;
import com.sxdl.drplus.dto.ProcessDataDBO;
import com.sxdl.drplus.entity.DrPlusCenterTable;
import com.sxdl.drplus.entity.DrPlusErrorQualityLog;
import com.sxdl.drplus.entity.DrPlusHistoryUpdate;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
@Transactional
public class DrPlusCenterTableService extends BaseServiceImpl<DrPlusCenterTable> {

    public static final String LineBreak = "\r\n";
    private String TABLENAME="drplus_center_table_data";
    private String TABLENAMEIOC="drplus_center_table_data_ioc";
    @Autowired
    private DrPlusCenterTableDao centerTableDao;
    @Autowired
    private DrPlusHistoryUpdateService historyUpdateService;
    @Autowired
    private DrPlusControlResultService resultService;
    @Autowired
    private DrPlusPlatformDetailedDao platformDetailedDao;


    @Autowired
    private DrPlusControlProcessDataDao controlProcessDao;
    @Autowired
    private DrPlusErrorQualityLogDao errorProcessDao;

    @Autowired
    private DrPlusDataTypeDao dataTypeDao;



    public void insertCol(DrPlusCenterTable centerTable) {
        Integer pid = centerTable.getDrplus_platform_detailed_id();
        String tableType = StringUtils.isEmpty(centerTable.getTable_type())?"":centerTable.getTable_type();
        int i = centerTableDao.alterAddColumn(TABLENAME+pid+tableType,centerTable.getName(),centerTable.getColumn_type());
        int ioc = centerTableDao.alterAddColumn(TABLENAMEIOC+pid+tableType,centerTable.getName(),centerTable.getColumn_type());
        int i2 =centerTableDao.execAddExtendedProperty(centerTable.getName_zh(),TABLENAME+pid+tableType,centerTable.getName());
        i2 =centerTableDao.execAddExtendedProperty(centerTable.getName_zh(),TABLENAMEIOC+pid+tableType,centerTable.getName());
        int insert = centerTableDao.insert(centerTable);
    }

    public void updateCol(DrPlusCenterTable centerTable) {
        Integer pid = centerTable.getDrplus_platform_detailed_id();
        String tableType = StringUtils.isEmpty(centerTable.getTable_type())?"":centerTable.getTable_type();
        DrPlusCenterTable drPlusCenterTable = centerTableDao.selectByPrimaryKey(centerTable.getId());
        if(!centerTable.getColumn_type().equals(drPlusCenterTable.getColumn_type())){
            int i1 = centerTableDao.alterUpdateColumn(TABLENAME+pid+tableType,centerTable.getName(),centerTable.getColumn_type());
            i1 = centerTableDao.alterUpdateColumn(TABLENAMEIOC+pid+tableType,centerTable.getName(),centerTable.getColumn_type());
        }
        if(!centerTable.getName().equals(drPlusCenterTable.getName())){
            int i2 = centerTableDao.updateColname(TABLENAME+pid+tableType,drPlusCenterTable.getName(),centerTable.getName());
            i2 = centerTableDao.updateColname(TABLENAMEIOC+pid+tableType,drPlusCenterTable.getName(),centerTable.getName());
        }
        if(!centerTable.getName_zh().equals(drPlusCenterTable.getName_zh())){
            int i3 = centerTableDao.execUpdateExtendedProperty(centerTable.getName_zh(),TABLENAME+pid+tableType,centerTable.getName());
            i3 = centerTableDao.execUpdateExtendedProperty(centerTable.getName_zh(),TABLENAMEIOC+pid+tableType,centerTable.getName());
        }
        int i = centerTableDao.updateByPrimaryKey(centerTable);

    }



    public int getColumnsNumByname(Integer pid,String column) {
        return centerTableDao.getColumnsNumByname(pid,column);
    }

    public void delColumn( DrPlusCenterTable centerTable) {
        Integer pid = centerTable.getDrplus_platform_detailed_id();
        String tableType = StringUtils.isEmpty(centerTable.getTable_type())?"":centerTable.getTable_type();
        int i = centerTableDao.deleteByPrimaryKey(centerTable.getId());
        int i2 = centerTableDao.alterDeleteColumn(TABLENAME+pid+tableType,centerTable.getName());
        i2 = centerTableDao.alterDeleteColumn(TABLENAMEIOC+pid+tableType,centerTable.getName());
    }

    public List<DrPlusCenterTable> getLikeDateList(Integer pid,String val1,String val2,String val3,String val4) {
        if(StringUtils.isEmpty(val4)){
            return centerTableDao.getLikeDateList(pid,val1,val2,val3);
        }else {
            return centerTableDao.getLikeDateListPlus(pid,val1,val2,val3);
        }
    }

    public List<DrPlusCenterTable> getLikeDateListAdd(Integer pid,String val1,String val2,String val3 ,String val4) {

        if(StringUtils.isEmpty(val4)){
            return centerTableDao.getLikeDateListAdd(pid,val1,val2,val3);
        }else {
            return centerTableDao.getLikeDateListPlusAdd(pid,val1,val2,val3 );
        }
    }

    public List<DrPlusCenterTable> getLikeDateList2(Integer pid,String val1,String val2,String val3,String val4) {
        if(StringUtils.isEmpty(val4)){
            return centerTableDao.getLikeDateList2(pid,val1,val2,val3);
        }else{
            return centerTableDao.getLikeDateList3(pid,val1,val2);
        }
    }

    public List<String> getTableColumns(String name) {
        return centerTableDao.getTableColumns(name);
    }
    public List<String> getTableColumnsByVal(String name,String val) {
        return centerTableDao.getTableColumnsByVal(name,val);
    }


    public List<LinkedHashMap<String, String>> getUnmappedColumnList(String tablename, Integer pid,String val,Integer type ) {
        if(type!=2){
            return   centerTableDao.getUnmappedColumnList(tablename, pid, val, type);
        }else {
            return centerTableDao.getAllColumnList(tablename,pid,val);
        }
    }


    public List<LinkedHashMap<String, String>> getUnmappedColumnListAdd(String tablenameA,String tablenameB,Integer pid, String val ,Integer type  ) {
        if(type!=2){
            return   centerTableDao.getUnmappedColumnListAdd(tablenameA,tablenameB, pid, val, type);
        }else {
            return centerTableDao.getAllColumnListAdd(tablenameA,tablenameB, pid, val);
        }
    }

    public void getAutomappedColumn(String tablename, Integer pid) {
        centerTableDao.getAutomappedColumn(tablename,pid);
        return;
    }

    public void getAutomappedColumnAdd(String tablenameA,String tablenameB, Integer pid ) {
        centerTableDao.getAutomappedColumnAdd(tablenameA,tablenameB,pid);
        return;
    }

    public void getManualmappedColumn(String columnName, Integer id) {
        centerTableDao.getManualmappedColumn(columnName,id);
    }
    public void getReportManualmappedColumn(String columnName, Integer id) {
        centerTableDao.getReportManualmappedColumn(columnName,id);
    }
    public void getAutoReportManualmappedColumn( Integer pid) {
        centerTableDao.getAutoReportManualmappedColumn(pid);
    }

    public void cleanReportManualmappedColumn( Integer pid) {
        centerTableDao.cleanReportManualmappedColumn(pid);
    }

    public Integer getExistsMapping(Integer id) {
        return centerTableDao.getExistsMapping(id);
    }
    /**
     * 创建插入数据sql 并且执行
     * @param extract_id
     * @param pid
     * @param stime
     * @param etime
     * @param type 抽取类型 1 抽取遗漏数据  2抽取未审核数据(包括遗漏) 3 重新抽取已审核数据(包括未审核遗漏)  4 抽取上报失败数据(单单失败) 5 抽取除上报成功外的数据, 6抽取所有数据
     * @return 返回值是应该抽取的数量
     */
    public void createInsertIntoSqlAndExec(Integer extract_id, Integer pid, String stime, String etime, Integer type) {
        Integer integer = null;
        DrPlusPlatformDetailed detailed = platformDetailedDao.selectByPrimaryKey(pid);
        List<DrPlusCenterTable> list = centerTableDao.getColumnByPId(pid);
        StringBuilder sb1 = new StringBuilder(" insert into drplus_center_table_data"+pid+"( drplus_extract_detailed_id");
        StringBuilder sb2 = new StringBuilder(" select "  +extract_id);
        StringBuilder delsql = new StringBuilder();
        list.forEach(e->{
             if(!StringUtils.isEmpty(e.getSource_column())){
                 sb1.append(" ,"+e.getName()) ;
                 if(StringUtils.isEmpty(e.getSql())){
                     sb2.append(" ,a."+e.getSource_column());
                 }else{
                     sb2.append(" , "+e.getSql());
                 }
             }

        });
        sb2.append(" from "+detailed.getSource_table() +" a ").append(LineBreak);
        sb2.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1.append(" ) ").append(LineBreak);


        if(type==1){//  1 抽取遗漏数据


            //key 正式抽取
            sb2.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+" c where a.PRIMAEYKEY= c.PRIMAEYKEY   )" );
            sb1.append(sb2);
            Integer i1 =centerTableDao.executeInsertSqlScript(sb1.toString());
        }else if(type== 2){//2抽取未审核数据

            //key 删除数据
            delsql.append(" delete from drplus_center_table_data"+pid+" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"'");
            delsql.append(" and exists( select 1 from drplus_center_table_data"+pid+" a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            delsql.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+".PRIMAEYKEY and isnull(b.review_type,0)<=0)");
            Integer  i1 = centerTableDao.executeDeleteSqlScript(delsql.toString());


            //key 正式抽取
            sb2.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+" c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1.append(sb2);

            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1.toString());
        }else if(type== 3){//3 重新抽取已审核数据

            //key 删除数据
            delsql.append(" delete from drplus_center_table_data"+pid+" where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsql.append(" and exists( select 1 from drplus_center_table_data"+pid+" a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val ");
            delsql.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+".PRIMAEYKEY   and isnull(b.review_type,0) in (0,1,-1) and isnull(b.report_type,0)=0)");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsql.toString());


            //key 正式抽取
            sb2.append(" where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+" c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1.append(sb2);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1.toString());
        }else if(type== 4){ // 4 抽取上报失败数据

            //key 删除数据
            delsql.append(" delete from drplus_center_table_data"+pid+" where  CONVERT(VARCHAR(10), cqsj,120) between '"+stime+"' and '"+etime+"' ");
            delsql.append(" and exists( select 1 from drplus_center_table_data"+pid+" a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val  ");
            delsql.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+".PRIMAEYKEY    and isnull(b.report_type,0)=-1)");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsql.toString());


            //key 正式抽取
            sb2.append(" where CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+" c where a.PRIMAEYKEY = c.PRIMAEYKEY )" );
            sb1.append(sb2);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1.toString());
        }else if(type== 5){ // 5 抽取除上报成功外的数据,

            //key 删除数据
            delsql.append(" delete from drplus_center_table_data"+pid+" where  CONVERT(VARCHAR(10), cqsj,120) between '"+stime+"' and '"+etime+"' ");
            delsql.append(" and exists( select 1 from drplus_center_table_data"+pid+" a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val "  );
            delsql.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+".PRIMAEYKEY    and isnull(report_type,0)!=1)");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsql.toString());

            //key 正式抽取
            sb2.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+" c where a.PRIMAEYKEY = c.PRIMAEYKEY    )" );
            sb1.append(sb2);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1.toString());
        }else if(type== 6){//6抽取所有数据

            //key 删除数据
            delsql.append(" delete from drplus_center_table_data"+pid+" where   drplus_extract_detailed_id = "+extract_id);
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsql.toString());


            //key 正式抽取数据
            sb2.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+" c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1.append(sb2);
            Integer  i2 =centerTableDao.executeInsertSqlScript(sb1.toString());
        }else if(type==7){ //7 质控有问题的数据
            //key 删除数据
            delsql.append(" delete from drplus_center_table_data"+pid+" where   CONVERT(VARCHAR(10), cqsj,120)  between '"+stime+"' and '"+etime+"' ");
            delsql.append(" and exists( select 1 from drplus_control_result  a  where a.drplus_platform_detailed_id="+pid+" and a.primary_keyval = drplus_center_table_data"+pid+".PRIMAEYKEY  )");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsql.toString());


            //key 正式抽取数据
            sb2.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and "  );
            sb2.append("  exists ( select 1 from drplus_control_result  c  where c.drplus_platform_detailed_id="+pid+" and c.primary_keyval = a.PRIMAEYKEY  )");
            sb1.append(sb2);
            Integer  i2 =centerTableDao.executeInsertSqlScript(sb1.toString());

        }
        return;
    }


    public void createInsertIntoSqlAndExecToOne(Integer pid, Integer extract_id, String PRIMAEYKEY) {
        Integer integer = null;
        DrPlusPlatformDetailed detailed = platformDetailedDao.selectByPrimaryKey(pid);
        List<DrPlusCenterTable> list = centerTableDao.getColumnByPId(pid);
        StringBuilder sb1 = new StringBuilder(" insert into drplus_center_table_data"+pid+"( drplus_extract_detailed_id");
        StringBuilder sb2 = new StringBuilder(" select "  +extract_id);
        StringBuilder delsql = new StringBuilder();
        list.forEach(e->{
            if(!StringUtils.isEmpty(e.getSource_column())){
                sb1.append(" ,"+e.getName()) ;
                if(StringUtils.isEmpty(e.getSql())){
                    sb2.append(" ,a."+e.getSource_column());
                }else{
                    sb2.append(" , "+e.getSql());
                }
            }

        });
        sb2.append(" from "+detailed.getSource_table() +" a ").append(LineBreak);
        sb2.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1.append(" ) ").append(LineBreak);

        //key 删除数据
        delsql.append(" delete from drplus_center_table_data"+pid+" where   PRIMAEYKEY = '"+PRIMAEYKEY+"'");
        Integer  i1 =centerTableDao.executeDeleteSqlScript(delsql.toString());


        //key 正式抽取数据
        sb2.append(" where   PRIMAEYKEY = '"+PRIMAEYKEY+"'");
        sb1.append(sb2);
        Integer  i2 =centerTableDao.executeInsertSqlScript(sb1.toString());
    }


    /**
     * 超过1024字段的数据抽取
     * 创建插入数据sql 并且执行
     * @param extract_id
     * @param pid
     * @param stime
     * @param etime
     * @param type 抽取类型 1 抽取遗漏数据  2抽取未审核数据(包括遗漏) 3 重新抽取已审核数据(包括未审核遗漏)  4 抽取上报失败数据(单单失败) 5 抽取除上报成功外的数据, 6抽取所有数据
     * @return 返回值是应该抽取的数量
     */
    public void createInsertIntoSqlAndExecAdd(Integer extract_id, Integer pid, String stime, String etime, Integer type) {
        Integer integer = null;
        DrPlusPlatformDetailed detailed = platformDetailedDao.selectByPrimaryKey(pid);
        List<DrPlusCenterTable> listA = centerTableDao.getColumnByPIdAndTableType(pid,"a");
        List<DrPlusCenterTable> listB = centerTableDao.getColumnByPIdAndTableType(pid,"b");

        StringBuilder sb1a= new StringBuilder(" insert into drplus_center_table_data"+pid+"a"+" ( drplus_extract_detailed_id");
        StringBuilder sb1b = new StringBuilder(" insert into drplus_center_table_data"+pid+"b"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb2a = new StringBuilder(" select "  +extract_id);
        StringBuilder sb2b = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder delsqla = new StringBuilder();
        StringBuilder delsqlb = new StringBuilder();
        listA.forEach(e->{
            if(!StringUtils.isEmpty(e.getSource_column())){
                sb1a.append(" ,"+e.getName()) ;
                if(StringUtils.isEmpty(e.getSql())){
                    sb2a.append(" ,a."+e.getSource_column());
                }else{
                    sb2a.append(" , "+e.getSql());
                }
            }

        });
        listB.forEach(e->{
            if(!StringUtils.isEmpty(e.getSource_column())){
                sb1b.append(" ,"+e.getName()) ;
                if(StringUtils.isEmpty(e.getSql())){
                    sb2b.append(" ,a."+e.getSource_column());
                }else{
                    sb2b.append(" , "+e.getSql());
                }
            }

        });


        sb2a.append(" from "+detailed.getSource_table() +" a ").append(LineBreak);
        sb2a.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY =b.primarykey_val ").append(LineBreak);
        sb1a.append(" ) ").append(LineBreak);

        sb2b.append(" from "+detailed.getSource_table_add() +" a ").append(LineBreak);
        sb2b.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1b.append(" ) ").append(LineBreak);

        if(type==1){//  1 抽取遗漏数据


            //key 正式抽取
            sb2a.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and  not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY   )" );
            sb1a.append(sb2a);
            Integer i1 =centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and  not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY   )" );
            sb1b.append(sb2b);
            i1 =centerTableDao.executeInsertSqlScript(sb1b.toString());
        }else if(type== 2){//2抽取未审核数据

            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"'");
            delsqla.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            delsqla.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"a.PRIMAEYKEY and isnull(b.review_type,0)<=0)");
            Integer  i1 = centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"'");
            delsqlb.append(" and exists( select 1 from drplus_center_table_data"+pid+"b a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            delsqlb.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"b.PRIMAEYKEY and isnull(b.review_type,0)<=0)");
            i1 = centerTableDao.executeDeleteSqlScript(delsqlb.toString());


            //key 正式抽取
            sb2a.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1a.append(sb2a);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1b.append(sb2b);
            i2 = centerTableDao.executeInsertSqlScript(sb1b.toString());
        }else if(type== 3){//3 重新抽取已审核数据

            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqla.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val ");
            delsqla.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"a.PRIMAEYKEY   and isnull(b.review_type,0) in (0,1,-1) and isnull(b.report_type,0)=0)");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqlb.append(" and exists( select 1 from drplus_center_table_data"+pid+"b a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val ");
            delsqlb.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"b.PRIMAEYKEY   and isnull(b.review_type,0) in (0,1,-1) and isnull(b.report_type,0)=0)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());




            //key 正式抽取
            sb2a.append(" where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a  c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1a.append(sb2a);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"b  c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1b.append(sb2b);
            i2 = centerTableDao.executeInsertSqlScript(sb1b.toString());
        }else if(type== 4){ // 4 抽取上报失败数据

            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqla.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val  ");
            delsqla.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"a.PRIMAEYKEY    and isnull(b.report_type,0)=-1)");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqlb.append(" and exists( select 1 from drplus_center_table_data"+pid+"b a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val  ");
            delsqlb.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"b.PRIMAEYKEY    and isnull(b.report_type,0)=-1)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());


            //key 正式抽取
            sb2a.append(" where CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY )" );
            sb1a.append(sb2a);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY )" );
            sb1b.append(sb2b);
            i2 = centerTableDao.executeInsertSqlScript(sb1b.toString());
        }else if(type== 5){ // 5 抽取除上报成功外的数据,

            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqla.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val "  );
            delsqla.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"a.PRIMAEYKEY    and isnull(report_type,0)!=1)");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqlb.append(" and exists( select 1 from drplus_center_table_data"+pid+"b a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val "  );
            delsqlb.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"b.PRIMAEYKEY    and isnull(report_type,0)!=1)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());


            //key 正式抽取
            sb2a.append(" where  CONVERT(VARCHAR(10), CQSJ, 120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY    )" );
            sb1a.append(sb2a);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where  CONVERT(VARCHAR(10), CQSJ, 120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY    )" );
            sb1b.append(sb2b);
            i2 = centerTableDao.executeInsertSqlScript(sb1b.toString());
        }else if(type== 6){//6抽取所有数据

            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where  drplus_extract_detailed_id ="+extract_id);
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where   drplus_extract_detailed_id =  "+extract_id);
            i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());


            //key 正式抽取数据
            sb2a.append(" where   CONVERT(VARCHAR(10), CQSJ, 120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1a.append(sb2a);
            Integer  i2 =centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where   CONVERT(VARCHAR(10), CQSJ, 120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1b.append(sb2b);
            i2 =centerTableDao.executeInsertSqlScript(sb1b.toString());
        }else if(type==7){ //7 质控有问题的数据
            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where   CONVERT(VARCHAR(10), CQSJ, 120)  between '"+stime+"' and '"+etime+"' ");
            delsqla.append(" and exists( select 1 from drplus_control_result  a  where a.drplus_platform_detailed_id="+pid+" and a.primary_keyval = drplus_center_table_data"+pid+"a.PRIMAEYKEY  )");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where   CONVERT(VARCHAR(10), CQSJ, 120)  between '"+stime+"' and '"+etime+"' ");
            delsqlb.append(" and exists( select 1 from drplus_control_result  a  where a.drplus_platform_detailed_id="+pid+" and a.primary_keyval = drplus_center_table_data"+pid+"b.PRIMAEYKEY  )");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());


            //key 正式抽取数据
            sb2a.append(" where   CONVERT(VARCHAR(10), CQSJ, 120) between '"+stime+"' and '"+etime+"' and "  );
            sb2a.append("    exists ( select 1 from drplus_control_result  c  where c.drplus_platform_detailed_id="+pid+" and c.primary_keyval = a.PRIMAEYKEY  )");
            sb1a.append(sb2a);
            Integer  i2 =centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where   CONVERT(VARCHAR(10), CQSJ, 120) between '"+stime+"' and '"+etime+"' and "  );
            sb2b.append("   exists ( select 1 from drplus_control_result  c  where c.drplus_platform_detailed_id="+pid+" and c.primary_keyval = a.PRIMAEYKEY  )");
            sb1b.append(sb2b);
            i2 =centerTableDao.executeInsertSqlScript(sb1b.toString());

        }
        return;
    }


    public void createInsertIntoSqlAndExecAddToOne(Integer pid, Integer extract_id, String PRIMAEYKEY) {
        Integer integer = null;
        DrPlusPlatformDetailed detailed = platformDetailedDao.selectByPrimaryKey(pid);
        List<DrPlusCenterTable> listA = centerTableDao.getColumnByPIdAndTableType(pid,"a");
        List<DrPlusCenterTable> listB = centerTableDao.getColumnByPIdAndTableType(pid,"b");

        StringBuilder sb1a= new StringBuilder(" insert into drplus_center_table_data"+pid+"a"+" ( drplus_extract_detailed_id");
        StringBuilder sb1b = new StringBuilder(" insert into drplus_center_table_data"+pid+"b"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb2a = new StringBuilder(" select "  +extract_id);
        StringBuilder sb2b = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder delsqla = new StringBuilder();
        StringBuilder delsqlb = new StringBuilder();
        listA.forEach(e->{
            if(!StringUtils.isEmpty(e.getSource_column())){
                sb1a.append(" ,"+e.getName()) ;
                if(StringUtils.isEmpty(e.getSql())){
                    sb2a.append(" ,a."+e.getSource_column());
                }else{
                    sb2a.append(" , "+e.getSql());
                }
            }

        });
        listB.forEach(e->{
            if(!StringUtils.isEmpty(e.getSource_column())){
                sb1b.append(" ,"+e.getName()) ;
                if(StringUtils.isEmpty(e.getSql())){
                    sb2b.append(" ,a."+e.getSource_column());
                }else{
                    sb2b.append(" , "+e.getSql());
                }
            }

        });


        sb2a.append(" from "+detailed.getSource_table() +" a ").append(LineBreak);
        sb2a.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY =b.primarykey_val ").append(LineBreak);
        sb1a.append(" ) ").append(LineBreak);

        sb2b.append(" from "+detailed.getSource_table_add() +" a ").append(LineBreak);
        sb2b.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1b.append(" ) ").append(LineBreak);

        //key 删除数据
        delsqla.append(" delete from drplus_center_table_data"+pid+"a where  PRIMAEYKEY ='"+PRIMAEYKEY+"'");
        Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

        delsqlb.append(" delete from drplus_center_table_data"+pid+"b where   PRIMAEYKEY =  '"+PRIMAEYKEY+"'");
        i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());


        //key 正式抽取数据
        sb2a.append(" where  PRIMAEYKEY = '"+PRIMAEYKEY+"'" );
        sb1a.append(sb2a);
        Integer  i2 =centerTableDao.executeInsertSqlScript(sb1a.toString());

        sb2b.append(" where  PRIMAEYKEY = '"+PRIMAEYKEY+"'" );
        sb1b.append(sb2b);
        i2 =centerTableDao.executeInsertSqlScript(sb1b.toString());
    }

    public void createInsertIntoSqlAndExecAdd10(Integer extract_id, Integer pid, String stime, String etime, Integer type) {
        Integer integer = null;
        DrPlusPlatformDetailed detailed = platformDetailedDao.selectByPrimaryKey(pid);
        List<DrPlusCenterTable> listA = centerTableDao.getColumnByPIdAndTableType(pid,"a");
        List<DrPlusCenterTable> listB = centerTableDao.getColumnByPIdAndTableType(pid,"b");
        List<DrPlusCenterTable> listC = centerTableDao.getColumnByPIdAndTableType(pid,"c");
        List<DrPlusCenterTable> listD = centerTableDao.getColumnByPIdAndTableType(pid,"d");

        StringBuilder sb1a= new StringBuilder(" insert into drplus_center_table_data"+pid+"a"+" ( drplus_extract_detailed_id");
        StringBuilder sb1b = new StringBuilder(" insert into drplus_center_table_data"+pid+"b"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb1c = new StringBuilder(" insert into drplus_center_table_data"+pid+"c"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb1d = new StringBuilder(" insert into drplus_center_table_data"+pid+"d"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");

        StringBuilder sb2a = new StringBuilder(" select "  +extract_id);
        StringBuilder sb2b = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder sb2c = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder sb2d = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder delsqla = new StringBuilder();
        StringBuilder delsqlb = new StringBuilder();
        StringBuilder delsqlc = new StringBuilder();
        StringBuilder delsqld = new StringBuilder();

        listA.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                if(e.getName().contains("-")){
                    sb1a.append(" ,["+e.getName()+"]");
                    sb2a.append(" ,["+e.getName()+"]");
                }else{
                    sb1a.append(" ,"+e.getName());
                    sb2a.append(" ,"+e.getName());
                }

            }
        });
        listB.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1b.append(" ,"+e.getName()) ;
                sb2b.append(" , "+e.getName());
            }
        });
        listC.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1c.append(" ,"+e.getName()) ;
                sb2c.append(" , "+e.getName());
            }
        });
        listD.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1d.append(" ,"+e.getName()) ;
                sb2d.append(" , "+e.getName());
            }
        });

        sb2a.append(" from "+detailed.getSource_table() +" a ").append(LineBreak);
        sb2a.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY =b.primarykey_val ").append(LineBreak);
        sb1a.append(" ) ").append(LineBreak);

        sb2b.append(" from "+detailed.getSource_table_add() +" a ").append(LineBreak);
        sb2b.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1b.append(" ) ").append(LineBreak);

        sb2c.append(" from "+detailed.getSource_table_add_c() +" a ").append(LineBreak);
        sb2c.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1c.append(" ) ").append(LineBreak);

        sb2d.append(" from "+detailed.getSource_table_add_d() +" a ").append(LineBreak);
        sb2d.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1d.append(" ) ").append(LineBreak);


        if(type==1){//  1 抽取遗漏数据
            //key 正式抽取
            sb2a.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and  not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY   )" );
            sb1a.append(sb2a);
            Integer i1 =centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and  not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY   )" );
            sb1b.append(sb2b);
            i1 =centerTableDao.executeInsertSqlScript(sb1b.toString());

            sb2c.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and  not exists( select 1 from drplus_center_table_data"+pid+"c c where a.PRIMAEYKEY = c.PRIMAEYKEY   )" );
            sb1c.append(sb2c);
            i1 =centerTableDao.executeInsertSqlScript(sb1c.toString());


            sb2d.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and  not exists( select 1 from drplus_center_table_data"+pid+"d c where a.PRIMAEYKEY = c.PRIMAEYKEY   )" );
            sb1d.append(sb2d);
            i1 =centerTableDao.executeInsertSqlScript(sb1d.toString());

        }else if(type== 2){//2抽取未审核数据

            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"'");
            delsqla.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            delsqla.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"a.PRIMAEYKEY and isnull(b.review_type,0)<=0)");
            Integer  i1 = centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"'");
            delsqlb.append(" and exists( select 1 from drplus_center_table_data"+pid+"b a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            delsqlb.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"b.PRIMAEYKEY and isnull(b.review_type,0)<=0)");
            i1 = centerTableDao.executeDeleteSqlScript(delsqlb.toString());

            delsqlc.append(" delete from drplus_center_table_data"+pid+"c where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"'");
            delsqlc.append(" and exists( select 1 from drplus_center_table_data"+pid+"c a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            delsqlc.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"c.PRIMAEYKEY and isnull(b.review_type,0)<=0)");
            i1 = centerTableDao.executeDeleteSqlScript(delsqlc.toString());

            delsqld.append(" delete from drplus_center_table_data"+pid+"d where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"'");
            delsqld.append(" and exists( select 1 from drplus_center_table_data"+pid+"d a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            delsqld.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"d.PRIMAEYKEY and isnull(b.review_type,0)<=0)");
            i1 = centerTableDao.executeDeleteSqlScript(delsqld.toString());



            //key 正式抽取
            sb2a.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1a.append(sb2a);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1b.append(sb2b);
            i2 = centerTableDao.executeInsertSqlScript(sb1b.toString());

            sb2c.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"c c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1c.append(sb2c);
            i2 = centerTableDao.executeInsertSqlScript(sb1c.toString());


            sb2d.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"d c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1d.append(sb2d);
            i2 = centerTableDao.executeInsertSqlScript(sb1d.toString());

        }else if(type== 3){//3 重新抽取已审核数据

            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqla.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val ");
            delsqla.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"a.PRIMAEYKEY   and isnull(b.review_type,0) in (0,1,-1) and isnull(b.report_type,0)=0)");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqlb.append(" and exists( select 1 from drplus_center_table_data"+pid+"b a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val ");
            delsqlb.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"b.PRIMAEYKEY   and isnull(b.review_type,0) in (0,1,-1) and isnull(b.report_type,0)=0)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());

            delsqlc.append(" delete from drplus_center_table_data"+pid+"c where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqlc.append(" and exists( select 1 from drplus_center_table_data"+pid+"c a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val ");
            delsqlc.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"c.PRIMAEYKEY   and isnull(b.review_type,0) in (0,1,-1) and isnull(b.report_type,0)=0)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlc.toString());

            delsqld.append(" delete from drplus_center_table_data"+pid+"d where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqld.append(" and exists( select 1 from drplus_center_table_data"+pid+"d a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val ");
            delsqld.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"d.PRIMAEYKEY   and isnull(b.review_type,0) in (0,1,-1) and isnull(b.report_type,0)=0)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqld.toString());

            //key 正式抽取
            sb2a.append(" where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a  c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1a.append(sb2a);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"b  c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1b.append(sb2b);
            i2 = centerTableDao.executeInsertSqlScript(sb1b.toString());

            sb2c.append(" where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"c  c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1c.append(sb2c);
            i2 = centerTableDao.executeInsertSqlScript(sb1c.toString());

            sb2d.append(" where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"d  c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1d.append(sb2d);
            i2 = centerTableDao.executeInsertSqlScript(sb1d.toString());

        }else if(type== 4){ // 4 抽取上报失败数据

            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqla.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val  ");
            delsqla.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"a.PRIMAEYKEY    and isnull(b.report_type,0)=-1)");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqlb.append(" and exists( select 1 from drplus_center_table_data"+pid+"b a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val  ");
            delsqlb.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"b.PRIMAEYKEY    and isnull(b.report_type,0)=-1)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());

            delsqlc.append(" delete from drplus_center_table_data"+pid+"c where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqlc.append(" and exists( select 1 from drplus_center_table_data"+pid+"c a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val  ");
            delsqlc.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"c.PRIMAEYKEY    and isnull(b.report_type,0)=-1)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlc.toString());


            delsqld.append(" delete from drplus_center_table_data"+pid+"d where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            delsqld.append(" and exists( select 1 from drplus_center_table_data"+pid+"d a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val  ");
            delsqld.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"d.PRIMAEYKEY    and isnull(b.report_type,0)=-1)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqld.toString());


            //key 正式抽取
            sb2a.append(" where CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY )" );
            sb1a.append(sb2a);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY )" );
            sb1b.append(sb2b);
            i2 = centerTableDao.executeInsertSqlScript(sb1b.toString());


            sb2c.append(" where CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"c c where a.PRIMAEYKEY = c.PRIMAEYKEY )" );
            sb1c.append(sb2c);
            i2 = centerTableDao.executeInsertSqlScript(sb1c.toString());


            sb2d.append(" where CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"d c where a.PRIMAEYKEY = c.PRIMAEYKEY )" );
            sb1d.append(sb2d);
            i2 = centerTableDao.executeInsertSqlScript(sb1d.toString());
        }else if(type== 5){ // 5 抽取除上报成功外的数据,

            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where  CONVERT(VARCHAR(10), cqsj,120) between '"+stime+"' and '"+etime+"' ");
            delsqla.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val "  );
            delsqla.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"a.PRIMAEYKEY    and isnull(report_type,0)!=1)");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where  CONVERT(VARCHAR(10), cqsj,120) between '"+stime+"' and '"+etime+"' ");
            delsqlb.append(" and exists( select 1 from drplus_center_table_data"+pid+"b a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val "  );
            delsqlb.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"b.PRIMAEYKEY    and isnull(report_type,0)!=1)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());

            delsqlc.append(" delete from drplus_center_table_data"+pid+"c where  CONVERT(VARCHAR(10), cqsj,120) between '"+stime+"' and '"+etime+"' ");
            delsqlc.append(" and exists( select 1 from drplus_center_table_data"+pid+"c a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val "  );
            delsqlc.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"c.PRIMAEYKEY    and isnull(report_type,0)!=1)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlc.toString());

            delsqld.append(" delete from drplus_center_table_data"+pid+"d where  CONVERT(VARCHAR(10), cqsj,120) between '"+stime+"' and '"+etime+"' ");
            delsqld.append(" and exists( select 1 from drplus_center_table_data"+pid+"d a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val "  );
            delsqld.append(" where a.PRIMAEYKEY = drplus_center_table_data"+pid+"d.PRIMAEYKEY    and isnull(report_type,0)!=1)");
            i1 =centerTableDao.executeDeleteSqlScript(delsqld.toString());



            //key 正式抽取
            sb2a.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY    )" );
            sb1a.append(sb2a);
            Integer  i2 = centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY    )" );
            sb1b.append(sb2b);
            i2 = centerTableDao.executeInsertSqlScript(sb1b.toString());

            sb2c.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"c c where a.PRIMAEYKEY = c.PRIMAEYKEY    )" );
            sb1c.append(sb2c);
            i2 = centerTableDao.executeInsertSqlScript(sb1c.toString());

            sb2d.append(" where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"d c where a.PRIMAEYKEY = c.PRIMAEYKEY    )" );
            sb1d.append(sb2d);
            i2 = centerTableDao.executeInsertSqlScript(sb1d.toString());
        }else if(type== 6){//6抽取所有数据

            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where   drplus_extract_detailed_id ="+extract_id);
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where   drplus_extract_detailed_id ="+extract_id);
            i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());

            delsqlc.append(" delete from drplus_center_table_data"+pid+"c where   drplus_extract_detailed_id ="+extract_id);
            i1 =centerTableDao.executeDeleteSqlScript(delsqlc.toString());

            delsqld.append(" delete from drplus_center_table_data"+pid+"d where    drplus_extract_detailed_id ="+extract_id);
            i1 =centerTableDao.executeDeleteSqlScript(delsqld.toString());

            //key 正式抽取数据
            sb2a.append(" where   CONVERT(VARCHAR(10), CQSJ,120)  between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1a.append(sb2a);
            Integer  i2 =centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1b.append(sb2b);
            i2 =centerTableDao.executeInsertSqlScript(sb1b.toString());

            sb2c.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"c c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1c.append(sb2c);
            i2 =centerTableDao.executeInsertSqlScript(sb1c.toString());

            sb2d.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"d c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
            sb1d.append(sb2d);
            i2 =centerTableDao.executeInsertSqlScript(sb1d.toString());
        }else if(type==7){ //7 质控有问题的数据
            //key 删除数据
            delsqla.append(" delete from drplus_center_table_data"+pid+"a where   CONVERT(VARCHAR(10), cqsj,120) between '"+stime+"' and '"+etime+"' ");
            delsqla.append(" and exists( select 1 from drplus_control_result  a  where a.drplus_platform_detailed_id="+pid+" and a.primary_keyval = drplus_center_table_data"+pid+"a.PRIMAEYKEY  )");
            Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

            delsqlb.append(" delete from drplus_center_table_data"+pid+"b where   CONVERT(VARCHAR(10), cqsj,120) between '"+stime+"' and '"+etime+"' ");
            delsqlb.append(" and exists( select 1 from drplus_control_result  a  where a.drplus_platform_detailed_id="+pid+" and a.primary_keyval = drplus_center_table_data"+pid+"b.PRIMAEYKEY  )");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());

            delsqlc.append(" delete from drplus_center_table_data"+pid+"c where   CONVERT(VARCHAR(10), cqsj,120)   between '"+stime+"' and '"+etime+"' ");
            delsqlc.append(" and exists( select 1 from drplus_control_result  a  where a.drplus_platform_detailed_id="+pid+" and a.primary_keyval = drplus_center_table_data"+pid+"c.PRIMAEYKEY  )");
            i1 =centerTableDao.executeDeleteSqlScript(delsqlc.toString());

            delsqld.append(" delete from drplus_center_table_data"+pid+"d where   CONVERT(VARCHAR(10), cqsj,120)   between '"+stime+"' and '"+etime+"' ");
            delsqld.append(" and exists( select 1 from drplus_control_result  a  where a.drplus_platform_detailed_id="+pid+" and a.primary_keyval = drplus_center_table_data"+pid+"d.PRIMAEYKEY  )");
            i1 =centerTableDao.executeDeleteSqlScript(delsqld.toString());


            //key 正式抽取数据
            sb2a.append(" where   CONVERT(VARCHAR(10), CQSJ,120)  between '"+stime+"' and '"+etime+"' and "  );
            sb2a.append("    exists ( select 1 from drplus_control_result  c  where c.drplus_platform_detailed_id="+pid+" and c.primary_keyval = a.PRIMAEYKEY  )");
            sb1a.append(sb2a);
            Integer  i2 =centerTableDao.executeInsertSqlScript(sb1a.toString());

            sb2b.append(" where   CONVERT(VARCHAR(10), CQSJ,120)  between '"+stime+"' and '"+etime+"' and "  );
            sb2b.append("   exists ( select 1 from drplus_control_result  c  where c.drplus_platform_detailed_id="+pid+" and c.primary_keyval = a.PRIMAEYKEY  )");
            sb1b.append(sb2b);
            i2 =centerTableDao.executeInsertSqlScript(sb1b.toString());

            sb2c.append(" where   CONVERT(VARCHAR(10), CQSJ,120)  between '"+stime+"' and '"+etime+"' and "  );
            sb2c.append("   exists ( select 1 from drplus_control_result  c  where c.drplus_platform_detailed_id="+pid+" and c.primary_keyval = a.PRIMAEYKEY  )");
            sb1c.append(sb2c);
            i2 =centerTableDao.executeInsertSqlScript(sb1c.toString());

            sb2d.append(" where   CONVERT(VARCHAR(10), CQSJ,120)  between '"+stime+"' and '"+etime+"' and "  );
            sb2d.append("   exists ( select 1 from drplus_control_result  c  where c.drplus_platform_detailed_id="+pid+" and c.primary_keyval = a.PRIMAEYKEY  )");
            sb1d.append(sb2d);
            i2 =centerTableDao.executeInsertSqlScript(sb1d.toString());

        }
        return;
    }


    public void createInsertIntoSqlAndExecAdd15(Integer extract_id, Integer pid, String stime, String etime, Integer type) {
        Integer integer = null;
        DrPlusPlatformDetailed detailed = platformDetailedDao.selectByPrimaryKey(pid);
        List<DrPlusCenterTable> listA = centerTableDao.getColumnByPIdAndTableType(pid,"a");
        List<DrPlusCenterTable> listB = centerTableDao.getColumnByPIdAndTableType(pid,"b");
        List<DrPlusCenterTable> listC = centerTableDao.getColumnByPIdAndTableType(pid,"c");
        List<DrPlusCenterTable> listD = centerTableDao.getColumnByPIdAndTableType(pid,"d");
        List<DrPlusCenterTable> listE = centerTableDao.getColumnByPIdAndTableType(pid,"e");
        List<DrPlusCenterTable> listF = centerTableDao.getColumnByPIdAndTableType(pid,"f");
        List<DrPlusCenterTable> listG = centerTableDao.getColumnByPIdAndTableType(pid,"g");

        StringBuilder sb1a= new StringBuilder(" insert into drplus_center_table_data"+pid+"a"+" ( drplus_extract_detailed_id");
        StringBuilder sb1b = new StringBuilder(" insert into drplus_center_table_data"+pid+"b"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb1c = new StringBuilder(" insert into drplus_center_table_data"+pid+"c"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb1d = new StringBuilder(" insert into drplus_center_table_data"+pid+"d"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb1e = new StringBuilder(" insert into drplus_center_table_data"+pid+"e"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb1f = new StringBuilder(" insert into drplus_center_table_data"+pid+"f"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb1g = new StringBuilder(" insert into drplus_center_table_data"+pid+"g"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");

        StringBuilder sb2a = new StringBuilder(" select "  +extract_id);
        StringBuilder sb2b = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder sb2c = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder sb2d = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder sb2e = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder sb2f = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder sb2g = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder delsqla = new StringBuilder();
        StringBuilder delsqlb = new StringBuilder();
        StringBuilder delsqlc = new StringBuilder();
        StringBuilder delsqld = new StringBuilder();
        StringBuilder delsqle = new StringBuilder();
        StringBuilder delsqlf = new StringBuilder();
        StringBuilder delsqlg = new StringBuilder();

        listA.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                if(e.getName().contains("-")){
                    sb1a.append(" ,["+e.getName()+"]");
                    sb2a.append(" ,["+e.getName()+"]");
                }else{
                    sb1a.append(" ,"+e.getName());
                    sb2a.append(" ,"+e.getName());
                }

            }
        });
        listB.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1b.append(" ,"+e.getName()) ;
                sb2b.append(" , "+e.getName());
            }
        });
        listC.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1c.append(" ,"+e.getName()) ;
                sb2c.append(" , "+e.getName());
            }
        });
        listD.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1d.append(" ,"+e.getName()) ;
                sb2d.append(" , "+e.getName());
            }
        });

        listE.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1e.append(" ,"+e.getName()) ;
                sb2e.append(" , "+e.getName());
            }
        });

        listF.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1f.append(" ,"+e.getName()) ;
                sb2f.append(" , "+e.getName());
            }
        });
        listG.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1g.append(" ,"+e.getName()) ;
                sb2g.append(" , "+e.getName());
            }
        });

        sb2a.append(" from "+detailed.getSource_table() +" a ").append(LineBreak);
        sb2a.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY =b.primarykey_val ").append(LineBreak);
        sb1a.append(" ) ").append(LineBreak);

        sb2b.append(" from "+detailed.getSource_table_add() +" a ").append(LineBreak);
        sb2b.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1b.append(" ) ").append(LineBreak);

        sb2c.append(" from "+detailed.getSource_table_add_c() +" a ").append(LineBreak);
        sb2c.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1c.append(" ) ").append(LineBreak);

        sb2d.append(" from "+detailed.getSource_table_add_d() +" a ").append(LineBreak);
        sb2d.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1d.append(" ) ").append(LineBreak);

        sb2e.append(" from "+detailed.getSource_table_add_e() +" a ").append(LineBreak);
        sb2e.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1e.append(" ) ").append(LineBreak);

        sb2f.append(" from "+detailed.getSource_table_add_f() +" a ").append(LineBreak);
        sb2f.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1f.append(" ) ").append(LineBreak);

        sb2g.append(" from "+detailed.getSource_table_add_g() +" a ").append(LineBreak);
        sb2g.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1g.append(" ) ").append(LineBreak);


        //key 删除数据
        delsqla.append(" delete from drplus_center_table_data"+pid+"a where   drplus_extract_detailed_id ="+extract_id);
        Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

        delsqlb.append(" delete from drplus_center_table_data"+pid+"b where   drplus_extract_detailed_id ="+extract_id);
        i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());

        delsqlc.append(" delete from drplus_center_table_data"+pid+"c where   drplus_extract_detailed_id ="+extract_id);
        i1 =centerTableDao.executeDeleteSqlScript(delsqlc.toString());

        delsqld.append(" delete from drplus_center_table_data"+pid+"d where    drplus_extract_detailed_id ="+extract_id);
        i1 =centerTableDao.executeDeleteSqlScript(delsqld.toString());

        delsqle.append(" delete from drplus_center_table_data"+pid+"e where    drplus_extract_detailed_id ="+extract_id);
        i1 =centerTableDao.executeDeleteSqlScript(delsqle.toString());

        delsqlf.append(" delete from drplus_center_table_data"+pid+"f where    drplus_extract_detailed_id ="+extract_id);
        i1 =centerTableDao.executeDeleteSqlScript(delsqlf.toString());

        delsqlg.append(" delete from drplus_center_table_data"+pid+"g where    drplus_extract_detailed_id ="+extract_id);
        i1 =centerTableDao.executeDeleteSqlScript(delsqlg.toString());

        //key 正式抽取数据
        sb2a.append(" where   CONVERT(VARCHAR(10), CQSJ,120)  between '"+stime+"' and '"+etime+"' and" +
                " not exists( select 1 from drplus_center_table_data"+pid+"a c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
        sb1a.append(sb2a);
        Integer  i2 =centerTableDao.executeInsertSqlScript(sb1a.toString());

        sb2b.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                " not exists( select 1 from drplus_center_table_data"+pid+"b c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
        sb1b.append(sb2b);
        i2 =centerTableDao.executeInsertSqlScript(sb1b.toString());

        sb2c.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                " not exists( select 1 from drplus_center_table_data"+pid+"c c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
        sb1c.append(sb2c);
        i2 =centerTableDao.executeInsertSqlScript(sb1c.toString());

        sb2d.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                " not exists( select 1 from drplus_center_table_data"+pid+"d c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
        sb1d.append(sb2d);
        i2 =centerTableDao.executeInsertSqlScript(sb1d.toString());

        sb2e.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                " not exists( select 1 from drplus_center_table_data"+pid+"e c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
        sb1e.append(sb2e);
        i2 =centerTableDao.executeInsertSqlScript(sb1e.toString());

        sb2f.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                " not exists( select 1 from drplus_center_table_data"+pid+"f c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
        sb1f.append(sb2f);
        i2 =centerTableDao.executeInsertSqlScript(sb1f.toString());

        sb2g.append(" where   CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                " not exists( select 1 from drplus_center_table_data"+pid+"g c where a.PRIMAEYKEY = c.PRIMAEYKEY  )" );
        sb1g.append(sb2g);
        i2 =centerTableDao.executeInsertSqlScript(sb1g.toString());
    }


    public void createInsertIntoSqlAndExecAdd10ToOne(Integer pid, Integer extract_id,String PRIMAEYKEY  ) {
        Integer integer = null;
        DrPlusPlatformDetailed detailed = platformDetailedDao.selectByPrimaryKey(pid);
        List<DrPlusCenterTable> listA = centerTableDao.getColumnByPIdAndTableType(pid,"a");
        List<DrPlusCenterTable> listB = centerTableDao.getColumnByPIdAndTableType(pid,"b");
        List<DrPlusCenterTable> listC = centerTableDao.getColumnByPIdAndTableType(pid,"c");
        List<DrPlusCenterTable> listD = centerTableDao.getColumnByPIdAndTableType(pid,"d");

        StringBuilder sb1a= new StringBuilder(" insert into drplus_center_table_data"+pid+"a"+" ( drplus_extract_detailed_id");
        StringBuilder sb1b = new StringBuilder(" insert into drplus_center_table_data"+pid+"b"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb1c = new StringBuilder(" insert into drplus_center_table_data"+pid+"c"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");
        StringBuilder sb1d = new StringBuilder(" insert into drplus_center_table_data"+pid+"d"+" (drplus_extract_detailed_id, PRIMAEYKEY,CQSJ ");

        StringBuilder sb2a = new StringBuilder(" select "  +extract_id);
        StringBuilder sb2b = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder sb2c = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder sb2d = new StringBuilder(" select "+extract_id+", PRIMAEYKEY ,CQSJ");
        StringBuilder delsqla = new StringBuilder();
        StringBuilder delsqlb = new StringBuilder();
        StringBuilder delsqlc = new StringBuilder();
        StringBuilder delsqld = new StringBuilder();

        listA.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                if(e.getName().contains("-")){
                    sb1a.append(" ,["+e.getName()+"]");
                    sb2a.append(" ,["+e.getName()+"]");
                }else{
                    sb1a.append(" ,"+e.getName());
                    sb2a.append(" ,"+e.getName());
                }

            }
        });
        listB.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1b.append(" ,"+e.getName()) ;
                sb2b.append(" , "+e.getName());
            }
        });
        listC.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1c.append(" ,"+e.getName()) ;
                sb2c.append(" , "+e.getName());
            }
        });
        listD.forEach(e->{
            if(!StringUtils.isEmpty(e.getName())){
                sb1d.append(" ,"+e.getName()) ;
                sb2d.append(" , "+e.getName());
            }
        });

        sb2a.append(" from "+detailed.getSource_table() +" a ").append(LineBreak);
        sb2a.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY =b.primarykey_val ").append(LineBreak);
        sb1a.append(" ) ").append(LineBreak);

        sb2b.append(" from "+detailed.getSource_table_add() +" a ").append(LineBreak);
        sb2b.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1b.append(" ) ").append(LineBreak);

        sb2c.append(" from "+detailed.getSource_table_add_c() +" a ").append(LineBreak);
        sb2c.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1c.append(" ) ").append(LineBreak);

        sb2d.append(" from "+detailed.getSource_table_add_d() +" a ").append(LineBreak);
        sb2d.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY=b.primarykey_val ").append(LineBreak);
        sb1d.append(" ) ").append(LineBreak);



        //key 删除数据


        delsqla.append(" delete from drplus_center_table_data"+pid+"a where   PRIMAEYKEY ='"+PRIMAEYKEY+"'");
        Integer  i1 =centerTableDao.executeDeleteSqlScript(delsqla.toString());

        delsqlb.append(" delete from drplus_center_table_data"+pid+"b where   PRIMAEYKEY ='"+PRIMAEYKEY+"'");
        i1 =centerTableDao.executeDeleteSqlScript(delsqlb.toString());

        delsqlc.append(" delete from drplus_center_table_data"+pid+"c where   PRIMAEYKEY ='"+PRIMAEYKEY+"'");
        i1 =centerTableDao.executeDeleteSqlScript(delsqlc.toString());

        delsqld.append(" delete from drplus_center_table_data"+pid+"d where   PRIMAEYKEY ='"+PRIMAEYKEY+"'");
        i1 =centerTableDao.executeDeleteSqlScript(delsqld.toString());

        //key 正式抽取数据
        sb2a.append(" where  PRIMAEYKEY = '"+PRIMAEYKEY+"'" );
        sb1a.append(sb2a);
        Integer  i2 =centerTableDao.executeInsertSqlScript(sb1a.toString());

        sb2b.append(" where  PRIMAEYKEY = '"+PRIMAEYKEY+"'" );
        sb1b.append(sb2b);
        i2 =centerTableDao.executeInsertSqlScript(sb1b.toString());

        sb2c.append(" where PRIMAEYKEY = '"+PRIMAEYKEY+"'" );
        sb1c.append(sb2c);
        i2 =centerTableDao.executeInsertSqlScript(sb1c.toString());

        sb2d.append(" where  PRIMAEYKEY = '"+PRIMAEYKEY+"'" );
        sb1d.append(sb2d);
        i2 =centerTableDao.executeInsertSqlScript(sb1d.toString());
    }
    public Integer getProgressBar(  Integer pid, String stime, String etime, Integer type) {
        Integer integer = null;
        DrPlusPlatformDetailed detailed = platformDetailedDao.selectByPrimaryKey(pid);
        StringBuilder sb = new StringBuilder(" select count(1) ");


        if(type==1){
            //  1 抽取遗漏数据
            sb.append(" from "+detailed.getSource_table() +" a  with (nolock) ").append(LineBreak);
            // sb.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a."+detailed.getPrimarykey_column()+"=b.primarykey_val ").append(LineBreak);
            sb.append(" where CONVERT(VARCHAR(10), CQSJ,120)  between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+" c where a.PRIMAEYKEY= c.PRIMAEYKEY    )" );
        }else if(type== 2){
            //2抽取未审核数据
            sb.append(" from "+detailed.getSource_table()   +" c  with (nolock) ").append(LineBreak);
            sb.append(" where  CONVERT(VARCHAR(10), c.CQSJ,120) between '"+stime+"' and '"+etime+"'");
            sb.append(" and exists( select 1 from drplus_center_table_data"+pid+" a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            sb.append(" where a.PRIMAEYKEY = c.PRIMAEYKEY   and isnull(b.review_type,0)<=0)");
        }else if(type== 3){
            //3 重新抽取已审核数据
            sb.append(" from "+detailed.getSource_table()   +" c  with (nolock) ").append(LineBreak);
            sb.append(" where   CONVERT(VARCHAR(10), c.CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            sb.append(" and exists( select 1 from drplus_center_table_data"+pid+" a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            sb.append(" where a.PRIMAEYKEY = c.PRIMAEYKEY   and isnull(b.review_type,0) in (0,1,-1) and isnull(b.report_type,0)=0)");
        }else if(type== 4){
            // 4 抽取上报失败数据
            sb.append(" from "+detailed.getSource_table()   +" c  with (nolock) ").append(LineBreak);
            sb.append(" where    CONVERT(VARCHAR(10), c.CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            sb.append(" and exists( select 1 from drplus_center_table_data"+pid+" a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            sb.append(" where a.PRIMAEYKEY = c.PRIMAEYKEY    and isnull(b.report_type,0)=-1)");
        }else if(type== 5){
            // 5 抽取除上报成功外的数据,
            sb.append(" from "+detailed.getSource_table()   +" c  with (nolock) ").append(LineBreak);
            sb.append(" where   CONVERT(VARCHAR(10), c.CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            sb.append(" and exists( select 1 from drplus_center_table_data"+pid+" a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            sb.append(" where a.PRIMAEYKEY = c.PRIMAEYKEY   and isnull(b.report_type,0)!=1)");
        }else if(type== 6){
            // 6抽取所有数据
            sb.append(" from "+detailed.getSource_table() ).append(LineBreak);
            sb.append("  with (nolock)  where  CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
        }else if (type==7){
            sb.append("  from "+detailed.getSource_table()+"  c with (nolock) where   CONVERT(VARCHAR(10), CQSJ,120)  between '"+stime+"' and '"+etime+"' ");
            sb.append("  and exists( select 1 from drplus_control_result  a  where a.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY = c.PRIMAEYKEY  )");
        }
        integer =centerTableDao.executeSelectSqlScript(sb.toString());
        return integer;
    }

    public Integer getProgressBarAdd(  Integer pid, String stime, String etime, Integer type) {
        Integer integer = null;
        DrPlusPlatformDetailed detailed = platformDetailedDao.selectByPrimaryKey(pid);
        StringBuilder sb = new StringBuilder(" select count(1) ");


        if(type==1){
            //  1 抽取遗漏数据
            sb.append(" from "+detailed.getSource_table() +" c  with (nolock) ").append(LineBreak);
           // sb.append(" left join drplus_data_type b on b.drplus_platform_detailed_id="+pid+" and a."+detailed.getPrimarykey_column()+"=b.primarykey_val ").append(LineBreak);
            sb.append(" where CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' and" +
                    " not exists( select 1 from drplus_center_table_data"+pid+"a a where a.PRIMAEYKEY = c.PRIMAEYKEY    )" );
        }else if(type== 2){
            //2抽取未审核数据
            sb.append(" from "+detailed.getSource_table()   +" c  with (nolock) ").append(LineBreak);
            sb.append(" where  CONVERT(VARCHAR(10), c.CQSJ,120) between '"+stime+"' and '"+etime+"'");
            sb.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  " +
                    "               left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            sb.append("             where a.PRIMAEYKEY = c.PRIMAEYKEY   and isnull(b.review_type,0)<=0)");
        }else if(type== 3){
            //3 重新抽取已审核数据
            sb.append(" from "+detailed.getSource_table()   +" c  with (nolock) ").append(LineBreak);
            sb.append(" where   CONVERT(VARCHAR(10), c.CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            sb.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            sb.append(" where a.PRIMAEYKEY = c.PRIMAEYKEY   and isnull(b.review_type,0) in (0,1,-1) and isnull(b.report_type,0)=0)");
        }else if(type== 4){
            // 4 抽取上报失败数据
            sb.append(" from "+detailed.getSource_table()   +" c  with (nolock) ").append(LineBreak);
            sb.append(" where    CONVERT(VARCHAR(10), c.CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            sb.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            sb.append(" where a.PRIMAEYKEY = c.PRIMAEYKEY      and isnull(b.report_type,0)=-1)");
        }else if(type== 5){
            // 5 抽取除上报成功外的数据,
            sb.append(" from "+detailed.getSource_table()   +" c  with (nolock) ").append(LineBreak);
            sb.append(" where   CONVERT(VARCHAR(10), c.CQSJ,120) between '"+stime+"' and '"+etime+"' ");
            sb.append(" and exists( select 1 from drplus_center_table_data"+pid+"a a  left join drplus_data_type b on a.PRIMAEYKEY = b.primarykey_val and b.drplus_platform_detailed_id="+pid );
            sb.append(" where a.PRIMAEYKEY = c.PRIMAEYKEY   and isnull(b.report_type,0)!=1)");
        }else if(type== 6){
            // 6抽取所有数据
            sb.append(" from "+detailed.getSource_table() ).append(LineBreak);
            sb.append("  with (nolock)  where    CONVERT(VARCHAR(10), CQSJ,120) between '"+stime+"' and '"+etime+"' ");
        }else if (type==7){
            sb.append("  from "+detailed.getSource_table()+"  c with (nolock) where   CONVERT(VARCHAR(10), CQSJ,120)  between '"+stime+"' and '"+etime+"' ");
            sb.append("  and exists( select 1 from drplus_control_result  a  where a.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY = c.PRIMAEYKEY  )");
        }
        integer =centerTableDao.executeSelectSqlScript(sb.toString());
        return integer;
    }

    public Integer getCountextractSumWithNolock(Integer pid,Integer id){
        return centerTableDao.getCountextractSumWithNolock(pid,id);
    }

    public Integer getCountextractSumWithNolockAdd(Integer pid,Integer id){
        return centerTableDao.getCountextractSumWithNolockAdd(pid,id);
    }

    public Integer getCountextractSum(Integer pid ,Integer id) {
        return centerTableDao.getCountextractSum(pid,id);

    }

    public Integer getCountextractSumAdd(Integer pid ,Integer id) {
        return centerTableDao.getCountextractSumAdd(pid,id);
    }


    /**
     * 开启异步 查询进度条
     * @param pid
     * @param stime
     * @param etime
     * @param type
     * @param ex_id
     * @return
     */
    @Async
    public Future<String> asyncMethodWithNoReturnType(Integer pid,String stime, String etime, Integer type,Integer ex_id){
        //应该抽取的数量

        Integer sum =  getProgressBar(pid, stime, etime, type);
        //实时访问数据库里面的数量
        Integer extractSum = getCountextractSumWithNolock(pid, ex_id);
        if(0==sum ){
            return new AsyncResult<>("100");
        }
        if(  extractSum==0){
            return new AsyncResult<>("0.0");
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        String bar = numberFormat.format((float)extractSum/(float)sum*100);
        if(Float.parseFloat(bar)>100){
            return new AsyncResult<>("100.00");
        }
        return new AsyncResult<>(bar);
    }
 /**
     * 开启异步 查询进度条
     * @param pid
     * @param stime
     * @param etime
     * @param type
     * @param ex_id
     * @return
     */
    @Async
    public Future<String> asyncMethodWithNoReturnTypeAdd(Integer pid,String stime, String etime, Integer type,Integer ex_id){
        //应该抽取的数量

        Integer sum =  getProgressBarAdd(pid, stime, etime, type);
        //实时访问数据库里面的数量
        Integer extractSum = getCountextractSumWithNolockAdd(pid, ex_id);
        if(0==sum ){
            return new AsyncResult<>("100");
        }
        if(  extractSum==0){
            return new AsyncResult<>("0.0");
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        String bar = numberFormat.format((float)extractSum/(float)sum*100);
        if(Float.parseFloat(bar)>100){
            return new AsyncResult<>("100.00");
        }
        return new AsyncResult<>(bar);
    }

    public void clearMapping(Integer id) {
        centerTableDao.clearMapping(id);
    }


    public void clearOneMapping(Integer pid, Integer id) {
        centerTableDao.clearOneMapping(pid,id);
    }

    public Integer clearExistsMapping(Integer pid, Integer id) {
        return centerTableDao.clearExistsMapping(pid,id);
    }


    /**
     *
     * @param pid
     * @param timeColumn
     * @param stime
     * @param etime
     * @param type 0 未审 1 已审 -1 审核未通过  3已上报(转成1)  -3 上报失败(转-1)  2 未上报(转0) 4已撤销(2) -4撤销失败(-2)  9全部
     * @param val
     * @return
     *
     */
    private Integer convertType(Integer type) {
        Integer i = null;
        switch (type) {
            case -3:
                i= -1;
                break;
            case 4:
                i= 2;
                break;
            case -4:
                i= -2;
                break;
        }
        return i;
    }
    public List<LinkedHashMap> getPatientByPlatformId(Integer pid, String timeColumn, String stime, String etime,Integer type,String val) {
        List<LinkedHashMap> linkedHashMaps = new ArrayList<>();
        String typesql ="";
        if(9==type){
            typesql=" 1=1 ";
        }else if(0==type || 1==type || -1==type){
            typesql=" isnull(b.review_type,0)="+type+" ";
        }else if(3==type  ){ //已上报
            typesql = " b.review_type=1 and ( isnull(b.report_type,0)=1 or  isnull(b.report_type,0)=-2) ";
        }else if(2==type  ){ //未上报
            typesql = " b.review_type=1 and ( isnull(b.report_type,0)= 0 or isnull(b.report_type,0)= 2  )   ";
        }else {
            typesql=" isnull(b.report_type,0)="+convertType(type)+" ";
        }


        if (1==pid){

        }else if(2==pid){
            linkedHashMaps = centerTableDao.getPatientByPlatformId2(pid,timeColumn,stime,etime,typesql,val);
        }else if(3==pid){
            linkedHashMaps = centerTableDao.getPatientByPlatformId3(pid,timeColumn,stime,etime,typesql,val);
        }else if(4==pid){

        }else if(5==pid){
            linkedHashMaps = centerTableDao.getPatientByPlatformId5(pid,timeColumn,stime,etime,typesql,val);
        }else if(6==pid){
            linkedHashMaps = centerTableDao.getPatientByPlatformId6(pid,timeColumn,stime,etime,typesql,val);
        }else if(7==pid){
            linkedHashMaps = centerTableDao.getPatientByPlatformId7(pid,timeColumn,stime,etime,typesql,val);
        }else if(8==pid){
            linkedHashMaps = centerTableDao.getPatientByPlatformId8(pid,timeColumn,stime,etime,typesql,val);
        }else if(9==pid){
            linkedHashMaps = centerTableDao.getPatientByPlatformId9(pid,timeColumn,stime,etime,typesql,val);
        }else if(10==pid){
            linkedHashMaps = centerTableDao.getPatientByPlatformId10(pid,timeColumn,stime,etime,typesql,val);
        }

        return linkedHashMaps;
    }


    /**
     * 修改保存患者数据
     * @param map
     */
    public void savePatient(PatientDataDBO dataDBO) {

        Integer pid = dataDBO.getDrplus_platform_detailed_id();
        StringBuilder sb  =new StringBuilder();
        List<DrPlusHistoryUpdate> updates = dataDBO.getUpdates();
        if(updates.size()<1)
            return;
        sb.append("update drplus_center_table_data"+pid+" set ");
        updates.forEach(e->{
            if(null == e.getAfter_update()){
                sb.append(e.getColumn_en()+" = null,");
            }
            sb.append(" "+e.getColumn_en()+" = '"+e.getAfter_update()+"' ,");
        });
        StringBuilder stringBuilder = DataUtil.delLastChar(sb);
        stringBuilder.append(" where PRIMAEYKEY = '"+dataDBO.getPRIMAEYKEY()+"' ");
        centerTableDao.updateSqlWithSQL(stringBuilder.toString());
    }


    /**
     * 修改保存患者数据
     * @param map
     */
    public void savePatientAdd(PatientDataDBO dataDBO) {

        Integer pid = dataDBO.getDrplus_platform_detailed_id();
        StringBuilder sbA  =new StringBuilder();
        StringBuilder sbB  =new StringBuilder();
        List<DrPlusHistoryUpdate> updates = dataDBO.getUpdates();

        if(updates.size()<1)
            return;
        Map<String, List<DrPlusHistoryUpdate>> map = updates.stream().filter(e -> StringUtils.isEmpty(e.getTable_type())).collect(Collectors.groupingBy(e -> e.getTable_type()));

        List<DrPlusHistoryUpdate> tableA = map.get("a");

        sbA.append("update drplus_center_table_data"+pid+"a set ");
        tableA.forEach(e->{
            if(null == e.getAfter_update()){
                sbA.append(e.getColumn_en()+" = null,");
            }
            sbA.append(" "+e.getColumn_en()+" = '"+e.getAfter_update()+"' ,");
        });

        List<DrPlusHistoryUpdate> tableB = map.get("b");
        sbB.append("update drplus_center_table_data"+pid+"b set ");
        tableB.forEach(e->{
            if(null == e.getAfter_update()){
                sbB.append(e.getColumn_en()+" = null,");
            }
            sbB.append(" "+e.getColumn_en()+" = '"+e.getAfter_update()+"' ,");
        });

        StringBuilder stringBuilderA = DataUtil.delLastChar(sbA);
        StringBuilder stringBuilderB = DataUtil.delLastChar(sbB);
        stringBuilderA.append(" where PRIMAEYKEY = '"+dataDBO.getPRIMAEYKEY()+"' ");
        stringBuilderB.append(" where PRIMAEYKEY = '"+dataDBO.getPRIMAEYKEY()+"' ");
        centerTableDao.updateSqlWithSQL(stringBuilderA.toString());
        centerTableDao.updateSqlWithSQL(stringBuilderB.toString());
    }


    public void saveAllData(PatientDataDBO dataDBO){
        Integer pid = dataDBO.getDrplus_platform_detailed_id();
        Integer extract_id =   dataDBO.getDrplus_extract_detailed_id();
        String PRIMAEYKEY = dataDBO.getPRIMAEYKEY();
        //1 修改患者数据
        if(6==pid||7==pid){
            savePatientAdd(dataDBO);
        }else{
            savePatient(dataDBO);
        }
        // 2 修改留痕
        historyUpdateService.saveHistoryPatient(dataDBO);
        // 3重新 单个质控
        if(6==pid||7==pid){
            List<DrQualityDBO> drQualityDBOS = resultService.truncateTableOneAdd(pid, PRIMAEYKEY);
            resultService.qualityByOneAdd(pid,extract_id,PRIMAEYKEY,drQualityDBOS);
        }else{
            List<DrQualityDBO> drQualityDBOS = resultService.truncateTableOne(pid, PRIMAEYKEY);
            resultService.qualityByOne(pid,extract_id,PRIMAEYKEY,drQualityDBOS);
        }

    }
    public void saveOnePatient(Integer pid,Integer eid,String PRIMAEYKEY){


        //1 重新抽取患者数据
        if(6==pid||7==pid){
            createInsertIntoSqlAndExecAddToOne(pid,eid,PRIMAEYKEY);
        }else if(10==pid){
            createInsertIntoSqlAndExecAdd10ToOne(pid,eid,PRIMAEYKEY);
        }else{
            createInsertIntoSqlAndExecToOne(pid,eid,PRIMAEYKEY);
        }
        //  重新质控
        if(6==pid||7==pid){
            List<DrQualityDBO> drQualityDBOS = resultService.truncateTableOneAdd(pid, PRIMAEYKEY);
            resultService.qualityByOneAdd(pid,eid,PRIMAEYKEY,drQualityDBOS);
        }else{
            List<DrQualityDBO> drQualityDBOS = resultService.truncateTableOne(pid, PRIMAEYKEY);
            resultService.qualityByOne(pid,eid,PRIMAEYKEY,drQualityDBOS);
        }

    }


    public LinkedHashMap<String,Object> getPatientOne(Integer pid, String PRIMAEYKEY) {
        return centerTableDao.getPatientOne(pid,PRIMAEYKEY);
    }

    public LinkedHashMap<String,Object> getPatientOneAdd7(Integer pid, String PRIMAEYKEY) {
        return centerTableDao.getPatientOneAdd7(pid,PRIMAEYKEY);
    }

    public Map<String,Object> getPatientOneAdd10(Integer pid, String PRIMAEYKEY) {
        Map<String,Object> map = new HashMap<>();
        LinkedHashMap<String, Object> data_a = centerTableDao.getPatientOneAdd10A(pid, PRIMAEYKEY);
        List<LinkedHashMap<String, Object>> data_b = centerTableDao.getPatientOneAdd10B(pid, PRIMAEYKEY,"b");
        List<LinkedHashMap<String, Object>> data_c = centerTableDao.getPatientOneAdd10B(pid, PRIMAEYKEY,"c");
        List<LinkedHashMap<String, Object>> data_d = centerTableDao.getPatientOneAdd10B(pid, PRIMAEYKEY,"d");
        map.put("a",data_a);
        map.put("b",data_b);
        map.put("c",data_c);
        map.put("d",data_d);
        return  map;
    }

    public Map<String,Object> getPatientOneAdd15(Integer pid, String PRIMAEYKEY) {
        Map<String,Object> map = new HashMap<>();
        LinkedHashMap<String, Object> data_a = centerTableDao.getPatientOneAdd10A(pid, PRIMAEYKEY);
        List<LinkedHashMap<String, Object>> data_b = centerTableDao.getPatientOneAdd10B(pid, PRIMAEYKEY,"b");
        List<LinkedHashMap<String, Object>> data_c = centerTableDao.getPatientOneAdd10B(pid, PRIMAEYKEY,"c");
        List<LinkedHashMap<String, Object>> data_d = centerTableDao.getPatientOneAdd10B(pid, PRIMAEYKEY,"d");
        List<LinkedHashMap<String, Object>> data_e = centerTableDao.getPatientOneAdd10B(pid, PRIMAEYKEY,"e");
        List<LinkedHashMap<String, Object>> data_f = centerTableDao.getPatientOneAdd10B(pid, PRIMAEYKEY,"f");
        List<LinkedHashMap<String, Object>> data_g = centerTableDao.getPatientOneAdd10B(pid, PRIMAEYKEY,"g");
        map.put("a",data_a);
        map.put("b",data_b);
        map.put("c",data_c);
        map.put("d",data_d);
        map.put("e",data_e);
        map.put("f",data_f);
        map.put("g",data_g);
        return  map;
    }

    public LinkedHashMap<String,Object> getPatientOneAdd6(Integer pid, String PRIMAEYKEY) {
        return centerTableDao.getPatientOneAdd6(pid,PRIMAEYKEY);
    }

    public List<DrPlusCenterTable> getLikeDateList3(Integer pid, String val1, String val2) {
        return centerTableDao.getLikeDateList3(pid,val1,val2);
    }

    public List<LinkedHashMap<String, Object>> getReportResult(Object pidObj, Object typeObj, Object valObj,Object sObj,Object eObj) {
        Integer pid = convert(pidObj,Integer.class);
        Integer type = convert(typeObj,Integer.class);
        String val = convert(valObj,String.class);
        String s= convert(sObj,String.class);
        String e= convert(eObj,String.class);
        List<LinkedHashMap<String, Object>> list = new ArrayList<>();
        String typesql = "";
        if(9==type){  //全部
            typesql = " review_type=1 "  ;
        }else if (0==type){ //未上报 = 已撤销 + 未上报
            typesql = " review_type=1 and ( isnull(b.report_type,0)= 0 or isnull(b.report_type,0)= 2  )   ";
        }else if (1==type) {  //已上报 = 上报成功+撤销失败
            typesql = " review_type=1 and ( isnull(b.report_type,0)=1 or  isnull(b.report_type,0)=-2) ";
        }else  {  //已上报 = 上报成功+撤销失败
            typesql = " review_type=1 and isnull(b.report_type,0) = "+type+" ";
        }
        if (1==pid){

        }else if(2==pid){
            list =centerTableDao.getReportResult2(pid,typesql,val,s,e);
        }else if(3==pid){
            list = centerTableDao.getReportResult3(pid,typesql,val,s,e);
        }else if(4==pid){

        }else if(5==pid){
            list = centerTableDao.getReportResult5(pid,typesql,val,s,e);
        }else if(6==pid||7==pid){
            list = centerTableDao.getReportResult6(pid,typesql,val,s,e);
        }else if(8==pid || 9==pid){
            list = centerTableDao.getReportResult8(pid,typesql,val,s,e);
        }

        return list;
    }
    //获取主键 字段 或者  时间字段
    public String getColumnPrimaryOrTime(Integer pid, String column) {
        return centerTableDao.getColumnPrimaryOrTime(pid,column);
    }




    public List<DrPlusCenterTable> getReportColumn(Integer pid) {
        return centerTableDao.getReportColumn(pid);
    }

    public List<DrPlusCenterTable> getReportColumn2(Integer pid) {
        return centerTableDao.getReportColumn2(pid);
    }

    public String getReportColumnByCol(Integer pid,String col) {
        return centerTableDao.getReportColumnByCol(pid,col);
    }

    public List<LinkedHashMap<String, Object>> getPatientData(String sql) {
        return centerTableDao.getPatientData(sql);
    }

    /**
     *
     * @param pid
     * @param eid
     * @param val
     * @param type  1 实际抽取下钻  2 质控问题下钻 3 审核通过 4 审核不通过 5 上报成功 6 上报失败
     * @return
     */
    public List<ProcessDataDBO> drillDown(Integer pid, Integer eid, String val, Integer type) {
        List<ProcessDataDBO> list = null;
        String tab  = "";
        if(6==pid||7==pid||10==pid||15==pid)
            tab= "a";
        if(1==type){//1 实际抽取下钻
            list =dataTypeDao.drillDownExtract(pid,eid,val,tab);
        }else if(2==type){// 2 质控问题下钻
            list =controlProcessDao.drillDownControl(pid,eid, val,tab);
        }else if(3==type || 4==type){//3 审核通过 4 审核不通过
            list = dataTypeDao.drillDownReview(pid,eid,val,type == 3 ? 1 : -1,tab);
        }else if(5==type || 6==type){//5 上报成功 6 上报失败
            list = dataTypeDao.drillDownReport(pid,eid,val,type == 5 ? 1 : -1,tab);
        }
        return list;
    }

    public List<DrPlusErrorQualityLog> drillDownError(Integer pid, String eid ) {
        return errorProcessDao.drillDownError(pid,eid );
    }

    public Integer isExistsTable(String name) {
        return centerTableDao.isExistsTable(name);
    }

    public Integer createTableBysql(String sql) {
        return centerTableDao.updateSqlWithSQL(sql);
    }
}
