package com.sxdl.sd.controller;

import cn.hutool.core.date.DateUtil;
import com.sxdl.sd.dao.dao1.Handle1Dao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class ReportControllerTest {

    @Autowired
    Handle1Dao handle1Dao;

    @Test
    public void test() {
        //'测试名称','2','387351'
        String tpinfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", "测试名称","2","387351");
        System.out.println(tpinfo);
    }
    @Test
    public void test11() {
        //'386509','2020-12-25 14:33','2','测试名称'
        List<Map<String,Object>> maps = handle1Dao.excuteProcedueWithTpLoad("ETL_LOAD_TEMPLATE", "386509","2020-12-25 14:33","2","测试名称");
        System.out.println(maps);
    }
    @Test
    public void test22(){
        int i = 3;
        switch(i){

            case 1:case 3:
                System.out.println("12121");
                break;
            case 2:
                System.out.println("2");
                break;
            case 0:
                System.out.println("0");
                break;
        }
    }
    @Autowired
    SdInfoController sdInfoController;

    @Test
    public void test33(){
        String updateTime = DateUtil.now();
        System.out.println(updateTime);
        System.out.println(sdInfoController.findByTpNames(2));

    }
}
