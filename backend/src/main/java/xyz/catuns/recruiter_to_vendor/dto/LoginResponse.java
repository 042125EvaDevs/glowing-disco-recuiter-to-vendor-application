package xyz.catuns.recruiter_to_vendor.dto;

import java.util.Base64;

public record LoginResponse(
        UserEntityDetails user,
        String token
) {

    public static LoginResponse of(String username, String password) {
        UserEntityDetails user = new UserEntityDetails(username);
        String token = generateToken(username, password);
        return new LoginResponse(user, token);
    }

    private static String generateToken(String username, String password) {
        String valueToEncode = username + ":" + password;
        String encoded = Base64.getEncoder().encodeToString(valueToEncode.getBytes());
        return "Basic " + encoded;
    }
}
