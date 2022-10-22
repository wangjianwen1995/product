package com.sxdl.cf.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class CFSheduled   {



    @Autowired
    private CFRunner runner;

    /**
     *
     * 每天晚上10点 定时更新缓存
     */
    // @Scheduled(cron = "0 0/1 * * * ?")
    @Scheduled(cron = "0 0/30 * * * ?")
    public void hnScheduled(){

        runner.ref();

    }


}
