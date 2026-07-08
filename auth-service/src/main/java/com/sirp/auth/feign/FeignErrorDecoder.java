package com.sirp.auth.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignErrorDecoder {
    @Bean
    ErrorDecoder errorDecoder() {
        return (
                methodKey,
                response
        ) -> {
            if (
                    response.status()
                            ==
                            404
            ) {
                return new RuntimeException(
                        "User not found"
                );
            }
            if (
                    response.status()
                            ==
                            503
            ) {
                return new RuntimeException(
                        "User Service unavailable"
                );
            }
            return new RuntimeException(
                    "Feign communication failed"
            );
        };
    }
}