package com.example.springplay.config.jwt;

import com.example.springplay.config.SecurityProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.springplay.config.SecurityProperties.AUTHORITIES_KEY;

public class JwtWriter {

    public String generateToken(Authentication auth) {
        User userDetails = (User)auth.getPrincipal();

        final String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return createToken(authorities, userDetails.getUsername());
    }

    private String createToken(String authorities, String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .addClaims(Map.of(AUTHORITIES_KEY, authorities))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(Date.from(Instant.now().plus(365, ChronoUnit.DAYS)))
                .signWith(SignatureAlgorithm.HS256, SecurityProperties.JWT_KEY).compact();
    }
}
