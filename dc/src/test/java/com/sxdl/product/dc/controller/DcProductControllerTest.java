package com.sxdl.product.dc.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.product.dc.MainTest;
import com.sxdl.product.dc.entity.DcProduct;
import com.sxdl.product.dc.service.DcProductService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class DcProductControllerTest extends MainTest {
    @Autowired
    private DcProductService dcProductService;

    @Disabled
    @Test
    public void selectAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/findAll")//
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect( OK)
                .andDo( print() );

    }

    @Disabled
    @Test
    public void findName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/findByName")  //路径
                .param("name","测试")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Disabled
    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/product/delete")//路径
                .param("id", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Disabled
    @Test
    public void insertProduct() throws Exception {
        DcProduct dcProduct  =new DcProduct();
        dcProduct.setName("测试");
        dcProduct.setShort_name("测试0001");
        mockMvc.perform(MockMvcRequestBuilders.post("/product/insert")//路径
                .content(JSONUtil.toJsonStr(dcProduct))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Disabled
    @Test
    public void updateProduct() throws Exception {
        DcProduct dcProduct  =dcProductService.findById(2);
        dcProduct.setName("测试2");
        dcProduct.setShort_name("测试0002");
        mockMvc.perform(MockMvcRequestBuilders.put("/product/update")//路径
                .content(JSONUtil.toJsonStr(dcProduct))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }
}
