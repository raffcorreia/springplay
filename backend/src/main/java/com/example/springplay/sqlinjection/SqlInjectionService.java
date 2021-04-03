package com.example.springplay.sqlinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SqlInjectionService {

    @Autowired
    LoginRepository loginRepository;


    public SqlInjectionLoginResponse loginJPA(SqlInjectionLoginRequest loginRequest) {
        List<LoginEntity> logins = loginRepository.findAllByName(loginRequest.getName());

        SqlInjectionLoginResponse response = new SqlInjectionLoginResponse();

        LoginEntity login = logins.stream()
                .filter(l -> l.getPassword().equals(loginRequest.getPassword()))
                .findFirst().orElse(null);

        response.setAuthenticated(Objects.nonNull(login));

        return response;
    }
}
