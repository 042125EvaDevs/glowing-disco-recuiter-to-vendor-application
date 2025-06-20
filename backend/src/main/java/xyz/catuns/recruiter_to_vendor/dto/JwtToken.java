package xyz.catuns.recruiter_to_vendor.dto;

import java.util.Date;

public record JwtToken(
        String token,
        Date expiration
) {
}
