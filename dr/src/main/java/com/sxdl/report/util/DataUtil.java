package com.sxdl.report.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.util.StringUtils;

import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

public class DataUtil {


    public static void main(String[] args) throws  Exception{
        ApplicationRunner s = (args1) -> {System.out.println("爸爸吧");};
        s.run(new DefaultApplicationArguments());
        System.out.println(s);

    }


    public static int bytes2kb(int bytes) {
        BigDecimal filesize = new BigDecimal(bytes);
        BigDecimal megabyte = new BigDecimal(1024 * 1024);
        float returnValue = filesize.divide(megabyte, 2, BigDecimal.ROUND_UP)
                .floatValue();
        if (returnValue > 1)
            return (int) returnValue;
        BigDecimal kilobyte = new BigDecimal(1024);
        returnValue = filesize.divide(kilobyte, 2, BigDecimal.ROUND_UP)
                .floatValue();
        return (int) Math.ceil(returnValue);
    }

    public static void bufferedWriterToFile(String str) throws  Exception{
        File file =new File("d://报文.txt");
        if(!file.getParentFile().exists()){ //判断文件父目录是否存在
            file.getParentFile().mkdirs();  //不存在创建父目录
        }
        if(!file.exists()){ //判断文件是否存在
            file.createNewFile();
        }
            BufferedWriter bw = null;
        if(file.length()>0  &&  DataUtil.bytes2kb((int)file.length())>15){
            //大于10M 清空内容
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
        }else{
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"UTF-8"));
        }
        bw.write(new String(str.getBytes("utf-8"),"utf-8"));
        bw.flush();
        bw.close();
    }


    public static void bufferedWriterToFile2(String str) throws  Exception{
        File file =new File("d://报文.txt");
        if(!file.getParentFile().exists()){ //判断文件父目录是否存在
            file.getParentFile().mkdirs();  //不存在创建父目录
        }
        if(!file.exists()){ //判断文件是否存在
            file.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"UTF-8"));
        bw.write(new String(str.getBytes("utf-8"),"utf-8"));
        bw.flush();
        bw.close();
    }



    public static String stringReplaces(String str){
        String s = str.replaceAll("\\[", "").replaceAll("\\]", "");
        return s;
    }

    /**
     * 将平台返回的数据 封装到map集合中
     * @param xmlstring
     * @return
     * @throws Exception
     */
    public static LinkedHashMap<String,String> responseData(String xmlstring) throws Exception{
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        xmlstring  = "<?xml version=\"1.0\" encoding=\"utf8\"?> " +xmlstring ;
        Document document = DocumentHelper.parseText(xmlstring);
        List<Node> nodeSuccess = document.selectNodes("/system/paras");
        List<Node> nodesError = document.selectNodes("/system/error");
        Node node = null;
        String zybasy01 = null;
        String message =null;
        String error = null;
        if(!StringUtils.isEmpty(nodesError)){
            if(nodesError.size()>0){
                node = nodesError.get(0);
            }
        }

        if(StringUtils.isEmpty(nodeSuccess)){
            if(nodeSuccess.size()>0){
                node = nodeSuccess.get(0);
            }
        }
        Element element = (Element) node;
        zybasy01 = element.attributeValue("zybasy01");
        message = element.attributeValue("message");
        error = element.attributeValue("error");
        map.put("zybasy01",zybasy01);
        map.put("message",message);
        map.put("error",error);
        return map;
    }


}
