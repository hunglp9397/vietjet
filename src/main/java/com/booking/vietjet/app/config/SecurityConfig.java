package com.booking.vietjet.app.config;


import com.booking.vietjet.app.filter.IdempotenceFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private IdempotenceFilter idempotenceFilter;

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz
                .anyRequest().permitAll())
                .addFilterBefore(idempotenceFilter, ChannelProcessingFilter.class)
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
