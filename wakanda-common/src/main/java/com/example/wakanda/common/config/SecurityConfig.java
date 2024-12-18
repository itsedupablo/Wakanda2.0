package com.example.wakanda.common.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF (opcional)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/traffic/**").permitAll() // Permite acceso a /traffic/**
                        .anyRequest().authenticated() // Requiere autenticación para cualquier otra ruta
                )
                .httpBasic(httpBasic -> httpBasic.disable()); // Deshabilita la autenticación básica

        return http.build();
    }
}

