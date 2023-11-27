package com.Strong.Tshirt_Web.Security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /*
         * THIS IS USED FOR CORS ATTACK BASICALLY CONNECT TO ANOTHER APPLICATIONS LIKE
         * WEB IF THIS IS HOSTED IN ANOTHER ADDRESS AND SOMEONE HAVE TO CATCH THE
         * ENDPOINTS ..
         */
        http.cors().configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("http://127.0.0.1:5500"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setMaxAge(3600L);
                return config;
            }

        }).and().csrf().disable().authorizeHttpRequests(t -> {
            try {
                t.requestMatchers(HttpMethod.GET, "/admin/**")
                        .hasAnyAuthority("ADMIN")
                        .requestMatchers("/manage/**")
                        .hasAnyAuthority("MANAGE", "ADMIN")
                        .anyRequest().permitAll()
                        .and().exceptionHandling()
                        .accessDeniedPage("/access-denied")
                        .and().formLogin()
                        .and().httpBasic();
            } catch (Exception e) {
                e.getLocalizedMessage();
            }

        });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
