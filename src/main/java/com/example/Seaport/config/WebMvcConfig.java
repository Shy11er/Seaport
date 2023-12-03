//package com.example.Seaport.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://allowed-origin.com")
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept")
//                .allowCredentials(true)
//                .maxAge(3600);
//    }
//}