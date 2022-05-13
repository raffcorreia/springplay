package com.example.springplay.appUser;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class LocalUserDetailsService implements UserDetailsService {

    private final List<String> users = Arrays.asList("admin", "user", "joe", "test", "boot", "server");

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        String user = users.stream().filter(u -> u.equalsIgnoreCase(userName)).findFirst().orElse(null);

        if(Objects.nonNull(user)) {
            return User.builder().username(user).password(user).roles("ADMIN").build();
        }
        return null;
    }
}
