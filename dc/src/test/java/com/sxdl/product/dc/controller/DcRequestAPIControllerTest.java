package com.sxdl.product.dc.controller;

import cn.hutool.json.JSONUtil;
import com.sxdl.product.dc.Main;
import com.sxdl.product.dc.MainTest;
import com.sxdl.product.dc.dao.dao1.DcColumnDao;
import com.sxdl.product.dc.dao.dao1.DcRequestAPIDao;
import com.sxdl.product.dc.dao.dao1.DcTableDao;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcRequestAPI;
import com.sxdl.product.dc.entity.DcTable;
import com.sxdl.product.dc.util.WebUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Hui
 * @version 1.0
 */

@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class DcRequestAPIControllerTest extends MainTest {



    @Autowired
    private HandleDao handleDao;



    @Autowired
    private DcTableDao dcTableDao;
    @Autowired
    private DcColumnDao dcColumnDao;



    @Autowired
    DcRequestAPIDao dcRequestAPIDao;
    @Test
    public void getAll() throws Exception {
        mockMvc.perform ( MockMvcRequestBuilders.get ( "/api/getAll" ) //路径
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Test
    public void save() throws Exception {
        DcRequestAPI dcRequestAPI = new DcRequestAPI();
        dcRequestAPI.setUrl ( "http://" );
        dcRequestAPI.setName ( "测试2" );
        mockMvc.perform ( MockMvcRequestBuilders.post ( "/api/save" ) //路径
                .content( JSONUtil.toJsonStr(dcRequestAPI))
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }




    @Test
    public void cloneRequest() throws Exception {

        DcRequestAPI dcRequestAPI = new DcRequestAPI();
        dcRequestAPI.setId ("3" );
        mockMvc.perform ( MockMvcRequestBuilders.get ( "/api/clone" ) //路径
                .content( JSONUtil.toJsonStr(dcRequestAPI))
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据

    }

    @Test
    public void update() throws  Exception {

        DcRequestAPI dcRequestAPI = new DcRequestAPI();
        dcRequestAPI.setId ("3" );
        dcRequestAPI.setName ( "sa" );
        dcRequestAPI.setProduct_id ( "1");
        mockMvc.perform ( MockMvcRequestBuilders.put ( "/api/update" ) //路径
                .content( JSONUtil.toJsonStr(dcRequestAPI))
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }

    @Test
    public void del() throws Exception{
        DcRequestAPI dcRequestAPI = new DcRequestAPI();
        dcRequestAPI.setId ("4" );
        mockMvc.perform ( MockMvcRequestBuilders.delete ( "/api/del" ) //路径
                .content( JSONUtil.toJsonStr(dcRequestAPI))
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据

    }



      @Test
    public void sendout() throws Exception {
        DcRequestAPI dcRequestAPI = new DcRequestAPI();



        //测试 无参 接口
        dcRequestAPI.setIsparam ( 3 );
        dcRequestAPI.setTag ( "ETL_His_yzzt" );
        //测试时间参数 接口
//        dcRequestAPI.setIsparam ( 1 );
//        dcRequestAPI.setTag ( "ETL_His_HzJbxx" );
//        dcRequestAPI.setParams ( "startDate>2020-07-01;endDate>2020-07-02" );
        dcRequestAPI.setUrl ( "http://172.180.100.18:10012/HospitalInfection.asmx" );
        dcRequestAPI.setContenttype ( "application/soap+xml;charset=utf-8" );
        dcRequestAPI.setName ( "测试2" );
        mockMvc.perform ( MockMvcRequestBuilders.post ( "/api/sendout" ) //路径
                .content( JSONUtil.toJsonStr(dcRequestAPI))
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }



    @Test
    public void createFile() throws Exception {
        DcRequestAPI dcRequestAPI = new DcRequestAPI();



        //测试 无参 接口
        dcRequestAPI.setIsparam ( 3 );
        dcRequestAPI.setTag ( "ETL_YPZD" );
        //测试时间参数 接口
        dcRequestAPI.setIsparam ( 1 );
        dcRequestAPI.setTag ( "ETL_zkxx" );
        dcRequestAPI.setUrl ( "http://172.180.100.18:10012/HospitalInfection.asmx" );
        dcRequestAPI.setContenttype ( "application/soap+xml;charset=utf-8" );
        dcRequestAPI.setName ( "测试2" );
        mockMvc.perform ( MockMvcRequestBuilders.post ( "/api/createFile" ) //路径
                .content( JSONUtil.toJsonStr(dcRequestAPI))
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }



    @Test
    public void saveOneTable() throws Exception {
        DcRequestAPI dcRequestAPI = new DcRequestAPI();
        //测试 无参 接口
       dcRequestAPI.setTag ( "ETL_YPZD" );
        //测试时间参数 接口
        dcRequestAPI.setSchedule_id ( "3");
        dcRequestAPI.setIsparam ( 0 );
        dcRequestAPI.setIsparam ( 1 );
        dcRequestAPI.setTag ( "ETL_zkxx" );
        dcRequestAPI.setUrl ( "http://172.180.100.18:10012/HospitalInfection.asmx" );
        dcRequestAPI.setContenttype ( "application/soap+xml;charset=utf-8" );
        dcRequestAPI.setName ( "测试2" );
        mockMvc.perform ( MockMvcRequestBuilders.post ( "/api/saveOneTable" ) //路径
                .content( JSONUtil.toJsonStr(dcRequestAPI))
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )//请求头类型
                .andExpect ( OK )//状态码200
                .andDo ( print () );//结束后打印所有数据
    }




    // 第一步 xml 请求头信息拼接测试通过  -->发送按钮功能
      @Autowired
      public void sendinfo(){

        Integer param=2;
        StringBuilder sb = new StringBuilder();
        String webSoapHeaderStr = WebUtil.getWebSoapHeaderStr();
        String webSoapTailStr="";
        if(param==1){
            String params = "startDate>2020-01-01;endDate>2020-02-01;";
            LinkedHashMap<String, String> keyValues = WebUtil.getKeyValues(params);
            webSoapTailStr = WebUtil.getWebSoapTailTimeParamStr("ETL_TDoctor",  keyValues);
        }else if(param==2){
            String params = "blh>583541;";
            LinkedHashMap<String, String> keyValue = WebUtil.getKeyValues(params);
            webSoapTailStr = WebUtil.getWebSoapTailBlhParamStr("ETL_TDoctor",keyValue);
        }else if(param==0){
            webSoapTailStr = WebUtil.getWebSoapTailNoParamStr("ETL_TDoctor");
        }
        String webString = sb.append(webSoapHeaderStr).append(webSoapTailStr).toString();

        System.out.println(webString);


      }




      //第二步   同步表 功能测试完成
    @Test
    public void createSqlAutoExec() throws Exception {
        Set<String > tableColumns  = new HashSet<>();
        tableColumns.add("name");
        tableColumns.add("code");
        tableColumns.add("type");
        tableColumns.add("center");
        tableColumns.add("isparam");
        tableColumns.add("biyear");
        tableColumns.add("bimonth");
        String tag = "ETL_Zy_basy";
        DcTable dcTable = new DcTable();
        dcTable.setName(tag);
        List<DcTable> table = dcTableDao.select(dcTable);
        String sqlText="";
        //创建一个装载 新增字段的容器
        List<String> addCloumn = new ArrayList<>();
        if(table.size()>0){  //表存在 ，判断是否有多出来的字段 有 添加字段
            DcColumn column = new DcColumn();
            String talbeId =table.get(0).getId();
            column.setTable_id(table.get(0).getId());
            //将获取的 entity集合换成 字符串集合
            List<DcColumn> dcColumns = dcColumnDao.select(column);
            List<String> dccolumns = new ArrayList<>();
            for (DcColumn dcColumn : dcColumns) {
                dccolumns.add(dcColumn.getColumn_name());
            }
            for (String webColumn : tableColumns) {
                if(!dccolumns.contains(webColumn)){
                    addCloumn.add(webColumn);
                }
            }
            // 存在新 增 字段 开始 添加
            if(addCloumn.size()>0){
                for (String webColumn : addCloumn) {
                    DcColumn addC = new DcColumn();
                    addC.setTable_id(talbeId);
                    addC.setColumn_name(webColumn);
                    addC.setType_id(1);
                    addC.setType("字符串");
                    addC.setSize(500);
                    dcColumnDao.insert(addC);
                }

                sqlText = WebUtil.getSqlTextIsExists(tag, addCloumn);
            }

        }else{  //没有表，则创建
            dcTableDao.insert(dcTable);
            if(tableColumns.size()>0){
                for (String dcColumn : tableColumns) {
                    DcColumn addC = new DcColumn();
                    addC.setTable_id(dcTable.getId());
                    addC.setColumn_name(dcColumn);
                    addC.setType_id(1);
                    addC.setType("字符串");
                    addC.setSize(500);
                    dcColumnDao.insert(addC);
                }
                sqlText =  WebUtil.getSqlTextNotExists(tag,tableColumns);
            }
        }


        System.out.println(sqlText);


     if (sqlText.length()>0){
            // 直接执行sql语句
            handleDao.excuteSqlWithSQL(sqlText);
        }

    }



      // 保存web数据   抽取历史数据 功能通过
  @Test
    public void  ttt() throws Exception{
        LinkedHashMap<String,String > map = new LinkedHashMap<>();
        map.put("isparam","111");
        map.put("code","222");
        map.put("center","333");
        map.put("name","4444");
        map.put("type","555");
        map.put("bimonth","666");
        map.put("biyear","777");
        String etl_zy_basy = WebUtil.getInsertTableSql("ETL_Zy_basy", map);
        System.out.println(etl_zy_basy);
    }



    @Test
    public void proctest(){
        String sql = "DECLARE @sql VARCHAR(800)\n" +
                "IF (NOT EXISTS(SELECT * FROM sysobjects WHERE name='etl_ttt' AND type='P'))\n" +
                "BEGIN\n" +
                " set  @sql='CREATE  PROC etl_ttt\n" +
                "\tAS\n" +
                "\tBEGIN\n" +
                "\t SELECT 1\n" +
                "\tend'\n" +
                "\tEXEC (@sql)\n" +
                "END\n" +
                "ELSE BEGIN\n" +
                " \n" +
                " \n" +
                "\tset  @sql='alter  PROC etl_ttt\n" +
                "\tAS\n" +
                "\tBEGIN\n" +
                "\t SELECT 2\n" +
                "\tend'\n" +
                "\tEXEC (@sql) \n" +
                " \n" +
                "END";

        int i = handleDao.excuteSqlWithSQL(sql);



    }


    @Test
    public void runProc(){
        String etl_ttt = handleDao.excuteCallProcedueWithParams("etl_ttt", "水电费", "地方");
        System.out.println(etl_ttt);
    }












}