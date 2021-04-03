package com.example.springplay.appUser;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String userName;
    private String password;
}
