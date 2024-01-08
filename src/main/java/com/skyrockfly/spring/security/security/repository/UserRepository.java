package com.skyrockfly.spring.security.security.repository;

import com.skyrockfly.spring.security.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
