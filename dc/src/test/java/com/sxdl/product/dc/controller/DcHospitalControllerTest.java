package com.sxdl.product.dc.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.product.dc.MainTest;
import com.sxdl.product.dc.entity.DcHospital;
import com.sxdl.product.dc.service.DcHospitalService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class DcHospitalControllerTest  extends MainTest {
    @Autowired
    private DcHospitalService dcHospitalService;

    @Test
    public void findByAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hospital/findAll")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Disabled
    @Test
    public void findByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hospital/findByName")//路径
                .param("name", "合聚")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }
    @Disabled
    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/hospital/delete")//路径
                .param("id", "3")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }
    @Disabled
    @Test
    public void insert() throws Exception {
        DcHospital dcHospital  =new DcHospital();
        dcHospital.setName("测试");
        dcHospital.setShort_name("测试0001");
        mockMvc.perform(MockMvcRequestBuilders.post("/hospital/insert")//路径
                .content(JSONUtil.toJsonStr(dcHospital))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }
    @Disabled
    @Test
    public void update() throws Exception {
        DcHospital dcHospital  =dcHospitalService.findById(3);
        dcHospital.setName("测试2");
        dcHospital.setShort_name("测试0002");
        mockMvc.perform(MockMvcRequestBuilders.put("/hospital/update")//路径
                .content(JSONUtil.toJsonStr(dcHospital))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }


}
