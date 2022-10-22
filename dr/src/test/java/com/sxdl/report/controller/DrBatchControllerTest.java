package com.sxdl.report.controller;

import com.sxdl.report.DrMainTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class DrBatchControllerTest extends DrMainTest {

    @Test
    public void findAll()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/batch/findAll")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }


    @Autowired
    private DrTableController drTableController;

    @Test
    public void findByTempId()  throws  Exception{



    }

}
