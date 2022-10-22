package com.sxdl.report.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 *
 * Swagger配置类
 */
//@Configuration
//@EnableSwagger2
//@EnableKnife4j
//@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
//	@Value("${swagger.basePackage}")
//	private String basePackage;//cnotroller接口所在的包
//	@Value("${swagger.title}")
//	private String title;//当前文档的标题
//	@Value("${swagger.description}")
//	private String description;//当前文档的详细描述
//	@Value("${swagger.version}")
//	private String version;//当前文档的版本
	
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sxdl.report.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("山西雕龙数据上报工具")
                .description("接口方法介绍及测试和数据字段的综合平台")
                .version("V1.0")
                .license("赵东")
                .build();
    }
}
