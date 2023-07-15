package com.github.youssefwadie.messagehub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;

@Configuration(proxyBeanMethods = false)
@EnableWebFluxSecurity
public class WebSecurityConfig {

    @Bean
    @Autowired
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        http.authorizeExchange(
                auth -> {
                    auth.pathMatchers("/", "/error").permitAll();
                    auth.anyExchange().authenticated();
                }
        );

        http.exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED)));

        http.csrf(c -> c.csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse()));
        http.logout(l -> l.logoutUrl("/"));
        http.oauth2Login(Customizer.withDefaults());

        return http.build();
    }
}
