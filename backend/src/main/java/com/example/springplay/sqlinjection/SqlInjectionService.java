package com.example.springplay.sqlinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class SqlInjectionService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;


    public SqlInjectionLoginResponse loginJPA(SqlInjectionLoginRequest loginRequest) {
        List<LoginEntity> logins = loginRepository.findAllByName(loginRequest.getName());

        SqlInjectionLoginResponse response = new SqlInjectionLoginResponse();

        LoginEntity login = logins.stream()
                .filter(l -> l.getPassword().equals(loginRequest.getPassword()))
                .findFirst().orElse(null);

        response.setAuthenticated(nonNull(login));

        return response;
    }

    public SqlInjectionLoginResponse loginJDBC(SqlInjectionLoginRequest loginRequest) {
        List<LoginEntity> logins = jdbcTemplate.query(

                "SELECT ID, NAME, PASSWORD " +
                    "FROM dbo.TB_LOGIN " +
                    "WHERE NAME = '" + loginRequest.getName() + "'" +
                    " AND  PASSWORD = '" + loginRequest.getPassword() + "'",
                (rs, rowNum) -> new LoginEntity(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("PASSWORD")
                )
        );

        return new SqlInjectionLoginResponse(!CollectionUtils.isEmpty(logins) && nonNull(logins.get(0)));
    }

}
