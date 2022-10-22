package com.dlong.util;


import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.dlong.data.DbzData;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.codec.binary.Base64;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class DataUtil   {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        //第一步 开始登录平台
        int i =1;
        JSONObject jsonObject = startLogin();
        Boolean flag = !(jsonObject.getStr("message")==null);
        while (flag && i<10){
            System.out.println("警告: 第 "+i+" 次识别失败....");
            jsonObject =startLogin();
            flag = !(jsonObject.getStr("message")==null);
            i++;
        }
        System.out.println("报告:登录平台成功!!!");

        /**
         * key 注意 2~4步骤 顺序可以调换
         *
         *    1、java 文件有lombok 插件中的@Data是使用IDEA这种开发工具编译器实现的get/set方法的动态写入,故此 需要开发人员将 get/set方法写入
         *    如有需要可以动态生成@data中的 equals()/hashCode()方法
         *    2、不管java文件 还是json/html文件 生成的路径需要注意, 本代码采用的是相对路径方法生成文件
         *    需要开发人员将生成的相关文件放到jar包反编译(解压)时候的存放路径 .文件路径一定要对映好
         *    3、由于本项目属于小工具类型,没有web前端的页面,所有执行消息都会回显到控制台上,为了减小小工具的体积,以及技术性的考虑
         *    本系统,采用最原始的JDBC 链接数据库,采用JDBC原生的方法执行sql脚本语句,这里需要开发人员注意,返回数据怎么获取数据,
         *    数据没有框架自动映射成实体entity的映射功能,纯属简单的java工具包
         *
         *
         */
        //第二步: 生成前端文件
        String token = JSONUtil.parseObj(jsonObject.getStr("object")).getStr("token");
        DbzData.testInitJson(token);
        System.out.println("报告: 前端文件生成完成!!!");
        //第三步 entity下的*.java 文件,以及sql

        //第四部: 执行需要更新的sql脚本

        //第三步 :动态更新单病种的jar包
        ExecCMDDos.execCMDAll();



    }






    public static JSONObject startLogin() throws  Exception{
        //登录国家单病种平台,通过Tess4J 识别验证码 ,获取 凭条SESSIONID 和 JSON 数据
        //key 由于图片识别验证码准确率非100% 这里可以通过HttpResponse返回JSON数据判断是否登录成功,不成功,通过Scanner 断点回车 循环执行
        JSONObject jsonObj = getImage();
        getFile(jsonObj.getStr("image"), "./imageCode.png");
        JSONObject jsonObject = OCRTest("./imageCode.png", jsonObj);
        JSONObject jsonObject1 = requestDataTest(jsonObject);

        return  jsonObject1 ;
    }

    public static void runProduct() throws Exception {



        //
        ExecCMDDos.execCMD("javac -encoding UTF-8  -Djava.ext.dirs=./lib -d   ./BOOT-INF/classes  ./entity/*.java");
        System.out.println("回车继续");

        //替换class文件
        ExecCMDDos.execCMD("jar uf ./lib/sd.jar ./BOOT-INF/classes/com/sxdl/sd/entity/*.class");

        System.out.println("完成操作");


    }


    /**
     * 登录
     * @param object
     * @return
     * @throws Exception
     */
    public static JSONObject requestDataTest(JSONObject object ) throws Exception{
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
        JSONObject jsonObject = JSONUtil.parseObj(requestBody);
        //System.out.println(requestBody);
        return jsonObject;
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
        // System.out.println("验证码:"+str);
        object.set("image",str);
        return object;
    }


}
