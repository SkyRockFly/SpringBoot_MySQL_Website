package com.skyrockfly.spring.security.security.repository;

import com.skyrockfly.spring.security.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
