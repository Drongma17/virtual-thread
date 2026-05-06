package com.thonglam.virtual_thread.config;


import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public class PersistenceConfig implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // This pulls the username from Spring Security
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(auth -> auth.getName());
    }
}