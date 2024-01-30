package com.lipe.copilote.controller;

import com.lipe.copilote.config.JwtConfig;
import com.lipe.copilote.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtConfig jwtConfig;

    @GetMapping("/")
    public String getHello() {
        return "Hello to Spring security";
    }

    @GetMapping("/user")
    public String getUser() {
        return "Hello to Spring security user";
    }

    // "/admin" url is accessible to only users with role "ADMIN"
    @GetMapping("/admin")
    public String getAdmin() {
        return "Hello to Spring security admin";
    }

    // "/all" url is accessible to all users
    @GetMapping("/all")
    public String getAll() {
        return "Hello to Spring security all";
    }

    // post method for ./auth endpoint to authenticate user and return jwt token

    @PostMapping("/auth")
    public String generateToken(@RequestBody UserRequest userRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
        } catch (Exception e) {
            // return invalid username/passord exception auth status code 401
            throw new Exception("Invalid username/password");
        }

        return jwtConfig.generateToken(userRequest.getUsername());

    }
}
