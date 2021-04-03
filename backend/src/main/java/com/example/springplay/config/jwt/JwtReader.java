package com.example.springplay.config.jwt;

import com.example.springplay.config.SecurityProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;

import static com.example.springplay.config.SecurityProperties.AUTHORITIES_KEY;

public class JwtReader {

    private Jws<Claims> jws;

    public JwtReader(String strJWT) {
        extractAllClaims(strJWT);
    }

    public Claims getClaims(String authoritiesKey) {
        return jws.getBody();
    }

    public Object getClaimsByKey(String key) {
        return jws.getBody().get(key);
    }

    public Collection<GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        String strAuthorities = String.valueOf(getClaimsByKey(AUTHORITIES_KEY));
        for(String auth : strAuthorities.split(",")){
            authorities.add(new SimpleGrantedAuthority(auth));
        }

        return authorities;
    }

    public String getAlgorithm() {
        return jws.getHeader().getAlgorithm();
    }

    public String getSubject() {
        return this.jws.getBody().getSubject();
    }

    public Date getExpiration() {
        return this.jws.getBody().getExpiration();
    }

    public <T> T extractClaim(Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(jws.getBody());
    }

    private void extractAllClaims(String token) {
        this.jws = Jwts.parser().setSigningKey(SecurityProperties.JWT_KEY).parseClaimsJws(token);
    }

    private Boolean isTokenExpired() {
        return this.getExpiration().before(new Date());
    }

    public Boolean validateToken(UserDetails userDetails) {
        final String username = this.getSubject();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired());
    }
}
