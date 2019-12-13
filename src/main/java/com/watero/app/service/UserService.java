package com.watero.app.service;

import com.watero.app.entity.User;

import java.util.List;


public interface UserService {
    User findUserById(Long id);

    List<User> findAll(User user);

    int insert(User user);

    int updateById(User user);

    int deleteUserById(Long id);
}

