package com.sxdl.fm.controller;


import com.sxdl.fm.FmMainTest;
import com.sxdl.fm.util.app.FmSingle;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class AppControllerTest extends FmMainTest {
    @Test//用户登录
    public void testLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sysUser/loginApp")
                .param("pwd", "123")//路径
                .param("name", "梁勇")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test//普通用户查询首页数据
    public void testGetMyInfoYs() throws Exception {//医生查询我的信息，手机端首页
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getMyInfo")
                .param("time", "2020-10-10;2020-10-14")//路径
                .param("name", "乔爱萍")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test//领导用户查询首页数据
    public void testGetMyInfoLD() throws Exception {//领导查询我的信息，手机端首页
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getMyInfo")
                .param("time", "2020-10-13;2020-10-14")//路径
                .param("name", "梁 勇")
                .param("ks", "院领导")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//领导用户查询首页数据
    public void testGetMyInfoLD2() throws Exception {//领导查询我的信息，手机端首页
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getMyInfo")
                .param("time", "2021-01-3;2021-01-04")//路径
                .param("name", "梁 勇")
                .param("ks", "院领导")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//普通用户查询自己参与的科室工作量情况
    public void testgetChildSelectKs() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getChildSelect")
                .param("time", "2020-10-01;2020-10-30")//路径
                .param("name", "乔爱萍")
                .param("type", "1")
                .param("isAll", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test//普通用户查询自己参与的考核单元工作量情况
    public void testgetChildSelectKh() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getChildSelect")
                .param("time", "2020-10-01;2020-10-30")//路径
                .param("name", "乔爱萍")
                .param("type", "1")
                .param("isAll", "3")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//普通用户查询全院数据自己的情况
    public void testgetSomeOneYs1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getSomeOne")
                .param("time", "2020-10-01;2020-10-30")//路径
                .param("name", "乔爱萍")
                .param("type", "1")
                .param("ks", "医保科")
                .param("isAll", "1")
                .param("khdy", "")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test//普通用户查询科室数据,自己的请款
    public void testgetSomeOneYs2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getSomeOne")
                .param("time", "2020-10-01;2020-10-30")//路径
                .param("name", "乔爱萍")
                .param("type", "1")
                .param("ks", "医保科")
                .param("isAll", "2")
                .param("khdy", "")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test//普通用户查询考核单元数据,自己的情况
    public void testgetSomeOneYs3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getSomeOne")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "超声科门诊")
                .param("isAll", "3")
                .param("khdy", "医务科")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test//领导用户查询全院的数据,默认科室情况
    public void testgetSomeOneLD1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getSomeOne")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "院领导")
                .param("isAll", "1")
                .param("khdy", "")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test//领导用户查询全院的数据,考核单元情况
    public void testgetSomeOneLD3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getSomeOne")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "院领导")
                .param("isAll", "3")
                .param("khdy", "")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//领导用户查询全院的数据,科室情况
    public void testfindTopLD1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/findTop")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "院领导")
                .param("isAll", "1")
                .param("khdy", "")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//领导用户查询全院的数据,科室情况
    public void testfindTopLD3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/findTop")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "院领导")
                .param("isAll", "3")
                .param("khdy", "")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//普通用户查询全院的数据
    public void testfindTopYS1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/findTop")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "超声科门诊")
                .param("isAll", "1")
                .param("khdy", "")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//普通用户查询某个科室的数据
    public void testfindTopYS2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/findTop")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "超声科门诊")
                .param("isAll", "2")
                .param("khdy", "")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//普通用户查询某个考核单元的数据
    public void testfindTopYS3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/findTop")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "超声科门诊")
                .param("isAll", "3")
                .param("khdy", "医务科")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//领导用户查询某个科室的医生数据
    public void testgetDetailLD2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getDetail")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "院领导")
                .param("isAll", "2")
                .param("queryKs", "妇科")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test//领导用户查询某个考核单元的医生数据
    public void testgetDetailLD3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getDetail")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "院领导")
                .param("isAll", "3")
                .param("queryKh", "医务科")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//医生用户查询某个医生的病人数据
    public void testgetDetailYS1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getDetail")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "超声科门诊")
                .param("isAll", "1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//医生用户查询包含自己工作量科室中的某个医生的病人数据
    public void testgetDetailYS2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getDetail")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "超声科门诊")
                .param("isAll", "2")
                .param("queryKs", "超声科门诊")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test//医生用户查询包含自己工作量考核单元中的某个医生的病人数据
    public void testgetDetailYS3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getDetail")
                .param("time", "2020-11-13;2020-11-14")//路径
                .param("name", "梁 勇")
                .param("type", "1")
                .param("ks", "超声科门诊")
                .param("isAll", "3")
                .param("queryKh", "医务科")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
    @Test
    public void testGetReport() throws Exception {
        //GUID=c5e817df-9c55-4fec-8e42-1ea9719cdeed&uid=1
        mockMvc.perform(MockMvcRequestBuilders.get("/app/getReportDataForApp")
                .param("GUID", "c5e817df-9c55-4fec-8e42-1ea9719cdeed")//路径
                .param("uid", "1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    public void tt() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/app/ttt")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    public void tCompare() throws Exception {
        FmSingle f = new FmSingle("1", "2", "3", "0");
        System.out.println(f.compareTo(new FmSingle("0")));
    }

}