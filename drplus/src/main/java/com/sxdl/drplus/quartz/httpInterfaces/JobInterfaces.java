package com.sxdl.drplus.quartz.httpInterfaces;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.dto.AUTODBO;
import com.sxdl.drplus.quartz.core.QuartzJobCore;
import com.sxdl.drplus.quartz.job.DynamicJob;
import com.sxdl.drplus.quartz.pojo.TaskDefine;
import com.sxdl.drplus.service.DrPlusPlatformDetailedService;
import com.sxdl.drplus.util.DataUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
public class JobInterfaces {
    public static final String LineBreak = "\r\n";

    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Resource
    private QuartzJobCore quartzJobCore;

    @Autowired
    private DrPlusPlatformDetailedService detailedService;

    /**
     * 通过jobKey 来定位任务 ,一个任务(jobKey)只能同事开启一次
     *
     *  key : 前端数据需要
     *     pid->平台id
     *     offset->偏移量(开始结束时间整体向前 推动几天)
     *     e_days->抽取天数
     *     cron->调度表达式
     *     isopen->是否开启
     */
    @PostMapping("/startRun")
    public ResultUtil startHelloWorldJob(@RequestBody @Valid AUTODBO autodbo, BindingResult bindingResult) throws SchedulerException {
        //前端 数据需要
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            //修改平台数据,主要用于页面回显
            detailedService.setSheduled(autodbo);
            JobKey jobKey = JobKey.jobKey(autodbo.getName(), autodbo.getId().toString());
            if (1==autodbo.getIsopen()){//调度页面是开启状态
                JobDataMap jobDataMap = getNewJobDataMap(autodbo);
                TaskDefine task = new TaskDefine(jobKey,
                        autodbo.getName(),       //定时任务 的描述
                        autodbo.getCron(),        //定时任务 的cron表达式
                        jobDataMap,
                        DynamicJob.class //定时任务 的具体执行逻辑
                );

                if(!quartzJobCore.checkExists(jobKey)){//定时任务不存在, 创建
                    quartzJobCore.scheduleJob(task);
                }else {//存在就修改任务
                    quartzJobCore.modifyJobCron(task);
                }
            }else {
                if(quartzJobCore.checkExists(jobKey)){//定时任务不存在, 创建
                    quartzJobCore.deleteJob(jobKey);
                }
            }



        }catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    @GetMapping("/delete2")
    public String deleteHelloWorldJob2() throws SchedulerException {
        JobKey jobKey2 = JobKey.jobKey("HelloWorld2", "GroupOne2");
        quartzJobCore.deleteJob(jobKey2);
        return "delete HelloWorld Job success";
    }


    /**
     *      "NONE",    "不存在" ,"-1"
     *      "NORMAL",  "正常"  , "0"
     *      "PAUSED",  "暂停" ,  "1"
     *      "COMPLETE","其他" ,  "2"
     *
     *
     * @return
     * @throws SchedulerException
     */
    @GetMapping("/delete3")
    public String deleteHelloWorldJob3() throws SchedulerException {
        JobKey jobKey2 = JobKey.jobKey("HelloWorld2", "GroupOne2");
        Integer started = quartzJobCore.getStarted(jobKey2);
        System.out.println(started);
        return "delete HelloWorld Job success";
    }


    private JobDataMap getNewJobDataMap(AUTODBO autodbo) {
        Map<String,Object> map = new HashMap<>();
        map.put("id", autodbo.getId());
        map.put("pname",autodbo.getName());
        map.put("offset",autodbo.getOffset());
        map.put("e_days",autodbo.getE_days());
        map.put("cron",autodbo.getCron());
        map.put("isopen",autodbo.getIsopen());
        return new JobDataMap(map);
    }

    @GetMapping("/start2")
    public String startHelloWorldJob2() throws SchedulerException {
        JobKey jobKey2 = JobKey.jobKey("HelloWorld2", "GroupOne2");
        //创建一个定时任务
        Map<String,String> map = new HashMap<>();
        map.put("pid","1");
        map.put("pname","某某平台名称");
        map.put("offset","7");
        map.put("e_days","30");
        map.put("cron","0/10 * * * * ?");
        map.put("isopen","1");
        JobDataMap jobDataMap = new JobDataMap(map);
        TaskDefine task = new TaskDefine(jobKey2,
                "这是一个测试的 任务",       //定时任务 的描述
                "0/2 * * * * ? ",           //定时任务 的cron表达式
                jobDataMap,
                DynamicJob.class //定时任务 的具体执行逻辑
        );
        quartzJobCore.scheduleJob(task);
        return "start HelloWorld Job success";
    }



    /**
     * 暂停 hello world
     */
    @GetMapping("/pause")
    public String pauseHelloWorldJob() throws SchedulerException {
        JobKey jobKey = JobKey.jobKey("HelloWorld2", "GroupOne2");
        quartzJobCore.pauseJob(jobKey);
        return "pause HelloWorld Job success";
    }


    /**
     * 恢复 hello world
     */
    @GetMapping("/resume")
    public String resumeHelloWorldJob() throws SchedulerException {
        JobKey jobKey = JobKey.jobKey("HelloWorld2", "GroupOne2");
        quartzJobCore.resumeJob(jobKey);
        return "resume HelloWorld Job success";
    }

    /**
     * 删除 hello world
     */
    @GetMapping("/delete")
    public String deleteHelloWorldJob() throws SchedulerException {
        JobKey jobKey = JobKey.jobKey("HelloWorld", "GroupOne");
        quartzJobCore.deleteJob(jobKey);
        return "delete HelloWorld Job success";
    }

    /**
     * 修改 hello world 的cron表达式
     */
    @GetMapping("/modifyCron")
    public String modifyHelloWorldJobCron() {
        Map<String,String> map = new HashMap<>();
        map.put("pid","1");
        map.put("pname","某某平台名称");
        map.put("offset","7");
        map.put("e_days","30");
        map.put("cron","0/10 * * * * ?");
        map.put("isopen","1");
        JobDataMap jobDataMap = new JobDataMap(map);
        JobKey jobKey = JobKey.jobKey("HelloWorld2", "GroupOne2");
        //这是即将要修改cron的定时任务
        TaskDefine task = new TaskDefine(jobKey,
                "这是一个测试的 任务",  //定时任务 的描述
                "0/5 * * * * ? ", //定时任务 的cron表达式
                jobDataMap,
                DynamicJob.class //定时任务 的具体执行逻辑
        );
        if (quartzJobCore.modifyJobCron(task))
            return "modify HelloWorld Job Cron success";
        else return "modify HelloWorld Job Cron fail";
    }


}
