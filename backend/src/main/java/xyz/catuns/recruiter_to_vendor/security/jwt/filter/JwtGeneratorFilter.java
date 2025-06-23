package xyz.catuns.recruiter_to_vendor.security.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import xyz.catuns.recruiter_to_vendor.dto.JwtToken;
import xyz.catuns.recruiter_to_vendor.security.jwt.JwtService;

import java.io.IOException;

public class JwtGeneratorFilter extends OncePerRequestFilter {

//    private final JwtService jwtService;
//
//    public JwtGeneratorFilter(JwtService jwtService) {
//        this.jwtService = jwtService;
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            Environment environment = getEnvironment();

            JwtService jwtService = new JwtService(environment);
            JwtToken token = jwtService.generate();
            response.setHeader("Authorization", "Bearer " + token.token());
        }
        filterChain.doFilter(request, response);
    }
}
