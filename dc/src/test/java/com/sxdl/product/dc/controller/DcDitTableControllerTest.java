//package com.sxdl.product.dc.controller;
//
//import cn.hutool.json.JSONUtil;
//import com.sxdl.product.dc.MainTest;
//import com.sxdl.product.dc.entity.DcDitTable;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//public class DcDitTableControllerTest extends MainTest {
//
//    @Test
//    public void findAll() throws Exception {
//        mockMvc.perform ( MockMvcRequestBuilders.get ( "/dt/findAll" )//路径
//                /*.param ( "pageNum", "3" )
//                .param ( "pageSize", "2" )*/
//                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public void findByfactor() throws Exception {
//        mockMvc.perform ( MockMvcRequestBuilders.get ( "/dt/findByFactor" )//路径
//                .param ( "name_zh", "字段" )
//                .param ( "name", "" )
//                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public void insertDT() throws Exception {
//        DcDitTable dcDitTable = new DcDitTable ();
//        dcDitTable.setSource_id ( 2 );
//        dcDitTable.setName ( "dc_ceshi2" );
//        dcDitTable.setName_zh ( "测试2" );
//        dcDitTable.setSource_content ( "写实2" );
//        dcDitTable.setSource_name ( "官方" );
//        mockMvc.perform ( MockMvcRequestBuilders.post ( "/dt/insert" ).content ( JSONUtil.toJsonStr ( dcDitTable ) )//路径
//                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public void updateDT() throws Exception {
//        DcDitTable dcDitTable = new DcDitTable ();
//        dcDitTable.setId ( 6 );
//        dcDitTable.setName ( "relation_replace_type" );
//        mockMvc.perform(MockMvcRequestBuilders.put("/dt/update")//路径
//                .content(JSONUtil.toJsonStr(dcDitTable))
//                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
//                .andExpect(OK)//状态码200
//                .andDo(print());//结束后打印所有数据
//    }
//
//
//
//
//
//
//}