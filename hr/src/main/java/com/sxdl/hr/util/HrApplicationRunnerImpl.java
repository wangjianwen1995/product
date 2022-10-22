package com.sxdl.hr.util;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class HrApplicationRunnerImpl extends com.sxdl.base.util.ApplicationRunnerImpl {
    //全局变量
    public volatile static Map<String, Object> contextMap = new ConcurrentHashMap<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        super.init();
        System.out.println("山西雕龙欢迎您！欢迎使用Hr（Hospital Report）医院感染上报平台~");

    }
}
