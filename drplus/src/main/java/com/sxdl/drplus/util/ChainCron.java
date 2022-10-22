package com.sxdl.drplus.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.quartz.CronExpression;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ChainCron {

    public final static String[] CRON_TIME_CN = new String[]{"秒", "分钟", "小时", "号", "月","周", "年"};



    private final static Integer HOURS = 24;

    private final static Integer TIMESCALE = 60;


    public static void main(String[] args) throws ParseException {
        String   cronExpression = "0 0 * 15-31 * ? *";
        System.out.println(translateToChinese(cronExpression, CRON_TIME_CN));
        System.out.println(isCanDoExpression(cronExpression )?"成功":"失败");

        CronExpression exp = new CronExpression(cronExpression);
        /*String expressionSummary = exp.getExpressionSummary();
        System.out.println(expressionSummary);*/

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = s.parse("2021-12-27");
        Date e = exp.getNextValidTimeAfter(parse);
        System.out.println(s.format(e));
        String keyRuleStr = getKeyRuleStr(cronExpression, 2);
        System.out.println("规则:"+keyRuleStr);


    }


    /***
     *  生成主键规则: 平台id_当前年_当前月
     *  * 表示每个月都要生成
     *  - 表示范围 判断当前月份 是否在范文内 (类似between and)
     *  , 表示枚举值 拆分字符 判断与当前月份是否相符
     *  / 表示起始时间开始触发，然后每隔固定时间触发一次，例如在Minutes域使用5/20,则意味着5分钟触发一次，而25，45等分别触发一次
     */
    public static String getKeyRuleStr(String cron ,Integer pid){
        Calendar cal = Calendar.getInstance();
        //当前月份
        int nowMonth = cal.get(Calendar.MONTH) + 1;
        String keyStr = "";

        //cron 表达式的 月份规则
        String cronMonth = cron.split(" ")[4];
        String timeKey = null;
        if(cronMonth.contains("*")){
            timeKey = DataUtil.getDateTimeKey();
        }else if(cronMonth.contains("-")){
            String[] split = cronMonth.split("-");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            if(nowMonth>=s && nowMonth<=e)
                timeKey = DataUtil.getDateTimeKey();
        }else if(cronMonth.contains(",")){
            if(Arrays.asList(cronMonth.split(",")).contains(nowMonth+""))
                timeKey = DataUtil.getDateTimeKey();
        }else if(cronMonth.contains("/")){
            String[] split = cronMonth.split("/");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            List<Integer> list = new ArrayList<>();
            list.add(s);
            while (true){
                s = s+e;
                if(s<=12){
                    list.add(s);
                }else{
                    break;
                }
            }
            if(list.contains(nowMonth) )
                timeKey = DataUtil.getDateTimeKey();
        }
        if (StringUtils.isEmpty(timeKey))
            return null;
        keyStr = pid+"_"+timeKey;
        return keyStr;
    }


    /**
     * 校验表达式 不能指定 分钟和 秒
     *@songwen
     * @param expressionStr
     * @return
     * @throws ParseException
     */
    public static boolean isCanDoExpression(String expressionStr ){
        try {
            CronExpression exp = new CronExpression(expressionStr);
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH");
            return exp.isSatisfiedBy(s.parse(s.format(new Date())));
        }catch (ParseException p){
            System.out.println(p.getMessage());
        }
        return false;
    }




    /**
     *  主要解析 斜杆  /：表示起始时间开始触发，然后每隔固定时间触发一次。
     *      范围值+开始值 - 间隔值 = 范围内最后执行的值；
     *      例如在Hourss域使用3/4,则意味着从第3小时到24+3-4：23小时范围内，第3小时开始触发第一次，然后每隔4小时，即7，11，15，19，23小时等分别触发一次。
     *      例如在Minutes域使用5/20,则意味着从第5分钟到60+5-20：45分范围内，第5分钟开始触发第一次，然后每隔20分钟，即25，45分钟等分别触发一次。
     *      例如在Seconds域使用8/10,则意味着从第8秒到60+8-10：58秒范围内，第8秒开始触发第一次，然后每隔10秒，即18，28，38，48，58秒等分别触发一次。
     *      *
     *   对于 *：表示匹配该域的任意值。例如在Minutes域使用*, 即表示每分钟都会触发事件。
     *   对于问号  ?：只能用在DayofMonth和DayofWeek两个域，其作用为不指定
     *   对于 -：表示范围。例如在Minutes域使用5-20，表示从5分到20分钟每分钟触发一次。直接进行拼接
     *   对于逗号 ,：表示列出枚举值。例如在Minutes域使用5,20 ， 则意味着在5和20分每分钟触发一次。
     *   对于L：表示最后，只能出现在DayofWeek和DayofMonth域。
     *      如果出现在DayofMonth域，只能使用L，表示当月最后一天
     *      如果在DayofWeek域
     *          使用数字（1-7）或L（和7的作用一样表示每周的最后一天周六），比如数字"5"表示每周4， "7"或"L"表示每周六
     *          使用数字（1-7）结合L，表示当月最后一周的周几，比如"5L" 表示在最后的一周的周四； "3L" 表示最后一周的周二
     *   对于#: 用于确定每个月第几个星期几，只能出现在DayofMonth域。
     *      例如 "4#2" 表示某月的第二个星期三（4表示星期三，2表示第二周）;
     *       “6#3”表示本月第三周的星期五（6表示星期五，3表示第三周）;
     *       “2#1”表示本月第一周的星期一;
     *       “4#5”表示第五周的星期三。
     *
     * @param cronExp
     * @param cronTimeArr
     * @return
     */

    public static String translateToChinese(String cronExp, String[] cronTimeArr) {

        if (cronExp == null || cronExp.length() < 1) {

            return "cron表达式为空";

        }



        String[] tmpCorns = cronExp.split(" ");

        StringBuffer sBuffer = new StringBuffer();

        if (tmpCorns.length == 6 || tmpCorns.length == 7) {



            if (tmpCorns.length == 7) {

                //解析年 Year

                String year = tmpCorns[6];

                if((!year.equals("*") && !year.equals("?"))){

                    sBuffer.append(year).append(cronTimeArr[6]);

                }



            }



            //解析月 Month 主要解析 /

            String months = tmpCorns[4];

            if (!months.equals("*") && !months.equals("?")) {

                if (months.contains("/")) {

                    sBuffer.append("从").append(months.split("/")[0]).append("号开始").append(",每")

                            .append(months.split("/")[1]).append(cronTimeArr[4]);

                } else {

                    sBuffer.append("每年").append(months).append(cronTimeArr[4]);

                }

            }



            //解析周 DayofWeek  主要解析 , -  1~7/L   1L~7L

            String dayofWeek = tmpCorns[5];

            if (!dayofWeek.equals("*") && !dayofWeek.equals("?")) {

                if (dayofWeek.contains(",")) {// 多个数字，逗号隔开

                    sBuffer.append("每周的第").append(dayofWeek).append(cronTimeArr[3]);

                } else if (dayofWeek.contains("L") && dayofWeek.length() > NumberUtils.INTEGER_ONE) {// 1L-7L

                    String weekNum = dayofWeek.split("L")[0];

                    String weekName = judgeWeek(weekNum);

                    sBuffer.append("每月的最后一周的");

                    sBuffer.append(weekName);

                } else if(dayofWeek.contains("-")) {

                    String[] splitWeek = dayofWeek.split("-");

                    String weekOne = judgeWeek(splitWeek[0]);

                    String weekTwo = judgeWeek(splitWeek[1]);

                    sBuffer.append("每周的").append(weekOne).append("到").append(weekTwo);

                } else { // 1-7/L

                    if("L".equals(dayofWeek)){ // L 转换为7，便于识别

                        dayofWeek = "7";

                    }

                    int weekNums = Integer.parseInt(dayofWeek);

                    if(weekNums < 0 || weekNums > 7 ){

                        return "cron表达式有误，dayofWeek数字应为1-7";

                    }

                    sBuffer.append("每周的");

                    String weekName = judgeWeek(dayofWeek);

                    sBuffer.append(weekName);

                }

            }



            //解析日 days -- DayofMonth  需要解析的 / # L W

//                 *       “6#3”表示本月第三周的星期五（6表示星期五，3表示第三周）;

//     *       “2#1”表示本月第一周的星期一;

//     *       “4#5”表示第五周的星期三。

            String days = tmpCorns[3];

            if (!days.equals("?")&& !days.equals("*")) {



                if (days.contains("/")) {

                    sBuffer.append("每周从").append(days.split("/")[0]).append("号开始").append(",每")

                            .append(days.split("/")[1]).append(cronTimeArr[3]);

                } else if ("L".equals(days)) { // 处理L 每月的最后一天

                    sBuffer.append("每月最后一天");

                }  else if ("W".equals(days)) { // 处理W 暂时不懂怎么处理

                    sBuffer.append(days);

                }  else if (days.contains("#")) {

                    String[] splitDays = days.split("#");

                    String weekNum = splitDays[0]; // 前面数字表示周几

                    String weekOfMonth = splitDays[1]; // 后面的数字表示第几周 范围1-4 一个月最多4周

                    String weekName = judgeWeek(weekNum);

                    sBuffer.append(DataUtil.getDateTimeKey2()).append(weekOfMonth).append(cronTimeArr[5]).append(weekName);

                } else {

                    sBuffer.append(DataUtil.getDateTimeKey2()).append(days).append(cronTimeArr[3]);

                }



            } else {

                if (sBuffer.toString().length() == 0 || tmpCorns.length == 7) { // 前面没有内容的话，拼接下

                    sBuffer.append("每").append(cronTimeArr[3]);

                }

            }



            //解析时 Hours 主要解析 /



            String hours = tmpCorns[2];

            if (!hours.equals("*")) {

                if (hours.contains("/")) {

//                   sBuffer.append("内，从").append(hours.split("/")[0]).append("时开始").append(",每")

//                            .append(hours.split("/")[1]).append(cronTimeArr[2]);

                    sBuffer.append(appendGapInfo(hours, HOURS, 2));

                } else {

                    if (!(sBuffer.toString().length() > 0)) { // 对于 , 的情况，直接拼接

                        sBuffer.append("每天").append(hours).append(cronTimeArr[2]);

                    } else {

                        sBuffer.append(hours).append(cronTimeArr[2]);

                    }

                }

            }



            //解析分 Minutes 主要解析 /

            String minutes = tmpCorns[1];

            if (!minutes.equals("*")) {

                if (minutes.contains("/")) {

//                    sBuffer.append("内，从第").append(minutes.split("/")[0]).append("分开始").append(",每")

//                            .append(minutes.split("/")[1]).append(cronTimeArr[1]);

                    sBuffer.append(appendGapInfo(minutes, TIMESCALE, 1));

                } else if (minutes.equals("0")) {



                } else if (minutes.contains("-")) {

                    String[] splitMinute = minutes.split("-");

                    sBuffer.append(splitMinute[0]).append(cronTimeArr[1]).append("到").append(splitMinute[1])

                            .append(cronTimeArr[1]).append("每分钟");

                } else {

                    sBuffer.append(minutes).append(cronTimeArr[1]);

                }

            }



            //解析秒 Seconds 主要解析 /

            String seconds = tmpCorns[0];

            if (!seconds.equals("*")) {

                if (seconds.contains("/")) {

//                    sBuffer.append("内，从第").append(seconds.split("/")[0]).append("秒开始").append(",每")

//                            .append(seconds.split("/")[0]).append(cronTimeArr[0]);

                    sBuffer.append(appendGapInfo(seconds, TIMESCALE, 0));

                } else if (!seconds.equals("0")) {

                    sBuffer.append(seconds).append(cronTimeArr[0]);

                }

            }



            if (sBuffer.toString().length() > 0) {

                sBuffer.append("开始上报");

            } else {

                sBuffer.append("表达式中文转换异常");

            }

        }

        return sBuffer.toString();

    }





    public static String judgeWeek(String weekNum){

        String weekName = WeekEnum.matchNameCn(String.valueOf(weekNum));

        int weekNums = Integer.parseInt(weekNum);

        if(weekNums < 0 || weekNums > 7 ){

            return "cron表达式有误，dayofWeek 数字应为1-7";

        }

        return StringUtils.isNotEmpty(weekName) ? weekName : String.valueOf(weekNum);

    }



    private static String appendGapInfo(String time, int rangeNum, int index){

        StringBuffer sBufferTemp = new StringBuffer();

        String[] splitTime = time.split("/");

        String startNum = splitTime[0];

        String gapNum = splitTime[1];

        int endNum = rangeNum + Integer.parseInt(startNum) - Integer.parseInt(gapNum);

        String endStr = String.valueOf(endNum);

        String timeUnit = CRON_TIME_CN[index];

        sBufferTemp.append("从").append(startNum).append(timeUnit).append("开始")

                .append("到").append(endStr).append(timeUnit).append("范围内")

                .append(",每隔").append(gapNum).append(timeUnit);

        return sBufferTemp.toString();



    }

}
