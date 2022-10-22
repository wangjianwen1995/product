package com.sxdl.analyse;

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
@EnableCaching
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.sxdl.**"})
public class DaMain extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        System.out.println("山西雕龙欢迎您！欢迎使用DA（Data Analyse）数据分析平台~");
        long start = System.currentTimeMillis(), end;
        ConfigurableApplicationContext context = SpringApplication.run(DaMain.class, args);

        ConfigurableEnvironment environment = context.getEnvironment();
        String prot = environment.getProperty("server.port");
        InetAddress inetAddress=InetAddress.getLocalHost();
        String ip=inetAddress.getHostAddress().toString();//获得本机Ip
        end = System.currentTimeMillis() - start;
        System.out.println("系统已正常启用,耗时 : " + end + " 毫秒!请登录该网址使用系统  http://"+ip+":"+prot);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DaMain.class);
    }

}

