package com.sxdl.drplus;


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
public class DrplusMain extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DrplusMain.class);
    }


    public static void main(String[] args) throws Exception {


        //上面的代码就是为了拿到jar包外中log4j2.xml的绝对路径，不拘泥方法
        //System.setProperty("logging.config",path);

        long start=System.currentTimeMillis(),end;
        ConfigurableApplicationContext context = SpringApplication.run(DrplusMain.class, args);
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
