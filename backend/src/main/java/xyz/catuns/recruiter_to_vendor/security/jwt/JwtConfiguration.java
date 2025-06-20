package xyz.catuns.recruiter_to_vendor.security.jwt;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtConfiguration {

    @Bean
    public JwtService jwtService(JwtProperties jwtProperties) {
        return JwtService.of(jwtProperties);
    }
}
