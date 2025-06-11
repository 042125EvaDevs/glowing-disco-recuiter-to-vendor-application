package xyz.catuns.recruiter_to_vendor.dto;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record UserRegistrationDTO(
        @Length(min = 5)
        String username,
        @Length(min = 8)
        String password
) {
}
