package com.sxdl.report.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.sxdl.report.DrMainTest;
import com.sxdl.report.dao.dao1.HandleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class DrReturnControllerTest extends DrMainTest {

    @Autowired
    private HandleDao handle;

    @Test
    public void findAll()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/drReturn/findAll")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }


    @Test
    public void findByTempId()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/drReturn/findByCondition")
                .param("template_id","1")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    public void findByTempId1() {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            DateTime qwer= DateUtil.parse("2020-01-04 00:00:00");

            System.out.println(sdf.format(qwer));

            List<Map> sss = handle.selectAllTableData("select * from sss ");
            sss.forEach(e->{
                e.forEach((k,v)->{
                    System.out.print("k="+k+"和 v="+v+"   ");
                });
                System.out.println("");
                System.out.println("====================");
            });

        }catch (Exception e ){
            System.out.println(e.getMessage());
        }

    }

}
