package com.sxdl.report.controller;

import com.sxdl.report.DrMainTest;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Hashtable;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class DrProcdureControllerTest extends DrMainTest {

    @Test
    public void findAll()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/procdure/findAll")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }


    @Test
    public void findByTempId()  throws  Exception{

        Map<String,String> map  =new Hashtable<>();

        map.put("blh","1223");
        JSONObject jsonObject =  JSONObject.fromObject(map);
        System.out.println(jsonObject.toString());

    }
}
