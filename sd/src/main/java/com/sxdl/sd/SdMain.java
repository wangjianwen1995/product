package com.sxdl.sd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;

@SpringBootApplication
@ComponentScan({"com.sxdl.**"})
@EnableCaching
@EnableTransactionManagement
public class SdMain extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SdMain.class);
    }


    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis(),end;
        //SpringApplication.run(SdMain.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(SdMain.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        String prot = environment.getProperty("server.port");
        InetAddress inetAddress = InetAddress.getLocalHost();
        //获得本机Ip
        String ip = inetAddress.getHostAddress();
        end = System.currentTimeMillis() - start;
        System.out.println("系统已正常启用,耗时 : " + end + " 毫秒!请登录该网址使用系统  http://" + ip + ":" + prot);
        System.out.println("OK,spend "+end+" millis");
    }
}
