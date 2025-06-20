package xyz.catuns.recruiter_to_vendor.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Objects;


@ConfigurationProperties(prefix = "auth.jwt")
public record JwtProperties(
   String secret,
   @DefaultValue("36000000")
   Long expiration,
   @DefaultValue("recruiter-to-vendor")
   String issuer
) {

    public JwtProperties {
        Objects.requireNonNull(secret, "jwt secret must not be null");
    }
}
