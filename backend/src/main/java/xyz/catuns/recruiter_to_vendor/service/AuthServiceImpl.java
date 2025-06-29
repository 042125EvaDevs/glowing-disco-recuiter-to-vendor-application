package xyz.catuns.recruiter_to_vendor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.catuns.recruiter_to_vendor.dto.UserEntityDetails;
import xyz.catuns.recruiter_to_vendor.dto.UserRegistrationDTO;
import xyz.catuns.recruiter_to_vendor.entities.UserEntity;
import xyz.catuns.recruiter_to_vendor.repositories.UserEntityRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserEntityRepository userEntityRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UserEntityRepository userEntityRepository) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserEntityDetails login(UserRegistrationDTO userRegistrationDTO) {
        Authentication auth = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(
                        userRegistrationDTO.username(),
                        userRegistrationDTO.password()
                )
        );

        if (auth == null || !auth.isAuthenticated()) {
            throw new BadCredentialsException("username or password is incorrect");
        }

        String username = ((User) auth.getPrincipal()).getUsername();
        return new UserEntityDetails(username);
    }

    @Override
    public UserEntityDetails register(UserRegistrationDTO userRegistrationDTO) {
        UserEntity user = new UserEntity();
        user.setUsername(userRegistrationDTO.username());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.password()));

        log.info("user {}", user);

        /**
         * todo: Catch data integrity exception
         */

        user = userEntityRepository.save(user);

        return new UserEntityDetails(user.getUsername());
    }
}
