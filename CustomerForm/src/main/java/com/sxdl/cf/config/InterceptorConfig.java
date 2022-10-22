package com.sxdl.cf.config;

import com.sxdl.cf.interceptor.RightInterceptorBaseDev;
import com.sxdl.cf.util.FileUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;


/**
 * 注册拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Bean
    public RightInterceptorBaseDev getLoginInterceptor() {
        // 初始化RightInterceptorBaseDev 拦截器 ,将文件数据加载到 缓存中
        try {
            FileUtil.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RightInterceptorBaseDev();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/dev/**").addPathPatterns("/dev").addPathPatterns("/devindex").excludePathPatterns("/cf/**") ;
        WebMvcConfigurer.super.addInterceptors(registry);
    }



}
