package com.example.springplay.sqlinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class SqlInjectionService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public SqlInjectionLoginResponse loginJPA(SqlInjectionLoginRequest loginRequest) {
        LoginEntity login = loginRepository.findOneByNameAndPassword(
                loginRequest.getName(), loginRequest.getPassword());

        return new SqlInjectionLoginResponse(nonNull(login));
    }

    public SqlInjectionLoginResponse loginJDBC(SqlInjectionLoginRequest loginRequest) {
        LoginEntity login = jdbcTemplate.queryForObject(
                "SELECT ID, NAME, PASSWORD " +
                    "FROM dbo.TB_LOGIN " +
                    "WHERE NAME = '" + loginRequest.getName() + "'" +
                    " AND  PASSWORD = '" + loginRequest.getPassword() + "'",
                (rs, rowNum) -> new LoginEntity(rs.getLong("ID"),
                        rs.getString("NAME"),
                        rs.getString("PASSWORD")
                )
        );

        return new SqlInjectionLoginResponse(nonNull(login));
    }

}
