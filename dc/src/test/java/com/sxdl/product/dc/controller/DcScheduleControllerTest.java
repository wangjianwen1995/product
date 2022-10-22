package com.sxdl.product.dc.controller;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.product.dc.Main;
import com.sxdl.product.dc.MainTest;
import com.sxdl.product.dc.entity.DcSchedule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Hui
 * @version 1.0
 */

@SpringBootTest(classes = Main.class)
@WebAppConfiguration

public class DcScheduleControllerTest extends MainTest {

    @Test
    public void findAll() throws Exception {
        PageInfo pageInfo = new PageInfo ();
        pageInfo.setPageNum ( 1 );
        pageInfo.setPageSize ( 1 );
        mockMvc.perform ( MockMvcRequestBuilders.get ( "/schedule/findAll" ) //路径
                .content ( JSONUtil.toJsonStr ( pageInfo ) )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Test
    public void insert() throws Exception {
        DcSchedule dcSchedule = new DcSchedule ();
        dcSchedule.setName ( "测试任务3" );
        dcSchedule.setTime ( "2020/07/29" );
        dcSchedule.setValue ( "1221" );
        mockMvc.perform ( MockMvcRequestBuilders.post ( "/schedule/save" ) //路径
                .content ( JSONUtil.toJsonStr ( dcSchedule ) )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform ( MockMvcRequestBuilders.get ( "/schedule/getById/1" ) //路径
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Test
    public void update() throws Exception {
        DcSchedule dcSchedule = new DcSchedule ();
        dcSchedule.setId ( "1" );
        dcSchedule.setName ( "测试任务1" );
        dcSchedule.setTime ( "2020/07/31" );
        dcSchedule.setValue ( "888" );
        mockMvc.perform ( MockMvcRequestBuilders.put ( "/schedule/update" ) //路径
                .content ( JSONUtil.toJsonStr ( dcSchedule ) )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform ( MockMvcRequestBuilders.delete ( "/schedule/del/3" ) //路径
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Test
    public void updateRequestAPI() throws Exception {
        mockMvc.perform ( MockMvcRequestBuilders.put ( "/schedule/updateRequestAPI/1/0" ) //路径
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

   /* @Test
    public void updateRequestAPI1() throws Exception {
        DcRequestAPI dcRequestAPI = new DcRequestAPI();
        dcRequestAPI.setId (1 );
        dcRequestAPI.setSchedule_id ( 1 );
        mockMvc.perform ( MockMvcRequestBuilders.put ( "/schedule/updateRequestAPI1" ) //路径
                .content( JSONUtil.toJsonStr(dcRequestAPI))
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }*/

    @Test
    public void updateScheduleRequestAPI() throws Exception {

        mockMvc.perform ( MockMvcRequestBuilders.put ( "/schedule/updateScheduleRequestAPI/3/2" ) //路径
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Test
    public void updateScheduleStatus() throws Exception {

        mockMvc.perform ( MockMvcRequestBuilders.put ( "/schedule/updateScheduleStatus/8/0" ) //路径
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Test
    public void updateScheduleStatus1() throws Exception {

        mockMvc.perform ( MockMvcRequestBuilders.put ( "/schedule/updateScheduleStatus1/8/1" ) //路径
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }
}