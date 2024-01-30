package com.lipe.copilote.config;

// file contains the security configuration for the application base on in memory authentication

// import the following classes from the spring security framework

import com.lipe.copilote.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

// class extends the WebSecurityConfigurerAdapter class
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

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
        // jwt authentication for all urls except "/auth" with filter JtRequestFilter
        http.csrf().disable().authorizeRequests().antMatchers("/auth").permitAll().anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


    // method configures the authentication manager
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // use jdbc authentication using the datasource h2 with default schema
//        auth.jdbcAuthentication()
//            .dataSource(dataSource);
//                .withDefaultSchema();
//
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // use jdbc authentication using the datasource mysql
//        auth.jdbcAuthentication().
//        dataSource(dataSource).usersByUsernameQuery("select username, password, enabled"
//                + " from users where username=?")
//                .authoritiesByUsernameQuery("select username, authority "
//                        + "from authorities where username=?");
//
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // use jdbc authentication using userdetails service helloUserDetailService
        auth.userDetailsService(userDetailsService);
    }

    // @bean for authentication manager
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
