package com.sxdl.fm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sxdl.**"})
@EnableCaching
@EnableTransactionManagement
public class FmMain extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FmMain.class);
    }


    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis(),end;
        SpringApplication.run(FmMain.class, args);
        end=System.currentTimeMillis()-start;
        System.out.println("OK,spend "+end+" millis");
    }
}
