package com.sirp.incident.integration.user;

import com.sirp.incident.integration.user.dto.TeamResponse;
import com.sirp.incident.integration.user.dto.UserResponse;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/internal/users/{id}")
    UserResponse getUser(@PathVariable UUID id);

    @GetMapping("/internal/teams/{id}")
    TeamResponse getTeam(@PathVariable UUID id);
}