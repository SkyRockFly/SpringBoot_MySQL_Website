package com.skyrockfly.spring.security.security.service;

import com.skyrockfly.spring.security.security.dto.UserDto;
import com.skyrockfly.spring.security.security.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
