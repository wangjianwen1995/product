package com.sxdl.drplus.service;

import cn.hutool.http.HttpRequest;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.drplus.dao1.DrPlusCenterTableDao;
import com.sxdl.drplus.dao1.DrPlusDataTypeDao;
import com.sxdl.drplus.dao1.DrPlusPlatformDetailedDao;
import com.sxdl.drplus.dao1.DrPlusReportProcessDataDao;
import com.sxdl.drplus.entity.DrPlusCenterTable;
import com.sxdl.drplus.entity.DrPlusDataType;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.entity.DrPlusReportProcessData;
import com.sxdl.drplus.util.*;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
//@Transactional
@RequiredArgsConstructor
public class DrPlusReportService extends BaseUUIDServiceImpl<DrPlusReportProcessData> {
    public static final String LineBreak = "\r\n";
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private final  DrPlusPlatformDetailedDao detailedDao;
    private final DrPlusReportProcessDataDao reportProcessDataDao;
    private final DrPlusCenterTableDao centerTableDao;
    private final DrPlusDataTypeDao dataTypeDao;

    @Deprecated
    public void insertData(Integer pid ,Integer history_report_id,String BAH,String CYSJ,String NAME,String ZYH) {
        DrPlusReportProcessData data = new DrPlusReportProcessData();
        data.setDrplus_history_report_id(history_report_id);
        data.setDrplus_platform_detailed_id(pid);
        data.setPatient_zyh(ZYH);
        data.setPatient_name(NAME);
        data.setPatient_cysj(CYSJ);
        data.setPatient_key(BAH);
        return;
    }

    public LinkedHashMap<String, String> fileDRGTemplate (LinkedHashMap map,String Path_file,String File_header, String keycol) throws Exception {
        //1. 判断reply.txt 是否存在，存在就删除文件
        FileReportUtil.delFiletxt(Path_file);
        // 2创建文件并且独占文件开始写入数据
        createfile(map,Path_file,File_header,keycol);
        // 3.判断请求文件是否存在，存在就等待平台返回，返回后继续开始执行
        FileReportUtil.sleepTime(Path_file);
        //4 .读取平台数据：检测应答文件时，应当等到应答文件的reply=TRUE时，方可进行读取工作
        LinkedHashMap<String, String> stringStringMap = txtRead(Path_file);
        return stringStringMap;

    }
   // private String LineBreak ="\r\n";

    public synchronized  void createfile (LinkedHashMap map, String Path_file,String File_header,String keycol) throws Exception{
        //1.生成requestBat.txt文件 并且注入数据
        File file = FileReportUtil.isExistsFile2(Path_file);
        OutputStreamWriter writer=null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(file),"GBK");
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write( File_header.replaceAll("\\n",LineBreak));
        bw.write(LineBreak);

        map.forEach((k,v)->{
            try {
               /*
               //key 这里主键 可能存在空格 但是应该在数据库里面处理
               if(k.toString().equals(keycol)){
                    bw.write(k.toString()+"="+ (StringUtils.isEmpty(v)?"":v.toString().trim()));
                }else {
                    bw.write(k.toString()+"="+ (StringUtils.isEmpty(v)?"":v.toString()));
                }*/
                bw.write(k.toString()+"="+ (StringUtils.isEmpty(v)?"":v.toString()));
                bw.write(LineBreak);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.flush();
        bw.close();
    }

    public   LinkedHashMap<String ,String > txtRead(String  filePath) throws Exception{
        LinkedHashMap<String ,String > map = new LinkedHashMap<>();
        String newfilePath = filePath.replaceAll("\\\\", "\\\\\\\\")+"\\reply.txt";
        File file = new File(newfilePath);

        int flag=50;
        while (flag>0){
            if(file.exists()){
                flag=-1;
                break;
            }
            flag--;
            Thread.sleep(500);
            System.out.println("等待平台返回相应文件中....."+flag);
        }

        flag = 50;
        while (flag>0){
            try {
                if(!file.renameTo(file)){
                    System.out.println("文件被占用 ,请等待..."+flag);
                    flag--;
                    Thread.sleep(2000);
                }else{
                    break;
                }
            }catch (Exception e){
                System.out.println("文件占用异常:"+e.getMessage());
                flag--;
                break;
            }
        }



        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                sb.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            System.out.println("外部系统结束写操作,开始读取文件失败...:"+e.getMessage());
        }

        String result  = sb.toString().replaceAll(LineBreak,"");
        map.put("error",result);


        return map;
    }


    /**
     * 撤销数据
     * @param primaeykey
     * @param pid
     * @param iswrite
     * @param PRIMAEYKEYCol
     * @param path_file
     * @throws Exception
     */
    public void startRevokeReport(String primaeykey, Integer pid, Integer iswrite,String PRIMAEYKEYCol,String path_file) throws Exception {
        //key 第一步 准备数据
        String file_heard="[zybasycx]" +LineBreak+"request=true";
       // LinkedHashMap<String, String> map = new LinkedHashMap<>();
        List<LinkedHashMap<String ,Object>> list = centerTableDao.getPatientData("select PRIMAEYKEY zylsh0,isnull(cardno,'') cardno from drplus_center_table_data"+pid +" where PRIMAEYKEY in ( "+primaeykey+" )");
        //key 第二步 撤销核心代码     第三步 修改状态表
        for (LinkedHashMap<String, Object> map : list) {
            DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid, map.get(PRIMAEYKEYCol).toString());
            dataType.setRevoke_time(DataUtil.getDateTime());
            try {
                LinkedHashMap<String, String> stringStringMap = fileDRGTemplate(map, path_file, file_heard, PRIMAEYKEYCol);
                if(iswrite==1){
                    logger.info("输出报文:"+ JSONObject.fromObject(map));
                    logger.info("输出返回值:"+stringStringMap);
                }
            }catch (Exception e){
                dataType.setReprot_code("-999");
                dataType.setReport_type(-1);
                dataType.setReport_content("系统上报异常:"+e.getMessage());
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }


        }
        return ;
    }
    @Deprecated
    public List<DrPlusReportProcessData> getHistoryReportResultdrillDown(Integer pid, Integer hid, Integer type,String val) {
        List<DrPlusReportProcessData> list = null;
        if(1==type){
            list = reportProcessDataDao.getHistoryReportResultdrillDown1(pid,hid,val);
          }else if(2==type){
            list = reportProcessDataDao.getHistoryReportResultdrillDown2(pid,hid,val);
          }else if(3==type){
            list = reportProcessDataDao.getHistoryReportResultdrillDown3(pid,hid,val);
          }
        return list;
    }


    public List<LinkedHashMap<String, Object>> getReadyReportData(Integer pid,   Integer eid) {
        String sql="";
        List<DrPlusCenterTable> cols = null;
        if(10==pid){
            cols = centerTableDao.getReportColumnNmme(pid,"a");
            sql = DataUtil.getPatientDataByEidName(pid,eid,cols);
        }else if(15==pid){
            cols = centerTableDao.getReportColumnNmme(pid,"a");
            sql = DataUtil.getPatientDataByEidName(pid,eid,cols);
        }else{
            cols = centerTableDao.getReportColumn2(pid);
            sql = DataUtil.getPatientDataByEid(pid,eid,cols);
        }
        List<LinkedHashMap<String ,Object>> list = centerTableDao.getPatientData(sql);
        return list;
    }




    public void startReport(List<LinkedHashMap<String ,Object>> list ,Integer pid,Integer iswrite,String PRIMAEYKEYCol )
    {
        //开始 写util上报类
        DrPlusPlatformDetailed platform = detailedDao.selectByPrimaryKey(pid);
        String starttime="";


        if(2==pid||3==pid){
            for (LinkedHashMap<String, Object> map : list) {
                //key 核心方法
                coreMethod3(pid, map, platform, iswrite ,PRIMAEYKEYCol  );
            }
        }

        if(5==pid){ //dip 上报
            for (LinkedHashMap<String, Object> map : list) {
                //key 核心方法
                coreMethod5(pid, map, platform, iswrite ,PRIMAEYKEYCol  );
            }
        }
        if(6==pid ||7==pid){
            for (LinkedHashMap<String, Object> map : list) {
                //key 核心方法
                coreMethod6(  pid, map, platform, iswrite ,PRIMAEYKEYCol);
            }
        }
        if(10==pid){
            for (LinkedHashMap<String, Object> map : list) {
                //key 核心方法
                coreMethod10(  pid, map, platform, iswrite ,"mdtrt_sn");
            }
        }

        if(15==pid){
            for (LinkedHashMap<String, Object> map : list) {
                //key 核心方法                setl_id-->结算ID
                System.out.println("***** 注意 有数据*****"+list.size());
                coreMethod15(  pid, map, platform, iswrite ,"mdtrt_id");
            }
        }

    }

    //key 核心方法
    private void coreMethod10(Integer pid, LinkedHashMap<String, Object> map,
                              DrPlusPlatformDetailed platform, Integer iswrite,
                              String primaeykeyCol) {
        String keyVal = map.get(primaeykeyCol).toString();

        DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid,keyVal);
        dataType.setReprot_time(DataUtil.getDateTime());

        try {
            //key 组装上报数据
            /*
            String keyVal, Integer pid,LinkedHashMap<String, Object> Adata,DrPlusPlatformDetailed platform
             */
            JSONObject dateReport = getDateReport(keyVal, pid, map,platform);
            //FileUtil.bufferedWriterToFile(dateReport.toString(),"报文.txt");
            if(iswrite==1){
                logger.error("输出报文:"+dateReport);
               // logger.info("输出返回值:"+jo);
            }
            JSONObject jo = Http.requset(dateReport.toString(), platform.getReport_url());
            if(iswrite==1){
                //logger.info("输出报文:"+dateReport);
                logger.error("输出返回值:"+jo);
            }
            // 10平台  的状态码 : -1 失败  0 成功
            String code = jo.getString("infcode");
            String data = jo.getString("err_msg");
            dataType.setReprot_code(code);
            if("0".equals(code)){
                dataType.setReport_type(1);
                dataType.setReport_content("上报成功");
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }else{
                dataType.setReport_type(-1);
                dataType.setReport_content("上报失败: "+data);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }
        }catch (Exception e){
            dataType.setReprot_code("-999");
            dataType.setReport_type(-1);
            dataType.setReport_content("系统上报异常: "+e.getMessage());
            Integer update = dataTypeDao.updateByPrimaryKey(dataType);
        }
    }

    // 15 平台 核心组装数据
    private JSONObject getDateReport15(String keyVal, Integer pid,LinkedHashMap<String, Object> Adata,DrPlusPlatformDetailed platform) throws Exception {
        //key 组装基本信息数据
        System.out.println("***进入数据核心数据组装");
        JSONObject setlinfo = JSONObject.fromObject(Adata);

        System.out.println("数据查询A完成");
        List<String> BColumn = centerTableDao.getReportColumnOnlyName(pid,"b");
        String sqlTxtB = DataUtil.getReportSql(keyVal,pid, "b",BColumn);
        List<LinkedHashMap<String, Object>> dataB = getDataBySql(sqlTxtB);
        if(StringUtils.isEmpty(dataB) || dataB.size()<1){
            dataB = new ArrayList<>();
        }
        JSONArray  payinfo= JSONArray.fromObject(dataB);

        System.out.println("数据查询B完成");
        List<String> CColumn = centerTableDao.getReportColumnOnlyName(pid,"c");
        String sqlTxtC = DataUtil.getReportSql(keyVal,pid, "c",CColumn);
        List<LinkedHashMap<String, Object>> dataC = getDataBySql(sqlTxtC);
        JSONArray  opspdiseinfo= JSONArray.fromObject(dataC);
        System.out.println("数据查询C完成");

        List<String> DColumn = centerTableDao.getReportColumnOnlyName(pid,"d");
        String sqlTxtD = DataUtil.getReportSql(keyVal,pid, "d",DColumn);
        List<LinkedHashMap<String, Object>> dataD = getDataBySql(sqlTxtD);
        JSONArray  diseinfo= JSONArray.fromObject(dataD);
        System.out.println("数据查询D完成");
        List<String> EColumn = centerTableDao.getReportColumnOnlyName(pid,"e");
        String sqlTxtE = DataUtil.getReportSql(keyVal,pid, "e",EColumn);
        List<LinkedHashMap<String, Object>> dataE = getDataBySql(sqlTxtE);
        JSONArray  iteminfo= JSONArray.fromObject(dataE);
        System.out.println("数据查询E完成");
        List<String> FColumn = centerTableDao.getReportColumnOnlyName(pid,"f");
        String sqlTxtF = DataUtil.getReportSql(keyVal,pid, "f",FColumn);
        List<LinkedHashMap<String, Object>> dataF = getDataBySql(sqlTxtF);
        JSONArray  oprninfo= JSONArray.fromObject(dataF);
        System.out.println("数据查询F完成");
        List<String> GColumn = centerTableDao.getReportColumnOnlyName(pid,"g");
        String sqlTxtG = DataUtil.getReportSql(keyVal,pid, "g",GColumn);
        List<LinkedHashMap<String, Object>> dataG = getDataBySql(sqlTxtG);
        JSONArray  icuinfo= JSONArray.fromObject(dataG);


        System.out.println("数据查询G完成");
        //key 组装上报节点input 数据
        JSONObject inputJson = new JSONObject();
        inputJson.put("setlinfo",setlinfo);
        inputJson.put("payinfo",payinfo);
        inputJson.put("opspdiseinfo",opspdiseinfo);
        inputJson.put("diseinfo",diseinfo);
        inputJson.put("iteminfo",iteminfo);
        inputJson.put("oprninfo",oprninfo);
        inputJson.put("icuinfo",icuinfo);

        //key 1~4 加密 input 节点 数据 和 加密cainfo 秘钥节点数据
        //1 生成 SM4 秘钥
        //String sm4Key = SM4SM2.getSM4Key();
        //2 使用SM4 秘钥加密 input节点数据
        //String input = SM4SM2.SM4EncryptStr(sm4Key, inputJson.toString());
        //3 使用SM2 将SM4的秘钥加密 放到 cainfo 节点中
        //String cainfo = SM4SM2.SM2EncryptStr(sm4Key,platform.getAppid());

        //key 最后封装数据返回
        JSONObject resultData = FileUtil.getJsonDate("report15.json");
        // 加密后的input 节点数据
        Map<String, String> m = DataUtil.getDateTime3();
        String atime = m.get("a").toString();
        String btime = m.get("b").toString();
        resultData.put("inf_time",atime);
        resultData.put("msgid",resultData.getString("msgid")+btime+""+Math.round((Math.random()+1) * 1000));
        //核心数据
        resultData.put("input",inputJson);
        // 签到编码
        resultData.put("sign_no",platform.getToken());
        // SM4 秘钥
        //resultData.put("cainfo",cainfo);

        return resultData;
    }



    //key 核心方法
    private void coreMethod15(Integer pid, LinkedHashMap<String, Object> map,
                              DrPlusPlatformDetailed platform, Integer iswrite,
                              String primaeykeyCol) {
        logger.error("输出map:"+map.toString());
        String keyVal = map.get(primaeykeyCol).toString();
        System.out.println("keyVal="+keyVal);
        DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid,keyVal);
        dataType.setReprot_time(DataUtil.getDateTime());

        try {
            //key 组装上报数据
            JSONObject dateReport = getDateReport15(keyVal, pid, map,platform);
            //FileUtil.bufferedWriterToFile(dateReport.toString(),"报文.txt");
            if(iswrite==1){
                logger.error("输出报文:"+dateReport);
                // logger.info("输出返回值:"+jo);
            }
            JSONObject jo = Http.requset(dateReport.toString(), platform.getReport_url());
            if(iswrite==1){
                //logger.info("输出报文:"+dateReport);
                logger.error("输出返回值:"+jo);
            }
            // 15平台  的状态码 : -1 失败  0 成功
            String code = jo.getString("infcode");
            String data = jo.getString("err_msg");
            dataType.setReprot_code(code);
            if("0".equals(code)){
                dataType.setReport_type(1);
                dataType.setReport_content("上报成功");
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }else{
                dataType.setReport_type(-1);
                dataType.setReport_content("上报失败: "+data);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }
        }catch (Exception e){
            dataType.setReprot_code("-999");
            dataType.setReport_type(-1);
            dataType.setReport_content("系统上报异常: "+e.getMessage());
            Integer update = dataTypeDao.updateByPrimaryKey(dataType);
        }
    }




    // 10 平台 核心组装数据
    private JSONObject getDateReport(String keyVal, Integer pid,LinkedHashMap<String, Object> Adata,DrPlusPlatformDetailed platform) throws Exception {
        //key 组装基本信息数据
        JSONObject baseinfo = JSONObject.fromObject(Adata);

        //key 组装诊断数据
        List<String> BColumn = centerTableDao.getReportColumnOnlyName(pid,"b");
        String sqlTxtB = DataUtil.getReportSql(keyVal,pid, "b",BColumn);
        List<LinkedHashMap<String, Object>> dataB = getDataBySql(sqlTxtB);
        JSONArray  diseinfo= JSONArray.fromObject(dataB);

        //key 组装手术数据
        List<String> CColumn = centerTableDao.getReportColumnOnlyName(pid,"c");
        String sqlTxtC = DataUtil.getReportSql(keyVal,pid, "c",CColumn);
        List<LinkedHashMap<String, Object>> dataC = getDataBySql(sqlTxtC);
        JSONArray  oprninfo= JSONArray.fromObject(dataC);

        //key 组装重症监护数据
        List<String> DColumn = centerTableDao.getReportColumnOnlyName(pid,"d");
        String sqlTxtD = DataUtil.getReportSql(keyVal,pid, "d",DColumn);
        List<LinkedHashMap<String, Object>> dataD = getDataBySql(sqlTxtD);
        JSONArray  icuinfo= JSONArray.fromObject(dataD);

        //key 组装上报节点input 数据
        JSONObject inputJson = new JSONObject();
        inputJson.put("baseinfo",baseinfo);
        inputJson.put("diseinfo",diseinfo);
        inputJson.put("oprninfo",oprninfo);
        inputJson.put("icuinfo",icuinfo);

        //key 1~4 加密 input 节点 数据 和 加密cainfo 秘钥节点数据
        //1 生成 SM4 秘钥
        //String sm4Key = SM4SM2.getSM4Key();
        //2 使用SM4 秘钥加密 input节点数据
        //String input = SM4SM2.SM4EncryptStr(sm4Key, inputJson.toString());
        //3 使用SM2 将SM4的秘钥加密 放到 cainfo 节点中
        //String cainfo = SM4SM2.SM2EncryptStr(sm4Key,platform.getAppid());

        //key 最后封装数据返回
        JSONObject resultData = FileUtil.getJsonDate("report10.json");
        // 加密后的input 节点数据
        Map<String, String> m = DataUtil.getDateTime3();
        String atime = m.get("a").toString();
        String btime = m.get("b").toString();
        resultData.put("inf_time",atime);
        resultData.put("msgid",resultData.getString("msgid")+btime+""+Math.round((Math.random()+1) * 1000));
        //核心数据
        resultData.put("input",inputJson);
        // 签到编码
        resultData.put("sign_no",platform.getToken());
        // SM4 秘钥
        //resultData.put("cainfo",cainfo);

        return resultData;
    }

    //key 核心方法
    private void coreMethod6( Integer pid,LinkedHashMap<String, Object> map,DrPlusPlatformDetailed platform,Integer iswrite
            ,String PRIMAEYKEYCol  )
    {

        String skey = PRIMAEYKEYCol;
        if(StringUtils.isEmpty(PRIMAEYKEYCol))
            skey = "PRIMAEYKEY";
        //key  保存 上报明细的历史数据 用来实上报数据 下钻使用
        DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid, map.get(skey).toString());
        dataType.setReprot_time(DataUtil.getDateTime());

        //key 若不上报主键则会 删除主键不会影响上报
        if(StringUtils.isEmpty(PRIMAEYKEYCol))
            map.keySet().removeIf(key -> key.equals("PRIMAEYKEY"));

        try {
            JSONObject jo = RequestUtil.sendOut2(JSONObject.fromObject(map).toString(),platform.getReport_url(),platform.getContent_type(),platform.getToken(),platform.getUseragent());
            if(iswrite==1){
                logger.error("输出报文:"+JSONObject.fromObject(map));
                logger.error("输出返回值:"+jo);
            }
            String code = jo.getString("code");
            String message = jo.getString("message");
            String data = jo.getString("data");
            dataType.setReprot_code(code);
            if("1".equals(code)){
                dataType.setReport_type(1);
                dataType.setReport_content(message+": "+data);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }else{
                dataType.setReport_type(-1);
                dataType.setReport_content(message+": "+data);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }
        }catch (Exception e){
            dataType.setReprot_code("-999");
            dataType.setReport_type(-1);
            dataType.setReport_content("系统上报异常:"+e.getMessage());
            Integer update = dataTypeDao.updateByPrimaryKey(dataType);
        }
    }


    //TODO 这里上报数据 文件这块需要加强下  回馈信息这里需要获取数据判断是否 成功,把有效数据打印到log日志中去
    private void coreMethod3( Integer pid,LinkedHashMap<String, Object> map,DrPlusPlatformDetailed platform,Integer iswrite
            ,String PRIMAEYKEYCol )
    {
        String skey = PRIMAEYKEYCol;
         if(StringUtils.isEmpty(PRIMAEYKEYCol))
             skey = "PRIMAEYKEY";
        //key  保存 上报明细的历史数据 用来实上报数据 下钻使用
        DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid, map.get(skey).toString());
        dataType.setReprot_time(DataUtil.getDateTime());

        //key 若不上报主键则会 删除主键不会影响上报
        if(StringUtils.isEmpty(PRIMAEYKEYCol))
            map.keySet().removeIf(key -> key.equals("PRIMAEYKEY"));
        try {
            //JSONObject jo = RequestUtil.sendOut2(JSONObject.fromObject(map).toString(),platform.getReport_url(),platform.getContent_type(),platform.getToken(),platform.getUseragent());
            LinkedHashMap<String, String> stringStringMap = fileDRGTemplate(map, platform.getPath_file(),platform.getFile_header(),PRIMAEYKEYCol);

            if(iswrite==1){
                logger.error("输出报文:"+JSONObject.fromObject(map));
                logger.error("输出返回值:"+stringStringMap);
            }
            String code = stringStringMap.get("code");
            String message = stringStringMap.get("message");
            String data = stringStringMap.get("data");
            dataType.setReprot_code(code);
            if("1".equals(code)){
                dataType.setReport_type(1);
                dataType.setReport_content(message+": "+data);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);

            }else{
                dataType.setReport_type(-1);
                dataType.setReport_content(message+": "+data);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);

            }
        }catch (Exception e){
            dataType.setReport_type(-1);
            dataType.setRevoke_content("系统上报异常:"+e.getMessage());
            Integer update = dataTypeDao.updateByPrimaryKey(dataType);

        }
    }

    //key 核心方法
    private void coreMethod5(Integer pid, LinkedHashMap<String, Object> map,
                              DrPlusPlatformDetailed platform, Integer iswrite,
                              String primaeykeyCol) {
        String keyVal = map.get(primaeykeyCol).toString();

        DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid,keyVal);
        dataType.setReprot_time(DataUtil.getDateTime());

        try {
            //key 组装上报数据
            Map<String,Object> maps = new LinkedHashMap<>();
            maps.put("APP_ID",platform.getAppid());
            maps.put("ORG_CODE",platform.getOrgcode());
            maps.put("MED_SETTLE_INFO",JSONObject.fromObject(map).toString());

            String dateReport= HttpRequest.post(platform.getReport_url())
                    .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                    .header("Accept", "application/json; charset=UTF-8").form(maps).execute().body();

            if(iswrite==1){
                logger.error("输出报文:"+dateReport);
            }

            JSONObject jo = JSONObject.fromObject(dateReport);
            if(iswrite==1){
                logger.error("输出返回值:"+jo);
            }
            // 5 平台  的状态码 : 400 失败  200 成功
            String code = jo.getString("CODE");
            dataType.setReprot_code(code);
            if("200".equals(code)){
                dataType.setReport_type(1);
                dataType.setReport_content("上报成功");
                String data = jo.getJSONObject("DATA").getString("QDLSH");
                dataType.setRevoke_code(data);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }else{
                String FAILDATA = jo.getJSONObject("FAILDATA").getString("MSG");
                dataType.setReport_type(-1);
                dataType.setReport_content("上报失败: "+FAILDATA);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }
        }catch (Exception e){
            dataType.setReprot_code("-999");
            dataType.setReport_type(-1);
            dataType.setReport_content("系统上报异常: "+e.getMessage());
            Integer update = dataTypeDao.updateByPrimaryKey(dataType);
        }
    }


    /**
     * signIn 签到 节点的数据
     * @return
     */
    public  JSONObject getSignIn(String opter, String key,Integer pid) throws Exception {
        JSONObject resultData = FileUtil.getJsonDate("report"+pid+".json");
        Map<String, String> m = DataUtil.getDateTime3();
        String atime = m.get("a").toString();
        String btime = m.get("b").toString();
        resultData.put("inf_time",atime);
        resultData.put("msgid",resultData.getString("msgid")+btime+""+Math.round((Math.random()+1) * 1000));
        resultData.put("infno","9001");

        //组装 signIn节点数据 数据
        JSONObject inputJson = MACIPUtil.getInput(opter);
        //加密数据
        //1 生成 SM4 秘钥
        //String sm4Key = SM4SM2.getSM4Key();
        //2 使用SM4 秘钥加密 input节点数据
        //String input = SM4SM2.SM4EncryptStr(sm4Key, inputJson.toString());
        //3 使用SM2 将SM4的秘钥加密 放到 cainfo 节点中
        //String cainfo = SM4SM2.SM2EncryptStr(sm4Key,key);
        // SM4 秘钥
        //resultData.put("cainfo",cainfo);
        resultData.put("inf_time",DataUtil.getDateTime());
        resultData.put("input",inputJson);
        //组装  节点数据
        return resultData;
    }

    //开始 签到 获取签到编号
    public String startSignIn(JSONObject signInJson,String url,String key,Integer pid) {

        logger.error(LineBreak+"输出签到报文:"+signInJson.toString() );
        JSONObject jo = Http.requset(signInJson.toString(),url);
        logger.error(LineBreak+"输出返回值:"+jo);
        String output = jo.getString("output");
        //String cainfo_data = jo.getString("cainfo");

        //String sm4Key = SM4SM2.SM2DecryptStr(cainfo_data,key);

        //4.2 使用解密后的SM4秘钥 解密SM4 加密后的数据
        //String s = SM4SM2.SM4DecryptStr(sm4Key, output);

        // signinoutb节点的  sign_no 就是签到编号
        String sign_no = JSONObject.fromObject(output).getJSONObject("signinoutb").getString("sign_no");
        return sign_no;
    }

    /**
     *  签退
     * @param sign_no
     * @param opter_no
     * @return
     * @throws Exception
     */
    public JSONObject getSignOut(String sign_no,String opter_no,String key,Integer pid) throws Exception {
        JSONObject resultData = FileUtil.getJsonDate("report"+pid+".json");
        Map<String, String> m = DataUtil.getDateTime3();
        String atime = m.get("a").toString();
        String btime = m.get("b").toString();
        resultData.put("inf_time",atime);
        resultData.put("msgid",resultData.getString("msgid")+btime+""+Math.round((Math.random()+1) * 1000));
        resultData.put("infno","9002");
        //组装 signOut节点数据 数据
        JSONObject signOutJson = new JSONObject();
        signOutJson.put("sign_no",sign_no);
        signOutJson.put("opter_no",opter_no);
        JSONObject inputJson = new JSONObject();
        inputJson.put("signOut",signOutJson);
        //加密数据
        //key 1~4 加密 input 节点 数据 和 加密cainfo 秘钥节点数据
        //1 生成 SM4 秘钥
        //String sm4Key = SM4SM2.getSM4Key();
        //2 使用SM4 秘钥加密 input节点数据
        //String input = SM4SM2.SM4EncryptStr(sm4Key, inputJson.toString());
        //3 使用SM2 将SM4的秘钥加密 放到 cainfo 节点中
        //String cainfo = SM4SM2.SM2EncryptStr(sm4Key,key);
        // SM4 秘钥
        //resultData.put("cainfo",cainfo);
        resultData.put("inf_time",DataUtil.getDateTime());
        resultData.put("input",inputJson);
        //组装  节点数据
        return resultData;
    }

    public String startSignOut(JSONObject signOutJson,String url,String key) {
        JSONObject jo = Http.requset(signOutJson.toString(),url);

        String output = jo.getString("output");
        //String cainfo_data = jo.getString("cainfo");

        //String sm4Key = SM4SM2.SM2DecryptStr(cainfo_data,key);

        //4.2 使用解密后的SM4秘钥 解密SM4 加密后的数据
        //String s = SM4SM2.SM4DecryptStr(sm4Key, output);
        // signinoutb节点的  sign_no 就是签到编号
        String sign_time = JSONObject.fromObject(output).getJSONObject("signoutoutb").getString("sign_time");
        return sign_time;
    }




}



