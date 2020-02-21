package com.spring5.practice;

import com.spring5.practice.config.security.CustomAuthSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
*
* TODO:
*   1. soft delete
*   2. multiple authorities/roles for a user
*   3. profiling
*   4. deployment to heroku
*   5. add user, change password, change role
*   6. image upload, user details
*   7. smtp setup
*   8. change password, forgot password
*   9.
* */

@ComponentScan(basePackages = {
        "com.spring5.practice.service",
        "com.spring5.practice.config.persistence",
        "com.spring5.practice.config.security"})
public class RootConfig {
    @Bean
    GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomAuthSuccessHandler authSuccessHandler() {
        return new CustomAuthSuccessHandler();
    }
}
