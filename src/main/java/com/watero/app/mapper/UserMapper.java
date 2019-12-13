package com.watero.app.mapper;

import com.watero.app.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User findUserById(Long id);

    List<User> findAll(User user);

    int insertUserWithAutoKey(User user);


    int updateById(User user);

    int deleteUserById(Long id);
}
