package xyz.catuns.recruiter_to_vendor.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.catuns.recruiter_to_vendor.entities.UserEntity;
import xyz.catuns.recruiter_to_vendor.repositories.UserEntityRepository;

import java.util.List;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(DefaultUserDetailsService.class);

    private final UserEntityRepository userRepository;
    
    public DefaultUserDetailsService(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException("You shall not pass"));

        return new User(username, user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
