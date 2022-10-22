package com.sxdl.fm.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.fm.FmMainTest;
import com.sxdl.fm.entity.FmKhdy;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class FmKhdyTest  extends FmMainTest {
    @Test
    public void whenInserSucc() throws Exception{
        FmKhdy fmKhdy=new FmKhdy();
        fmKhdy.setName("111");
        fmKhdy.setIson(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/khdy/add")
                .content(JSONUtil.toJsonStr(fmKhdy))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
}
