package xyz.catuns.recruiter_to_vendor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.catuns.recruiter_to_vendor.dto.LoginResponse;
import xyz.catuns.recruiter_to_vendor.dto.UserEntityDetails;
import xyz.catuns.recruiter_to_vendor.dto.UserRegistrationDTO;
import xyz.catuns.recruiter_to_vendor.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<UserEntityDetails> register(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        UserEntityDetails user = authService.register(userRegistrationDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserEntityDetails> login(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        LoginResponse loginResponse = authService.login(userRegistrationDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .header("Authorization", loginResponse.token())
                .body(loginResponse.user());
    }
}
