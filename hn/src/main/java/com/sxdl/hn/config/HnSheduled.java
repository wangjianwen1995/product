package com.sxdl.hn.config;


import com.sxdl.hn.dao.dao1.HnHandleDao;
import com.sxdl.hn.util.HNApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;

@Configuration
@EnableScheduling
public class HnSheduled   {

  /*  @Autowired
    private HnHandleDao hnHandleDao;
*/

    @Autowired
    private HNApplicationRunnerImpl runner;

    /**
     *
     * 每天晚上10点 定时更新缓存
     */
    // @Scheduled(cron = "0 0/1 * * * ?")
    @Scheduled(cron = "0 0 22 * * ?")
    public void hnScheduled(){
        //重新加载类目亚目缓存
        runner.setLmYm();
        System.out.println("..............(1自动更新)目亚目缓存 成功..............");
        //细目放到缓存中
        runner.setXm();
        System.out.println("..............(2自动更新)细目 成功..............");
        //考核模板放到缓存中
        runner.putTemplate();
        System.out.println("..............(3自动更新)考核模板 成功..............");
        //开始考核放到缓存中
        runner.templateMap.forEach((k,v)-> {
            try {
                runner.putStartAssessment(k);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("..............(4自动更新)开始考核放 成功..............");

    }


}
