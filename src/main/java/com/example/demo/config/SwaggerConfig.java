package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 配置多个分组则需要创建多个docket类的实例，比如：
    @Bean()
    public Docket docket1(Environment environment) {

        // 获取环境信息，让生产环境不能访问swagger
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("我的第二个分组")
                .enable(flag); // 是否启动swagger，为false则不能在浏览器中访问
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")) // 指定扫描包
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) // 扫描有@RestController注解的类
//                .paths(PathSelectors.ant("/example/**")) // 过滤不需要扫描的路径,这个是正则过滤，还有其他方式
//                .build();
    }

    @Bean()
    public Docket docket(Environment environment) {

        // 获取环境信息，让生产环境不能访问swagger
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("我的第一个分组")
                .enable(flag) // 是否启动swagger，为false则不能在浏览器中访问
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")) // 指定扫描包
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) // 扫描有@RestController注解的类
//                .paths(PathSelectors.ant("/example/**")) // 过滤不需要扫描的路径,这个是正则过滤，还有其他方式
                .build();
    }

    // 配置swagger基本信息
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "我的swagger",
                "我的第一个swagger",
                "1.0",
                "urn:tos",
                new Contact("小杰", "http://www.baidu.com", "1553861774@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
