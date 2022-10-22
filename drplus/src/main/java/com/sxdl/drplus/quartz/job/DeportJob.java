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

public class DeportJob implements Job{

    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @Autowired
    private DrplusAutoRun drplusAutoRun;


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        Map<String, Object> map = jobDataMap.getWrappedMap();
        Integer pid = Integer.parseInt(map.get("id").toString());
        Integer offset = Integer.parseInt(map.get("offset2").toString());
        Integer e_days = Integer.parseInt(map.get("e_days2").toString());
        Map<String, String> startAndEndTime = DataUtil.getStartAndEndTime(offset, e_days);
        //drplusAutoRun.autoReport(pid,startAndEndTime.get("startTime"),startAndEndTime.get("endTime"));

        System.out.println(" 测试 上报  "+pid+"   :"+startAndEndTime);

    }
}
