package com.example.springplay.config;

import com.example.springplay.config.jwt.JwtReader;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

import static com.example.springplay.config.SecurityProperties.AUTHENTICATION_HEADER_STRING;
import static com.example.springplay.config.SecurityProperties.TOKEN_PREFIX;


public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String authHeader = req.getHeader(AUTHENTICATION_HEADER_STRING);

        if (authHeader == null || !authHeader.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(authHeader.substring(7));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        JwtReader jwtReader = new JwtReader(token);

        if (!SignatureAlgorithm.HS256.name().equals(jwtReader.getAlgorithm())){
            return null;
        }

        Collection<? extends GrantedAuthority> authorities = jwtReader.getAuthorities();

        if (jwtReader.getSubject() != null) {
            return new UsernamePasswordAuthenticationToken(jwtReader.getSubject(), null, authorities);
        }

        return null;
    }
}
