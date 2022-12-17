package com.apiharrypotter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.apiharrypotter.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Harry Potter API",
                "This project seeks to be the best rest api related to the magical world of Harry Potter. In it you will find a diversity of information to be able to consume and use in your applications.",
                "1.0",
                "https://github.com/DePalma2/api-rest-harry-potter",
                new Contact("Lucas De Palma", "https://www.linkedin.com/in/lucasdepalma/", "lucasdepalma2002@gmail.com"),
                "MIT License",
                "https://github.com/DePalma2/api-rest-harry-potter/blob/main/LICENSE",
                Collections.emptyList()
        );
    }



}
