package com.Strong.Tshirt_Web.Security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig implements AuthenticationFailureHandler {

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

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof AuthenticationException) {
            response.sendRedirect("/login");
        } else {
            // Handle other authentication failures
            response.sendRedirect("/login?error");
        }

        /*
         * <div th:if="${param.error != null}">
         * <p style="color: red;">Incorrect credentials. Please try again.</p>
         * </div>
         */
    }
}
