package com.lipe.copilote.service;

// class for user detail service for spring security to find user by username and return details

import com.lipe.copilote.dto.User;
import com.lipe.copilote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // find user by username
        User user = userRepository.findByUsername(username);

        // if user not found
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // retur the user details
        // get the command separeted roles from the database and convert it ot a list of GrantedAuthority
        List<GrantedAuthority> roles = new ArrayList<>();
        for (String role : user.getRoles().split(",")) {
            roles.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return role;
                }
            });
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
}
