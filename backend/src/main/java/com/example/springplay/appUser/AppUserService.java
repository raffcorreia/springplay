package com.example.springplay.appUser;

import com.example.springplay.config.jwt.JwtWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return User.builder().username("admin").password("admin").roles("ADMIN").build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) throws Exception {
        Authentication auth;

        try {
            auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username or password!");
        }

        JwtWriter jwtWriter = new JwtWriter();
        final String strJWT = jwtWriter.generateToken(auth);

        return new AuthenticationResponse(strJWT);
    }
}
