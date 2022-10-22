//package com.sxdl.product.dc.controller;
//
//import cn.hutool.json.JSONUtil;
//import com.github.pagehelper.PageInfo;
//import com.sxdl.product.dc.MainTest;
//import com.sxdl.product.dc.entity.DcDitVal;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//
//public class DcDitValControllerTest extends MainTest {
//
//    @Test
//    public void findByfactor() throws Exception {
//        PageInfo<DcDitVal> pageInfo = new PageInfo<DcDitVal> ();
//        pageInfo.setPageNum ( 1 );
//        pageInfo.setPageSize ( 2 );
//        System.out.println ( JSONUtil.toJsonStr ( pageInfo ) );
//        mockMvc.perform ( MockMvcRequestBuilders.get ( "/dv/findByFactor" )//路径
//                .param ( "pageNum", "1" )
//                .param ( "pageSize", "2" )
//                .param ( "dict_id", "1" )
//                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public void insertLink() throws Exception {
//        DcDitVal dcDitVal = new DcDitVal ();
//        dcDitVal.setDict_id ( 3 );
//        dcDitVal.setIs_on ( 1 );
//        dcDitVal.setName ( "测试" );
//        dcDitVal.setRemark ( "写实" );
//        mockMvc.perform ( MockMvcRequestBuilders.post ( "/dv/insert" ).content ( JSONUtil.toJsonStr ( dcDitVal ) )//路径
//                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public void updateLink() throws Exception {
//        DcDitVal dcDitVal = new DcDitVal ();
//        dcDitVal.setId ( 26 );
//        dcDitVal.setIs_on ( 0 );
//        mockMvc.perform(MockMvcRequestBuilders.put("/dv/update")//路径
//                .content(JSONUtil.toJsonStr(dcDitVal))
//                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
//                .andExpect(OK)//状态码200
//                .andDo(print());//结束后打印所有数据
//    }
//}