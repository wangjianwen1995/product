package com.sxdl.base.util;

import cn.hutool.core.net.NetUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Component
public class ReportUtil {

    @Autowired
    YmlUtil ymlUtil;

    private String publicKey, URL, token, isnew;
    private String[] ss;

    /**
     * 根据yml中配置判断hbi地址是否开放
     *
     * @return
     */
    public boolean addrIsOpen() {
        boolean flag = false;
        isnew = ymlUtil.getIsNew();
        if (StringUtil.isEmpty(isnew) || !"1".equals(isnew)) {
            return flag;
        }
        URL = ymlUtil.getHbiURL();
        if (StringUtil.isEmpty(URL) && !URL.contains(":")) {
            System.out.println("javahbi需要请正确填写配置文件中\"hbi.url\"选项,如果当前系统不是java版hbi请将配置文件中\"isnew\"选项删除!");
            return flag;
        }
        publicKey = ymlUtil.getPublicKey();
        if (StringUtil.isEmpty(publicKey)) {
            System.out.println("javahbi需要请正确填写配置文件中\"publicKey\"选项,如果当前系统不是java版hbi请将配置文件中\"isnew\"选项删除!");
            return flag;
        }
        if (URL.contains("//")) {//适配包含http开头的ip地址
            token = URL.split("//")[1];
            if (token.contains(":")) {
                ss = token.split(":");
            }
        } else {
            ss = URL.split(":");
        }
        if (!NetUtil.isOpen(new InetSocketAddress(ss[0], Integer.parseInt(ss[1])), 2000)) {
            System.out.println("检测到javahbi系统没有正常运行或者网络不通,请联系管理员查看~");
            return flag;
        }

        return true;
    }

    public String getHbiToken() {
        publicKey = ymlUtil.getPublicKey();
        URL = ymlUtil.getHbiURL();
        URL += "/accesstoken?appsecret=";
        URL += publicKey;
        try {
            HttpResponse execute = HttpRequest.post(URL).execute();
            if (execute.getStatus() == 200) {
                token = execute.body();
            } else {
                System.out.println("请求token过程中发生错误,请检查配置!" + execute.getStatus());
                return "";
            }
            if (StringUtil.isNotEmpty(token) && token.contains("false")) {
                System.out.println("hbi响应出错,请联系管理员~");
                return "";
            }
            return token;
        } catch (Exception e) {
            System.out.println("检测到javahbi系统没有正常运行或者网络不通,请联系管理员~");
            return "";
        }
    }
}
