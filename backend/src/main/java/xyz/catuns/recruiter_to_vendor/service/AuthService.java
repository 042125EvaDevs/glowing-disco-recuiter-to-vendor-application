package xyz.catuns.recruiter_to_vendor.service;

import xyz.catuns.recruiter_to_vendor.dto.LoginResponse;
import xyz.catuns.recruiter_to_vendor.dto.UserEntityDetails;
import xyz.catuns.recruiter_to_vendor.dto.UserRegistrationDTO;

public interface AuthService {
    LoginResponse login(UserRegistrationDTO userRegistrationDTO);

    UserEntityDetails register(UserRegistrationDTO userRegistrationDTO);
}
