package com.sxdl.ae;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;

@EnableAsync
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@ServletComponentScan
@ComponentScan(basePackages = {"com.sxdl.**"})
public class AEMain extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AEMain.class);
    }


    public static void main(String[] args) throws Exception {

        long start=System.currentTimeMillis(),end;
        ConfigurableApplicationContext context = SpringApplication.run(AEMain.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        String prot = environment.getProperty("server.port");
        end=System.currentTimeMillis()-start;
        InetAddress inetAddress=InetAddress.getLocalHost();
        String ip=inetAddress.getHostAddress();//获得本机Ip
        System.out.println("http://"+ip+":"+prot);
        System.out.println("OK,spend "+end+" millis");
        System.out.println("山西雕龙");
    }

}
