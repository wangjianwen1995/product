package com.sxdl.drplus.quartz.job;


import com.sxdl.drplus.service.auto.DrplusAutoRun;
import com.sxdl.drplus.util.DataUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class DynamicJob implements Job{

    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @Autowired
    private DrplusAutoRun drplusAutoRun;

    /**
     *
     * @param context 里面的数据实际是存储到 QRTZ_JOB_DETAILS.JOB_DATA 字段中,说明
     *                参数数据也会持久化
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        Map<String, Object> map = jobDataMap.getWrappedMap();
        Integer pid = Integer.parseInt(map.get("id").toString());
        Integer offset = Integer.parseInt(map.get("offset").toString());
        Integer e_days = Integer.parseInt(map.get("e_days").toString());

        //key 下面可以不需要查询数据库获取直接在 map中获取
//        Integer is_autoextract = Integer.parseInt(map.get("is_autoextract").toString());
//        Integer is_autocode = Integer.parseInt(map.get("is_autocode").toString());
//        Integer is_autoreview = Integer.parseInt(map.get("is_autoreview").toString());
//        Integer is_autoreport = Integer.parseInt(map.get("is_autoreport").toString());
        Map<String, String> startAndEndTime = DataUtil.getStartAndEndTime(offset, e_days);
        drplusAutoRun.drplusScheduled(pid,startAndEndTime.get("startTime"),startAndEndTime.get("endTime"));
        System.out.println(" 测试 抽取  "+pid+"   :"+startAndEndTime);


    }
}
