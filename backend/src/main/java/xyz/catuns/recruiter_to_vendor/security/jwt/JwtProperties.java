package xyz.catuns.recruiter_to_vendor.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import xyz.catuns.recruiter_to_vendor.utils.Constants;


@ConfigurationProperties(prefix = "auth.jwt")
public class JwtProperties {

    private String secret;
    private Long expiration = Constants.Jwt.EXPIRATION;
    private String issuer = Constants.Jwt.ISSUER;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
