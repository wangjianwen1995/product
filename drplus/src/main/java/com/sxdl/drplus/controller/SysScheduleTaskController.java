package com.sxdl.drplus.controller;



import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.config.ScheduleTaskConfig;
import com.sxdl.drplus.entity.SysScheduleTaskEntity;
import com.sxdl.drplus.service.SysScheduleTaskService;
import com.sxdl.drplus.util.DataUtil;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Api(tags = "移植表单模块" )
@RestController
@RequestMapping("/sys/scheduleTask")
@RequiredArgsConstructor
public class SysScheduleTaskController {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";

    private final SysScheduleTaskService taskService;

    private final ScheduleTaskConfig taskConfig;


    /// key 这里的值取的是 drplus_center_table_data7a
    @GetMapping("/save1")
    public ResultUtil<Map<String, String>> save1() {

        try {
            taskService.insert(new SysScheduleTaskEntity().setName("任务1").setCron("0/30 * * * * ?").setIsonable(1).setPid("1"));
            taskRefresh();
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error( DataUtil.ERROR_MASSAGE);

        }

        return ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }

    public void taskRefresh() {
        taskConfig.refresh(taskService.select(new SysScheduleTaskEntity().setIsonable(1)));
    }

    @GetMapping("/save2")
    public ResultUtil<Map<String, String>> save2() {

        try {
            taskService.insert(new SysScheduleTaskEntity().setName("任务2").setCron("0 */1 * * * ?").setIsonable(1).setPid("2"));
            taskRefresh();
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error( DataUtil.ERROR_MASSAGE);

        }

        return ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }



    @GetMapping("/save3")
    public ResultUtil<Map<String, String>> save3() {

        try {
            taskService.insert(new SysScheduleTaskEntity().setName("任务3").setCron("0 */1 * * * ?").setIsonable(1).setPid("3"));
            taskRefresh();
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error( DataUtil.ERROR_MASSAGE);

        }

        return ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }

    @GetMapping("/del1")
    public ResultUtil<Map<String, String>> del1() {
        try {
            taskService.delete(new SysScheduleTaskEntity().setName("任务1") );
            taskRefresh();
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error( DataUtil.ERROR_MASSAGE);

        }

        return ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }

    @GetMapping("/del2")
    public ResultUtil<Map<String, String>> del2() {
        try {
            taskService.delete(new SysScheduleTaskEntity().setName("任务2") );
            taskRefresh();
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error( DataUtil.ERROR_MASSAGE);

        }

        return ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }

    @GetMapping("/del3")
    public ResultUtil<Map<String, String>> del3() {
        try {
            taskService.delete(new SysScheduleTaskEntity().setName("任务3") );
            taskRefresh();
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error( DataUtil.ERROR_MASSAGE);

        }

        return ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }

    @GetMapping("/ssss")
    public ResultUtil<Map<String, String>> ssss() throws InterruptedException {
        int i= 1/ 0;
        TimeUnit.SECONDS.sleep(30);
        return ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }

}
