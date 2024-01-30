package com.lipe.copilote.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JwtConfig {

    String SECRET_KEY = "4gypNYcd2w2QfT19qrdNW4N/OnFgedwSR6+aqhTWix4=";

    // methods to generate jt token based on user and secret key

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    // method to create token
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    // method to extract usernmae from token
    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    // method to check if token is expired
    private Boolean isTokkenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // method to extract expiration date from token
    private Date extractExpiration(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
    }

    //method to validate token
    public Boolean validateToken(String token, String usernameparam) {
        final String username = extractUsername(token);
        return (username.equals(usernameparam) && !isTokkenExpired(token));
    }
}
