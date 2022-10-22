package com.sxdl.product.dc.controller;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.product.dc.MainTest;
import com.sxdl.product.dc.entity.DcTable;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class DcTableControllerTest extends MainTest {

    private DcTable dcTable;




    @Test
    public void findAll()  throws  Exception{
        PageInfo<DcTable> pageInfo= new PageInfo<DcTable>();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(20);
        mockMvc.perform(MockMvcRequestBuilders.get("/table/findAll")//路径
                .content(JSONUtil.toJsonStr(pageInfo))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

     }



    @Test
    public void findByType()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/table/findByType")
                .param("type","1")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }




    @Test
    public void findByProductId()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/table/findByProductId").param("productId","1")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }


    @Test
    public void saveOneTable()  throws  Exception{
        dcTable = new DcTable();
        dcTable.setName("t_test");
        dcTable.setName_zh("中文名");
        dcTable.setType_id(1);
        dcTable.setIs_public(1);
        dcTable.setProduct_id("1");

        mockMvc.perform(MockMvcRequestBuilders.post("/table/save").content(JSONUtil.toJsonStr(dcTable))//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }



    @Test
    public void updateTable()  throws  Exception{
        dcTable = new DcTable();
        dcTable.setId("4");
        dcTable.setName("t_test");
        dcTable.setName_zh("中文名改");
        dcTable.setType_id(1);
        dcTable.setIs_public(1);
        dcTable.setProduct_id("1");

        mockMvc.perform(MockMvcRequestBuilders.put("/table/update")//路径
                .content(JSONUtil.toJsonStr(dcTable))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }

    @Test
    public void deleteTable()  throws  Exception{
        DcTable table =new DcTable();
        table.setId("4");

        mockMvc.perform(MockMvcRequestBuilders.delete("/table/del")//路径
                .content(JSONUtil.toJsonStr(table))
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }






}
