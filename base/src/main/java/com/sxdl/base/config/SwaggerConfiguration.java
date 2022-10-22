package com.sxdl.base.config;

import cn.hutool.core.util.StrUtil;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Swagger配置类
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfiguration {
    @Value(value = "${swagger.enable:false}")
    String enable;
    @Value(value = "${swagger.rule:}")
    String rule;
    @Value(value = "${server.application.name}")
    private String title;//当前文档的标题
    @Value("${basePackage:}")
    private String basePackage;//需要暴露的接口目录
    @Value("${server.port}")
    private String port;

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     * 访问地址：http://项目实际地址/doc.htm
     */
    @Bean
    public Docket createRestApi() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("请联系管理员调整网络," + e.getCause());
        }
        if (StrUtil.isBlank(rule)) {
            if (StrUtil.isBlank(basePackage)) {
                return new Docket(DocumentationType.SWAGGER_2)
                        .host(address.getCanonicalHostName() + ":" + port)
                        .apiInfo(new ApiInfoBuilder().title(this.title).description("接口方法介绍及测试和数据字段的综合平台").version("V1.0").license("山西雕龙").build())
                        .select().apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.none()).build();

            } else {
                return new Docket(DocumentationType.SWAGGER_2)
                        .host(address.getCanonicalHostName() + ":" + port)
                        .apiInfo(new ApiInfoBuilder().title(this.title).description("接口方法介绍及测试和数据字段的综合平台").version("V1.0").license("山西雕龙").build())
                        .select().apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.any()).build();
            }
        } else {
            return new Docket(DocumentationType.SWAGGER_2)
                    .host(address.getCanonicalHostName() + ":" + port)
                    .apiInfo(new ApiInfoBuilder().title(this.title).description("接口方法介绍及测试和数据字段的综合平台").version("V1.0").license("山西雕龙").build())
                    .select().apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.ant(rule)).build();
        }
    }
}
