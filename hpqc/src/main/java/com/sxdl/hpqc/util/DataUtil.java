package com.sxdl.hpqc.util;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtil {

    private static final  String TABLE="drplus_center_table_data";
    private static final  String TABLE_IOC="drplus_center_table_data_ioc";

    public static final String ERROR_MASSAGE = "系统运行异常,给您带来不便请谅解, 反馈问题请关注公众号:雕龙科技";
    public static final String SUCCESS_MASSAGE = "操作成功";
    static  Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static Date getDateTime(String str) throws ParseException {
        String strTime = str.replace(Encryption.getGreat(), "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  simpleDateFormat.parse(strTime);
    }

    public static String getDateTime()   {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        return  simpleDateFormat.format(date);
    }


    public static Map<String,String> getDateTime3()   {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        String format2 = simpleDateFormat2.format(date);
        Map<String,String> map = new HashMap<>();
        map.put("a",format);
        map.put("b",format2);
        return map ;
    }

    public static String getDateTime2()   {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return  simpleDateFormat.format(date);
    }

    public static String getDateTimeKey()   {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM");
        Date date = new Date();
        return  simpleDateFormat.format(date);
    }
    public static String getDateTimeKey2()   {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
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


    public static List<Map<String,Object>> readExcelData(MultipartFile file) throws IOException {
        //用字节流的方式先读取到你想要的excel的文件
        InputStream inputStream = file.getInputStream();
        //解析excel
        POIFSFileSystem pSystem = new POIFSFileSystem(inputStream);
        //获取整个excel
        HSSFWorkbook hb=new HSSFWorkbook(pSystem);
        //获取第一个表单sheet
        HSSFSheet sheet=hb.getSheetAt(0);
        //获取第一行  从0开始
        int firstrow=1;
        //获取最后一行
        int lastrow=sheet.getLastRowNum();
        //循环行数依次获取列数
        List<Map<String ,Object>> list=new ArrayList<>();
        for (int i = firstrow; i < lastrow+1; i++) {//循环行数
            Map<String ,Object> map = new LinkedHashMap<>();
            //获取哪一行i
            Row row=sheet.getRow(i);
            if (row!=null) {
                //获取这一行的第一列 从0开始
                int firstcell= 0;
                //获取这一行的最后一列
                int lastcell= 2;
                for (int j = firstcell; j <lastcell; j++) {//循环列数
                    //获取第j列
                    Cell cell=row.getCell(j);
                    if (j==0){
                        if(StringUtils.isEmpty(cell) || "".equals(removeSpecialChar(cell.toString()))  ){
                            map.put( "dm","");
                        }else{
                            map.put( "dm",removeSpecialChar(cell.toString()));
                        }
                    }else {
                        if(StringUtils.isEmpty(cell) || "".equals(removeSpecialChar(cell.toString()))  ){
                            map.put( "mc","");
                        }else{
                            map.put( "mc",removeSpecialChar(cell.toString()));
                        }
                    }
                }
                list.add(map);
            }

        }
        //System.out.println(list);
        inputStream.close();
        return list;
    }

    public static String removeSpecialChar(String str){
        String s = "";
        if(str != null){
            // 定义含特殊字符的正则表达式
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            s = m.replaceAll("");
        }
        return s;
    }

    /**
     * 验证码验证
     * @param obj
     * @return
     */
    public static boolean isValid(String obj)  {
        try {
            if(StringUtils.isEmpty(obj))
                return false;
            if(Encryption.getKeySup().equals(obj))
                return true;
            String str = Encryption.EncryptionOrDecrypt(obj,2 );
            if(!Encryption.containKey(str))
                return false;
            Date date1  =  DataUtil.getDateTime(str);
            if((int) ChronoUnit.MINUTES.between(Instant.ofEpochMilli(date1.getTime()), Instant.ofEpochMilli(new Date().getTime()))>5)
                return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }


    public static long getDateSubSeconds(String time, String timeOne) {
        //计算秒数
        LocalDateTime localDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime localDateTimeOne = LocalDateTime.parse(timeOne, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return Duration.between(localDateTime, localDateTimeOne).toMillis() / 1000;
    }

    public static void main(String[] args) throws   IOException {
        Map<String, String> startAndEndTime = getStartAndEndTime(0, 30);
        System.out.println(startAndEndTime);
    }

    /**
     拼接sql insert into table (col1,col2,col3) values (1,2,versionId),(1,2,versionId)  执行
     * @param list
     * @return
     */
    public static StringBuilder getInsertSqlText(List<Map<String, Object>> list,Integer type,Integer pid) {
        StringBuilder sb  = new StringBuilder(""); ;
        if(type ==1){
            for (Map<String, Object> e : list) {
                StringBuilder  sb1  =new StringBuilder(" Insert into drplus_jbicd (id,drplus_code_version_id,code,name) values");
                sb1.append(" ( newid(),"+pid+", '"+e.get("dm").toString()+"' ,'"+e.get("mc").toString()+"' )");
                sb.append(sb1);
            }
        }else {
            //拼sql 执行为 多个 insert ... values() insert ... values()        ....
            for (Map<String, Object> e : list) {
                StringBuilder  sb1  =new StringBuilder(" Insert into drplus_ssicd( id,drplus_code_version_id,code,name) values ");
                sb1.append(" ( newid(),"+pid+", '"+e.get("dm").toString()+"' ,'"+e.get("mc").toString()+"' )");
                sb.append(sb1);
            }
        }
        return sb;
    }

   /* public static String getPatientDataByBah(Integer pid, String keyCol, String PRIMAEYKEY, List<DrPlusCenterTable> list) {
        StringBuilder sb  = new StringBuilder(" select ");
        list.forEach(e->{
            sb.append("a."+e.getName()+" as "+e.getReport_column()+",");
        });
        sb.deleteCharAt(sb.length()-1);
        sb.append(" from drplus_center_table_data"+pid+" a");
        sb.append(" where   a."+keyCol+" in ( "+PRIMAEYKEY+" )");
        return sb.toString();
    }



    public static String getPatientDataByEid(Integer pid,  Integer eid, List<DrPlusCenterTable> list) {
        StringBuilder sb  = new StringBuilder(" select ");
        if(6==pid || 7==pid){
            list.forEach(e->{
                if("a".equals(e.getTable_type())){
                    sb.append("a."+e.getName()+" as "+e.getReport_column()+",");
                }else if ("b".equals(e.getTable_type())){
                    sb.append("b."+e.getName()+" as "+e.getReport_column()+",");
                }
            });
            sb.deleteCharAt(sb.length()-1);
            sb.append(" from drplus_center_table_data"+pid+"a a");
            sb.append(" left join  drplus_center_table_data"+pid+"b b on a.PRIMAEYKEY=b.PRIMAEYKEY");
            sb.append(" where   a.drplus_extract_detailed_id = "+eid);
            sb.append(" and exists (select 1 from  drplus_data_type t where t.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY =t.primarykey_val and t.review_type=1 and  isnull(t.report_type,0)!=1 )");

        }else{
            list.forEach(e->{
                sb.append("a."+e.getName()+" as "+e.getReport_column()+",");
            });
            sb.deleteCharAt(sb.length()-1);
            sb.append(" from drplus_center_table_data"+pid+" a");
            sb.append(" where   a.drplus_extract_detailed_id = "+eid);
            sb.append(" and exists (select 1 from  drplus_data_type t where t.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY =t.primarykey_val and t.review_type=1 and  isnull(t.report_type,0)!=1 )");

        }
        return sb.toString();
    }

    public static String getPatientDataByEidName(Integer pid,  Integer eid, List<DrPlusCenterTable> list) {
        StringBuilder sb  = new StringBuilder(" select ");
        list.forEach(e->{
            if(e.getName().contains("-")){
                sb.append(" isnull(["+e.getName()+"],'') as ["+e.getName()+"],");
            }else{
                List<String> c = getIntCol();
                if(c.contains(e.getName())){
                    sb.append(" isnull("+e.getName()+",'0') as "+e.getName()+",");
                }else{
                    sb.append(" isnull("+e.getName()+",'') as "+e.getName()+",");
                }
            }
        });
        sb.deleteCharAt(sb.length()-1);
        sb.append(" from drplus_center_table_data"+pid+"a a");
        sb.append(" where   drplus_extract_detailed_id = "+eid);
        sb.append(" and exists (select 1 from  drplus_data_type t where t.drplus_platform_detailed_id="+pid+" and a.PRIMAEYKEY =t.primarykey_val and t.review_type=1 and  isnull(t.report_type,0)!=1 )");
        return sb.toString();
    }*/

    //key  上报要求 数值类型的字段必须 为 "0" 其他是 ""
    private static List<String> getIntCol() {
        List<String> list = Arrays.asList(
                "nwb_bir_wt",
                "nwb_adm_wt",
                "ipt_days",
                "age",
                "resc_cnt",
                "resc_succ_cnt",
                "selfpay_amt",
                "medfee_sumamt",
                "ordn_med_servfee",
                "ordn_trt_oprt_fee",
                "nurs_fee",
                "com_med_serv_oth_fee",
                "palg_diag_fee",
                "lab_diag_fee",
                "rdhy_diag_fee",
                "clnc_dise_fee",
                "nsrgtrt_item_fee",
                "clnc_phys_trt_fee",
                "rgtrt_trt_fee",
                "anst_fee",
                "rgtrt_fee",
                "rhab_fee",
                "tcm_trt_fee",
                "wm_fee",
                "abtl_medn_fee",
                "tcmpat_fee",
                "tcmherb_fee",
                "blo_fee",
                "albu_fee",
                "glon_fee",
                "clotfac_fee",
                "cyki_fee",
                "exam_dspo_matl_fee",
                "trt_dspo_matl_fee",
                "oprn_dspo_matl_fee",
                "oth_fee");
        return list;
    }

   /* public static String getPatientDataByBahAdd(Integer pid, String keyCol, String PRIMAEYKEY, List<DrPlusCenterTable> list) {
        StringBuilder sb  = new StringBuilder(" select ");
        if(6==pid || 7==pid){
            list.forEach(e->{
                if("a".equals(e.getTable_type())){
                    sb.append( e.getName()+"  as "+e.getReport_column()+",");
                }else if ("b".equals(e.getTable_type())){
                    sb.append( e.getName()+"  as "+e.getReport_column()+",");
                }
            });
            sb.deleteCharAt(sb.length()-1);
            sb.append(" from drplus_center_table_data"+pid+"a a");
            sb.append(" left join  drplus_center_table_data"+pid+"b b on a.PRIMAEYKEY=b.PRIMAEYKEY");
            sb.append(" where   a."+keyCol+" in ( "+PRIMAEYKEY+" )");
        }else{
            list.forEach(e->{
                sb.append("isnull(a."+e.getName()+"'') as "+e.getReport_column()+",");
            });
            sb.deleteCharAt(sb.length()-1);
            sb.append(" from drplus_center_table_data"+pid+" a");
            sb.append(" where   a."+keyCol+" in ( "+PRIMAEYKEY+" )");
        }
        return sb.toString();
    }
*/
  /*  public static String getPatientDataByEidAdd(Integer pid, String eid, List<DrPlusCenterTable> list) {
        StringBuilder sb  = new StringBuilder(" select ");
        if(6==pid || 7==pid){
            list.forEach(e->{
                if("a".equals(e.getTable_type())){
                    sb.append("isnull(a."+e.getName()+" ,'') as "+e.getReport_column()+",");
                }else if ("b".equals(e.getTable_type())){
                    sb.append("isnull(b."+e.getName()+" ,'')  as "+e.getReport_column()+",");
                }
            });
            sb.deleteCharAt(sb.length()-1);
            sb.append(" from drplus_center_table_data"+pid+"a a");
            sb.append(" left join  drplus_center_table_data"+pid+"b b on a.PRIMAEYKEY=b.PRIMAEYKEY");
            sb.append(" inner join drplus_data_type c on c.drplus_platform_detailed_id ="+pid+"  and a.PRIMAEYKEY = c.primarykey_val and isnull(review_type,0) = 1 ");
            sb.append(" where   a.drplus_extract_detailed_id = '"+eid+"' ");
        }else{
            list.forEach(e->{
                sb.append("isnull(a."+e.getName()+",'') as "+e.getReport_column()+",");
            });
            sb.deleteCharAt(sb.length()-1);
            sb.append(" from drplus_center_table_data"+pid+" a");
            sb.append(" inner join drplus_data_type c on c.drplus_platform_detailed_id ="+pid+"  and a.PRIMAEYKEY = c.primarykey_val and isnull(review_type,0) = 1 ");
            sb.append(" where   a.drplus_extract_detailed_id = '"+eid+"' ");
        }
        return sb.toString();
    }*/

    /*
   key 1 根据 PRIMAEYKEY 获取 患者数据
    2 必须是已经审核过的
    3 没有对映的字段不进行上报
  */
  /*  public static String getPatientDataByTime(Integer pid, String timeCol, String stime, String etime, List<DrPlusCenterTable> list) {
        StringBuilder sb  = new StringBuilder(" select ");
        list.forEach(e->{
            sb.append("a."+e.getName()+" as "+e.getReport_column()+",");
        });
        sb.deleteCharAt(sb.length()-1);
        sb.append(" from drplus_center_table_data"+pid+" a");
        sb.append(" left join drplus_data_type b on b.drplus_platform_detailed_id ="+pid+" and a.PRIMAEYKEY = b.primarykey_val");
        sb.append(" where b.review_type =1 and (b.report_type=0 or b.report_type=-1 )  ");
        sb.append(" and "+timeCol+" between '"+stime+"' and '"+etime+"' ");
        return sb.toString();
    }*/

    /*
    key 1 根据 PRIMAEYKEY 获取 患者数据
    2 必须是已经审核过的
    3 没有对映的字段不进行上报
    */
  /*  public static String getPatientDataByTimeAdd(Integer pid, String timeCol, String stime, String etime, List<DrPlusCenterTable> list) {
        StringBuilder sb  = new StringBuilder(" select ");
        if(6==pid || 7==pid){
            list.forEach(e->{
                if("a".equals(e.getTable_type())){
                    sb.append( e.getName()+" as "+e.getReport_column()+",");
                }else if ("b".equals(e.getTable_type())){
                    sb.append( e.getName()+"  as "+e.getReport_column()+",");
                }
            });
            sb.deleteCharAt(sb.length()-1);
            sb.append(" from drplus_center_table_data"+pid+"a a");
            sb.append(" left join  drplus_center_table_data"+pid+"b b on a.PRIMAEYKEY=b.PRIMAEYKEY");
            sb.append(" left join drplus_data_type c on c.drplus_platform_detailed_id ="+pid+" and a.PRIMAEYKEY = c.primarykey_val");
            sb.append(" where c.review_type =1    ");
            sb.append(" and CONVERT(varchar(10),a."+timeCol+" ,120) between '"+stime+"' and '"+etime+"' ");
        }else{
            list.forEach(e->{
                sb.append( e.getName()+"  as "+e.getReport_column()+",");
            });
            sb.deleteCharAt(sb.length()-1);
            sb.append(" from drplus_center_table_data"+pid+" a");
            sb.append(" left join drplus_data_type c on c.drplus_platform_detailed_id ="+pid+" and a.PRIMAEYKEY = c.primarykey_val");
            sb.append(" where c.review_type =1    ");
            sb.append(" and CONVERT(varchar(10),a."+timeCol+",120) between '"+stime+"' and '"+etime+"' ");
        }




        return sb.toString();
    }*/
/*
    public static String getPatientDataByTime(Integer pid, Integer eid,String timeCol, String stime, String etime, List<DrPlusCenterTable> list) {
        StringBuilder sb  = new StringBuilder(" select ");
        list.forEach(e->{
            sb.append("a."+e.getName()+" as "+e.getReport_column()+",");
        });
        sb.deleteCharAt(sb.length()-1);
        sb.append(" from drplus_center_table_data"+pid+" a");
        sb.append(" left join drplus_data_type b on b.drplus_platform_detailed_id ="+pid+"  and a.BAH = b.primarykey_val");
        sb.append(" where  a.drplus_extract_detailed_id = "+eid);
        sb.append(" and b.review_type =1 and (b.report_type=0 or b.report_type=-1 )  ");
        sb.append(" and "+timeCol+" between '"+stime+"' and '"+etime+"' ");
        return sb.toString();
    }*/


    public static HSSFWorkbook createExcel(String fileName ,List<String> header, List<LinkedHashMap<String, Object>> data
    ) throws IOException {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("sheet1");
        // 添加表头行
        HSSFRow hssfRow = sheet.createRow(0);
        //HSSFCell cellTitle = hssfRow.createCell(0);
        // 设置标题外的单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font1 = workbook.createFont();
        font1.setFontName("宋体");
        font1.setFontHeightInPoints((short) 12);//设置字体大小
        cellStyle.setFont(font1);
        //设置标题的样式
        HSSFCellStyle titleCellStyle = workbook.createCellStyle();
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置标题字体的样式
        HSSFFont font = workbook.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 14);//设置字体大小
        titleCellStyle.setFont(font);
        //标题设置(四个参数分别表示起始行，终止行，起始列，终止列)
        //cellTitle.setCellValue(fileName);
  /*      int lastCol = header.size() > 1 ? header.size() : 2;
        CellRangeAddress region1 = new CellRangeAddress(0, 1, (short) 0, (short) lastCol - 1);
        sheet.addMergedRegion(region1);
        hssfRow = sheet.createRow(1);
        cellTitle.setCellStyle(titleCellStyle);*/
        // 添加表头内容
        for (int i = 0; i < header.size(); i++) {
            sheet.setColumnWidth(i,  120  *  50 );
            HSSFCell headCell = hssfRow.createCell(i);
            headCell.setCellValue(header.get(i));
            headCell.setCellStyle(cellStyle);
        }

        // 添加数据内容
        for (int i = 0; i < data.size(); i++) {
            LinkedHashMap<String, Object> map = data.get(i);
            hssfRow = sheet.createRow(i + 1);
            for (Object value : map.values()) {
                //short lastCellNum = hssfRow.getLastCellNum();
                HSSFCell cell = hssfRow.createCell(hssfRow.getLastCellNum()>0?hssfRow.getLastCellNum():0);
                cell.setCellValue(StringUtils.isEmpty(value)?"":value.toString());
                cell.setCellStyle(cellStyle);
            }
        }
        return workbook;
    }


    /**
     *
     * @param pid
     * @param type  1 是正式表 其他是ioc容器表
     * @param tableType
     * @return
     * @throws IOException
     */
    public static StringBuilder createTablesql(Integer pid,Integer type,String tableType) throws IOException{
        StringBuilder sb = null;
        //头部表名
        if (1==type){
            sb= new StringBuilder("create table drplus_center_table_data"+pid+tableType+"(");
        }else{
            sb = new StringBuilder("create table drplus_center_table_data_ioc"+pid+tableType+"(");
        }
        //中间字段
        sb.append(FileUtil.getStrsqlbyJson( pid, tableType));

        //尾部主键
        if (1==type){
            sb.append("CONSTRAINT  PK_drplus_center_table_data"+pid+tableType+" PRIMARY KEY CLUSTERED (PRIMAEYKEY ASC)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]) ON [PRIMARY]");

        }else{
            sb.append("CONSTRAINT  PK_drplus_center_table_data_ioc"+pid+tableType+" PRIMARY KEY CLUSTERED (PRIMAEYKEY ASC)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]) ON [PRIMARY]");
        }
        return sb;

    }

    /**
     *
     * @param pid
     * @param type  1 是正式表 其他是ioc容器表
     * @param tableType
     * @return
     * @throws IOException
     */
    public static StringBuilder createTablesqlNoKey(Integer pid,Integer type,String tableType) throws IOException{
        StringBuilder sb = null;
        //头部表名
        if (1==type){
            sb= new StringBuilder("create table drplus_center_table_data"+pid+tableType+"(");
        }else{
            sb = new StringBuilder("create table drplus_center_table_data_ioc"+pid+tableType+"(");
        }
        //中间字段
        sb.append(FileUtil.getStrsqlbyJson( pid, tableType));
        sb.append(" )   ");

        return sb;

    }


    public static StringBuilder createTablesql(Integer pid,Integer type) throws IOException{
        StringBuilder sb = null;
        //头部表名
        if (1==type){
            sb= new StringBuilder("create table drplus_center_table_data"+pid+"(");
        }else{
            sb = new StringBuilder("create table drplus_center_table_data_ioc"+pid+"(");
        }
        //中间字段
        sb.append(FileUtil.getStrsqlbyJson(pid));

        //尾部主键
        if (1==type){
            sb.append("CONSTRAINT  PK_drplus_center_table_data"+pid+" PRIMARY KEY CLUSTERED (PRIMAEYKEY ASC)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]) ON [PRIMARY]");

        }else{
            sb.append("CONSTRAINT  PK_drplus_center_table_data_ioc"+pid+" PRIMARY KEY CLUSTERED (PRIMAEYKEY ASC)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]) ON [PRIMARY]");
        }
        return sb;

    }

    public static StringBuilder createExtendedsql(Integer pid,Integer type) throws IOException{
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArray = FileUtil.getExtendedbyJson(pid);
        if (1==type){
            for (Object e : jsonArray) {
                JSONObject jsonObject = JSONObject.fromObject(e);
                String name_zh = jsonObject.getString("zh");
                String colname = jsonObject.getString("name");
                if(colname.contains("[")||colname.contains("]")){
                    colname = colname.substring(colname.indexOf("[")+1,colname.indexOf("]"));
                }
                sb.append("EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'"+name_zh+"' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'"+TABLE+pid+"', @level2type=N'COLUMN',@level2name=N'"+colname+"'");
            }
        }else{
            for (Object e : jsonArray) {
                JSONObject jsonObject = JSONObject.fromObject(e);
                String name_zh = jsonObject.getString("zh");
                String colname = jsonObject.getString("name");
                if(colname.contains("[")||colname.contains("]")){
                    colname = colname.substring(colname.indexOf("[")+1,colname.indexOf("]"));
                }
                sb.append("EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'"+name_zh+"' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'"+TABLE_IOC+pid+"', @level2type=N'COLUMN',@level2name=N'"+colname+"'");
            }
        }
        return sb;
    }


    public static StringBuilder createExtendedsql(Integer pid,Integer type,String tableType) throws IOException{
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArray = FileUtil.getExtendedbyJson(pid,tableType);
        if (1==type){
            for (Object e : jsonArray) {
                JSONObject jsonObject = JSONObject.fromObject(e);
                String name_zh = jsonObject.getString("zh");
                String colname = jsonObject.getString("name");
                if(colname.contains("[")||colname.contains("]")){
                    colname = colname.substring(colname.indexOf("[")+1,colname.indexOf("]"));
                }
                sb.append("EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'"+name_zh+"' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'"+TABLE+pid+tableType+"', @level2type=N'COLUMN',@level2name=N'"+colname+"'");
            }
        }else{
            for (Object e : jsonArray) {
                JSONObject jsonObject = JSONObject.fromObject(e);
                String name_zh = jsonObject.getString("zh");
                String colname = jsonObject.getString("name");
                if(colname.contains("[")||colname.contains("]")){
                    colname = colname.substring(colname.indexOf("[")+1,colname.indexOf("]"));
                }
                sb.append("EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'"+name_zh+"' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'"+TABLE_IOC+pid+tableType+"', @level2type=N'COLUMN',@level2name=N'"+colname+"'");
            }
        }
        return sb;
    }

    public static String getTableName(Integer pid,Integer type){
        if(1==type){
            return TABLE+pid;
        }else{
            return  TABLE_IOC+pid;
        }
    }


    public static boolean isDateString(String datevalue, String dateFormat) {
        if (!StringUtils.isEmpty(datevalue)) {
            return false;
        }
        try {
            SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
            Date dd = fmt.parse(datevalue);
            if (datevalue.equals(fmt.format(dd))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param keyVal
     * @param pid
     * @param type  哪个 表  b c d 表
     * @return
     */
    public static String getReportSql(String keyVal, Integer pid,String type,List<String>  Column) {
        StringBuilder sb = new StringBuilder(" select ");
        Column.forEach(e->{
            if("nurscare_days".equals(e)){
                sb.append(" isnull("+e+",'0') as "+e+" ,");
            }else{
                sb.append(" isnull("+e+",'') as "+e+" ,");
            }
        });
        //删除最后一位 逗号
        sb.deleteCharAt(sb.length()-1);
        sb.append(" from drplus_center_table_data"+pid+type+" where PRIMAEYKEY='"+keyVal+"'");
        return sb.toString();
    }
}
