package com.sxdl.cf.util;

import com.sxdl.cf.dto.TableModelDBO;
import com.sxdl.cf.entity.SysCustomerFormFieldTableEntity;
import com.sxdl.cf.entity.SysCustomerFormHeaderColumnEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DataUtil {
    public static final String LineBreak = "\r\n";
    private static final  String TABLE="drplus_center_table_data";
    private static final  String TABLE_IOC="drplus_center_table_data_ioc";

    public volatile static Map<String, Object> threadMap = new ConcurrentHashMap<>();

    public static final String ERROR_MASSAGE = "系统运行异常,给您带来不便请谅解, 反馈问题请关注公众号:雕龙科技";
    public static final String SUCCESS_MASSAGE = "操作成功";
    static  Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static String getDateTime()   {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        return  simpleDateFormat.format(date);
    }

    public static String getDate()   {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return  simpleDateFormat.format(date);
    }

    public static StringBuilder delLastChar(StringBuilder sb){
        return sb.deleteCharAt(sb.length()-1);
    }


    /**
     *  获取开始结束时间
     * @param offset
     * @param e_days
     * @return
     */
    public static Map<String,String> getStartAndEndTime(Integer offset,Integer e_days) {
        Map<String,String> map = new HashMap<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime endDate = LocalDateTime.now().minusDays(offset);
        LocalDateTime startDate = endDate.minusDays(e_days);
        String endTime = dtf.format(endDate);
        String startTime = dtf.format(startDate);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return map;
    }


    /**
     * 获取上月月初
     * @return 获取上月月初
     */
    public static String getStartDate() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDate = now.plusMonths(-1L).withDayOfMonth(1).truncatedTo(ChronoUnit.DAYS);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(startDate);
    }

    /**
     *  获取上月月末
     * @return  获取上月月末
     */
    public static String getEndDate() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endDate = now.withDayOfMonth(1).truncatedTo(ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS)
                .plus(-1L, ChronoUnit.MILLIS);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(endDate);
    }


    public static List<SysCustomerFormHeaderColumnEntity> InitColumn(String pid) {
        List<SysCustomerFormHeaderColumnEntity> list = new ArrayList<>();
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"id","id主键",1).setType("3").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"created_time","创建时间",2).setType("8").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"created_user","创建用户",3).setType("3").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"modified_time","修改时间",4).setType("8").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"modified_user","修改用户",5).setType("3").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"owner_user","所属人员",6).setType("3").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"owner_department","所属科室",7).setType("3").setIs_system(1));
        return list;
    }


    public static List<SysCustomerFormHeaderColumnEntity> InitChildManyColumn(String pid) {
        List<SysCustomerFormHeaderColumnEntity> list = new ArrayList<>();
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"id","id主键",1).setType("3").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"created_time","创建时间",2).setType("8").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"created_user","创建用户",3).setType("3").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"modified_time","修改时间",4).setType("8").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"modified_user","修改用户",5).setType("3").setIs_system(1));
        list.add(new SysCustomerFormHeaderColumnEntity(pid,"maintable_id","父表ID",6).setType("3").setIs_system(1));
        //list.add(new SysCustomerFormHeaderColumnEntity(pid,"maintable_id","父表ID",6));
        //list.add(new SysCustomerFormHeaderColumnEntity(pid,"order_number","序号",7));
        return list;
    }




    public static List<SysCustomerFormFieldTableEntity> InitField(String pid,String name){
        List<SysCustomerFormFieldTableEntity> list = new ArrayList<>();
        //类型: 1 整数 2 小数 3 文本 4 大文本 5 单选下拉框 6 多选下拉框 7 日期(yyyy-MM-dd) 8 日期时间(yyyy-MM-dd HH:mm:ss) 9 年份(yyyy) 10 年月(yyyy-MM) 11 时间(HH:mm:ss) 12 文件 13 图片
        //String table_name String name, String label, Integer type, Integer is_mainfield, Integer is_system, String facttable_id default_show,is_null,is_edit order_number
        SysCustomerFormFieldTableEntity field1 = new SysCustomerFormFieldTableEntity(name,"id","id主键",3,1,1,pid, 0,0,50,1);
        SysCustomerFormFieldTableEntity field2 = new SysCustomerFormFieldTableEntity(name,"created_time","创建时间",8,0,1,pid, 0,0,19,2);
        SysCustomerFormFieldTableEntity field3 = new SysCustomerFormFieldTableEntity(name,"created_user","创建用户",3,0,1,pid, 1,0,50,3);
        SysCustomerFormFieldTableEntity field4 = new SysCustomerFormFieldTableEntity(name,"modified_time","修改时间",8,0,1,pid, 0,0,19,4);
        SysCustomerFormFieldTableEntity field5 = new SysCustomerFormFieldTableEntity(name,"modified_user","修改用户",3,0,1,pid, 1,0,50,5);
        SysCustomerFormFieldTableEntity field6 = new SysCustomerFormFieldTableEntity(name,"owner_user","所属人员",3,0,1,pid, 1,0,50,6);
        SysCustomerFormFieldTableEntity field7 = new SysCustomerFormFieldTableEntity(name,"owner_department","所属科室",3,0,1,pid, 1,0,50,7);
        list.add(field1);
        list.add(field2);
        list.add(field3);
        list.add(field4);
        list.add(field5);
        list.add(field6);
        list.add(field7);
        return list;
    }



    public static List<SysCustomerFormFieldTableEntity> InitFieldChildrenMany(String pid,String name){
        List<SysCustomerFormFieldTableEntity> list = new ArrayList<>();
        //类型: 1 整数 2 小数 3 文本 4 大文本 5 单选下拉框 6 多选下拉框 7 日期(yyyy-MM-dd) 8 日期时间(yyyy-MM-dd HH:mm:ss) 9 年份(yyyy) 10 年月(yyyy-MM) 11 时间(HH:mm:ss) 12 文件 13 图片
        //String table_name String name, String label, Integer type, Integer is_mainfield, Integer is_system, String facttable_id default_show,is_null,is_edit order_number
        SysCustomerFormFieldTableEntity field1 = new SysCustomerFormFieldTableEntity(name,"id","id主键",3,1,1,pid, 0,0,50,1);
        SysCustomerFormFieldTableEntity field2 = new SysCustomerFormFieldTableEntity(name,"created_time","创建时间",8,0,1,pid, 0,0,19,2);
        SysCustomerFormFieldTableEntity field3 = new SysCustomerFormFieldTableEntity(name,"created_user","创建用户",3,0,1,pid, 1,0,50,3);
        SysCustomerFormFieldTableEntity field4 = new SysCustomerFormFieldTableEntity(name,"modified_time","修改时间",8,0,1,pid, 0,0,19,4);
        SysCustomerFormFieldTableEntity field5 = new SysCustomerFormFieldTableEntity(name,"modified_user","修改用户",3,0,1,pid, 1,0,50,5);
        SysCustomerFormFieldTableEntity field6 = new SysCustomerFormFieldTableEntity(name,"maintable_id","父表ID",3,0,1,pid, 1,0,50,6);
       // SysCustomerFormFieldTableEntity field7 = new SysCustomerFormFieldTableEntity(name,"order_number","序号",1,0,1,pid, 0,0,50,7);
        list.add(field1);
        list.add(field2);
        list.add(field3);
        list.add(field4);
        list.add(field5);
        list.add(field6);
       // list.add(field7);
        return list;
    }

    public static List<SysCustomerFormFieldTableEntity> InitFieldChildrenOne(String pid,String name){
        List<SysCustomerFormFieldTableEntity> list = new ArrayList<>();
        //类型: 1 整数 2 小数 3 文本 4 大文本 5 单选下拉框 6 多选下拉框 7 日期(yyyy-MM-dd) 8 日期时间(yyyy-MM-dd HH:mm:ss) 9 年份(yyyy) 10 年月(yyyy-MM) 11 时间(HH:mm:ss) 12 文件 13 图片
        //String table_name String name, String label, Integer type, Integer is_mainfield, Integer is_system, String facttable_id default_show,is_null,is_edit order_number
        //SysCustomerFormFieldTableEntity field1 = new SysCustomerFormFieldTableEntity(name,"id","id主键",3,1,1,pid,0,0,0,50,1);
        SysCustomerFormFieldTableEntity field1 = new SysCustomerFormFieldTableEntity(name,"maintable_id","主键父表ID",3,1,1,pid, 0,0,50,1);
        SysCustomerFormFieldTableEntity field2 = new SysCustomerFormFieldTableEntity(name,"created_time","创建时间",8,0,1,pid, 0,0,19,2);
        SysCustomerFormFieldTableEntity field3 = new SysCustomerFormFieldTableEntity(name,"created_user","创建用户",3,0,1,pid, 1,0,50,3);
        SysCustomerFormFieldTableEntity field4 = new SysCustomerFormFieldTableEntity(name,"modified_time","修改时间",8,0,1,pid, 0,0,19,4);
        SysCustomerFormFieldTableEntity field5 = new SysCustomerFormFieldTableEntity(name,"modified_user","修改用户",3,0,1,pid, 1,0,50,5);
        list.add(field1);
        list.add(field2);
        list.add(field3);
        list.add(field4);
        list.add(field5);
        return list;
    }

    public static String InitFieldChildManySql(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append(" CREATE TABLE [dbo].["+tableName+"] (\n" +
                "\t[id] UNIQUEIDENTIFIER ROWGUIDCOL PRIMARY KEY  NOT NULL CONSTRAINT [PK_"+tableName+"]  DEFAULT (NEWSEQUENTIALID()),\n" +
                "\t[created_time] [varchar](50) DEFAULT (CONVERT([varchar](19),getdate(),(120)))  NULL,\n" +
                "\t[created_user] [varchar](50) NULL,\n" +
                "\t[modified_time] [varchar](50) NULL,\n" +
                "\t[modified_user] [varchar](50) NULL,\n" +
                "\t[maintable_id] [varchar](50) NOT NULL)" );
        return sb.toString();
    }

    public static String InitFieldChildOneSql(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append(" CREATE TABLE [dbo].["+tableName+"] (\n" +
                "\t[maintable_id] [varchar](50) PRIMARY KEY NOT NULL,\n" +
                "\t[created_time] [varchar](50) DEFAULT (CONVERT([varchar](19),getdate(),(120)))  NULL,\n" +
                "\t[created_user] [varchar](50) NULL,\n" +
                "\t[modified_time] [varchar](50) NULL,\n" +
                "\t[modified_user] [varchar](50) NULL )" );
        return sb.toString();
    }

    public static String InitFieldSql(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append(" CREATE TABLE [dbo].["+tableName+"] (\n" +
                "\t[id] UNIQUEIDENTIFIER ROWGUIDCOL PRIMARY KEY  NOT NULL CONSTRAINT [PK_"+tableName+"]  DEFAULT (NEWSEQUENTIALID()),\n" +
                "\t[created_time] [varchar](50) DEFAULT (CONVERT([varchar](19),getdate(),(120)))  NULL,\n" +
                "\t[created_user] [varchar](50) NULL,\n" +
                "\t[modified_time] [varchar](50) NULL,\n" +
                "\t[modified_user] [varchar](50) NULL,\n" +
                "\t[owner_user] [varchar](50) NULL,\n" +
                "\t[owner_department] [varchar](50) NULL,\n" +
                "\t[toexamine_process] [varchar](50)  NULL,\n" +
                "\t[toexamine_step] [varchar](50)   NULL,\n" +
                "\t[toexamine_branchs] [varchar](500)  NULL,\n" +
                "\t[toexamine_currentusers] [varchar](500) NULL,\n" +
                "\t[toexamine_currentnames] [varchar](500) NULL,\n" +
                "\t[toexamine_result] int NULL ) ");
        return sb.toString();
    }


    public static String AddSqlText(SysCustomerFormFieldTableEntity fieldEntity){
        StringBuilder sb = new StringBuilder();
        sb.append(" ALTER TABLE "+fieldEntity.getTable_name()+" ADD "+fieldEntity.getName()+" ");
        sb.append(DataType(fieldEntity.getType(),fieldEntity.getField_length(),fieldEntity.getIs_null(),fieldEntity.getNum_length()));
        return sb.toString();
    }

    public static String UpdateSqlText(SysCustomerFormFieldTableEntity fieldEntity){
        StringBuilder sb = new StringBuilder();
        sb.append(" ALTER TABLE "+fieldEntity.getTable_name()+" alter  column "+fieldEntity.getName()+" ");
        sb.append(DataType(fieldEntity.getType(),fieldEntity.getField_length(),fieldEntity.getIs_null(),fieldEntity.getNum_length()));
        return sb.toString();
    }


    //alter table tableName drop column columnName
    public static String DelSqlText(SysCustomerFormFieldTableEntity fieldEntity){
        StringBuilder sb = new StringBuilder();
        sb.append(" ALTER TABLE "+fieldEntity.getTable_name()+" drop column "+fieldEntity.getName()+" ");
        return sb.toString();
    }


    /**
     *TODO 文件图片类型没有进行操作
     * @param type 字段类型
     * @param fieldLength 字段长度 多指字符串
     * @param isNull   字段是否为null
     * @param numLength 小数位数
     * @return
     *
     */
    public static String DataType(Integer type,Integer fieldLength,Integer isNull,Integer numLength){
        //类型: 1 整数 2 小数 3 文本 4 大文本 5 单选下拉框 6 多选下拉框 7 日期(yyyy-MM-dd)
        // 8 日期时间(yyyy-MM-dd HH:mm:ss) 9 年份(yyyy)
        // 10 年月(yyyy-MM) 11 时间(HH:mm:ss) 12 文件 13 图片  14单选 15多选 16电子签名
        String typeStr="";
        String fieldLengthStr = " ("+fieldLength+") ";
        String numLengthStr = " (18, "+numLength+") ";
        String isNullStr = isNull==1?" NULL ":" NOT NULL ";
        if(1 == type ){
            typeStr = "int "+isNullStr;
        }else if(2 == type ){
            typeStr = "decimal "+numLengthStr+isNullStr;
        }else if(3 == type||5==type || 6==type || 14==type ||  15 ==type ){
            typeStr = "varchar "+fieldLengthStr+isNullStr;
        }else if(4 == type ||16==type ){
            typeStr = "varchar(max) "+isNullStr;
        }else if(7 == type ){
            typeStr = "varchar(10) "+isNullStr;
        }else if(8 == type ){
            typeStr = "varchar(19) "+isNullStr;
        }else if(9 == type ){
            typeStr = "varchar(4) "+isNullStr;
        }else if(10 == type ){
            typeStr = "varchar(7) "+isNullStr;
        }else if(11 == type ){
            typeStr = "varchar(8) "+isNullStr;
        }else if(12 == type ||13 == type ){
            typeStr = "varchar(200) "+isNullStr;
        }
        return typeStr;
    }

    /***
     * 自动生成建表sql 全自动版
     * @param tabelStructure
     * @param table_name
     * @return
     * @throws IOException
     */
    public static File createTabelStructureAuto(List<TableModelDBO> tabelStructure, String table_name) throws IOException {
        File tempFile = File.createTempFile(table_name, ".sql");
        StringBuilder sb = new StringBuilder(" CREATE TABLE ");
        sb.append(table_name).append("(").append(LineBreak);
        tabelStructure.forEach(e->{
            sb.append(" [").append(e.getName()).append("] ").append(e.getColtype2()).append(" ");
            //主键
            if(e.getIsmain().equals("1"))
                sb.append(" PRIMARY KEY ");
            //默认值
            if(!StringUtils.isEmpty(e.getDefval()))
                sb.append(" DEFAULT ").append(e.getDefval()).append(" ");
            //是否可以为null
            if (e.getAblenull().equals("1"))
                sb.append(" NULL,").append(LineBreak);
            else
                sb.append(" NOT NULL,").append(LineBreak);
        });
        sb.append(")");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile),"UTF-8"));
        bw.write(new String(sb.toString().getBytes("utf-8"),"utf-8"));
        bw.flush();
        bw.close();
        return tempFile;
    }

    /**
     *  自动生成建表sql id 手动版
     * @param tabelStructure
     * @param table_name
     * @return
     * @throws IOException
     */
    public static File createTabelStructure(List<TableModelDBO> tabelStructure, String table_name) throws IOException {
        File tempFile = File.createTempFile(table_name, ".sql");
        StringBuilder sb = new StringBuilder(" CREATE TABLE ");
        sb.append(table_name).append("(").append(LineBreak);
        sb.append(" id UNIQUEIDENTIFIER ROWGUIDCOL PRIMARY KEY  NOT NULL CONSTRAINT [PK_"+table_name+"] DEFAULT (NEWSEQUENTIALID()),").append(LineBreak);
        tabelStructure.forEach(e->{
            sb.append(" [").append(e.getName()).append("] ").append(e.getColtype2()).append(" ");
            //默认值
            if(!StringUtils.isEmpty(e.getDefval()))
                sb.append(" DEFAULT ").append(e.getDefval()).append(" ");
            //是否可以为null
            if (e.getAblenull().equals("1"))
                sb.append(" NULL,").append(LineBreak);
            else
                sb.append(" NOT NULL,").append(LineBreak);
        });
        sb.append(")");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile),"UTF-8"));
        bw.write(new String(sb.toString().getBytes("utf-8"),"utf-8"));
        bw.flush();
        bw.close();
        return tempFile;
    }



    public static File createLayOutFile( String table_name,String table_id,Object o) throws IOException {
        File tempFile = File.createTempFile(table_name+"."+table_id+"#", ".Lay");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile),"UTF-8"));
        bw.write(new String(o.toString().getBytes("utf-8"),"utf-8"));
        bw.flush();
        bw.close();
        return tempFile;
    }

    public static File createBaseDataFile(File tempFile, Object o) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile),"UTF-8"));
        bw.write(new String(o.toString().getBytes("utf-8"),"utf-8"));
        bw.flush();
        bw.close();
        return tempFile;
    }


}
