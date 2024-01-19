package com.lipe.copilote.repository;

// class for implementing user details interface for spring security


import com.lipe.copilote.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
