package com.sxdl.base.config;

import cn.hutool.core.util.StrUtil;
import com.sxdl.base.entity.SchedulEntity;
import com.sxdl.base.service.ServiceDiskService;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.ReportUtil;
import com.sxdl.base.util.YmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.text.ParseException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 全局调度任务,配置了默认20个的调度线程池,防止调度任务时间漂移
 */
@Configuration
@EnableScheduling
@EnableAsync
public class SchedulConfig implements SchedulingConfigurer {

    @Autowired
    ServiceDiskService serviceDiskService;
    @Autowired
    ReportUtil reportUtil;
    @Autowired
    YmlUtil ymlUtil;
    private Executor executor;

    public void run(SchedulEntity se) {
        if (null == se || null == se.getIsSys()) {
            return;
        }
        if (se.getIsSys() == 1) {
            String info = se.getInfo();
            switch (info) {
                case "常规备份":
                    try {
                        if(StrUtil.isEmpty(PrefixConfig.PREFIX)){//没有合并库的项目,自己备份自己的
                            serviceDiskService.backUp();
                        }else{//合并库的项目统一由dc备份
                           String port= ymlUtil.getYmlValue("server.port");
                           if("23300".equals(port)){
                               serviceDiskService.backUp();
                           }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "常规清理":
                    try {
                        serviceDiskService.clearUpAllLogs();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "获取hbi令牌":
                    try {
                        if (reportUtil.addrIsOpen()) {
                            String token = reportUtil.getHbiToken();
                            ApplicationRunnerImpl.contextMap.put("hbitoken", token);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    //手动注册定时任务处理器
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    //简单初始化20个空位线程池,简单单例
    @Qualifier("taskExecutor")
    protected Executor taskExecutor() {
        if (null == executor) {
            executor = Executors.newScheduledThreadPool(10);
        }
        return executor;
    }

    /**
     * 每天早上03点,常规备份
     */
    @Scheduled(cron = "0 0 3 * * ?")
//    @Scheduled(cron = "*/5 * * * * ?")
    public void dailybackup() {
        run(new SchedulEntity(1,"常规备份"));
    }

    //每2小时获取令牌
    @Scheduled(cron = "0 0 0/2 * * ?")
    public void getHBIToken() {
        run(new SchedulEntity(1,"获取hbi令牌"));
    }

    /**
     * 每月3日早上04点,常规清理全库日志文件
     */
    @Scheduled(cron = "0 0 3 3 * ?")
    public void clearAllLogs() {
        run(new SchedulEntity(1,"常规清理"));
    }
}
