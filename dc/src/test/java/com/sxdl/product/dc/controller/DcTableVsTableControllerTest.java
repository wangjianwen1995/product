package com.sxdl.product.dc.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.product.dc.MainTest;
import com.sxdl.product.dc.entity.DcTableVsTable;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class DcTableVsTableControllerTest extends MainTest {

    private DcTableVsTable dcTableVsTable;

    @Test
    public void findAll()  throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/tableVsTable/findAll")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

     }


    @Test
    public void saveOne()  throws  Exception{
        dcTableVsTable = new DcTableVsTable();
        dcTableVsTable.setFrom_table_id("1");
        dcTableVsTable.setFrom_table_column_id("1");
        dcTableVsTable.setTo_table_id("1");
        dcTableVsTable.setTo_table_column_id("1");

        mockMvc.perform(MockMvcRequestBuilders.post("/tableVsTable/save")//路径
                .content(JSONUtil.toJsonStr(dcTableVsTable))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }

    @Test
    public void update()  throws  Exception{
        dcTableVsTable = new DcTableVsTable();
        dcTableVsTable.setId("1");
        dcTableVsTable.setFrom_table_id("1");
        dcTableVsTable.setFrom_table_column_id("1");
        dcTableVsTable.setTo_table_id("2");
        dcTableVsTable.setTo_table_column_id("2");

        mockMvc.perform(MockMvcRequestBuilders.put("/tableVsTable/update")//路径
                .content(JSONUtil.toJsonStr(dcTableVsTable))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }
}
