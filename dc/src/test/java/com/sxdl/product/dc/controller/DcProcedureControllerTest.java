//package com.sxdl.product.dc.controller;
//
//import com.sxdl.product.dc.MainTest;
//import com.sxdl.product.dc.dao.dao2.HandleDao;
//import com.sxdl.product.dc.service.DcProcedureService;
//import com.sxdl.product.dc.util.DirectLinkLibraryUtil;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//
//public class DcProcedureControllerTest extends MainTest {
//    @Autowired
//    private HandleDao handleDao;
//
//@Test
//public void testCall(){
//    try {
//        String dcCreateTableType = handleDao.excuteCallProcedue("DcCreateTableType");
//        System.out.println(dcCreateTableType);
//    }catch (Exception e){
//        System.out.println(e.getCause());
//    }
//}
//
//    @Test
//    public void test(){
//        String tableColumssql = DirectLinkLibraryUtil.getTableColums("his", "batj2005", "EL_Log");
//        String tableColums = handleDao.execSelectSql(tableColumssql);
//        String columsAndType = DirectLinkLibraryUtil.getColumsAndType("his", "batj2005", "EL_Log");
//        String selectColumns = handleDao.execSelectSql(columsAndType);
//        String sqlProcText =  DirectLinkLibraryUtil.getProc("his", "batj2005","EETTLL", "EL_Log",tableColums,selectColumns);
//
//        System.out.println(sqlProcText);
//
//    }
//
//
//    @Test
//    public void test2(){
//        String aa = "dc_job";
//        //List columsql = handleDao.execSelectSql("select stuff((SELECT ','+ convert(varchar(50),name)    FROM SYSCOLUMNS WHERE ID=OBJECT_ID('"+aa+"' ) for xml path('')),1,1,'')");
//        String columsql = handleDao.execSelectSql("SELECT convert(varchar(50),name) FROM SYSCOLUMNS WHERE ID=OBJECT_ID('dc_job' )");
//
//        System.out.println(columsql);
//    }
//
//
//    @Test
//    public void tset3(){
//        List<String> lis = Arrays.asList("id,code,name,type".split(","));
//        System.out.println(lis);
//    }
//
//
//    /**
//     *
//     * 测试按钮 动态创建存储过程 √√√√√通过
//     */
//
//
//
//
//    @Autowired
//    private DcProcedureService dcProcedureService;
//    /**
//     * 抽取历史数据
//     */
//
//
//    @Test
//    public void ttt(){
//        String str="DECLARE @sql VARCHAR(1000)  " +
//                "SET @sql='select * into ttttt from his.sxdl.dbo.dc_job where 1=2  " +
//                " select stuff((SELECT '',''+ convert(varchar(50),name)    FROM SYSCOLUMNS WHERE ID=OBJECT_ID(''temp'' ) for xml path('''')),1,1,'''')' EXEC (@sql)";
//        String s = handleDao.execSelectSql(str);
//        System.out.println(s);
//
//    }
//
//
//    /**
//     * 根据表名称，后去表中的所有字段
//     */
//    @Test
//    public void   getOneTableOfColumns(){
//        String id = handleDao.getOneTableOfColumns("ETL_TDoctor_Info");
//        List<String> list = Arrays.asList(id.split(","));
//        System.out.println(list);
//    }
//
//
//    @Test
//    public void deleteTable(){
//        int i = handleDao.deleteTable("temp", "hospital_id");
//        System.out.println(i);
//
//    }
//
//    @Test
//    public void findByName() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/dcProcedure/findByName")//
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect( OK)
//                .andDo( print() );
//    }
//
//
//
//
//
//
//
//
//}
