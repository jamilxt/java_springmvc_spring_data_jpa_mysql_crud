package com.spring5.practice;

import com.spring5.practice.config.persistence.HibernateConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.spring5.practice.service",
        "com.spring5.practice.config.persistence",
        "com.spring5.practice.config.security"})
//@ComponentScan(basePackageClasses = {StudentService.class})
public class RootConfig {
    @Bean
    GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

//    @Bean
//    HibernateConfig hibernateConfig() {
//        return new HibernateConfig();
//    }
}
