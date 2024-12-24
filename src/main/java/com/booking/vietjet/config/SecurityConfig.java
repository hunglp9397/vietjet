package com.booking.vietjet.config;

//import com.booking.vietjet.app.filter.IdempotenceFilter;
import com.booking.vietjet.app.filter.IdempotenceFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private IdempotenceFilter idempotenceFilter;

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

//        http.addFilterBefore(idempotenceFilter, UsernamePasswordAuthenticationFilter.class)
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"))
//                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
//                ;;

        http
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()  // Cho phép tất cả các request
                )
                .addFilterBefore(idempotenceFilter, ChannelProcessingFilter.class)  // Đảm bảo IdempotenceFilter là filter đầu tiên

                // Vô hiệu hóa CSRF cho tất cả các request
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
