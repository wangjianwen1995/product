package com.sxdl.report.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.report.DrMainTest;
import com.sxdl.report.entity.DrColumn;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class DrColumnControllerTest extends DrMainTest {

    private DrColumn column;

    @Test
    public void findByTableId()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/column/findByTableId")
                .param("id","2")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }


    @Test
    public void save()  throws  Exception{

        column = new DrColumn();
        column.setName("CZYB");
        column.setName_zh("长治医保上报表");
        column.setTable_id(2);
        column.setColumn_type(1);
        column.setScale(2);
        column.setSize(20);

        mockMvc.perform(MockMvcRequestBuilders.post("/column/save")
                .content(JSONUtil.toJsonStr(column))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    public void deleteColumn()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.delete("/column/delete")//路径
                .param("id","1")//.content(JSONUtil.toJsonStr(template))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }
}
