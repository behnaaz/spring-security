package com.example.demo;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class AuthenticationManagerConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder amb) throws Exception {
        amb.inMemoryAuthentication()
                .withUser("abc")
                .password("123")
                .roles("USER")
                    .and()
                .withUser("salam")
                .password("123")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity hs) throws Exception {
        hs.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }
}
