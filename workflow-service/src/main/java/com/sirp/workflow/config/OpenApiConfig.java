package com.sirp.workflow.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class OpenApiConfig {

    @Bean
    public OpenAPI workflowOpenAPI() {
        return new OpenAPI().info(new Info().title("Workflow Service API")
                                            .description(
                                                "Workflow Service for Smart Incident Response "
                                                    + "Platform")
                                            .version("1.0.0")
                                            .contact(new Contact().name("SIRP")
                                                                  .email("support@sirp.com"))
                                            .license(new License().name("Apache License 2.0")
                                                                  .url("https://www.apache"
                                                                           + ".org/licenses"
                                                                           + "/LICENSE-2.0")))
                            .externalDocs(
                                new ExternalDocumentation().description("SIRP Documentation")
                                                           .url("https://sirp.com"))
                            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
