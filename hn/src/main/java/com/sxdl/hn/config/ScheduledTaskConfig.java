package com.sxdl.hn.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * 执行定时任务的线程池配置类
 */
@Configuration
public class ScheduledTaskConfig {

    private static final Logger LOGGER = LogManager.getLogger(ScheduledTaskConfig.class);

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        LOGGER.info("创建定时任务调度线程池 start");
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(20);
        threadPoolTaskScheduler.setThreadNamePrefix("taskExecutor-");
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
        threadPoolTaskScheduler.setRemoveOnCancelPolicy(true);
        LOGGER.info("创建定时任务调度线程池 end");
        return threadPoolTaskScheduler;
    }

   /* @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //允许上传的文件最大值

        factory.setMaxFileSize("102400KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }*/
}