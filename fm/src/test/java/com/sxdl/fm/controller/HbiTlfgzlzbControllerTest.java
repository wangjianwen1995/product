package com.sxdl.fm.controller;

import com.sxdl.fm.FmMainTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class HbiTlfgzlzbControllerTest  extends FmMainTest {

    @Test
    public void whenInserSucc() throws Exception{

        mockMvc.perform( MockMvcRequestBuilders.post("/hbiTlfgzlzb/saveHistory")
                .param("sdate", "2020-10-01")
                .param("edate", "2020-11-02")
                .contentType( MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
}