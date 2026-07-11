package com.sirp.notification.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(
    basePackages = "com.sirp.notification.feign"
)
public class FeignConfig {

}