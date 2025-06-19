package xyz.catuns.recruiter_to_vendor.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;
import java.util.List;

public class CorsConfigurationSourceImpl implements org.springframework.web.cors.CorsConfigurationSource {
    @Override
    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        var config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:5173"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.addAllowedHeader("*");
        return config;
    }
}
