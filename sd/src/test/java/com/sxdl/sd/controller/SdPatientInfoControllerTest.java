package com.sxdl.sd.controller;

import com.sxdl.sd.SdMainTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class SdPatientInfoControllerTest extends SdMainTest {

    @Test
    public void findAllSd() throws Exception {
        mockMvc.perform ( MockMvcRequestBuilders.get ( "/psi/findAllSd" )
                //.content ( JSONUtil.toJsonStr ( list ) )
                /*.param ( "pageNum", "1" )
                .param ( "pageSize", "2" )*/
                //.param ( "uid","37" )
                .param ( "uid","1" )
                //.param ( "flag","列表" )
                .param ( "flag","角标" )
                .param ( "gid","1" )
                //.param ( "sid","1" )
                //.param ( "status","2" )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }


    @Test
    public void test() throws Exception {
        mockMvc.perform ( MockMvcRequestBuilders.post ( "/report/report" )
                .param ( "sid","1" )
                .param ( "caseId","1330121801" )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }


}