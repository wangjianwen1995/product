package com.sxdl.report.util;

import cn.hutool.json.JSONUtil;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.ReportUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.verify.VerifyReturn;
import com.sxdl.base.util.verify.VerifyUtil;
import com.sxdl.report.dao.dao1.DrTemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DrApplicationRunnerImpl implements ApplicationRunner {
    //全局变量
    public volatile static Map<String, Object> contextMap = new ConcurrentHashMap<>();
    public static String PATH,FILESPATH;


    @Autowired
    private ReportUtil reportUtil;
    @Autowired
    private Environment env;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    public static String getFilesPath(){
        String classPath = System.getProperty("exe.path"), file = "files";
        if (StringUtil.isEmpty(classPath)) {
            try {
                classPath = ResourceUtils.getURL("classpath:").getPath().trim();
                int len = 15;
                if (classPath.contains("test")) {
                    len = 20;
                }
                classPath = classPath.substring(1, classPath.length() - len);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        FILESPATH=classPath + file;
        return FILESPATH;
    }
    public void setPATH() {
        this.PATH = getFilesPath()+"/sysfile/longlicenses.lisp";
        ApplicationRunnerImpl.PATH=this.PATH;
    }

    public void init(){
        if(reportUtil.addrIsOpen()){
            contextMap.put("hbitoken",reportUtil.getHbiToken());
        }
        ApplicationRunnerImpl.contextMap.put("env", env);//验证需要配置的端口
        setPATH();
        VerifyReturn vr = VerifyUtil.builder().verify(null,PATH);
        if (!vr.getFlag()) {
            ApplicationRunnerImpl.contextMap.put("verify", false);
        } else {
            ApplicationRunnerImpl.contextMap.put("verify", true);
            ApplicationRunnerImpl.contextMap.put("verifyInfo", JSONUtil.parseObj(vr.getMeg()));
        }
    }

}
