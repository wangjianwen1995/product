//package com.sxdl.product.dc.controller;
//
//import cn.hutool.json.JSONUtil;
//import com.github.pagehelper.PageInfo;
//import com.sxdl.product.dc.MainTest;
//import com.sxdl.product.dc.dao.dao1.DcDitTableDao;
//import com.sxdl.product.dc.dao.dao2.HandleDao;
//import com.sxdl.product.dc.entity.DcApiType;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//public class DcApiTypeControllerTest extends MainTest {
//
//    @Autowired
//    private DcDitTableDao dcDitTableDao;
//    @Autowired
//    private HandleDao handleDao;
////    @Autowired
////    private DcApiTypeService dcApiTypeService;
//
//    @Disabled
//    @Test
//    public void whenSaveSucc() throws Exception {
//        DcApiType dat = new DcApiType();
//        dat.setId(1);
//        dat.setName("ttt");
//        dat.setXh(888);
//        String result = mockMvc.perform(MockMvcRequestBuilders.post("/apitype/add") //路径
//                .content(JSONUtil.toJsonStr(dat))
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(OK) //状态码200
//                .andReturn().getResponse().getContentAsString();
//        System.err.println(result);
//    }
//
//    @Disabled
//    @Test
//    public void whenQueryListSuccess() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/apitype/list") //路径
//                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
//                .andExpect(OK)//状态码200
//                .andDo(print());//结束后打印所有数据
//    }
//
//    @Disabled
//    @Test
//    public void whenUpdateSuccess() throws Exception {
//        DcApiType dat = new DcApiType();
//        dat.setId(1);
//        mockMvc.perform(MockMvcRequestBuilders.put("/apitype/update") //路径
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content("1"))
//                .andExpect(XXXX) //状态码200
//                .andDo(print());
////                .andReturn().getResponse().getContentAsString();
//    }
//
//    //    @Disabled
//    @Test
//    /*
//    测试连接多数据源数据库,连接并查询
//     */
//    public void whenQueryListFromDiffDBSucc() {
//        dcDitTableDao.selectAll().forEach(e -> System.out.println(e));
//        handleDao.selectAll().stream().forEach(e -> System.out.println(e));
//    }
//
//    @Disabled
//    @Test
//    public void whenDeleteSucc() throws Exception {
//        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/apitype/delete") //路径
//                .param("id", "1")
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(OK) //状态码200
//                .andReturn().getResponse().getContentAsString();
//        System.err.println(result);
//    }
//
//    //    @Disabled
//    @Test
//    public void whenDDLSUCC() throws Exception {
//        //测试执行建表语句
//        handleDao.excuteSql();
//    }
//
//    @Test
//    public void whenDDLWithParamsSUCC() throws Exception {
//        //测试执行带参数的建表语句
//        handleDao.excuteSqlWithParams("bbb", "name nvarchar (255)");
//    }
//
//    @Test
//    public void whenExcuteProcedueFromOtherDBSucc() throws Exception {
//        //测试执行调用其他数据库中的存储过程
////        System.out.println(handleDao.excuteCallProcedueWithParams("test","testtest"));
//        //执行失败，本地dao绑定的是DC，无权限访问
//    }
//
//    @Test
//    public void whenFindListSucc() throws Exception {
//        DcApiType dat = new DcApiType();
//        dat.setName("1");
//        PageInfo<DcApiType> pageInfo=new PageInfo<>();
//        pageInfo.setPages(0);
//        pageInfo.setPageSize(10);
//        mockMvc.perform(MockMvcRequestBuilders.get("/apitype/ls") //路径
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(JSONUtil.toJsonStr(pageInfo)))
//                .andExpect(OK) //状态码200
//                .andDo(print());
//    }
//
//    @Test
//    public void whenExcuteSQLwithSQL() throws Exception{
//        String link="\r\n";
////        String sql1="IF OBJECT_ID(N'aaa', N'U') IS  NOT  NULL DROP TABLE aaa CREATE TABLE dbo.aaa( id int IDENTITY(1,1) NOT NULL,name nvarchar(255), PRIMARY KEY (id))";
//        String sql="CREATE TABLE ttt ( id INT IDENTITY(1,1)   NOT NULL,\r\n" +
//                "code VARCHAR(10),\r\n" +
//                "NAME varchar(10),\r\n" +
//                ")";
//        String sql2="INSERT INTO ttt (code,NAME) VALUES('11','你好'),"+link+"('22','他好'),"+link+"('33','我也好')";
//        handleDao.excuteSqlWithSQL(sql);
//    }
//
//}