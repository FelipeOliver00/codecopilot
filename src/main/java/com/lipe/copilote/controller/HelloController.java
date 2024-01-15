package com.lipe.copilote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


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
}
