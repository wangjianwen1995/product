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
        //1. ??????reply.txt ????????????????????????????????????
        FileReportUtil.delFiletxt(Path_file);
        // 2????????????????????????????????????????????????
        createfile(map,Path_file,File_header,keycol);
        // 3.??????????????????????????????????????????????????????????????????????????????????????????
        FileReportUtil.sleepTime(Path_file);
        //4 .????????????????????????????????????????????????????????????????????????reply=TRUE??????????????????????????????
        LinkedHashMap<String, String> stringStringMap = txtRead(Path_file);
        return stringStringMap;

    }
   // private String LineBreak ="\r\n";

    public synchronized  void createfile (LinkedHashMap map, String Path_file,String File_header,String keycol) throws Exception{
        //1.??????requestBat.txt?????? ??????????????????
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
               //key ???????????? ?????????????????? ????????????????????????????????????
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
            System.out.println("?????????????????????????????????....."+flag);
        }

        flag = 50;
        while (flag>0){
            try {
                if(!file.renameTo(file)){
                    System.out.println("??????????????? ,?????????..."+flag);
                    flag--;
                    Thread.sleep(2000);
                }else{
                    break;
                }
            }catch (Exception e){
                System.out.println("??????????????????:"+e.getMessage());
                flag--;
                break;
            }
        }



        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//????????????BufferedReader??????????????????
            String s = null;
            while((s = br.readLine())!=null){//??????readLine????????????????????????
                sb.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            System.out.println("???????????????????????????,????????????????????????...:"+e.getMessage());
        }

        String result  = sb.toString().replaceAll(LineBreak,"");
        map.put("error",result);


        return map;
    }


    /**
     * ????????????
     * @param primaeykey
     * @param pid
     * @param iswrite
     * @param PRIMAEYKEYCol
     * @param path_file
     * @throws Exception
     */
    public void startRevokeReport(String primaeykey, Integer pid, Integer iswrite,String PRIMAEYKEYCol,String path_file) throws Exception {
        //key ????????? ????????????
        String file_heard="[zybasycx]" +LineBreak+"request=true";
       // LinkedHashMap<String, String> map = new LinkedHashMap<>();
        List<LinkedHashMap<String ,Object>> list = centerTableDao.getPatientData("select PRIMAEYKEY zylsh0,isnull(cardno,'') cardno from drplus_center_table_data"+pid +" where PRIMAEYKEY in ( "+primaeykey+" )");
        //key ????????? ??????????????????     ????????? ???????????????
        for (LinkedHashMap<String, Object> map : list) {
            DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid, map.get(PRIMAEYKEYCol).toString());
            dataType.setRevoke_time(DataUtil.getDateTime());
            try {
                LinkedHashMap<String, String> stringStringMap = fileDRGTemplate(map, path_file, file_heard, PRIMAEYKEYCol);
                if(iswrite==1){
                    logger.info("????????????:"+ JSONObject.fromObject(map));
                    logger.info("???????????????:"+stringStringMap);
                }
            }catch (Exception e){
                dataType.setReprot_code("-999");
                dataType.setReport_type(-1);
                dataType.setReport_content("??????????????????:"+e.getMessage());
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
        //?????? ???util?????????
        DrPlusPlatformDetailed platform = detailedDao.selectByPrimaryKey(pid);
        String starttime="";


        if(2==pid||3==pid){
            for (LinkedHashMap<String, Object> map : list) {
                //key ????????????
                coreMethod3(pid, map, platform, iswrite ,PRIMAEYKEYCol  );
            }
        }

        if(5==pid){ //dip ??????
            for (LinkedHashMap<String, Object> map : list) {
                //key ????????????
                coreMethod5(pid, map, platform, iswrite ,PRIMAEYKEYCol  );
            }
        }
        if(6==pid ||7==pid){
            for (LinkedHashMap<String, Object> map : list) {
                //key ????????????
                coreMethod6(  pid, map, platform, iswrite ,PRIMAEYKEYCol);
            }
        }
        if(10==pid){
            for (LinkedHashMap<String, Object> map : list) {
                //key ????????????
                coreMethod10(  pid, map, platform, iswrite ,"mdtrt_sn");
            }
        }

        if(15==pid){
            for (LinkedHashMap<String, Object> map : list) {
                //key ????????????                setl_id-->??????ID
                System.out.println("***** ?????? ?????????*****"+list.size());
                coreMethod15(  pid, map, platform, iswrite ,"mdtrt_id");
            }
        }

    }

    //key ????????????
    private void coreMethod10(Integer pid, LinkedHashMap<String, Object> map,
                              DrPlusPlatformDetailed platform, Integer iswrite,
                              String primaeykeyCol) {
        String keyVal = map.get(primaeykeyCol).toString();

        DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid,keyVal);
        dataType.setReprot_time(DataUtil.getDateTime());

        try {
            //key ??????????????????
            /*
            String keyVal, Integer pid,LinkedHashMap<String, Object> Adata,DrPlusPlatformDetailed platform
             */
            JSONObject dateReport = getDateReport(keyVal, pid, map,platform);
            //FileUtil.bufferedWriterToFile(dateReport.toString(),"??????.txt");
            if(iswrite==1){
                logger.error("????????????:"+dateReport);
               // logger.info("???????????????:"+jo);
            }
            JSONObject jo = Http.requset(dateReport.toString(), platform.getReport_url());
            if(iswrite==1){
                //logger.info("????????????:"+dateReport);
                logger.error("???????????????:"+jo);
            }
            // 10??????  ???????????? : -1 ??????  0 ??????
            String code = jo.getString("infcode");
            String data = jo.getString("err_msg");
            dataType.setReprot_code(code);
            if("0".equals(code)){
                dataType.setReport_type(1);
                dataType.setReport_content("????????????");
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }else{
                dataType.setReport_type(-1);
                dataType.setReport_content("????????????: "+data);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }
        }catch (Exception e){
            dataType.setReprot_code("-999");
            dataType.setReport_type(-1);
            dataType.setReport_content("??????????????????: "+e.getMessage());
            Integer update = dataTypeDao.updateByPrimaryKey(dataType);
        }
    }

    // 15 ?????? ??????????????????
    private JSONObject getDateReport15(String keyVal, Integer pid,LinkedHashMap<String, Object> Adata,DrPlusPlatformDetailed platform) throws Exception {
        //key ????????????????????????
        System.out.println("***??????????????????????????????");
        JSONObject setlinfo = JSONObject.fromObject(Adata);

        System.out.println("????????????A??????");
        List<String> BColumn = centerTableDao.getReportColumnOnlyName(pid,"b");
        String sqlTxtB = DataUtil.getReportSql(keyVal,pid, "b",BColumn);
        List<LinkedHashMap<String, Object>> dataB = getDataBySql(sqlTxtB);
        if(StringUtils.isEmpty(dataB) || dataB.size()<1){
            dataB = new ArrayList<>();
        }
        JSONArray  payinfo= JSONArray.fromObject(dataB);

        System.out.println("????????????B??????");
        List<String> CColumn = centerTableDao.getReportColumnOnlyName(pid,"c");
        String sqlTxtC = DataUtil.getReportSql(keyVal,pid, "c",CColumn);
        List<LinkedHashMap<String, Object>> dataC = getDataBySql(sqlTxtC);
        JSONArray  opspdiseinfo= JSONArray.fromObject(dataC);
        System.out.println("????????????C??????");

        List<String> DColumn = centerTableDao.getReportColumnOnlyName(pid,"d");
        String sqlTxtD = DataUtil.getReportSql(keyVal,pid, "d",DColumn);
        List<LinkedHashMap<String, Object>> dataD = getDataBySql(sqlTxtD);
        JSONArray  diseinfo= JSONArray.fromObject(dataD);
        System.out.println("????????????D??????");
        List<String> EColumn = centerTableDao.getReportColumnOnlyName(pid,"e");
        String sqlTxtE = DataUtil.getReportSql(keyVal,pid, "e",EColumn);
        List<LinkedHashMap<String, Object>> dataE = getDataBySql(sqlTxtE);
        JSONArray  iteminfo= JSONArray.fromObject(dataE);
        System.out.println("????????????E??????");
        List<String> FColumn = centerTableDao.getReportColumnOnlyName(pid,"f");
        String sqlTxtF = DataUtil.getReportSql(keyVal,pid, "f",FColumn);
        List<LinkedHashMap<String, Object>> dataF = getDataBySql(sqlTxtF);
        JSONArray  oprninfo= JSONArray.fromObject(dataF);
        System.out.println("????????????F??????");
        List<String> GColumn = centerTableDao.getReportColumnOnlyName(pid,"g");
        String sqlTxtG = DataUtil.getReportSql(keyVal,pid, "g",GColumn);
        List<LinkedHashMap<String, Object>> dataG = getDataBySql(sqlTxtG);
        JSONArray  icuinfo= JSONArray.fromObject(dataG);


        System.out.println("????????????G??????");
        //key ??????????????????input ??????
        JSONObject inputJson = new JSONObject();
        inputJson.put("setlinfo",setlinfo);
        inputJson.put("payinfo",payinfo);
        inputJson.put("opspdiseinfo",opspdiseinfo);
        inputJson.put("diseinfo",diseinfo);
        inputJson.put("iteminfo",iteminfo);
        inputJson.put("oprninfo",oprninfo);
        inputJson.put("icuinfo",icuinfo);

        //key 1~4 ?????? input ?????? ?????? ??? ??????cainfo ??????????????????
        //1 ?????? SM4 ??????
        //String sm4Key = SM4SM2.getSM4Key();
        //2 ??????SM4 ???????????? input????????????
        //String input = SM4SM2.SM4EncryptStr(sm4Key, inputJson.toString());
        //3 ??????SM2 ???SM4??????????????? ?????? cainfo ?????????
        //String cainfo = SM4SM2.SM2EncryptStr(sm4Key,platform.getAppid());

        //key ????????????????????????
        JSONObject resultData = FileUtil.getJsonDate("report15.json");
        // ????????????input ????????????
        Map<String, String> m = DataUtil.getDateTime3();
        String atime = m.get("a").toString();
        String btime = m.get("b").toString();
        resultData.put("inf_time",atime);
        resultData.put("msgid",resultData.getString("msgid")+btime+""+Math.round((Math.random()+1) * 1000));
        //????????????
        resultData.put("input",inputJson);
        // ????????????
        resultData.put("sign_no",platform.getToken());
        // SM4 ??????
        //resultData.put("cainfo",cainfo);

        return resultData;
    }



    //key ????????????
    private void coreMethod15(Integer pid, LinkedHashMap<String, Object> map,
                              DrPlusPlatformDetailed platform, Integer iswrite,
                              String primaeykeyCol) {
        logger.error("??????map:"+map.toString());
        String keyVal = map.get(primaeykeyCol).toString();
        System.out.println("keyVal="+keyVal);
        DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid,keyVal);
        dataType.setReprot_time(DataUtil.getDateTime());

        try {
            //key ??????????????????
            JSONObject dateReport = getDateReport15(keyVal, pid, map,platform);
            //FileUtil.bufferedWriterToFile(dateReport.toString(),"??????.txt");
            if(iswrite==1){
                logger.error("????????????:"+dateReport);
                // logger.info("???????????????:"+jo);
            }
            JSONObject jo = Http.requset(dateReport.toString(), platform.getReport_url());
            if(iswrite==1){
                //logger.info("????????????:"+dateReport);
                logger.error("???????????????:"+jo);
            }
            // 15??????  ???????????? : -1 ??????  0 ??????
            String code = jo.getString("infcode");
            String data = jo.getString("err_msg");
            dataType.setReprot_code(code);
            if("0".equals(code)){
                dataType.setReport_type(1);
                dataType.setReport_content("????????????");
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }else{
                dataType.setReport_type(-1);
                dataType.setReport_content("????????????: "+data);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }
        }catch (Exception e){
            dataType.setReprot_code("-999");
            dataType.setReport_type(-1);
            dataType.setReport_content("??????????????????: "+e.getMessage());
            Integer update = dataTypeDao.updateByPrimaryKey(dataType);
        }
    }




    // 10 ?????? ??????????????????
    private JSONObject getDateReport(String keyVal, Integer pid,LinkedHashMap<String, Object> Adata,DrPlusPlatformDetailed platform) throws Exception {
        //key ????????????????????????
        JSONObject baseinfo = JSONObject.fromObject(Adata);

        //key ??????????????????
        List<String> BColumn = centerTableDao.getReportColumnOnlyName(pid,"b");
        String sqlTxtB = DataUtil.getReportSql(keyVal,pid, "b",BColumn);
        List<LinkedHashMap<String, Object>> dataB = getDataBySql(sqlTxtB);
        JSONArray  diseinfo= JSONArray.fromObject(dataB);

        //key ??????????????????
        List<String> CColumn = centerTableDao.getReportColumnOnlyName(pid,"c");
        String sqlTxtC = DataUtil.getReportSql(keyVal,pid, "c",CColumn);
        List<LinkedHashMap<String, Object>> dataC = getDataBySql(sqlTxtC);
        JSONArray  oprninfo= JSONArray.fromObject(dataC);

        //key ????????????????????????
        List<String> DColumn = centerTableDao.getReportColumnOnlyName(pid,"d");
        String sqlTxtD = DataUtil.getReportSql(keyVal,pid, "d",DColumn);
        List<LinkedHashMap<String, Object>> dataD = getDataBySql(sqlTxtD);
        JSONArray  icuinfo= JSONArray.fromObject(dataD);

        //key ??????????????????input ??????
        JSONObject inputJson = new JSONObject();
        inputJson.put("baseinfo",baseinfo);
        inputJson.put("diseinfo",diseinfo);
        inputJson.put("oprninfo",oprninfo);
        inputJson.put("icuinfo",icuinfo);

        //key 1~4 ?????? input ?????? ?????? ??? ??????cainfo ??????????????????
        //1 ?????? SM4 ??????
        //String sm4Key = SM4SM2.getSM4Key();
        //2 ??????SM4 ???????????? input????????????
        //String input = SM4SM2.SM4EncryptStr(sm4Key, inputJson.toString());
        //3 ??????SM2 ???SM4??????????????? ?????? cainfo ?????????
        //String cainfo = SM4SM2.SM2EncryptStr(sm4Key,platform.getAppid());

        //key ????????????????????????
        JSONObject resultData = FileUtil.getJsonDate("report10.json");
        // ????????????input ????????????
        Map<String, String> m = DataUtil.getDateTime3();
        String atime = m.get("a").toString();
        String btime = m.get("b").toString();
        resultData.put("inf_time",atime);
        resultData.put("msgid",resultData.getString("msgid")+btime+""+Math.round((Math.random()+1) * 1000));
        //????????????
        resultData.put("input",inputJson);
        // ????????????
        resultData.put("sign_no",platform.getToken());
        // SM4 ??????
        //resultData.put("cainfo",cainfo);

        return resultData;
    }

    //key ????????????
    private void coreMethod6( Integer pid,LinkedHashMap<String, Object> map,DrPlusPlatformDetailed platform,Integer iswrite
            ,String PRIMAEYKEYCol  )
    {

        String skey = PRIMAEYKEYCol;
        if(StringUtils.isEmpty(PRIMAEYKEYCol))
            skey = "PRIMAEYKEY";
        //key  ?????? ??????????????????????????? ????????????????????? ????????????
        DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid, map.get(skey).toString());
        dataType.setReprot_time(DataUtil.getDateTime());

        //key ???????????????????????? ??????????????????????????????
        if(StringUtils.isEmpty(PRIMAEYKEYCol))
            map.keySet().removeIf(key -> key.equals("PRIMAEYKEY"));

        try {
            JSONObject jo = RequestUtil.sendOut2(JSONObject.fromObject(map).toString(),platform.getReport_url(),platform.getContent_type(),platform.getToken(),platform.getUseragent());
            if(iswrite==1){
                logger.error("????????????:"+JSONObject.fromObject(map));
                logger.error("???????????????:"+jo);
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
            dataType.setReport_content("??????????????????:"+e.getMessage());
            Integer update = dataTypeDao.updateByPrimaryKey(dataType);
        }
    }


    //TODO ?????????????????? ???????????????????????????  ???????????????????????????????????????????????? ??????,????????????????????????log????????????
    private void coreMethod3( Integer pid,LinkedHashMap<String, Object> map,DrPlusPlatformDetailed platform,Integer iswrite
            ,String PRIMAEYKEYCol )
    {
        String skey = PRIMAEYKEYCol;
         if(StringUtils.isEmpty(PRIMAEYKEYCol))
             skey = "PRIMAEYKEY";
        //key  ?????? ??????????????????????????? ????????????????????? ????????????
        DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid, map.get(skey).toString());
        dataType.setReprot_time(DataUtil.getDateTime());

        //key ???????????????????????? ??????????????????????????????
        if(StringUtils.isEmpty(PRIMAEYKEYCol))
            map.keySet().removeIf(key -> key.equals("PRIMAEYKEY"));
        try {
            //JSONObject jo = RequestUtil.sendOut2(JSONObject.fromObject(map).toString(),platform.getReport_url(),platform.getContent_type(),platform.getToken(),platform.getUseragent());
            LinkedHashMap<String, String> stringStringMap = fileDRGTemplate(map, platform.getPath_file(),platform.getFile_header(),PRIMAEYKEYCol);

            if(iswrite==1){
                logger.error("????????????:"+JSONObject.fromObject(map));
                logger.error("???????????????:"+stringStringMap);
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
            dataType.setRevoke_content("??????????????????:"+e.getMessage());
            Integer update = dataTypeDao.updateByPrimaryKey(dataType);

        }
    }

    //key ????????????
    private void coreMethod5(Integer pid, LinkedHashMap<String, Object> map,
                              DrPlusPlatformDetailed platform, Integer iswrite,
                              String primaeykeyCol) {
        String keyVal = map.get(primaeykeyCol).toString();

        DrPlusDataType dataType = dataTypeDao.getDatabyBah(pid,keyVal);
        dataType.setReprot_time(DataUtil.getDateTime());

        try {
            //key ??????????????????
            Map<String,Object> maps = new LinkedHashMap<>();
            maps.put("APP_ID",platform.getAppid());
            maps.put("ORG_CODE",platform.getOrgcode());
            maps.put("MED_SETTLE_INFO",JSONObject.fromObject(map).toString());

            String dateReport= HttpRequest.post(platform.getReport_url())
                    .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                    .header("Accept", "application/json; charset=UTF-8").form(maps).execute().body();

            if(iswrite==1){
                logger.error("????????????:"+dateReport);
            }

            JSONObject jo = JSONObject.fromObject(dateReport);
            if(iswrite==1){
                logger.error("???????????????:"+jo);
            }
            // 5 ??????  ???????????? : 400 ??????  200 ??????
            String code = jo.getString("CODE");
            dataType.setReprot_code(code);
            if("200".equals(code)){
                dataType.setReport_type(1);
                dataType.setReport_content("????????????");
                String data = jo.getJSONObject("DATA").getString("QDLSH");
                dataType.setRevoke_code(data);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }else{
                String FAILDATA = jo.getJSONObject("FAILDATA").getString("MSG");
                dataType.setReport_type(-1);
                dataType.setReport_content("????????????: "+FAILDATA);
                Integer update = dataTypeDao.updateByPrimaryKey(dataType);
            }
        }catch (Exception e){
            dataType.setReprot_code("-999");
            dataType.setReport_type(-1);
            dataType.setReport_content("??????????????????: "+e.getMessage());
            Integer update = dataTypeDao.updateByPrimaryKey(dataType);
        }
    }


    /**
     * signIn ?????? ???????????????
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

        //?????? signIn???????????? ??????
        JSONObject inputJson = MACIPUtil.getInput(opter);
        //????????????
        //1 ?????? SM4 ??????
        //String sm4Key = SM4SM2.getSM4Key();
        //2 ??????SM4 ???????????? input????????????
        //String input = SM4SM2.SM4EncryptStr(sm4Key, inputJson.toString());
        //3 ??????SM2 ???SM4??????????????? ?????? cainfo ?????????
        //String cainfo = SM4SM2.SM2EncryptStr(sm4Key,key);
        // SM4 ??????
        //resultData.put("cainfo",cainfo);
        resultData.put("inf_time",DataUtil.getDateTime());
        resultData.put("input",inputJson);
        //??????  ????????????
        return resultData;
    }

    //?????? ?????? ??????????????????
    public String startSignIn(JSONObject signInJson,String url,String key,Integer pid) {

        logger.error(LineBreak+"??????????????????:"+signInJson.toString() );
        JSONObject jo = Http.requset(signInJson.toString(),url);
        logger.error(LineBreak+"???????????????:"+jo);
        String output = jo.getString("output");
        //String cainfo_data = jo.getString("cainfo");

        //String sm4Key = SM4SM2.SM2DecryptStr(cainfo_data,key);

        //4.2 ??????????????????SM4?????? ??????SM4 ??????????????????
        //String s = SM4SM2.SM4DecryptStr(sm4Key, output);

        // signinoutb?????????  sign_no ??????????????????
        String sign_no = JSONObject.fromObject(output).getJSONObject("signinoutb").getString("sign_no");
        return sign_no;
    }

    /**
     *  ??????
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
        //?????? signOut???????????? ??????
        JSONObject signOutJson = new JSONObject();
        signOutJson.put("sign_no",sign_no);
        signOutJson.put("opter_no",opter_no);
        JSONObject inputJson = new JSONObject();
        inputJson.put("signOut",signOutJson);
        //????????????
        //key 1~4 ?????? input ?????? ?????? ??? ??????cainfo ??????????????????
        //1 ?????? SM4 ??????
        //String sm4Key = SM4SM2.getSM4Key();
        //2 ??????SM4 ???????????? input????????????
        //String input = SM4SM2.SM4EncryptStr(sm4Key, inputJson.toString());
        //3 ??????SM2 ???SM4??????????????? ?????? cainfo ?????????
        //String cainfo = SM4SM2.SM2EncryptStr(sm4Key,key);
        // SM4 ??????
        //resultData.put("cainfo",cainfo);
        resultData.put("inf_time",DataUtil.getDateTime());
        resultData.put("input",inputJson);
        //??????  ????????????
        return resultData;
    }

    public String startSignOut(JSONObject signOutJson,String url,String key) {
        JSONObject jo = Http.requset(signOutJson.toString(),url);

        String output = jo.getString("output");
        //String cainfo_data = jo.getString("cainfo");

        //String sm4Key = SM4SM2.SM2DecryptStr(cainfo_data,key);

        //4.2 ??????????????????SM4?????? ??????SM4 ??????????????????
        //String s = SM4SM2.SM4DecryptStr(sm4Key, output);
        // signinoutb?????????  sign_no ??????????????????
        String sign_time = JSONObject.fromObject(output).getJSONObject("signoutoutb").getString("sign_time");
        return sign_time;
    }




}



