package com.sxdl.product.dc.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.product.dc.MainTest;
import com.sxdl.product.dc.entity.DcHospital;
import com.sxdl.product.dc.entity.DcJob;
import com.sxdl.product.dc.entity.DcProduct;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class DcJobControllerTest  extends MainTest {

    private DcProduct dcProduct;
    private DcHospital dcHospital;
    private DcJob dcJob;

    @Test
    public void fingAllJob()  throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/dcjob/findJobAll")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

     }



    @Test
    public void fingJobByName()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/dcjob/findJobByName").param("name","我")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }



    @Test
    public void findJobByOther()  throws  Exception{
        dcJob = new DcJob();
        dcJob.setName("我");
        mockMvc.perform(MockMvcRequestBuilders.get("/dcjob/findJobByOther").content(JSONUtil.toJsonStr(dcJob))//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }

    @Test
    public void findJobById()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/dcjob/findJobById")
                .param("id","1")

                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }

    @Test
    public void findById()  throws  Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/dcjob/findById").param("id","19F38C86-C063-4BB0-BAA5-6E87CA588590")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }

    @Test
    public void insertJob()  throws  Exception{
        dcJob = new DcJob();
        dcJob.setName("1");
        dcJob.setHospital_id("1");
        dcJob.setProduct_id("1");

        mockMvc.perform(MockMvcRequestBuilders.post("/dcjob/insetJob").content(JSONUtil.toJsonStr(dcJob))//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }



    @Test
    public void updateJob()  throws  Exception{
        dcJob = new DcJob();
        dcJob.setId("1");
        dcJob.setName("你猜猜我是谁");
        mockMvc.perform(MockMvcRequestBuilders.put("/dcjob/updateJob").content(JSONUtil.toJsonStr(dcJob))//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }

    @Test
    public void deleteJob()  throws  Exception{
        dcJob = new DcJob();
        dcJob.setId("1");
        dcJob.setName("你猜猜我是谁");
        mockMvc.perform(MockMvcRequestBuilders.delete("/dcjob/deleteJob").param("id","1")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }



    @Test
    public void findHospitalAll()  throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/dcjob/findHospitalAll")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }

    @Test
    public void findHospitalById()  throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/dcjob/findHospitalById").param("id","1")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }


    @Test
    public void insertHospital()  throws  Exception{

        DcHospital dcHospital  =new DcHospital();
        dcHospital.setName("肿瘤医院");
        dcHospital.setShort_name("大医院");
        mockMvc.perform(MockMvcRequestBuilders.post("/dcjob/insertHospital").content(JSONUtil.toJsonStr(dcHospital))//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }



    @Test
    public void updateHospital()  throws  Exception{
        DcHospital dcHospital  =new DcHospital();
        dcHospital.setId("1");
        dcHospital.setName("你猜猜我是谁");
        mockMvc.perform(MockMvcRequestBuilders.put("/dcjob/updateHospital").content(JSONUtil.toJsonStr(dcHospital))//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }



    @Test
    public void deleteHospital()  throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/dcjob/deleteHospital").param("id","1")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }




    @Test
    public void findProductAll()  throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/dcjob/findProductAll")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据


    }


    @Test
    public void insertProduct()  throws  Exception{

        DcProduct dcProduct = new DcProduct();
        dcProduct.setName("肿瘤医院项目");
        dcProduct.setShort_name("项目");
        mockMvc.perform(MockMvcRequestBuilders.post("/dcjob/insertProduct").content(JSONUtil.toJsonStr(dcProduct))//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }



    @Test
    public void updateProduct()  throws  Exception{
        DcProduct dcProduct = new DcProduct();
        dcProduct.setId("1");
        dcProduct.setName("肿瘤医院项目");
        dcProduct.setShort_name("项目");
        mockMvc.perform(MockMvcRequestBuilders.put("/dcjob/updateProduct").content(JSONUtil.toJsonStr(dcProduct))//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }





    @Test
    public void deleteProduct()  throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/dcjob/deleteProduct").param("id","2")//路径
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }





}
