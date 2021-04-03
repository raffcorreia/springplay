package com.example.springplay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "springplay.security")
public class SecurityProperties {

    public static final String  AUTHENTICATION_HEADER_STRING    = "Authorization";
    public static final String  TOKEN_PREFIX                    = "Bearer ";
    public static final String  AUTHORITIES_KEY                 = "authorities";
    public static String JWT_KEY;

    /**
     * This is a workaround to make the static JWT_KEY be loaded by the property jwtKey
     *
     * @param jwtKey - This parameter is loaded by Spring configuration
     */
    public void setJwtKey(String jwtKey) {
        SecurityProperties.JWT_KEY = jwtKey;
    }
}
