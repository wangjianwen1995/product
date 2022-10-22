package com.sxdl.sd.controller;


import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.RsaUtil;
import com.sxdl.sd.dbo.DrReprotRecord;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdPatientInfoService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpCookie;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController(value = "sdReportController")
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    String publickey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4u6MNph/FiFx8GJAcs58TAGPCfzv40gJwbY+bpiki9jJ/YwI9VI6xfZQEq1+X4kuEsaxQs6Z4C8AtC34GH5OOuwxElzLVX3ylS0F/Ffl1oETrDmCDBNhDENFKfFhgtfPGhMclSWyP+xpVo4uUEF5T6Z5ktwUI9kOAgFsyzO/C7SertJme7OSyKcl87FQ4dtONXMvAseC/ZarPpi6XARE+lqNE0ceEqfv9YhNRwcbt+6F+2h6Pm1R5y0E+ApTcYOArKPIPxSmCFH4Xx2HZgt+ttBmMVKoBI0sDuY+ZEscHNPU3MAQk3b1Bc2WyS+b7WriggpOP9CeqjL3fBZ9BVGozwIDAQAB";
    String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDi7ow2mH8WIXHwYkByznxMAY8J/O/jSAnBtj5umKSL2Mn9jAj1UjrF9lASrX5fiS4SxrFCzpngLwC0LfgYfk467DESXMtVffKVLQX8V+XWgROsOYIME2EMQ0Up8WGC188aExyVJbI/7GlWji5QQXlPpnmS3BQj2Q4CAWzLM78LtJ6u0mZ7s5LIpyXzsVDh2041cy8Cx4L9lqs+mLpcBET6Wo0TRx4Sp+/1iE1HBxu37oX7aHo+bVHnLQT4ClNxg4Cso8g/FKYIUfhfHYdmC3620GYxUqgEjSwO5j5kSxwc09TcwBCTdvUFzZbJL5vtauKCCk4/0J6qMvd8Fn0FUajPAgMBAAECggEAW/4F2u/wvMDsFl1N8PxhiNIs8QiXGlSOl/dP0beRJJvKLj1BOGmQJ8XU6e1oyEOs6LGhFAr6d9W1/FSSOSOihOJQdjgluU9oMi7hOU1Mf6stlWhunoSQl88BT6JpPAhODSzoLlHss1sbzJmwjposGizLJcyPYYTQ1+FKAAnHDW/0ZTSYyqXvxFLQyBqXb3x9VRRIPbwg8qWdVZXFLM1DeTK8EPqN5jvFy2n1ev86+MiIzekfsXP3wL3F7fHJhi1jwGy0BVygGqgWplwhHWlCoaqfYjG2ZghETIcRBUEFZjLxOOy4d6kITHSgw6uF8BNrNI8PTC/K81gVGcHLmYtYQQKBgQDxOSThOE+DIiZQ9DANEpYVt9RAYCV1Awn3TpVtQIkeq+48s4X21u//AD4BSNEcCdEEqWr/y6PGjsBhHTXqbegeFO+KaFAtNlVuU9ZHx+EPwJKEh67VDQp7iUeLRaqBAdthYMwJVl9aEiH5PtA2u7qHN3OmxaJK/wf3HIyzZkPcIQKBgQDw1UlTR2R2O5/lw/hU+Hv+V21o27uEGWEjfeR/RszjqMI8WmkBEStGQR5POLRO1Inu/jwO8/1/7fXq+x9sDL4kli1cqfah7zXtqp8f17pKAistcSmOfutEGXiuKeQ3KwpDmC/zbF8OhYClcuWDW9LhNoEl48f7PNNeBH0QigJm7wKBgDgglL02zgF0I7g4aSnRhkx9XoywEmcckugRR+GI357cYG2NVAFwV51c4BCKceV1P0Y3aWclafEcbBTsqAvpENZXBrmMtgMfHleyeCxxjKOOqkjeDUcTZroB4jy8tASaewI4dKFDkKIzj+YfwHDL04X82BMY7z9GAgN0iCSCCg4hAoGBAI9Vka+D9RG9SNw592my/jERHafj50WmyT6TZdQucjEotnmvIYGmE0hb50slJ4MnUfSw0VPg+UYTfWJeFYR8TQp/av4UlhoowcLy4oPUJCZ6BfKkwCPz+9frBP07J32CGzjBsgBBxo1g/YD60giNNQQfKVxApjwsJmx1ZW3bhbR3AoGAO+vtAqTBKpT3hN89UsOReWbJpb2N32xM4UV1csuSkAx+XN6fTHpraM/dcLVS08qm2tD1fHeHGRXBjJushFeSX4Qauxj2HOZgRybU9JlEFMuwREhCBDw/ySrxyWlcJwQQcsUwex1SdFO1B5YiC1yPwzXPz/ndVDeF3k/Y2gqNSbM=";
    @Value("${drpath}")
    private String drpath;
  /*  @Value("${drrzpath}")
    private String drrzpath;*/
    @Value("${sd_special_id}")
    private String sd_special_id;
    /*
    @Value("${sd_special_column}")
    private String sd_special_column;
    @Value("${sd_special_column}")
    private String sd_default_column;
    @Value("${spring.datasource.secondary.url}")
    private String url;
*/    @Value("${drlink}")
    private String drlink;
    @Value("${user}")
    private String user;
    @Value("${pwd}")
    private String pwd;
    @Value("${drip}")
    private String drip;

    @Autowired
    private SdPatientInfoService sdPatientInfoService;


    @ApiOperation(value = "单病种上报", notes = " 单病种上报")
    @GetMapping("/report1")
    @ResponseBody
    public ResultUtil report1(Integer sid, String starTime, String endTime, String timeColumn) throws SQLException {
           String s="";
        try {
            String RSA = getRSA();
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("sid", sid);
            paramMap.put("starTime", starTime);
            paramMap.put("endTime", endTime);
            paramMap.put("RSA", RSA);
            System.setProperty("sun.net.http.retryPost", "false");
            System.out.println("paramMap:"+paramMap);
            HttpResponse response = HttpRequest.post(drpath)
                    //.header("Connection","Keep-Alive")
                    .timeout(60000).header("Connection", "Keep-Alive")
                    .header("Accept-Encoding", "gzip,deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.9")
                    .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                    .setChunkedStreamingMode(0)
                    .form(paramMap)
                    .execute().sync();

            if (!response.isOk()) {
                return ResultUtil.error("请求未响应" + response.toString());
            }

            String result = response.body();
            if (result.contains("html")) {
                return ResultUtil.error("上报器异常请联系管理员");
            }
            ResultUtil listResultUtil = JSONObject.parseObject(result, ResultUtil.class);
            String state = listResultUtil.getState();
            if (state.equals("error")) {
                return listResultUtil;
            }
            Object t = listResultUtil.getT();
            logger.error("report101");
            List<DrReprotRecord> list = JSONObject.parseArray(JSONArray.toJSONString(t), DrReprotRecord.class);
            logger.error("report102");
            int size = list.size();
            //System.out.println("list"+list);
            int count = (int) list.stream().filter(e -> e != null && !e.getResult_type().equals("1")).count();
            List<SdPatientInfo> sdPatientInfoList = new ArrayList<>();
            setStatus(list, sid);
            logger.error("report103");
            s= toqzj(pwd,user);
            logger.error("report104");
            updatesql();
            int success=size-count;
            return ResultUtil.success(sdPatientInfoList, "本次上传" + size + "条数据,上传成功"+ success +"条数据,上传失败" + count + "条数据,失败原因可查看上报日志"+s);
        } catch (Exception e) {
            if (e.getCause().toString().contains("Connection reset")) {
                 s=toqzj(pwd,user);
                logger.error("异常report101");
                updatesql();
                logger.error("异常report102");
                return ResultUtil.success(s);
            } else {
                logger.error("异常report103"+e.getCause());
                return ResultUtil.error("上报异常请联系管理员" + e.getCause());
            }

        }
    }


    void updatesql(){
        //String dbName = url.split("=")[1];
        String sql = "update sd_patient_info set status=9 from " + drlink + ".dr_reprot_record c inner  join " + drlink + ".dr_dbzinfo d on " +
                "c.template_id=d.templateid AND  result_content='上报成功!' \n" +
                "inner join sd_patient_info s on  c.primarykey=s.patient_code and d.sid=s.sd_info_id and s.status=6";
        //System.out.println(sql);
        sdPatientInfoService.updateSqlWithSQL(sql);
    }

    private List<String> getList(String s, Integer sid) {
        if (s.contains(",")) {
            String[] split = sd_special_id.split(",");
            List<String> strings = Arrays.asList(split);
            strings = strings.stream().filter(e -> null != e && sid == Integer.parseInt(e)).collect(Collectors.toList());
            return strings;
        } else {
            return new ArrayList<>();
        }
    }

    private void setStatus(List<DrReprotRecord> list, Integer sid) {
        List<SdPatientInfo> sdPatientInfoList = new ArrayList<>();
        list.forEach(e -> {
            SdPatientInfo sdPatientInfo1 = new SdPatientInfo();
            sdPatientInfo1.setSd_info_id(sid);
            sdPatientInfo1.setPatient_code(e.getPrimarykey());
            List<String> strings = getList(sd_special_id,sid);
            if (null == strings || strings.size() <= 0) {
                sdPatientInfo1.setCy_time(e.getQuerytime());
            }
            sdPatientInfo1.setStatus(6);
            List<SdPatientInfo> sdPatientInfos = sdPatientInfoService.select(sdPatientInfo1);
            //System.out.println("病人信息" + sdPatientInfos);
            if (sdPatientInfos != null && sdPatientInfos.size() > 0) {
                SdPatientInfo sdPatientInfo = sdPatientInfos.get(0);
                if ((e.getResult_type().equals("1") && e.getResult_content().contains("成功")) ||
                        (e.getResult_type().equals("1000") && e.getResult_content().contains("病案号重复"))) {
                    sdPatientInfo.setStatus(9);
                    sdPatientInfo.setUpload_time(e.getUpload_end_time());
                    sdPatientInfoService.update(sdPatientInfo);
                }
            }
        });
    }


    private String getRSA() {
        String RSA = null;
        SimpleDateFormat simpleDateFormat = null;
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        try {
            RSA = RsaUtil.encrypt(format, publickey);
            String decrypt = RsaUtil.decrypt(RSA, privateKey);
            //System.out.println(decrypt);
            //System.out.println(RSA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RSA;
    }



   /* @ApiOperation(value = "test", notes = " test")
    @GetMapping("/test")
    @ResponseBody*/
   public String toqzj(String pwd,String user) {
           String drurl = drip.split(":")[1].split("//")[1];
           String url = "http://" + drurl + "/interface/user/initLogin";
           Map<String, Object> data = new HashMap<String, Object>();
           data.put("password", pwd);
           data.put("loginName", user);
           logger.error("report_toqzj01:pwd:"+pwd+";user:"+user+";url:"+url+";drurl:"+drurl);
           HttpResponse response = HttpRequest.post(url).form(data)
                   .header(Header.ACCEPT, "application/json,text/plain,*/*")
                   .header(Header.ACCEPT_ENCODING, "gzip,deflate")
                   .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9")
                   .header(Header.CONNECTION, "keep-alive")
                   .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded")
                   .header(Header.HOST, drurl)
                   .header(Header.ORIGIN, "http://" + drurl)
                   .header(Header.REFERER, "http://" + drurl + "/html-inner/")
                   .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36")
                   .header(Header.AUTHORIZATION, "undefined")
                   .timeout(20000)//超时，毫秒
                   .execute();
           logger.error("report_toqzj02:response:"+response);
           HttpCookie jsessionid = response.getCookie("JSESSIONID");
           logger.error("report_toqzj03:jsessionid:"+jsessionid);
//           getQzjList(jsessionid, drurl);
           // return ResultUtil.success("c");
           getQzjList(jsessionid, drurl,0);
           logger.error("report_toqzj04");
           // 上传失败
           getQzjList(jsessionid, drurl,4);
           logger.error("report_toqzj05");
           return response.body().toString();

   }
    private void getQzjList(HttpCookie jsessionid,String drurl,Integer status) {
        String findUrl = "http://" + drurl + "/interface/findReportDataByStatus";
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNum", 1);
        data.put("pageSize", 10);
        data.put("status", status);
        logger.error("report_getQzjList01:findUrl:"+findUrl);
        HttpResponse response = HttpRequest.post(findUrl).form(data)
                .header(Header.ACCEPT, "application/json,text/plain,*/*")
                .header(Header.ACCEPT_ENCODING, "gzip,deflate")
                .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9")
                .header(Header.CONNECTION, "keep-alive")
                .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded")
                .header(Header.COOKIE, jsessionid.toString())
                .header(Header.HOST, drurl)
                .header(Header.ORIGIN, "http://" + drurl)
                .header(Header.REFERER, "http://" + drurl + "/html-inner/")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36")
                .header(Header.AUTHORIZATION, "undefined")
                .timeout(20000)//超时，毫秒
                .execute();
        logger.error("report_getQzjList02:response:"+response);
        String body = response.body();
        logger.error("report_getQzjList03:body:"+body);
        Map map = JSONObject.parseObject(body, Map.class);
        Map object = (Map) map.get("object");
        List<Map<String, Object>> bean = (List<Map<String, Object>>) object.get("bean");
        if (null == bean || bean.size() <= 0) {
            return;
        } else {
            bean.forEach(e -> {
                String diseaseId = (String) e.get("diseaseId");
                domanuallyupload(diseaseId, jsessionid,drurl);
            });
            logger.error("report_getQzjList04:drurl:"+drurl+";jsessionid:"+jsessionid+";status:"+status);
            //getQzjList(jsessionid,drurl,status);
            logger.error("report_getQzjList05:drurl:"+drurl+";jsessionid:"+jsessionid+";status:"+status);
        }
    }

    private void domanuallyupload(String diseaseId, HttpCookie jsessionid,String drurl) {
        String sburl = "http://" + drurl + "/interface/domanuallyupload";
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("diseaseId", diseaseId);
        HttpResponse response = HttpRequest.post(sburl).form(data)
                .header(Header.ACCEPT, "application/json,text/plain,*/*")
                .header(Header.ACCEPT_ENCODING, "gzip,deflate")
                .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9")
                .header(Header.CONNECTION, "keep-alive")
                .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded")
                .header(Header.COOKIE, jsessionid.toString())
                .header(Header.HOST, drurl)
                .header(Header.ORIGIN, "http://" + drurl)
                .header(Header.REFERER, "http://" + drurl + "/html-inner/")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36")
                .header(Header.AUTHORIZATION, "undefined")
                .timeout(20000)//超时，毫秒
                .execute();
        String body = response.body();
    }
/*

    public static void main(String[] args) throws Exception {
        String RSA = null;
        String publickey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4u6MNph/FiFx8GJAcs58TAGPCfzv40gJwbY+bpiki9jJ/YwI9VI6xfZQEq1+X4kuEsaxQs6Z4C8AtC34GH5OOuwxElzLVX3ylS0F/Ffl1oETrDmCDBNhDENFKfFhgtfPGhMclSWyP+xpVo4uUEF5T6Z5ktwUI9kOAgFsyzO/C7SertJme7OSyKcl87FQ4dtONXMvAseC/ZarPpi6XARE+lqNE0ceEqfv9YhNRwcbt+6F+2h6Pm1R5y0E+ApTcYOArKPIPxSmCFH4Xx2HZgt+ttBmMVKoBI0sDuY+ZEscHNPU3MAQk3b1Bc2WyS+b7WriggpOP9CeqjL3fBZ9BVGozwIDAQAB";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDi7ow2mH8WIXHwYkByznxMAY8J/O/jSAnBtj5umKSL2Mn9jAj1UjrF9lASrX5fiS4SxrFCzpngLwC0LfgYfk467DESXMtVffKVLQX8V+XWgROsOYIME2EMQ0Up8WGC188aExyVJbI/7GlWji5QQXlPpnmS3BQj2Q4CAWzLM78LtJ6u0mZ7s5LIpyXzsVDh2041cy8Cx4L9lqs+mLpcBET6Wo0TRx4Sp+/1iE1HBxu37oX7aHo+bVHnLQT4ClNxg4Cso8g/FKYIUfhfHYdmC3620GYxUqgEjSwO5j5kSxwc09TcwBCTdvUFzZbJL5vtauKCCk4/0J6qMvd8Fn0FUajPAgMBAAECggEAW/4F2u/wvMDsFl1N8PxhiNIs8QiXGlSOl/dP0beRJJvKLj1BOGmQJ8XU6e1oyEOs6LGhFAr6d9W1/FSSOSOihOJQdjgluU9oMi7hOU1Mf6stlWhunoSQl88BT6JpPAhODSzoLlHss1sbzJmwjposGizLJcyPYYTQ1+FKAAnHDW/0ZTSYyqXvxFLQyBqXb3x9VRRIPbwg8qWdVZXFLM1DeTK8EPqN5jvFy2n1ev86+MiIzekfsXP3wL3F7fHJhi1jwGy0BVygGqgWplwhHWlCoaqfYjG2ZghETIcRBUEFZjLxOOy4d6kITHSgw6uF8BNrNI8PTC/K81gVGcHLmYtYQQKBgQDxOSThOE+DIiZQ9DANEpYVt9RAYCV1Awn3TpVtQIkeq+48s4X21u//AD4BSNEcCdEEqWr/y6PGjsBhHTXqbegeFO+KaFAtNlVuU9ZHx+EPwJKEh67VDQp7iUeLRaqBAdthYMwJVl9aEiH5PtA2u7qHN3OmxaJK/wf3HIyzZkPcIQKBgQDw1UlTR2R2O5/lw/hU+Hv+V21o27uEGWEjfeR/RszjqMI8WmkBEStGQR5POLRO1Inu/jwO8/1/7fXq+x9sDL4kli1cqfah7zXtqp8f17pKAistcSmOfutEGXiuKeQ3KwpDmC/zbF8OhYClcuWDW9LhNoEl48f7PNNeBH0QigJm7wKBgDgglL02zgF0I7g4aSnRhkx9XoywEmcckugRR+GI357cYG2NVAFwV51c4BCKceV1P0Y3aWclafEcbBTsqAvpENZXBrmMtgMfHleyeCxxjKOOqkjeDUcTZroB4jy8tASaewI4dKFDkKIzj+YfwHDL04X82BMY7z9GAgN0iCSCCg4hAoGBAI9Vka+D9RG9SNw592my/jERHafj50WmyT6TZdQucjEotnmvIYGmE0hb50slJ4MnUfSw0VPg+UYTfWJeFYR8TQp/av4UlhoowcLy4oPUJCZ6BfKkwCPz+9frBP07J32CGzjBsgBBxo1g/YD60giNNQQfKVxApjwsJmx1ZW3bhbR3AoGAO+vtAqTBKpT3hN89UsOReWbJpb2N32xM4UV1csuSkAx+XN6fTHpraM/dcLVS08qm2tD1fHeHGRXBjJushFeSX4Qauxj2HOZgRybU9JlEFMuwREhCBDw/ySrxyWlcJwQQcsUwex1SdFO1B5YiC1yPwzXPz/ndVDeF3k/Y2gqNSbM=";
        SimpleDateFormat simpleDateFormat = null;
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
            RSA = RsaUtil.encrypt(format, publickey);
            String decrypt = RsaUtil.decrypt(RSA, privateKey);
            System.out.println(decrypt);
            System.out.println(RSA);
    }
*/

}
