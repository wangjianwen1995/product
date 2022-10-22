package com.sxdl.hp;

import com.sxdl.hp.util.HpApplicationRunnerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.sxdl.**"})
@EnableCaching
@EnableTransactionManagement
public class HpMain extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        System.out.println("山西雕龙欢迎您！欢迎使用HP（Homepage Of Medical Record）智慧病案首页管理平台~");
        long start = System.currentTimeMillis(), end;
        ConfigurableApplicationContext context = SpringApplication.run(HpMain.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        String port = environment.getProperty("server.port");
        String ip = HpApplicationRunnerImpl.contextMap.get("localip").toString();

        end = System.currentTimeMillis() - start;
        System.out.println("系统已正常启用,耗时 : " + end + " 毫秒!请登录该网址使用系统  http://" + ip + ":" + port);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HpMain.class);
    }
}
