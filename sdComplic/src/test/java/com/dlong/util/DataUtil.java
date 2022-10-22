package com.dlong.util;


import java.io.*;
import java.util.LinkedHashMap;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.codec.binary.Base64;


public class DataUtil   {

    public static void main(String[] args) throws Exception {


        JSONObject jsonObj = getImage();
        getFile(jsonObj.getStr("image"),"C:\\Users\\HP\\Desktop\\11.png");
        JSONObject jsonObject = OCRTest("C:\\Users\\HP\\Desktop\\11.png", jsonObj);
        requestDataTest(jsonObject);



    }

    public static String requestDataTest( ) throws Exception{
        // 加工上报数据
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("announcementType","CACC");
        String requestBody= HttpRequest.post("https://quality.ncis.cn/drgsgateway/findByAnnouncementType")
                .header("Authorization","3c1ff4b2-c82b-4633-9af2-9abbc87a9f00")
                .header("Connection","keep-alive")
                .header("Cookie","JSESSIONID=3c1ff4b2-c82b-4633-9af2-9abbc87a9f00")
                .header("Host","quality.ncis.cn")
                .header("Referer","https://quality.ncis.cn/report-disease/drgs-detail?diseaseType=CACC&num=form-47&type=1&check=false")
                .contentType("application/x-www-form-urlencoded")
                .form(map).execute().body();
        return requestBody;
    }

    /**
     * 登录
     * @param object
     * @return
     * @throws Exception
     */
    public static String requestDataTest(JSONObject object ) throws Exception{
        // 加工上报数据

        String code = object.getStr("image");
        String sessionId = object.getStr("sessionId");
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("loginName","+SAcXzja+tT1eSXgpVCabQ==");
        map.put("password","OfWzEfQO87cdtlfM7cujgw==");
        map.put("code",code);
        map.put("JSESSIONID",sessionId);
        String requestBody= HttpRequest.post("https://quality.ncis.cn/drgsgateway/initLogin")
                .header("Authorization",sessionId)
                //.header("Connection","keep-alive")
                .header("Cookie","JSESSIONID="+sessionId)
                .header("Host","quality.ncis.cn")
                .header("Referer","https://quality.ncis.cn/platform-home")
                .contentType("application/x-www-form-urlencoded")
                .form(map).execute().body();
        System.out.println(requestBody);
        return requestBody;
    }

    /**
     * 通过HTTP请求获取 Base64密文验证码 和SessionId 信息
     * @return
     */
    public static JSONObject getImage(){
        String requestBody= HttpRequest.get("https://quality.ncis.cn/drgsgateway/getImage")
                .header("Referer","https://quality.ncis.cn/platform-home")
                .execute().body();
        JSONObject jsonObject = new JSONObject(requestBody);
        JSONObject object = jsonObject.getJSONObject("object");
        return object;
    }

    /***
     *   将DateURl 转换成文本数据
     */
    public static void getFile( String src,  String filePath) {
        byte[] imageData = Base64.decodeBase64(src);
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {

            file = new File(filePath );
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(imageData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    //图片识别
    public static  JSONObject OCRTest(String file,JSONObject object) throws Exception {
        ITesseract instance = new Tesseract();
        //如果未将tessdata放在根目录下需要指定绝对路径
        //instance.setDatapath("the absolute path of tessdata");
        //如果需要识别英文之外的语种，需要指定识别语种，并且需要将对应的语言包放进项目中
        //instance.setLanguage("chi_sim");
        // 指定识别图片
        File imgDir = new File(file);
        //instance.setDatapath("C:\\ProgramFiles(x86)\\Tesseract-OCR\\tessdata");//设置训练库的位置


        String ocrResult = instance.doOCR(imgDir);
        String str = ocrResult.substring(0, 4);
        // 输出识别结果
        System.out.println("验证码:"+str +"  看看跟生成的一样");
        object.set("image",str);
        return object;
    }


}
