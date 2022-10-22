package com.sxdl.product.dc.controller;

import com.sxdl.product.dc.MainTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class DcScheduleRuleControllerTest extends MainTest {

    @Test
    public void whenFindAllSucc() throws Exception {
        mockMvc.perform ( MockMvcRequestBuilders.get ( "/scheduleRule/findAll" ) //路径
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }
}