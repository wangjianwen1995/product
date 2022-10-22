package com.sxdl.fm.controller;

import com.sxdl.fm.FmMainTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class HbiFmDrgsControllerTest extends FmMainTest {

    @Test
    public void upload() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/drgs/upload")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());
    }
}