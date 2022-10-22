package com.sxdl.hn.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Datespilce {




    /** * 根据一段时间区间，按月份拆分成多个时间段 * @author lxg * * 2016年9月5日下午6:18:36 */

    public static void main(String[] args) {
        List<KeyValueForDate> list = getKeyValueForDate("2018-08-23", "2020-06-10");
        System.out.println("开始日期--------------结束日期");
        for (KeyValueForDate date : list) {
            System.out.println(date.getStartDate() + "-----" + date.getEndDate());
        }
    }


        /** * 根据一段时间区间，按月份拆分成多个时间段 * @param startDate 开始日期 * @param endDate 结束日期  */

        public static List<KeyValueForDate> getKeyValueForDate(String startDate,String endDate) {
            List<KeyValueForDate> list = null;
            try {
                list = new ArrayList<KeyValueForDate>();
                String firstDay = "";
                String lastDay = "";
                Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);// 定义起始日期
                Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);// 定义结束日期
                Calendar dd = Calendar.getInstance();// 定义日期实例
                dd.setTime(d1);// 设置日期起始时间
                Calendar cale = Calendar.getInstance();
                Calendar c = Calendar.getInstance();
                c.setTime(d2);
                int startDay = d1.getDate();
                int endDay = d2.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                KeyValueForDate keyValueForDate = null;
                while (dd.getTime().before(d2)) {// 判断是否到结束日期
                    keyValueForDate = new KeyValueForDate();
                    cale.setTime(dd.getTime());
                    if(dd.getTime().equals(d1)){
                        cale.set(Calendar.DAY_OF_MONTH, dd .getActualMaximum(Calendar.DAY_OF_MONTH));
                        lastDay = sdf.format(cale.getTime());
                        keyValueForDate.setStartDate(sdf.format(d1));
                        keyValueForDate.setEndDate(lastDay);
                    }else if(
                            dd.get(Calendar.MONTH) == d2.getMonth() && dd.get(Calendar.YEAR) == c.get(Calendar.YEAR)){
                        cale.set(Calendar.DAY_OF_MONTH,1);//取第一天
                        firstDay = sdf.format(cale.getTime());
                        keyValueForDate.setStartDate(firstDay);
                        keyValueForDate.setEndDate(sdf.format(d2));
                    }else {
                        cale.set(Calendar.DAY_OF_MONTH,1);//取第一天
                        firstDay = sdf.format(cale.getTime());
                        cale.set(Calendar.DAY_OF_MONTH,
                                dd .getActualMaximum(Calendar.DAY_OF_MONTH));
                        lastDay = sdf.format(cale.getTime());
                        keyValueForDate.setStartDate(firstDay);
                        keyValueForDate.setEndDate(lastDay);
                    }
                    list.add(keyValueForDate);
                    dd.add(Calendar.MONTH, 1);// 进行当前日期月份加1
                } if(endDay<startDay){
                    keyValueForDate = new KeyValueForDate();
                    cale.setTime(d2); cale.set(Calendar.DAY_OF_MONTH,1);//取第一天
                    firstDay = sdf.format(cale.getTime());
                    keyValueForDate.setStartDate(firstDay);
                    keyValueForDate.setEndDate(sdf.format(d2));
                    list.add(keyValueForDate);
                } } catch (Exception e) {
                   e.printStackTrace();
                 }
            return list;
        }


    static class KeyValueForDate{
        private String startDate;
        private String endDate;
        public String getStartDate() {
            return startDate;
        }
        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }
        public String getEndDate() {
            return endDate;
        }
        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

  }
}
