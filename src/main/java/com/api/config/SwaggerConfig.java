package com.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("artwork-api")

                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Artwork API")
                .description("Spring BOOT Artwork API")
                .license("MIT License")
                .licenseUrl("http://cemaytan_01@hotmail.com")
                .version("1.0")
                .build();
    }


}
