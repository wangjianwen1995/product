package com.sxdl.drplus.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.dao1.DrplusJbicdDao;
import com.sxdl.drplus.dao1.TestPojoDao;
import com.sxdl.drplus.entity.DrplusJbicd;
import com.sxdl.drplus.entity.TestPojo;
import com.sxdl.drplus.service.DrPlusPlatformDetailedService;
import com.sxdl.drplus.service.DrplusJbicdService;
import com.sxdl.drplus.service.SysScheduleTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
class DrPlusPlatformDetailedControllerTest   {

    @Autowired
    private DrPlusPlatformDetailedService detailedDao;

    @Autowired
    private DrplusJbicdService jbicdService;

    @Autowired
    private DrplusJbicdDao jbicdDao;

    @Autowired
    private TestPojoDao testPojoDao;



    @Autowired
    private  DrPlusTargetWarningController warningController;
    @Autowired
    private  DrPlusIndexController indexController;
    @Autowired
    private  SysScheduleTaskService taskService;
    public static ExecutorService executorService = Executors.newFixedThreadPool(100);
    @Test
    public void t2t() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            if(1>0){
                return "111";
            }else{
                return null;
            }
        });
        executorService.submit(futureTask);
        String s = futureTask.get();
        executorService.shutdown();
    }

    /**
     *  测试 guid 主键回显
     */
    @Test
    public void tt(){

        String insert = testPojoDao.getID("declare @tb_id table(ID uniqueidentifier)\n" +
                "insert into jobs(account,password)\n" +
                "OUTPUT INSERTED.id INTO @tb_id\n" +
                "values('Col1Value','Col2Value')\n" +
                "select ID from @tb_id ");
        System.out.println(insert);

    }


    /**
     * 测试 乐观锁
     */

    @Test
    public void tt2(){

        TestPojo testPojo = new TestPojo().setAccount("1").setPassword("乐观锁");
        int insert = testPojoDao.insert(testPojo);


        TestPojo test1 = testPojoDao.selectOne(new TestPojo().setPassword("乐观锁"));

        TestPojo test2 = testPojoDao.selectOne(new TestPojo().setPassword("乐观锁"));
        //模拟线程1
        TestPojo testPojo1 = test1.setPassword("线程1修改");


        //模拟线程2 先抢占到了资源

        TestPojo testPojo2 = test2.setPassword("线程2修改");


        int update = testPojoDao.updateByPrimaryKey(testPojo2);
        int update2 = testPojoDao.updateByPrimaryKey(testPojo1);




    }


    /**
     * 测试 乐观锁
     */

    @Test
    public void tt3(){
/*

        TestPojo testPojo = new TestPojo().setAccount("1").setPassword("乐观锁");
        int insert = testPojoDao.insert(testPojo);
*/

        TestPojo testPojo = testPojoDao.selectByPrimaryKey("F6910153-4707-ED11-86A6-34C93D1BB8F8");
        TestPojo testPojo1 = testPojo.setPassword("报错");
        int update = testPojoDao.updateByPrimaryKeySelective(testPojo1);


    }
}
