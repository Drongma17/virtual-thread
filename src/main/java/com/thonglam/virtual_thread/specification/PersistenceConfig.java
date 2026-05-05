package com.thonglam.virtual_thread.specification;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class PersistenceConfig {

//    @Bean
//    public AuditorAware<String> auditorProvider() {
//        // This pulls the current user from Spring Security
//        return () -> Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
//                .filter(Authentication::isAuthenticated)
//                .map(Authentication::getName)
//                .or(() -> Optional.of("SYSTEM"));
//    }
}