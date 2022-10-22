package com.sxdl.report.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.report.DrMainTest;
import com.sxdl.report.entity.DrColRule;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class DrColRuleControllerTest extends DrMainTest {

    private DrColRule colRule;

    @Test
    public void findByTableId()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/colrule/findByColumnId")
                .param("id","2")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }


    @Test
    public void save()  throws  Exception{

        colRule = new DrColRule();
        colRule.setName("CZYB");
        colRule.setColumn_id(2);
        colRule.setFormat("");
        colRule.setVal("");


        mockMvc.perform(MockMvcRequestBuilders.post("/colrule/save")
                .content(JSONUtil.toJsonStr(colRule))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    public void deleteColumn()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.delete("/colrule/delete")//路径
                .param("id","1")//.content(JSONUtil.toJsonStr(template))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }
}
