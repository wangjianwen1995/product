package com.sxdl.sd.config;

import cn.hutool.http.Header;
import cn.hutool.http.HtmlUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONArray;
import com.sxdl.base.config.SchedulConfig;
import com.sxdl.base.entity.SchedulEntity;
import com.sxdl.base.util.BaseMailUtil;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.sd.dbo.SdRz;
import com.sxdl.sd.service.SdInfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableScheduling
public class SdScheduledConfig extends SchedulConfig {
    @Autowired
    SdInfoService sdInfoService;
    @Autowired
    YmlUtil ymlUtil;
    SchedulEntity schedulEntity;
    String urlEmile;
    HttpResponse response;

    public void run(SchedulEntity se) {
        if (null == se || null == se.getIsSys()) {
            return;
        }
        if (se.getIsSys() == 0) {
            String info = se.getInfo();
            try {
                switch (info) {
                    case "发邮件":
                        sendMails();
                        break;
                    case "":
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getCause());
            }

        }
    }

    /**
     * 每周一早上7:30,监控平台是否有更新,并发送通知
     */
    @Scheduled(cron = "0 30 7 ? * MON ")
    public void checkUpdateAndsendEmails() {
        schedulEntity = new SchedulEntity();
        schedulEntity.setIsSys(0);
        schedulEntity.setInfo("发邮件");
        run(schedulEntity);
    }

    public void sendMails() throws Exception {
        urlEmile = "https://quality.ncis.cn/drgsgateway/findAllSystemAnnouncement";
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("pageNum", 1);
        data.put("pageSize", 10);
        data.put("noticeType", 0);
        data.put("importantFlag", 1);
        response = HttpRequest.post(urlEmile).form(data)
                .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded")
                .header(Header.HOST, "quality.ncis.cn")
                .header(Header.REFERER, "https://quality.ncis.cn/platform-announcement?routeName=%E5%B9%B3%E5%8F%B0%E9%80%9A%E7%9F%A5")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36")
                .header(Header.AUTHORIZATION, "undefined")
                .timeout(20000)//超时，毫秒
                .execute();
        if (!response.isOk() || response.body().length() < 30) {
            System.out.println(response.body());
            return;
        } else {
            String body = response.body();
            //解析返回的json数据
            JSONObject jsonObject = JSONObject.fromObject(body);
            System.out.println(jsonObject);
            //result 是一个完整json字符串
            Object result = jsonObject.get("result");
            JSONObject jsonObject1 = JSONObject.fromObject(result);
            //获取实际更新数据
            Object sysAnnouncement = jsonObject1.get("sysAnnouncement");
            //获取更新列表
            List<SdRz> list = com.alibaba.fastjson.JSONObject.parseArray(JSONArray.toJSONString(sysAnnouncement), SdRz.class);
            //获取最新的更新时间
            String s = list.stream().map(SdRz::getAnnouncementDate).max((e1, e2) ->
                    DateUtil.compare(DateUtil.parseDateTime(e1), DateUtil.parseDateTime(e2))
            ).get();
            //获取库中是否有最新版信息,以及最高的版本号
            List<Map<String, Object>> maps = sdInfoService.selectSqlWithSQL("with v as (select * from sys_version)\nselect max(v) as mx,(select count(*) from v where time>='" + s + "') as cnt  from v ");
            if (Integer.parseInt(maps.get(0).get("cnt").toString()) > 0) {
                return;
            }
            //获取版本号
            String version = maps.get(0).get("mx").toString(), newV = "";

            version = getNewVersion(version);
            //按时间更新
            SdRz lastSDRZ = list.stream().collect(Collectors.groupingBy(SdRz::getAnnouncementDate)).get(s).get(0);
            //获取邮箱地址
            String mails = ymlUtil.getYmlValue("mails");
            if (StringUtil.isEmpty(mails)) {
                return;
            }
            //更新数据库
            sdInfoService.selectSqlWithSQL("insert into sys_version (v,info,time,type) values ('" + version + "','" + HtmlUtil.escape(lastSDRZ.getAnnouncementContent()) + "','" + lastSDRZ.getAnnouncementDate() + "',1)");
            List<String> tos = new ArrayList<>();
            if (mails.contains(",")) {
                tos = Arrays.asList(mails.split(","));//处理可能的异常情况
                if (mails.trim().endsWith(",")) {
                    tos.remove(tos.size() - 1);
                }
            } else {
                tos.add(mails);
            }
            //发送
            BaseMailUtil.sendEmail(tos, "单病种国家平台已经更新,请相关人员尽快处理!平台更新时间:" + lastSDRZ.getAnnouncementDate(), lastSDRZ.getAnnouncementContent());
        }
    }

    /**
     * 根据传入的之前最新版版本号生成新版本号
     *
     * @param version 之前最新版版本号,格式要求为0.0.0
     * @return 当前版本号
     */
    private String getNewVersion(String version) {
        if (StringUtil.isEmpty(version) || !version.contains("\\.")) {
            return "0.0.0";
        }
        //计算最新版本号
        String[] ss = version.split("\\.");
        Integer ge = Integer.parseInt(ss[2]), shi = Integer.parseInt(ss[1]), bai = Integer.parseInt(ss[0]);
        if (ge == 9) {//当个位数是9时,设置成0十位加一,当十位是9时,十位设置成0,百位加一
            ge = 0;
            if (shi == 9) {
                bai++;
            } else {
                shi++;
            }
        } else {
            ge++;
        }
        //新版本号
        version = bai + "." + shi + "." + ge;
        return version;
    }
}
