package com.lipe.copilote.config;

// file contains the security configuration for the application base on in memory authentication

// import the following classes from the spring security framework

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

// class extends the WebSecurityConfigurerAdapter class
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    // no op password encoder
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    // configure the http security
    // "/" , static/css/** , static/js/** , static/images/** , static/favicon.ico root url is accessible to all users
    // "/user" url is accessible to only users with role "USER" and "ADMIN" role
    // "/all" url is accessible to all users
    // "/admin" url is accessible to only users with role "ADMIN"

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "/static/css/**", "/static/js/**", "/static/images/**", "/static/favicon.ico").permitAll()
            .antMatchers("/user").hasAnyRole("USER", "ADMIN")
            .antMatchers("/all").permitAll()
                .antMatchers("/h2-console").permitAll()
            .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
            .and().formLogin();
    }


    // method configures the authentication manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // use jdbc authentication using the datasource h2 with default schema
        auth.jdbcAuthentication()
            .dataSource(dataSource);
//                .withDefaultSchema();

    }
}
