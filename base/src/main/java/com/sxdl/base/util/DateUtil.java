package com.sxdl.base.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 时间及日期转换工具类,继承自 cn.hutool.core.date.DateUtil
 *
 * @see cn.hutool.core.date.DateUtil
 */
public class DateUtil extends cn.hutool.core.date.DateUtil {

    public static final String FORMATER_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMATER_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat sdfYMDHmS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final Log log = LogFactory.getLog(DateUtil.class);
    private static final String ending=" 23:59:59";

    /**
     * 首先解析日期,生成去年的日期,最后根据是否开始时间拼接完整字符串
     * @param s         字符串格式日期
     * @return
     */
    public static String getLastYearDate(String s){
        return getOffsetDate(s,-12);
    }
    /**
     * 首先解析日期,生成上月的日期,最后根据是否开始时间拼接完整字符串
     * @param s         字符串格式日期
     * @return
     */
    public static String getLastMonthDate(String s){
        return getOffsetDate(s,-1);
    }
    /**
     * 首先解析日期,然后根据月数的偏移量生成日期,最后根据是否开始时间拼接完整字符串
     * @param s         字符串格式日期
     * @param offset    月数的偏移量
     * @return
     */
    public static String getOffsetDate(String s, Integer offset) {
        return format(offsetMonth(parse(s), offset), FORMATER_YYYY_MM_DD);
    }

    /**
     * 返回java.sql.Date类型的当前时间
     *
     * @return
     */
    public static java.sql.Date getSqlDate() {
        return getSqlDate(new Date());
    }

    /**
     * 返回java.sql.Date类型的时间
     *
     * @param date
     * @return
     */
    public static java.sql.Date getSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    /**
     * 以"yyyy-MM-dd"格式来格式化日期
     *
     * @param date
     * @return
     */
    public static String formatFromDate(Date date) {
        return formatFromDate(FORMATER_YYYY_MM_DD, date);
    }


    public static String formatFromDate3(Date date) {
        return formatFromDate("yyyyMMddhhmmss", date);
    }

    /**
     * 以"yyyy-MM-dd"格式来格式化日期
     *
     * @param date
     * @return
     */
    public static String formatFromDate2(Date date) {
        return formatFromDate(FORMATER_YYYY_MM_DD_HH_MM_SS, date);
    }

    /**
     * 将"20201111"格式数据转化成 LocalDate
     *
     * @param sdate
     * @return
     * @throws ParseException
     */
    public static LocalDate formatYYYYMMDDFromDateToLocalDate(String sdate) throws ParseException {
        return LocalDateTime.ofInstant(sdfYMD.parse(sdate).toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 将"20201111"格式数据转化成 "2020-01-01 00:00:00"
     *
     * @param sdate
     * @return
     * @throws ParseException
     */
    public static String formatYYYYMMDDFromDateToYMDHmS(String sdate) throws ParseException {
        return sdfYMDHmS.format(sdfYMD.parse(sdate));
    }

    /**
     * 根据日期返回周数
     *
     * @param ld
     * @return
     */
    public static Integer getWeek(LocalDate ld) {
        return ld.get(WeekFields.ISO.weekOfWeekBasedYear());
    }

    /**
     * 根据月份数值返回季度
     *
     * @param month
     * @return
     */
    public static Integer getQuarter(Integer month) {
        int q = 0;
        if (month >= 1 && month <= 3) {
            q = 1;
        } else if (month >= 4 && month <= 6) {
            q = 2;
        } else if (month >= 7 && month <= 9) {
            q = 3;
        } else if (month >= 10 && month <= 12) {
            q = 4;
        }
        return q;
    }

    /**
     * 将 yyyy-MM-dd 格式字符串转化成date
     *
     * @param date
     * @return
     */
    public static String dateToStr(Date date) {
        String s = "";
        if (date == null) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            s = sdf.format(date);
        } catch (Exception e) {

        }

        return s;
    }

    /**
     * 将 yyyy-MM-dd 格式字符串转化成date
     *
     * @param s
     * @return
     */
    public static Date strToDate(String s) {
        Date d = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d = sdf.parse(s);
        } catch (Exception e) {

        }

        return d;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getCurrentDateTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        Date now = getCurrentDateTime();
        return strToDate(dateToStr(now));
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurrentDateForDateTime() {
        Date now = getCurrentDateTime();
        return formatFromDate(FORMATER_YYYY_MM_DD_HH_MM_SS, now);
    }


    /**
     * 按照给定的格式，格式化日期
     *
     * @param formater 需要的格式，常用的例如"yyyy-MM-dd HH:mm:ss"
     * @param date     日期
     * @return
     */
    public static String formatFromDate(String formater, Date date) {
        DateFormat df = new SimpleDateFormat(formater);
        return df.format(date);
    }


    /**
     * 按照给定的格式，格式化日期
     *
     * @param formater 需要的格式，常用的例如"yyyy-MM-dd HH:mm:ss"
     * @param s        可格式化为日期的字符串
     * @return
     */
    public static String formatFromString(String formater, String s) {
        DateFormat df = new SimpleDateFormat(formater);
        return df.format(s);
    }

    /**
     * 字符串转化为日期</br>
     *
     * @param str    需要被转换为日期的字符串
     * @param format 格式，常用的为 yyyy-MM-dd HH:mm:ss
     * @return java.util.Date，如果出错会返回null
     */
    public static Date StringToDate(String str, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            if (log.isErrorEnabled()) {
                log.error("将字符串转换成日期时出错", e);
            }
        }
        return date;
    }

    /**
     * 计算两个日期之间的天数</br>
     * 任何一个参数传空都会返回-1</br>
     * 返回两个日期的时间差，不关心两个日期的先后</br>
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static long getDaysBetweenTwoDate(Date dateStart, Date dateEnd) {
        if (null == dateStart || null == dateEnd) {
            return -1;
        }
        long l = Math.abs(dateStart.getTime() - dateEnd.getTime());
        l = l / (1000 * 60 * 60 * 24l);
        return l;
    }


    /**
     * 判断某字符串是否是日期类型
     *
     * @param strDate
     * @return
     */
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        return m.matches();
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param date
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 毫秒转化为天小时分钟秒
     *
     * @param ms 毫秒值
     * @return
     */
    public static String formatTime(long ms) {
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        double second = (ms - day * dd - hour * hh - minute * mi) * 1.0 / ss;
        //long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;
        //year, month, day, hour, minute, second
        //yyyy-MM-dd HH:mm:ss
        if (day > 0) {
            return day + "天" + hour + "时" + minute + "分" + second + "秒";
        } else if (hour > 0) {
            return hour + "时" + minute + "分" + second + "秒";
        } else if (minute > 0) {
            return minute + "分" + second + "秒";
        } else if (second > 0) {
            return second + "秒";
        } else {
            return 0 + "秒";
        }
    }


    /***
     * 将给定的时间范围，根据频率 来拆分成若干份
     * ex: 2020-01-01 2020-01-03   频率：1（天）  拆分成三天
     *
     * @param startTime  开始时间
     * @param EndTime    结束时间
     * @param rule       频率单位：月/天/周/时/分
     * @param timeLong   频率
     * @return
     * @throws ParseException
     */
    public static List<String> getSplicTimeParam(String startTime, String EndTime, String rule, Integer timeLong) throws ParseException {

        //重设 map集合的排序规则
        List<String> list = new ArrayList<>();
        //LinkedHashMap<String, String> map = new LinkedHashMap<>();
        // 将要存入map中的开始结束时间
        String start = "";
        String end = "";
        boolean b = true;
        SimpleDateFormat myFmt = null;
        if (startTime.length() == 10 && EndTime.length() == 10) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd");
        } else if (startTime.length() == 19 && EndTime.length() == 19) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if (startTime.length() == 23 && EndTime.length() == 23) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }

        Date startDate = null;
        Calendar instance = Calendar.getInstance();
        while (b) {
            if ("".equals(end)) {
                startDate = myFmt.parse(EndTime);
            } else {
                startDate = myFmt.parse(start);
            }
            instance.setTime(startDate);
            if ("天".equals(rule)) {
                instance.add(Calendar.DAY_OF_YEAR, -timeLong);
            } else if ("时".equals(rule)) {
                instance.add(Calendar.HOUR_OF_DAY, -timeLong);
            } else if ("月".equals(rule)) {
                instance.add(Calendar.MONTH, -timeLong);
            } else if ("周".equals(rule)) {
                instance.add(Calendar.WEEK_OF_YEAR, -timeLong);
            } else if ("分".equals(rule)) {
                instance.add(Calendar.MINUTE, -timeLong);
            }
            start = myFmt.format(instance.getTime());
            instance.setTime(startDate);
            end = myFmt.format(instance.getTime());
            ////startDate>value1;endDate>value2
            list.add(start);
            if (myFmt.parse(startTime).getTime() >= myFmt.parse(start).getTime()) {
                b = false;
            }
        }
        return list;
    }

    /**
     * 获取某年第一天
     *
     * @param year
     * @return
     */
    public static String getYearSDate(int year) {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        String format = myFmt.format(currYearFirst);
        System.out.println(format);
        return format;
    }

    /**
     * 获取某年最后一天
     *
     * @param year
     * @return
     */
    public static String getYearEDate(int year) {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        String format = myFmt.format(currYearLast);
        System.out.println(format);
        return format;
    }

    /**
     * 获取某月第一天
     *
     * @param Mon
     * @return
     */
    public static String getMonSDate(int Mon) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();//获取当前日期
        calendar.add(Calendar.MONTH, Mon);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String firstDay = format.format(calendar.getTime());
        System.out.println("-----2------firstDay:" + firstDay);
        return firstDay;
    }

    /**
     * 获取某月最后一天
     *
     * @param Mon
     * @return
     */
    public static String getMonEDate(int Mon) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, Mon);
        //calendar.set ( Calendar.DAY_OF_MONTH, dat );
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getMinimum(Calendar.DATE) - 1);
        String lastDay = format.format(calendar.getTime());
        System.out.println("-----2------lastDay:" + lastDay);
        return lastDay;
    }


    /**
     * 获取当天0点0分0秒时间
     *
     * @return
     */
    public static String getZeroTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        String format = simpleDateFormat.format(zero);
        return format;
    }

}