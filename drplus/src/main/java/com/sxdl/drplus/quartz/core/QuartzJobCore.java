package com.sxdl.drplus.quartz.core;

import com.sxdl.drplus.quartz.pojo.TaskDefine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by EalenXie on 2019/7/10 13:49.
 * 核心其实就是Scheduler的功能 , 这里只是非常简单的示例说明其功能
 * 如需根据自身业务进行扩展 请参考 {@link Scheduler}
 */

@Component
public class QuartzJobCore {

    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);



    //Quartz定时任务核心的功能实现类
    private final Scheduler scheduler;


    public QuartzJobCore(@Autowired SchedulerFactoryBean schedulerFactoryBean) {
        scheduler = schedulerFactoryBean.getScheduler();
    }

    /**
     * 创建  定时任务
     * {@link Scheduler#scheduleJob(JobDetail, Trigger)}
     *
     * @param define 定时任务
     */
    public void scheduleJob(TaskDefine define) throws SchedulerException {
        //1.定时任务 的 名字和组名
        JobKey jobKey = define.getJobKey();
        //2.定时任务 的 元数据
        JobDataMap jobDataMap = getJobDataMap(define.getJobDataMap());
        //3.定时任务 的 描述
        String description = define.getDescription();
        //4.定时任务 的 逻辑实现类
        Class<? extends Job> jobClass = define.getJobClass();
        //5.定时任务 的 cron表达式
        String cron = define.getCronExpression();
        JobDetail jobDetail = getJobDetail(jobKey, description, jobDataMap, jobClass);
        Trigger trigger = getTrigger(jobKey, description, jobDataMap, cron);
        scheduler.scheduleJob(jobDetail, trigger);

    }


    /**
     *      "NONE",    "不存在" ,"-1"
     *      "NORMAL",  "正常"  , "0"
     *      "PAUSED",  "暂停" ,  "1"
     *      "COMPLETE","完成" ,  "2"
     *      "ERROR",   "出错" ,  "3"
     *      "BLOCKED", "阻塞",   "4"
     *
     * @param jobKey
     * @return
     * @throws SchedulerException
     */
    public Integer getStarted(JobKey jobKey) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobKey.getName(), jobKey.getGroup());
        Trigger.TriggerState triggerState = scheduler.getTriggerState(triggerKey);
        switch (triggerState.name()){
            case "NONE" :
                return -1;
            case "NORMAL" :
                return 0;
            case "PAUSED" :
                return 1;
            default:
                return 2;
        }
    }

    public boolean checkExists(JobKey jobKey) throws SchedulerException {
        return  scheduler.checkExists(jobKey);
    }

    /**
     * 暂停Job
     * {@link Scheduler#pauseJob(JobKey)}
     */
    public void pauseJob(JobKey jobKey) throws SchedulerException {
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复Job
     * {@link Scheduler#resumeJob(JobKey)}
     */
    public void resumeJob(JobKey jobKey) throws SchedulerException {
        scheduler.resumeJob(jobKey);
    }

    /**
     * 删除Job
     * {@link Scheduler#deleteJob(JobKey)}
     */
    public void deleteJob(JobKey jobKey) throws SchedulerException {
        scheduler.deleteJob(jobKey);
    }


    /**
     * 修改Job 的cron表达式
     */
    public boolean modifyJobCron(TaskDefine define) {
        String cronExpression = define.getCronExpression();
        //1.如果cron表达式的格式不正确,则返回修改失败
        if (!CronExpression.isValidExpression(cronExpression)) return false;
        JobKey jobKey = define.getJobKey();
        TriggerKey triggerKey = new TriggerKey(jobKey.getName(), jobKey.getGroup());
        try {
            CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            JobDataMap jobDataMap = getJobDataMap(define.getJobDataMap());
            //2.如果cron发生变化了,则按新cron触发 进行重新启动定时任务
            if (!cronTrigger.getCronExpression().equalsIgnoreCase(cronExpression)) {
                CronTrigger trigger = TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey)
                        .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                        .usingJobData(jobDataMap)
                        .build();
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (SchedulerException e) {
            logger.error("修改Job 的cron表达式", e);
            return false;
        }
        return true;
    }


    /**
     * 获取定时任务的定义
     * JobDetail是任务的定义,Job是任务的执行逻辑
     *
     * @param jobKey      定时任务的名称 组名
     * @param description 定时任务的 描述
     * @param jobDataMap  定时任务的 元数据
     * @param jobClass    {@link Job} 定时任务的 真正执行逻辑定义类
     */
    public JobDetail getJobDetail(JobKey jobKey, String description, JobDataMap jobDataMap, Class<? extends Job> jobClass) {
        return JobBuilder.newJob(jobClass)
                .withIdentity(jobKey)
                .withDescription(description)
                .setJobData(jobDataMap)
                .usingJobData(jobDataMap)
                .requestRecovery()
                .storeDurably()
                .build();
    }


    /**
     * 获取Trigger (Job的触发器,执行规则)
     *
     * @param jobKey         定时任务的名称 组名
     * @param description    定时任务的 描述
     * @param jobDataMap     定时任务的 元数据
     * @param cronExpression 定时任务的 执行cron表达式
     */
    public Trigger getTrigger(JobKey jobKey, String description, JobDataMap jobDataMap, String cronExpression) {
        return TriggerBuilder.newTrigger()
                .withIdentity(jobKey.getName(), jobKey.getGroup())
                .withDescription(description)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .usingJobData(jobDataMap)
                .build();
    }


    public JobDataMap getJobDataMap(Map<?, ?> map) {
        return map == null ? new JobDataMap() : new JobDataMap(map);
    }


}
