package com.sxdl.fm.controller;

import com.sxdl.fm.FmMainTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Hui
 * @version 1.0
 */
public class IndexControllerTest extends FmMainTest {

    @Test
    public void zycytest() throws Exception{
        mockMvc.perform( MockMvcRequestBuilders.get("/indexData/zycy")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test
    public void findByTime() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.get("/indexData/findByTime")
                .param("sdate", "2020-10-01")
                .param("edate", "2020-11-02")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    public void findByFid1()throws Exception  {
        mockMvc.perform( MockMvcRequestBuilders.get("/indexData/findByFid1")
                .param("sDate", "2020-10-01")
                .param("eDate", "2020-11-02")
                .param("fid", "1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    public void findByFid()throws Exception  {
        mockMvc.perform( MockMvcRequestBuilders.get("/indexData/findByFid")
                .param("flag", "月")
                .param("fid", "1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    public void findByFid2()throws Exception  {
        mockMvc.perform( MockMvcRequestBuilders.get("/indexData/findByKs")
                .param("sDate", "2020-10-01")
                .param("eDate", "2020-11-02")
                .param("fid", "1")
                .param ( "ks","呼吸与危重症医学科" )
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
}