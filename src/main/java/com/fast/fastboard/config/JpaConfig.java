package com.fast.fastboard.config;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@Configuration
public class JpaConfig {
    
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("admin");
    }

    /**
     * @see https://github.com/spring-projects/spring-data-commons/issues/880#issuecomment-849730106
     */
    @Bean
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(OffsetDateTime.now());
    }
}
