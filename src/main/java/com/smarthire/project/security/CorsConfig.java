package com.smarthire.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Permite solicitudes desde cualquier origen
        config.addAllowedMethod("*"); // Permite todos los métodos HTTP (GET, POST, etc.)
        config.addAllowedHeader("*"); // Permite todas las cabeceras HTTP
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}