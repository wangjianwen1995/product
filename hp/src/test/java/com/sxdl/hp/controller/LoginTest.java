package com.sxdl.hp.controller;

import cn.hutool.http.ContentType;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sxdl.base.util.verify.VerifyUtil;
import com.sxdl.hp.HpMainTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.File;
import java.io.FileInputStream;

public class LoginTest extends HpMainTest {
    @Test
    public void testLogin() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/linking/getToken")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse();
        response.setCharacterEncoding("utf8");
        System.out.println(response.getContentAsString());
        JSONObject j=JSONUtil.parseObj(response.getContentAsString());
        if(!"success".equals(j.getStr("state"))){
            return;
        }
        j= j.getJSONObject("t");

        response= mockMvc.perform ( MockMvcRequestBuilders.get ( "/linking/islogin" )//路径
                .header(j.getStr("tokenName"),j.getStr("tokenValue"))
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) ).andReturn().getResponse();
        response.setCharacterEncoding("utf8");
        System.out.println(response.getContentAsString());
    }
    @Test
    public void testFileUpload() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/verify/upload").
                file(new MockMultipartFile("file", "longlicenses.lisp", ContentType.TEXT_PLAIN.toString(), new FileInputStream(new File("D:\\longlicenses.lisp")))));
        MvcResult mvcResult = resultActions.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        mvcResult.getResponse().setCharacterEncoding("utf8");
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");
    }
    @Test
    public void testGeneratorJiami(){
        System.out.println(VerifyUtil.generatVerify());
    }

}
