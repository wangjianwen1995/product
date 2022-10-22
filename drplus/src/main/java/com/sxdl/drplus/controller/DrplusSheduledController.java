package com.sxdl.drplus.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.dto.AUTODBO;
import com.sxdl.drplus.dto.AUTOReportDBO;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.quartz.core.QuartzJobCore;
import com.sxdl.drplus.quartz.job.DeportJob;
import com.sxdl.drplus.quartz.job.DynamicJob;
import com.sxdl.drplus.quartz.pojo.TaskDefine;
import com.sxdl.drplus.service.DrPlusPlatformDetailedService;
import com.sxdl.drplus.util.DataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.CronExpression;
import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "自动调度维护")
@RestController
@RequestMapping("/sheduled")
public class DrplusSheduledController {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";
    @Autowired
    private DrPlusPlatformDetailedService sheduledService;
    @Resource
    private QuartzJobCore quartzJobCore;



    @ApiOperation(value = "查询调度任务")
    @GetMapping("/getSheduledData")
    public ResultUtil getSheduledData() {
        List<DrPlusPlatformDetailed> list = new ArrayList<>();
        try {
            list = sheduledService.getSheduledData();
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }


    @ApiOperation(value = "判断cron表达式是否合法")
    @GetMapping("/getSheduledCron")
    public ResultUtil getSheduledCron(String cron) {
        boolean validExpression=false;
        try {
            validExpression = CronExpression.isValidExpression(cron);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(validExpression);
    }




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
    @ApiOperation(value = "修改调度任务")
    @PostMapping("/upSheduledData")
    public ResultUtil upSheduledData(@RequestBody @Valid AUTODBO autodbo, BindingResult bindingResult) throws SchedulerException {
        //前端 数据需要
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            //修改平台数据,主要用于页面回显
            sheduledService.setSheduled(autodbo);
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
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }




    @ApiOperation(value = "修改调度上报任务 : 第二期作废, 上报合并到抽取里面")
    @PostMapping("/upSheduledReportData")
    @Deprecated
    public ResultUtil upSheduledReportData(@RequestBody @Valid AUTOReportDBO autodbo, BindingResult bindingResult) throws SchedulerException {
        //前端 数据需要
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            //修改平台数据,主要用于页面回显
            sheduledService.setSheduled2(autodbo);
            JobKey jobKey = JobKey.jobKey(autodbo.getName() , autodbo.getId().toString());
            if (1==autodbo.getIsopen2()){//调度页面是开启状态
                JobDataMap jobDataMap = getNewJobDataMap2(autodbo);
                TaskDefine task = new TaskDefine(jobKey,
                        autodbo.getName(),       //定时任务 的描述
                        autodbo.getCron2(),        //定时任务 的cron表达式
                        jobDataMap,
                        DeportJob.class //定时任务 的具体执行逻辑
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
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    private JobDataMap getNewJobDataMap(AUTODBO autodbo) {
        Map<String,Object> map = new HashMap<>();
        map.put("id", autodbo.getId());
        map.put("name",autodbo.getName());
        map.put("offset",autodbo.getOffset());
        map.put("e_days",autodbo.getE_days());
        map.put("cron",autodbo.getCron());
        map.put("is_autoextract",autodbo.getIs_autoextract());
        map.put("is_autocode",autodbo.getIs_autocode());
        map.put("is_autoreview",autodbo.getIs_autoreview());
        return new JobDataMap(map);
    }

    private JobDataMap getNewJobDataMap2(AUTOReportDBO autodbo) {
        Map<String,Object> map = new HashMap<>();
        map.put("id", autodbo.getId());
        map.put("name",autodbo.getName());
        map.put("offset2",autodbo.getOffset2());
        map.put("e_days2",autodbo.getE_days2());
        map.put("cron2",autodbo.getCron2());
        return new JobDataMap(map);
    }


}
