package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.drplus.dao1.*;
import com.sxdl.drplus.dto.DrQualityDBO;
import com.sxdl.drplus.entity.DrPlusControlResult;
import com.sxdl.drplus.entity.DrPlusErrorQualityLog;
import com.sxdl.drplus.util.DataUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DrPlusControlResultService extends BaseUUIDServiceImpl<DrPlusControlResult> {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    private DrPlusCenterTableDao centerTableDao;

    @Autowired
    private DrPlusControlResultDao resultDao;

    @Autowired
    private DrPlusControlBzxDao bzxDao;

    @Autowired
    private DrPlusPlatformDetailedDao detailedDao;

    @Autowired
    private DrPlusErrorQualityLogDao errorQualityLogDao;




    /**
     * 批量质控核心代码
     * @param extract_id
     * @param pid
     */

    public void qualityByList(Integer extract_id,Integer pid,List<DrQualityDBO> qualityData) {
        List<DrPlusErrorQualityLog> logList = new ArrayList<>();

        StringBuilder sb = null;
            for (DrQualityDBO qualityDatum : qualityData) {
                String stime = DataUtil.getDateTime();
                    try {
                        sb = new StringBuilder();
                        sb.append(" insert into drplus_control_result(id,save_time,drplus_platform_detailed_id,drplus_extract_detailed_id,primary_keyval,result_message,type,drplus_quality_id,termlevel,field_name) ");
                        sb.append(" select Newid(),convert(varchar(19),getdate(),120)," + pid + "," + extract_id + ",PRIMAEYKEY," + "'" + qualityDatum.getResult_message() + "'," + qualityDatum.getType() + "," + qualityDatum.getId() + "," + qualityDatum.getTermlevel() + ",'" + qualityDatum.getField_name() + "' ");
                        sb.append(" from drplus_center_table_data_ioc" + pid + " a ");
                        sb.append(" where ( " + qualityDatum.getSql() + " ) And ");
                        sb.append(" not exists( select 1 from drplus_control_result b " +
                                "where  b.drplus_platform_detailed_id =   " + pid +
                                " and  a.drplus_extract_detailed_id = b.drplus_extract_detailed_id " +
                                " and  a.PRIMAEYKEY = b.primary_keyval and b.drplus_quality_id = " + qualityDatum.getId() + " and b.type =" + qualityDatum.getType() + ")");

                        int i1 = resultDao.insertSql(sb.toString());
                    } catch (Exception e) {
                        Integer type = qualityDatum.getType();
                        String a= "";
                        if(type==1){
                            a ="标准质控-->";
                        }else if(type==2){
                            a ="完整质控-->";
                        }else if(type==3){
                            a ="逻辑质控-->";
                        }

                        DrPlusErrorQualityLog logentity = new DrPlusErrorQualityLog();
                        logentity.setDrplus_platform_detailed_id(pid)
                                .setDrplus_extract_detailed_id(extract_id)
                                .setMessage(a+ qualityDatum.getResult_message()+"-->"+ e.getCause().toString()  )
                                .setDrplus_quality_id(qualityDatum.getId())
                                .setType(qualityDatum.getType())
                                .setCreate_time(DataUtil.getDateTime());
                        logList.add(logentity);
                        logger.error("DrPlusControlResultService.qualityByList方法错误 :" + e);
                    }
                    String etime = DataUtil.getDateTime();
                    long dateSubSeconds = DataUtil.getDateSubSeconds(stime, etime);
                    if(dateSubSeconds>5){
                        System.out.println("质控类型:"+qualityDatum.getType() + ">id:" + qualityDatum.getId() + ">用时:" + dateSubSeconds);
                    }
        }
        logList.forEach(e->{
            int insert = errorQualityLogDao.insert(e);
        });
        return;
    }

    /**
     * 批量质控核心代码
     * @param extract_id
     * @param pid
     */

    public void qualityByListAdd(Integer extract_id,Integer pid ,List<DrQualityDBO> qualityData) {
            StringBuilder sb = null;
            List<DrPlusErrorQualityLog> logList = new ArrayList<>();
            for (DrQualityDBO qualityDatum : qualityData) {

                    String stime = DataUtil.getDateTime();
                    try {
                        sb = new StringBuilder();
                        sb.append(" insert into drplus_control_result(id,save_time,drplus_platform_detailed_id,drplus_extract_detailed_id,primary_keyval,result_message,type,drplus_quality_id,termlevel,field_name) ");
                        if(qualityDatum.getBelong().contains("a,b")){
                            sb.append(" select Newid(),convert(varchar(19),getdate(),120)," + pid + "," + extract_id + ",a.PRIMAEYKEY," + "'" + qualityDatum.getResult_message() + "'," + qualityDatum.getType() + "," + qualityDatum.getId() + "," + qualityDatum.getTermlevel() + ",'" + qualityDatum.getField_name() + "' ");
                            sb.append(" from drplus_center_table_data_ioc" + pid + "a a ");
                            sb.append(" left join drplus_center_table_data_ioc" + pid + "b b on a.PRIMAEYKEY=b.PRIMAEYKEY");
                            sb.append(" where (" + qualityDatum.getSql() + ") And ");
                            sb.append(" not exists( select 1 from drplus_control_result r " +
                                    "where  r.drplus_platform_detailed_id =   " + pid +
                                    " and  a.drplus_extract_detailed_id = r.drplus_extract_detailed_id " +
                                    " and  a.PRIMAEYKEY = r.primary_keyval and r.drplus_quality_id = " + qualityDatum.getId() + " and r.type =" + qualityDatum.getType() + ")");
                        }else {
                            sb.append(" select Newid(),convert(varchar(19),getdate(),120)," + pid + "," + extract_id + ",PRIMAEYKEY," + "'" + qualityDatum.getResult_message() + "'," + qualityDatum.getType() + "," + qualityDatum.getId() + "," + qualityDatum.getTermlevel() + ",'" + qualityDatum.getField_name() + "' ");
                            sb.append(" from drplus_center_table_data_ioc" + pid + qualityDatum.getBelong() + " "+qualityDatum.getBelong());
                            sb.append(" where (" + qualityDatum.getSql() + ") And ");
                            sb.append(" not exists( select 1 from drplus_control_result r " +
                                    "where  r.drplus_platform_detailed_id =   " + pid +
                                    " and  "+qualityDatum.getBelong()+".drplus_extract_detailed_id = r.drplus_extract_detailed_id " +
                                    " and  "+qualityDatum.getBelong()+".PRIMAEYKEY = r.primary_keyval and r.drplus_quality_id = " + qualityDatum.getId() + " and r.type =" + qualityDatum.getType() + ")");
                        }

                        int i1 = resultDao.insertSql(sb.toString());
                    } catch (Exception e) {
                        Integer type = qualityDatum.getType();
                        String a= "";
                        if(type==1){
                            a ="标准质控-->";
                        }else if(type==2){
                            a ="完整质控-->";
                        }else if(type==3){
                            a ="逻辑质控-->";
                        }

                        DrPlusErrorQualityLog logentity = new DrPlusErrorQualityLog();
                        logentity.setDrplus_platform_detailed_id(pid)
                                .setDrplus_extract_detailed_id(extract_id)
                                .setMessage(a+ qualityDatum.getResult_message()+"-->"+ e.getCause().toString()  )
                                .setDrplus_quality_id(qualityDatum.getId())
                                .setType(qualityDatum.getType())
                                .setCreate_time(DataUtil.getDateTime());
                        logList.add(logentity);

                        logger.error("DrPlusControlResultService.qualityByList方法错误 :" + e);
                    }
                    String etime = DataUtil.getDateTime();
                    long dateSubSeconds = DataUtil.getDateSubSeconds(stime, etime);
                    if(dateSubSeconds>5){
                        System.out.println("质控类型:"+qualityDatum.getType() + ">id:" + qualityDatum.getId() + ">用时:" + dateSubSeconds);
                    }

            }
            logList.forEach(e->{
                int insert = errorQualityLogDao.insert(e);
            });

            return;

    }


    public void qualityByListOnetoMany(Integer extract_id,Integer pid ,List<DrQualityDBO> qualityData) {
        List<DrPlusErrorQualityLog> logList = new ArrayList<>();
        StringBuilder sb = null;
        for (DrQualityDBO qualityDatum : qualityData) {

                String stime = DataUtil.getDateTime();
                try {
                    sb = new StringBuilder();
                    sb.append(" insert into drplus_control_result(id,save_time,drplus_platform_detailed_id,drplus_extract_detailed_id,primary_keyval,result_message,type,drplus_quality_id,termlevel,field_name) ");

                    if(qualityDatum.getBelong().contains(",")){
                        String[] split = qualityDatum.getBelong().split(",");
                        sb.append(" select Newid(),convert(varchar(19),getdate(),120)," + pid + "," + extract_id + ","+split[0]+".PRIMAEYKEY," + "'" + qualityDatum.getResult_message() + "'," + qualityDatum.getType() + "," + qualityDatum.getId() + "," + qualityDatum.getTermlevel() + ",'" + qualityDatum.getField_name() + "' ");
                        sb.append(" from drplus_center_table_data_ioc" + pid +split[0]+ " "+split[0]);
                        for (int i = 1; i < split.length; i++) {
                            sb.append(" left join drplus_center_table_data_ioc" + pid +split[i] +" "+split[i] +" on a.PRIMAEYKEY=b.PRIMAEYKEY");
                        }
                        sb.append(" where (" + qualityDatum.getSql() + ") And ");
                        sb.append(" not exists( select 1 from drplus_control_result r " +
                                " where  r.drplus_platform_detailed_id =   " + pid +
                                " and  "+ split[0] +".drplus_extract_detailed_id = r.drplus_extract_detailed_id " +
                                " and  "+ split[0] +".PRIMAEYKEY = r.primary_keyval and r.drplus_quality_id = " + qualityDatum.getId() + " and r.type =" + qualityDatum.getType() + ")");
                    }else{
                        sb.append(" select Newid(),convert(varchar(19),getdate(),120)," + pid + "," + extract_id + ",PRIMAEYKEY," + "'" + qualityDatum.getResult_message() + "'," + qualityDatum.getType() + "," + qualityDatum.getId() + "," + qualityDatum.getTermlevel() + ",'" + qualityDatum.getField_name() + "' ");
                        sb.append(" from drplus_center_table_data_ioc" + pid + qualityDatum.getBelong() + " "+ qualityDatum.getBelong());
                        sb.append(" where (" + qualityDatum.getSql() + ") And ");
                        sb.append(" not exists( select 1 from drplus_control_result r " +
                                " where  r.drplus_platform_detailed_id =   " + pid +
                                " and  "+ qualityDatum.getBelong() +".drplus_extract_detailed_id = r.drplus_extract_detailed_id " +
                                " and  "+ qualityDatum.getBelong() +".PRIMAEYKEY = r.primary_keyval and r.drplus_quality_id = " + qualityDatum.getId() + " and r.type =" + qualityDatum.getType() + ")");
                    }


                    int i1 = resultDao.insertSql(sb.toString());
                } catch (Exception e) {
                    Integer type = qualityDatum.getType();
                    String a= "";
                    if(type==1){
                        a ="标准质控-->";
                    }else if(type==2){
                        a ="完整质控-->";
                    }else if(type==3){
                        a ="逻辑质控-->";
                    }

                    DrPlusErrorQualityLog logentity = new DrPlusErrorQualityLog();
                    logentity.setDrplus_platform_detailed_id(pid)
                            .setDrplus_extract_detailed_id(extract_id)
                            .setMessage(a+ qualityDatum.getResult_message()+"-->"+ e.getCause().toString() )
                            .setDrplus_quality_id(qualityDatum.getId())
                            .setType(qualityDatum.getType())
                            .setCreate_time(DataUtil.getDateTime());
                    logList.add(logentity);

                    logger.error("DrPlusControlResultService.qualityByList方法错误 :" + e);
                }
                String etime = DataUtil.getDateTime();
                long dateSubSeconds = DataUtil.getDateSubSeconds(stime, etime);
                if(dateSubSeconds>5){
                    System.out.println("质控类型:"+qualityDatum.getType() + ">id:" + qualityDatum.getId() + ">用时:" + dateSubSeconds);
                }
        }

        logList.forEach(e->{
            int insert = errorQualityLogDao.insert(e);
        });

        return;

    }

    /**
     * 一对一的 平台6 /7
     * @param pid
     * @param extract_id
     * @return
     */
    public List<DrQualityDBO> truncateTableAdd(Integer pid,Integer extract_id){
        centerTableDao.truncateTableAdd(pid, "a");
        centerTableDao.truncateTableAdd(pid, "b");
        int i3 = centerTableDao.delQualityData(extract_id, pid);
        int i2 = centerTableDao.delQualityErrorData(extract_id, pid);
        //  1 获取 开启的质控条件
        List<DrQualityDBO> list = bzxDao.getQualityData(pid);

        List<DrQualityDBO> qualityData = list.stream().filter(e -> !StringUtils.isEmpty(e.getBelong())).collect(Collectors.toList());

        // 将这一次抽取过来的数据放到容器表中
        int sizeA = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("a")).collect(Collectors.toList()).size();
        int sizeB = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("b")).collect(Collectors.toList()).size();
        if (sizeA > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "a");
        }
        if (sizeB > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "b");
        }
        return qualityData;
    }

    /**
     *  一对 多的 质控 10平台为 案例
     * @param pid
     * @param extract_id
     * @return
     */
    public List<DrQualityDBO> truncateTableOnetoMany10(Integer pid,Integer extract_id){
        centerTableDao.truncateTableAdd(pid, "a");
        centerTableDao.truncateTableAdd(pid, "b");
        centerTableDao.truncateTableAdd(pid, "c");
        centerTableDao.truncateTableAdd(pid, "d");
        int i3 = centerTableDao.delQualityData(extract_id, pid);
        int i2 = centerTableDao.delQualityErrorData(extract_id, pid);
        //  1 获取 开启的质控条件
        List<DrQualityDBO> list = bzxDao.getQualityData(pid);

        List<DrQualityDBO> qualityData = list.stream().filter(e -> !StringUtils.isEmpty(e.getBelong())).collect(Collectors.toList());

        // 将这一次抽取过来的数据放到容器表中
        int sizeA = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("a")).collect(Collectors.toList()).size();
        int sizeB = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("b") ).collect(Collectors.toList()).size();
        int sizeC = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("c") ).collect(Collectors.toList()).size();
        int sizeD = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("d") ).collect(Collectors.toList()).size();
        if (sizeA > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "a");
        }
        if (sizeB > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "b");
        }
        if (sizeC > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "c");
        }
        if (sizeD > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "d");
        }
        return qualityData;
    }


    public List<DrQualityDBO> truncateTableOnetoMany15(Integer pid,Integer extract_id){
        centerTableDao.truncateTableAdd(pid, "a");
        centerTableDao.truncateTableAdd(pid, "b");
        centerTableDao.truncateTableAdd(pid, "c");
        centerTableDao.truncateTableAdd(pid, "d");
        centerTableDao.truncateTableAdd(pid, "e");
        centerTableDao.truncateTableAdd(pid, "f");
        centerTableDao.truncateTableAdd(pid, "g");
        int i3 = centerTableDao.delQualityData(extract_id, pid);
        int i2 = centerTableDao.delQualityErrorData(extract_id, pid);
        //  1 获取 开启的质控条件
        List<DrQualityDBO> list = bzxDao.getQualityData(pid);

        List<DrQualityDBO> qualityData = list.stream().filter(e -> !StringUtils.isEmpty(e.getBelong())).collect(Collectors.toList());

        // 将这一次抽取过来的数据放到容器表中
        int sizeA = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("a")).collect(Collectors.toList()).size();
        int sizeB = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("b") ).collect(Collectors.toList()).size();
        int sizeC = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("c") ).collect(Collectors.toList()).size();
        int sizeD = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("d") ).collect(Collectors.toList()).size();
        int sizeE = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("e") ).collect(Collectors.toList()).size();
        int sizeF = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("f") ).collect(Collectors.toList()).size();
        int sizeG = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && e.getBelong().contains("g") ).collect(Collectors.toList()).size();
        if (sizeA > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "a");
        }
        if (sizeB > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "b");
        }
        if (sizeC > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "c");
        }
        if (sizeD > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "d");
        }
        if (sizeD > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "e");
        }
        if (sizeD > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "f");
        }
        if (sizeD > 0) {
            int i = centerTableDao.insertDataToIocTableAdd(extract_id, pid, "g");
        }
        return qualityData;
    }
    public  List<DrQualityDBO>  truncateTable(Integer pid,Integer extract_id){
        //容器表 执行truncate
        centerTableDao.truncateTable(pid);
        //删除上次质控数据  drplus_errorlog   drplus_control_result
        centerTableDao.delQualityData(extract_id, pid);
        centerTableDao.delQualityErrorData(extract_id, pid);
        // 将这一次抽取过来的数据放到容器表中
        int i = centerTableDao.insertDataToIocTable(extract_id, pid);
        //  1 获取 开启的质控条件
        List<DrQualityDBO> qualityData = bzxDao.getQualityData(pid);
        return qualityData;
    }




    /**
     *
     * 注意: drplus_errorlog 表中,PRIMAEYKEY有的代表是单人质控的也就是说在保存数据的时候质控的  ,
     *      没有病案号的 代表是自动抽取的时候那块的质控,需要在页面上显示质控异常信息
     * 单人质控核心代码
     * @param extract_id
     * @param pid
     * @param PRIMAEYKEY  数据唯一标识 病历号
     */
    public void qualityByOne(Integer pid,Integer extract_id,String PRIMAEYKEY,List<DrQualityDBO> qualityData) {
            StringBuilder sb = null;
            for (DrQualityDBO qualityDatum : qualityData) {
                String stime = DataUtil.getDateTime();
                try {
                    sb = new StringBuilder();
                    sb.append(" insert into drplus_control_result(id,save_time,drplus_platform_detailed_id,drplus_extract_detailed_id,primary_keyval,result_message,type,drplus_quality_id,termlevel,field_name) ");
                    sb.append(" select Newid(),convert(varchar(19),getdate(),120)," + pid + "," + extract_id + ",PRIMAEYKEY," + "'" + qualityDatum.getResult_message() + "'," + qualityDatum.getType() + "," + qualityDatum.getId() + "," + qualityDatum.getTermlevel() + ",'" + qualityDatum.getField_name() + "' ");
                    sb.append(" from drplus_center_table_data_ioc" + pid + " a ");
                    sb.append(" where (" + qualityDatum.getSql() + ") And ");
                    sb.append(" not exists( select 1 from drplus_control_result b " +
                            " where  b.drplus_platform_detailed_id =   " + pid +
                            " and  a.drplus_extract_detailed_id = b.drplus_extract_detailed_id " +
                            " and  a.PRIMAEYKEY = b.primary_keyval and b.drplus_quality_id = " + qualityDatum.getId() + " and b.type =" + qualityDatum.getType() + ")");
                    int i1 = resultDao.insertSql(sb.toString());
                } catch (Exception e) {
                    sb = new StringBuilder();
                    sb.append(" insert into drplus_errorlog(id,drplus_platform_detailed_id,drplus_extract_detailed_id,message,drplus_quality_id,type,create_time,patient_key) ");
                    sb.append(" values (newid()," + pid + "," + extract_id + " ,'" + e.getMessage().replace("'", " ") + "'," + qualityDatum.getId() + "," + qualityDatum.getType() + ", convert(varchar(19),getdate(),120),'" + PRIMAEYKEY + "' )");
                    int i1 = resultDao.insertSql(sb.toString());
                    logger.error(e);
                }
                String etime = DataUtil.getDateTime();
                long dateSubSeconds = DataUtil.getDateSubSeconds(stime, etime);
                if(dateSubSeconds>5){
                    System.out.println("警告:质控类型:"+qualityDatum.getType() + ">id:" + qualityDatum.getResult_message() + ">用时:" + dateSubSeconds);
                }

        }
        return;
    }

    public List<DrQualityDBO>  truncateTableOne(Integer pid,String PRIMAEYKEY ){

        //容器表 执行truncate
        centerTableDao.truncateTable(pid);
        //删除上次质控数据  drplus_errorlog   drplus_control_result
        centerTableDao.delQualityData2(pid, PRIMAEYKEY);
        centerTableDao.delQualityErrorData2(pid, PRIMAEYKEY);
        //  1 获取 开启的质控条件
        List<DrQualityDBO> qualityData = bzxDao.getQualityData(pid);
        // 将这一次抽取过来的数据放到容器表中
        int i = centerTableDao.insertDataToIocTable2(pid, PRIMAEYKEY);
        return qualityData;
    }
    public List<DrQualityDBO>  truncateTableOneAdd(Integer pid,String PRIMAEYKEY ){
        //容器表 执行truncate A表
        centerTableDao.truncateTableAdd(pid, "a");
        centerTableDao.truncateTableAdd(pid, "b");
        //删除上次质控数据  drplus_errorlog   drplus_control_result
        centerTableDao.delQualityData2(pid, PRIMAEYKEY);
        centerTableDao.delQualityErrorData2(pid, PRIMAEYKEY);
        // 将这一次抽取过来的数据放到容器表中
        //  1 获取 开启的质控条件
        List<DrQualityDBO> qualityData = bzxDao.getQualityData(pid).stream().filter(e -> !StringUtils.isEmpty(e.getBelong())).collect(Collectors.toList());
        int sizeA = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && "a".equals(e.getBelong())).collect(Collectors.toList()).size();
        int sizeB = qualityData.stream().filter(e -> !StringUtils.isEmpty(e.getBelong()) && "b".equals(e.getBelong())).collect(Collectors.toList()).size();
        if (sizeA > 0) {
            int i = centerTableDao.insertDataToIocTableAdd2(pid, PRIMAEYKEY, "a");
        }
        if (sizeB > 0) {
            int i = centerTableDao.insertDataToIocTableAdd2(pid, PRIMAEYKEY, "b");
        }
        return qualityData;
    }


    /**
     *
     * 注意: drplus_errorlog 表中,PRIMAEYKEY有的代表是单人质控的也就是说在保存数据的时候质控的  ,
     *      没有病案号的 代表是自动抽取的时候那块的质控,需要在页面上显示质控异常信息
     * 单人质控核心代码
     * @param extract_id
     * @param pid
     * @param PRIMAEYKEY  数据唯一标识 病历号
     */
    public void qualityByOneAdd(Integer pid,Integer extract_id,String PRIMAEYKEY, List<DrQualityDBO> qualityData ) {

            // 将这一次抽取过来的数据放到容器表中
            StringBuilder sb = null;
            for (DrQualityDBO qualityDatum : qualityData) {
                String stime = DataUtil.getDateTime();
                try {
                    sb = new StringBuilder();
                    sb.append(" insert into drplus_control_result(id,save_time,drplus_platform_detailed_id,drplus_extract_detailed_id,primary_keyval,result_message,type,drplus_quality_id,termlevel,field_name) ");
                    sb.append(" select Newid(),convert(varchar(19),getdate(),120)," + pid + "," + extract_id + ",PRIMAEYKEY," + "'" + qualityDatum.getResult_message() + "'," + qualityDatum.getType() + "," + qualityDatum.getId() + "," + qualityDatum.getTermlevel() + ",'" + qualityDatum.getField_name() + "' ");
                    sb.append(" from drplus_center_table_data_ioc" + pid + "a a ");
                    sb.append(" where (" + qualityDatum.getSql() + ") And ");
                    sb.append(" not exists( select 1 from drplus_control_result b " +
                            "where  b.drplus_platform_detailed_id =   " + pid +
                            " and  a.drplus_extract_detailed_id = b.drplus_extract_detailed_id " +
                            " and  a.PRIMAEYKEY = b.primary_keyval and b.drplus_quality_id = " + qualityDatum.getId() + " and b.type =" + qualityDatum.getType() + ")");
                    int i1 = resultDao.insertSql(sb.toString());
                } catch (Exception e) {
                    sb = new StringBuilder();
                    sb.append(" insert into drplus_errorlog(id,drplus_platform_detailed_id,drplus_extract_detailed_id,message,drplus_quality_id,type,create_time,patient_key) ");
                    sb.append(" values (newid()," + pid + "," + extract_id + " ,'" + e.getMessage().replace("'", " ") + "'," + qualityDatum.getId() + "," + qualityDatum.getType() + ", convert(varchar(19),getdate(),120),'" + PRIMAEYKEY + "' )");
                    int i1 = resultDao.insertSql(sb.toString());
                    logger.error(e);
                }
                String etime = DataUtil.getDateTime();
                long dateSubSeconds = DataUtil.getDateSubSeconds(stime, etime);
                if(dateSubSeconds>5){
                    System.out.println("警告!!!质控类型:"+qualityDatum.getType() + ">id:" + qualityDatum.getResult_message() + " >用时:" + dateSubSeconds);
                }



        }
        return;
    }
    public List<DrPlusControlResult> getQualityResultOneInfo(Integer pid, String PRIMAEYKEY) {
        DrPlusControlResult result = new DrPlusControlResult();
        result.setDrplus_platform_detailed_id(pid);
        result.setPrimary_keyval(PRIMAEYKEY);
        return resultDao.select(result);
    }
    public Integer getCountData(Integer pid, String PRIMAEYKEY) {
        return resultDao.getCountData(pid,PRIMAEYKEY);
    }

    /**
     * 手动批量审核 审核全部数据
     * @param pid
     * @param col
     * @param stime
     * @param etime
     * @return
     */
    public List<String> getPassData(Integer pid ,String col,String stime,String etime) {
        return resultDao.getPassData( pid , col, stime, etime);
    }

    /**
     * 手动批量审核 审核全部数据
     * @param pid
     * @param col
     * @param stime
     * @param etime
     * @return
     */
    public List<String> getPassDataAdd(Integer pid ,String col,String stime,String etime) {
        return resultDao.getPassDataAdd( pid , col, stime, etime);
    }



    public List<String> getPassDataBypid(Integer pid ,Integer eid,String tab) {
        return resultDao.getPassDataBypid( pid ,eid,tab);
    }

    /**
     * 自动审核 不审核其他 抽取模块中的数据
     * @param pid
     * @param eid
     * @param col
     * @param stime
     * @param etime
     * @return
     */
    public List<String> getPassDataAuto(Integer pid, Integer eid ,String col,String stime,String etime) {
        return resultDao.getPassDataAuto( pid,  eid , col, stime, etime);
    }
    /**
     * 自动审核 不审核其他 抽取模块中的数据
     * @param pid
     * @param eid
     * @param col
     * @param stime
     * @param etime
     * @return
     */
    public List<String> getPassDataAutoAdd(Integer pid, Integer eid ,String col,String stime,String etime) {
        return resultDao.getPassDataAutoAdd( pid,  eid , col, stime, etime);
    }
}
