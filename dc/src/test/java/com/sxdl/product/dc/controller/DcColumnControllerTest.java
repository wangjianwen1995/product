package com.sxdl.product.dc.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.product.dc.MainTest;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcColumn;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class DcColumnControllerTest extends MainTest {

    private DcColumn dcColumn;

    @Autowired
    private HandleDao handleDao;

    @Test
    public void findByTableId()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/column/findByTableId").param("tableid","1")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }

    @Test
    public void ttt()  throws  Exception{
        Integer integer = handleDao.countSum("CRB_Bbk");
        System.out.println(integer);



    }



    @Test
    public void findByTableIds()  throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/column/findByTableIds")
                .param("tableids", "1, 2, 3")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }


    @Test
    public void saveOne()  throws  Exception{
        dcColumn=new DcColumn();
        dcColumn.setTable_id("2");
        dcColumn.setTable_name("科室信息表");
        dcColumn.setColumn_name("code");
        dcColumn.setColumn_name_zh("代码");
        dcColumn.setType_id(1);
        dcColumn.setType("字符串");
        dcColumn.setSize(255);
        dcColumn.setScale(0);

        mockMvc.perform(MockMvcRequestBuilders.post("/column/save").content(JSONUtil.toJsonStr(dcColumn))//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }



    @Test
    public void updateColumn()  throws  Exception{
        dcColumn=new DcColumn();
        dcColumn.setId("1");
        dcColumn.setTable_id("1");
        dcColumn.setTable_name("职工信息表");
        dcColumn.setColumn_name("sex");
        dcColumn.setColumn_name_zh("性别改1");
        dcColumn.setType_id(1);
        dcColumn.setType("字符串");
        dcColumn.setSize(255);
        dcColumn.setScale(0);

        mockMvc.perform(MockMvcRequestBuilders.put("/column/update").content(JSONUtil.toJsonStr(dcColumn))//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }

    @Test
    public void deleteColumn()  throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/column/del")//路径
                .param("id", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }






}
