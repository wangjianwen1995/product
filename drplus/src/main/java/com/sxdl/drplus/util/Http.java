package com.sxdl.drplus.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class Http {



    //private static final String url = "http://localhost:8097/fsi/api/rsfComIfsService/callService";
    /** 按照报文要求传入JSON格式字符串 */
    // private static final String downInput = "{…}";

    /**
     * key 病案属于 普通交易数据
     * 调用普通交易及文件下载交易
     */
    public static JSONObject requset(String data, String url)  {
        String result = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(10000).build();
        httppost.setConfig(requestConfig);
        ByteArrayEntity entity = new ByteArrayEntity(data.getBytes(StandardCharsets.UTF_8));
        entity.setContentType("text/plain");
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                httppost.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null) {
                result = EntityUtils.toString(responseEntity, "UTF-8");
                System.out.println(result);
            }
            //确保实体内容被完全使用并且内容流（如果存在）被关闭
            EntityUtils.consume(entity);
            return JSONObject.fromObject(result);
        } catch (ClientProtocolException e) {
            throw new RuntimeException("提交给服务器的请求，不符合HTTP协议", e);
        } catch (IOException e) {
            throw new RuntimeException("向服务器承保接口发起http请求,执行post请求异常", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件交互方案可以学习  调用文件上传交易
     */
    public static void requsetStudy() throws Exception{
        String upInput ="";
        File file = new File("testUpload.txt");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("url");
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(10000).build();
        httppost.setConfig(requestConfig);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setCharset(StandardCharsets.UTF_8);
        builder.addTextBody("jsonStr", upInput);
        builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, "testUpload.txt");
        HttpEntity entity = builder.build();
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                httppost.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity responseEntity = response.getEntity();
            String result;
            if (responseEntity != null) {
                //返回字符串
                result = EntityUtils.toString(responseEntity, "UTF-8");
                System.out.println(result);
            }
            EntityUtils.consume(entity);
        } catch (ClientProtocolException e) {
            throw new RuntimeException("提交给服务器的请求，不符合HTTP协议", e);
        } catch (IOException e) {
            throw new RuntimeException("向服务器承保接口发起http请求,执行post请求异常", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
