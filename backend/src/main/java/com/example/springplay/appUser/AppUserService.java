package com.example.springplay.appUser;

import com.bot.Test;
import com.example.springplay.config.jwt.JwtWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {


    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse login(AuthenticationRequest request) throws Exception {

        com.bot.Test test = new Test();
        test.testando1();


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
