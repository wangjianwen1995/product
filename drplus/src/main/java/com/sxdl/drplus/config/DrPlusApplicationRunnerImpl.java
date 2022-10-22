package com.sxdl.drplus.config;

import com.sxdl.base.dao.dao1.SysDictTableDao;
import com.sxdl.base.dao.dao1.SysDictValDao;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.drplus.dao1.DrPlusAreaZipDao;
import com.sxdl.drplus.dao1.SysScheduleTaskDao;
import com.sxdl.drplus.entity.DrPlusAreaZip;
import com.sxdl.drplus.entity.SysScheduleTaskEntity;
import com.sxdl.drplus.service.SysScheduleTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DrPlusApplicationRunnerImpl extends ApplicationRunnerImpl {
    //全局变量
    public volatile static Map<String, Object> contextMap = new ConcurrentHashMap<>();
    public static String PATH,FILESPATH;
    @Autowired
    private DrPlusAreaZipDao areaZipDao;


    @Autowired
    public SysDictValDao sysDictValDao;
    @Autowired
    public SysDictTableDao sysDictTableDao;

    @Autowired
    public SysScheduleTaskDao taskDao;
    @Autowired
    public ScheduleTaskConfig taskConfig;




    @Override
    public void run(ApplicationArguments args) throws Exception {

        init();
        List<DrPlusAreaZip> hpAreaZips = areaZipDao.selectAll();
        contextMap.put("areaZip", hpAreaZips);
        //开启定时任务功能
        // TaskInitialize()
    }


    /***
     * 调度任务初始化
     */
    public void TaskInitialize(){
        List<SysScheduleTaskEntity> sysScheduleTaskEntities = taskDao.select(new SysScheduleTaskEntity().setIsonable(1));
        taskConfig.refresh(sysScheduleTaskEntities);

    }

}
