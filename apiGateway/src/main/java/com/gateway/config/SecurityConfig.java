//package com.gateway.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtDecoders;
//import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
//import org.springframework.security.oauth2.server.resource.introspection.SpringOpaqueTokenIntrospector;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .anyRequest().authenticated()
//                )
//                .oauth2ResourceServer((oauth2) -> oauth2
//                        .opaqueToken(Customizer.withDefaults())
//                );
//        return http.build();
//    }
//
//    @Bean
//    public OpaqueTokenIntrospector opaqueTokenIntrospector() {
//        return new SpringOpaqueTokenIntrospector(
//                "https://dev-81657319.okta.com/oauth2/default/v1/introspect",
//                "0oam6ttzjiaugO93u5d7",
//                "nErp-KVc22pSL3wUbLfwhVth5LOpA9tOTCtSHgWa3MF75vPu9g9egGDmKV1_4LZ7"
//        );
//    }
//}