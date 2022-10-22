package com.sxdl.hn;

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
public class HnMain extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HnMain.class);
    }

    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis(),end;
        ConfigurableApplicationContext context = SpringApplication.run(HnMain.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        String prot = environment.getProperty("server.port");
        end=System.currentTimeMillis()-start;
        InetAddress inetAddress=InetAddress.getLocalHost();
        String ip=inetAddress.getHostAddress().toString();//获得本机Ip
        System.out.println("http://"+ip+":"+prot);
        System.out.println("OK,spend "+end+" millis");
        System.out.println("山西雕龙");

    }




}
