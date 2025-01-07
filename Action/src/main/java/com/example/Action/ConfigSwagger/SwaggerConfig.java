package com.example.Action.ConfigSwagger;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Action Service API Documentation")
                        .version("1.0")
                        .description("API documentation for the Action Service."));
    }
}
//http://localhost:1000/swagger-ui/index.html