package com.watero.app.service.impl;

import com.watero.app.entity.User;
import com.watero.app.mapper.UserMapper;
import com.watero.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<User> findAll(User user) {
        return userMapper.findAll(user);
    }

    @Transactional
    @Override
    public int insert(User user) {
        return userMapper.insertUserWithAutoKey(user);
    }

    @Override
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteUserById(Long id) {
        return userMapper.deleteUserById(id);
    }
}
