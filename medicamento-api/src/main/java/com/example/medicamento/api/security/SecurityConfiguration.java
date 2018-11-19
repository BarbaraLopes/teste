package com.example.medicamento.api.security;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
@EnableResourceServer
public class SecurityConfiguration extends ResourceServerConfigurerAdapter {

    private final static String resourceId = "resources";

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
           .antMatchers("/tipos").permitAll()
           .antMatchers("/status").permitAll()
           .antMatchers(HttpMethod.GET, "/medicamentos").access("hasRole('ADMIN')")
           .antMatchers("/solicitacao").access("hasRole('USER')")
           .antMatchers(HttpMethod.POST, "/medicamentos").access("hasRole('ADMIN')")
           .antMatchers(HttpMethod.PUT, "/medicamentos").access("hasRole('ADMIN')")
           .antMatchers("/estoque").access("hasRole('ADMIN')")
           .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources){
        resources.resourceId(resourceId);
    }
}