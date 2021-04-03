package com.example.springplay.sqlinjection;

import lombok.Data;

@Data
public class SqlInjectionLoginRequest {
    private String name;
    private String password;
}
