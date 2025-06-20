package xyz.catuns.recruiter_to_vendor.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import xyz.catuns.recruiter_to_vendor.dto.JwtToken;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtService {

    private final String secret;
    private final Long expiration;
    private final String issuer;

    public JwtService(String secret, Long expiration, String issuer) {
        this.secret = secret;
        this.expiration = expiration;
        this.issuer = issuer;
    }

    public static JwtService of(JwtProperties properties) {
        return new JwtService(properties.secret(), properties.expiration(), properties.issuer());
    }


    public JwtToken generate(String secret) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        Date tokenExpiration = this.getExpiration();
        String token = Jwts.builder()
                .issuer(this.issuer)
                .expiration(tokenExpiration)
                .issuedAt(new Date())
                .signWith(key)
                .compact();
        return new JwtToken(token,tokenExpiration);
    }

    private Date getExpiration() {
        long currentTimeMillis = System.currentTimeMillis();
        return new Date(expiration + currentTimeMillis);
    }

    public JwtToken generate() {
        return generate(this.secret);
    }
}
