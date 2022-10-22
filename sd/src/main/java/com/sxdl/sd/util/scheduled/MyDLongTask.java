//package com.sxdl.sd.util.scheduled;
//
//import cn.hutool.http.Header;
//import cn.hutool.http.HttpRequest;
//import cn.hutool.http.HttpResponse;
//import com.alibaba.fastjson.JSONArray;
//import com.sxdl.base.util.BaseMailUtil;
//import com.sxdl.sd.dbo.SdRz;
//import net.sf.json.JSONObject;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.*;
//
//@Component(value = "dataTask")
//public class MyDLongTask {
//
//    String urlEmile;
//    HttpResponse response;
//    public static final String LineBreak = "\r\n";
//
//
//    public void doTask() throws IOException, InterruptedException  {
//        tt();
//    }
//    public void tt() throws IOException, InterruptedException {
//        urlEmile="https://quality.ncis.cn/drgsgateway/findAllSystemAnnouncement" ;
//        Map<String, Object> data = new HashMap<String, Object>();
//        data.put("pageNum", 1);
//        data.put("pageSize", 10);
//        data.put("noticeType", 0);
//        data.put("importantFlag", 0);
//        response= HttpRequest.post(urlEmile).form(data)
//                .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded")
//                .header(Header.HOST, "quality.ncis.cn")
//                .header(Header.REFERER, "https://quality.ncis.cn/platform-announcement?routeName=%E5%B9%B3%E5%8F%B0%E9%80%9A%E7%9F%A5")
//                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36")
//                .header(Header.AUTHORIZATION, "undefined")
//                .timeout(20000)//超时，毫秒
//                .execute();
//        if(!response.isOk()||response.body().length()<30){
//            System.out.println(response.body());
//            return;
//        }else{
//            String body = response.body();
//            JSONObject jsonObject =JSONObject.fromObject(body);
//            System.out.println(jsonObject);
//            Object result = jsonObject.get("result");
//            JSONObject jsonObject1 = JSONObject.fromObject(result);
//            Object sysAnnouncement = jsonObject1.get("sysAnnouncement");
//            List<SdRz> list = com.alibaba.fastjson.JSONObject.parseArray(JSONArray.toJSONString(sysAnnouncement), SdRz.class);
//            StringBuilder sb=new StringBuilder();
//            list.forEach(e->{
//                sb.append(e.getAnnouncementDate()).append(" ").append(e.getAnnouncementTitle()).append(LineBreak);
//                //sdList.add(e.getAnnouncementDate()+" "+e.getAnnouncementTitle());
//            });
//            Collection<String> tos=new ArrayList<>();
//            tos.add("孙有志<1301040901@qq.com>");
//            tos.add("赵东<502658195@qq.com>");
//            tos.add("续懿媛<1559715677@qq.com>");
//            BaseMailUtil.sendEmail(tos,"单病种平台更新",sb.toString());
//        }
//    }
//}
