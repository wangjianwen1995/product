package com.sxdl.hn.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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





}
