package com.sxdl.product.dc.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.product.dc.Main;
import com.sxdl.product.dc.MainTest;
import com.sxdl.product.dc.entity.DcUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @version 1.0
 */


@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class DcLoginControllerTest extends MainTest {


    @Test
    public void login() throws Exception {
        DcUser dcUser = new DcUser ();
        dcUser.setName ( "admin" );
        dcUser.setPwd ( "888" );
        String result = mockMvc.perform ( MockMvcRequestBuilders.get ( "/login/login" ) //路径
                .content ( JSONUtil.toJsonStr ( dcUser ) )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )
                .andExpect ( OK ) //状态码200
                .andReturn ().getResponse ().getContentAsString ();
        System.err.println ( result );
        mockMvc.perform ( MockMvcRequestBuilders.get ( "/login/login" ) //路径
                .content ( JSONUtil.toJsonStr ( dcUser ) )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }


    @Test
    public void update() throws Exception {
        DcUser dcUser = new DcUser ();
        dcUser.setId ( 1 );
        dcUser.setName ( "admin" );
        dcUser.setPwd ( "123" );
        String result = mockMvc.perform ( MockMvcRequestBuilders.put ( "/login/update" ) //路径
                .content ( JSONUtil.toJsonStr ( dcUser ) )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )
                .andExpect ( OK ) //状态码200
                .andReturn ().getResponse ().getContentAsString ();
        System.err.println ( result );
    }

    @Test
    public void login2() throws Exception {
        DcUser dcUser = new DcUser ();
        dcUser.setName ( "admin" );
        mockMvc.perform ( MockMvcRequestBuilders.get ( "/login/userInfo" ) //路径
                .content ( JSONUtil.toJsonStr ( dcUser ) )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

}