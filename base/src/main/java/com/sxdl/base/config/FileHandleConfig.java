package com.sxdl.base.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.YmlUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.util.Arrays;

/**
 * 本系统核心配置类,主要配置了项目访问路径以及拦截器
 * 路径,包含项目默认配置文件路径,以及包外访问路径
 * 拦截器,开放特定的接口访问路径和项目资源,其他都会拦截,同时处理请求跨域问题
 */
@Configuration
public class FileHandleConfig implements WebMvcConfigurer {

    private static final String OPTIONS = "OPTIONS";

    @Autowired
    YmlUtil ymlUtil;

    String origin, token, acceptSystem;
    Object loginIdByToken;


    @SneakyThrows
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.out.println(ApplicationRunnerImpl.getFilesPath());
        //项目之外的静态资源
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:" + ApplicationRunnerImpl.getFilesPath() + File.separator);
        //项目静态资源
        registry.addResourceHandler("/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/resources/")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/META-INF/resources/");//swagger的静态资源
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaRouteInterceptor((req, res, handler) -> {

            origin = req.getHeader("Origin");
            if (StringUtil.isEmpty(origin)) {
                origin = req.getHeader("Referer");
                if (StringUtil.isEmpty(origin)) {
                    origin = "*";
                }
            }
            // 允许指定域访问跨域资源
            res.setHeader("Access-Control-Allow-Origin", origin);
            // 允许客户端携带跨域cookie，此时origin值不能为“*”，只能为指定单一域名
//            res.setHeader("Access-Control-Allow-Credentials", "true");
            // 允许所有请求方式
            res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT,DELETE");
            // 有效时间
            res.setHeader("Access-Control-Max-Age", "36000");
            // 允许的header参数
            res.setHeader("Access-Control-Allow-Headers", "x-requested-with,token");
            // 允许的header参数
            res.setHeader("Access-Control-Allow-Headers", "*");
            // 如果是预检请求，直接返回
            if (OPTIONS.equals(req.getMethod())) {
                return;
            }
            SaRouter.match(Arrays.asList("/**"),
                    Arrays.asList("/sysUser/login", "/verify/**","/swagger-ui/index.html",
                            "/**/index.html", "/doc.html", "/swagger-resources",
                            "/**/*.js",              //js静态资源
                            "/**/*.css",             //css静态资源
                            "/**/*.ico",             //css静态资源
                            "/static/fonts/**",
                            "/files/**",
                            "/static/img/**"), () -> {
                        //本系统用户信息
                        token = req.getHeader("sxdl");
                        if (StringUtil.isNotEmpty(token)) {
                            //本系统用户登录信息
                            loginIdByToken = StpUtil.getLoginIdByToken(token);
                            //判断本系统用户是否登录失效
                            if (null == loginIdByToken) {
                                //其他登录系统请求
                                acceptSystem = req.getHeader("Accept-System");
                                if (StringUtil.isEmpty(acceptSystem)) {
                                    String istest = ymlUtil.getYmlValueOrDefault("istest", "402");
                                    res.setStatus(Integer.parseInt(istest));
                                }
                            }
                        }else{
                            //其他登录系统请求
                            acceptSystem = req.getHeader("Accept-System");
                            if (!StringUtil.isEmpty(acceptSystem) && "sxdl".equals(acceptSystem)) {
                              //  String istest = ymlUtil.getYmlValueOrDefault("istest", "402");
                                res.setStatus(200);
                            }else{
                                res.setStatus(402);
                            }
                        }
                    });
        })).addPathPatterns("/**");
        registry.addInterceptor(new SaRouteInterceptor()).addPathPatterns("/files/sysfile/**");
    }
}
