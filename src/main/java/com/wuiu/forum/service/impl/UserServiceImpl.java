package com.wuiu.forum.service.impl;

import com.wuiu.forum.mapper.UserMapper;
import com.wuiu.forum.model.User;
import com.wuiu.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer save(User user) {
        Integer num = userMapper.save(user);
        return num;
    }

    @Override
    public User queryByToken(String token) {
        User user = userMapper.queryByToken(token);
        return user;
    }
}
