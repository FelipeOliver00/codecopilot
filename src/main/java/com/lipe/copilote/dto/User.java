package com.lipe.copilote.dto;

// user class for implementing user details interface for spring security

import javax.persistence.*;

// create table users(id int primary key auto_increment, username varchar(45), password varchar(45), enabled boolean, roles varchar(45));

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private boolean enabled;

    // roles field
    private String roles;

    // getters and setters for roles

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

   // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // getters and setters for username and password

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // getters and setters for enabled

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}