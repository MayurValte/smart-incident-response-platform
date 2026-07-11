package com.sirp.workflow.feign;

import com.sirp.workflow.feign.dto.UserResponse;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserServiceClient {

    @GetMapping("/internal/users/{id}")
    UserResponse findById(@PathVariable UUID id);
}