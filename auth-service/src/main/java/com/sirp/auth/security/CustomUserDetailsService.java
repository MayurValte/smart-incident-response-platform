package com.sirp.auth.security;

import com.sirp.auth.dto.response.UserSecurityResponse;
import com.sirp.auth.feign.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {
    private final UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(
            String email
    )
            throws UsernameNotFoundException {
        UserSecurityResponse user =
                userClient.findByEmail(
                        email
                );
        return new UserPrincipal(
                user
        );
    }
}