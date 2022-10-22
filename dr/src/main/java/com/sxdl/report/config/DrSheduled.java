package com.sxdl.report.config;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.report.controller.DrTableController;
import com.sxdl.report.dao.dao1.DrTemplateDao;
import com.sxdl.report.entity.DrTable;
import com.sxdl.report.entity.DrTemplate;
import com.sxdl.report.service.DrTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
public class DrSheduled {

    @Autowired
    private DrTableController drTableController;

    @Autowired
    private DrTemplateDao drTemplateDao;
    @Autowired
    private DrTableService drTableService;


    public void run(DrTemplate template,String stime,String etime)  {
        try {
            List<DrTemplate> drTemplates = drTemplateDao.select(template);
            if(drTemplates.size()>0){
                for (DrTemplate drTemplate : drTemplates) {
                    DrTable table = new DrTable();
                    table.setTemplate_id(drTemplate.getId());
                    List<DrTable> drTables = drTableService.select(table);
                    if(drTables.size()>0){
                        for (DrTable drTable : drTables) {
                            ResultUtil resultUtil = drTableController.ManualReport(drTemplate.getId(), drTable.getId(), stime, etime, "");
                            System.out.println(drTemplate.getName() + "  自动上报完成");
                        }
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * 每天早上09点 自动上报 时间是前天到昨天
     */
    // @Scheduled(cron = "*/30 * * * * ?")
    @Scheduled(cron = "0 0 9 * * ?")
    public void hnScheduledDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        String stime = sdf.format(calendar.getTime());//前天时间

        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String etime = sdf.format(calendar.getTime());//昨天时间

        System.out.println(stime +"----"+etime);

        DrTemplate template = new DrTemplate();
        template.setCorn("0 0 9 * * ?");
        run(template,stime,etime);

    }



    /**
     *
     * 每天晚上09点 自动上报 时间是前天到昨天
     */
    @Scheduled(cron = "0 0 21 * * ?")
    public void hnScheduledDay2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        String stime = sdf.format(calendar.getTime());//前天时间

        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String etime = sdf.format(calendar.getTime());//昨天时间

        System.out.println(stime +"----"+etime);

        DrTemplate template = new DrTemplate();
        template.setCorn("0 0 21 * * ?");
        run(template,stime,etime);

    }


    /**
     *
     * 每周周一早上10点 自动上报 时间是昨天到昨天-7天
     */
    @Scheduled(cron = "0 0 10 ? * MON")
    public void hnScheduledWeek(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -8);
        String stime = sdf.format(calendar.getTime());//前天时间

        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String etime = sdf.format(calendar.getTime());//昨天时间

        System.out.println(stime +"----"+etime);

        DrTemplate template = new DrTemplate();
        template.setCorn("0 0 10 ? * MON");
        run(template,stime,etime);

    }

    /**
     *
     * 每周周一晚上10点 自动上报 时间是昨天到昨天-7天
     */
    @Scheduled(cron = "0 0 22 ? * MON")
    public void hnScheduledWeek2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -8);
        String stime = sdf.format(calendar.getTime());//前天时间

        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        String etime = sdf.format(calendar.getTime());//昨天时间

        System.out.println(stime +"----"+etime);

        DrTemplate template = new DrTemplate();
        template.setCorn("0 0 22 ? * MON");
        run(template,stime,etime);

    }


    /**
     *
     * 每月最后一天早上10点 自动上报 时间是当月第一天到最后一天
     */
    @Scheduled(cron = "0 0 11 L * ?")
    public void hnScheduledMonth(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar   cal_1=Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String stime = sdf.format(cal_1.getTime());

        //获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
        String etime = sdf.format(cale.getTime());

        System.out.println(stime +"----"+etime);
        DrTemplate template = new DrTemplate();
        template.setCorn("0 0 11 L * ?");
        run(template,stime,etime);

    }


    /**
     *
     * 每月最后一天晚上11点 自动上报 时间是当月第一天到最后一天
     */
    @Scheduled(cron = "0 0 23 L * ?")
    public void hnScheduledMonth2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar   cal_1=Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String stime = sdf.format(cal_1.getTime());

        //获取前月的最后一天
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
        String etime = sdf.format(cale.getTime());

        System.out.println(stime +"----"+etime);
        DrTemplate template = new DrTemplate();
        template.setCorn("0 0 23 L * ?");
        run(template,stime,etime);
    }







}
