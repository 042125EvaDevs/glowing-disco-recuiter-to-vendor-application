package xyz.catuns.recruiter_to_vendor.dto;

public record LoginResponse(
        UserEntityDetails user,
        JwtToken token
) {}
