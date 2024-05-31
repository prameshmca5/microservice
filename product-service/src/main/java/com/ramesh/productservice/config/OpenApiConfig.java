package com.ramesh.productservice.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI productServiceOpenAPI() {
    return new OpenAPI()
        .info(new io.swagger.v3.oas.models.info.Info().title("Product Service API").version("v1.0.0")
        .description("Product Service API")
        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
        .externalDocs(
            new ExternalDocumentation().description("SpringShop Wiki Documentation").url("https://springshop.wiki")
        );
  }
}
