package com.sxdl.drplus.util;

import cn.hutool.http.HttpRequest;
import net.sf.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class RequestUtil {


    /**
     *
     * request.body(json)  与 request.form(json)   源码分析，底层都是使用的java.net.* 包，默认使用的是body。如果body没有数据才开始查询form中的数据
     *
     *  一般情况中：如果他们只要一个json 对象，一般上报的使用body就可以
     *             form ：针对多个参数的情况下，可以使用map吧一个一个参数封装 放到form中--一般使用的contentType( application/x-www-form-urlencoded;charset=UTF-8)
     *                     使用form表单提交一般是他们的接口是分开的几个参数比如
     *                     这样就用map分装放到form中去
     *                     mainMethod(String sss,String eee ,String ddd)
     *
     * 病案上报发送接口
     * @param jsonStr  要求：只有一个对象json：{"id":1,"name":"张三"}  ，里面的key必须是全小写，字段有有null值的可不传
     * @return  返回结果JsonObect对象中的key：code、message、data
     *
     * hostUrl:http://10.44.122.28/sjcjpt/api/v1/settlementList/medicalRecordInfo
     * contentType：application/json; charset=utf-8
     * token:da37c87e039f0c29e35290f767ee90ae
     */
    public static JSONObject sendOut(String jsonStr,String hostUrl,String outTime ,String contentType,String token){
        String requestBody= HttpRequest.post(hostUrl)
                            //.timeout(Integer.parseInt(outTime))
                            .contentType(contentType)
                             .header("access-token", token).body(jsonStr).execute().body();

        JSONObject jsonObject =  JSONObject.fromObject(requestBody);
        return  jsonObject;
    }

    public static JSONObject sendOut2(String map,String hostUrl ,String contentType,String token,String user_agent) throws  Exception{

        String requestBody= HttpRequest.post(hostUrl)
                .contentType(contentType).header("user-agent",user_agent)
                .header("access-token", token).body(map).execute().body();
        //System.out.println("requestBody输出:"+requestBody);
        //DataUtil.bufferedWriterToFile(map);
        JSONObject jsonObject =  JSONObject.fromObject(requestBody);
        return  jsonObject;
    }




    /**'
     * 单病种上报
     */
    public static JSONObject sentOutSd(String jsonStr, String hostUrl, String contentType){
        String requestBody= HttpRequest.post(hostUrl)
                //.timeout(Integer.parseInt(outTime))
                .contentType(contentType)//.setChunkedStreamingMode(0)
                .body(jsonStr).execute().body();
        JSONObject jsonObject =JSONObject.fromObject(requestBody);

        return  jsonObject;
    }


    public static String requestData(LinkedHashMap<String,Object> map, String username,
                                     String passwd, String url, String methodname, String version) throws Exception{
        // 加工上报数据
        map.put("username",username);
        map.put("passwd",passwd);
        map.put("version",version);
        map.put("methodname",methodname);
        String requestBody= HttpRequest.post(url)
                .form(map).execute().body();
        return requestBody;
    }


    public static JSONObject sendOutPID(String type, String hostUrl,String contentType,
                                     String accept,String appId ,String orgCode ,
                                         LinkedHashMap<String,Object>  map) throws Exception {
        String requestBody = "";
        Map<String,Object> maps = new LinkedHashMap<>();
        if("5".equals(type) ){//5 DIP注册 6 DIP上报 7 DIP冲销
         requestBody= HttpRequest.post(hostUrl)
                    .contentType(contentType)
                    .header("Accept", accept).form(map).execute().body();
        }else if("6".equals(type)){
            maps.put("APP_ID",appId);
            maps.put("ORG_CODE",orgCode);
            maps.put("MED_SETTLE_INFO",JSONObject.fromObject(map).toString());
            requestBody= HttpRequest.post(hostUrl)
                    .contentType(contentType)
                    .header("Accept", accept).form(maps).execute().body();
        }
        JSONObject jsonObject =  JSONObject.fromObject(requestBody);
        return  jsonObject;
    }

    //DIP数据撤销 7 DIP冲销
    public static JSONObject sendOutPID7(String hostUrl,String contentType,
                                        String accept,String appId ,String orgCode ,
                                        String qdlsh) throws Exception   {
        Map<String,Object> maps = new LinkedHashMap<>();
        maps.put("APP_ID",appId);
        maps.put("ORG_CODE",orgCode);
        maps.put("YLJGDM",orgCode);
        maps.put("QDLSH",qdlsh);
        String requestBody= HttpRequest.post(hostUrl)
                .contentType(contentType)
                .header("Accept", accept).form(maps).execute().body();
        JSONObject jsonObject =  JSONObject.fromObject(requestBody);
        return jsonObject;
    }



}
