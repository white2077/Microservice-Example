package com.white.product.core.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class SecurityConfig {
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    String issuerUri ;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(oauth2->oauth2.jwt(jwtConfigurer -> jwtConfigurer.decoder(JwtDecoders.fromIssuerLocation(issuerUri))));
        http.authorizeHttpRequests(auth ->{
                 auth.requestMatchers(
                          "api/v1/products/create-product"
                         ,"/api/v1/products/update-product/**"
                         , "api/v1/products/delete-product/**")
                         .hasAuthority("ADMIN");
                 auth.anyRequest().permitAll();
         });
         return http.build();
    }
    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter()  {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            List<String> authorities = jwt.getClaimAsStringList("authorities");
            if (authorities != null) {
                return authorities.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
            } else {
                return Collections.emptyList();
            }
        });
        return converter;
    }
}
