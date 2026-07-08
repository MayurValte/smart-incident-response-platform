package com.sirp.auth.feign;

import com.sirp.auth.dto.response.UserSecurityResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "user-service"
)
public interface UserClient {
    @GetMapping(
            "/internal/users/email/{email}"
    )
    UserSecurityResponse findByEmail(
            @PathVariable
            String email
    );

    @GetMapping(
            "/internal/users/{id}"
    )
    UserSecurityResponse findById(
            @PathVariable
            Long id
    );
}