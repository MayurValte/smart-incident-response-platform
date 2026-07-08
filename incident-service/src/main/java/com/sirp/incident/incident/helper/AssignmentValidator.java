package com.sirp.incident.incident.helper;

import com.sirp.incident.exception.InactiveUserException;
import com.sirp.incident.exception.UserNotFoundException;
import com.sirp.incident.integration.user.UserClient;
import com.sirp.incident.integration.user.dto.UserResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssignmentValidator {

    private final UserClient userClient;

    public void validate(UUID userId) {
        UserResponse user = userClient.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found : " + userId);
        }
        if (!user.active()) {
            throw new InactiveUserException("User is inactive");
        }
    }
}