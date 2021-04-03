package com.example.springplay.sqlinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/experience/sqlinjection")
public class SqlInjectionController {

    @Autowired
    SqlInjectionService sqlInjectionService;

    @RequestMapping(value = "/loginJPA", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public SqlInjectionLoginResponse loginJPA(@RequestBody SqlInjectionLoginRequest loginRequest) {
        return sqlInjectionService.loginJPA(loginRequest);
    }

}
