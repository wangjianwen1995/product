package com.sxdl.product.dc.util;


import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sxdl.base.util.StringUtil;

import java.util.*;

public class WebPostUtil {

    public static final String LineBreak = "\r\n";
    public static final String Tab = "\t";


    /***
     *   post 纯url 方式访问接口
     * @param url      路径
     * @param contentType    平台返回类型
     * @param reqbody        请求体信息
     * @return
     */
    public static HttpResponse getResponse(String url, String contentType, String reqbody) {
        HttpResponse response = null;

        if ("".equals(reqbody) || null == reqbody) {
            response = HttpRequest.post(url).timeout(30000).contentType(contentType).execute();
        } else {
            response = HttpRequest.post(url).timeout(30000).body(reqbody).contentType(contentType).execute();
        }
        // System.out.println(url);
        return response;
    }


    /**
     * 返回类型是json字符串 处理数据转换成 JSONArray对象
     *
     * @param httpResponse
     * @return
     */
    public static JSONArray getJsonArray(HttpResponse httpResponse, String analysisNode) {
        String body = httpResponse.body();
        JSONObject jsonObject = JSONUtil.parseObj(body);
        // 不确定json 格式情况下暂时不做处理
        //body = body.substring(body.indexOf("["),body.indexOf("]")+1);
        JSONArray jsonArray = JSONUtil.parseArray(jsonObject.get(analysisNode));
        return jsonArray;
    }


    /***
     *
     * @param httpResponse
     * @return 返回 字段名称（keys）  对象字符串
     * @throws Exception
     */
    public static Set<String> getJsonColumns(HttpResponse httpResponse, String analysisNode) throws Exception {
        Set<String> set = new HashSet<>();
        JSONObject jsonObject;
        if (JSONUtil.isJsonObj(httpResponse.body())) {
            jsonObject = new JSONObject(httpResponse.body());
        } else {
//            System.out.println("非jsonObject数据");
            return set;
        }
        JSONArray jsonArray;
        if (JSONUtil.isJsonArray(jsonObject.get(analysisNode).toString())) {
            jsonArray = JSONUtil.parseArray(jsonObject.get(analysisNode));
        } else {
//            System.out.println("非jsonArray数据");
            return set;
        }
        JSONObject object;
        if (jsonArray.size() > 0 && JSONUtil.isJsonObj(jsonArray.getJSONObject(0).toString())) {
            object = jsonArray.getJSONObject(0);
        } else {
//            System.out.println("没有返回数据");
            return set;
        }
        if (object.size() > 0) {
            set = object.keySet();
        }
        return set;
        /*JSONArray jsonArray = getJsonArray(httpResponse,analysisNode);
        JSONObject object = jsonArray.getJSONObject(0);
        Set<String> set = object.keySet();
        return set;*/
    }


    /***
     *  解析不规范的json 数据
     * @param httpResponse
     * @return 返回 字段名称（keys）  对象字符串
     * @throws Exception
     */
    public static Set<String> getJsonColumnsNOStandard(HttpResponse httpResponse) throws Exception {

        Set<String> set = new HashSet<>();
        JSONArray jsonArray = parseArray(httpResponse.body());
        if (null == jsonArray || jsonArray.size() == 0) {
            //System.out.println("jsonArray没有数据");
            return set;
        }
       /* FileWriter fileWriter =new  FileWriter(new File("E:\\sss.txt"));
        fileWriter.write(jsonArray.toString());
        fileWriter.flush();
        fileWriter.close();*/
        JSONObject object = new JSONObject();
        if (JSONUtil.isJsonObj(jsonArray.getJSONObject(0).toString())) {
            object = jsonArray.getJSONObject(0);
        }

        if (object.size() > 0) {
            set = object.keySet();
        }
        return set;
        /*JSONArray jsonArray = getJsonArray(httpResponse,analysisNode);
        JSONObject object = jsonArray.getJSONObject(0);
        Set<String> set = object.keySet();
        return set;*/
    }


    public static JSONArray parseArray(String body) throws Exception {
        String str = "";
        if (body.contains("[{") && body.contains("}]")) {
            str = body.substring(body.indexOf("[{"), body.indexOf("}]") + 2);
        }
        // System.out.println("str:"+str);
      /*  FileWriter fileWriter =new  FileWriter(new File("E:\\json.txt"));
        fileWriter.write(str);
        fileWriter.flush();
        fileWriter.close();*/
        JSONArray jsonArray;
        if (JSONUtil.isJsonArray(str)) {
            jsonArray = JSONUtil.parseArray(str);
        } else {
            jsonArray = new JSONArray();
        }
        return jsonArray;
    }

    /***
     *
     * @param PostBody
     * @param startNodeName     代表开始时间的name（StartTime）
     * @param startNodeValue   传入的开始时间
     * @param endNodeName        代表结束时间的name（EndTime）
     * @param endNodeValue     传入的结束时间
     * @return
     *
    PostBody：StartTime=2020-02-01&EndTime=2020-02-20&Hospotial=0001
    NewBody: StartTime=2020-10-01&EndTime=2020-10-02&Hospotial=0001
     */
    public static String getRequestBodyOfTime(String PostBody, String startNodeName, String startNodeValue, String endNodeName, String endNodeValue) {
        int i = PostBody.indexOf(startNodeName) + startNodeName.length() + 1;
        int j = PostBody.indexOf(endNodeName) + 1 + endNodeName.length();
        if (PostBody.contains("\"")) {
            String temp = PostBody.substring(PostBody.indexOf(startNodeName), PostBody.length() - 1);
            int i1 = temp.indexOf(":", 1);
            int i2 = temp.indexOf("\"", 1);
            int i3 = i2 - i1;
            i += i3;
            j += i3;
        }
        String OldStartTime = PostBody.substring(i, i + startNodeValue.length());
        String OldEndTime = PostBody.substring(j, j + endNodeValue.length());
        return PostBody.replace(OldStartTime, startNodeValue).replace(OldEndTime, endNodeValue);

    }


    /**
     * 规定 格式为
     *
     * @param reqbody
     * @param oleVlaue
     * @param NewValue
     * @return PostBody：blh=524874&Hospotial=0001    Hospotial=0001&blh=524874    Hospotial=0001&blh=5248
     * NewBody: blh=1234586&Hospotial=0001   Hospotial=0001&blh=524847     Hospotial=0001&blh=524844
     */
    public static String getRequestBodyOfBlh(String reqbody, String oleVlaue, String NewValue) {
        return reqbody.replace(oleVlaue, NewValue);

    }


    /**
     * 功能 ：动态url获取response  时间类型的
     * 原因：因为纯post请求中url是可变的
     *
     * @param webReqestBody  请求体
     * @param url            路径
     * @param contentType    contentType
     * @param startNodeName  开始时间的节点名
     * @param startNodeValue 开始时间
     * @param endNodeName    结束时间的节点名
     * @param endNodeValue   结束时间
     * @return
     * @throws Exception
     */
    public static HttpResponse getAutoResponseOfTime(String webReqestBody, String url, String contentType,
                                                     String startNodeName, String startNodeValue,
                                                     String endNodeName, String endNodeValue) {
        String requestBodyOfTime = getRequestBodyOfTime(webReqestBody, startNodeName, startNodeValue, endNodeName, endNodeValue);
        HttpResponse response = getResponse(url, contentType, requestBodyOfTime);
        return response;

    }


    /**
     * 获取时间类型post请求的数据  json数据非格式
     *
     * @param response
     * @param setColumn josn中的key值
     * @return
     */
    public static List<LinkedHashMap<String, String>> getPostDataNoStandard(HttpResponse response, Set<String> setColumn) throws Exception {
        List<LinkedHashMap<String, String>> mapList = new ArrayList<>();
        JSONArray jsonArray = parseArray(response.body());
        if (jsonArray.size() > 0) {
            for (int j = 0; j < jsonArray.size(); j++) {
                LinkedHashMap<String, String> map = new LinkedHashMap<>();
                for (String key : setColumn) {
                    JSONObject jsonObject = jsonArray.getJSONObject(j);
                    String str = jsonObject.getStr(key);
                    map.put(key, str);
                }
                mapList.add(map);
            }
        }
        return mapList;
    }

    /**
     * 获取时间类型post请求的数据
     *
     * @param response
     * @param setColumn josn中的key值
     * @return
     */
    public static List<LinkedHashMap<String, String>> getPostData(HttpResponse response, Set<String> setColumn, String analysisNode) {
        List<LinkedHashMap<String, String>> mapList = new ArrayList<>();
        JSONArray jsonArray = getJsonArray(response, analysisNode);
        if (jsonArray.size() > 0) {
            for (int j = 0; j < jsonArray.size(); j++) {
                LinkedHashMap<String, String> map = new LinkedHashMap<>();
                for (String key : setColumn) {
                    JSONObject jsonObject = jsonArray.getJSONObject(j);
                    String str = jsonObject.getStr(key);
                    map.put(key, str);
                }
                mapList.add(map);
            }
        }
        return mapList;
    }

    /**
     * 晋城检验信息处理数据
     *
     * @param response
     * @param setColumn
     * @param analysisNode
     * @return
     */
    public static Map<String ,List<LinkedHashMap<String, String>>> getPostData10(HttpResponse response, Map<String, Set<String>> setColumn, String analysisNode, String tableName) {
        System.out.println("-**- 开始生成数据包");
        Map<String ,List<LinkedHashMap<String, String>>> resMap =  new HashMap<>();
        List<LinkedHashMap<String, String>> mapList = new ArrayList<>();
        List<LinkedHashMap<String, String>> resultdetailMapList = new ArrayList<>();
        List<LinkedHashMap<String, String>> wswresultdetailMapList = new ArrayList<>();
        List<LinkedHashMap<String, String>> antiresultdetailMapList = new ArrayList<>();


        JSONObject jsonObject = JSONUtil.parseObj(response.body());

        JSONArray jsonArray = JSONUtil.parseArray(jsonObject.get(analysisNode));
        JSONArray jsonArray2,jsonArray3,jsonArray4;
        if (jsonArray.size() > 0) {
            for (int j = 0; j < jsonArray.size(); j++) {
                LinkedHashMap<String, String> map = new LinkedHashMap<>();
                for (String key : setColumn.get(tableName)) {
                    //如果有常规检验信息，则需要处理常规检验信息的结果集
                    if ("resultdetail".equals(key)) {

                        String resultdetailStr = jsonArray.getJSONObject(j).getStr(key);

                        if(StringUtil.isEmpty(resultdetailStr)) continue;
                        jsonArray2 = JSONUtil.parseArray(resultdetailStr);



                        if (jsonArray2.size() > 0) {
                            for (int i = 0; i < jsonArray2.size(); i++) {

                                LinkedHashMap<String, String> resultdetailMap = new LinkedHashMap<>();
                                for (String key1 : setColumn.get("resultdetail")) {

                                    if ("patientid".equals(key1)) {
                                        String str = jsonArray.getJSONObject(j).getStr("patientid");
                                        resultdetailMap.put(key1, str);
                                    } else if ("pubdatetime".equals(key1)) {
                                        String str = jsonArray.getJSONObject(j).getStr("pubdatetime");
                                        resultdetailMap.put(key1, str);
                                    } else {
                                        String str = jsonArray2.getJSONObject(i).getStr(key1);
                                        resultdetailMap.put(key1, str);
                                    }
                                }
                                resultdetailMapList.add(resultdetailMap);
                            }
                        }
                    }
                    //如果有微生物信息，则需要处理微生物的结果集
                    else if ("wswresultdetail".equals(key)) {

                        String str1 = jsonArray.getJSONObject(j).getStr(key);

                        if(StringUtil.isEmpty(str1)) continue;
                        jsonArray3 = JSONUtil.parseArray(str1);

                        if (jsonArray3.size() > 0) {

                            for (int i = 0; i < jsonArray3.size(); i++) {

                                LinkedHashMap<String, String> wswresultdetailMap = new LinkedHashMap<>();
                                for (String key1 : setColumn.get("wswresultdetail")) {

                                    if ("patientid".equals(key1)) {
                                        String str = jsonArray.getJSONObject(j).getStr("patientid");
                                        wswresultdetailMap.put(key1, str);
                                    } else if ("pubdatetime".equals(key1)) {
                                        String str = jsonArray.getJSONObject(j).getStr("pubdatetime");
                                        wswresultdetailMap.put(key1, str);
                                    } else if ("antiresultdetail".equals(key1))
                                    {

                                        String antiresultdetailStr = jsonArray.getJSONObject(j).getStr(key);
                                        if(StringUtil.isEmpty(antiresultdetailStr)) continue;
                                        jsonArray4 = JSONUtil.parseArray(antiresultdetailStr);
                                        if (jsonArray4.size() > 0) {

                                            for (int x = 0; x < jsonArray4.size(); x++) {
                                                LinkedHashMap<String, String> antiresultdetailMap = new LinkedHashMap<>();

                                                for (String key2 : setColumn.get("antiresultdetail")) {
                                                    if ("patientid".equals(key2)) {
                                                        String str = jsonArray.getJSONObject(j).getStr("patientid");
                                                        antiresultdetailMap.put(key2, str);
                                                    } else if ("pubdatetime".equals(key2)) {
                                                        String str = jsonArray.getJSONObject(j).getStr("pubdatetime");
                                                        antiresultdetailMap.put(key2, str);
                                                    } else {
                                                        String str = jsonArray4.getJSONObject(x).getStr(key2);
                                                        antiresultdetailMap.put(key2, str);
                                                    }
                                                }
                                                antiresultdetailMapList.add(antiresultdetailMap);
                                            }
                                        }
                                    }
                                    else {
                                        String str = jsonArray3.getJSONObject(i).getStr(key1);
                                        wswresultdetailMap.put(key1, str);
                                    }

                                }
                                wswresultdetailMap.put("antiresultdetail",null);
                                wswresultdetailMapList.add(wswresultdetailMap);
                            }
                        }
                    }
                    else {

                        JSONObject jsonObject2 = jsonArray.getJSONObject(j);
                        String str = jsonObject2.getStr(key);
                        map.put(key, str);

                    }

                }
                map.put("resultdetail",null);
                map.put("wswresultdetail",null);
                mapList.add(map);
            }
        }
        resMap.put(tableName,mapList);
        resMap.put("resultdetail",resultdetailMapList);
        resMap.put("wswresultdetail",wswresultdetailMapList);
        resMap.put("antiresultdetail",antiresultdetailMapList);
        System.out.println("-**- 结束生成数据包");
        //System.out.println(resMap);
        return resMap;
    }


    public static HttpResponse getAutoResponseOfBlh(String reqbody, String url, String contentType, String OldValue, String NewValue) {
        String requestBodyOfBlh = getRequestBodyOfBlh(reqbody, OldValue, NewValue);
        HttpResponse response = getResponse(url, contentType, requestBodyOfBlh);
        return response;
    }

    public static void main(String[] args) {
        String body;
        if(1==1){
            body ="[{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"★天门冬氨酸氨基转移酶\",\"printorder\":\" 0013\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"酶法\",\"testmethodcode\":\"M098\",\"result\":\"29.3\",\"itemnum\":\"AST\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"U/L\",\"referencerance\":\"15.0～40.0\",\"itemcode\":\"1020060\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"谷草酶：谷丙酶\",\"printorder\":\" 0014\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"计算法\",\"testmethodcode\":\"M054\",\"result\":\"0.7\",\"itemnum\":\"AST/ALT\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"\",\"referencerance\":\"\",\"itemcode\":\"1020070\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"★总胆红素\",\"printorder\":\" 0015\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"重氮法\",\"testmethodcode\":\"M172\",\"result\":\"14.5\",\"itemnum\":\"TBIL\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"umol/L\",\"referencerance\":\"5.0～21.0\",\"itemcode\":\"1020080\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"脂肪酶\",\"printorder\":\" 0033\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"色原底物法\",\"testmethodcode\":\"M196\",\"result\":\"32.0\",\"itemnum\":\"LPS\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"U/L\",\"referencerance\":\"0.0～67.0\",\"itemcode\":\"1060010\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"淀粉酶\",\"printorder\":\" 0034\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"PNP-G7底物法\",\"testmethodcode\":\"M197\",\"result\":\"112.0\",\"itemnum\":\"AMY\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"U/L\",\"referencerance\":\"35.0～135.0\",\"itemcode\":\"1060020\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"C反应蛋白\",\"printorder\":\" 0036\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"免疫比浊\",\"testmethodcode\":\"M103\",\"result\":\"4.2\",\"itemnum\":\"CRP\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"mg/L\",\"referencerance\":\"0.0～10.0\",\"itemcode\":\"1080010\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"★尿素\",\"printorder\":\" 0039\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"酶法\",\"testmethodcode\":\"M098\",\"result\":\"7.65\",\"itemnum\":\"UREA\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"mmol/L\",\"referencerance\":\"1.70～8.30\",\"itemcode\":\"1100010\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"肌酐\",\"printorder\":\" 0040\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"酶法\",\"testmethodcode\":\"M098\",\"result\":\"75.9\",\"itemnum\":\"CRE\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"umol/L\",\"referencerance\":\"50.0～105.0\",\"itemcode\":\"1100020\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"尿素/肌酐\",\"printorder\":\" 0041\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"计算法\",\"testmethodcode\":\"M054\",\"result\":\"0.10\",\"itemnum\":\"UREA/CRE\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"\",\"referencerance\":\"\",\"itemcode\":\"1100030\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"★葡萄糖测定\",\"printorder\":\" 0055\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"己糖激酶法\",\"testmethodcode\":\"M053\",\"result\":\"5.59\",\"itemnum\":\"GLU\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"mmol/L\",\"referencerance\":\"3.90～6.10\",\"itemcode\":\"1140320\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"★钾\",\"printorder\":\" 0001\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"离子选择性电极(间接法)\",\"testmethodcode\":\"M074\",\"result\":\"3.9\",\"itemnum\":\"K\",\"resulttime\":\"2022-06-11 01:06:39\",\"unit\":\"mmol/L\",\"referencerance\":\"3.5～5.3\",\"itemcode\":\"1010010\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"★钠\",\"printorder\":\" 0002\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"离子选择性电极(间接法)\",\"testmethodcode\":\"M074\",\"result\":\"137.0\",\"itemnum\":\"Na\",\"resulttime\":\"2022-06-11 01:06:39\",\"unit\":\"mmol/L\",\"referencerance\":\"137.0～147.0\",\"itemcode\":\"1010020\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"★氯\",\"printorder\":\" 0003\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"离子选择性电极(直接法)\",\"testmethodcode\":\"M075\",\"result\":\"107.3\",\"itemnum\":\"Cl\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"mmol/L\",\"referencerance\":\"99.0～110.0\",\"itemcode\":\"1010030\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"★钙\",\"printorder\":\" 0004\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"偶氮砷 III 法\",\"testmethodcode\":\"M123\",\"result\":\"2.34\",\"itemnum\":\"Ca\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"mmol/L\",\"referencerance\":\"2.11～2.52\",\"itemcode\":\"1010040\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"二氧化碳\",\"printorder\":\" 0005\",\"highlowflag\":\"L\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"碳酸酐酶比色法\",\"testmethodcode\":\"M190\",\"result\":\"20.5\",\"itemnum\":\"CO2\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"mmol/L\",\"referencerance\":\"22.0～30.0\",\"itemcode\":\"1010050\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"★磷\",\"printorder\":\" 0006\",\"highlowflag\":\"L\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"钼酸盐法\",\"testmethodcode\":\"M191\",\"result\":\"0.83\",\"itemnum\":\"P\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"mmol/L\",\"referencerance\":\"0.85～1.51\",\"itemcode\":\"1010060\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"镁\",\"printorder\":\" 0007\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"二甲苯胺蓝\",\"testmethodcode\":\"M031\",\"result\":\"0.87\",\"itemnum\":\"Mg\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"mmol/L\",\"referencerance\":\"0.75～1.02\",\"itemcode\":\"1010070\",\"panicflag\":\"0\"},{\"instcode\":\"42\",\"hintinfo\":\"\",\"itemname\":\"★丙氨酸氨基转移酶\",\"printorder\":\" 0012\",\"highlowflag\":\"\",\"instname\":\"全自动生化分析仪【AU5811】\",\"testmethodname\":\"酶法\",\"testmethodcode\":\"M098\",\"result\":\"40.6\",\"itemnum\":\"ALT\",\"resulttime\":\"2022-06-11 01:06:40\",\"unit\":\"U/L\",\"referencerance\":\"9.0～50.0\",\"itemcode\":\"1020050\",\"panicflag\":\"0\"}]";
        }

        JSONArray jsonArray2 = JSONUtil.parseArray(body);

        System.out.println("123");
    }

    public static Map<String, Set<String>> getJsonColumns10(HttpResponse httpResponse, String analysisNode, String mainTableName) throws Exception {
        Map<String, Set<String>> res = new HashMap<>();
        Set<String> set = new HashSet<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        JSONObject jsonObject;

        if (JSONUtil.isJsonObj(httpResponse.body())) {
            jsonObject = new JSONObject(httpResponse.body());
        } else {
            return new HashMap<>();
        }
        JSONArray jsonArray;
        if (JSONUtil.isJsonArray(jsonObject.get(analysisNode).toString())) {
            jsonArray = JSONUtil.parseArray(jsonObject.get(analysisNode));
        } else {
            return new HashMap<>();
        }
        JSONObject object;
        if (jsonArray.size() > 0 && JSONUtil.isJsonObj(jsonArray.getJSONObject(0).toString())) {
            object = jsonArray.getJSONObject(0);
        } else {
            return new HashMap<>();
        }

        //System.out.println(object);
        if (object.size() > 0) {
            set.addAll(object.keySet());

            if (object.containsKey("resultdetail")) {

                if (JSONUtil.isJsonArray(object.get("resultdetail").toString())) {
                    jsonArray = JSONUtil.parseArray(object.get("resultdetail"));
                    if (jsonArray.size() > 0 && JSONUtil.isJsonObj(jsonArray.getJSONObject(0).toString())) {
                        object = jsonArray.getJSONObject(0);
                        if (object.size() > 0) {
                            set1.addAll(object.keySet());
                            set1.add("patientid");
                            set1.add("pubdatetime");
                        }
                    }

                }

            }
            if (object.containsKey("wswresultdetail")) {
                if (JSONUtil.isJsonArray(object.get("wswresultdetail").toString())) {
                    jsonArray = JSONUtil.parseArray(object.get("wswresultdetail"));
                    if (jsonArray.size() > 0 && JSONUtil.isJsonObj(jsonArray.getJSONObject(0).toString())) {
                        object = jsonArray.getJSONObject(0);
                        if (object.size() > 0) {
                            set2.addAll(object.keySet());
                            set2.add("patientid");
                            set2.add("pubdatetime");
                            if (object.containsKey("antiresultdetail")) {
                                if (JSONUtil.isJsonArray(object.get("antiresultdetail").toString())) {
                                    jsonArray = JSONUtil.parseArray(object.get("antiresultdetail"));
                                    if (jsonArray.size() > 0 && JSONUtil.isJsonObj(jsonArray.getJSONObject(0).toString())) {
                                        object = jsonArray.getJSONObject(0);
                                        if (object.size() > 0) {
                                            set3.addAll(object.keySet());
                                            set3.add("patientid");
                                            set3.add("pubdatetime");
                                        }
                                    }

                                }

                            }
                        }
                    }

                }

            }
        }
        set.add("resultdetail");
        set.add("wswresultdetail");
        if(!set2.isEmpty()) set2.add("antiresultdetail");
        res.put(mainTableName, set);
        res.put("resultdetail", set1);
        res.put("wswresultdetail", set2);
        res.put("antiresultdetail", set3);
        System.out.println("完成表结构");
        return res;
    }



}
