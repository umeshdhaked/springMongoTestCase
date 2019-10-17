package com.stackroute.muzix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.stackroute.muzix"))
                .paths(regex("/tracks.*"))
                .build();

    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Music Track List",
                "Music Track List CRUD Operations",
                "3.0",
                "Absolutely no Terms and Conditions Apply",
                new Contact("Umesh","localhost","umdk456@gmail.com"),
                "StackRoute Verson 0.0",
                "stackroute.in",
                null
        );

        return apiInfo;
    }


}
