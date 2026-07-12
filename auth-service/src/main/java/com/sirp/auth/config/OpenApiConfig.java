package com.sirp.auth.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class OpenApiConfig {

    @Bean
    OpenAPI authApi() {
        return new OpenAPI().info(new Info().title("SIRP Auth Service")
                                            .version("v1")
                                            .description("Authentication Service")
                                            .contact(new Contact().name("Mayur")))
                            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
