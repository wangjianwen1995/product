package com.dlong.data;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbzData {

    private static Statement statement = null;


    public static Statement getStatement(){
        if (statement!=null){
            return statement;
        }
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=ybjsqd";
        String username="sa";
        String password="sa";
        Connection connection =null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return statement;
    }





    public static void testInitJson(String sessionStr) throws Exception {
         new DbzData().spider(sessionStr);
         System.out.println("前端文件生成成功!!!");
    }



    public static void back_db() throws Exception {
        String truncate_sql = "IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sd_info_column_old_bak]') AND type in (N'U'))\n" +
                "DROP TABLE [dbo].[sd_info_column_old_bak]";
        getStatement().executeUpdate(truncate_sql );
        String sql = "select * into sd_info_column_old_bak from sd_info_column where 1=1";
        getStatement().executeUpdate(sql );
    }


    public void spider(String auth) throws IOException, InterruptedException {
        List<SdInfoInit> list = init();
        for (SdInfoInit sii : list) {
            spiderAndCreat(sii.getName(), sii.getDetail(), sii.getId(), auth);

            System.out.println(sii.getId() + "  " + sii.getName() + "  " + sii.getAbbr() + " " + sii.getDetail());
        }

    }

    public void spiderAndCreat(String jsonName, String pageName, Integer id, String auth) throws IOException, InterruptedException {
        String path = System.getProperty("user.dir");
        String urlJosn = "https://quality.ncis.cn/drgsgateway/getTemplateObject?diseaseType=" + jsonName + "&version=";
        String urlPage = "https://quality.ncis.cn/static/drgs/" + pageName + ".html?diseaseType=" + jsonName + "&num=" + pageName + "&diseaseId=undefined&check=false&type=1&back=undefined&version=undefined";
        String urlJsonGG = "https://quality.ncis.cn/drgsgateway/findByAnnouncementType";
        HttpResponse response = HttpRequest.get(urlJosn)
                .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded")
                .header(Header.HOST, "quality.ncis.cn")
                .header(Header.REFERER, "https://quality.ncis.cn/static/drgs/" + pageName + ".html?diseaseType=" + jsonName + "&num=" + pageName + "&diseaseId=undefined&check=false&type=1&back=undefined&version=undefined")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3861.400 QQBrowser/10.7.4313.400")
                .header("X-Requested-With", "XMLHttpRequest")
                .header(Header.AUTHORIZATION, auth)
                .timeout(200000)//超时，毫秒
                .execute();
        duelRespose(response, path+"/BOOT-INF/classes/static/sd/js/json/", ".json", id, jsonName, false);
        //TODO 这块的json文件没有爬取出俩,需要验证下这块的数据方法
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("announcementType", jsonName);
        response = HttpRequest.post(urlJsonGG)
                .header("Authorization", auth)
                .header("Connection", "keep-alive")
                .header("Cookie", "JSESSIONID="+auth)
                .header("Host", "quality.ncis.cn")
                .header("Referer", "https://quality.ncis.cn/report-disease/drgs-detail?diseaseType=" + jsonName + "&num=" + pageName + "&type=1&check=false")
                .contentType("application/x-www-form-urlencoded")
                .form(map)
                .timeout(200000)//超时，毫秒
                .execute();
        duelRespose(response, path+"/new/ggs/", "GG.json", id, jsonName, false);
        response = HttpRequest.get(urlPage)
                .header(Header.REFERER, "https://quality.ncis.cn/report-disease/drgs-detail?diseaseType=" + jsonName + "&num=" + pageName + "&type=1&check=false")
                .header("Upgrade-Insecure-Requests", "1")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3861.400 QQBrowser/10.7.4313.400")
                .timeout(200000)//超时，毫秒
                .execute();
        duelRespose(response, path+"/BOOT-INF/classes/static/sd/drgs/", ".html", id, pageName, true);
    }



    public void duelRespose(HttpResponse response, String filePath, String sufPath, int id, String jsonName, boolean ispage) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (null == response) {
            return;
        }
        if (!response.isOk()) {
            System.out.println(id + " " + jsonName + " 接口报错!");
            return;
        } else if (response.body().length() < 30) {
            System.out.println(response.body());
            return;
        } else {
            if (ispage) {
                filePath += jsonName+sufPath;
            } else {
                if (0 < id && id < 10) {
                    filePath = filePath + "0" + id + sufPath;
                } else {
                    filePath = filePath + id + sufPath;
                }
            }
            response.writeBody(filePath);
        }

    }


    public static List<SdInfoInit> init() {
        List<SdInfoInit> list = new ArrayList<>();
        list.add(new SdInfoInit(1, "STEMI", "STEMI", 1, "form-1"));
        list.add(new SdInfoInit(2, "HF", "HF", 1, "form-2"));
        list.add(new SdInfoInit(3, "CABG", "CABG", 1, "form-7"));
        list.add(new SdInfoInit(4, "AF", "AF", 1, "form-32"));
        list.add(new SdInfoInit(5, "AVR", "AVR", 1, "form-29"));
        list.add(new SdInfoInit(6, "MVR", "MVR", 1, "form-24"));
        list.add(new SdInfoInit(7, "ASD", "ASD", 1, "form-30"));
        list.add(new SdInfoInit(8, "VSD", "VSD", 1, "form-31"));

        list.add(new SdInfoInit(9, "STK", "STK", 1, "form-3"));
        list.add(new SdInfoInit(10, "TIA", "TIA", 1, "form-8"));
        list.add(new SdInfoInit(11, "ICH", "ICH", 1, "form-26"));
        list.add(new SdInfoInit(12, "MEN", "MEN", 1, "form-25"));
        list.add(new SdInfoInit(13, "GLI", "GLI", 1, "form-27"));
        list.add(new SdInfoInit(14, "PA", "PA", 1, "form-28"));
        list.add(new SdInfoInit(15, "aSAH", "aSAH", 1, "form-23"));
        list.add(new SdInfoInit(16, "CSE", "CSE", 1, "form-22"));
        list.add(new SdInfoInit(17, "PD", "PD", 1, "form-21"));

        list.add(new SdInfoInit(18, "Cap-Adult", "CAP", 1, "form-13"));
        list.add(new SdInfoInit(19, "Cap", "CAP2", 1, "form-4"));
        list.add(new SdInfoInit(20, "AECOPD", "AECOPD", 1, "form-10"));
        list.add(new SdInfoInit(21, "CAC", "CAC", 1, "form-19"));
        list.add(new SdInfoInit(22, "CACC", "CAC2", 1, "form-47"));

        list.add(new SdInfoInit(23, "Hip", "THR", 1, "form-5"));
        list.add(new SdInfoInit(24, "Knee", "TKR", 1, "form-6"));
        list.add(new SdInfoInit(25, "DDH", "DDH", 1, "form-52"));

        list.add(new SdInfoInit(26, "CS", "CS", 1, "form-12"));
        list.add(new SdInfoInit(27, "DG", "EP", 1, "form-20"));
        list.add(new SdInfoInit(28, "UM", "UM", 1, "form-34"));

        list.add(new SdInfoInit(29, "LC", "LC", 1, "form-16"));
        list.add(new SdInfoInit(30, "TC", "TC", 1, "form-14"));
        list.add(new SdInfoInit(31, "BC", "BC", 1, "form-15"));
        list.add(new SdInfoInit(32, "GC", "GC", 1, "form-33"));
        list.add(new SdInfoInit(33, "CC", "CC", 1, "form-42"));
        list.add(new SdInfoInit(34, "CoC", "CoC", 1, "form-43"));

        list.add(new SdInfoInit(35, "DKD", "DKD", 1, "form-46"));
        list.add(new SdInfoInit(36, "HD", "ESRD-HD", 1, "form-44"));
        list.add(new SdInfoInit(37, "DPD", "ESRD-PD", 1, "form-45"));

        list.add(new SdInfoInit(38, "TSCC", "TSCC", 1, "form-40"));
        list.add(new SdInfoInit(39, "PT", "PT", 1, "form-41"));
        list.add(new SdInfoInit(40, "OIT", "OIT", 1, "form-51"));

        list.add(new SdInfoInit(41, "PACG", "PACG", 1, "form-39"));
        list.add(new SdInfoInit(42, "RD", "RD", 1, "form-38"));

        list.add(new SdInfoInit(43, "PIP", "PIP", 1, "form-18"));
        list.add(new SdInfoInit(44, "DVT", "DVT", 1, "form-17"));
        list.add(new SdInfoInit(45, "HBIPS", "HBIPS", 1, "form-9"));
        list.add(new SdInfoInit(46, "VTE", "VTE", 1, "form-36"));
        list.add(new SdInfoInit(47, "SEP", "SEP", 1, "form-35"));
        list.add(new SdInfoInit(48, "ALL", "ALL", 1, "form-48"));
        list.add(new SdInfoInit(49, "APL", "APL", 1, "form-49"));
        list.add(new SdInfoInit(50, "TN", "TN", 1, "form-37"));
        list.add(new SdInfoInit(51, "HBV", "HBV", 1, "form-50"));
        return list;
    }

}
