package com.sxdl.report.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.report.DrMainTest;
import com.sxdl.report.entity.DrTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class DrTemplateControllerTest extends DrMainTest {

    private DrTemplate template;



    @Test
    public void findAll()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/template/findAll")
//                .param("tableid","1")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    public void findById()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/template/findById")
                .param("id","1")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    public void save()  throws  Exception{

        template = new DrTemplate();
        //测试传id的时候是更新操作
        template.setId(3);
        template.setName("长治市医保上报");
        template.setShort_name("市医保上报");
        template.setDb_host("140.143.190.251");
        template.setDb_name("czbatj2005");
        template.setDb_user("sa");
        template.setDb_password("ckboar123!@#");
        template.setReport_source(1);
        template.setHost("http://10.55.255.11");
        template.setReport_url("http://10.55.255.11/sjcjpt/api/v1/settlementList/medicalRecordInfo");
        template.setObsolete_url("http://10.55.255.11/sjcjpt/api/v1/settlementList/medicalRecordInfo");
        template.setToken("7ea4c3b5479a069abc41b63ee62e82e3");
        template.setRequest_type("POST");
        template.setTimeout(3000);
        template.setCorn("0/2 * * * * ?");
        template.setEnd_time("2020-01-01");
        template.setEncode("utf-8");
        template.setBody_type("JSON");
        template.setReport_type("JSON");
        template.setPackage_type("JSON");
        template.setReport_type("JSON");
        template.setScope("1");
        template.setScope_unit("月");


        mockMvc.perform(MockMvcRequestBuilders.post("/template/save")
                .content(JSONUtil.toJsonStr(template))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }


    @Test
    public void deleteTemplate()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.delete("/template/delete")//路径
                .param("id","3")//.content(JSONUtil.toJsonStr(template))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }
}
