package com.example.springplay.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("/api/experience")
public class SecurityController {

    @RequestMapping(value = "/userDetails", method = RequestMethod.GET)
    @ResponseBody
    public UserDetailsResponse getUserDetails(Principal principal, Authentication authentication) {
        String userName = isNull(principal.getName()) ? authentication.getName() : principal.getName();
        return UserDetailsResponse.builder().name(userName).build();
    }
}
