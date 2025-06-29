package xyz.catuns.recruiter_to_vendor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import xyz.catuns.recruiter_to_vendor.security.DefaultAuthenticationProvider;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(r -> r
                .requestMatchers(
                        "/auth/**",
                        "/actuator/**",
                        "/api/candidates/health",
                        "/error")
                    .permitAll()
                .anyRequest()
                    .authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationProvider authenticationProvider = new DefaultAuthenticationProvider(userDetailsService, passwordEncoder);
        return new ProviderManager(authenticationProvider);
    }

}
