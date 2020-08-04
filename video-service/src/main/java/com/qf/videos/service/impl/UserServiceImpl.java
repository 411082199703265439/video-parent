package com.qf.videos.service.impl;

import com.qf.videos.mapper.UserMapper;
import com.qf.videos.pojo.User;
import com.qf.videos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUserByEmailAndPassword(User user) {
        return userMapper.selectUserByEmailAndPassword(user);
    }

    @Override
    public User selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }

    @Override
    public Boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
