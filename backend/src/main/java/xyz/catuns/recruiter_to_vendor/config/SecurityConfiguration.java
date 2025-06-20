package xyz.catuns.recruiter_to_vendor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import xyz.catuns.recruiter_to_vendor.security.CorsConfigurationSourceImpl;
import xyz.catuns.recruiter_to_vendor.security.DefaultAuthenticationProvider;
import xyz.catuns.recruiter_to_vendor.security.jwt.filter.JwtGeneratorFilter;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterAfter(new JwtGeneratorFilter(), BasicAuthenticationFilter.class);
        http.authorizeHttpRequests(r -> r
                .requestMatchers(
                        "/auth/**",
                        "/actuator/**",
                        "/api/candidates/**",
                        "/error")
                    .permitAll()
                .anyRequest()
                    .authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(cors -> cors.configurationSource(new CorsConfigurationSourceImpl()));
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
